package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bAq;
    private Queue<DuMixGameSurfaceView> bAr = new ArrayDeque();

    public static a Xc() {
        if (bAq == null) {
            synchronized (a.class) {
                if (bAq == null) {
                    bAq = new a();
                }
            }
        }
        return bAq;
    }

    public DuMixGameSurfaceView bZ(Context context) {
        if (this.bAr.isEmpty()) {
            if (DEBUG) {
                Log.d("SwanGameSurfaceView", "obtainSurfaceView crateNew.");
            }
            return ca(context);
        }
        if (DEBUG) {
            Log.d("SwanGameSurfaceView", "obtainSurfaceView take from pool.");
        }
        return this.bAr.remove();
    }

    public void f(DuMixGameSurfaceView duMixGameSurfaceView) {
        if (!this.bAr.contains(duMixGameSurfaceView)) {
            this.bAr.add(duMixGameSurfaceView);
        }
    }

    public DuMixGameSurfaceView ca(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
