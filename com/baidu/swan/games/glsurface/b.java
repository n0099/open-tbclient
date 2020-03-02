package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b coC;
    private Queue<DuMixGameSurfaceView> coD = new ArrayDeque();

    public static b aot() {
        if (coC == null) {
            synchronized (b.class) {
                if (coC == null) {
                    coC = new b();
                }
            }
        }
        return coC;
    }

    public DuMixGameSurfaceView dx(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
