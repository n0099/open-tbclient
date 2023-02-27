package com.baidu.sofire.k;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class v {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            try {
                a = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
            } catch (Throwable unused) {
                int i = com.baidu.sofire.a.b.a;
            }
            return a;
        }
        return (String) invokeL.objValue;
    }
}
