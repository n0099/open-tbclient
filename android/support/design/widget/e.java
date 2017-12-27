package android.support.design.widget;

import android.support.v4.util.Pools;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
final class e<T> {
    private final Pools.Pool<ArrayList<T>> oi = new Pools.SimplePool(10);
    private final SimpleArrayMap<T, ArrayList<T>> oj = new SimpleArrayMap<>();
    private final ArrayList<T> ol = new ArrayList<>();
    private final HashSet<T> om = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(T t) {
        if (!this.oj.containsKey(t)) {
            this.oj.put(t, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean contains(T t) {
        return this.oj.containsKey(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(T t, T t2) {
        if (!this.oj.containsKey(t) || !this.oj.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayList = this.oj.get(t);
        if (arrayList == null) {
            arrayList = bJ();
            this.oj.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List g(T t) {
        return this.oj.get(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List h(T t) {
        ArrayList arrayList = null;
        int size = this.oj.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> valueAt = this.oj.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
                arrayList2.add(this.oj.keyAt(i));
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(T t) {
        int size = this.oj.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> valueAt = this.oj.valueAt(i);
            if (valueAt != null && valueAt.contains(t)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        int size = this.oj.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> valueAt = this.oj.valueAt(i);
            if (valueAt != null) {
                c(valueAt);
            }
        }
        this.oj.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<T> bI() {
        this.ol.clear();
        this.om.clear();
        int size = this.oj.size();
        for (int i = 0; i < size; i++) {
            a(this.oj.keyAt(i), this.ol, this.om);
        }
        return this.ol;
    }

    private void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.oj.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }

    private ArrayList<T> bJ() {
        ArrayList<T> acquire = this.oi.acquire();
        if (acquire == null) {
            return new ArrayList<>();
        }
        return acquire;
    }

    private void c(ArrayList<T> arrayList) {
        arrayList.clear();
        this.oi.release(arrayList);
    }
}
