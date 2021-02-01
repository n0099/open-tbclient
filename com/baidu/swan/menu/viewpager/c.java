package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c<T> {
    private ArrayList<T> etu = new ArrayList<>();
    private final int etv;

    public c(int i) {
        this.etv = i;
    }

    public synchronized void aj(T t) {
        if (t != null) {
            if (this.etu.size() >= this.etv) {
                this.etu.remove(this.etu.size() - 1);
            }
            this.etu.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.etu.size() <= 0) {
                t = null;
                break;
            }
            t = this.etu.remove(this.etu.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
