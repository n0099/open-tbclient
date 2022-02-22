package com.baidu.smartcolor;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.smartcolor.utils.Tri;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes11.dex */
public class SmartColorSDK {
    public static /* synthetic */ Interceptable $ic;
    public static volatile SmartColorSDK a;
    public transient /* synthetic */ FieldHolder $fh;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static int a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65538, null, i2, i3, i4, i5)) == null) {
            int i6 = 1;
            if (i3 > i4 || i2 > i5) {
                int i7 = i3 / 2;
                int i8 = i2 / 2;
                while (i7 / i6 >= i4 && i8 / i6 >= i5) {
                    i6 *= 2;
                }
            }
            return i6;
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
            return tri == Tri.FALSE ? 0 : 2;
        }
        return invokeL.intValue;
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

    private native String getNativeSmartColor(byte[] bArr, int i2, int i3, int i4, int i5, String str, String str2, int i6, int i7, int i8, int i9, long j2, long j3, long j4, long j5);

    public final byte[] b(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, bitmap, compressFormat, i2)) == null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(compressFormat, i2, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLLI.objValue;
    }

    public String e(a aVar, Bitmap bitmap) {
        InterceptResult invokeLL;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, bitmap)) == null) {
            if (bitmap == null || aVar == null) {
                return null;
            }
            if (aVar.h()) {
                int s = aVar.s();
                int p = aVar.p();
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
                    float f2 = 1.0f / a2;
                    matrix.setScale(f2, f2);
                    bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
                }
            } else {
                bitmap2 = null;
            }
            if (bitmap2 == null) {
                return null;
            }
            for (int i2 = 0; i2 < bitmap2.getHeight(); i2++) {
                for (int i3 = 0; i3 < bitmap2.getWidth(); i3++) {
                    if (Color.alpha(bitmap2.getPixel(i3, i2)) == 0) {
                        bitmap2.setPixel(i3, i2, -1);
                    }
                }
            }
            byte[] b2 = b(bitmap2, Bitmap.CompressFormat.JPEG, 100);
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            if (b2 == null) {
                return null;
            }
            return f(aVar, b2, b2.length);
        }
        return (String) invokeLL.objValue;
    }

    public final String f(a aVar, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, aVar, bArr, i2)) == null) {
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            return getNativeSmartColor(bArr, i2, aVar.j(), aVar.k(), aVar.o(), aVar.v(), aVar.l(), c(aVar.m()), c(aVar.n()), c(aVar.i()), c(aVar.g()), aVar.t(), aVar.q(), aVar.u(), aVar.r());
        }
        return (String) invokeLLI.objValue;
    }
}
