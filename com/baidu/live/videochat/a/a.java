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
    private AlaLiveRecorder bAM;
    private com.baidu.live.r.b bBB;
    private Context mContext;
    private int bBC = 2;
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
            a.this.bBC = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.bBB != null) {
                a.this.bBB.dM(1);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.r.b bVar) {
        this.bBB = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        SV();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.g.a.a(this.bAM, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void SP() {
        if (this.bAM != null) {
            this.bAM.stopRecord();
            this.bAM.release();
            this.bAM = null;
        }
    }

    public boolean SQ() {
        return this.bAM != null;
    }

    public View SR() {
        if (this.bAM != null) {
            return this.bAM.getPreview();
        }
        return null;
    }

    public View SS() {
        if (this.bAM != null) {
            return this.bAM.createPKPlayer();
        }
        return null;
    }

    public void ST() {
        if (this.bAM != null && !UtilHelper.isAppForeground()) {
            this.bAM.stopRecord();
        }
    }

    public void SU() {
        if (this.bAM != null) {
            this.bAM.startRecord();
        }
    }

    private void SV() {
        if (this.bAM == null) {
            this.bAM = new AlaLiveRecorder(this.mContext, LiveRecorderConfigHelper.ON().d(4, 1, false), VideoRecorderType.CAMERA, VideoBeautyType.BEAUTY_NONE);
            this.bAM.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.e.a
    public int Dn() {
        if (this.bAM != null) {
            return this.bAM.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.e.a
    public int SD() {
        return this.bBC;
    }
}
