package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cNQ;
    private Queue<DuMixGameSurfaceView> cNR = new ArrayDeque();

    public static b awJ() {
        if (cNQ == null) {
            synchronized (b.class) {
                if (cNQ == null) {
                    cNQ = new b();
                }
            }
        }
        return cNQ;
    }

    public DuMixGameSurfaceView cY(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
