package com.baidu.sofire.k;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class n {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return false;
            }
            int k = a.k(context);
            if (k == 1 && (i = a) != -1) {
                return i == 1;
            }
            boolean z = com.baidu.sofire.j.a.a(context).c.getBoolean("s_a_pl", false);
            boolean z2 = !a.a(context, ".ffnpp");
            if (z && !z2 && k == 1) {
                a.a(context, ".ffnpp", 0);
                z2 = true;
            }
            if (k == 1) {
                if (z2) {
                    a = 1;
                } else {
                    a = 2;
                }
            }
            return z2;
        }
        return invokeL.booleanValue;
    }
}
