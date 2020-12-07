package com.baidu.live.videochat.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.w;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface a {
    int Uc();

    void WG();

    void WH();

    void XA();

    com.baidu.live.alablmsdk.module.c XB();

    JSONObject XC();

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    void ab(JSONObject jSONObject);

    void ac(JSONObject jSONObject);

    boolean b(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void ds(boolean z);

    View getPlayerView();

    void init(Context context);

    void onDestroy();

    void s(w wVar);

    void setMute(boolean z);
}
