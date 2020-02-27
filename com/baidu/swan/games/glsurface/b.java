package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b coB;
    private Queue<DuMixGameSurfaceView> coC = new ArrayDeque();

    public static b aor() {
        if (coB == null) {
            synchronized (b.class) {
                if (coB == null) {
                    coB = new b();
                }
            }
        }
        return coB;
    }

    public DuMixGameSurfaceView dx(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
