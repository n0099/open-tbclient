package android.arch.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.baidu.webkit.internal.ETAG;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    private c<K, V> xA;
    private c<K, V> xB;
    private WeakHashMap<f<K, V>, Boolean> xC = new WeakHashMap<>();
    private int mSize = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface f<K, V> {
        void c(@NonNull c<K, V> cVar);
    }

    protected c<K, V> h(K k) {
        c<K, V> cVar = this.xA;
        while (cVar != null && !cVar.xD.equals(k)) {
            cVar = cVar.xE;
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
        if (this.xB == null) {
            this.xA = cVar;
            this.xB = this.xA;
        } else {
            this.xB.xE = cVar;
            cVar.xF = this.xB;
            this.xB = cVar;
        }
        return cVar;
    }

    public V remove(@NonNull K k) {
        c<K, V> h = h(k);
        if (h == null) {
            return null;
        }
        this.mSize--;
        if (!this.xC.isEmpty()) {
            for (f<K, V> fVar : this.xC.keySet()) {
                fVar.c(h);
            }
        }
        if (h.xF != null) {
            h.xF.xE = h.xE;
        } else {
            this.xA = h.xE;
        }
        if (h.xE != null) {
            h.xE.xF = h.xF;
        } else {
            this.xB = h.xF;
        }
        h.xE = null;
        h.xF = null;
        return h.mValue;
    }

    public int size() {
        return this.mSize;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.xA, this.xB);
        this.xC.put(aVar, false);
        return aVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0000b c0000b = new C0000b(this.xB, this.xA);
        this.xC.put(c0000b, false);
        return c0000b;
    }

    public b<K, V>.d fM() {
        b<K, V>.d dVar = new d();
        this.xC.put(dVar, false);
        return dVar;
    }

    public Map.Entry<K, V> fN() {
        return this.xA;
    }

    public Map.Entry<K, V> fO() {
        return this.xB;
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

    /* loaded from: classes7.dex */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {
        c<K, V> xE;
        c<K, V> xJ;

        abstract c<K, V> a(c<K, V> cVar);

        abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.xJ = cVar2;
            this.xE = cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.xE != null;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (this.xJ == cVar && cVar == this.xE) {
                this.xE = null;
                this.xJ = null;
            }
            if (this.xJ == cVar) {
                this.xJ = b(this.xJ);
            }
            if (this.xE == cVar) {
                this.xE = fP();
            }
        }

        private c<K, V> fP() {
            if (this.xE == this.xJ || this.xJ == null) {
                return null;
            }
            return a(this.xE);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.xE;
            this.xE = fP();
            return cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.xE;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.xF;
        }
    }

    /* renamed from: android.arch.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0000b<K, V> extends e<K, V> {
        C0000b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.a.b.b.e
        c<K, V> a(c<K, V> cVar) {
            return cVar.xF;
        }

        @Override // android.arch.a.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.xE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> xG;
        private boolean xH;

        private d() {
            this.xH = true;
        }

        @Override // android.arch.a.b.b.f
        public void c(@NonNull c<K, V> cVar) {
            if (cVar == this.xG) {
                this.xG = this.xG.xF;
                this.xH = this.xG == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.xH ? b.this.xA != null : (this.xG == null || this.xG.xE == null) ? false : true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.xH) {
                this.xH = false;
                this.xG = b.this.xA;
            } else {
                this.xG = this.xG != null ? this.xG.xE : null;
            }
            return this.xG;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class c<K, V> implements Map.Entry<K, V> {
        @NonNull
        final V mValue;
        @NonNull
        final K xD;
        c<K, V> xE;
        c<K, V> xF;

        c(@NonNull K k, @NonNull V v) {
            this.xD = k;
            this.mValue = v;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            return this.xD;
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
            return this.xD + ETAG.EQUAL + this.mValue;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                return this.xD.equals(cVar.xD) && this.mValue.equals(cVar.mValue);
            }
            return false;
        }
    }
}
