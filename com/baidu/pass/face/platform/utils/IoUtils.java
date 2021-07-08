package com.baidu.pass.face.platform.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.util.zip.ZipFile;
/* loaded from: classes2.dex */
public class IoUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 1024;
    public static final int EOF = -1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public interface ProgressListener {
        void progress(long j, long j2);
    }

    public IoUtils() {
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

    public static void closeQuietly(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, inputStream, outputStream) != null) {
            return;
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    public static byte[] loadBytes(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    copyStream(inputStream, byteArrayOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    closeQuietly(byteArrayOutputStream);
                    return null;
                }
            } finally {
                closeQuietly(byteArrayOutputStream);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String loadContent(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, inputStream)) == null) ? loadContent(inputStream, null) : (String) invokeL.objValue;
    }

    public static String loadContent(InputStream inputStream, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, inputStream, str)) == null) {
            if (inputStream != null) {
                if (TextUtils.isEmpty(str)) {
                    str = System.getProperty("file.encoding", "utf-8");
                }
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
                StringWriter stringWriter = new StringWriter();
                char[] cArr = new char[4096];
                for (int read = inputStreamReader.read(cArr); read > 0; read = inputStreamReader.read(cArr)) {
                    stringWriter.write(cArr, 0, read);
                }
                return stringWriter.toString();
            }
            throw new IllegalArgumentException("stream may not be null.");
        }
        return (String) invokeLL.objValue;
    }

    public static void closeQuietly(ServerSocket serverSocket) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, serverSocket) == null) || serverSocket == null) {
            return;
        }
        try {
            serverSocket.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void copyStream(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream, file) == null) {
            try {
                fileOutputStream = FileUtils.openNewFileOutput(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                copyStream(inputStream, fileOutputStream);
                closeQuietly(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileOutputStream);
                throw th;
            }
        }
    }

    public static void closeQuietly(ZipFile zipFile) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, zipFile) == null) || zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void copyStream(InputStream inputStream, File file, long j, ProgressListener progressListener) throws IOException {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{inputStream, file, Long.valueOf(j), progressListener}) == null) {
            try {
                fileOutputStream = FileUtils.openNewFileOutput(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                copyStream(inputStream, fileOutputStream, j, progressListener);
                closeQuietly(fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileOutputStream);
                throw th;
            }
        }
    }

    public static void copyStream(InputStream inputStream, OutputStream outputStream, long j, ProgressListener progressListener) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(65543, null, new Object[]{inputStream, outputStream, Long.valueOf(j), progressListener}) != null) {
            return;
        }
        byte[] bArr = new byte[1024];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
            j2 += read;
            if (progressListener != null) {
                progressListener.progress(j2, j);
            }
        }
    }
}
