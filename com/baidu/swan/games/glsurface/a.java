package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bcY;
    private Queue<DuMixGameSurfaceView> bcZ = new ArrayDeque();

    public static a Oq() {
        if (bcY == null) {
            synchronized (a.class) {
                if (bcY == null) {
                    bcY = new a();
                }
            }
        }
        return bcY;
    }

    public DuMixGameSurfaceView cw(Context context) {
        if (this.bcZ.isEmpty()) {
            if (DEBUG) {
                Log.d("SwanGameSurfaceView", "obtainSurfaceView crateNew.");
            }
            return cx(context);
        }
        if (DEBUG) {
            Log.d("SwanGameSurfaceView", "obtainSurfaceView take from pool.");
        }
        return this.bcZ.remove();
    }

    public void f(DuMixGameSurfaceView duMixGameSurfaceView) {
        if (!this.bcZ.contains(duMixGameSurfaceView)) {
            this.bcZ.add(duMixGameSurfaceView);
        }
    }

    public DuMixGameSurfaceView cx(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
