package b.a.p0.a.n1.q.d;

import android.text.TextUtils;
import b.a.p0.a.k;
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
    public static final boolean f6954e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f6955f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f6956a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f6957b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6958c;

    /* renamed from: d  reason: collision with root package name */
    public a f6959d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1575190360, "Lb/a/p0/a/n1/q/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1575190360, "Lb/a/p0/a/n1/q/d/b;");
                return;
            }
        }
        f6954e = k.f6397a;
        f6955f = new b();
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
        this.f6956a = new ArrayList();
        this.f6957b = new HashMap();
        this.f6958c = false;
    }

    public static b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f6955f : (b) invokeV.objValue;
    }

    public void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) || hybridUbcFlow == null) {
            return;
        }
        JSONArray e2 = e();
        if (e2 != null && e2.length() > 0) {
            hybridUbcFlow.A("ma_update_recorder", e2.toString());
        }
        c();
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f6958c) {
                return null;
            }
            if (f6954e) {
                String str2 = "begin update scope id - " + str;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str3 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
            d dVar = new d(str);
            dVar.a(currentTimeMillis);
            synchronized (this.f6956a) {
                this.f6957b.put(str3, dVar);
            }
            if (f6954e) {
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
            this.f6958c = true;
            synchronized (this.f6956a) {
                this.f6956a.clear();
                this.f6957b.clear();
            }
            boolean z = f6954e;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f6958c) {
            return;
        }
        if (f6954e) {
            String str2 = "end update uni tag - " + str;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f6956a) {
            d dVar = this.f6957b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.f6956a.add(dVar);
                this.f6957b.remove(str);
            }
        }
        if (f6954e) {
            String str3 = "end update ts - " + currentTimeMillis;
        }
    }

    public final JSONArray e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            synchronized (this.f6956a) {
                try {
                    for (d dVar : this.f6956a) {
                        if (dVar != null && (this.f6959d == null || this.f6959d.a(dVar))) {
                            jSONArray.put(dVar.d());
                        }
                    }
                } catch (Exception e2) {
                    if (f6954e) {
                        e2.printStackTrace();
                    }
                }
            }
            if (f6954e) {
                jSONArray.toString();
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f6958c = false;
            synchronized (this.f6956a) {
                this.f6956a.clear();
                this.f6957b.clear();
            }
            boolean z = f6954e;
        }
    }

    public void h(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.f6959d = aVar;
        }
    }
}
