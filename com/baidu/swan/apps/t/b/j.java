package com.baidu.swan.apps.t.b;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public interface j {

    /* loaded from: classes9.dex */
    public interface a {
        void b(j jVar);
    }

    /* loaded from: classes9.dex */
    public interface b {
        boolean a(j jVar, int i, int i2);
    }

    /* loaded from: classes9.dex */
    public interface c {
        void e(j jVar);
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a(j jVar);
    }

    /* loaded from: classes9.dex */
    public interface e {
        void c(j jVar);
    }

    /* loaded from: classes9.dex */
    public interface f {
        void d(j jVar);
    }

    j a(Context context, @NonNull com.baidu.swan.apps.media.b.c cVar);

    void a(com.baidu.swan.apps.media.b.c cVar);

    void a(com.baidu.swan.apps.media.b.c cVar, boolean z);

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void ayD();

    void b(com.baidu.swan.apps.media.b.c cVar);

    void f(FrameLayout frameLayout);

    void fR(boolean z);

    int getCurrentPosition();

    int getDuration();

    void i(boolean z, int i);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    boolean onBackPressed();

    void onBackground();

    void onForeground();

    void oy(String str);

    void pause();

    void resume();

    void seekTo(int i);

    void stop();
}
