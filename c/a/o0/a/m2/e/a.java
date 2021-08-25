package c.a.o0.a.m2.e;

import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.a1.e;
import c.a.o0.a.e0.d;
import c.a.o0.a.k;
import c.a.o0.a.k2.g.h;
import c.a.o0.t.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f7356a;

    /* renamed from: b  reason: collision with root package name */
    public static C0296a f7357b;

    /* renamed from: c  reason: collision with root package name */
    public static C0296a f7358c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.m2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0296a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f7359a;

        /* renamed from: b  reason: collision with root package name */
        public long f7360b;

        public C0296a() {
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

        public static String b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? i2 == 1 ? "game-core-version-code" : "swan-core-version-code" : (String) invokeI.objValue;
        }

        public static String c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 == 1 ? "game-core-version-name" : "swan-core-version-name" : (String) invokeI.objValue;
        }

        public static C0296a f(JSONObject jSONObject, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, i2)) == null) {
                C0296a c0296a = new C0296a();
                if (jSONObject != null) {
                    c0296a.f7359a = jSONObject.optString(c(i2));
                    c0296a.f7360b = jSONObject.optLong(b(i2));
                }
                return c0296a;
            }
            return (C0296a) invokeLI.objValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f7360b : invokeV.longValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.f7359a) ? "0" : this.f7359a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1157535768, "Lc/a/o0/a/m2/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1157535768, "Lc/a/o0/a/m2/e/a;");
                return;
            }
        }
        f7356a = k.f7049a;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            d.h("PresetSwanCoreControl", "canPresetFolderWrite presetSavePath=" + str);
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                d.h("PresetSwanCoreControl", "canPresetFolderWrite mkdirs fail");
                return false;
            }
            boolean canWrite = file.canWrite();
            d.h("PresetSwanCoreControl", "canPresetFolderWrite canWrite=" + canWrite);
            return canWrite;
        }
        return invokeL.booleanValue;
    }

    public static void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            h.a().putString(p(i2), "0");
            h.a().putLong(o(i2), 0L);
        }
    }

    public static Exception c(C0296a c0296a, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, c0296a, i2)) == null) {
            d.h("PresetSwanCoreControl", "doPresetUpdate.");
            if (c0296a == null) {
                return new Exception("preset swan config is null");
            }
            String h2 = h(i2);
            String path = l(c0296a.d(), i2).getPath();
            if (!c.a.o0.t.d.U(h2, path)) {
                Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + h2);
                d.h("PresetSwanCoreControl", "doPresetUpdate unzip failed assetExists: " + c.a.o0.a.v2.h.a(AppRuntime.getAppContext(), h2) + ";" + exc);
                boolean a2 = a(path);
                if (i2 == 0 && Looper.myLooper() != Looper.getMainLooper() && !e.w() && !a2) {
                    d.h("PresetSwanCoreControl", "doSwanFolderFallback:start.");
                    e.e("swan_core" + File.separator + "preset" + File.separator + c0296a.d());
                }
                return exc;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(c0296a.d()));
            c.a.o0.a.m2.b.b(j(i2), arrayList);
            h.a().putLong(o(i2), c0296a.d());
            h.a().putString(p(i2), c0296a.e());
            if (i2 == 0) {
                SwanJSVersionUpdateEvent.sendEvent(c0296a.d());
            }
            v(false, i2);
            if (f7356a) {
                String b2 = f.b(new File(h(i2)), false);
                if (TextUtils.isEmpty(b2)) {
                    return null;
                }
                h.a().putString(c.a.o0.a.m2.a.d(i2), b2);
                return null;
            }
            return null;
        }
        return (Exception) invokeLI.objValue;
    }

    public static C0296a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f7357b == null) {
                f7357b = C0296a.f(u(0), 0);
            }
            return f7357b;
        }
        return (C0296a) invokeV.objValue;
    }

    public static String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? i2 == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json" : (String) invokeI.objValue;
    }

    public static long f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? h.a().getLong(o(i2), 0L) : invokeI.longValue;
    }

    public static String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? h.a().getString(p(i2), "0") : (String) invokeI.objValue;
    }

    public static String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) ? i2 == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip" : (String) invokeI.objValue;
    }

    public static C0296a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f7358c == null) {
                f7358c = C0296a.f(u(1), 1);
            }
            return f7358c;
        }
        return (C0296a) invokeV.objValue;
    }

    public static File j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? new File(c.a.o0.a.m2.b.d(i2), "preset") : (File) invokeI.objValue;
    }

    public static C0296a k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            if (i2 == 1) {
                return i();
            }
            return d();
        }
        return (C0296a) invokeI.objValue;
    }

    public static File l(long j2, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j2), Integer.valueOf(i2)})) == null) ? new File(j(i2), String.valueOf(j2)) : (File) invokeCommon.objValue;
    }

    public static SwanCoreVersion m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) {
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCoreType = 0;
            swanCoreVersion.swanCoreVersionCode = f(i2);
            swanCoreVersion.swanCoreVersionName = g(i2);
            swanCoreVersion.swanCorePath = l(swanCoreVersion.swanCoreVersionCode, i2).getPath();
            return swanCoreVersion;
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static String n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) ? i2 == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key" : (String) invokeI.objValue;
    }

    public static String o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i2)) == null) ? i2 == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key" : (String) invokeI.objValue;
    }

    public static String p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i2)) == null) ? i2 == 1 ? "aigames_cur_preset_ver_name_key" : "aiapps_cur_preset_ver_name_key" : (String) invokeI.objValue;
    }

    public static boolean q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i2)) == null) {
            if (k(i2).f7360b > 0) {
                return h.a().getBoolean(n(i2), false) || !m(i2).isAvailable();
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) {
            return h.a().getBoolean(i2 == 1 ? "aigames_preset_checked_key" : "aiapps_preset_checked_key", false);
        }
        return invokeI.booleanValue;
    }

    public static synchronized void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, null, i2) == null) {
            synchronized (a.class) {
                C0296a k = k(i2);
                String h2 = h(i2);
                String path = l(k.d(), i2).getPath();
                boolean y = c.a.o0.t.d.y(h2, path);
                if (f7356a) {
                    String str = "isZipAssetMatchUnzipResult:" + y + ",path:" + path;
                }
                if (!y) {
                    c.a.o0.a.m2.b.m(0, i2, k.d());
                    c.a.o0.t.d.L(path);
                    c.a.o0.t.d.U(h2, path);
                }
            }
        }
    }

    public static synchronized Exception t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) {
            synchronized (a.class) {
                boolean z = f7356a;
                if (q(i2)) {
                    C0296a k = k(i2);
                    long j2 = h.a().getLong(h(i2), 0L);
                    if (f7356a) {
                        String str = "onPresetUpdate curVer: " + j2 + " newVer: " + k.e();
                    }
                    return c(k, i2);
                }
                return null;
            }
        }
        return (Exception) invokeI.objValue;
    }

    public static JSONObject u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i2)) == null) {
            boolean z = f7356a;
            String C = c.a.o0.t.d.C(AppRuntime.getAppContext(), e(i2));
            if (TextUtils.isEmpty(C)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(C);
                if (f7356a) {
                    String str = "readPresetConfig end. config: " + jSONObject.toString();
                }
                return jSONObject;
            } catch (JSONException e2) {
                if (f7356a) {
                    throw new RuntimeException(e2);
                }
                return null;
            }
        }
        return (JSONObject) invokeI.objValue;
    }

    public static void v(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            h.a().putBoolean(n(i2), z);
        }
    }

    public static void w(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            h.a().putBoolean(i2 == 1 ? "aigames_preset_checked_key" : "aiapps_preset_checked_key", z);
        }
    }
}
