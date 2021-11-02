package b.a.p0.r;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.ubc.Flow;
import com.baidu.swan.ubc.IRemoteUBCService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
@Autowired
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile IRemoteUBCService f11452a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Integer> f11453b;

    /* renamed from: c  reason: collision with root package name */
    public static final Set<String> f11454c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-612892357, "Lb/a/p0/r/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-612892357, "Lb/a/p0/r/e;");
                return;
            }
        }
        f11453b = new HashMap();
        HashSet hashSet = new HashSet();
        f11454c = hashSet;
        hashSet.add("606");
        f11454c.add("671");
        f11453b.put("606", -1);
        f11453b.put("671", -1);
    }

    public e() {
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

    public static int a(String str, String str2) {
        InterceptResult invokeLL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            Integer num = f11453b.get(str);
            if (num == null) {
                num = -1;
            }
            if (num.intValue() == -1) {
                intValue = t.g().getInt(str2, 0);
            } else {
                intValue = num.intValue();
            }
            int i2 = intValue + 1;
            if (i2 >= Integer.MAX_VALUE || i2 < 0) {
                return 0;
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        l g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            if (f11454c.contains(str) && (g2 = g()) != null && g2.q()) {
                synchronized (e.class) {
                    String str3 = "ubc_counter" + str;
                    int a2 = a(str, str3);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        jSONObject.put("counter", a2);
                        str2 = jSONObject.toString();
                        t.g().putInt(str3, a2);
                        f11453b.put(str, Integer.valueOf(a2));
                    } catch (JSONException unused) {
                    }
                }
                return str2;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static JSONObject c(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        l g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, jSONObject)) == null) {
            if (f11454c.contains(str) && (g2 = g()) != null && g2.q()) {
                synchronized (e.class) {
                    String str2 = "ubc_counter" + str;
                    int a2 = a(str, str2);
                    try {
                        jSONObject.put("counter", a2);
                        t.g().putInt(str2, a2);
                        f11453b.put(str, Integer.valueOf(a2));
                    } catch (JSONException unused) {
                    }
                }
                return jSONObject;
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static Flow d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? e(str, "", 0) : (Flow) invokeL.objValue;
    }

    public static Flow e(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, i2)) == null) ? p.b().a(str, str2, i2) : (Flow) invokeLLI.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static IRemoteUBCService f() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f11452a == null) {
                synchronized (e.class) {
                    if (f11452a == null) {
                        IBinder f2 = IPCServiceManager.f("open_log", true);
                        if (f2 == null) {
                            throw new RemoteException("Ceres get remote service empty !");
                        }
                        if (f2 != null) {
                            f11452a = IRemoteUBCService.Stub.asInterface(f2);
                        }
                    }
                }
            }
            return f11452a;
        }
        return (IRemoteUBCService) invokeV.objValue;
    }

    @Inject
    public static l g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? b.a.p0.a.o1.b.a() : (l) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? AppRuntime.getAppContext() : (Context) invokeV.objValue;
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            i(str, str2, 0);
        }
    }

    public static void i(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) {
            if (b.a.h0.b.a.a.g()) {
                str2 = b(str, str2);
            }
            if (b.a.p0.s.d.a()) {
                p.b().e(str, str2, i2);
            }
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, map) == null) {
            k(str, map, 0);
        }
    }

    public static void k(String str, Map<String, String> map, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65549, null, str, map, i2) == null) && b.a.p0.s.d.a()) {
            p.b().f(str, map, i2);
        }
    }

    public static void l(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, str, jSONObject) == null) {
            m(str, jSONObject, 0);
        }
    }

    public static void m(String str, JSONObject jSONObject, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65551, null, str, jSONObject, i2) == null) {
            if (b.a.h0.b.a.a.g()) {
                c(str, jSONObject);
            }
            if (b.a.p0.s.d.a()) {
                p.b().g(str, jSONObject, i2);
            }
        }
    }

    public static void onEvent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            i(str, "", 0);
        }
    }
}
