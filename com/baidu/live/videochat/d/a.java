package com.baidu.live.videochat.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.w;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface a {
    int RE();

    void Va();

    com.baidu.live.alablmsdk.module.c Vb();

    JSONObject Vc();

    void Z(JSONObject jSONObject);

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    void aa(JSONObject jSONObject);

    boolean b(com.baidu.live.alablmsdk.module.c cVar, JSONObject jSONObject);

    void de(boolean z);

    View getPlayerView();

    void init(Context context);

    void onDestroy();

    void s(w wVar);

    void setMute(boolean z);
}
