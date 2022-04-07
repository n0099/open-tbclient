package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SharedPreferences a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? context.getSharedPreferences(b(context), 0) : (SharedPreferences) invokeL.objValue;
    }

    public static void a(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, context, str, i) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(context).edit().putInt(str, i).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, str, str2) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(context).edit().putString(str, str2).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int b(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, str, i)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    return a(context).getInt(str, i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return i;
        }
        return invokeLLI.intValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? "ct_account_api_sdk" : (String) invokeL.objValue;
    }

    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, context, str, str2)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    return a(context).getString(str, str2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return str2;
        }
        return (String) invokeLLL.objValue;
    }
}
