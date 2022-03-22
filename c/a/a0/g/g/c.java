package c.a.a0.g.g;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes.dex */
public interface c {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");

    /* renamed from: b  reason: collision with root package name */
    public static final c f1177b = new b();

    boolean a(Context context, String str, @Nullable Map<String, Object> map, @Nullable d dVar);

    void b(String str, String str2, c.a.a0.g.h.a aVar);

    String[] c();

    boolean d(Context context, String str);
}
