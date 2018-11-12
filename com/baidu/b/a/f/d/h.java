package com.baidu.b.a.f.d;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class h<T> {
    private boolean aaf;
    private final List<T> mQueue = new ArrayList();

    public synchronized void E(T t) {
        this.mQueue.add(t);
        notifyAll();
    }

    public synchronized T rT() {
        T t;
        if (this.mQueue.isEmpty() && this.aaf) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if (this.mQueue.isEmpty()) {
            t = null;
        } else {
            t = this.mQueue.get(0);
            this.mQueue.remove(0);
        }
        return t;
    }

    public synchronized T get() {
        T t;
        if (this.mQueue.isEmpty()) {
            t = null;
        } else {
            t = this.mQueue.get(0);
        }
        return t;
    }

    public boolean remove(Object obj) {
        return this.mQueue.remove(obj);
    }

    public boolean contains(T t) {
        if (t != null) {
            for (int size = this.mQueue.size() - 1; size >= 0; size--) {
                if (t.equals(this.mQueue.get(size))) {
                    return true;
                }
            }
        }
        return false;
    }

    public T F(T t) {
        if (t != null) {
            for (int size = this.mQueue.size() - 1; size >= 0; size--) {
                if (t.equals(this.mQueue.get(size))) {
                    return this.mQueue.get(size);
                }
            }
        }
        return null;
    }
}
