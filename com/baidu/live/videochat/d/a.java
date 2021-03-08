package com.baidu.live.videochat.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.ab;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public interface a {
    View MV();

    int SY();

    void VD();

    void VE();

    void WA();

    com.baidu.live.alablmsdk.module.c WB();

    JSONObject WC();

    String WD();

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    void an(JSONObject jSONObject);

    void ao(JSONObject jSONObject);

    boolean b(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void dz(boolean z);

    void init(Context context);

    void onDestroy();

    void setMute(boolean z);

    void t(ab abVar);
}
