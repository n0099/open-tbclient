package com.baidu.sofire.k;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class r {
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
            int j = b.j(context);
            if (j == 1 && (i = a) != -1) {
                if (i != 1) {
                    return false;
                }
                return true;
            }
            boolean z = com.baidu.sofire.j.a.a(context).c.getBoolean("s_a_pl", false);
            boolean z2 = !b.a(context, ".ffnpp");
            if (z && !z2 && j == 1) {
                b.a(context, ".ffnpp", 0);
                z2 = true;
            }
            if (j == 1) {
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
