package c.e.b.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.core.utils.LogUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f32226a;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(String str, String str2) {
        InterceptResult invokeLL;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            long j3 = -1;
            try {
                j2 = simpleDateFormat.parse(str2).getTime() - simpleDateFormat.parse(str).getTime();
                try {
                    j3 = j2 / 86400000;
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                j2 = -1;
            }
            LogUtil.d("date", "before = " + str + " ; current = " + str2 + " ; diff = " + j2 + " ; days = " + j3);
            return j3;
        }
        return invokeLL.longValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return "sdk_market_polling" + str + "count";
        }
        return (String) invokeL.objValue;
    }

    public static void c(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, context, str, i2) == null) {
            h(context, b(str), i(context, b(str), 0) + 1);
            d(context, g(str), new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            h(context, j(str), i2);
        }
    }

    public static void d(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f32226a == null) {
            f32226a = DxmApplicationContextImpl.getApplicationContext(context).getSharedPreferences("pop_window_sign_record", 0);
        }
        SharedPreferences.Editor edit = f32226a.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static boolean e(Context context, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, i2, i3)) == null) {
            boolean z = i(context, b(str), 0) < i2;
            String f2 = f(context, g(str), "");
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            long a2 = a(f2, format);
            LogUtil.d("date", "before = " + f2 + " ; current = " + format);
            return z && ((a2 > (-1L) ? 1 : (a2 == (-1L) ? 0 : -1)) == 0 || (a(f2, format) > ((long) i(context, j(str), 1)) ? 1 : (a(f2, format) == ((long) i(context, j(str), 1)) ? 0 : -1)) >= 0);
        }
        return invokeLLII.booleanValue;
    }

    public static String f(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (f32226a == null) {
                f32226a = DxmApplicationContextImpl.getApplicationContext(context).getSharedPreferences("pop_window_sign_record", 0);
            }
            return f32226a.getString(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            return "sdk_market_polling" + str + "time";
        }
        return (String) invokeL.objValue;
    }

    public static void h(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65543, null, context, str, i2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (f32226a == null) {
            f32226a = DxmApplicationContextImpl.getApplicationContext(context).getSharedPreferences("pop_window_sign_record", 0);
        }
        SharedPreferences.Editor edit = f32226a.edit();
        edit.putInt(str, i2);
        edit.commit();
    }

    public static int i(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, context, str, i2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (f32226a == null) {
                f32226a = DxmApplicationContextImpl.getApplicationContext(context).getSharedPreferences("pop_window_sign_record", 0);
            }
            return f32226a.getInt(str, i2);
        }
        return invokeLLI.intValue;
    }

    public static String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            return "sdk_market_polling" + str + "interval_count";
        }
        return (String) invokeL.objValue;
    }
}
