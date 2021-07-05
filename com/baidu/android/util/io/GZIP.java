package com.baidu.android.util.io;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public final class GZIP {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int NUM_1024 = 1024;
    public transient /* synthetic */ FieldHolder $fh;

    public GZIP() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static byte[] gZip(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
            byte[] bArr2 = null;
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return bArr2;
            } catch (Exception e2) {
                e2.printStackTrace();
                return bArr2;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean isGzipFile(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                byte[] bArr = new byte[4];
                FileInputStream fileInputStream2 = null;
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileInputStream.read(bArr);
                } catch (Exception unused2) {
                    fileInputStream2 = fileInputStream;
                    Closeables.closeSafely(fileInputStream2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    Closeables.closeSafely(fileInputStream2);
                    throw th;
                }
                if ("1F8B0800".equalsIgnoreCase(FileUtils.toHexString(bArr, "", true))) {
                    Closeables.closeSafely(fileInputStream);
                    return true;
                }
                Closeables.closeSafely(fileInputStream);
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static byte[] unGZip(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        byte[] bArr2 = null;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr3 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr3, 0, 1024);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr3, 0, read);
                } else {
                    bArr2 = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return bArr2;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return bArr2;
        }
    }
}
