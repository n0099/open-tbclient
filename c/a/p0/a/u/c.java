package c.a.p0.a.u;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.x.u.g;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, c.a.p0.a.f.e.a> f7559b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1358665847, "Lc/a/p0/a/u/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1358665847, "Lc/a/p0/a/u/c;");
                return;
            }
        }
        a = c.a.p0.a.a.a;
        f7559b = new HashMap(2);
    }

    public static c.a.p0.a.f.e.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            boolean z = a;
            d.n(true);
            return g.U().f0().b(AppRuntime.getAppContext());
        }
        return (c.a.p0.a.f.e.a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[Catch: all -> 0x0063, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x004d, B:20:0x0051), top: B:30:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051 A[Catch: all -> 0x0063, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x004d, B:20:0x0051), top: B:30:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized c.a.p0.a.f.e.a b() {
        InterceptResult invokeV;
        String str;
        c.a.p0.a.f.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (c.class) {
                c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
                if (a0 != null && !TextUtils.isEmpty(a0.getAppId())) {
                    str = a0.getAppId();
                    String a2 = c.a.p0.a.l.a.a(str);
                    aVar = f7559b.get(a2);
                    if (aVar == null) {
                        e();
                        aVar = a();
                        f7559b.put(a2, aVar);
                        if (a) {
                            String str2 = "can not find sconsole for appId - " + str;
                        }
                    }
                    if (a) {
                        String str3 = "get sconsole for appId - " + str;
                    }
                }
                str = "_no_id_";
                String a22 = c.a.p0.a.l.a.a(str);
                aVar = f7559b.get(a22);
                if (aVar == null) {
                }
                if (a) {
                }
            }
            return aVar;
        }
        return (c.a.p0.a.f.e.a) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            if (a0 != null && !TextUtils.isEmpty(a0.f7512f)) {
                return b.b(c.a.p0.a.l.a.a(a0.f7512f));
            }
            boolean z = a;
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && c()) {
            b();
        }
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (c.class) {
                if (f7559b.size() > 0) {
                    for (String str : f7559b.keySet()) {
                        c.a.p0.a.f.e.a aVar = f7559b.get(str);
                        if (aVar != null) {
                            aVar.F();
                        }
                    }
                    f7559b.clear();
                }
            }
        }
    }
}
