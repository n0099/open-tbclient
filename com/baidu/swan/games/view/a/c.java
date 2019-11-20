package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.w.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class c {
    private static final ReentrantLock bDX = new ReentrantLock();
    private static ArrayList<a> bEh = new ArrayList<>();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        com.baidu.swan.games.view.b LG = e.LE().LG();
        return LG != null && LG.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        com.baidu.swan.games.view.b LG = e.LE().LG();
        return LG != null && LG.b(view, bVar);
    }

    public static boolean at(View view) {
        com.baidu.swan.games.view.b LG = e.LE().LG();
        return LG != null && LG.at(view);
    }

    public static boolean az(View view) {
        com.baidu.swan.games.view.b LG = e.LE().LG();
        return LG != null && LG.ay(view);
    }

    public static boolean isLandScape() {
        com.baidu.swan.games.view.b LG = e.LE().LG();
        return LG != null && LG.isLandScape();
    }

    public static int Yu() {
        return ((Integer) e.LE().Lt().first).intValue();
    }

    public static int Yv() {
        return ((Integer) e.LE().Lt().second).intValue();
    }

    public static void a(a aVar) {
        bDX.lock();
        if (aVar != null) {
            try {
                if (!bEh.contains(aVar)) {
                    bEh.add(aVar);
                }
            } finally {
                bDX.unlock();
            }
        }
    }

    public static void b(a aVar) {
        bDX.lock();
        if (aVar != null) {
            try {
                bEh.remove(aVar);
            } finally {
                bDX.unlock();
            }
        }
    }

    public static void Yw() {
        if (!bEh.isEmpty()) {
            Iterator<a> it = bEh.iterator();
            while (it.hasNext()) {
                it.next().VE();
            }
        }
    }

    public static void Yx() {
        if (!bEh.isEmpty()) {
            Iterator<a> it = bEh.iterator();
            while (it.hasNext()) {
                it.next().VF();
            }
        }
    }
}
