package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b ckk;
    private Queue<DuMixGameSurfaceView> ckl = new ArrayDeque();

    public static b alL() {
        if (ckk == null) {
            synchronized (b.class) {
                if (ckk == null) {
                    ckk = new b();
                }
            }
        }
        return ckk;
    }

    public DuMixGameSurfaceView dt(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
