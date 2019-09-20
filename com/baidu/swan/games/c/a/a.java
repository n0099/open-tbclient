package com.baidu.swan.games.c.a;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends com.baidu.b.a.a.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private File bgt;
    private com.baidu.swan.games.c.b bgu;

    public a(@NonNull File file, @NonNull com.baidu.swan.games.c.b bVar) {
        super("48", "game_core", "swan-game-sconsole");
        this.bgt = file;
        this.bgu = bVar;
    }

    public static void Rr() {
        com.baidu.b.a.c.a.N("48", "swan-game-sconsole");
    }
}
