package com.baidu.swan.games.view.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class b {
    private static final ReentrantLock bfx = new ReentrantLock();
    private static ArrayList<a> bfH = new ArrayList<>();

    public static void Pr() {
        if (!bfH.isEmpty()) {
            Iterator<a> it = bfH.iterator();
            while (it.hasNext()) {
                it.next().Pp();
            }
        }
    }

    public static void Ps() {
        if (!bfH.isEmpty()) {
            Iterator<a> it = bfH.iterator();
            while (it.hasNext()) {
                it.next().Pq();
            }
        }
    }
}
