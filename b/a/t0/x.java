package b.a.t0;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f29769b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile x f29770c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public y f29771a;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f29772a;

        /* renamed from: b  reason: collision with root package name */
        public Map<String, JSONObject> f29773b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29772a = 0;
            this.f29773b = new HashMap();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1136607025, "Lb/a/t0/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1136607025, "Lb/a/t0/x;");
                return;
            }
        }
        f29769b = b0.m();
    }

    public x() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static x f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f29770c == null) {
                synchronized (x.class) {
                    if (f29770c == null) {
                        f29770c = new x();
                    }
                }
            }
            return f29770c;
        }
        return (x) invokeV.objValue;
    }

    public void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && !TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str) && b()) {
            this.f29771a.c(str, z);
        }
    }

    public final boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            g o = g.o();
            if (o == null || o.g("2980", 32)) {
                return o == null || !o.d("2980");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g o = g.o();
            if (o == null || o.g("2980", 32)) {
                return o == null || !o.d("2980");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d(l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, l0Var)) == null) {
            if (l0Var == null || l0Var.w() || !c()) {
                return false;
            }
            this.f29771a.f();
            Map<String, a> v = this.f29771a.v(7);
            if (v != null && v.size() != 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    boolean z = false;
                    for (String str : v.keySet()) {
                        a aVar = v.get(str);
                        if (aVar != null && !TextUtils.isEmpty(str)) {
                            JSONObject jSONObject2 = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            for (JSONObject jSONObject3 : aVar.f29773b.values()) {
                                jSONArray.put(jSONObject3);
                            }
                            jSONObject2.put("total", aVar.f29772a);
                            jSONObject2.put("data", jSONArray);
                            jSONObject.put(str.replace("-", ""), jSONObject2);
                            z = true;
                        }
                    }
                    if (z) {
                        n nVar = new n("2980");
                        nVar.y(jSONObject);
                        nVar.B(System.currentTimeMillis());
                        l0Var.c(nVar, nVar.g());
                        l0Var.a(v.keySet());
                        return true;
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void e(Map<String, a> map, String str, String str2, int i2, int i3) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{map, str, str2, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || map == null) {
            return;
        }
        if (map.containsKey(str)) {
            aVar = map.get(str);
        } else {
            a aVar2 = new a();
            map.put(str, aVar2);
            aVar = aVar2;
        }
        Map<String, JSONObject> map2 = aVar.f29773b;
        if (map2.containsKey(str2) && f29769b) {
            String str3 = "*******duplicate ubc id record: " + str2;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", str2);
            jSONObject.put("c", i2);
            jSONObject.put("cc", i3);
            aVar.f29772a += i2;
            map2.put(str2, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void g(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, yVar) == null) {
            this.f29771a = yVar;
        }
    }
}
