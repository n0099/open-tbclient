package com.baidu.swan.games.glsurface;

import android.content.Context;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b eiS;
    private Queue<DuMixGameSurfaceView> eiT = new ArrayDeque();

    public static b aXb() {
        if (eiS == null) {
            synchronized (b.class) {
                if (eiS == null) {
                    eiS = new b();
                }
            }
        }
        return eiS;
    }

    public DuMixGameSurfaceView ez(Context context) {
        return new DuMixGameSurfaceView(context);
    }
}
