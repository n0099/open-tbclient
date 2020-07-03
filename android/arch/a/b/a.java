package android.arch.a.b;

import android.arch.a.b.b;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes7.dex */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> mHashMap = new HashMap<>();

    @Override // android.arch.a.b.b
    protected b.c<K, V> h(K k) {
        return this.mHashMap.get(k);
    }

    @Override // android.arch.a.b.b
    public V c(@NonNull K k, @NonNull V v) {
        b.c<K, V> h = h(k);
        if (h != null) {
            return h.mValue;
        }
        this.mHashMap.put(k, d(k, v));
        return null;
    }

    @Override // android.arch.a.b.b
    public V remove(@NonNull K k) {
        V v = (V) super.remove(k);
        this.mHashMap.remove(k);
        return v;
    }

    public boolean contains(K k) {
        return this.mHashMap.containsKey(k);
    }

    public Map.Entry<K, V> i(K k) {
        if (contains(k)) {
            return this.mHashMap.get(k).yf;
        }
        return null;
    }
}
