package com.baidu.ar.audio;

import androidx.core.view.InputDeviceCompat;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(byte b, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b), Byte.valueOf(b2)})) == null) {
            int i = (b & 255) + ((b2 & 255) << 8);
            return i >= 32768 ? i - 65535 : i;
        }
        return invokeCommon.intValue;
    }

    public static void a(byte[] bArr, double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{bArr, Double.valueOf(d)}) == null) {
            for (int i = 0; i < bArr.length; i += 2) {
                int i2 = i + 1;
                int a = a(bArr[i], bArr[i2]);
                int i3 = (int) (a * d);
                if (i3 < 32767 && i3 > -32768) {
                    a = (short) i3;
                } else if (i3 > 32767) {
                    a = 32767;
                } else if (i3 < -32768) {
                    a = -32768;
                }
                bArr[i] = (byte) (a & 255);
                bArr[i2] = (byte) ((a >> 8) & 255);
            }
        }
    }

    public static double b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            double d = 0.0d;
            for (int i = 0; i < bArr.length; i += 2) {
                d += Math.abs(a(bArr[i], bArr[i + 1]));
            }
            return Math.log10(((d / bArr.length) / 2.0d) + 1.0d) * 10.0d;
        }
        return invokeL.doubleValue;
    }

    public static double c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            double d = 0.0d;
            for (int i = 0; i < bArr.length; i += 2) {
                int a = a(bArr[i], bArr[i + 1]);
                d += a * a;
            }
            return Math.min(5000.0d, Math.sqrt((d / bArr.length) / 2.0d)) / 50.0d;
        }
        return invokeL.doubleValue;
    }
}
