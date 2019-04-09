package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bcZ;
    private Queue<DuMixGameSurfaceView> bda = new ArrayDeque();

    public static a Oq() {
        if (bcZ == null) {
            synchronized (a.class) {
                if (bcZ == null) {
                    bcZ = new a();
                }
            }
        }
        return bcZ;
    }

    public DuMixGameSurfaceView cw(Context context) {
        if (this.bda.isEmpty()) {
            if (DEBUG) {
                Log.d("SwanGameSurfaceView", "obtainSurfaceView crateNew.");
            }
            return cx(context);
        }
        if (DEBUG) {
            Log.d("SwanGameSurfaceView", "obtainSurfaceView take from pool.");
        }
        return this.bda.remove();
    }

    public void f(DuMixGameSurfaceView duMixGameSurfaceView) {
        if (!this.bda.contains(duMixGameSurfaceView)) {
            this.bda.add(duMixGameSurfaceView);
        }
    }

    public DuMixGameSurfaceView cx(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
