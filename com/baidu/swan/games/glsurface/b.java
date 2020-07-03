package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b ddw;
    private Queue<DuMixGameSurfaceView> ddx = new ArrayDeque();

    public static b aBE() {
        if (ddw == null) {
            synchronized (b.class) {
                if (ddw == null) {
                    ddw = new b();
                }
            }
        }
        return ddw;
    }

    /* renamed from: do  reason: not valid java name */
    public DuMixGameSurfaceView m28do(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
