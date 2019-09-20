package com.baidu.swan.games.view.a;

import android.view.View;
import com.baidu.swan.apps.w.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class c {
    private static final ReentrantLock bmb = new ReentrantLock();
    private static ArrayList<a> bml = new ArrayList<>();

    public static boolean c(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        com.baidu.swan.games.view.b GL = e.GJ().GL();
        return GL != null && GL.a(view, bVar);
    }

    public static boolean b(View view, com.baidu.swan.apps.model.a.a.b bVar) {
        com.baidu.swan.games.view.b GL = e.GJ().GL();
        return GL != null && GL.b(view, bVar);
    }

    public static boolean an(View view) {
        com.baidu.swan.games.view.b GL = e.GJ().GL();
        return GL != null && GL.an(view);
    }

    public static boolean at(View view) {
        com.baidu.swan.games.view.b GL = e.GJ().GL();
        return GL != null && GL.as(view);
    }

    public static boolean isLandScape() {
        com.baidu.swan.games.view.b GL = e.GJ().GL();
        return GL != null && GL.isLandScape();
    }

    public static int TF() {
        return ((Integer) e.GJ().Gy().first).intValue();
    }

    public static int TG() {
        return ((Integer) e.GJ().Gy().second).intValue();
    }

    public static void a(a aVar) {
        bmb.lock();
        if (aVar != null) {
            try {
                if (!bml.contains(aVar)) {
                    bml.add(aVar);
                }
            } finally {
                bmb.unlock();
            }
        }
    }

    public static void b(a aVar) {
        bmb.lock();
        if (aVar != null) {
            try {
                bml.remove(aVar);
            } finally {
                bmb.unlock();
            }
        }
    }

    public static void TH() {
        if (!bml.isEmpty()) {
            Iterator<a> it = bml.iterator();
            while (it.hasNext()) {
                it.next().QQ();
            }
        }
    }

    public static void TI() {
        if (!bml.isEmpty()) {
            Iterator<a> it = bml.iterator();
            while (it.hasNext()) {
                it.next().QR();
            }
        }
    }
}
