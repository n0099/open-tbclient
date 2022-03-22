package c.a.n0.a.k.e.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.tencent.connect.common.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f5269b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1462102993, "Lc/a/n0/a/k/e/p/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1462102993, "Lc/a/n0/a/k/e/p/l;");
                return;
            }
        }
        a = c.a.n0.a.a.a;
    }

    public static JSONObject a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a) {
                Log.d("SystemInfoCacheHelper", "start create System Info");
            }
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            windowManager.getDefaultDisplay().getSize(new Point());
            windowManager.getDefaultDisplay().getRectSize(new Rect());
            Configuration configuration = context.getResources().getConfiguration();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("brand", Build.BRAND);
                jSONObject.put("model", Build.MODEL);
                jSONObject.put("pixelRatio", displayMetrics.density);
                jSONObject.put("devicePixelRatio", displayMetrics.density);
                jSONObject.put("language", c(configuration));
                jSONObject.put("version", q0.D());
                jSONObject.put("system", "Android " + Build.VERSION.RELEASE);
                jSONObject.put(Constants.PARAM_PLATFORM, "android");
                jSONObject.put("fontSizeSetting", c.a.n0.a.s0.a.o().r());
                jSONObject.put("swanNativeVersion", c.a.n0.a.b.a());
                jSONObject.put("host", c.a.n0.a.s0.a.n().a());
                jSONObject.put("statusBarHeight", n0.O(n0.t()));
                jSONObject.put("navigationBarHeight", n0.O(n0.j()));
                if (a) {
                    Log.d("SystemInfoCacheHelper", "end create System Info");
                }
                return jSONObject;
            } catch (JSONException e2) {
                if (a) {
                    Log.d("SystemInfoCacheHelper", "crate system info error : ");
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @Nullable
    public static synchronized JSONObject b(Context context) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            synchronized (l.class) {
                if (f5269b == null && context != null) {
                    if (a) {
                        Log.d("SystemInfoCacheHelper", "need create system info");
                    }
                    f5269b = a(context);
                }
                if (a) {
                    Log.d("SystemInfoCacheHelper", "return cache system info");
                }
                jSONObject = f5269b;
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static String c(Configuration configuration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, configuration)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i < 21) {
                return configuration.locale.toString();
            }
            if (i < 24) {
                return configuration.locale.toLanguageTag();
            }
            return configuration.getLocales().toLanguageTags();
        }
        return (String) invokeL.objValue;
    }

    public static void d(int i) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i) == null) || (jSONObject = f5269b) == null) {
            return;
        }
        try {
            jSONObject.put("fontSizeSetting", i);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Nullable
    public static synchronized void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            synchronized (l.class) {
                if (a) {
                    Log.d("SystemInfoCacheHelper", "start pre cache system info");
                }
                if (c.a.n0.a.s0.a.g0().t()) {
                    if (f5269b == null && context != null) {
                        if (a) {
                            Log.d("SystemInfoCacheHelper", "need create system info");
                        }
                        f5269b = a(context);
                    }
                    if (a) {
                        Log.d("SystemInfoCacheHelper", "end pre cache system info");
                    }
                }
            }
        }
    }

    public static synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            synchronized (l.class) {
                if (a) {
                    Log.d("SystemInfoCacheHelper", "release cache system info");
                }
                f5269b = null;
            }
        }
    }
}
