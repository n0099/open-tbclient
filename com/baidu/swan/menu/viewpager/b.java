package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b<T> {
    private ArrayList<T> blt = new ArrayList<>();
    private final int blu;

    public b(int i) {
        this.blu = i;
    }

    public synchronized void R(T t) {
        if (t != null) {
            if (this.blt.size() >= this.blu) {
                this.blt.remove(this.blt.size() - 1);
            }
            this.blt.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.blt.size() <= 0) {
                t = null;
                break;
            }
            t = this.blt.remove(this.blt.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
