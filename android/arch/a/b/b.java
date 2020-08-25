package android.arch.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes18.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    private c<K, V> yA;
    private c<K, V> yz;
    private WeakHashMap<f<K, V>, Boolean> yB = new WeakHashMap<>();
    private int mSize = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public interface f<K, V> {
        void c(@NonNull c<K, V> cVar);
    }

    protected c<K, V> i(K k) {
        c<K, V> cVar = this.yz;
        while (cVar != null && !cVar.yC.equals(k)) {
            cVar = cVar.yD;
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
        if (this.yA == null) {
            this.yz = cVar;
            this.yA = this.yz;
        } else {
            this.yA.yD = cVar;
            cVar.yE = this.yA;
            this.yA = cVar;
        }
        return cVar;
    }

    public V remove(@NonNull K k) {
        c<K, V> i = i(k);
        if (i == null) {
            return null;
        }
        this.mSize--;
        if (!this.yB.isEmpty()) {
            for (f<K, V> fVar : this.yB.keySet()) {
                fVar.c(i);
            }
        }
        if (i.yE != null) {
            i.yE.yD = i.yD;
        } else {
            this.yz = i.yD;
        }
        if (i.yD != null) {
            i.yD.yE = i.yE;
        } else {
            this.yA = i.yE;
        }
        i.yD = null;
        i.yE = null;
        return i.mValue;
    }

    public int size() {
        return this.mSize;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.yz, this.yA);
        this.yB.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0000b c0000b = new C0000b(this.yA, this.yz);
        this.yB.put(c0000b, false);
        return c0000b;
    }

    public b<K, V>.d hr() {
        b<K, V>.d dVar = new d();
        this.yB.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> hs() {
        return this.yz;
    }

    public Map.Entry<K, V> ht() {
        return this.yA;
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

    /* loaded from: classes18.dex */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {
        c<K, V> yD;
        c<K, V> yI;

        abstract c<K, V> a(c<K, V> cVar);

        abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.yI = cVar2;
            this.yD = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.yD != null;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (this.yI == cVar && cVar == this.yD) {
                this.yD = null;
                this.yI = null;
            }
            if (this.yI == cVar) {
                this.yI = b(this.yI);
            }
            if (this.yD == cVar) {
                this.yD = hu();
            }
        }

        private c<K, V> hu() {
            if (this.yD == this.yI || this.yI == null) {
                return null;
            }
            return a(this.yD);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.yD;
            this.yD = hu();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.yD;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.yE;
        }
    }

    /* renamed from: android.arch.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.yE;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.yD;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> yF;
        private boolean yG;

        private d() {
            this.yG = true;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (cVar == this.yF) {
                this.yF = this.yF.yE;
                this.yG = this.yF == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.yG ? b.this.yz != null : (this.yF == null || this.yF.yD == null) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.yG) {
                this.yG = false;
                this.yF = b.this.yz;
            } else {
                this.yF = this.yF != null ? this.yF.yD : null;
            }
            return this.yF;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        @NonNull
        final V mValue;
        @NonNull
        final K yC;
        c<K, V> yD;
        c<K, V> yE;

        c(@NonNull K k, @NonNull V v) {
            this.yC = k;
            this.mValue = v;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.yC;
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
            return this.yC + ETAG.EQUAL + this.mValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.yC.equals(cVar.yC) && this.mValue.equals(cVar.mValue);
            }
            return false;
        }
    }
}
