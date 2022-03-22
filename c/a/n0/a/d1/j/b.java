package c.a.n0.a.d1.j;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Double.valueOf(d2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = d2;
    }

    @Override // c.a.n0.a.d1.j.a
    public boolean a(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, rect)) == null) {
            if (a.f4114c) {
                Log.d("ErrorPageParser", "GridErrorPageParser: start error page parse");
            }
            if (bitmap == null) {
                return false;
            }
            Rect rect2 = !b(bitmap, rect) ? new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()) : rect;
            int width = rect2.width() - 2;
            int height = rect2.height() - 2;
            int i = width / 3;
            int i2 = height / i;
            int ceil = (int) Math.ceil(i2 * 3 * this.a);
            int i3 = 0;
            int i4 = 0;
            while (i4 < 3) {
                int i5 = rect2.left;
                int i6 = (i4 * i) + 1 + i5;
                int i7 = i4 == 2 ? width + 1 : ((i4 + 1) * i) + i5;
                int i8 = i3;
                int i9 = 0;
                while (i9 < i2) {
                    int i10 = rect2.top;
                    int i11 = i9;
                    if (e(bitmap, i6, (i9 * i) + 1 + i10, i7, i9 == i2 + (-1) ? height + 1 : ((i9 + 1) * i) + i10)) {
                        int i12 = i8 + 1;
                        if (i12 >= ceil) {
                            return true;
                        }
                        i8 = i12;
                    }
                    i9 = i11 + 1;
                }
                i4++;
                i3 = i8;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public double d(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, rect)) == null) {
            if (a.f4114c) {
                Log.d("ErrorPageParser", "GridErrorPageParser: start error page parse");
            }
            if (bitmap == null) {
                return 0.0d;
            }
            Rect rect2 = !b(bitmap, rect) ? new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()) : rect;
            int width = rect2.width() - 2;
            int height = rect2.height() - 2;
            int i = width / 3;
            if (i == 0) {
                return 0.0d;
            }
            int i2 = height / i;
            int i3 = 0;
            int i4 = 0;
            while (i3 < 3) {
                int i5 = rect2.left;
                int i6 = (i3 * i) + 1 + i5;
                int i7 = i3 == 2 ? width + 1 : ((i3 + 1) * i) + i5;
                int i8 = i4;
                int i9 = 0;
                while (i9 < i2) {
                    int i10 = rect2.top;
                    int i11 = i9;
                    if (e(bitmap, i6, (i9 * i) + 1 + i10, i7, i9 == i2 + (-1) ? height + 1 : ((i9 + 1) * i) + i10)) {
                        i8++;
                    }
                    i9 = i11 + 1;
                }
                i3++;
                i4 = i8;
            }
            return i4 / (i2 * 3);
        }
        return invokeLL.doubleValue;
    }

    public final boolean e(Bitmap bitmap, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bitmap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i < 0 || i3 < i || i2 < 0 || i4 < i2) {
                return false;
            }
            int pixel = bitmap.getPixel(i, i2);
            while (i <= i3) {
                for (int i5 = i2; i5 <= i4; i5++) {
                    if (pixel != bitmap.getPixel(i, i5)) {
                        return false;
                    }
                }
                i++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
