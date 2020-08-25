package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dtn;
    private Queue<DuMixGameSurfaceView> dto = new ArrayDeque();

    public static b aOa() {
        if (dtn == null) {
            synchronized (b.class) {
                if (dtn == null) {
                    dtn = new b();
                }
            }
        }
        return dtn;
    }

    public DuMixGameSurfaceView dy(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
