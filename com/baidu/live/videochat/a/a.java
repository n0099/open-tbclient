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
/* loaded from: classes10.dex */
public class a implements com.baidu.live.videochat.e.a {
    private AlaLiveRecorder bAQ;
    private com.baidu.live.v.b bLf;
    private Context mContext;
    private int bLg = 2;
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.a.a.1
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
            BdLog.d("video chat rtc error=" + i + "|msg=" + str);
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            a.this.bLg = i == 0 ? 1 : 2;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
            if (a.this.bLf != null) {
                a.this.bLf.cs(1);
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
        this.bLf = bVar;
    }

    public boolean a(AlaLiveInfoData alaLiveInfoData, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        QT();
        String str = "";
        if (alaLiveInfoData != null && alaLiveInfoData.session_info != null) {
            str = alaLiveInfoData.session_info.getPushUrl();
        }
        return com.baidu.live.videochat.g.a.a(this.bAQ, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo), str);
    }

    public void UD() {
        if (this.bAQ != null) {
            this.bAQ.stopRecord();
            this.bAQ.release();
            this.bAQ = null;
        }
    }

    public boolean UE() {
        return this.bAQ != null;
    }

    public View UF() {
        if (this.bAQ != null) {
            return this.bAQ.getPreview();
        }
        return null;
    }

    public View UG() {
        if (this.bAQ != null) {
            return this.bAQ.createPKPlayer();
        }
        return null;
    }

    public void TS() {
        if (this.bAQ != null && !UtilHelper.isAppForeground()) {
            this.bAQ.stopRecord();
        }
    }

    public void TT() {
        if (this.bAQ != null) {
            this.bAQ.startRecord();
        }
    }

    private void QT() {
        if (this.bAQ == null) {
            this.bAQ = new AlaLiveRecorder(this.mContext, LiveRecorderConfigHelper.Og().d(4, 1, false), VideoRecorderType.CAMERA, new com.baidu.live.recorder.helper.a(), VideoBeautyType.BEAUTY_NONE);
            this.bAQ.addRecorderCallback(this.mRecorderCallback);
        }
    }

    @Override // com.baidu.live.videochat.e.a
    public int Ab() {
        if (this.bAQ != null) {
            return this.bAQ.getRtcStreamStatus();
        }
        return 0;
    }

    @Override // com.baidu.live.videochat.e.a
    public int Ur() {
        return this.bLg;
    }
}
