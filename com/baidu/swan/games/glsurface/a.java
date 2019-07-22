package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bhT;
    private Queue<DuMixGameSurfaceView> bhU = new ArrayDeque();

    public static a Sj() {
        if (bhT == null) {
            synchronized (a.class) {
                if (bhT == null) {
                    bhT = new a();
                }
            }
        }
        return bhT;
    }

    public DuMixGameSurfaceView bZ(Context context) {
        if (this.bhU.isEmpty()) {
            if (DEBUG) {
                Log.d("SwanGameSurfaceView", "obtainSurfaceView crateNew.");
            }
            return ca(context);
        }
        if (DEBUG) {
            Log.d("SwanGameSurfaceView", "obtainSurfaceView take from pool.");
        }
        return this.bhU.remove();
    }

    public void f(DuMixGameSurfaceView duMixGameSurfaceView) {
        if (!this.bhU.contains(duMixGameSurfaceView)) {
            this.bhU.add(duMixGameSurfaceView);
        }
    }

    public DuMixGameSurfaceView ca(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
