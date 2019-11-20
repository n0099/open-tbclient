package com.baidu.live.liveroom.d;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public interface a {
    void a(c cVar);

    void b(int i, JSONObject jSONObject);

    void b(Uri uri);

    void bz(int i);

    void d(Context context, Uri uri);

    void pause();

    void release();

    void setDecodeMode(int i);

    void setVideoScalingMode(int i);

    void start();

    void stop();

    View uh();
}
