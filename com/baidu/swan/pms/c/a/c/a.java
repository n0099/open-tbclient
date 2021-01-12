package com.baidu.swan.pms.c.a.c;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class a<T> {
    protected final List<T> mQueue = new ArrayList();

    public synchronized T bcE() {
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

    public T ao(T t) {
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
    public Iterator<T> bcF() {
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
