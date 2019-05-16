package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.w.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class c {
    private static final ReentrantLock bkQ = new ReentrantLock();
    private static ArrayList<a> bla = new ArrayList<>();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        com.baidu.swan.games.view.b FX = e.FV().FX();
        return FX != null && FX.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        com.baidu.swan.games.view.b FX = e.FV().FX();
        return FX != null && FX.b(view, bVar);
    }

    public static boolean al(View view) {
        com.baidu.swan.games.view.b FX = e.FV().FX();
        return FX != null && FX.al(view);
    }

    public static boolean ar(View view) {
        com.baidu.swan.games.view.b FX = e.FV().FX();
        return FX != null && FX.aq(view);
    }

    public static boolean isLandScape() {
        com.baidu.swan.games.view.b FX = e.FV().FX();
        return FX != null && FX.isLandScape();
    }

    public static int SI() {
        return ((Integer) e.FV().FK().first).intValue();
    }

    public static int SJ() {
        return ((Integer) e.FV().FK().second).intValue();
    }

    public static void a(a aVar) {
        bkQ.lock();
        if (aVar != null) {
            try {
                if (!bla.contains(aVar)) {
                    bla.add(aVar);
                }
            } finally {
                bkQ.unlock();
            }
        }
    }

    public static void b(a aVar) {
        bkQ.lock();
        if (aVar != null) {
            try {
                bla.remove(aVar);
            } finally {
                bkQ.unlock();
            }
        }
    }

    public static void SK() {
        if (!bla.isEmpty()) {
            Iterator<a> it = bla.iterator();
            while (it.hasNext()) {
                it.next().PU();
            }
        }
    }

    public static void SL() {
        if (!bla.isEmpty()) {
            Iterator<a> it = bla.iterator();
            while (it.hasNext()) {
                it.next().PV();
            }
        }
    }
}
