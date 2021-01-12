package com.baidu.live.videochat.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.x;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public interface a {
    View Lu();

    int Ro();

    void TS();

    void TT();

    void UO();

    com.baidu.live.alablmsdk.module.c UP();

    JSONObject UQ();

    String UR();

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    void aj(JSONObject jSONObject);

    void ak(JSONObject jSONObject);

    boolean b(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void dr(boolean z);

    void init(Context context);

    void onDestroy();

    void setMute(boolean z);

    void t(x xVar);
}
