package android.arch.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    private c<K, V> bs;
    private c<K, V> bt;
    private WeakHashMap<Object<K, V>, Boolean> bu = new WeakHashMap<>();
    private int mSize = 0;

    public int size() {
        return this.mSize;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.bs, this.bt);
        this.bu.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0000b c0000b = new C0000b(this.bt, this.bs);
        this.bu.put(c0000b, false);
        return c0000b;
    }

    public b<K, V>.d ap() {
        b<K, V>.d dVar = new d();
        this.bu.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> aq() {
        return this.bs;
    }

    public Map.Entry<K, V> ar() {
        return this.bt;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (size() == bVar.size()) {
                Iterator<Map.Entry<K, V>> it = iterator();
                Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    Map.Entry<K, V> next2 = it2.next();
                    if (next == null && next2 != null) {
                        return false;
                    }
                    if (next != null && !next.equals(next2)) {
                        return false;
                    }
                }
                return (it.hasNext() || it2.hasNext()) ? false : true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>> {
        c<K, V> bC;
        c<K, V> bx;

        abstract c<K, V> a(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.bC = cVar2;
            this.bx = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.bx != null;
        }

        private c<K, V> as() {
            if (this.bx == this.bC || this.bC == null) {
                return null;
            }
            return a(this.bx);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.bx;
            this.bx = as();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.a.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.bx;
        }
    }

    /* renamed from: android.arch.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.a.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.by;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements Iterator<Map.Entry<K, V>> {
        private boolean bA;
        private c<K, V> bz;

        private d() {
            this.bA = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.bA ? b.this.bs != null : (this.bz == null || this.bz.bx == null) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.bA) {
                this.bA = false;
                this.bz = b.this.bs;
            } else {
                this.bz = this.bz != null ? this.bz.bx : null;
            }
            return this.bz;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        @NonNull
        final K bv;
        @NonNull
        final V bw;
        c<K, V> bx;
        c<K, V> by;

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.bv;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.bw;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.bv + "=" + this.bw;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.bv.equals(cVar.bv) && this.bw.equals(cVar.bw);
            }
            return false;
        }
    }
}
