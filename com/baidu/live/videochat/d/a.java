package com.baidu.live.videochat.d;

import android.content.Context;
import android.view.View;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.live.data.w;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface a {
    int Ta();

    void Th();

    com.baidu.live.alablmsdk.module.c Ti();

    JSONObject Tj();

    void a(AlaLiveRecorder alaLiveRecorder);

    void a(f fVar);

    void aa(JSONObject jSONObject);

    void ab(JSONObject jSONObject);

    boolean b(com.baidu.live.alablmsdk.module.c cVar, String str);

    void cV(boolean z);

    View getPlayerView();

    void init(Context context);

    void onDestroy();

    void r(w wVar);

    void setMute(boolean z);
}
