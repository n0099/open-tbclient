package android.arch.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes14.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    private c<K, V> zF;
    private c<K, V> zG;
    private WeakHashMap<f<K, V>, Boolean> zH = new WeakHashMap<>();
    private int mSize = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public interface f<K, V> {
        void c(@NonNull c<K, V> cVar);
    }

    protected c<K, V> i(K k) {
        c<K, V> cVar = this.zF;
        while (cVar != null && !cVar.zI.equals(k)) {
            cVar = cVar.zK;
        }
        return cVar;
    }

    public V c(@NonNull K k, @NonNull V v) {
        c<K, V> i = i(k);
        if (i != null) {
            return i.zJ;
        }
        d(k, v);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c<K, V> d(@NonNull K k, @NonNull V v) {
        c<K, V> cVar = new c<>(k, v);
        this.mSize++;
        if (this.zG == null) {
            this.zF = cVar;
            this.zG = this.zF;
        } else {
            this.zG.zK = cVar;
            cVar.zL = this.zG;
            this.zG = cVar;
        }
        return cVar;
    }

    public V remove(@NonNull K k) {
        c<K, V> i = i(k);
        if (i == null) {
            return null;
        }
        this.mSize--;
        if (!this.zH.isEmpty()) {
            for (f<K, V> fVar : this.zH.keySet()) {
                fVar.c(i);
            }
        }
        if (i.zL != null) {
            i.zL.zK = i.zK;
        } else {
            this.zF = i.zK;
        }
        if (i.zK != null) {
            i.zK.zL = i.zL;
        } else {
            this.zG = i.zL;
        }
        i.zK = null;
        i.zL = null;
        return i.zJ;
    }

    public int size() {
        return this.mSize;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.zF, this.zG);
        this.zH.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0001b c0001b = new C0001b(this.zG, this.zF);
        this.zH.put(c0001b, false);
        return c0001b;
    }

    public b<K, V>.d hs() {
        b<K, V>.d dVar = new d();
        this.zH.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> ht() {
        return this.zF;
    }

    public Map.Entry<K, V> hu() {
        return this.zG;
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

    /* loaded from: classes14.dex */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {
        c<K, V> zK;
        c<K, V> zP;

        abstract c<K, V> a(c<K, V> cVar);

        abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.zP = cVar2;
            this.zK = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.zK != null;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (this.zP == cVar && cVar == this.zK) {
                this.zK = null;
                this.zP = null;
            }
            if (this.zP == cVar) {
                this.zP = b(this.zP);
            }
            if (this.zK == cVar) {
                this.zK = hv();
            }
        }

        private c<K, V> hv() {
            if (this.zK == this.zP || this.zP == null) {
                return null;
            }
            return a(this.zK);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.zK;
            this.zK = hv();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.zK;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.zL;
        }
    }

    /* renamed from: android.arch.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    private static class C0001b<K, V> extends e<K, V> {
        C0001b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.zL;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.zK;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> zM;
        private boolean zN;

        private d() {
            this.zN = true;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (cVar == this.zM) {
                this.zM = this.zM.zL;
                this.zN = this.zM == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.zN ? b.this.zF != null : (this.zM == null || this.zM.zK == null) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.zN) {
                this.zN = false;
                this.zM = b.this.zF;
            } else {
                this.zM = this.zM != null ? this.zM.zK : null;
            }
            return this.zM;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        @NonNull
        final K zI;
        @NonNull
        final V zJ;
        c<K, V> zK;
        c<K, V> zL;

        c(@NonNull K k, @NonNull V v) {
            this.zI = k;
            this.zJ = v;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.zI;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            return this.zJ;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.zI + "=" + this.zJ;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.zI.equals(cVar.zI) && this.zJ.equals(cVar.zJ);
            }
            return false;
        }
    }
}
