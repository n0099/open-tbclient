package com.baidu.pass.main.facesdk.utils;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
/* loaded from: classes4.dex */
public class ZipUtils {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isSuccess;
    public transient /* synthetic */ FieldHolder $fh;

    public ZipUtils() {
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

    public static void addEntry(String str, File file, ZipOutputStream zipOutputStream) throws IOException {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(65537, null, str, file, zipOutputStream) != null) {
            return;
        }
        String str2 = str + file.getName();
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                addEntry(str2 + "/", file2, zipOutputStream);
            }
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            byte[] bArr = new byte[10240];
            fileInputStream = new FileInputStream(file);
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream, 10240);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(str2));
                    while (true) {
                        int read = bufferedInputStream2.read(bArr, 0, 10240);
                        if (read != -1) {
                            zipOutputStream.write(bArr, 0, read);
                        } else {
                            zipOutputStream.closeEntry();
                            IOUtil.closeQuietly(bufferedInputStream2, fileInputStream);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    IOUtil.closeQuietly(bufferedInputStream, fileInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static boolean unZipFolder(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65538, null, str, str2)) != null) {
            return invokeLL.booleanValue;
        }
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (nextEntry.isDirectory()) {
                        new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                    } else {
                        String str3 = str2 + File.separator + name;
                        File file = new File(str2 + File.separator + name);
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                            file.createNewFile();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = zipInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        }
                        fileOutputStream.close();
                    }
                } else {
                    zipInputStream.close();
                    return true;
                }
            }
        } catch (Exception e2) {
            String str4 = "e = " + e2.getMessage();
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean unzip(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, str)) != null) {
            return invokeL.booleanValue;
        }
        File file = new File(str);
        try {
            SafeZipInputStream safeZipInputStream = new SafeZipInputStream(new BufferedInputStream(new FileInputStream(file)));
            while (true) {
                SafeZipEntry safeZipEntry = (SafeZipEntry) safeZipInputStream.getNextEntry();
                if (safeZipEntry != null) {
                    if (!safeZipEntry.isDirectory()) {
                        File file2 = new File(file.getParent(), safeZipEntry.getName());
                        if (!file2.getParentFile().exists()) {
                            file2.getParentFile().mkdirs();
                        }
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int read = safeZipInputStream.read(bArr, 0, 10240);
                            if (read == -1) {
                                break;
                            }
                            bufferedOutputStream.write(bArr, 0, read);
                        }
                        bufferedOutputStream.flush();
                    }
                } else {
                    safeZipInputStream.close();
                    return true;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:14:0x0059 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x005b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.zip.ZipOutputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static File zip(String str) {
        InterceptResult invokeL;
        FileOutputStream fileOutputStream;
        ?? r6;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) != null) {
            return (File) invokeL.objValue;
        }
        File file = new File(str);
        FileOutputStream fileOutputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        File file2 = new File(file.getParent(), file.getName() + ".zip");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            fileOutputStream = new FileOutputStream(file2);
        } catch (IOException e2) {
            e = e2;
            r6 = 0;
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            r6 = new ZipOutputStream(new BufferedOutputStream(fileOutputStream));
            try {
                addEntry("/", file, r6);
                IOUtil.closeQuietly(new Closeable[]{r6, fileOutputStream});
                return file2;
            } catch (IOException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                r6 = r6;
                try {
                    throw new RuntimeException(e);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    fileOutputStream2 = r6;
                    IOUtil.closeQuietly(fileOutputStream2, fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = r6;
                IOUtil.closeQuietly(fileOutputStream2, fileOutputStream);
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            r6 = 0;
        } catch (Throwable th4) {
            th = th4;
            IOUtil.closeQuietly(fileOutputStream2, fileOutputStream);
            throw th;
        }
    }
}
