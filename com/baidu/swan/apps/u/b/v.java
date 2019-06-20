package com.baidu.swan.apps.u.b;

import android.content.Context;
import android.widget.FrameLayout;
/* loaded from: classes2.dex */
public interface v {

    /* loaded from: classes2.dex */
    public interface a {
        void a(v vVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean a(v vVar, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void b(v vVar);
    }

    void EC();

    void a(com.baidu.swan.apps.media.d.c cVar);

    void a(com.baidu.swan.apps.media.d.c cVar, boolean z);

    void a(a aVar);

    void a(b bVar);

    void a(c cVar);

    void b(FrameLayout frameLayout);

    void b(com.baidu.swan.apps.media.d.c cVar);

    v bg(Context context);

    void bo(boolean z);

    void bp(boolean z);

    void eB(String str);

    int getCurrentPosition();

    int getDuration();

    boolean isEnd();

    boolean isPlaying();

    boolean onBackPressed();

    void pause();

    void resume();

    void seekTo(int i);

    void setFullScreen(boolean z);

    void stop();
}
