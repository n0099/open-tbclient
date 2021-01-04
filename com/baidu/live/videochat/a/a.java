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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.videochat.e.a {
    private AlaLiveRecorder bFC;
    private com.baidu.live.v.b bPR;
    private Context mContext;
    private int bPS = 2;
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.a.a.1
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            BdLog.d("video chat rtc error=" + i + "|msg=" + str);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            a.this.bPS = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.bPR != null) {
                a.this.bPR.dY(1);
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

    public void a(com.baidu.live.v.b bVar) {
        this.bPR = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        UO();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.g.a.a(this.bFC, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void Yv() {
        if (this.bFC != null) {
            this.bFC.stopRecord();
            this.bFC.release();
            this.bFC = null;
        }
    }

    public boolean Yw() {
        return this.bFC != null;
    }

    public View Yx() {
        if (this.bFC != null) {
            return this.bFC.getPreview();
        }
        return null;
    }

    public View Yy() {
        if (this.bFC != null) {
            return this.bFC.createPKPlayer();
        }
        return null;
    }

    public void XK() {
        if (this.bFC != null && !UtilHelper.isAppForeground()) {
            this.bFC.stopRecord();
        }
    }

    public void XL() {
        if (this.bFC != null) {
            this.bFC.startRecord();
        }
    }

    private void UO() {
        if (this.bFC == null) {
            this.bFC = new AlaLiveRecorder(this.mContext, LiveRecorderConfigHelper.Sb().d(4, 1, false), VideoRecorderType.CAMERA, new com.baidu.live.recorder.helper.a(), VideoBeautyType.BEAUTY_NONE);
            this.bFC.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.e.a
    public int DW() {
        if (this.bFC != null) {
            return this.bFC.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.e.a
    public int Yj() {
        return this.bPS;
    }
}
