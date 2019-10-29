package android.arch.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    private c<K, V> bT;
    private c<K, V> bV;
    private WeakHashMap<Object<K, V>, Boolean> bW = new WeakHashMap<>();
    private int mSize = 0;

    public int size() {
        return this.mSize;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.bT, this.bV);
        this.bW.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0000b c0000b = new C0000b(this.bV, this.bT);
        this.bW.put(c0000b, false);
        return c0000b;
    }

    public b<K, V>.d ap() {
        b<K, V>.d dVar = new d();
        this.bW.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> aq() {
        return this.bT;
    }

    public Map.Entry<K, V> ar() {
        return this.bV;
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
        c<K, V> bZ;
        c<K, V> ce;

        abstract c<K, V> a(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.ce = cVar2;
            this.bZ = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.bZ != null;
        }

        private c<K, V> as() {
            if (this.bZ == this.ce || this.ce == null) {
                return null;
            }
            return a(this.bZ);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.bZ;
            this.bZ = as();
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
            return cVar.bZ;
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
            return cVar.ca;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d implements Iterator<Map.Entry<K, V>> {
        private c<K, V> cb;
        private boolean cc;

        private d() {
            this.cc = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cc ? b.this.bT != null : (this.cb == null || this.cb.bZ == null) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.cc) {
                this.cc = false;
                this.cb = b.this.bT;
            } else {
                this.cb = this.cb != null ? this.cb.bZ : null;
            }
            return this.cb;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        @NonNull
        final K bX;
        @NonNull
        final V bY;
        c<K, V> bZ;
        c<K, V> ca;

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.bX;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.bY;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.bX + "=" + this.bY;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.bX.equals(cVar.bX) && this.bY.equals(cVar.bY);
            }
            return false;
        }
    }
}
