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
/* loaded from: classes3.dex */
public class a implements com.baidu.live.videochat.c.a {
    private com.baidu.live.o.b bgd;
    private AlaLiveRecorder bge;
    private Context mContext;
    private int bgf = 2;
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
            a.this.bgf = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.bgd != null) {
                a.this.bgd.bE(1);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.o.b bVar) {
        this.bgd = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        IE();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.d.a.a(this.bge, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void Iy() {
        if (this.bge != null) {
            this.bge.stopRecord();
            this.bge.release();
            this.bge = null;
        }
    }

    public boolean Iz() {
        return this.bge != null;
    }

    public View IA() {
        if (this.bge != null) {
            return this.bge.getPreview();
        }
        return null;
    }

    public View IB() {
        if (this.bge != null) {
            return this.bge.createPKPlayer();
        }
        return null;
    }

    public void IC() {
        if (this.bge != null && !UtilHelper.isAppForeground()) {
            this.bge.stopRecord();
        }
    }

    public void ID() {
        if (this.bge != null) {
            this.bge.startRecord();
        }
    }

    private void IE() {
        if (this.bge == null) {
            this.bge = new AlaLiveRecorder(this.mContext, LiveRecorderConfigHelper.FX().d(4, 1, false), VideoRecorderType.CAMERA, VideoBeautyType.BEAUTY_NONE);
            this.bge.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.c.a
    public int vG() {
        if (this.bge != null) {
            return this.bge.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.c.a
    public int Im() {
        return this.bgf;
    }
}
