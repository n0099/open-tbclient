package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bcV;
    private Queue<DuMixGameSurfaceView> bcW = new ArrayDeque();

    public static a Os() {
        if (bcV == null) {
            synchronized (a.class) {
                if (bcV == null) {
                    bcV = new a();
                }
            }
        }
        return bcV;
    }

    public DuMixGameSurfaceView cw(Context context) {
        if (this.bcW.isEmpty()) {
            if (DEBUG) {
                Log.d("SwanGameSurfaceView", "obtainSurfaceView crateNew.");
            }
            return cx(context);
        }
        if (DEBUG) {
            Log.d("SwanGameSurfaceView", "obtainSurfaceView take from pool.");
        }
        return this.bcW.remove();
    }

    public void f(DuMixGameSurfaceView duMixGameSurfaceView) {
        if (!this.bcW.contains(duMixGameSurfaceView)) {
            this.bcW.add(duMixGameSurfaceView);
        }
    }

    public DuMixGameSurfaceView cx(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
