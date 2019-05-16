package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b<T> {
    private ArrayList<T> brv = new ArrayList<>();
    private final int brw;

    public b(int i) {
        this.brw = i;
    }

    public synchronized void S(T t) {
        if (t != null) {
            if (this.brv.size() >= this.brw) {
                this.brv.remove(this.brv.size() - 1);
            }
            this.brv.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.brv.size() <= 0) {
                t = null;
                break;
            }
            t = this.brv.remove(this.brv.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
