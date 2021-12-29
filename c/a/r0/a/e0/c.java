package c.a.r0.a.e0;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.u.g;
import c.a.r0.a.k;
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
    public static final Map<String, c.a.r0.a.p.e.a> f5710b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(423209475, "Lc/a/r0/a/e0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(423209475, "Lc/a/r0/a/e0/c;");
                return;
            }
        }
        a = k.a;
        f5710b = new HashMap(2);
    }

    public static c.a.r0.a.p.e.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            boolean z = a;
            d.n(true);
            return g.U().f0().b(AppRuntime.getAppContext());
        }
        return (c.a.r0.a.p.e.a) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[Catch: all -> 0x0063, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x004d, B:20:0x0051), top: B:30:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051 A[Catch: all -> 0x0063, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x004d, B:20:0x0051), top: B:30:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized c.a.r0.a.p.e.a b() {
        InterceptResult invokeV;
        String str;
        c.a.r0.a.p.e.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (c.class) {
                c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
                if (a0 != null && !TextUtils.isEmpty(a0.getAppId())) {
                    str = a0.getAppId();
                    String a2 = c.a.r0.a.v.a.a(str);
                    aVar = f5710b.get(a2);
                    if (aVar == null) {
                        e();
                        aVar = a();
                        f5710b.put(a2, aVar);
                        if (a) {
                            String str2 = "can not find sconsole for appId - " + str;
                        }
                    }
                    if (a) {
                        String str3 = "get sconsole for appId - " + str;
                    }
                }
                str = "_no_id_";
                String a22 = c.a.r0.a.v.a.a(str);
                aVar = f5710b.get(a22);
                if (aVar == null) {
                }
                if (a) {
                }
            }
            return aVar;
        }
        return (c.a.r0.a.p.e.a) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.r0.a.d2.e a0 = c.a.r0.a.d2.e.a0();
            if (a0 != null && !TextUtils.isEmpty(a0.f5660f)) {
                return b.b(c.a.r0.a.v.a.a(a0.f5660f));
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
                if (f5710b.size() > 0) {
                    for (String str : f5710b.keySet()) {
                        c.a.r0.a.p.e.a aVar = f5710b.get(str);
                        if (aVar != null) {
                            aVar.F();
                        }
                    }
                    f5710b.clear();
                }
            }
        }
    }
}
