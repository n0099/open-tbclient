package com.alipay.security.mobile.module.a;

import android.os.Environment;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                return (File) Environment.class.getMethod(new String(com.alipay.security.mobile.module.a.a.a.a("Z2V0RXh0ZXJuYWxTdG9yYWdlRGlyZWN0b3J5")), new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
        return (File) invokeV.objValue;
    }

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, th)) == null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String a(Map<String, String> map, String str, String str2) {
        InterceptResult invokeLLL;
        String str3;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, map, str, str2)) == null) ? (map == null || (str3 = map.get(str)) == null) ? str2 : str3 : (String) invokeLLL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str != null && (length = str.length()) != 0) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (!Character.isWhitespace(str.charAt(i2))) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) ? str == null ? str2 == null : str.equals(str2) : invokeLL.booleanValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            try {
                return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            } catch (Exception unused) {
                return str2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? !a(str) : invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        byte[] bytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            for (byte b2 : str.getBytes()) {
                if ((b2 >= 0 && b2 <= 31) || b2 >= Byte.MAX_VALUE) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            try {
                if (a(str)) {
                    return null;
                }
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                messageDigest.update(str.getBytes("UTF-8"));
                byte[] digest = messageDigest.digest();
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < digest.length; i2++) {
                    sb.append(String.format("%02x", Byte.valueOf(digest[i2])));
                }
                return sb.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            try {
                byte[] array = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(str.length()).array();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(str.getBytes("UTF-8"));
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                byte[] bArr = new byte[byteArrayOutputStream.toByteArray().length + 4];
                System.arraycopy(array, 0, bArr, 0, 4);
                System.arraycopy(byteArrayOutputStream.toByteArray(), 0, bArr, 4, byteArrayOutputStream.toByteArray().length);
                return Base64.encodeToString(bArr, 8);
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65547, null, str)) != null) {
            return (String) invokeL.objValue;
        }
        if (a(str)) {
            return "";
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("utf-8"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    gZIPOutputStream.flush();
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                    return new String(Base64.encode(byteArray, 2));
                }
                gZIPOutputStream.write(bArr, 0, read);
            }
        } catch (Exception unused) {
            return "";
        }
    }
}
