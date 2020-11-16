package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dUb;
    private Queue<DuMixGameSurfaceView> dUc = new ArrayDeque();

    public static b aVg() {
        if (dUb == null) {
            synchronized (b.class) {
                if (dUb == null) {
                    dUb = new b();
                }
            }
        }
        return dUb;
    }

    public DuMixGameSurfaceView dD(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
