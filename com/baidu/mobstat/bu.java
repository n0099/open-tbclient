package com.baidu.mobstat;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes7.dex */
public final class bu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(InputStream inputStream, OutputStream outputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, inputStream, outputStream)) == null) {
            if (inputStream != null && outputStream != null) {
                byte[] bArr = new byte[4048];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            return true;
                        }
                        outputStream.write(bArr, 0, read);
                    } catch (IOException unused) {
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65536, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }
}
