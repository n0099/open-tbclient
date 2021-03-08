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
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.baidu.live.videochat.e.a {
    private AlaLiveRecorder bFW;
    private com.baidu.live.u.b bQp;
    private Context mContext;
    private int bQq = 2;
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.a.a.1
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            BdLog.d("video chat rtc error=" + i + "|msg=" + str);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            a.this.bQq = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.bQp != null) {
                a.this.bQp.cw(1);
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
        this.bQp = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        SG();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.g.a.a(this.bFW, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void Wp() {
        if (this.bFW != null) {
            this.bFW.stopRecord();
            this.bFW.release();
            this.bFW = null;
        }
    }

    public boolean Wq() {
        return this.bFW != null;
    }

    public View Wr() {
        if (this.bFW != null) {
            return this.bFW.getPreview();
        }
        return null;
    }

    public View Ws() {
        if (this.bFW != null) {
            return this.bFW.createPKPlayer();
        }
        return null;
    }

    public void VD() {
        if (this.bFW != null && !UtilHelper.isAppForeground()) {
            this.bFW.stopRecord();
        }
    }

    public void VE() {
        if (this.bFW != null) {
            this.bFW.startRecord();
        }
    }

    private void SG() {
        if (this.bFW == null) {
            this.bFW = new AlaLiveRecorder(this.mContext, com.baidu.live.z.a.b.PI().d(4, 1, false), VideoRecorderType.CAMERA, new com.baidu.live.z.a.a(), VideoBeautyType.BEAUTY_NONE);
            this.bFW.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.e.a
    public int AO() {
        if (this.bFW != null) {
            return this.bFW.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.e.a
    public int Wd() {
        return this.bQq;
    }
}
