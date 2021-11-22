package b.h.d.d;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
/* loaded from: classes6.dex */
public interface e {
    <T> HashCode hashObject(T t, Funnel<? super T> funnel);

    f newHasher();
}
