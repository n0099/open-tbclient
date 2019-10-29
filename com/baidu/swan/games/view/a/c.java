package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.w.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class c {
    private static final ReentrantLock bEO = new ReentrantLock();
    private static ArrayList<a> bEY = new ArrayList<>();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        com.baidu.swan.games.view.b LF = e.LD().LF();
        return LF != null && LF.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        com.baidu.swan.games.view.b LF = e.LD().LF();
        return LF != null && LF.b(view, bVar);
    }

    public static boolean at(View view) {
        com.baidu.swan.games.view.b LF = e.LD().LF();
        return LF != null && LF.at(view);
    }

    public static boolean az(View view) {
        com.baidu.swan.games.view.b LF = e.LD().LF();
        return LF != null && LF.ay(view);
    }

    public static boolean isLandScape() {
        com.baidu.swan.games.view.b LF = e.LD().LF();
        return LF != null && LF.isLandScape();
    }

    public static int Yw() {
        return ((Integer) e.LD().Ls().first).intValue();
    }

    public static int Yx() {
        return ((Integer) e.LD().Ls().second).intValue();
    }

    public static void a(a aVar) {
        bEO.lock();
        if (aVar != null) {
            try {
                if (!bEY.contains(aVar)) {
                    bEY.add(aVar);
                }
            } finally {
                bEO.unlock();
            }
        }
    }

    public static void b(a aVar) {
        bEO.lock();
        if (aVar != null) {
            try {
                bEY.remove(aVar);
            } finally {
                bEO.unlock();
            }
        }
    }

    public static void Yy() {
        if (!bEY.isEmpty()) {
            Iterator<a> it = bEY.iterator();
            while (it.hasNext()) {
                it.next().VG();
            }
        }
    }

    public static void Yz() {
        if (!bEY.isEmpty()) {
            Iterator<a> it = bEY.iterator();
            while (it.hasNext()) {
                it.next().VH();
            }
        }
    }
}
