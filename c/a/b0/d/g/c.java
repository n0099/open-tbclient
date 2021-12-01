package c.a.b0.d.g;

import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.pyramid.runtime.service.ServiceReference;
import java.util.Map;
/* loaded from: classes.dex */
public interface c {
    public static final ServiceReference a = new ServiceReference("nad.core", "cmd");

    /* renamed from: b  reason: collision with root package name */
    public static final c f1422b = new b();

    void a(String str, String str2, c.a.b0.d.h.a aVar);

    boolean b(Context context, String str, @Nullable Map<String, Object> map);

    String[] c();

    boolean d(Context context, String str);
}
