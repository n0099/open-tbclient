package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bBh;
    private Queue<DuMixGameSurfaceView> bBi = new ArrayDeque();

    public static a Xe() {
        if (bBh == null) {
            synchronized (a.class) {
                if (bBh == null) {
                    bBh = new a();
                }
            }
        }
        return bBh;
    }

    public DuMixGameSurfaceView bZ(Context context) {
        if (this.bBi.isEmpty()) {
            if (DEBUG) {
                Log.d("SwanGameSurfaceView", "obtainSurfaceView crateNew.");
            }
            return ca(context);
        }
        if (DEBUG) {
            Log.d("SwanGameSurfaceView", "obtainSurfaceView take from pool.");
        }
        return this.bBi.remove();
    }

    public void f(DuMixGameSurfaceView duMixGameSurfaceView) {
        if (!this.bBi.contains(duMixGameSurfaceView)) {
            this.bBi.add(duMixGameSurfaceView);
        }
    }

    public DuMixGameSurfaceView ca(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
