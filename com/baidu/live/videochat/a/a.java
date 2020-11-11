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
    private com.baidu.live.s.b bHH;
    private AlaLiveRecorder bxq;
    private Context mContext;
    private int bHI = 2;
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
            a.this.bHI = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.bHH != null) {
                a.this.bHH.dM(1);
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
        this.bHH = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        RU();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.g.a.a(this.bxq, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void Vw() {
        if (this.bxq != null) {
            this.bxq.stopRecord();
            this.bxq.release();
            this.bxq = null;
        }
    }

    public boolean Vx() {
        return this.bxq != null;
    }

    public View Vy() {
        if (this.bxq != null) {
            return this.bxq.getPreview();
        }
        return null;
    }

    public View Vz() {
        if (this.bxq != null) {
            return this.bxq.createPKPlayer();
        }
        return null;
    }

    public void VA() {
        if (this.bxq != null && !UtilHelper.isAppForeground()) {
            this.bxq.stopRecord();
        }
    }

    public void VB() {
        if (this.bxq != null) {
            this.bxq.startRecord();
        }
    }

    private void RU() {
        if (this.bxq == null) {
            this.bxq = new AlaLiveRecorder(this.mContext, LiveRecorderConfigHelper.Pn().d(4, 1, false), VideoRecorderType.CAMERA, VideoBeautyType.BEAUTY_NONE);
            this.bxq.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.e.a
    public int DG() {
        if (this.bxq != null) {
            return this.bxq.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.e.a
    public int Vk() {
        return this.bHI;
    }
}
