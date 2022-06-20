package com.baidu.searchbox;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.bsdiff.BsPatchNative;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public class NPSPatchUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    public transient /* synthetic */ FieldHolder $fh;

    public NPSPatchUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void closeSafely(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static int nativePatch(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    File file2 = new File(str3);
                    if (file2.exists() && file2.isFile()) {
                        try {
                            int patch = BsPatchNative.patch(str, str2, str3);
                            try {
                                file2.delete();
                                return patch;
                            } catch (Throwable unused) {
                                return patch;
                            }
                        } catch (Throwable unused2) {
                            return 1;
                        }
                    }
                }
            }
            return 3;
        }
        return invokeLLL.intValue;
    }

    public static int patch(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) ? nativePatch(str, str2, str3) : invokeLLL.intValue;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static String toMd5(File file, boolean z) {
        InterceptResult invokeLZ;
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLZ = interceptable.invokeLZ(65541, null, file, z)) != null) {
            return (String) invokeLZ.objValue;
        }
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            fileInputStream = new FileInputStream(file);
        } catch (Throwable unused) {
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                } else {
                    String hexString = toHexString(messageDigest.digest(), "", z);
                    closeSafely(fileInputStream);
                    return hexString;
                }
            }
        } catch (Throwable unused2) {
            closeSafely(fileInputStream);
            return null;
        }
    }
}
