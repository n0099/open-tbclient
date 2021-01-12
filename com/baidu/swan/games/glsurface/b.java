package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b efj;
    private Queue<DuMixGameSurfaceView> efk = new ArrayDeque();

    public static b aWM() {
        if (efj == null) {
            synchronized (b.class) {
                if (efj == null) {
                    efj = new b();
                }
            }
        }
        return efj;
    }

    public DuMixGameSurfaceView eB(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
