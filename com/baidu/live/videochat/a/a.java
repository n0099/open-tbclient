package com.baidu.live.videochat.a;

import android.content.Context;
import android.view.View;
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
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.videochat.e.a {
    private AlaLiveRecorder bAP;
    private com.baidu.live.u.b bLe;
    private Context mContext;
    private int bLf = 2;
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.a.a.1
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            BdLog.d("video chat rtc error=" + i + "|msg=" + str);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            a.this.bLf = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.bLe != null) {
                a.this.bLe.eb(1);
            }
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onLogReport(String str, JSONObject jSONObject, JSONObject jSONObject2) {
            UbcStatisticManager.getInstance().logRecorderEvent(str, jSONObject, jSONObject2);
        }
    };

    public a(Context context) {
        this.mContext = context;
    }

    public void a(com.baidu.live.u.b bVar) {
        this.bLe = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        TJ();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.g.a.a(this.bAP, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void Xp() {
        if (this.bAP != null) {
            this.bAP.stopRecord();
            this.bAP.release();
            this.bAP = null;
        }
    }

    public boolean Xq() {
        return this.bAP != null;
    }

    public View Xr() {
        if (this.bAP != null) {
            return this.bAP.getPreview();
        }
        return null;
    }

    public View Xs() {
        if (this.bAP != null) {
            return this.bAP.createPKPlayer();
        }
        return null;
    }

    public void WG() {
        if (this.bAP != null && !UtilHelper.isAppForeground()) {
            this.bAP.stopRecord();
        }
    }

    public void WH() {
        if (this.bAP != null) {
            this.bAP.startRecord();
        }
    }

    private void TJ() {
        if (this.bAP == null) {
            this.bAP = new AlaLiveRecorder(this.mContext, LiveRecorderConfigHelper.QY().d(4, 1, false), VideoRecorderType.CAMERA, VideoBeautyType.BEAUTY_NONE);
            this.bAP.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.e.a
    public int EH() {
        if (this.bAP != null) {
            return this.bAP.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.e.a
    public int Xd() {
        return this.bLf;
    }
}
