package com.baidu.android.util.io;

import android.text.TextUtils;
import android.util.Xml;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.client.result.ResultParser;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes.dex */
public class StreamUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    public static final String TAG = "StreamUtils";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1488774828, "Lcom/baidu/android/util/io/StreamUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1488774828, "Lcom/baidu/android/util/io/StreamUtils;");
        }
    }

    public StreamUtils() {
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

    public static boolean bytesToFile(byte[] bArr, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bArr, file)) == null) {
            if (bArr != null && file != null) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.flush();
                    Closeables.closeSafely(fileOutputStream);
                    return true;
                } catch (IOException unused2) {
                    fileOutputStream2 = fileOutputStream;
                    Closeables.closeSafely(fileOutputStream2);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    Closeables.closeSafely(fileOutputStream2);
                    throw th;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String getStringFromInput(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            String readInputStream = FileUtils.readInputStream(inputStream);
            return readInputStream.startsWith(ResultParser.BYTE_ORDER_MARK) ? readInputStream.substring(1) : readInputStream;
        }
        return (String) invokeL.objValue;
    }

    public static byte[] streamToBytes(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65540, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (-1 != read) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } finally {
            Closeables.closeSafely(inputStream);
            Closeables.closeSafely(byteArrayOutputStream);
        }
    }

    @Deprecated
    public static boolean streamToFile(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, inputStream, file)) == null) {
            boolean z = false;
            if (inputStream == null) {
                return false;
            }
            if (file == null) {
                Closeables.closeSafely(inputStream);
                return false;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                z = true;
                Closeables.closeSafely(fileOutputStream);
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                Closeables.closeSafely(fileOutputStream2);
                Closeables.closeSafely(inputStream);
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                Closeables.closeSafely(fileOutputStream2);
                Closeables.closeSafely(inputStream);
                throw th;
            }
            Closeables.closeSafely(inputStream);
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static String streamToString(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, inputStream)) == null) ? streamToString(inputStream, Xml.Encoding.UTF_8.toString()) : (String) invokeL.objValue;
    }

    public static boolean streamToZipFile(InputStream inputStream, ZipOutputStream zipOutputStream, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65544, null, inputStream, zipOutputStream, str)) != null) {
            return invokeLLL.booleanValue;
        }
        if (inputStream == null || zipOutputStream == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            byte[] bArr = new byte[4096];
            zipOutputStream.putNextEntry(new ZipEntry(str));
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    return true;
                }
            }
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0032 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x000d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.Closeable, java.lang.Object, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    public static String streamToString(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, inputStream, str)) == null) {
            BufferedReader bufferedReader = null;
            if (inputStream == 0) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader((InputStream) inputStream, str), 8192);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                        } catch (Exception e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            Closeables.closeSafely((Closeable) inputStream);
                            Closeables.closeSafely(bufferedReader);
                            inputStream = sb.toString();
                            return inputStream;
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            Closeables.closeSafely((Closeable) inputStream);
                            Closeables.closeSafely(bufferedReader);
                            inputStream = sb.toString();
                            return inputStream;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            Closeables.closeSafely((Closeable) inputStream);
                            Closeables.closeSafely(bufferedReader);
                            throw th;
                        }
                    }
                    Closeables.closeSafely((Closeable) inputStream);
                    Closeables.closeSafely(bufferedReader2);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
            } catch (OutOfMemoryError e5) {
                e = e5;
            }
            inputStream = sb.toString();
            return inputStream;
        }
        return (String) invokeLL.objValue;
    }
}
