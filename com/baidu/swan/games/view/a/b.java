package com.baidu.swan.games.view.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class b {
    private static final ReentrantLock bfB = new ReentrantLock();
    private static ArrayList<a> bfL = new ArrayList<>();

    public static void Pp() {
        if (!bfL.isEmpty()) {
            Iterator<a> it = bfL.iterator();
            while (it.hasNext()) {
                it.next().Pn();
            }
        }
    }

    public static void Pq() {
        if (!bfL.isEmpty()) {
            Iterator<a> it = bfL.iterator();
            while (it.hasNext()) {
                it.next().Po();
            }
        }
    }
}
