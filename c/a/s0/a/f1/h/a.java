package c.a.s0.a.f1.h;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.a1.d;
import c.a.s0.a.h0.m.f;
import c.a.s0.a.k;
import c.a.s0.a.z2.g1.c;
import c.a.s0.a.z2.o0;
import c.a.s0.q.j.m.d;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.FlushManager;
import java.io.File;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.s0.a.f1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0341a implements c<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0341a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) && pMSAppInfo != null && pMSAppInfo.isForbiddenApp()) {
                c.a.s0.a.f2.f.f0.a.K(pMSAppInfo.appKey, pMSAppInfo.appStatus);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // c.a.s0.q.f.i, c.a.s0.q.f.f
        public void n(String str, String str2) {
            List<UbcFlowEvent> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
                super.n(str, str2);
                if (TextUtils.isEmpty(str2) || !TextUtils.equals(str, "770") || (list = this.t) == null) {
                    return;
                }
                list.add(new UbcFlowEvent(str2));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-272231605, "Lc/a/s0/a/f1/h/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-272231605, "Lc/a/s0/a/f1/h/a;");
                return;
            }
        }
        a = k.a;
    }

    public static void a(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bundle) == null) {
            boolean z = a;
            String string = bundle.getString("mAppId");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            int i2 = bundle.getInt("appFrameType");
            if (1 != i2) {
                i2 = 0;
            }
            d dVar = new d(string, i2);
            if (bundle.containsKey("pms_update_expect_pkg_ver")) {
                dVar.q(bundle.getLong("pms_update_expect_pkg_ver"));
            }
            if (a) {
                String.format(Locale.getDefault(), "asyncUpdatePkg: swanAsyncUpdate -> 异步更新 appid=%s frameType=%d expectVer=%d", string, Integer.valueOf(i2), Long.valueOf(dVar.i()));
            }
            dVar.d("4");
            b bVar = new b(string);
            bVar.f0(new C0341a());
            bVar.M(3);
            c.a.s0.q.b.c(dVar, bVar);
        }
    }

    public static boolean b(@Nullable PMSAppInfo pMSAppInfo, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, pMSAppInfo, bundle)) == null) {
            boolean z = false;
            if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                long j2 = pMSAppInfo.versionCode;
                if (j2 == 0 || bundle == null || pMSAppInfo.appCategory == 1) {
                    return false;
                }
                File i2 = d.e.i(pMSAppInfo.appId, String.valueOf(j2));
                if (i2.exists()) {
                    String string = bundle.getString("mPage");
                    if (TextUtils.isEmpty(string)) {
                        boolean exists = new File(i2, "app.json").exists();
                        c.a.s0.a.e0.d.k("SwanAppLaunchUtils", "checkSwanAppPageDirExist app.json exists: " + exists);
                        return exists;
                    }
                    String g2 = o0.g(string);
                    int lastIndexOf = g2.lastIndexOf(File.separator);
                    if (lastIndexOf >= 0) {
                        g2 = g2.substring(0, lastIndexOf);
                    }
                    boolean exists2 = new File(i2, g2).exists();
                    if (exists2) {
                        if (new File(i2, "app.json").exists()) {
                            return System.currentTimeMillis() - new File(i2, g2).lastModified() > FlushManager.ReportTimer.DEFAULT_INTERVAL;
                        }
                        int lastIndexOf2 = g2.lastIndexOf(File.separator);
                        while (true) {
                            if (lastIndexOf2 < 0) {
                                break;
                            }
                            g2 = g2.substring(0, lastIndexOf2);
                            if (new File(i2, g2 + File.separator + "app.json").exists()) {
                                z = true;
                                break;
                            }
                            lastIndexOf2 = g2.lastIndexOf(File.separator);
                        }
                        if (a) {
                            String str = "isInDependentPkg=" + z + ", pagePath=" + g2;
                        }
                        if (z && !TextUtils.isEmpty(g2)) {
                            bundle.putBoolean("swan_app_independent", true);
                            bundle.putString("swan_app_sub_root_path", g2);
                        }
                    }
                    return exists2;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String c(PMSAppInfo pMSAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, pMSAppInfo, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String g2 = o0.g(str);
            int lastIndexOf = g2.lastIndexOf(File.separator);
            while (lastIndexOf != -1) {
                g2 = g2.substring(0, lastIndexOf);
                if (c.a.s0.a.a1.d.B(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g2)) {
                    return g2;
                }
                lastIndexOf = g2.lastIndexOf(File.separator);
            }
            return c.a.s0.a.a1.d.B(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g2) ? g2 : "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean d(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return e(c.a.s0.q.g.a.i().u(str));
        }
        return invokeL.booleanValue;
    }

    public static boolean e(@Nullable PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId)) {
                long j2 = pMSAppInfo.versionCode;
                if (j2 != 0) {
                    if (pMSAppInfo.appCategory == 1) {
                        File a2 = c.a.s0.a.c1.b.g().a(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode));
                        if (a2 != null) {
                            return a2.exists();
                        }
                        return false;
                    }
                    return c.a.s0.a.a1.d.z(d.e.i(pMSAppInfo.appId, String.valueOf(j2)));
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(PMSAppInfo pMSAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, pMSAppInfo, str)) == null) {
            if (pMSAppInfo == null || TextUtils.isEmpty(str)) {
                return false;
            }
            String g2 = o0.g(str);
            if (g2.lastIndexOf(File.separator) != -1) {
                g2 = g2.substring(0, g2.lastIndexOf(File.separator));
            }
            return c.a.s0.a.a1.d.p(pMSAppInfo.appId, String.valueOf(pMSAppInfo.versionCode), g2).exists();
        }
        return invokeLL.booleanValue;
    }
}
