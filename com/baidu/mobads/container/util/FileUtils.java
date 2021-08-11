package com.baidu.mobads.container.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
/* loaded from: classes5.dex */
public class FileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int IO_BUF_SIZE = 32768;
    public transient /* synthetic */ FieldHolder $fh;

    public FileUtils() {
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

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0058, code lost:
        if (r4 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005a, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0066, code lost:
        if (r4 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0071, code lost:
        if (r4 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0074, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyFile(String str, String str2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, str, str2)) != null) {
            return invokeLL.booleanValue;
        }
        FileInputStream fileInputStream = null;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str).exists()) {
                return false;
            }
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (FileNotFoundException unused) {
                fileOutputStream = null;
            } catch (IOException unused2) {
                fileOutputStream = null;
            } catch (Throwable unused3) {
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream2.close();
                fileOutputStream.close();
                try {
                    fileInputStream2.close();
                } catch (Exception unused4) {
                }
                try {
                    fileOutputStream.close();
                } catch (Exception unused5) {
                }
                return true;
            } catch (FileNotFoundException unused6) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused7) {
                    }
                }
            } catch (IOException unused8) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused9) {
                    }
                }
            } catch (Throwable unused10) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused11) {
                    }
                }
            }
        } catch (FileNotFoundException unused12) {
            fileOutputStream = null;
        } catch (IOException unused13) {
            fileOutputStream = null;
        } catch (Throwable unused14) {
            fileOutputStream = null;
        }
    }

    public static void copyFileFromAssetsTo(Context context, String str, String str2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, context, str, str2) == null) {
            try {
                copyFileInputStream(context.getAssets().open(str), str2);
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2);
            }
        }
    }

    public static void copyFileInputStream(InputStream inputStream, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65539, null, inputStream, str) != null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(str);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                fileOutputStream2.close();
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static File deleteFileRecursive(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            try {
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        File deleteFileRecursive = deleteFileRecursive(file2);
                        if (deleteFileRecursive != null) {
                            return deleteFileRecursive;
                        }
                    }
                }
                if (file.delete()) {
                    return null;
                }
                return file;
            } catch (Exception unused) {
                if (file.delete()) {
                    return null;
                }
                return file;
            }
        }
        return (File) invokeL.objValue;
    }

    public static String getFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            try {
                String path = new URI(str).getPath();
                return path.substring(path.lastIndexOf(47) + 1, path.length());
            } catch (URISyntaxException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isFileExistsAndCanRead(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            if (file != null) {
                try {
                    if (file.exists() && file.canRead()) {
                        return file.length() > 0;
                    }
                    return false;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static byte[] readFileToByteArray(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65545, null, file)) != null) {
            return (byte[]) invokeL.objValue;
        }
        try {
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            byte[] bArr = new byte[32768];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    tryClose(byteArrayOutputStream);
                                    tryClose(fileInputStream);
                                    return byteArray;
                                }
                            }
                        } catch (IOException e2) {
                            e = e2;
                            RemoteXAdLogger.getInstance().d("Failed to read file", e);
                            tryClose(byteArrayOutputStream);
                            tryClose(fileInputStream);
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        tryClose(byteArrayOutputStream);
                        tryClose(fileInputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    tryClose(byteArrayOutputStream);
                    tryClose(fileInputStream);
                    throw th;
                }
            } else {
                throw new FileNotFoundException();
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static boolean renameFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) {
            try {
                File file = new File(str);
                File file2 = new File(str2);
                if (file.exists()) {
                    return file.renameTo(file2);
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x002a */
    /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: java.io.BufferedOutputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r5v7, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6 */
    public static void saveBytesToFile(byte[] bArr, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        FileOutputStream fileOutputStream3;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, bArr, file) == null) {
            FileOutputStream fileOutputStream4 = null;
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                    try {
                        bufferedOutputStream.write(bArr);
                        fileOutputStream.flush();
                        bufferedOutputStream.flush();
                        tryClose(fileOutputStream);
                        fileOutputStream3 = bufferedOutputStream;
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream4 = fileOutputStream;
                        fileOutputStream2 = bufferedOutputStream;
                        try {
                            RemoteXAdLogger.getInstance().d("Failed to save file", e);
                            tryClose(fileOutputStream4);
                            fileOutputStream3 = fileOutputStream2;
                            tryClose(fileOutputStream3);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream4;
                            fileOutputStream4 = fileOutputStream2;
                            tryClose(fileOutputStream);
                            tryClose(fileOutputStream4);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream4 = bufferedOutputStream;
                        try {
                            RemoteXAdLogger.getInstance().d("Failed to save file", th);
                            tryClose(fileOutputStream);
                            tryClose(fileOutputStream4);
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            tryClose(fileOutputStream);
                            tryClose(fileOutputStream4);
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedOutputStream = 0;
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e4) {
                e = e4;
                fileOutputStream2 = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
            tryClose(fileOutputStream3);
        }
    }

    public static void tryClose(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            RemoteXAdLogger.getInstance().e("Failed to close the target", e2);
        }
    }

    public static boolean isFileExistsAndCanRead(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                File file = new File(str);
                if (file.exists() && file.canRead()) {
                    return file.length() > 0;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static File deleteFileRecursive(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? deleteFileRecursive(new File(str)) : (File) invokeL.objValue;
    }
}
