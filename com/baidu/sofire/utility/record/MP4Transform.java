package com.baidu.sofire.utility.record;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class MP4Transform {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILE_TYPE_BOX = "ftyp";
    public static final byte[] FREEBYTES;
    public static final String FREE_SPACE_BOX = "free";
    public static final byte[] FTYPBYTES;
    public static final byte[] MDATBYTES;
    public static final int MDAT_INDEX = 1;
    public static final String MEDIADATA_BOX = "mdat";
    public static final byte[] MOOVBYTES;
    public static final int MOOV_INDEX = 0;
    public static final String MOVIE_BOX = "moov";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(96734260, "Lcom/baidu/sofire/utility/record/MP4Transform;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(96734260, "Lcom/baidu/sofire/utility/record/MP4Transform;");
                return;
            }
        }
        FTYPBYTES = "ftyp".getBytes();
        MDATBYTES = "mdat".getBytes();
        MOOVBYTES = "moov".getBytes();
        FREEBYTES = "free".getBytes();
    }

    public MP4Transform() {
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

    public static int byteArrayToInt(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            if (bArr == null || bArr.length != 4) {
                return -1;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
            wrap.order(ByteOrder.BIG_ENDIAN);
            return wrap.getInt();
        }
        return invokeL.intValue;
    }

    public static long byteArrayToLong(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr == null || bArr.length != 8) {
                return -1L;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 8);
            wrap.order(ByteOrder.BIG_ENDIAN);
            return wrap.getLong();
        }
        return invokeL.longValue;
    }

    public static byte[] bytesXor(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i)) == null) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr2[i2] = (byte) (bArr[i2] ^ i);
            }
            return bArr2;
        }
        return (byte[]) invokeLI.objValue;
    }

    public static int check(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws Exception {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, bArr, bArr2, bArr3, bArr4)) == null) {
            if (bArr == null || bArr2 == null || bArr3 == null || bArr4 == null || bArr.length <= 0 || bArr2.length <= 0 || bArr3.length <= 0 || bArr4.length <= 0) {
                return -1;
            }
            int i = !Arrays.equals(subBytes(bArr, 0, 8), subBytes(bArr2, 0, 8)) ? 1 : 0;
            if (!Arrays.equals(bytesXor(subBytes(bArr2, bArr2.length - 16, 16), 0, 16, 102), md5(subBytes(bArr, 0, bArr.length - 16)))) {
                i |= 2;
            }
            if (!Arrays.equals(bytesXor(subBytes(bArr, bArr.length - 16, 16), 0, 16, 121), md5(subBytes(bArr2, 0, bArr2.length - 16)))) {
                i |= 4;
            }
            if (!Arrays.equals(bytesXor(subBytes(bArr2, (bArr2.length - 16) - 16, 16), 0, 16, 109), md5(bArr3))) {
                i |= 8;
            }
            return !Arrays.equals(bytesXor(subBytes(bArr, (bArr.length - 16) - 16, 16), 0, 16, 52), md5(bArr4)) ? i | 16 : i;
        }
        return invokeLLLL.intValue;
    }

    public static byte[][] getAllBoxs(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        int i;
        char c2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            if (bArr == null || bArr.length < 16) {
                return null;
            }
            byte[][] bArr2 = new byte[2];
            long j2 = 8;
            long boxSize32 = getBoxSize32(bArr, 0) - 8;
            int i2 = (int) (16 + boxSize32 + 4 + 4);
            byte[] bArr3 = new byte[i2];
            System.arraycopy(intToByteArray(i2, false), 0, bArr3, 0, 4);
            System.arraycopy(intToByteArray(bArr.length, false), 0, bArr3, 4, 4);
            System.arraycopy(bArr, 8, bArr3, 24, (int) boxSize32);
            int i3 = 0;
            while (i3 < bArr.length) {
                long boxSize322 = getBoxSize32(bArr, i3);
                String boxType = getBoxType(bArr, i3 + 4);
                if (boxSize322 == 1) {
                    boxSize322 = getBoxSize64(bArr, i3 + 8);
                    i = 8;
                } else {
                    i = 0;
                }
                int hashCode = boxType.hashCode();
                if (hashCode == 3154021) {
                    if (boxType.equals("ftyp")) {
                        c2 = 2;
                    }
                    c2 = 65535;
                } else if (hashCode != 3346442) {
                    if (hashCode == 3357449 && boxType.equals("moov")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else {
                    if (boxType.equals("mdat")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                }
                if (c2 != 0) {
                    if (c2 == 1) {
                        System.arraycopy(intToByteArray(i3, false), 0, bArr3, 8, 4);
                        System.arraycopy(intToByteArray((int) boxSize322, false), 0, bArr3, 12, 4);
                        int i4 = (int) ((boxSize322 - 8) - i);
                        bArr2[0] = new byte[i4 + i2];
                        System.arraycopy(bArr, i3 + 8 + i, bArr2[0], i2, i4);
                    } else if (c2 != 2) {
                        j = j2;
                    } else {
                        subBytes(bArr, i3 + 8 + i, (int) ((boxSize322 - j2) - i));
                    }
                    j = 8;
                } else {
                    System.arraycopy(intToByteArray(i3, false), 0, bArr3, 16, 4);
                    System.arraycopy(intToByteArray((int) boxSize322, false), 0, bArr3, 20, 4);
                    j = 8;
                    bArr2[1] = subBytes(bArr, i3 + 8 + i, (int) ((boxSize322 - 8) - i));
                }
                i3 = (int) (i3 + boxSize322);
                j2 = j;
            }
            System.arraycopy(bArr3, 0, bArr2[0], 0, i2);
            return bArr2;
        }
        return (byte[][]) invokeL.objValue;
    }

    public static int getBoxSize32(byte[] bArr, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bArr, i)) == null) {
            if (bArr == null || bArr.length - i < 4) {
                return -1;
            }
            return byteArrayToInt(subBytes(bArr, i, 4));
        }
        return invokeLI.intValue;
    }

    public static long getBoxSize64(byte[] bArr, int i) throws Exception {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, bArr, i)) == null) {
            if (bArr == null || bArr.length - i < 8) {
                return -1L;
            }
            return byteArrayToLong(subBytes(bArr, i, 8));
        }
        return invokeLI.longValue;
    }

    public static String getBoxType(byte[] bArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, bArr, i)) == null) {
            if (bArr == null || bArr.length - i < 4) {
                return null;
            }
            return new String(subBytes(bArr, i, 4));
        }
        return (String) invokeLI.objValue;
    }

    public static String getHexString(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bArr)) == null) {
            String str = "";
            for (int i = 0; i < bArr.length; i++) {
                str = str + Integer.toString((bArr[i] & 255) + 256, 16).substring(1);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static long getMillsec(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bArr)) == null) {
            if (bArr == null || bArr.length < 8) {
                return -1L;
            }
            byte[] bArr2 = new byte[8];
            System.arraycopy(bArr, 0, bArr2, 0, 8);
            long j = ByteBuffer.wrap(bArr2, 0, 8).order(ByteOrder.LITTLE_ENDIAN).getLong();
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return j;
        }
        return invokeL.longValue;
    }

    public static byte[] intToByteArray(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            return ByteBuffer.allocate(4).order(z ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN).putInt(i).array();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static byte[] longToByteArray(long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            return ByteBuffer.allocate(8).order(z ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN).putLong(j).array();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static byte[] md5(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, bArr)) == null) {
            if (bArr == null || bArr.length <= 0) {
                return null;
            }
            try {
                return MessageDigest.getInstance("MD5").digest(bArr);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException("NoSuchAlgorithmException", e2);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[] subBytes(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65553, null, bArr, i, i2)) == null) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
        return (byte[]) invokeLII.objValue;
    }

    public static byte[] toByteArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (str == null || str.isEmpty()) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            byte[] bArr = new byte[lowerCase.length() >> 1];
            int i = 0;
            for (int i2 = 0; i2 < lowerCase.length() && i <= lowerCase.length() - 1; i2++) {
                bArr[i2] = (byte) ((((byte) (Character.digit(lowerCase.charAt(i), 16) & 255)) << 4) | ((byte) (Character.digit(lowerCase.charAt(i + 1), 16) & 255)));
                i += 2;
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static byte[][] transform(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        byte[][] bArr2;
        int i;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, bArr)) == null) {
            if (bArr == null || bArr.length < 4) {
                return null;
            }
            int length = bArr.length;
            byte[][] bArr3 = new byte[2];
            int boxSize32 = getBoxSize32(bArr, 0);
            int i2 = boxSize32 - 8;
            int i3 = i2 + 16 + 4 + 4;
            int i4 = boxSize32 + 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i4 < length) {
                int boxSize322 = getBoxSize32(bArr, i4);
                if (boxSize322 == 1) {
                    bArr2 = bArr3;
                    boxSize322 = (int) getBoxSize64(bArr, i4 + 8);
                    i = 8;
                } else {
                    bArr2 = bArr3;
                    i = 0;
                }
                String boxType = getBoxType(bArr, i4 + 4);
                int hashCode = boxType.hashCode();
                if (hashCode != 3346442) {
                    if (hashCode == 3357449 && boxType.equals("moov")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else {
                    if (boxType.equals("mdat")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                }
                if (c2 == 0) {
                    i10 = (boxSize322 - 8) - i;
                    i8 = boxSize322;
                    i7 = i4;
                } else if (c2 == 1) {
                    i9 = (boxSize322 - 8) - i;
                    i6 = boxSize322;
                    i5 = i4;
                }
                i4 += boxSize322;
                bArr3 = bArr2;
            }
            byte[][] bArr4 = bArr3;
            if (i5 + i6 <= length && i7 + i8 <= length) {
                long currentTimeMillis = System.currentTimeMillis();
                int i11 = i9 + i3;
                int i12 = i11 + 40;
                byte[] array = ByteBuffer.allocate(i12).order(ByteOrder.LITTLE_ENDIAN).putLong(currentTimeMillis).order(ByteOrder.BIG_ENDIAN).putInt(i3).putInt(length).putInt(i5).putInt(i6).putInt(i7).putInt(i8).put(bArr, 8, i2).put(bArr, i5 + (i6 - i9), i9).putLong(0L).putLong(0L).array();
                int i13 = i10 + 40;
                byte[] array2 = ByteBuffer.allocate(i13).order(ByteOrder.LITTLE_ENDIAN).putLong(currentTimeMillis).put(bArr, i7 + (i8 - i10), i10).putLong(0L).putLong(0L).array();
                int i14 = i13 - 32;
                md5(array, 8, i11, array2, i14, 16);
                bytesXor(array, 8, i11, array[0]);
                bytesXor(array2, i14, 16, bArr[8]);
                int i15 = i12 - 32;
                int i16 = i10;
                md5(array2, 8, i16, array, i15, 16);
                bytesXor(array2, 8, i16, array[1]);
                bytesXor(array, i15, 16, bArr[10]);
                int i17 = i12 - 16;
                int i18 = i13 - 16;
                md5(array, 0, i17, array2, i18, 16);
                bytesXor(array2, i18, 16, bArr[4]);
                md5(array2, 0, i18, array, i17, 16);
                bytesXor(array, i17, 16, bArr[6]);
                bArr4[0] = array;
                bArr4[1] = array2;
                return bArr4;
            }
            return null;
        }
        return (byte[][]) invokeL.objValue;
    }

    public static byte[][] transformOld(byte[] bArr) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bArr)) == null) {
            if (bArr == null || bArr.length < 4) {
                return null;
            }
            byte[][] allBoxs = getAllBoxs(bArr);
            byte[] bArr2 = allBoxs[0];
            byte[] bArr3 = allBoxs[1];
            byte[] bytesXor = bytesXor(md5(bArr2), bArr[8]);
            byte[] bytesXor2 = bytesXor(md5(bArr3), bArr[10]);
            byte[] longToByteArray = longToByteArray(System.currentTimeMillis(), true);
            byte[] bytesXor3 = bytesXor(bArr2, longToByteArray[0]);
            byte[] bytesXor4 = bytesXor(bArr3, longToByteArray[1]);
            int length = bytesXor3.length + 8 + 16;
            byte[] bArr4 = new byte[length];
            int length2 = bytesXor4.length + 8 + 16;
            byte[] bArr5 = new byte[length2];
            System.arraycopy(longToByteArray, 0, bArr4, 0, 8);
            System.arraycopy(longToByteArray, 0, bArr5, 0, 8);
            System.arraycopy(bytesXor3, 0, bArr4, 8, bytesXor3.length);
            System.arraycopy(bytesXor4, 0, bArr5, 8, bytesXor4.length);
            System.arraycopy(bytesXor2, 0, bArr4, bytesXor3.length + 8, 16);
            System.arraycopy(bytesXor, 0, bArr5, bytesXor4.length + 8, 16);
            byte[] bytesXor5 = bytesXor(md5(bArr4), bArr[4]);
            byte[] bytesXor6 = bytesXor(md5(bArr5), bArr[6]);
            byte[] bArr6 = new byte[length + 16];
            byte[] bArr7 = new byte[length2 + 16];
            System.arraycopy(bArr4, 0, bArr6, 0, length);
            System.arraycopy(bArr5, 0, bArr7, 0, length2);
            System.arraycopy(bytesXor6, 0, bArr6, length, 16);
            System.arraycopy(bytesXor5, 0, bArr7, length2, 16);
            return new byte[][]{bArr6, bArr7};
        }
        return (byte[][]) invokeL.objValue;
    }

    public static byte[][] untransformBoxs(byte[] bArr, byte[] bArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, bArr, bArr2)) == null) {
            if (bArr == null || bArr2 == null || bArr.length <= 0 || bArr2.length <= 0) {
                return null;
            }
            return new byte[][]{bytesXor(subBytes(bArr, 8, ((bArr.length - 8) - 16) - 16), 0, ((bArr.length - 8) - 16) - 16, bArr[0]), bytesXor(subBytes(bArr2, 8, ((bArr2.length - 8) - 16) - 16), 0, ((bArr2.length - 8) - 16) - 16, bArr2[1])};
        }
        return (byte[][]) invokeLL.objValue;
    }

    public static byte[] untransformMp4(byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, bArr, bArr2)) == null) {
            if (bArr == null || bArr2 == null || bArr.length <= 0 || bArr2.length <= 0) {
                return null;
            }
            int boxSize32 = getBoxSize32(bArr, 0);
            int boxSize322 = getBoxSize32(bArr, 4);
            int boxSize323 = getBoxSize32(bArr, 8);
            int boxSize324 = getBoxSize32(bArr, 12);
            int boxSize325 = getBoxSize32(bArr, 16);
            int boxSize326 = getBoxSize32(bArr, 20);
            int i2 = boxSize32 - 24;
            int i3 = i2 + 8;
            int length = boxSize326 - bArr2.length;
            int length2 = (boxSize324 - bArr.length) + boxSize32;
            if (length == 8 || length == 16 || length2 == 8 || length2 == 16) {
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                if (boxSize323 > boxSize325) {
                    iArr[0] = boxSize325;
                    iArr[1] = boxSize323;
                    iArr2[0] = boxSize326;
                    iArr2[1] = boxSize324;
                } else {
                    iArr[0] = boxSize323;
                    iArr[1] = boxSize325;
                    iArr2[0] = boxSize324;
                    iArr2[1] = boxSize326;
                }
                int[] iArr3 = {i3 + 0, iArr[0] + iArr2[0], iArr[1] + iArr2[1]};
                int[] iArr4 = {iArr[0] - iArr3[0], iArr[1] - iArr3[1], boxSize322 - iArr3[2]};
                int i4 = 0;
                for (int i5 = 3; i4 < i5; i5 = 3) {
                    if (iArr4[i4] < 0) {
                        return null;
                    }
                    if (iArr4[i4] > 0 && iArr4[i4] < 8) {
                        return null;
                    }
                    i4++;
                }
                ByteBuffer order = ByteBuffer.allocate(boxSize322).order(ByteOrder.BIG_ENDIAN);
                order.position(0);
                order.putInt(i3).put(FTYPBYTES).put(bArr, 24, i2);
                order.position(boxSize325);
                if (length == 8) {
                    order.putInt(boxSize326).put(MDATBYTES);
                } else if (length != 16) {
                    return null;
                } else {
                    order.putInt(1).put(MDATBYTES).putInt(0).putInt(boxSize326);
                }
                order.put(bArr2);
                order.position(boxSize323);
                if (length2 == 8) {
                    i = 0;
                    order.putInt(boxSize324).put(MOOVBYTES);
                } else if (length2 != 16) {
                    return null;
                } else {
                    i = 0;
                    order.putInt(1).put(MOOVBYTES).putInt(0).putInt(boxSize324);
                }
                order.put(bArr, boxSize32, bArr.length - boxSize32);
                while (i < 3) {
                    if (iArr4[i] != 0) {
                        order.position(iArr3[i]);
                        order.putInt(iArr4[i]).put(FREEBYTES);
                    }
                    i++;
                }
                return order.array();
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] untransformMp4Old(byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLL;
        long j;
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, bArr, bArr2)) == null) {
            if (bArr == null || bArr2 == null || bArr.length <= 0 || bArr2.length <= 0) {
                return null;
            }
            int i4 = 0;
            long boxSize32 = getBoxSize32(bArr, 0);
            long boxSize322 = getBoxSize32(bArr, 4);
            long boxSize323 = getBoxSize32(bArr, 8);
            long boxSize324 = getBoxSize32(bArr, 12);
            long boxSize325 = getBoxSize32(bArr, 20);
            byte[] bArr3 = new byte[(int) boxSize322];
            long j2 = boxSize32 - 24;
            int i5 = (int) (j2 + 8);
            System.arraycopy(intToByteArray(i5, false), 0, bArr3, 0, 4);
            System.arraycopy(FTYPBYTES, 0, bArr3, 4, 4);
            System.arraycopy(bArr, 24, bArr3, 8, (int) j2);
            int boxSize326 = (int) (getBoxSize32(bArr, 16) - i5);
            if (boxSize326 >= 0) {
                if (boxSize326 <= 0 || boxSize326 >= 8) {
                    if (boxSize326 > 8) {
                        System.arraycopy(intToByteArray(boxSize326, false), 0, bArr3, i5, 4);
                        System.arraycopy(FREEBYTES, 0, bArr3, i5 + 4, 4);
                        i5 += boxSize326;
                    }
                    if (boxSize325 - bArr2.length == 8) {
                        System.arraycopy(intToByteArray((int) boxSize325, false), 0, bArr3, i5, 4);
                        int i6 = i5 + 4;
                        System.arraycopy(MDATBYTES, 0, bArr3, i6, 4);
                        i2 = i6 + 4;
                        j = boxSize32;
                        i = 8;
                    } else {
                        j = boxSize32;
                        if (boxSize325 - bArr2.length != 16) {
                            return null;
                        }
                        i4 = 0;
                        System.arraycopy(intToByteArray(1, false), 0, bArr3, i5, 4);
                        int i7 = i5 + 4;
                        System.arraycopy(MDATBYTES, 0, bArr3, i7, 4);
                        int i8 = i7 + 4;
                        i = 8;
                        System.arraycopy(longToByteArray(boxSize325, false), 0, bArr3, i8, 8);
                        i2 = i8 + 8;
                    }
                    System.arraycopy(bArr2, i4, bArr3, i2, bArr2.length);
                    int length = i2 + bArr2.length;
                    int i9 = (int) (boxSize323 - length);
                    if (i9 >= 0) {
                        if (i9 <= 0 || i9 >= i) {
                            if (i9 > i) {
                                System.arraycopy(intToByteArray(i9, false), 0, bArr3, length, 4);
                                System.arraycopy(FREEBYTES, 0, bArr3, length + 4, 4);
                                length += i9;
                            }
                            long j3 = boxSize324 + j;
                            if (j3 - bArr.length == 8) {
                                System.arraycopy(intToByteArray((int) boxSize324, false), 0, bArr3, length, 4);
                                int i10 = length + 4;
                                System.arraycopy(MOOVBYTES, 0, bArr3, i10, 4);
                                i3 = i10 + 4;
                            } else if (j3 - bArr.length != 16) {
                                return null;
                            } else {
                                System.arraycopy(intToByteArray(1, false), 0, bArr3, length, 4);
                                int i11 = length + 4;
                                System.arraycopy(MOOVBYTES, 0, bArr3, i11, 4);
                                int i12 = i11 + 4;
                                System.arraycopy(longToByteArray(boxSize324, false), 0, bArr3, i12, 8);
                                i3 = i12 + 8;
                            }
                            long j4 = j;
                            System.arraycopy(bArr, (int) j4, bArr3, i3, (int) (bArr.length - j4));
                            int length2 = (int) (i3 + (bArr.length - j4));
                            if (length2 != boxSize322) {
                                System.arraycopy(intToByteArray(0, false), 0, bArr3, length2, 4);
                            }
                            return bArr3;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] bytesXor(byte[] bArr, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65541, null, bArr, i, i2, i3)) == null) {
            for (int i4 = i; i4 < i + i2; i4++) {
                bArr[i4] = (byte) (bArr[i4] ^ i3);
            }
            return bArr;
        }
        return (byte[]) invokeLIII.objValue;
    }

    public static int md5(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), bArr2, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (bArr == null || bArr.length <= 0) {
                return -1;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr, i, i2);
                return messageDigest.digest(bArr2, i3, i4);
            } catch (DigestException | NoSuchAlgorithmException e2) {
                throw new RuntimeException("NoSuchAlgorithmException", e2);
            }
        }
        return invokeCommon.intValue;
    }
}
