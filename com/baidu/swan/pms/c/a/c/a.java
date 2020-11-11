package com.baidu.swan.pms.c.a.c;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes15.dex */
public class a<T> {
    protected final List<T> mQueue = new ArrayList();

    public synchronized T bbD() {
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

    public T am(T t) {
        if (t != null) {
            for (int size = this.mQueue.size() - 1; size >= 0; size--) {
                if (t.equals(this.mQueue.get(size))) {
                    return this.mQueue.get(size);
                }
            }
        }
        return null;
    }

    @NonNull
    public Iterator<T> bbE() {
        return this.mQueue.iterator();
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
