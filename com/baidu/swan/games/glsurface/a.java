package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.c;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = c.DEBUG;
    private static volatile a bcU;
    private Queue<DuMixGameSurfaceView> bcV = new ArrayDeque();

    public static a Os() {
        if (bcU == null) {
            synchronized (a.class) {
                if (bcU == null) {
                    bcU = new a();
                }
            }
        }
        return bcU;
    }

    public DuMixGameSurfaceView cw(Context context) {
        if (this.bcV.isEmpty()) {
            if (DEBUG) {
                Log.d("SwanGameSurfaceView", "obtainSurfaceView crateNew.");
            }
            return cx(context);
        }
        if (DEBUG) {
            Log.d("SwanGameSurfaceView", "obtainSurfaceView take from pool.");
        }
        return this.bcV.remove();
    }

    public void f(DuMixGameSurfaceView duMixGameSurfaceView) {
        if (!this.bcV.contains(duMixGameSurfaceView)) {
            this.bcV.add(duMixGameSurfaceView);
        }
    }

    public DuMixGameSurfaceView cx(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
