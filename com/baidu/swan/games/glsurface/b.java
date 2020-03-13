package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b coD;
    private Queue<DuMixGameSurfaceView> coE = new ArrayDeque();

    public static b aot() {
        if (coD == null) {
            synchronized (b.class) {
                if (coD == null) {
                    coD = new b();
                }
            }
        }
        return coD;
    }

    public DuMixGameSurfaceView dx(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
