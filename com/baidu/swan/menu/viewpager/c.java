package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class c<T> {
    private ArrayList<T> euV = new ArrayList<>();
    private final int euW;

    public c(int i) {
        this.euW = i;
    }

    public synchronized void al(T t) {
        if (t != null) {
            if (this.euV.size() >= this.euW) {
                this.euV.remove(this.euV.size() - 1);
            }
            this.euV.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.euV.size() <= 0) {
                t = null;
                break;
            }
            t = this.euV.remove(this.euV.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
