package c.i.d.b;

import com.google.common.cache.RemovalNotification;
/* loaded from: classes4.dex */
public interface i<K, V> {
    void onRemoval(RemovalNotification<K, V> removalNotification);
}
