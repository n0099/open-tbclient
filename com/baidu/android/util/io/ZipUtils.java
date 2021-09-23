package com.baidu.android.util.io;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
/* loaded from: classes5.dex */
public final class ZipUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ZipUtils";
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

    public static boolean isZipFile(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
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
                    if ("504B0304".equalsIgnoreCase(FileUtils.toHexString(bArr, "", true))) {
                        Closeables.closeSafely(fileInputStream);
                        return true;
                    }
                    Closeables.closeSafely(fileInputStream);
                    return false;
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
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean unzipFile(String str, String str2) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            System.currentTimeMillis();
            if (str == null) {
                return false;
            }
            if (str2 == null) {
                str2 = new File(str).getParent();
            }
            try {
                ZipFile zipFile = new ZipFile(str);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                FileOutputStream fileOutputStream = null;
                BufferedInputStream bufferedInputStream = null;
                BufferedOutputStream bufferedOutputStream2 = null;
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    if (!nextElement.getName().contains(Constants.PATH_PARENT)) {
                        File file = new File(str2 + "/" + nextElement.getName());
                        if (nextElement.isDirectory()) {
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                        } else {
                            if (!file.exists()) {
                                FileUtils.createFileSafely(file);
                            }
                            try {
                                try {
                                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                    try {
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                        try {
                                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream2, FileUtils.getFSBlockSize());
                                        } catch (IOException e2) {
                                            e = e2;
                                            fileOutputStream = fileOutputStream2;
                                        } catch (Throwable th) {
                                            th = th;
                                            fileOutputStream = fileOutputStream2;
                                        }
                                        try {
                                            byte[] bArr = new byte[FileUtils.getFSBlockSize()];
                                            while (true) {
                                                int read = bufferedInputStream2.read(bArr, 0, FileUtils.getFSBlockSize());
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream.write(bArr, 0, read);
                                            }
                                            bufferedOutputStream.flush();
                                            Closeables.closeSafely(bufferedOutputStream);
                                            Closeables.closeSafely(bufferedInputStream2);
                                            Closeables.closeSafely(fileOutputStream2);
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            bufferedInputStream = bufferedInputStream2;
                                        } catch (IOException e3) {
                                            e = e3;
                                            fileOutputStream = fileOutputStream2;
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            bufferedInputStream = bufferedInputStream2;
                                            e.printStackTrace();
                                            Closeables.closeSafely(bufferedOutputStream2);
                                            Closeables.closeSafely(bufferedInputStream);
                                            Closeables.closeSafely(fileOutputStream);
                                            return false;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileOutputStream = fileOutputStream2;
                                            bufferedOutputStream2 = bufferedOutputStream;
                                            bufferedInputStream = bufferedInputStream2;
                                            Closeables.closeSafely(bufferedOutputStream2);
                                            Closeables.closeSafely(bufferedInputStream);
                                            Closeables.closeSafely(fileOutputStream);
                                            throw th;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (IOException e5) {
                                e = e5;
                            }
                        }
                    }
                }
                zipFile.close();
                System.currentTimeMillis();
                return true;
            } catch (Exception e6) {
                e6.printStackTrace();
                return false;
            } finally {
                System.currentTimeMillis();
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0062 -> B:47:0x0065). Please submit an issue!!! */
    public static void zip(String str, String str2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            ZipOutputStream zipOutputStream = null;
            try {
                try {
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str2);
                File file2 = new File(str);
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file));
                try {
                    if (file2.isFile()) {
                        zipFileOrDirectory(zipOutputStream2, file2, "");
                    } else {
                        File[] listFiles = file2.listFiles();
                        if (listFiles != null) {
                            for (File file3 : listFiles) {
                                zipFileOrDirectory(zipOutputStream2, file3, "");
                            }
                        }
                    }
                    zipOutputStream2.close();
                } catch (IOException unused2) {
                    zipOutputStream = zipOutputStream2;
                    if (zipOutputStream != null) {
                        zipOutputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    zipOutputStream = zipOutputStream2;
                    if (zipOutputStream != null) {
                        try {
                            zipOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    public static void zipFileOrDirectory(ZipOutputStream zipOutputStream, File file, String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, zipOutputStream, file, str) == null) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    if (!file.isDirectory()) {
                        byte[] bArr = new byte[4096];
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            zipOutputStream.closeEntry();
                            fileInputStream = fileInputStream2;
                        } catch (IOException unused) {
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        File[] listFiles = file.listFiles();
                        if (listFiles != null) {
                            for (File file2 : listFiles) {
                                zipFileOrDirectory(zipOutputStream, file2, str + file.getName() + "/");
                            }
                        }
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    @Deprecated
    public static void zip(File file, List<File> list) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, file, list) == null) {
            zip(list, file);
        }
    }

    public static void zip(List<File> list, File file) throws IOException {
        ZipOutputStream zipOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, list, file) == null) || file == null || !file.exists() || list == null || list.size() == 0) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            byte[] bArr = new byte[4096];
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            try {
                zipOutputStream.setComment(file.getName());
                for (File file2 : list) {
                    if (file2.canRead()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file2);
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            fileInputStream2.close();
                            fileInputStream = fileInputStream2;
                        } catch (FileNotFoundException unused) {
                            fileInputStream = fileInputStream2;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(zipOutputStream);
                            throw th;
                        }
                    }
                }
                zipOutputStream.flush();
                zipOutputStream.close();
            } catch (FileNotFoundException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException unused3) {
            zipOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
        Closeables.closeSafely(fileInputStream);
        Closeables.closeSafely(zipOutputStream);
    }
}
