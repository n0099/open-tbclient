package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dvt;
    private Queue<DuMixGameSurfaceView> dvu = new ArrayDeque();

    public static b aOL() {
        if (dvt == null) {
            synchronized (b.class) {
                if (dvt == null) {
                    dvt = new b();
                }
            }
        }
        return dvt;
    }

    public DuMixGameSurfaceView dx(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
