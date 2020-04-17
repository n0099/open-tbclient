package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cNL;
    private Queue<DuMixGameSurfaceView> cNM = new ArrayDeque();

    public static b awJ() {
        if (cNL == null) {
            synchronized (b.class) {
                if (cNL == null) {
                    cNL = new b();
                }
            }
        }
        return cNL;
    }

    public DuMixGameSurfaceView dk(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
