package com.baidu.swan.apps.t.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public interface j {

    /* loaded from: classes3.dex */
    public interface a {
        void b(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean a(j jVar, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void e(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(j jVar);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void c(j jVar);
    }

    /* loaded from: classes3.dex */
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

    void ara();

    void b(FrameLayout frameLayout);

    void b(com.baidu.swan.apps.media.b.c cVar);

    void eA(boolean z);

    int getCurrentPosition();

    int getDuration();

    void i(boolean z, int i);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void nC(String str);

    boolean onBackPressed();

    void onBackground();

    void onForeground();

    void pause();

    void resume();

    void seekTo(int i);

    void stop();
}
