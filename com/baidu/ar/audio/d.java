package com.baidu.ar.audio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "d";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1725836672, "Lcom/baidu/ar/audio/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1725836672, "Lcom/baidu/ar/audio/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(byte b2, byte b3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b2), Byte.valueOf(b3)})) == null) {
            int i2 = (b2 & 255) + ((b3 & 255) << 8);
            return i2 >= 32768 ? i2 - 65535 : i2;
        }
        return invokeCommon.intValue;
    }

    public static void a(byte[] bArr, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bArr, Double.valueOf(d2)}) == null) {
            for (int i2 = 0; i2 < bArr.length; i2 += 2) {
                int i3 = i2 + 1;
                int a2 = a(bArr[i2], bArr[i3]);
                int i4 = (int) (a2 * d2);
                if (i4 < 32767 && i4 > -32768) {
                    a2 = (short) i4;
                } else if (i4 > 32767) {
                    a2 = 32767;
                } else if (i4 < -32768) {
                    a2 = -32768;
                }
                bArr[i2] = (byte) (a2 & 255);
                bArr[i3] = (byte) ((a2 >> 8) & 255);
            }
        }
    }

    public static double b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            double d2 = 0.0d;
            for (int i2 = 0; i2 < bArr.length; i2 += 2) {
                d2 += Math.abs(a(bArr[i2], bArr[i2 + 1]));
            }
            return Math.log10(((d2 / bArr.length) / 2.0d) + 1.0d) * 10.0d;
        }
        return invokeL.doubleValue;
    }

    public static double c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            double d2 = 0.0d;
            for (int i2 = 0; i2 < bArr.length; i2 += 2) {
                int a2 = a(bArr[i2], bArr[i2 + 1]);
                d2 += a2 * a2;
            }
            return Math.min(5000.0d, Math.sqrt((d2 / bArr.length) / 2.0d)) / 50.0d;
        }
        return invokeL.doubleValue;
    }
}
