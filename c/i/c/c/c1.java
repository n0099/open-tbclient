package c.i.c.c;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes3.dex */
public interface c1<R, C, V> extends k1<R, C, V> {
    @Override // c.i.c.c.k1
    SortedSet<R> rowKeySet();

    @Override // c.i.c.c.k1
    SortedMap<R, Map<C, V>> rowMap();
}
