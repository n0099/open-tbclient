package c.a.a0.k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
/* loaded from: classes.dex */
public interface g {
    public static final ServiceReference a = new ServiceReference("nad.core", "eventbus");

    <T extends f> void a(@Nullable T t);

    <T extends f> void b(@NonNull Object obj, @NonNull i<T> iVar);

    void unregister(@NonNull Object obj);
}
