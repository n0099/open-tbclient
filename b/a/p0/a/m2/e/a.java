package b.a.p0.a.m2.e;

import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.a1.e;
import b.a.p0.a.e0.d;
import b.a.p0.a.k;
import b.a.p0.a.k2.g.h;
import b.a.p0.t.f;
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
    public static final boolean f6701a;

    /* renamed from: b  reason: collision with root package name */
    public static C0293a f6702b;

    /* renamed from: c  reason: collision with root package name */
    public static C0293a f6703c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b.a.p0.a.m2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0293a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f6704a;

        /* renamed from: b  reason: collision with root package name */
        public long f6705b;

        public C0293a() {
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

        public static C0293a f(JSONObject jSONObject, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, i2)) == null) {
                C0293a c0293a = new C0293a();
                if (jSONObject != null) {
                    c0293a.f6704a = jSONObject.optString(c(i2));
                    c0293a.f6705b = jSONObject.optLong(b(i2));
                }
                return c0293a;
            }
            return (C0293a) invokeLI.objValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f6705b : invokeV.longValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.f6704a) ? "0" : this.f6704a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1797152664, "Lb/a/p0/a/m2/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1797152664, "Lb/a/p0/a/m2/e/a;");
                return;
            }
        }
        f6701a = k.f6397a;
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

    public static Exception c(C0293a c0293a, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, c0293a, i2)) == null) {
            d.h("PresetSwanCoreControl", "doPresetUpdate.");
            if (c0293a == null) {
                return new Exception("preset swan config is null");
            }
            String h2 = h(i2);
            String path = l(c0293a.d(), i2).getPath();
            if (!b.a.p0.t.d.U(h2, path)) {
                Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + h2);
                d.h("PresetSwanCoreControl", "doPresetUpdate unzip failed assetExists: " + b.a.p0.a.v2.h.a(AppRuntime.getAppContext(), h2) + ";" + exc);
                boolean a2 = a(path);
                if (i2 == 0 && Looper.myLooper() != Looper.getMainLooper() && !e.w() && !a2) {
                    d.h("PresetSwanCoreControl", "doSwanFolderFallback:start.");
                    e.e("swan_core" + File.separator + "preset" + File.separator + c0293a.d());
                }
                return exc;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(c0293a.d()));
            b.a.p0.a.m2.b.b(j(i2), arrayList);
            h.a().putLong(o(i2), c0293a.d());
            h.a().putString(p(i2), c0293a.e());
            if (i2 == 0) {
                SwanJSVersionUpdateEvent.sendEvent(c0293a.d());
            }
            v(false, i2);
            if (f6701a) {
                String b2 = f.b(new File(h(i2)), false);
                if (TextUtils.isEmpty(b2)) {
                    return null;
                }
                h.a().putString(b.a.p0.a.m2.a.d(i2), b2);
                return null;
            }
            return null;
        }
        return (Exception) invokeLI.objValue;
    }

    public static C0293a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f6702b == null) {
                f6702b = C0293a.f(u(0), 0);
            }
            return f6702b;
        }
        return (C0293a) invokeV.objValue;
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

    public static C0293a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f6703c == null) {
                f6703c = C0293a.f(u(1), 1);
            }
            return f6703c;
        }
        return (C0293a) invokeV.objValue;
    }

    public static File j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? new File(b.a.p0.a.m2.b.d(i2), "preset") : (File) invokeI.objValue;
    }

    public static C0293a k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            if (i2 == 1) {
                return i();
            }
            return d();
        }
        return (C0293a) invokeI.objValue;
    }

    public static File l(long j, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) ? new File(j(i2), String.valueOf(j)) : (File) invokeCommon.objValue;
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
            if (k(i2).f6705b > 0) {
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
                C0293a k = k(i2);
                String h2 = h(i2);
                String path = l(k.d(), i2).getPath();
                boolean y = b.a.p0.t.d.y(h2, path);
                if (f6701a) {
                    String str = "isZipAssetMatchUnzipResult:" + y + ",path:" + path;
                }
                if (!y) {
                    b.a.p0.a.m2.b.m(0, i2, k.d());
                    b.a.p0.t.d.L(path);
                    b.a.p0.t.d.U(h2, path);
                }
            }
        }
    }

    public static synchronized Exception t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) {
            synchronized (a.class) {
                boolean z = f6701a;
                if (q(i2)) {
                    C0293a k = k(i2);
                    long j = h.a().getLong(h(i2), 0L);
                    if (f6701a) {
                        String str = "onPresetUpdate curVer: " + j + " newVer: " + k.e();
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
            boolean z = f6701a;
            String C = b.a.p0.t.d.C(AppRuntime.getAppContext(), e(i2));
            if (TextUtils.isEmpty(C)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(C);
                if (f6701a) {
                    String str = "readPresetConfig end. config: " + jSONObject.toString();
                }
                return jSONObject;
            } catch (JSONException e2) {
                if (f6701a) {
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
