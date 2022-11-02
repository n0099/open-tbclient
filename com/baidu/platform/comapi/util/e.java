package com.baidu.platform.comapi.util;

import android.graphics.Color;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int[] a(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iArr)) == null) {
            if (iArr != null && iArr.length > 0) {
                int[] iArr2 = new int[iArr.length];
                for (int i = 0; i < iArr.length; i++) {
                    iArr2[i] = Color.argb(Color.alpha(iArr[i]), Color.blue(iArr[i]), Color.green(iArr[i]), Color.red(iArr[i]));
                }
                return iArr2;
            }
            return null;
        }
        return (int[]) invokeL.objValue;
    }
}
