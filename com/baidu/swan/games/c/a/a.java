package com.baidu.swan.games.c.a;

import android.support.annotation.NonNull;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends com.baidu.a.a.a.a.a.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = a.class.getSimpleName();
    private File bzl;
    private com.baidu.swan.games.c.b bzm;

    public a(@NonNull File file, @NonNull com.baidu.swan.games.c.b bVar) {
        super("48", "game_core", "swan-game-sconsole");
        this.bzl = file;
        this.bzm = bVar;
    }

    public static void Wi() {
        com.baidu.a.a.c.a.F("48", "swan-game-sconsole");
    }
}
