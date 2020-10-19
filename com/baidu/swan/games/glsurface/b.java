package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dHu;
    private Queue<DuMixGameSurfaceView> dHv = new ArrayDeque();

    public static b aRu() {
        if (dHu == null) {
            synchronized (b.class) {
                if (dHu == null) {
                    dHu = new b();
                }
            }
        }
        return dHu;
    }

    public DuMixGameSurfaceView dD(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
