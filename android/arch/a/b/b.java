package android.arch.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    private c<K, V> ya;
    private c<K, V> yb;
    private WeakHashMap<f<K, V>, Boolean> yc = new WeakHashMap<>();
    private int mSize = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface f<K, V> {
        void c(@NonNull c<K, V> cVar);
    }

    protected c<K, V> h(K k) {
        c<K, V> cVar = this.ya;
        while (cVar != null && !cVar.yd.equals(k)) {
            cVar = cVar.ye;
        }
        return cVar;
    }

    public V c(@NonNull K k, @NonNull V v) {
        c<K, V> h = h(k);
        if (h != null) {
            return h.mValue;
        }
        d(k, v);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> d(@NonNull K k, @NonNull V v) {
        c<K, V> cVar = new c<>(k, v);
        this.mSize++;
        if (this.yb == null) {
            this.ya = cVar;
            this.yb = this.ya;
        } else {
            this.yb.ye = cVar;
            cVar.yf = this.yb;
            this.yb = cVar;
        }
        return cVar;
    }

    public V remove(@NonNull K k) {
        c<K, V> h = h(k);
        if (h == null) {
            return null;
        }
        this.mSize--;
        if (!this.yc.isEmpty()) {
            for (f<K, V> fVar : this.yc.keySet()) {
                fVar.c(h);
            }
        }
        if (h.yf != null) {
            h.yf.ye = h.ye;
        } else {
            this.ya = h.ye;
        }
        if (h.ye != null) {
            h.ye.yf = h.yf;
        } else {
            this.yb = h.yf;
        }
        h.ye = null;
        h.yf = null;
        return h.mValue;
    }

    public int size() {
        return this.mSize;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.ya, this.yb);
        this.yc.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0000b c0000b = new C0000b(this.yb, this.ya);
        this.yc.put(c0000b, false);
        return c0000b;
    }

    public b<K, V>.d gd() {
        b<K, V>.d dVar = new d();
        this.yc.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> ge() {
        return this.ya;
    }

    public Map.Entry<K, V> gf() {
        return this.yb;
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

    /* loaded from: classes3.dex */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {
        c<K, V> ye;
        c<K, V> yj;

        abstract c<K, V> a(c<K, V> cVar);

        abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.yj = cVar2;
            this.ye = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.ye != null;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (this.yj == cVar && cVar == this.ye) {
                this.ye = null;
                this.yj = null;
            }
            if (this.yj == cVar) {
                this.yj = b(this.yj);
            }
            if (this.ye == cVar) {
                this.ye = gg();
            }
        }

        private c<K, V> gg() {
            if (this.ye == this.yj || this.yj == null) {
                return null;
            }
            return a(this.ye);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.ye;
            this.ye = gg();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.ye;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.yf;
        }
    }

    /* renamed from: android.arch.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.yf;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.ye;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> yg;
        private boolean yh;

        private d() {
            this.yh = true;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (cVar == this.yg) {
                this.yg = this.yg.yf;
                this.yh = this.yg == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.yh ? b.this.ya != null : (this.yg == null || this.yg.ye == null) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.yh) {
                this.yh = false;
                this.yg = b.this.ya;
            } else {
                this.yg = this.yg != null ? this.yg.ye : null;
            }
            return this.yg;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        @NonNull
        final V mValue;
        @NonNull
        final K yd;
        c<K, V> ye;
        c<K, V> yf;

        c(@NonNull K k, @NonNull V v) {
            this.yd = k;
            this.mValue = v;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.yd;
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
            return this.yd + ETAG.EQUAL + this.mValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.yd.equals(cVar.yd) && this.mValue.equals(cVar.mValue);
            }
            return false;
        }
    }
}
