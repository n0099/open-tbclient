package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.w.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class c {
    private static final ReentrantLock blD = new ReentrantLock();
    private static ArrayList<a> blN = new ArrayList<>();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        com.baidu.swan.games.view.b GH = e.GF().GH();
        return GH != null && GH.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        com.baidu.swan.games.view.b GH = e.GF().GH();
        return GH != null && GH.b(view, bVar);
    }

    public static boolean an(View view) {
        com.baidu.swan.games.view.b GH = e.GF().GH();
        return GH != null && GH.an(view);
    }

    public static boolean at(View view) {
        com.baidu.swan.games.view.b GH = e.GF().GH();
        return GH != null && GH.as(view);
    }

    public static boolean isLandScape() {
        com.baidu.swan.games.view.b GH = e.GF().GH();
        return GH != null && GH.isLandScape();
    }

    public static int TB() {
        return ((Integer) e.GF().Gu().first).intValue();
    }

    public static int TC() {
        return ((Integer) e.GF().Gu().second).intValue();
    }

    public static void a(a aVar) {
        blD.lock();
        if (aVar != null) {
            try {
                if (!blN.contains(aVar)) {
                    blN.add(aVar);
                }
            } finally {
                blD.unlock();
            }
        }
    }

    public static void b(a aVar) {
        blD.lock();
        if (aVar != null) {
            try {
                blN.remove(aVar);
            } finally {
                blD.unlock();
            }
        }
    }

    public static void TD() {
        if (!blN.isEmpty()) {
            Iterator<a> it = blN.iterator();
            while (it.hasNext()) {
                it.next().QM();
            }
        }
    }

    public static void TE() {
        if (!blN.isEmpty()) {
            Iterator<a> it = blN.iterator();
            while (it.hasNext()) {
                it.next().QN();
            }
        }
    }
}
