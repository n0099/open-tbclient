package cn.com.chinatelecom.gateway.lib.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65536, null, context, str, i) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            context.getSharedPreferences("ct_account_api_sdk", 0).edit().putInt(str, i).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, context, str, str2) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            context.getSharedPreferences("ct_account_api_sdk", 0).edit().putString(str, str2).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int b(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, context, str, i)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    return context.getSharedPreferences("ct_account_api_sdk", 0).getInt(str, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 0;
        }
        return invokeLLI.intValue;
    }

    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, context, str, str2)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    return context.getSharedPreferences("ct_account_api_sdk", 0).getString(str, str2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return str2;
        }
        return (String) invokeLLL.objValue;
    }
}
