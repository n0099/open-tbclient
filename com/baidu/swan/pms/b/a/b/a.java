package com.baidu.swan.pms.b.a.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class a<T> {
    private final List<T> mQueue = new ArrayList();

    public synchronized void X(T t) {
        this.mQueue.add(t);
        notifyAll();
    }

    public synchronized T VE() {
        T t;
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

    public T Y(T t) {
        if (t != null) {
            for (int size = this.mQueue.size() - 1; size >= 0; size--) {
                if (t.equals(this.mQueue.get(size))) {
                    return this.mQueue.get(size);
                }
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(",Queue Size:" + this.mQueue.size());
        int i = 0;
        synchronized (this) {
            Iterator<T> it = this.mQueue.iterator();
            while (it.hasNext()) {
                sb.append(":[" + i + "]" + it.next());
                i++;
            }
        }
        return sb.toString();
    }
}
