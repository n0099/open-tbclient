package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b djg;
    private Queue<DuMixGameSurfaceView> djh = new ArrayDeque();

    public static b aFl() {
        if (djg == null) {
            synchronized (b.class) {
                if (djg == null) {
                    djg = new b();
                }
            }
        }
        return djg;
    }

    public DuMixGameSurfaceView ds(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
