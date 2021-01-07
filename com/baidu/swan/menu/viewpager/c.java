package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c<T> {
    private ArrayList<T> ewa = new ArrayList<>();
    private final int ewb;

    public c(int i) {
        this.ewb = i;
    }

    public synchronized void aj(T t) {
        if (t != null) {
            if (this.ewa.size() >= this.ewb) {
                this.ewa.remove(this.ewa.size() - 1);
            }
            this.ewa.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.ewa.size() <= 0) {
                t = null;
                break;
            }
            t = this.ewa.remove(this.ewa.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
