package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import org.apache.commons.codec.net.QCodec;
/* loaded from: classes3.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] a;
    public static final byte[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(197698848, "Lcom/baidu/mobads/sdk/internal/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(197698848, "Lcom/baidu/mobads/sdk/internal/g;");
                return;
            }
        }
        a = new byte[]{48, 75, 97, 106, 68, 55, 65, 90, 99, 70, 50, 81, 110, 80, 114, 53, 102, 119, 105, 72, 82, 78, 121, 103, 109, 117, 112, 85, 84, 73, 88, 120, 54, 57, 66, 87, 98, 45, 104, 77, 67, 71, 74, 111, QCodec.UNDERSCORE, 86, 56, 69, 115, 107, 122, 49, 89, 100, 118, 76, 51, 52, 108, Constants.SHORT_PING_CMD_TYPE, 116, 113, 83, 79};
        b = new byte[128];
        int i = 0;
        while (true) {
            byte[] bArr = a;
            if (i < bArr.length) {
                b[bArr[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }

    public g() {
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

    public static boolean a(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(65538, null, b2)) == null) {
            if (b2 == 36) {
                return true;
            }
            if (b2 >= 0 && b2 < 128 && b[b2] != -1) {
                return true;
            }
            return false;
        }
        return invokeB.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (str == null) {
                return true;
            }
            for (int i = 0; i < str.length(); i++) {
                if (!a((byte) str.charAt(i))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null && str.length() >= 4) {
                try {
                    String str2 = new String(c(str));
                    while (str2.endsWith("$")) {
                        str2 = str2.substring(0, str2.length() - 1);
                    }
                    return str2;
                } catch (Exception unused) {
                    return "";
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static byte[] c(String str) {
        InterceptResult invokeL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (d(str) || str == null || str.length() < 4) {
                return null;
            }
            if (str.charAt(str.length() - 2) == '$') {
                bArr = new byte[(((str.length() / 4) - 1) * 3) + 1];
            } else if (str.charAt(str.length() - 1) == '$') {
                bArr = new byte[(((str.length() / 4) - 1) * 3) + 2];
            } else {
                bArr = new byte[(str.length() / 4) * 3];
            }
            int i = 0;
            int i2 = 0;
            while (i < str.length() - 4) {
                byte b2 = b[str.charAt(i)];
                byte b3 = b[str.charAt(i + 1)];
                byte b4 = b[str.charAt(i + 2)];
                byte b5 = b[str.charAt(i + 3)];
                bArr[i2] = (byte) ((b2 << 2) | (b3 >> 4));
                bArr[i2 + 1] = (byte) ((b3 << 4) | (b4 >> 2));
                bArr[i2 + 2] = (byte) ((b4 << 6) | b5);
                i += 4;
                i2 += 3;
            }
            if (str.charAt(str.length() - 2) == '$') {
                bArr[bArr.length - 1] = (byte) ((b[str.charAt(str.length() - 3)] >> 4) | (b[str.charAt(str.length() - 4)] << 2));
            } else if (str.charAt(str.length() - 1) == '$') {
                byte b6 = b[str.charAt(str.length() - 4)];
                byte b7 = b[str.charAt(str.length() - 3)];
                byte b8 = b[str.charAt(str.length() - 2)];
                bArr[bArr.length - 2] = (byte) ((b6 << 2) | (b7 >> 4));
                bArr[bArr.length - 1] = (byte) ((b8 >> 2) | (b7 << 4));
            } else {
                byte b9 = b[str.charAt(str.length() - 4)];
                byte b10 = b[str.charAt(str.length() - 3)];
                byte b11 = b[str.charAt(str.length() - 2)];
                byte b12 = b[str.charAt(str.length() - 1)];
                bArr[bArr.length - 3] = (byte) ((b9 << 2) | (b10 >> 4));
                bArr[bArr.length - 2] = (byte) ((b10 << 4) | (b11 >> 2));
                bArr[bArr.length - 1] = (byte) (b12 | (b11 << 6));
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            for (int length = str.getBytes().length % 3; length > 0 && length < 3; length++) {
                str = str + "$";
            }
            byte[] bytes = str.getBytes();
            byte[] bArr = new byte[(bytes.length / 3) * 4];
            int i = 0;
            int i2 = 0;
            while (i < bytes.length) {
                byte[] bArr2 = a;
                bArr[i2] = bArr2[(bytes[i] & Cea608Decoder.CC_IMPLICIT_DATA_HEADER) >> 2];
                int i3 = i + 1;
                bArr[i2 + 1] = bArr2[((bytes[i] & 3) << 4) + ((bytes[i3] & 240) >> 4)];
                int i4 = i + 2;
                bArr[i2 + 2] = bArr2[((bytes[i3] & 15) << 2) + ((bytes[i4] & ExifInterface.MARKER_SOF0) >> 6)];
                bArr[i2 + 3] = bArr2[bytes[i4] & 63];
                i += 3;
                i2 += 4;
            }
            return new String(bArr);
        }
        return (String) invokeL.objValue;
    }
}
