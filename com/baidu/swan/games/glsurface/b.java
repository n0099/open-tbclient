package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b coO;
    private Queue<DuMixGameSurfaceView> coP = new ArrayDeque();

    public static b aow() {
        if (coO == null) {
            synchronized (b.class) {
                if (coO == null) {
                    coO = new b();
                }
            }
        }
        return coO;
    }

    public DuMixGameSurfaceView dw(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
