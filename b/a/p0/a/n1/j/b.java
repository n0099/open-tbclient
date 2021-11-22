package b.a.p0.a.n1.j;

import android.graphics.Bitmap;
import android.graphics.Rect;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7264a = d2;
    }

    @Override // b.a.p0.a.n1.j.a
    public boolean a(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bitmap, rect)) == null) {
            boolean z = a.f7263c;
            if (bitmap == null) {
                return false;
            }
            Rect rect2 = !b(bitmap, rect) ? new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()) : rect;
            int width = rect2.width() - 2;
            int height = rect2.height() - 2;
            int i2 = width / 3;
            int i3 = height / i2;
            int ceil = (int) Math.ceil(i3 * 3 * this.f7264a);
            int i4 = 0;
            int i5 = 0;
            while (i5 < 3) {
                int i6 = rect2.left;
                int i7 = (i5 * i2) + 1 + i6;
                int i8 = i5 == 2 ? width + 1 : ((i5 + 1) * i2) + i6;
                int i9 = i4;
                int i10 = 0;
                while (i10 < i3) {
                    int i11 = rect2.top;
                    int i12 = i10;
                    if (e(bitmap, i7, (i10 * i2) + 1 + i11, i8, i10 == i3 + (-1) ? height + 1 : ((i10 + 1) * i2) + i11)) {
                        int i13 = i9 + 1;
                        if (i13 >= ceil) {
                            return true;
                        }
                        i9 = i13;
                    }
                    i10 = i12 + 1;
                }
                i5++;
                i4 = i9;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public double d(Bitmap bitmap, Rect rect) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap, rect)) == null) {
            boolean z = a.f7263c;
            if (bitmap == null) {
                return 0.0d;
            }
            Rect rect2 = !b(bitmap, rect) ? new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()) : rect;
            int width = rect2.width() - 2;
            int height = rect2.height() - 2;
            int i2 = width / 3;
            if (i2 == 0) {
                return 0.0d;
            }
            int i3 = height / i2;
            int i4 = 0;
            int i5 = 0;
            while (i4 < 3) {
                int i6 = rect2.left;
                int i7 = (i4 * i2) + 1 + i6;
                int i8 = i4 == 2 ? width + 1 : ((i4 + 1) * i2) + i6;
                int i9 = i5;
                int i10 = 0;
                while (i10 < i3) {
                    int i11 = rect2.top;
                    int i12 = i10;
                    if (e(bitmap, i7, (i10 * i2) + 1 + i11, i8, i10 == i3 + (-1) ? height + 1 : ((i10 + 1) * i2) + i11)) {
                        i9++;
                    }
                    i10 = i12 + 1;
                }
                i4++;
                i5 = i9;
            }
            return i5 / (i3 * 3);
        }
        return invokeLL.doubleValue;
    }

    public final boolean e(Bitmap bitmap, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bitmap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            if (i2 < 0 || i4 < i2 || i3 < 0 || i5 < i3) {
                return false;
            }
            int pixel = bitmap.getPixel(i2, i3);
            while (i2 <= i4) {
                for (int i6 = i3; i6 <= i5; i6++) {
                    if (pixel != bitmap.getPixel(i2, i6)) {
                        return false;
                    }
                }
                i2++;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
