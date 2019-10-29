package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b<T> {
    private ArrayList<T> bLs = new ArrayList<>();
    private final int bLt;

    public b(int i) {
        this.bLt = i;
    }

    public synchronized void Q(T t) {
        if (t != null) {
            if (this.bLs.size() >= this.bLt) {
                this.bLs.remove(this.bLs.size() - 1);
            }
            this.bLs.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.bLs.size() <= 0) {
                t = null;
                break;
            }
            t = this.bLs.remove(this.bLs.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
