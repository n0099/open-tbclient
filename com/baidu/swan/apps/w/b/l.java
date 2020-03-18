package com.baidu.swan.apps.w.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
/* loaded from: classes11.dex */
public interface l {

    /* loaded from: classes11.dex */
    public interface a {
        void b(l lVar);
    }

    /* loaded from: classes11.dex */
    public interface b {
        boolean a(l lVar, int i, int i2);
    }

    /* loaded from: classes11.dex */
    public interface c {
    }

    /* loaded from: classes11.dex */
    public interface d {
        void a(l lVar);
    }

    /* loaded from: classes11.dex */
    public interface e {
    }

    /* loaded from: classes11.dex */
    public interface f {
    }

    void HS();

    void HU();

    void Vo();

    l a(Context context, @NonNull com.baidu.swan.apps.media.c.c cVar);

    void a(com.baidu.swan.apps.media.c.c cVar);

    void a(com.baidu.swan.apps.media.c.c cVar, boolean z);

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void a(d dVar);

    void a(e eVar);

    void a(f fVar);

    void b(FrameLayout frameLayout);

    void b(com.baidu.swan.apps.media.c.c cVar);

    void cK(boolean z);

    void cL(boolean z);

    void f(boolean z, int i);

    int getCurrentPosition();

    int getDuration();

    void ii(String str);

    boolean isEnd();

    boolean isPlaying();

    boolean onBackPressed();

    void pause();

    void resume();

    void seekTo(int i);

    void stop();
}
