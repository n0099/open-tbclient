package com.baidu.live.liveroom.e;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public interface d {
    View Pp();

    void b(int i, Map<String, String> map);

    void b(int i, JSONObject jSONObject);

    void d(Context context, Uri uri);

    void e(Uri uri);

    void fh(int i);

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
