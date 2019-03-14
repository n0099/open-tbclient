package com.baidu.swan.games.view.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class b {
    private static final ReentrantLock bfy = new ReentrantLock();
    private static ArrayList<a> bfI = new ArrayList<>();

    public static void Pr() {
        if (!bfI.isEmpty()) {
            Iterator<a> it = bfI.iterator();
            while (it.hasNext()) {
                it.next().Pp();
            }
        }
    }

    public static void Ps() {
        if (!bfI.isEmpty()) {
            Iterator<a> it = bfI.iterator();
            while (it.hasNext()) {
                it.next().Pq();
            }
        }
    }
}
