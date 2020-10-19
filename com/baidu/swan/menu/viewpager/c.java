package com.baidu.swan.menu.viewpager;

import java.util.ArrayList;
/* loaded from: classes14.dex */
public class c<T> {
    private ArrayList<T> mPool = new ArrayList<>();
    private final int mPoolLimit;

    public c(int i) {
        this.mPoolLimit = i;
    }

    public synchronized void recycle(T t) {
        if (t != null) {
            if (this.mPool.size() >= this.mPoolLimit) {
                this.mPool.remove(this.mPool.size() - 1);
            }
            this.mPool.add(t);
        }
    }

    public synchronized T get() {
        T t;
        while (true) {
            if (this.mPool.size() <= 0) {
                t = null;
                break;
            }
            t = this.mPool.remove(this.mPool.size() - 1);
            if (t != null) {
                break;
            }
        }
        return t;
    }
}
