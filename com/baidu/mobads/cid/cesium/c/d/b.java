package com.baidu.mobads.cid.cesium.c.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final SecureRandom f8318a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1962342093, "Lcom/baidu/mobads/cid/cesium/c/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1962342093, "Lcom/baidu/mobads/cid/cesium/c/d/b;");
                return;
            }
        }
        f8318a = new SecureRandom();
    }

    public static int a(BigInteger bigInteger) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bigInteger)) == null) ? (bigInteger.bitLength() + 7) >> 3 : invokeL.intValue;
    }

    public static BigInteger a(byte[] bArr, BigInteger bigInteger) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, bigInteger)) == null) {
            BigInteger bigInteger2 = new BigInteger(1, bArr);
            if (bigInteger2.compareTo(bigInteger) < 0) {
                return bigInteger2;
            }
            throw new BadPaddingException("Message is larger than modulus");
        }
        return (BigInteger) invokeLL.objValue;
    }

    public static byte[] a(BigInteger bigInteger, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, bigInteger, i2)) == null) {
            byte[] byteArray = bigInteger.toByteArray();
            int length = byteArray.length;
            if (length == i2) {
                return byteArray;
            }
            if (length == i2 + 1 && byteArray[0] == 0) {
                byte[] bArr = new byte[i2];
                System.arraycopy(byteArray, 1, bArr, 0, i2);
                return bArr;
            } else if (length >= i2) {
                return null;
            } else {
                byte[] bArr2 = new byte[i2];
                System.arraycopy(byteArray, 0, bArr2, i2 - length, length);
                return bArr2;
            }
        }
        return (byte[]) invokeLI.objValue;
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3)) == null) {
            if (i2 == 0 && i3 == bArr.length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] a(byte[] bArr, d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, bArr, dVar)) == null) ? a(bArr, dVar.a(), dVar.b()) : (byte[]) invokeLL.objValue;
    }

    public static byte[] a(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, bArr, bigInteger, bigInteger2)) == null) ? a(a(bArr, bigInteger).modPow(bigInteger2, bigInteger), a(bigInteger)) : (byte[]) invokeLLL.objValue;
    }
}
