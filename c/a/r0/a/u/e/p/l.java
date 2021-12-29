package c.a.r0.a.u.e.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q0;
import com.baidu.pass.face.platform.common.ConstantHelper;
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
    public static JSONObject f9504b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(536725131, "Lc/a/r0/a/u/e/p/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(536725131, "Lc/a/r0/a/u/e/p/l;");
                return;
            }
        }
        a = c.a.r0.a.k.a;
    }

    public static JSONObject a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            boolean z = a;
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
                jSONObject.put(ConstantHelper.LOG_OS, "Android " + Build.VERSION.RELEASE);
                jSONObject.put(Constants.PARAM_PLATFORM, "android");
                jSONObject.put("fontSizeSetting", c.a.r0.a.c1.a.o().r());
                jSONObject.put("swanNativeVersion", c.a.r0.a.l.a());
                jSONObject.put("host", c.a.r0.a.c1.a.n().a());
                jSONObject.put("statusBarHeight", n0.P(n0.t()));
                jSONObject.put("navigationBarHeight", n0.P(n0.j()));
                boolean z2 = a;
                return jSONObject;
            } catch (JSONException e2) {
                if (a) {
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
                if (f9504b == null && context != null) {
                    boolean z = a;
                    f9504b = a(context);
                }
                boolean z2 = a;
                jSONObject = f9504b;
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
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 21) {
                return configuration.locale.toString();
            }
            if (i2 < 24) {
                return configuration.locale.toLanguageTag();
            }
            return configuration.getLocales().toLanguageTags();
        }
        return (String) invokeL.objValue;
    }

    public static void d(int i2) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2) == null) || (jSONObject = f9504b) == null) {
            return;
        }
        try {
            jSONObject.put("fontSizeSetting", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Nullable
    public static synchronized void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            synchronized (l.class) {
                boolean z = a;
                if (c.a.r0.a.c1.a.g0().t()) {
                    if (f9504b == null && context != null) {
                        boolean z2 = a;
                        f9504b = a(context);
                    }
                    boolean z3 = a;
                }
            }
        }
    }

    public static synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            synchronized (l.class) {
                boolean z = a;
                f9504b = null;
            }
        }
    }
}
