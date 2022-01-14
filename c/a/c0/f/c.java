package c.a.c0.f;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.c0.f.h.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final List<c.a.c0.f.e.a> f1858c;

    /* renamed from: d  reason: collision with root package name */
    public static final List<c.a.c0.f.f.a> f1859d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, c.a.c0.f.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, c.a.c0.f.f.a> f1860b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1062847235, "Lc/a/c0/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1062847235, "Lc/a/c0/f/c;");
                return;
            }
        }
        e eVar = new e();
        f1858c = eVar.a.getList();
        f1859d = eVar.f1869b.getList();
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.f1860b = Collections.synchronizedMap(new LinkedHashMap());
        synchronized (c.class) {
            if (f1858c != null && this.a.isEmpty()) {
                for (c.a.c0.f.e.a aVar : f1858c) {
                    if (aVar != null && c.a.c0.x.c.b(this.a, aVar.a()) == null) {
                        c.a.c0.x.c.e(this.a, aVar.a(), aVar);
                    }
                }
            }
            if (f1859d != null && this.f1860b.isEmpty()) {
                for (c.a.c0.f.f.a aVar2 : f1859d) {
                    this.f1860b.put(aVar2.a(), aVar2);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull c.a.c0.f.g.a aVar, @Nullable Map<String, Object> map, @Nullable c.a.c0.f.h.d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, aVar, map, dVar)) == null) {
            if (b(context, aVar)) {
                c.a.c0.f.i.d.b(dVar, aVar, 403, false);
                return false;
            }
            c.a.c0.f.e.a aVar2 = c.a.c0.f.i.d.f(aVar.a()) ? (c.a.c0.f.e.a) c.a.c0.x.c.b(this.a, aVar.a()) : null;
            if (c.a.c0.f.i.d.g(aVar.c()) && aVar2 != null) {
                aVar.f();
                return aVar2.b(context, aVar, map, dVar);
            }
            return c.a.c0.f.h.a.a().a(context, aVar.b(), map, dVar);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, c.a.c0.f.g.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar)) == null) {
            if (this.f1860b.isEmpty()) {
                return false;
            }
            c.a.c0.f.f.a aVar2 = null;
            try {
                for (Map.Entry<String, c.a.c0.f.f.a> entry : this.f1860b.entrySet()) {
                    if (entry != null) {
                        aVar2 = entry.getValue();
                    }
                    if (aVar2 != null && aVar2.b(context, aVar)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
