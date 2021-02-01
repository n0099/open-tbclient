package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b ehr;
    private Queue<DuMixGameSurfaceView> ehs = new ArrayDeque();

    public static b aWY() {
        if (ehr == null) {
            synchronized (b.class) {
                if (ehr == null) {
                    ehr = new b();
                }
            }
        }
        return ehr;
    }

    public DuMixGameSurfaceView eA(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
