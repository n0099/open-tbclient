package c.a.r0.a.q2.e;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.e0.d;
import c.a.r0.a.k;
import c.a.r0.a.o2.g.h;
import c.a.r0.w.f;
import com.baidu.android.imsdk.internal.Constants;
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
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static C0512a f8602b;

    /* renamed from: c  reason: collision with root package name */
    public static C0512a f8603c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.q2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0512a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public long f8604b;

        public C0512a() {
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

        public static C0512a f(JSONObject jSONObject, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, i2)) == null) {
                C0512a c0512a = new C0512a();
                if (jSONObject != null) {
                    c0512a.a = jSONObject.optString(c(i2));
                    c0512a.f8604b = jSONObject.optLong(b(i2));
                }
                return c0512a;
            }
            return (C0512a) invokeLI.objValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f8604b : invokeV.longValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.a) ? "0" : this.a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(799831353, "Lc/a/r0/a/q2/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(799831353, "Lc/a/r0/a/q2/e/a;");
                return;
            }
        }
        a = k.a;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            d.k("PresetSwanCoreControl", "canPresetFolderWrite presetSavePath=" + str);
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                d.k("PresetSwanCoreControl", "canPresetFolderWrite mkdirs fail");
                return false;
            }
            boolean canWrite = file.canWrite();
            d.k("PresetSwanCoreControl", "canPresetFolderWrite canWrite=" + canWrite);
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

    public static Exception c(C0512a c0512a, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, c0512a, i2)) == null) {
            d.k("PresetSwanCoreControl", "doPresetUpdate.");
            if (c0512a == null) {
                return new Exception("preset swan config is null");
            }
            String h2 = h(i2);
            String path = l(c0512a.d(), i2).getPath();
            if (!c.a.r0.w.d.V(h2, path)) {
                Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + h2);
                d.k("PresetSwanCoreControl", "doPresetUpdate unzip failed assetExists: " + c.a.r0.a.z2.h.a(AppRuntime.getAppContext(), h2) + ";" + exc);
                boolean a2 = a(path);
                if (i2 == 0 && Looper.myLooper() != Looper.getMainLooper() && !c.a.r0.a.a1.d.w() && !a2) {
                    d.k("PresetSwanCoreControl", "doSwanFolderFallback:start.");
                    c.a.r0.a.a1.d.e("swan_core" + File.separator + "preset" + File.separator + c0512a.d());
                }
                return exc;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(c0512a.d()));
            c.a.r0.a.q2.b.b(j(i2), arrayList);
            h.a().putLong(o(i2), c0512a.d());
            h.a().putString(p(i2), c0512a.e());
            if (i2 == 0) {
                SwanJSVersionUpdateEvent.sendEvent(c0512a.d());
            }
            v(false, i2);
            if (a) {
                String b2 = f.b(new File(h(i2)), false);
                if (TextUtils.isEmpty(b2)) {
                    return null;
                }
                h.a().putString(c.a.r0.a.q2.a.d(i2), b2);
                return null;
            }
            return null;
        }
        return (Exception) invokeLI.objValue;
    }

    public static C0512a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f8602b == null) {
                f8602b = C0512a.f(u(0), 0);
            }
            return f8602b;
        }
        return (C0512a) invokeV.objValue;
    }

    public static String e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) ? i2 == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json" : (String) invokeI.objValue;
    }

    public static long f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i2)) == null) ? h.a().getLong(o(i2), 0L) : invokeI.longValue;
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

    public static C0512a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f8603c == null) {
                f8603c = C0512a.f(u(1), 1);
            }
            return f8603c;
        }
        return (C0512a) invokeV.objValue;
    }

    public static File j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? new File(c.a.r0.a.q2.b.d(i2), "preset") : (File) invokeI.objValue;
    }

    public static C0512a k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i2)) == null) {
            if (i2 == 1) {
                return i();
            }
            return d();
        }
        return (C0512a) invokeI.objValue;
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
            if (k(i2).f8604b > 0) {
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
                C0512a k2 = k(i2);
                String h2 = h(i2);
                String path = l(k2.d(), i2).getPath();
                boolean z = c.a.r0.w.d.z(h2, path);
                if (a) {
                    String str = "isZipAssetMatchUnzipResult:" + z + ",path:" + path;
                }
                if (!z) {
                    c.a.r0.a.q2.b.m(0, i2, k2.d());
                    c.a.r0.w.d.M(path);
                    c.a.r0.w.d.V(h2, path);
                }
            }
        }
    }

    public static synchronized Exception t(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i2)) == null) {
            synchronized (a.class) {
                boolean z = a;
                if (q(i2)) {
                    C0512a k2 = k(i2);
                    long j2 = h.a().getLong(h(i2), 0L);
                    if (a) {
                        String str = "onPresetUpdate curVer: " + j2 + " newVer: " + k2.e();
                    }
                    return c(k2, i2);
                }
                return null;
            }
        }
        return (Exception) invokeI.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static JSONObject u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i2)) == null) {
            boolean z = a;
            String D = c.a.r0.w.d.D(AppRuntime.getAppContext(), e(i2));
            if (TextUtils.isEmpty(D)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(D);
                if (a) {
                    String str = "readPresetConfig end. config: " + jSONObject.toString();
                }
                return jSONObject;
            } catch (JSONException e2) {
                if (a) {
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
