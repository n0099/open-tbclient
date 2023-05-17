package com.baidu.platform.comapi.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65536, null, closeable) != null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, inputStream, outputStream, bArr) == null) {
            if (inputStream != null && outputStream != null && bArr != null) {
                try {
                    if (!(inputStream instanceof BufferedInputStream)) {
                        inputStream = new BufferedInputStream(inputStream);
                    }
                    if (!(outputStream instanceof BufferedOutputStream)) {
                        outputStream = new BufferedOutputStream(outputStream);
                    }
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            outputStream.write(bArr, 0, read);
                        } else {
                            outputStream.flush();
                            return;
                        }
                    }
                } finally {
                    a(inputStream);
                    a(outputStream);
                }
            } else {
                throw new IOException("copyStream : outputStream or inputStream is null");
            }
        }
    }
}
