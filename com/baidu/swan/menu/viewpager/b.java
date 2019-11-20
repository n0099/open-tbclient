package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b<T> {
    private ArrayList<T> bKB = new ArrayList<>();
    private final int bKC;

    public b(int i) {
        this.bKC = i;
    }

    public synchronized void Q(T t) {
        if (t != null) {
            if (this.bKB.size() >= this.bKC) {
                this.bKB.remove(this.bKB.size() - 1);
            }
            this.bKB.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.bKB.size() <= 0) {
                t = null;
                break;
            }
            t = this.bKB.remove(this.bKB.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
