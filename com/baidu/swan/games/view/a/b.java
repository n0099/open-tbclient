package com.baidu.swan.games.view.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class b {
    private static final ReentrantLock bfC = new ReentrantLock();
    private static ArrayList<a> bfM = new ArrayList<>();

    public static void Pp() {
        if (!bfM.isEmpty()) {
            Iterator<a> it = bfM.iterator();
            while (it.hasNext()) {
                it.next().Pn();
            }
        }
    }

    public static void Pq() {
        if (!bfM.isEmpty()) {
            Iterator<a> it = bfM.iterator();
            while (it.hasNext()) {
                it.next().Po();
            }
        }
    }
}
