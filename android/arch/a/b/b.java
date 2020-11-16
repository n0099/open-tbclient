package android.arch.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes19.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    private c<K, V> yQ;
    private c<K, V> yR;
    private WeakHashMap<f<K, V>, Boolean> yS = new WeakHashMap<>();
    private int mSize = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public interface f<K, V> {
        void c(@NonNull c<K, V> cVar);
    }

    protected c<K, V> i(K k) {
        c<K, V> cVar = this.yQ;
        while (cVar != null && !cVar.yT.equals(k)) {
            cVar = cVar.yU;
        }
        return cVar;
    }

    public V c(@NonNull K k, @NonNull V v) {
        c<K, V> i = i(k);
        if (i != null) {
            return i.mValue;
        }
        d(k, v);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> d(@NonNull K k, @NonNull V v) {
        c<K, V> cVar = new c<>(k, v);
        this.mSize++;
        if (this.yR == null) {
            this.yQ = cVar;
            this.yR = this.yQ;
        } else {
            this.yR.yU = cVar;
            cVar.yV = this.yR;
            this.yR = cVar;
        }
        return cVar;
    }

    public V remove(@NonNull K k) {
        c<K, V> i = i(k);
        if (i == null) {
            return null;
        }
        this.mSize--;
        if (!this.yS.isEmpty()) {
            for (f<K, V> fVar : this.yS.keySet()) {
                fVar.c(i);
            }
        }
        if (i.yV != null) {
            i.yV.yU = i.yU;
        } else {
            this.yQ = i.yU;
        }
        if (i.yU != null) {
            i.yU.yV = i.yV;
        } else {
            this.yR = i.yV;
        }
        i.yU = null;
        i.yV = null;
        return i.mValue;
    }

    public int size() {
        return this.mSize;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.yQ, this.yR);
        this.yS.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0001b c0001b = new C0001b(this.yR, this.yQ);
        this.yS.put(c0001b, false);
        return c0001b;
    }

    public b<K, V>.d hs() {
        b<K, V>.d dVar = new d();
        this.yS.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> ht() {
        return this.yQ;
    }

    public Map.Entry<K, V> hu() {
        return this.yR;
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

    /* loaded from: classes19.dex */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {
        c<K, V> yU;
        c<K, V> yZ;

        abstract c<K, V> a(c<K, V> cVar);

        abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.yZ = cVar2;
            this.yU = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.yU != null;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (this.yZ == cVar && cVar == this.yU) {
                this.yU = null;
                this.yZ = null;
            }
            if (this.yZ == cVar) {
                this.yZ = b(this.yZ);
            }
            if (this.yU == cVar) {
                this.yU = hv();
            }
        }

        private c<K, V> hv() {
            if (this.yU == this.yZ || this.yZ == null) {
                return null;
            }
            return a(this.yU);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.yU;
            this.yU = hv();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.yU;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.yV;
        }
    }

    /* renamed from: android.arch.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static class C0001b<K, V> extends e<K, V> {
        C0001b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.yV;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.yU;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> yW;
        private boolean yX;

        private d() {
            this.yX = true;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (cVar == this.yW) {
                this.yW = this.yW.yV;
                this.yX = this.yW == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.yX ? b.this.yQ != null : (this.yW == null || this.yW.yU == null) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.yX) {
                this.yX = false;
                this.yW = b.this.yQ;
            } else {
                this.yW = this.yW != null ? this.yW.yU : null;
            }
            return this.yW;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        @NonNull
        final V mValue;
        @NonNull
        final K yT;
        c<K, V> yU;
        c<K, V> yV;

        c(@NonNull K k, @NonNull V v) {
            this.yT = k;
            this.mValue = v;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.yT;
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
            return this.yT + ETAG.EQUAL + this.mValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.yT.equals(cVar.yT) && this.mValue.equals(cVar.mValue);
            }
            return false;
        }
    }
}
