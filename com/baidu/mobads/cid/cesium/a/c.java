package com.baidu.mobads.cid.cesium.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(byte[] bArr, byte[] bArr2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65536, null, bArr, bArr2, i2) == null) {
            if (i2 < 0) {
                throw new IllegalArgumentException("start should be more than zero!");
            }
            if (bArr == null || bArr.length == 0) {
                throw new IllegalArgumentException("dst array should not be null or empty");
            }
            if (bArr2 == null || bArr2.length == 0) {
                throw new IllegalArgumentException("src array should not be null or empty");
            }
            if (bArr.length < bArr2.length) {
                throw new IllegalArgumentException("dst array length should be longer than:" + bArr2.length);
            }
            if (bArr.length >= bArr2.length + i2) {
                System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
                return;
            }
            throw new IllegalArgumentException("start should be less than:" + (bArr.length - bArr2.length));
        }
    }

    public static byte[] a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bArr, i2)) == null) {
            if (bArr == null || bArr.length == 0) {
                throw new IllegalArgumentException("original array should not be null or empty");
            }
            if (i2 >= 0) {
                return Arrays.copyOf(bArr, i2);
            }
            throw new IllegalArgumentException("length should be more than zero!");
        }
        return (byte[]) invokeLI.objValue;
    }
}
