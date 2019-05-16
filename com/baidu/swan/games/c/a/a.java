package com.baidu.swan.games.c.a;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends com.baidu.b.a.a.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private File bfi;
    private com.baidu.swan.games.c.b bfj;

    public a(@NonNull File file, @NonNull com.baidu.swan.games.c.b bVar) {
        super("48", "game_core", "swan-game-sconsole");
        this.bfi = file;
        this.bfj = bVar;
    }

    public static void Qu() {
        com.baidu.b.a.c.a.N("48", "swan-game-sconsole");
    }
}
