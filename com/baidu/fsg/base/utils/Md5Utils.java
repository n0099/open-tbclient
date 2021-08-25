package com.baidu.fsg.base.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Md5Utils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static char[] f39472a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(9483343, "Lcom/baidu/fsg/base/utils/Md5Utils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(9483343, "Lcom/baidu/fsg/base/utils/Md5Utils;");
                return;
            }
        }
        f39472a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
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
                stringBuffer.append(f39472a[i3]);
                stringBuffer.append(f39472a[i4]);
            }
            return stringBuffer.toString();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? b(str.getBytes()) : (byte[]) invokeL.objValue;
    }

    public static byte[] b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, bArr)) == null) ? a().digest(bArr) : (byte[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x001d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x002b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x000b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x000b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static String getMd5FromFile(String str) {
        Interceptable interceptable;
        InterceptResult invokeL;
        Interceptable interceptable2 = $ic;
        if (interceptable2 == null || (invokeL = (interceptable = interceptable2).invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("file path is empty");
            }
            String str2 = null;
            str2 = null;
            str2 = null;
            FileInputStream fileInputStream = null;
            try {
            } catch (Throwable th) {
                th = th;
                fileInputStream = interceptable;
            }
            try {
                try {
                    interceptable = new FileInputStream(str);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    str2 = getMd5FromInputStream(interceptable);
                    interceptable.close();
                    interceptable = interceptable;
                } catch (FileNotFoundException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (interceptable != 0) {
                        interceptable.close();
                        interceptable = interceptable;
                    }
                    return str2;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                interceptable = 0;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String getMd5FromInputStream(InputStream inputStream) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, inputStream)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                MessageDigest a2 = a();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    a2.update(bArr, 0, read);
                }
                for (byte b2 : a2.digest()) {
                    sb.append(Integer.toHexString((b2 & 255) | (-256)).substring(6));
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String md5Hex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? a(a(str), null) : (String) invokeL.objValue;
    }

    public static String md5Hex(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) ? a(b(bArr), null) : (String) invokeL.objValue;
    }

    public static String toMD5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (str != null) {
                try {
                    return a(str.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String toMD5(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
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

    public static String toMD5NoEncode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (str != null) {
                try {
                    return a(new String(str.getBytes("UTF-8"), "GBK").getBytes("UTF-16LE"));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String toMds(JSONObject jSONObject, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, jSONObject, str, str2)) == null) {
            StringBuilder sb = new StringBuilder();
            if (jSONObject != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    arrayList.add(keys.next());
                }
                Collections.sort(arrayList);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    String str3 = (String) arrayList.get(i2);
                    String optString = jSONObject.optString(str3);
                    sb.append(str3 + "=" + optString + str2);
                }
            }
            sb.append("key=" + str);
            return toMD5(sb.toString());
        }
        return (String) invokeLLL.objValue;
    }
}
