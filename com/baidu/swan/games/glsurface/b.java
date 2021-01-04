package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b ejW;
    private Queue<DuMixGameSurfaceView> ejX = new ArrayDeque();

    public static b baF() {
        if (ejW == null) {
            synchronized (b.class) {
                if (ejW == null) {
                    ejW = new b();
                }
            }
        }
        return ejW;
    }

    public DuMixGameSurfaceView eC(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
