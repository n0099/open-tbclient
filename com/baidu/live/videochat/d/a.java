package com.baidu.live.videochat.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.x;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public interface a {
    View Pp();

    int Vh();

    void XL();

    void XM();

    void YH();

    com.baidu.live.alablmsdk.module.c YI();

    JSONObject YJ();

    String YK();

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    void aj(JSONObject jSONObject);

    void ak(JSONObject jSONObject);

    boolean b(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void dv(boolean z);

    void init(Context context);

    void onDestroy();

    void setMute(boolean z);

    void t(x xVar);
}
