package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b<T> {
    private ArrayList<T> bsj = new ArrayList<>();
    private final int bsk;

    public b(int i) {
        this.bsk = i;
    }

    public synchronized void S(T t) {
        if (t != null) {
            if (this.bsj.size() >= this.bsk) {
                this.bsj.remove(this.bsj.size() - 1);
            }
            this.bsj.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.bsj.size() <= 0) {
                t = null;
                break;
            }
            t = this.bsj.remove(this.bsj.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
