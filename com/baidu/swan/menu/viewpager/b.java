package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b<T> {
    private ArrayList<T> blp = new ArrayList<>();
    private final int blq;

    public b(int i) {
        this.blq = i;
    }

    public synchronized void T(T t) {
        if (t != null) {
            if (this.blp.size() >= this.blq) {
                this.blp.remove(this.blp.size() - 1);
            }
            this.blp.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.blp.size() <= 0) {
                t = null;
                break;
            }
            t = this.blp.remove(this.blp.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
