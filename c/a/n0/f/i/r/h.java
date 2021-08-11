package c.a.n0.f.i.r;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static DisplayMetrics f10414a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65536, null, f2)) == null) ? (int) (f2 * d(AppRuntime.getAppContext())) : invokeF.intValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String substring = new a().a(String.valueOf(System.currentTimeMillis())).substring(4, 14);
            String c2 = c.a.n0.f.i.m.a.b().c();
            return "38" + substring + c2.substring(0, 4);
        }
        return (String) invokeV.objValue;
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(";");
                int length = split.length;
                for (int i2 = 0; i2 != length; i2++) {
                    String trim = split[i2].trim();
                    String[] split2 = trim.split("=");
                    if (split2.length >= 2 && TextUtils.equals(str2, split2[0])) {
                        if (split2.length == 2) {
                            return split2[1];
                        }
                        return trim.substring(split2[0].length() + 1);
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static float d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            n(AppRuntime.getAppContext());
            DisplayMetrics displayMetrics = f10414a;
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }
        return invokeL.floatValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String str = Build.MODEL;
            return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            String str = Build.VERSION.RELEASE;
            return TextUtils.isEmpty(str) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str.replace("_", "-");
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            String str = Build.MANUFACTURER;
            return TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
        }
        return (String) invokeV.objValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            n(AppRuntime.getAppContext());
            DisplayMetrics displayMetrics = f10414a;
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int i(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            n(AppRuntime.getAppContext());
            DisplayMetrics displayMetrics = f10414a;
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()) : (String) invokeV.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? AppRuntime.getAppContext().getPackageName() : (String) invokeV.objValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            try {
                Context appContext = AppRuntime.getAppContext();
                return appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? Build.VERSION.SDK_INT >= 24 : invokeV.booleanValue;
    }

    public static void n(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, context) == null) && f10414a == null) {
            Context appContext = AppRuntime.getAppContext();
            if (appContext != null) {
                context = appContext;
            }
            if (context == null) {
                return;
            }
            f10414a = context.getResources().getDisplayMetrics();
        }
    }

    public static boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) ? TextUtils.equals(BaseWebViewActivity.SHOUBAI_SCHEME, c.a.n0.f.i.m.a.b().a()) : invokeV.booleanValue;
    }

    public static int p(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65551, null, f2)) == null) ? (int) (f2 / d(AppRuntime.getAppContext())) : invokeF.intValue;
    }
}
