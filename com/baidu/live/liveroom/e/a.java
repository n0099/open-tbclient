package com.baidu.live.liveroom.e;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface a {
    void a(c cVar);

    void b(int i, Map<String, String> map);

    void b(int i, JSONObject jSONObject);

    void c(Uri uri);

    void cK(int i);

    void d(Context context, Uri uri);

    View getPlayerView();

    void release();

    void setDecodeMode(int i);

    void setVideoScalingMode(int i);

    void start();

    void stop();
}
