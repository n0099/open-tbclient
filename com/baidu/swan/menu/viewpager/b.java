package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b<T> {
    private ArrayList<T> bls = new ArrayList<>();
    private final int blt;

    public b(int i) {
        this.blt = i;
    }

    public synchronized void R(T t) {
        if (t != null) {
            if (this.bls.size() >= this.blt) {
                this.bls.remove(this.bls.size() - 1);
            }
            this.bls.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.bls.size() <= 0) {
                t = null;
                break;
            }
            t = this.bls.remove(this.bls.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
