package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b eaZ;
    private Queue<DuMixGameSurfaceView> eba = new ArrayDeque();

    public static b aYl() {
        if (eaZ == null) {
            synchronized (b.class) {
                if (eaZ == null) {
                    eaZ = new b();
                }
            }
        }
        return eaZ;
    }

    public DuMixGameSurfaceView ej(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
