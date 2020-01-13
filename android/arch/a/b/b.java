package android.arch.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    private c<K, V> bw;
    private c<K, V> bx;
    private WeakHashMap<f<K, V>, Boolean> by = new WeakHashMap<>();
    private int mSize = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface f<K, V> {
        void c(@NonNull c<K, V> cVar);
    }

    protected c<K, V> g(K k) {
        c<K, V> cVar = this.bw;
        while (cVar != null && !cVar.bz.equals(k)) {
            cVar = cVar.bA;
        }
        return cVar;
    }

    public V c(@NonNull K k, @NonNull V v) {
        c<K, V> g = g(k);
        if (g != null) {
            return g.mValue;
        }
        d(k, v);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> d(@NonNull K k, @NonNull V v) {
        c<K, V> cVar = new c<>(k, v);
        this.mSize++;
        if (this.bx == null) {
            this.bw = cVar;
            this.bx = this.bw;
        } else {
            this.bx.bA = cVar;
            cVar.bB = this.bx;
            this.bx = cVar;
        }
        return cVar;
    }

    public V remove(@NonNull K k) {
        c<K, V> g = g(k);
        if (g == null) {
            return null;
        }
        this.mSize--;
        if (!this.by.isEmpty()) {
            for (f<K, V> fVar : this.by.keySet()) {
                fVar.c(g);
            }
        }
        if (g.bB != null) {
            g.bB.bA = g.bA;
        } else {
            this.bw = g.bA;
        }
        if (g.bA != null) {
            g.bA.bB = g.bB;
        } else {
            this.bx = g.bB;
        }
        g.bA = null;
        g.bB = null;
        return g.mValue;
    }

    public int size() {
        return this.mSize;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.bw, this.bx);
        this.by.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0000b c0000b = new C0000b(this.bx, this.bw);
        this.by.put(c0000b, false);
        return c0000b;
    }

    public b<K, V>.d aq() {
        b<K, V>.d dVar = new d();
        this.by.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> ar() {
        return this.bw;
    }

    public Map.Entry<K, V> as() {
        return this.bx;
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

    /* loaded from: classes5.dex */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {
        c<K, V> bA;
        c<K, V> bF;

        abstract c<K, V> a(c<K, V> cVar);

        abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.bF = cVar2;
            this.bA = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.bA != null;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (this.bF == cVar && cVar == this.bA) {
                this.bA = null;
                this.bF = null;
            }
            if (this.bF == cVar) {
                this.bF = b(this.bF);
            }
            if (this.bA == cVar) {
                this.bA = at();
            }
        }

        private c<K, V> at() {
            if (this.bA == this.bF || this.bF == null) {
                return null;
            }
            return a(this.bA);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.bA;
            this.bA = at();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.bA;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.bB;
        }
    }

    /* renamed from: android.arch.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.bB;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.bA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> bC;
        private boolean bD;

        private d() {
            this.bD = true;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (cVar == this.bC) {
                this.bC = this.bC.bB;
                this.bD = this.bC == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.bD ? b.this.bw != null : (this.bC == null || this.bC.bA == null) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.bD) {
                this.bD = false;
                this.bC = b.this.bw;
            } else {
                this.bC = this.bC != null ? this.bC.bA : null;
            }
            return this.bC;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        c<K, V> bA;
        c<K, V> bB;
        @NonNull
        final K bz;
        @NonNull
        final V mValue;

        c(@NonNull K k, @NonNull V v) {
            this.bz = k;
            this.mValue = v;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.bz;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.bz + ETAG.EQUAL + this.mValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.bz.equals(cVar.bz) && this.mValue.equals(cVar.mValue);
            }
            return false;
        }
    }
}
