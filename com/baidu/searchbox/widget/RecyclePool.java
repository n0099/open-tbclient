package com.baidu.searchbox.widget;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class RecyclePool<T> {
    public ArrayList<T> mPool = new ArrayList<>();
    public final int mPoolLimit;

    public RecyclePool(int i) {
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

    public void clear() {
        this.mPool.clear();
    }

    public synchronized T get() {
        T remove;
        do {
            if (this.mPool.size() > 0) {
                remove = this.mPool.remove(this.mPool.size() - 1);
            } else {
                return null;
            }
        } while (remove == null);
        return remove;
    }
}
