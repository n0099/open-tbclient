package com.baidu.mobads.container.util;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
/* loaded from: classes7.dex */
public class Base64 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] DECODING_TABLE;
    public static final byte[] ENCODING_TABLE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1168030046, "Lcom/baidu/mobads/container/util/Base64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1168030046, "Lcom/baidu/mobads/container/util/Base64;");
                return;
            }
        }
        ENCODING_TABLE = new byte[]{48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, UtilsBlink.VER_TYPE_SEPARATOR, 104, 77, 67, 71, 74, 111, 95, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, Constants.SHORT_PING_CMD_TYPE, 116, 113, 83, 79};
        DECODING_TABLE = new byte[128];
        int i2 = 0;
        while (true) {
            byte[] bArr = ENCODING_TABLE;
            if (i2 >= bArr.length) {
                return;
            }
            DECODING_TABLE[bArr[i2]] = (byte) i2;
            i2++;
        }
    }

    public Base64() {
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

    public static boolean contianNonBase64Chars(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                return true;
            }
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (!isValidBase64Byte((byte) str.charAt(i2))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static byte[] decode(String str) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (contianNonBase64Chars(str) || str == null || str.length() < 4) {
                return null;
            }
            if (str.charAt(str.length() - 2) == '$') {
                bArr = new byte[(((str.length() / 4) - 1) * 3) + 1];
            } else if (str.charAt(str.length() - 1) == '$') {
                bArr = new byte[(((str.length() / 4) - 1) * 3) + 2];
            } else {
                bArr = new byte[(str.length() / 4) * 3];
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < str.length() - 4) {
                byte b2 = DECODING_TABLE[str.charAt(i2)];
                byte b3 = DECODING_TABLE[str.charAt(i2 + 1)];
                byte b4 = DECODING_TABLE[str.charAt(i2 + 2)];
                byte b5 = DECODING_TABLE[str.charAt(i2 + 3)];
                bArr[i3] = (byte) ((b2 << 2) | (b3 >> 4));
                bArr[i3 + 1] = (byte) ((b3 << 4) | (b4 >> 2));
                bArr[i3 + 2] = (byte) ((b4 << 6) | b5);
                i2 += 4;
                i3 += 3;
            }
            if (str.charAt(str.length() - 2) == '$') {
                bArr[bArr.length - 1] = (byte) ((DECODING_TABLE[str.charAt(str.length() - 3)] >> 4) | (DECODING_TABLE[str.charAt(str.length() - 4)] << 2));
            } else if (str.charAt(str.length() - 1) == '$') {
                byte b6 = DECODING_TABLE[str.charAt(str.length() - 4)];
                byte b7 = DECODING_TABLE[str.charAt(str.length() - 3)];
                byte b8 = DECODING_TABLE[str.charAt(str.length() - 2)];
                bArr[bArr.length - 2] = (byte) ((b6 << 2) | (b7 >> 4));
                bArr[bArr.length - 1] = (byte) ((b8 >> 2) | (b7 << 4));
            } else {
                byte b9 = DECODING_TABLE[str.charAt(str.length() - 4)];
                byte b10 = DECODING_TABLE[str.charAt(str.length() - 3)];
                byte b11 = DECODING_TABLE[str.charAt(str.length() - 2)];
                byte b12 = DECODING_TABLE[str.charAt(str.length() - 1)];
                bArr[bArr.length - 3] = (byte) ((b9 << 2) | (b10 >> 4));
                bArr[bArr.length - 2] = (byte) ((b10 << 4) | (b11 >> 2));
                bArr[bArr.length - 1] = (byte) (b12 | (b11 << 6));
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String decodeStr(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str == null || str.length() < 4) {
                return null;
            }
            try {
                String str2 = new String(decode(str));
                while (str2.endsWith("$")) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
                return str2;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String encode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
                str = str + "$";
            }
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[(bytes.length / 3) * 4];
            int i2 = 0;
            int i3 = 0;
            while (i2 < bytes.length) {
                byte[] bArr2 = ENCODING_TABLE;
                bArr[i3] = bArr2[(bytes[i2] & 252) >> 2];
                int i4 = i2 + 1;
                bArr[i3 + 1] = bArr2[((bytes[i2] & 3) << 4) + ((bytes[i4] & 240) >> 4)];
                int i5 = i2 + 2;
                bArr[i3 + 2] = bArr2[((bytes[i4] & 15) << 2) + ((bytes[i5] & ExifInterface.MARKER_SOF0) >> 6)];
                bArr[i3 + 3] = bArr2[bytes[i5] & 63];
                i2 += 3;
                i3 += 4;
            }
            return new String(bArr);
        }
        return (String) invokeL.objValue;
    }

    public static boolean isValidBase64Byte(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(AdIconUtil.BAIDU_LOGO_ID, null, b2)) == null) {
            if (b2 == 36) {
                return true;
            }
            return b2 >= 0 && b2 < 128 && DECODING_TABLE[b2] != -1;
        }
        return invokeB.booleanValue;
    }
}
