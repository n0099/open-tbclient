package com.baidu.mobstat;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public final class bt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
                try {
                    return bt.b(MessageDigest.getInstance(PackageTable.MD5), bArr);
                } catch (Exception unused) {
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
                try {
                    return bt.b(MessageDigest.getInstance("SHA-256"), bArr);
                } catch (Exception unused) {
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }

        public static String a(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
                try {
                    return bt.b(MessageDigest.getInstance("SHA-256"), file);
                } catch (NoSuchAlgorithmException unused) {
                    return "";
                }
            }
            return (String) invokeL.objValue;
        }
    }

    public static String b(MessageDigest messageDigest, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, messageDigest, bArr)) == null) {
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        }
        return (String) invokeLL.objValue;
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = (bArr[i2] >> 4) & 15;
                int i4 = bArr[i2] & 15;
                sb.append((char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48));
                sb.append((char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48));
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(MessageDigest messageDigest, File file) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, messageDigest, file)) == null) {
            if (file.isFile()) {
                FileInputStream fileInputStream2 = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    byte[] bArr = new byte[4048];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    fileInputStream.close();
                } catch (Exception unused3) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    return a(messageDigest.digest());
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
                return a(messageDigest.digest());
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }
}
