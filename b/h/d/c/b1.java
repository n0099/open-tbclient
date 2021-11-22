package b.h.d.c;

import com.google.common.collect.Range;
import java.lang.Comparable;
import java.util.Set;
/* loaded from: classes6.dex */
public interface b1<C extends Comparable> {
    Set<Range<C>> asRanges();

    b1<C> complement();

    boolean encloses(Range<C> range);

    boolean isEmpty();

    void removeAll(b1<C> b1Var);
}
