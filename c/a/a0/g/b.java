package c.a.a0.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.a.a0.g.g.d;
import c.a.a0.g.g.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final List<c.a.a0.g.d.a> f1166d;

    /* renamed from: e  reason: collision with root package name */
    public static final List<c.a.a0.g.e.a> f1167e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, c.a.a0.g.d.a> a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, c.a.a0.g.e.a> f1168b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<String> f1169c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1457142459, "Lc/a/a0/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1457142459, "Lc/a/a0/g/b;");
                return;
            }
        }
        e eVar = new e();
        f1166d = eVar.a.getList();
        f1167e = eVar.f1178b.getList();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.f1168b = Collections.synchronizedMap(new LinkedHashMap());
        this.f1169c = new ArrayList<>();
        synchronized (b.class) {
            if (f1166d != null && this.a.isEmpty()) {
                for (c.a.a0.g.d.a aVar : f1166d) {
                    if (aVar != null) {
                        if (c.a.a0.x.c.b(this.a, aVar.a()) == null) {
                            c.a.a0.x.c.e(this.a, aVar.a(), aVar);
                        }
                        if (!TextUtils.isEmpty(aVar.a())) {
                            c.a.a0.x.a.b(this.f1169c, aVar.a());
                        }
                    }
                }
            }
            if (f1167e != null && this.f1168b.isEmpty()) {
                for (c.a.a0.g.e.a aVar2 : f1167e) {
                    this.f1168b.put(aVar2.a(), aVar2);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull c.a.a0.g.f.a aVar, @Nullable Map<String, Object> map, @Nullable d dVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, aVar, map, dVar)) == null) {
            if (b(context, aVar)) {
                c.a.a0.g.h.d.b(dVar, aVar, 403, false);
                return false;
            }
            c.a.a0.g.d.a aVar2 = c.a.a0.g.h.d.f(aVar.a()) ? (c.a.a0.g.d.a) c.a.a0.x.c.b(this.a, aVar.a()) : null;
            if (c.a.a0.g.h.d.g(aVar.c()) && aVar2 != null) {
                aVar.f();
                return aVar2.b(context, aVar, map, dVar);
            }
            return c.a.a0.g.g.a.a().a(context, aVar.b(), map, dVar);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, c.a.a0.g.f.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aVar)) == null) {
            if (this.f1168b.isEmpty()) {
                return false;
            }
            c.a.a0.g.e.a aVar2 = null;
            try {
                for (Map.Entry<String, c.a.a0.g.e.a> entry : this.f1168b.entrySet()) {
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
