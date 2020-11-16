package com.baidu.live.videochat.a;

import android.content.Context;
import android.view.View;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.ala.recorder.video.VideoBeautyType;
import com.baidu.ala.recorder.video.VideoRecorderType;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.videochat.e.a {
    private com.baidu.live.s.b bFW;
    private AlaLiveRecorder bvF;
    private Context mContext;
    private int bFX = 2;
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.a.a.1
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            BdLog.d("video chat rtc error=" + i + "|msg=" + str);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            a.this.bFX = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.bFW != null) {
                a.this.bFW.dI(1);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.s.b bVar) {
        this.bFW = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        Rl();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.g.a.a(this.bvF, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void UN() {
        if (this.bvF != null) {
            this.bvF.stopRecord();
            this.bvF.release();
            this.bvF = null;
        }
    }

    public boolean UO() {
        return this.bvF != null;
    }

    public View UP() {
        if (this.bvF != null) {
            return this.bvF.getPreview();
        }
        return null;
    }

    public View UQ() {
        if (this.bvF != null) {
            return this.bvF.createPKPlayer();
        }
        return null;
    }

    public void UR() {
        if (this.bvF != null && !UtilHelper.isAppForeground()) {
            this.bvF.stopRecord();
        }
    }

    public void US() {
        if (this.bvF != null) {
            this.bvF.startRecord();
        }
    }

    private void Rl() {
        if (this.bvF == null) {
            this.bvF = new AlaLiveRecorder(this.mContext, LiveRecorderConfigHelper.OE().d(4, 1, false), VideoRecorderType.CAMERA, VideoBeautyType.BEAUTY_NONE);
            this.bvF.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.e.a
    public int CX() {
        if (this.bvF != null) {
            return this.bvF.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.e.a
    public int UB() {
        return this.bFX;
    }
}
