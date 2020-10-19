package com.baidu.live.videochat.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.u;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface a {
    int Sa();

    void Sh();

    com.baidu.live.alablmsdk.module.c Si();

    JSONObject Sj();

    void Y(JSONObject jSONObject);

    void Z(JSONObject jSONObject);

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    boolean b(com.baidu.live.alablmsdk.module.c cVar, String str);

    void cP(boolean z);

    View getPlayerView();

    void init(Context context);

    void onDestroy();

    void s(u uVar);

    void setMute(boolean z);
}
