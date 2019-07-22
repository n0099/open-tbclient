package com.baidu.swan.games.c.a;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends com.baidu.b.a.a.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private File bfU;
    private com.baidu.swan.games.c.b bfV;

    public a(@NonNull File file, @NonNull com.baidu.swan.games.c.b bVar) {
        super("48", "game_core", "swan-game-sconsole");
        this.bfU = file;
        this.bfV = bVar;
    }

    public static void Rn() {
        com.baidu.b.a.c.a.N("48", "swan-game-sconsole");
    }
}
