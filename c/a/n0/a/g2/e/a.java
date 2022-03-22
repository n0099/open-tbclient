package c.a.n0.a.g2.e;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.e2.g.h;
import c.a.n0.a.u.d;
import c.a.n0.w.f;
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
    public static C0286a f4556b;

    /* renamed from: c  reason: collision with root package name */
    public static C0286a f4557c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.n0.a.g2.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0286a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public long f4558b;

        public C0286a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static String b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 1 ? "game-core-version-code" : "swan-core-version-code" : (String) invokeI.objValue;
        }

        public static String c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i == 1 ? "game-core-version-name" : "swan-core-version-name" : (String) invokeI.objValue;
        }

        public static C0286a f(JSONObject jSONObject, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, i)) == null) {
                C0286a c0286a = new C0286a();
                if (jSONObject != null) {
                    c0286a.a = jSONObject.optString(c(i));
                    c0286a.f4558b = jSONObject.optLong(b(i));
                }
                return c0286a;
            }
            return (C0286a) invokeLI.objValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f4558b : invokeV.longValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1601741, "Lc/a/n0/a/g2/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1601741, "Lc/a/n0/a/g2/e/a;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
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

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            h.a().putString(p(i), "0");
            h.a().putLong(o(i), 0L);
        }
    }

    public static Exception c(C0286a c0286a, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, c0286a, i)) == null) {
            d.k("PresetSwanCoreControl", "doPresetUpdate.");
            if (c0286a == null) {
                return new Exception("preset swan config is null");
            }
            String h2 = h(i);
            String path = l(c0286a.d(), i).getPath();
            if (!c.a.n0.w.d.V(h2, path)) {
                Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + h2);
                d.k("PresetSwanCoreControl", "doPresetUpdate unzip failed assetExists: " + c.a.n0.a.p2.h.a(AppRuntime.getAppContext(), h2) + ";" + exc);
                boolean a2 = a(path);
                if (i == 0 && Looper.myLooper() != Looper.getMainLooper() && !c.a.n0.a.q0.d.w() && !a2) {
                    d.k("PresetSwanCoreControl", "doSwanFolderFallback:start.");
                    c.a.n0.a.q0.d.e("swan_core" + File.separator + "preset" + File.separator + c0286a.d());
                }
                return exc;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(c0286a.d()));
            c.a.n0.a.g2.b.b(j(i), arrayList);
            h.a().putLong(o(i), c0286a.d());
            h.a().putString(p(i), c0286a.e());
            if (i == 0) {
                SwanJSVersionUpdateEvent.sendEvent(c0286a.d());
            }
            v(false, i);
            if (a) {
                String b2 = f.b(new File(h(i)), false);
                if (TextUtils.isEmpty(b2)) {
                    return null;
                }
                h.a().putString(c.a.n0.a.g2.a.d(i), b2);
                return null;
            }
            return null;
        }
        return (Exception) invokeLI.objValue;
    }

    public static C0286a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (f4556b == null) {
                f4556b = C0286a.f(u(0), 0);
            }
            return f4556b;
        }
        return (C0286a) invokeV.objValue;
    }

    public static String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) ? i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json" : (String) invokeI.objValue;
    }

    public static long f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) ? h.a().getLong(o(i), 0L) : invokeI.longValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) ? h.a().getString(p(i), "0") : (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) ? i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip" : (String) invokeI.objValue;
    }

    public static C0286a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (f4557c == null) {
                f4557c = C0286a.f(u(1), 1);
            }
            return f4557c;
        }
        return (C0286a) invokeV.objValue;
    }

    public static File j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) ? new File(c.a.n0.a.g2.b.d(i), "preset") : (File) invokeI.objValue;
    }

    public static C0286a k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            if (i == 1) {
                return i();
            }
            return d();
        }
        return (C0286a) invokeI.objValue;
    }

    public static File l(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) ? new File(j(i), String.valueOf(j)) : (File) invokeCommon.objValue;
    }

    public static SwanCoreVersion m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) {
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCoreType = 0;
            swanCoreVersion.swanCoreVersionCode = f(i);
            swanCoreVersion.swanCoreVersionName = g(i);
            swanCoreVersion.swanCorePath = l(swanCoreVersion.swanCoreVersionCode, i).getPath();
            return swanCoreVersion;
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static String n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i)) == null) ? i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key" : (String) invokeI.objValue;
    }

    public static String o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) ? i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key" : (String) invokeI.objValue;
    }

    public static String p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) ? i == 1 ? "aigames_cur_preset_ver_name_key" : "aiapps_cur_preset_ver_name_key" : (String) invokeI.objValue;
    }

    public static boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i)) == null) {
            if (k(i).f4558b > 0) {
                return h.a().getBoolean(n(i), false) || !m(i).isAvailable();
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i)) == null) {
            return h.a().getBoolean(i == 1 ? "aigames_preset_checked_key" : "aiapps_preset_checked_key", false);
        }
        return invokeI.booleanValue;
    }

    public static synchronized void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, null, i) == null) {
            synchronized (a.class) {
                C0286a k = k(i);
                String h2 = h(i);
                String path = l(k.d(), i).getPath();
                boolean z = c.a.n0.w.d.z(h2, path);
                if (a) {
                    Log.d("PresetSwanCoreControl", "isZipAssetMatchUnzipResult:" + z + ",path:" + path);
                }
                if (!z) {
                    c.a.n0.a.g2.b.m(0, i, k.d());
                    c.a.n0.w.d.M(path);
                    c.a.n0.w.d.V(h2, path);
                }
            }
        }
    }

    public static synchronized Exception t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            synchronized (a.class) {
                if (a) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
                }
                if (q(i)) {
                    C0286a k = k(i);
                    long j = h.a().getLong(h(i), 0L);
                    if (a) {
                        Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + k.e());
                    }
                    return c(k, i);
                }
                return null;
            }
        }
        return (Exception) invokeI.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static JSONObject u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i)) == null) {
            if (a) {
                Log.d("PresetSwanCoreControl", "readPresetConfig start.");
            }
            String D = c.a.n0.w.d.D(AppRuntime.getAppContext(), e(i));
            if (TextUtils.isEmpty(D)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(D);
                if (a) {
                    Log.d("PresetSwanCoreControl", "readPresetConfig end. config: " + jSONObject.toString());
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

    public static void v(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            h.a().putBoolean(n(i), z);
        }
    }

    public static void w(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            h.a().putBoolean(i == 1 ? "aigames_preset_checked_key" : "aiapps_preset_checked_key", z);
        }
    }
}
