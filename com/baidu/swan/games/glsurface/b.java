package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b ckx;
    private Queue<DuMixGameSurfaceView> cky = new ArrayDeque();

    public static b ame() {
        if (ckx == null) {
            synchronized (b.class) {
                if (ckx == null) {
                    ckx = new b();
                }
            }
        }
        return ckx;
    }

    public DuMixGameSurfaceView dt(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
