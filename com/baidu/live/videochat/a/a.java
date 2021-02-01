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
/* loaded from: classes11.dex */
public class a implements com.baidu.live.videochat.e.a {
    private AlaLiveRecorder bEw;
    private com.baidu.live.u.b bOP;
    private Context mContext;
    private int bOQ = 2;
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.a.a.1
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            BdLog.d("video chat rtc error=" + i + "|msg=" + str);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            a.this.bOQ = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.bOP != null) {
                a.this.bOP.cv(1);
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
        this.bOP = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        SD();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.g.a.a(this.bEw, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void Wm() {
        if (this.bEw != null) {
            this.bEw.stopRecord();
            this.bEw.release();
            this.bEw = null;
        }
    }

    public boolean Wn() {
        return this.bEw != null;
    }

    public View Wo() {
        if (this.bEw != null) {
            return this.bEw.getPreview();
        }
        return null;
    }

    public View Wp() {
        if (this.bEw != null) {
            return this.bEw.createPKPlayer();
        }
        return null;
    }

    public void VA() {
        if (this.bEw != null && !UtilHelper.isAppForeground()) {
            this.bEw.stopRecord();
        }
    }

    public void VB() {
        if (this.bEw != null) {
            this.bEw.startRecord();
        }
    }

    private void SD() {
        if (this.bEw == null) {
            this.bEw = new AlaLiveRecorder(this.mContext, com.baidu.live.z.a.b.PF().d(4, 1, false), VideoRecorderType.CAMERA, new com.baidu.live.z.a.a(), VideoBeautyType.BEAUTY_NONE);
            this.bEw.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.e.a
    public int AL() {
        if (this.bEw != null) {
            return this.bEw.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.e.a
    public int Wa() {
        return this.bOQ;
    }
}
