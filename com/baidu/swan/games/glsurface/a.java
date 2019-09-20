package com.baidu.swan.games.glsurface;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.b;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a bit;
    private Queue<DuMixGameSurfaceView> biu = new ArrayDeque();

    public static a Sn() {
        if (bit == null) {
            synchronized (a.class) {
                if (bit == null) {
                    bit = new a();
                }
            }
        }
        return bit;
    }

    public DuMixGameSurfaceView bZ(Context context) {
        if (this.biu.isEmpty()) {
            if (DEBUG) {
                Log.d("SwanGameSurfaceView", "obtainSurfaceView crateNew.");
            }
            return ca(context);
        }
        if (DEBUG) {
            Log.d("SwanGameSurfaceView", "obtainSurfaceView take from pool.");
        }
        return this.biu.remove();
    }

    public void f(DuMixGameSurfaceView duMixGameSurfaceView) {
        if (!this.biu.contains(duMixGameSurfaceView)) {
            this.biu.add(duMixGameSurfaceView);
        }
    }

    public DuMixGameSurfaceView ca(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
