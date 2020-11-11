package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dVJ;
    private Queue<DuMixGameSurfaceView> dVK = new ArrayDeque();

    public static b aVO() {
        if (dVJ == null) {
            synchronized (b.class) {
                if (dVJ == null) {
                    dVJ = new b();
                }
            }
        }
        return dVJ;
    }

    public DuMixGameSurfaceView dD(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
