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
public class a implements com.baidu.live.videochat.c.a {
    private com.baidu.live.q.b buC;
    private AlaLiveRecorder buD;
    private Context mContext;
    private int buE = 2;
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
            a.this.buE = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.buC != null) {
                a.this.buC.dH(1);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.q.b bVar) {
        this.buC = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        Qy();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.d.a.a(this.buD, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void Qs() {
        if (this.buD != null) {
            this.buD.stopRecord();
            this.buD.release();
            this.buD = null;
        }
    }

    public boolean Qt() {
        return this.buD != null;
    }

    public View Qu() {
        if (this.buD != null) {
            return this.buD.getPreview();
        }
        return null;
    }

    public View Qv() {
        if (this.buD != null) {
            return this.buD.createPKPlayer();
        }
        return null;
    }

    public void Qw() {
        if (this.buD != null && !UtilHelper.isAppForeground()) {
            this.buD.stopRecord();
        }
    }

    public void Qx() {
        if (this.buD != null) {
            this.buD.startRecord();
        }
    }

    private void Qy() {
        if (this.buD == null) {
            this.buD = new AlaLiveRecorder(this.mContext, LiveRecorderConfigHelper.Nk().d(4, 1, false), VideoRecorderType.CAMERA, VideoBeautyType.BEAUTY_NONE);
            this.buD.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.c.a
    public int Cj() {
        if (this.buD != null) {
            return this.buD.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.c.a
    public int Qg() {
        return this.buE;
    }
}
