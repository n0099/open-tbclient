package com.baidu.sofire.j;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f44038a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f44039b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f44040c;

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f44041d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074229101, "Lcom/baidu/sofire/j/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074229101, "Lcom/baidu/sofire/j/b;");
                return;
            }
        }
        f44038a = "ftyp".getBytes();
        f44039b = MediaDataBox.TYPE.getBytes();
        f44040c = MovieBox.TYPE.getBytes();
        f44041d = "free".getBytes();
    }

    public static int a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), bArr2, Integer.valueOf(i4)})) == null) {
            if (bArr == null || bArr.length <= 0) {
                return -1;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr, i2, i3);
                return messageDigest.digest(bArr2, i4, 16);
            } catch (DigestException | NoSuchAlgorithmException e2) {
                throw new RuntimeException("NoSuchAlgorithmException", e2);
            }
        }
        return invokeCommon.intValue;
    }

    public static byte[] a(byte[] bArr, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2, i3, i4)) == null) {
            for (int i5 = i2; i5 < i2 + i3; i5++) {
                bArr[i5] = (byte) (bArr[i5] ^ i4);
            }
            return bArr;
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[][] a(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        int i2;
        int i3;
        int i4;
        String str;
        int hashCode;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bArr)) == null) {
            if (bArr == null || bArr.length < 4) {
                return null;
            }
            int length = bArr.length;
            byte[][] bArr2 = new byte[2];
            int i5 = 0;
            int a2 = a(bArr, 0);
            int i6 = a2 - 8;
            int i7 = i6 + 16 + 4 + 4;
            int i8 = a2 + 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i8 < length) {
                int a3 = a(bArr, i8);
                if (a3 == 1) {
                    int i15 = i8 + 8;
                    long j = -1;
                    if (bArr != null && bArr.length - i15 >= 8) {
                        byte[] a4 = a(bArr, i15, 8);
                        if (a4.length == 8) {
                            ByteBuffer wrap = ByteBuffer.wrap(a4, i5, 8);
                            wrap.order(ByteOrder.BIG_ENDIAN);
                            j = wrap.getLong();
                        }
                    }
                    i2 = length;
                    a3 = (int) j;
                    i3 = 8;
                } else {
                    i2 = length;
                    i3 = 0;
                }
                int i16 = i8 + 4;
                if (bArr != null) {
                    i4 = i2;
                    if (bArr.length - i16 >= 4) {
                        str = new String(a(bArr, i16, 4));
                        hashCode = str.hashCode();
                        if (hashCode == 3346442) {
                            if (hashCode == 3357449 && str.equals(MovieBox.TYPE)) {
                                c2 = 1;
                            }
                            c2 = 65535;
                        } else {
                            if (str.equals(MediaDataBox.TYPE)) {
                                c2 = 0;
                            }
                            c2 = 65535;
                        }
                        if (c2 != 0) {
                            i14 = (a3 - 8) - i3;
                            i12 = a3;
                            i11 = i8;
                        } else if (c2 == 1) {
                            i13 = (a3 - 8) - i3;
                            i10 = a3;
                            i9 = i8;
                        }
                        i8 += a3;
                        length = i4;
                        i5 = 0;
                    }
                } else {
                    i4 = i2;
                }
                str = null;
                hashCode = str.hashCode();
                if (hashCode == 3346442) {
                }
                if (c2 != 0) {
                }
                i8 += a3;
                length = i4;
                i5 = 0;
            }
            if (i9 + i10 <= length && i11 + i12 <= length) {
                long currentTimeMillis = System.currentTimeMillis();
                int i17 = i13 + i7;
                int i18 = i17 + 40;
                byte[] array = ByteBuffer.allocate(i18).order(ByteOrder.LITTLE_ENDIAN).putLong(currentTimeMillis).order(ByteOrder.BIG_ENDIAN).putInt(i7).putInt(length).putInt(i9).putInt(i10).putInt(i11).putInt(i12).put(bArr, 8, i6).put(bArr, i9 + (i10 - i13), i13).putLong(0L).putLong(0L).array();
                int i19 = i14 + 40;
                byte[] array2 = ByteBuffer.allocate(i19).order(ByteOrder.LITTLE_ENDIAN).putLong(currentTimeMillis).put(bArr, i11 + (i12 - i14), i14).putLong(0L).putLong(0L).array();
                int i20 = i19 - 32;
                a(array, 8, i17, array2, i20);
                a(array, 8, i17, array[0]);
                a(array2, i20, 16, bArr[8]);
                int i21 = i18 - 32;
                a(array2, 8, i14, array, i21);
                a(array2, 8, i14, array[1]);
                a(array, i21, 16, bArr[10]);
                int i22 = i18 - 16;
                int i23 = i19 - 16;
                a(array, 0, i22, array2, i23);
                a(array2, i23, 16, bArr[4]);
                a(array2, 0, i23, array, i22);
                a(array, i22, 16, bArr[6]);
                bArr2[0] = array;
                bArr2[1] = array2;
                return bArr2;
            }
            return null;
        }
        return (byte[][]) invokeL.objValue;
    }

    public static int a(byte[] bArr, int i2) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, bArr, i2)) == null) {
            if (bArr == null || bArr.length - i2 < 4) {
                return -1;
            }
            byte[] a2 = a(bArr, i2, 4);
            if (a2.length != 4) {
                return -1;
            }
            ByteBuffer wrap = ByteBuffer.wrap(a2, 0, 4);
            wrap.order(ByteOrder.BIG_ENDIAN);
            return wrap.getInt();
        }
        return invokeLI.intValue;
    }
}
