package c.a.c0.d;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.c0.d.g.d;
import c.a.c0.d.g.e;
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
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final List<c.a.c0.d.d.a> f1431c;

    /* renamed from: d  reason: collision with root package name */
    public static final List<c.a.c0.d.e.a> f1432d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, c.a.c0.d.d.a> a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, c.a.c0.d.e.a> f1433b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1062906848, "Lc/a/c0/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1062906848, "Lc/a/c0/d/b;");
                return;
            }
        }
        e eVar = new e();
        f1431c = eVar.a.getList();
        f1432d = eVar.f1441b.getList();
    }

    public b() {
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
        this.f1433b = Collections.synchronizedMap(new LinkedHashMap());
        synchronized (b.class) {
            if (f1431c != null && this.a.isEmpty()) {
                for (c.a.c0.d.d.a aVar : f1431c) {
                    if (aVar != null && c.a.c0.u.c.b(this.a, aVar.a()) == null) {
                        c.a.c0.u.c.e(this.a, aVar.a(), aVar);
                    }
                }
            }
            if (f1432d != null && this.f1433b.isEmpty()) {
                for (c.a.c0.d.e.a aVar2 : f1432d) {
                    this.f1433b.put(aVar2.a(), aVar2);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull c.a.c0.d.f.a aVar, @Nullable Map<String, Object> map, @Nullable d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, aVar, map, dVar)) == null) {
            if (c(context, aVar)) {
                b(dVar);
                return false;
            }
            c.a.c0.d.d.a aVar2 = c.a.c0.d.h.d.a(aVar.a()) ? (c.a.c0.d.d.a) c.a.c0.u.c.b(this.a, aVar.a()) : null;
            if (c.a.c0.d.h.d.b(aVar.c()) && aVar2 != null) {
                aVar.f();
                return aVar2.b(context, aVar, map, dVar);
            }
            return c.a.c0.d.g.a.a().b(context, aVar.b(), map);
        }
        return invokeLLLL.booleanValue;
    }

    public final void b(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        dVar.a(false, null);
    }

    public boolean c(Context context, c.a.c0.d.f.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, aVar)) == null) {
            if (this.f1433b.isEmpty()) {
                return false;
            }
            c.a.c0.d.e.a aVar2 = null;
            try {
                for (Map.Entry<String, c.a.c0.d.e.a> entry : this.f1433b.entrySet()) {
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
