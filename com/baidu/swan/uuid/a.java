package com.baidu.swan.uuid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes12.dex */
public class a<T> {
    private List<com.baidu.swan.uuid.a.b<T>> dBv = new ArrayList(6);

    public void a(com.baidu.swan.uuid.a.b<T> bVar) {
        if (bVar != null && !this.dBv.contains(bVar)) {
            this.dBv.add(bVar);
        }
    }

    public T aOb() {
        T t;
        ArrayList<com.baidu.swan.uuid.a.b> arrayList = new ArrayList();
        T t2 = null;
        Iterator<com.baidu.swan.uuid.a.b<T>> it = this.dBv.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = t2;
                break;
            }
            com.baidu.swan.uuid.a.b<T> next = it.next();
            t = next.get();
            if (ai(t)) {
                break;
            }
            arrayList.add(next);
            t2 = t;
        }
        if (arrayList.size() > 0) {
            for (com.baidu.swan.uuid.a.b bVar : arrayList) {
                bVar.put(t);
            }
        }
        return t;
    }

    private boolean ai(T t) {
        char[] charArray;
        if (t != null && (t instanceof String)) {
            String str = (String) t;
            if (str.length() == 32) {
                for (char c : str.toCharArray()) {
                    if ((c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void aj(T t) {
        if (!ai(t)) {
            for (com.baidu.swan.uuid.a.b<T> bVar : this.dBv) {
                if (bVar.aOc()) {
                    bVar.put(t);
                }
            }
        }
    }
}
