package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b cYI;
    private Queue<DuMixGameSurfaceView> cYJ = new ArrayDeque();

    public static b aAy() {
        if (cYI == null) {
            synchronized (b.class) {
                if (cYI == null) {
                    cYI = new b();
                }
            }
        }
        return cYI;
    }

    public DuMixGameSurfaceView dn(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
