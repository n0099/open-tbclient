package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dtr;
    private Queue<DuMixGameSurfaceView> dtt = new ArrayDeque();

    public static b aOa() {
        if (dtr == null) {
            synchronized (b.class) {
                if (dtr == null) {
                    dtr = new b();
                }
            }
        }
        return dtr;
    }

    public DuMixGameSurfaceView dy(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
