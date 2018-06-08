package android.arch.a.a;

import android.arch.a.a.b;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a<K, V> extends b<K, V> {
    private HashMap<K, b.c<K, V>> jk = new HashMap<>();

    public boolean contains(K k) {
        return this.jk.containsKey(k);
    }
}
