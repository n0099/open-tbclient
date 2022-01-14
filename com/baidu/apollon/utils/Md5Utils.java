package com.baidu.apollon.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes10.dex */
public final class Md5Utils {
    public static /* synthetic */ Interceptable $ic;
    public static char[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(87227756, "Lcom/baidu/apollon/utils/Md5Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(87227756, "Lcom/baidu/apollon/utils/Md5Utils;");
                return;
            }
        }
        a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public Md5Utils() {
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

    public static synchronized String a(byte[] bArr) {
        InterceptResult invokeL;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            synchronized (Md5Utils.class) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(bArr);
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb2 = new StringBuilder();
                    for (byte b2 : digest) {
                        sb2.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
                    }
                    sb = sb2.toString();
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return sb;
        }
        return (String) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) ? a().digest(bArr) : (byte[]) invokeL.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0051: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:36:0x0051 */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getMd5FromFile(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = null;
                str2 = null;
                str2 = null;
                str2 = null;
                str2 = null;
                FileInputStream fileInputStream3 = null;
                try {
                    try {
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                MessageDigest a2 = a();
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    a2.update(bArr, 0, read);
                                }
                                str2 = md5Hex(a2.digest());
                                fileInputStream.close();
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return str2;
                            } catch (IOException e3) {
                                e = e3;
                                e.printStackTrace();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return str2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream3 = fileInputStream2;
                            if (fileInputStream3 != null) {
                                try {
                                    fileInputStream3.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        fileInputStream = null;
                    } catch (IOException e6) {
                        e = e6;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream3 != null) {
                        }
                        throw th;
                    }
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                return str2;
            }
            throw new IllegalArgumentException("file path is empty");
        }
        return (String) invokeL.objValue;
    }

    public static String md5Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) ? a(b(bArr), null) : (String) invokeL.objValue;
    }

    public static String toMD5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (str != null) {
                try {
                    return a(str.getBytes("GBK"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String toMD5NoEncode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (str != null) {
                return a(str.getBytes());
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"NewApi"})
    public static String toMD5UCS2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (str != null) {
                try {
                    return a(new String(str.getBytes("GBK"), "GBK").getBytes("UTF-16LE"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String md5Hex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? a(a(str), null) : (String) invokeL.objValue;
    }

    public static String toMD5(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, str2)) == null) {
            if (str != null) {
                try {
                    return a(str.getBytes(str2));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static MessageDigest a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
        return (MessageDigest) invokeV.objValue;
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) ? b(str.getBytes()) : (byte[]) invokeL.objValue;
    }

    public static String a(byte[] bArr, Character ch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bArr, ch)) == null) {
            StringBuffer stringBuffer = new StringBuffer(bArr.length * (ch == null ? 2 : 3));
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = (bArr[i2] >>> 4) & 15;
                int i4 = bArr[i2] & 15;
                if (i2 > 0 && ch != null) {
                    stringBuffer.append(ch.charValue());
                }
                stringBuffer.append(a[i3]);
                stringBuffer.append(a[i4]);
            }
            return stringBuffer.toString();
        }
        return (String) invokeLL.objValue;
    }
}
