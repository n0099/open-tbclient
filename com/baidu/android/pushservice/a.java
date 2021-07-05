package com.baidu.android.pushservice;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? context.getSharedPreferences("pst", 4).getString("s_e", "default") : (String) invokeL.objValue;
    }

    public static short a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return (short) 119;
        }
        return invokeV.shortValue;
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pst", 4);
            String str = z ? SapiOptions.KEY_CACHE_ENABLED : "disabled";
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("s_e", str);
            edit.commit();
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? "com.baidu.searchbox".equals(str) || "com.baidu.BaiduMap".equals(str) || BdSailorPlatform.LITE_PACKAGE_NAME.equals(str) || "com.baidu.haokan".equals(str) || "com.baidu.minivideo".equals(str) || "com.baidu.push.qa".equals(str) || "com.baidu.push.salon".equals(str) : invokeL.booleanValue;
    }
}
