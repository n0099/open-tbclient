package com.baidu.swan.apps.adaptation.a;

import android.content.Context;
/* loaded from: classes7.dex */
public interface ar {
    void a(com.baidu.swan.apps.media.c.c cVar, Context context);

    void a(com.baidu.swan.apps.media.c.c cVar, boolean z);

    ar ahk();

    boolean isPlaying();

    boolean onBackPressed();

    void onBackground();

    void onForeground();

    void pause();

    void resume();

    void stop();
}
