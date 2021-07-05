package com.baidu.ar.h;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.zxing.client.result.ResultParser;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, inputStream)) == null) ? a(inputStream, (String) null) : (String) invokeL.objValue;
    }

    public static String a(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, inputStream, str)) == null) {
            if (inputStream != null) {
                if (TextUtils.isEmpty(str)) {
                    str = System.getProperty("file.encoding", "utf-8");
                }
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[4096];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read <= 0) {
                        break;
                    }
                    stringWriter.write(cArr, 0, read);
                }
                String stringWriter2 = stringWriter.toString();
                inputStreamReader.close();
                stringWriter.close();
                return ("utf-8".equalsIgnoreCase(str) && stringWriter2.startsWith(ResultParser.BYTE_ORDER_MARK)) ? stringWriter2.substring(1) : stringWriter2;
            }
            throw new IllegalArgumentException("stream may not be null.");
        }
        return (String) invokeLL.objValue;
    }

    public static void a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, inputStream, file) == null) {
            try {
                fileOutputStream = i.e(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                a(inputStream, fileOutputStream);
                closeQuietly(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileOutputStream);
                throw th;
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, inputStream, outputStream) != null) {
            return;
        }
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
