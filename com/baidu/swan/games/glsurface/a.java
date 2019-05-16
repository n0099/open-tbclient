package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bhg;
    private Queue<DuMixGameSurfaceView> bhh = new ArrayDeque();

    public static a Rq() {
        if (bhg == null) {
            synchronized (a.class) {
                if (bhg == null) {
                    bhg = new a();
                }
            }
        }
        return bhg;
    }

    public DuMixGameSurfaceView bZ(Context context) {
        if (this.bhh.isEmpty()) {
            if (DEBUG) {
                Log.d("SwanGameSurfaceView", "obtainSurfaceView crateNew.");
            }
            return ca(context);
        }
        if (DEBUG) {
            Log.d("SwanGameSurfaceView", "obtainSurfaceView take from pool.");
        }
        return this.bhh.remove();
    }

    public void f(DuMixGameSurfaceView duMixGameSurfaceView) {
        if (!this.bhh.contains(duMixGameSurfaceView)) {
            this.bhh.add(duMixGameSurfaceView);
        }
    }

    public DuMixGameSurfaceView ca(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
