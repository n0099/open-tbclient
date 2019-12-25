package android.arch.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes4.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    private c<K, V> bw;
    private c<K, V> bx;
    private WeakHashMap<f<K, V>, Boolean> by = new WeakHashMap<>();
    private int mSize = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface f<K, V> {
        void c(@NonNull c<K, V> cVar);
    }

    protected c<K, V> g(K k) {
        c<K, V> cVar = this.bw;
        while (cVar != null && !cVar.bz.equals(k)) {
            cVar = cVar.bB;
        }
        return cVar;
    }

    public V c(@NonNull K k, @NonNull V v) {
        c<K, V> g = g(k);
        if (g != null) {
            return g.bA;
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
            this.bx.bB = cVar;
            cVar.bC = this.bx;
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
        if (g.bC != null) {
            g.bC.bB = g.bB;
        } else {
            this.bw = g.bB;
        }
        if (g.bB != null) {
            g.bB.bC = g.bC;
        } else {
            this.bx = g.bC;
        }
        g.bB = null;
        g.bC = null;
        return g.bA;
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

    /* loaded from: classes4.dex */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {
        c<K, V> bB;
        c<K, V> bG;

        abstract c<K, V> a(c<K, V> cVar);

        abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.bG = cVar2;
            this.bB = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.bB != null;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (this.bG == cVar && cVar == this.bB) {
                this.bB = null;
                this.bG = null;
            }
            if (this.bG == cVar) {
                this.bG = b(this.bG);
            }
            if (this.bB == cVar) {
                this.bB = at();
            }
        }

        private c<K, V> at() {
            if (this.bB == this.bG || this.bG == null) {
                return null;
            }
            return a(this.bB);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.bB;
            this.bB = at();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.bB;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.bC;
        }
    }

    /* renamed from: android.arch.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.bC;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.bB;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> bD;
        private boolean bE;

        private d() {
            this.bE = true;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (cVar == this.bD) {
                this.bD = this.bD.bC;
                this.bE = this.bD == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.bE ? b.this.bw != null : (this.bD == null || this.bD.bB == null) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.bE) {
                this.bE = false;
                this.bD = b.this.bw;
            } else {
                this.bD = this.bD != null ? this.bD.bB : null;
            }
            return this.bD;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        @NonNull
        final V bA;
        c<K, V> bB;
        c<K, V> bC;
        @NonNull
        final K bz;

        c(@NonNull K k, @NonNull V v) {
            this.bz = k;
            this.bA = v;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.bz;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.bA;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.bz + ETAG.EQUAL + this.bA;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.bz.equals(cVar.bz) && this.bA.equals(cVar.bA);
            }
            return false;
        }
    }
}
