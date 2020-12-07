package com.baidu.live.liveroom.e;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public interface d {
    void b(int i, Map<String, String> map);

    void b(int i, JSONObject jSONObject);

    void c(Uri uri);

    void d(Context context, Uri uri);

    void fj(int i);

    View getPlayerView();

    boolean isPlaying();

    void pause();

    void release();

    void resume();

    void setDecodeMode(int i);

    void setPlayerCallback(f fVar);

    void setVideoScalingMode(int i);

    void start();

    void stop();
}
