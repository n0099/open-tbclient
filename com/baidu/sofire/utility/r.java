package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Process;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, strArr)) == null) {
            for (int i2 = 0; i2 <= 0; i2++) {
                try {
                    if (context.checkPermission(strArr[0], Process.myPid(), Process.myUid()) == -1) {
                        return false;
                    }
                } catch (Throwable unused) {
                    c.a();
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) != -1;
            } catch (Throwable unused) {
                c.a();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                return context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid()) != -1;
            } catch (Throwable unused) {
                c.a();
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
