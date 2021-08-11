package com.baidu.ar.h;

import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(int i2, int i3, byte[] bArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65536, null, i2, i3, bArr)) == null) {
            if (bArr.length <= 0) {
                return null;
            }
            int length = bArr.length / 4;
            int[] iArr = new int[length];
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = i4 * 4;
                iArr[i4] = ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 0] & 255) << 16) | ((bArr[i5 + 1] & 255) << 8) | (bArr[i5 + 2] & 255);
            }
            return Bitmap.createBitmap(iArr, 0, i2, i2, i3, Bitmap.Config.ARGB_8888);
        }
        return (Bitmap) invokeIIL.objValue;
    }

    public static byte[] b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bitmap)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(allocate);
            return allocate.array();
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] c(Bitmap bitmap, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bitmap, i2)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeLI.objValue;
    }
}
