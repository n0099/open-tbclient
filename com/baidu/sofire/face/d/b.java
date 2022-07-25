package com.baidu.sofire.face.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.coremedia.iso.boxes.MovieBox;
import com.coremedia.iso.boxes.mdat.MediaDataBox;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-266800665, "Lcom/baidu/sofire/face/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-266800665, "Lcom/baidu/sofire/face/d/b;");
                return;
            }
        }
        "ftyp".getBytes();
        MediaDataBox.TYPE.getBytes();
        MovieBox.TYPE.getBytes();
        "free".getBytes();
    }

    public static int a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (bArr == null || bArr.length < 1) {
                return -1;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr, i, i2);
                return messageDigest.digest(bArr2, i3, i4);
            } catch (DigestException | NoSuchAlgorithmException e) {
                throw new RuntimeException("NoSuchAlgorithmException", e);
            }
        }
        return invokeCommon.intValue;
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i, i2, i3)) == null) {
            for (int i4 = i; i4 < i + i2; i4++) {
                bArr[i4] = (byte) (bArr[i4] ^ i3);
            }
            return bArr;
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static byte[] a(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i, i2)) == null) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[][] a(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            if (bArr == null || bArr.length < 4) {
                return null;
            }
            int length = bArr.length;
            byte[][] bArr2 = new byte[2];
            int i3 = 0;
            int a = a(bArr, 0);
            int i4 = a - 8;
            int i5 = i4 + 16 + 4 + 4;
            int i6 = a + 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i6 < length) {
                int a2 = a(bArr, i6);
                if (a2 == 1) {
                    int i13 = i6 + 8;
                    long j = -1;
                    if (bArr.length - i13 >= 8) {
                        byte[] a3 = a(bArr, i13, 8);
                        if (a3.length == 8) {
                            ByteBuffer wrap = ByteBuffer.wrap(a3, i3, 8);
                            wrap.order(ByteOrder.BIG_ENDIAN);
                            j = wrap.getLong();
                        }
                    }
                    i = length;
                    a2 = (int) j;
                    i2 = 8;
                } else {
                    i = length;
                    i2 = 0;
                }
                int i14 = i6 + 4;
                String str = bArr.length - i14 < 4 ? null : new String(a(bArr, i14, 4));
                str.hashCode();
                if (str.equals(MediaDataBox.TYPE)) {
                    i12 = (a2 - 8) - i2;
                    i10 = a2;
                    i9 = i6;
                } else if (str.equals(MovieBox.TYPE)) {
                    i11 = (a2 - 8) - i2;
                    i8 = a2;
                    i7 = i6;
                }
                i6 += a2;
                length = i;
                i3 = 0;
            }
            if (i7 + i8 <= length && i9 + i10 <= length) {
                long currentTimeMillis = System.currentTimeMillis();
                int i15 = i11 + i5;
                int i16 = i15 + 40;
                ByteBuffer allocate = ByteBuffer.allocate(i16);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                byte[] array = allocate.order(byteOrder).putLong(currentTimeMillis).order(ByteOrder.BIG_ENDIAN).putInt(i5).putInt(length).putInt(i7).putInt(i8).putInt(i9).putInt(i10).put(bArr, 8, i4).put(bArr, i7 + (i8 - i11), i11).putLong(0L).putLong(0L).array();
                int i17 = i12 + 40;
                byte[] array2 = ByteBuffer.allocate(i17).order(byteOrder).putLong(currentTimeMillis).put(bArr, i9 + (i10 - i12), i12).putLong(0L).putLong(0L).array();
                int i18 = i17 - 32;
                a(array, 8, i15, array2, i18, 16);
                a(array, 8, i15, array[0]);
                a(array2, i18, 16, bArr[8]);
                int i19 = i16 - 32;
                int i20 = i12;
                a(array2, 8, i20, array, i19, 16);
                a(array2, 8, i20, array[1]);
                a(array, i19, 16, bArr[10]);
                int i21 = i16 - 16;
                int i22 = i17 - 16;
                a(array, 0, i21, array2, i22, 16);
                a(array2, i22, 16, bArr[4]);
                a(array2, 0, i22, array, i21, 16);
                a(array, i21, 16, bArr[6]);
                bArr2[0] = array;
                bArr2[1] = array2;
                return bArr2;
            }
            return null;
        }
        return (byte[][]) invokeL.objValue;
    }

    public static int a(byte[] bArr, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bArr, i)) == null) {
            if (bArr.length - i < 4) {
                return -1;
            }
            byte[] a = a(bArr, i, 4);
            if (a.length != 4) {
                return -1;
            }
            ByteBuffer wrap = ByteBuffer.wrap(a, 0, 4);
            wrap.order(ByteOrder.BIG_ENDIAN);
            return wrap.getInt();
        }
        return invokeLI.intValue;
    }
}
