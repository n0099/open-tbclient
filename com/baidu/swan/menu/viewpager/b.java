package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b<T> {
    private ArrayList<T> bsH = new ArrayList<>();
    private final int bsI;

    public b(int i) {
        this.bsI = i;
    }

    public synchronized void S(T t) {
        if (t != null) {
            if (this.bsH.size() >= this.bsI) {
                this.bsH.remove(this.bsH.size() - 1);
            }
            this.bsH.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.bsH.size() <= 0) {
                t = null;
                break;
            }
            t = this.bsH.remove(this.bsH.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
