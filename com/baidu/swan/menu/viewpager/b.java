package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b<T> {
    private ArrayList<T> blo = new ArrayList<>();
    private final int blp;

    public b(int i) {
        this.blp = i;
    }

    public synchronized void T(T t) {
        if (t != null) {
            if (this.blo.size() >= this.blp) {
                this.blo.remove(this.blo.size() - 1);
            }
            this.blo.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.blo.size() <= 0) {
                t = null;
                break;
            }
            t = this.blo.remove(this.blo.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
