package com.baidu.ar.auth;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long[] a(int i2, long j) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (j < 50) {
                j = 50;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i4 = 0;
            while (true) {
                i3 = (currentTimeMillis > 946656000000L ? 1 : (currentTimeMillis == 946656000000L ? 0 : -1));
                if (i3 >= 0) {
                    break;
                }
                int i5 = i4 + 1;
                if (i4 >= i2) {
                    break;
                }
                try {
                    Thread.currentThread();
                    Thread.sleep(j);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                currentTimeMillis = System.currentTimeMillis();
                i4 = i5;
            }
            long[] jArr = new long[2];
            jArr[0] = i3 < 0 ? 0 : 1;
            jArr[1] = currentTimeMillis;
            return jArr;
        }
        return (long[]) invokeCommon.objValue;
    }
}
