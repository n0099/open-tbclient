package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c<T> {
    private ArrayList<T> erm = new ArrayList<>();
    private final int ern;

    public c(int i) {
        this.ern = i;
    }

    public synchronized void aj(T t) {
        if (t != null) {
            if (this.erm.size() >= this.ern) {
                this.erm.remove(this.erm.size() - 1);
            }
            this.erm.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.erm.size() <= 0) {
                t = null;
                break;
            }
            t = this.erm.remove(this.erm.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
