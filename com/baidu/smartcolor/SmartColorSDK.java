package com.baidu.smartcolor;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smartcolor.utils.Tri;
import com.baidu.tieba.tj1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes4.dex */
public class SmartColorSDK {
    public static /* synthetic */ Interceptable $ic;
    public static volatile SmartColorSDK a;
    public transient /* synthetic */ FieldHolder $fh;

    private native String getNativeSmartColor(byte[] bArr, int i, int i2, int i3, int i4, String str, String str2, int i5, int i6, int i7, int i8, long j, long j2, long j3, long j4);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-813018686, "Lcom/baidu/smartcolor/SmartColorSDK;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-813018686, "Lcom/baidu/smartcolor/SmartColorSDK;");
                return;
            }
        }
        System.loadLibrary("native-bridge");
        a = null;
    }

    public SmartColorSDK() {
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

    public static SmartColorSDK d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (a == null) {
                synchronized (SmartColorSDK.class) {
                    if (a == null) {
                        a = new SmartColorSDK();
                    }
                }
            }
            return a;
        }
        return (SmartColorSDK) invokeV.objValue;
    }

    public static int a(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65538, null, i, i2, i3, i4)) == null) {
            int i5 = 1;
            if (i2 > i3 || i > i4) {
                int i6 = i2 / 2;
                int i7 = i / 2;
                while (i6 / i5 >= i3 && i7 / i5 >= i4) {
                    i5 *= 2;
                }
            }
            return i5;
        }
        return invokeIIII.intValue;
    }

    public static int c(Tri tri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, tri)) == null) {
            if (tri == Tri.TRUE) {
                return 1;
            }
            if (tri == Tri.FALSE) {
                return 0;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public final byte[] b(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, bitmap, compressFormat, i)) == null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(compressFormat, i, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLLI.objValue;
    }

    public String e(tj1 tj1Var, Bitmap bitmap) {
        InterceptResult invokeLL;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tj1Var, bitmap)) == null) {
            if (bitmap == null || tj1Var == null) {
                return null;
            }
            if (tj1Var.h()) {
                int s = tj1Var.s();
                int p = tj1Var.p();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width == 0 || height == 0) {
                    return null;
                }
                if (s >= width && p >= height) {
                    bitmap2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    int a2 = a(width, height, s, p);
                    Matrix matrix = new Matrix();
                    float f = 1.0f / a2;
                    matrix.setScale(f, f);
                    bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                }
            } else {
                bitmap2 = null;
            }
            if (bitmap2 == null) {
                return null;
            }
            for (int i = 0; i < bitmap2.getHeight(); i++) {
                for (int i2 = 0; i2 < bitmap2.getWidth(); i2++) {
                    if (Color.alpha(bitmap2.getPixel(i2, i)) == 0) {
                        bitmap2.setPixel(i2, i, -1);
                    }
                }
            }
            byte[] b = b(bitmap2, Bitmap.CompressFormat.JPEG, 100);
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            if (b == null) {
                return null;
            }
            return f(tj1Var, b, b.length);
        }
        return (String) invokeLL.objValue;
    }

    public final String f(tj1 tj1Var, byte[] bArr, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, tj1Var, bArr, i)) == null) {
            if (bArr != null && bArr.length > 0) {
                return getNativeSmartColor(bArr, i, tj1Var.j(), tj1Var.k(), tj1Var.o(), tj1Var.v(), tj1Var.l(), c(tj1Var.m()), c(tj1Var.n()), c(tj1Var.i()), c(tj1Var.g()), tj1Var.t(), tj1Var.q(), tj1Var.u(), tj1Var.r());
            }
            return null;
        }
        return (String) invokeLLI.objValue;
    }
}
