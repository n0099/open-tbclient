package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dPR;
    private Queue<DuMixGameSurfaceView> dPS = new ArrayDeque();

    public static b aTo() {
        if (dPR == null) {
            synchronized (b.class) {
                if (dPR == null) {
                    dPR = new b();
                }
            }
        }
        return dPR;
    }

    public DuMixGameSurfaceView dD(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
