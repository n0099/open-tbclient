package com.baidu.live.videochat.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.ab;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public interface a {
    View MS();

    int SV();

    void VA();

    void VB();

    String WA();

    void Wx();

    com.baidu.live.alablmsdk.module.c Wy();

    JSONObject Wz();

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    void al(JSONObject jSONObject);

    void am(JSONObject jSONObject);

    boolean b(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void dz(boolean z);

    void init(Context context);

    void onDestroy();

    void setMute(boolean z);

    void t(ab abVar);
}
