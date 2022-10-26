package com.baidu.sofire.k;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2074259140, "Lcom/baidu/sofire/k/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2074259140, "Lcom/baidu/sofire/k/j;");
                return;
            }
        }
        a = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
    }

    public static String a(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file == null || !file.exists()) {
                return null;
            }
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                fileInputStream = new FileInputStream(file);
            } catch (Throwable unused) {
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                String b = b(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                    int i = com.baidu.sofire.a.b.a;
                }
                return b;
            } catch (Throwable unused3) {
                try {
                    int i2 = com.baidu.sofire.a.b.a;
                    return null;
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused4) {
                            int i3 = com.baidu.sofire.a.b.a;
                        }
                    }
                }
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr)) == null) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] cArr2 = new char[bArr.length * 2];
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                int i2 = i * 2;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                cArr2[i2 + 1] = cArr[b & 15];
            }
            return new String(cArr2);
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String str2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String str3 = new String(str);
                try {
                    return a(MessageDigest.getInstance("MD5").digest(str3.getBytes()));
                } catch (Throwable unused) {
                    str2 = str3;
                    int i = com.baidu.sofire.a.b.a;
                    return str2;
                }
            } catch (Throwable unused2) {
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i : bArr) {
                if (i < 0) {
                    i += 256;
                }
                StringBuilder sb = new StringBuilder();
                String[] strArr = a;
                sb.append(strArr[i / 16]);
                sb.append(strArr[i % 16]);
                stringBuffer.append(sb.toString());
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }
}
