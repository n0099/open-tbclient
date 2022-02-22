package c.a.s0.a.p1.r.d;

import android.text.TextUtils;
import c.a.s0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8563e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f8564f;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<d> a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f8565b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f8566c;

    /* renamed from: d  reason: collision with root package name */
    public a f8567d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229870347, "Lc/a/s0/a/p1/r/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-229870347, "Lc/a/s0/a/p1/r/d/b;");
                return;
            }
        }
        f8563e = k.a;
        f8564f = new b();
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
        this.a = new ArrayList();
        this.f8565b = new HashMap();
        this.f8566c = false;
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f8564f : (b) invokeV.objValue;
    }

    public void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) || hybridUbcFlow == null) {
            return;
        }
        JSONArray e2 = e();
        if (e2 != null && e2.length() > 0) {
            hybridUbcFlow.D("ma_update_recorder", e2.toString());
        }
        c();
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f8566c) {
                return null;
            }
            if (f8563e) {
                String str2 = "begin update scope id - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
            d dVar = new d(str);
            dVar.a(currentTimeMillis);
            synchronized (this.a) {
                this.f8565b.put(str3, dVar);
            }
            if (f8563e) {
                String str4 = "begin update uni tag - " + str3;
                String str5 = "begin update ts - " + currentTimeMillis;
            }
            return str3;
        }
        return (String) invokeL.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f8566c = true;
            synchronized (this.a) {
                this.a.clear();
                this.f8565b.clear();
            }
            boolean z = f8563e;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f8566c) {
            return;
        }
        if (f8563e) {
            String str2 = "end update uni tag - " + str;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.a) {
            d dVar = this.f8565b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.a.add(dVar);
                this.f8565b.remove(str);
            }
        }
        if (f8563e) {
            String str3 = "end update ts - " + currentTimeMillis;
        }
    }

    public final JSONArray e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            synchronized (this.a) {
                try {
                    for (d dVar : this.a) {
                        if (dVar != null && (this.f8567d == null || this.f8567d.a(dVar))) {
                            jSONArray.put(dVar.d());
                        }
                    }
                } catch (Exception e2) {
                    if (f8563e) {
                        e2.printStackTrace();
                    }
                }
            }
            if (f8563e) {
                jSONArray.toString();
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f8566c = false;
            synchronized (this.a) {
                this.a.clear();
                this.f8565b.clear();
            }
            boolean z = f8563e;
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f8567d = aVar;
        }
    }
}
