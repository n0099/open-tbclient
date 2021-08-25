package c.a.f0.a.c;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(File file) {
        InterceptResult invokeL;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, file)) != null) {
            return (String) invokeL.objValue;
        }
        if (file == null || !file.exists()) {
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                byte[] bArr = new byte[102400];
                FileInputStream fileInputStream2 = new FileInputStream(file);
                do {
                    try {
                        read = fileInputStream2.read(bArr, 0, 102400);
                        if (read < 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        if (c.a.f0.a.b.a.f3346a.get().t()) {
                            throw new RuntimeException(e);
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } while (read > 0);
                String a2 = a(messageDigest.digest());
                try {
                    fileInputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                return a2;
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                return a(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
                return String.valueOf(str.hashCode());
            }
        }
        return (String) invokeL.objValue;
    }
}
