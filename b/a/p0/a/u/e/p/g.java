package b.a.p0.a.u.e.p;

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
import b.a.p0.a.k;
import b.a.p0.a.l;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
import com.baidu.mobads.container.util.AdIconUtil;
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
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f8393a;

    /* renamed from: b  reason: collision with root package name */
    public static JSONObject f8394b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-229778707, "Lb/a/p0/a/u/e/p/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-229778707, "Lb/a/p0/a/u/e/p/g;");
                return;
            }
        }
        f8393a = k.f6397a;
    }

    public static JSONObject a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            boolean z = f8393a;
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
                jSONObject.put("fontSizeSetting", b.a.p0.a.c1.a.n().q());
                jSONObject.put("swanNativeVersion", l.a());
                jSONObject.put("host", b.a.p0.a.c1.a.m().a());
                jSONObject.put("statusBarHeight", n0.L(n0.u()));
                jSONObject.put("navigationBarHeight", n0.L(n0.j()));
                boolean z2 = f8393a;
                return jSONObject;
            } catch (JSONException e2) {
                if (f8393a) {
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
            synchronized (g.class) {
                if (f8394b == null && context != null) {
                    boolean z = f8393a;
                    f8394b = a(context);
                }
                boolean z2 = f8393a;
                jSONObject = f8394b;
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

    @Nullable
    public static synchronized void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            synchronized (g.class) {
                boolean z = f8393a;
                if (b.a.p0.a.c1.a.Z().v()) {
                    if (f8394b == null && context != null) {
                        boolean z2 = f8393a;
                        f8394b = a(context);
                    }
                    boolean z3 = f8393a;
                }
            }
        }
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (g.class) {
                boolean z = f8393a;
                f8394b = null;
            }
        }
    }
}
