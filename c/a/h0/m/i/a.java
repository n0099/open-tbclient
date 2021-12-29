package c.a.h0.m.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.FileDescriptor;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, options, i2, i3)) == null) {
            int i4 = options.outHeight;
            int i5 = options.outWidth;
            int i6 = 1;
            if (i4 > i3 || i5 > i2) {
                int i7 = i4 / 2;
                int i8 = i5 / 2;
                while (i7 / i6 >= i3 && i8 / i6 >= i2) {
                    i6 *= 2;
                }
            }
            return i6;
        }
        return invokeLII.intValue;
    }

    public static Bitmap b(FileDescriptor fileDescriptor, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, fileDescriptor, i2, i3)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            int a = a(options, i2, i3);
            options.inSampleSize = a;
            options.inJustDecodeBounds = false;
            if (a <= 1) {
                return BitmapFactory.decodeFileDescriptor(fileDescriptor);
            }
            return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        }
        return (Bitmap) invokeLII.objValue;
    }
}
