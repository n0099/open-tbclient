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
/* loaded from: classes7.dex */
public class a implements com.baidu.live.videochat.c.a {
    private com.baidu.live.p.b brk;
    private AlaLiveRecorder brl;
    private Context mContext;
    private int brm = 2;
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
            a.this.brm = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.brk != null) {
                a.this.brk.dD(1);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.p.b bVar) {
        this.brk = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        PQ();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.d.a.a(this.brl, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void PK() {
        if (this.brl != null) {
            this.brl.stopRecord();
            this.brl.release();
            this.brl = null;
        }
    }

    public boolean PL() {
        return this.brl != null;
    }

    public View PM() {
        if (this.brl != null) {
            return this.brl.getPreview();
        }
        return null;
    }

    public View PN() {
        if (this.brl != null) {
            return this.brl.createPKPlayer();
        }
        return null;
    }

    public void PO() {
        if (this.brl != null && !UtilHelper.isAppForeground()) {
            this.brl.stopRecord();
        }
    }

    public void PP() {
        if (this.brl != null) {
            this.brl.startRecord();
        }
    }

    private void PQ() {
        if (this.brl == null) {
            this.brl = new AlaLiveRecorder(this.mContext, LiveRecorderConfigHelper.MC().d(4, 1, false), VideoRecorderType.CAMERA, VideoBeautyType.BEAUTY_NONE);
            this.brl.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.c.a
    public int BU() {
        if (this.brl != null) {
            return this.brl.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.c.a
    public int Py() {
        return this.brm;
    }
}
