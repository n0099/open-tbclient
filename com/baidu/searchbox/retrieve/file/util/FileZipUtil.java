package com.baidu.searchbox.retrieve.file.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes4.dex */
public class FileZipUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG;
    public static final String TAG = "FileZipUtil";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-886319193, "Lcom/baidu/searchbox/retrieve/file/util/FileZipUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-886319193, "Lcom/baidu/searchbox/retrieve/file/util/FileZipUtil;");
                return;
            }
        }
        DEBUG = AppConfig.isDebug();
    }

    public FileZipUtil() {
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

    public static String convertHashToString(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            String str = "";
            for (int i2 = 0; i2 < bArr.length; i2++) {
                str = str + Integer.toString((bArr[i2] & 255) + 256, 16).substring(1);
            }
            return str.toLowerCase();
        }
        return (String) invokeL.objValue;
    }

    public static boolean copyFile(File file, File file2) {
        FileChannel fileChannel;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65539, null, file, file2)) != null) {
            return invokeLL.booleanValue;
        }
        try {
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (!file2.exists()) {
                file2.createNewFile();
            }
            FileChannel fileChannel2 = null;
            try {
                FileChannel channel = new FileInputStream(file).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(file2).getChannel();
                    fileChannel2.transferFrom(channel, 0L, channel.size());
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                        return true;
                    }
                    return true;
                } catch (Throwable th) {
                    th = th;
                    FileChannel fileChannel3 = fileChannel2;
                    fileChannel2 = channel;
                    fileChannel = fileChannel3;
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
        } catch (IOException e2) {
            if (DEBUG) {
                e2.printStackTrace();
                return false;
            }
            return false;
        }
    }

    public static void deleteDirWithFile(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file) == null) && file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else if (file2.isDirectory()) {
                        deleteDirWithFile(file2);
                    }
                }
            }
            file.delete();
        }
    }

    public static String fileToSHA1(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Exception unused) {
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                int i2 = 0;
                while (i2 != -1) {
                    i2 = fileInputStream.read(bArr);
                    if (i2 > 0) {
                        messageDigest.update(bArr, 0, i2);
                    }
                }
                String convertHashToString = convertHashToString(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (Exception unused2) {
                }
                return convertHashToString;
            } catch (Exception unused3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception unused4) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused5) {
                    }
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void populateFilesList(File file, List<String> list) throws IOException {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65542, null, file, list) == null) || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                list.add(file2.getAbsolutePath());
            } else {
                populateFilesList(file2, list);
            }
        }
    }

    public static boolean zipDirectory(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, file, str)) == null) {
            try {
                ArrayList<String> arrayList = new ArrayList();
                populateFilesList(file, arrayList);
                if (arrayList.size() == 0) {
                    return false;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                for (String str2 : arrayList) {
                    if (DEBUG) {
                        String str3 = "Zipping " + str2;
                    }
                    zipOutputStream.putNextEntry(new ZipEntry(str2.substring(file.getAbsolutePath().length() + 1, str2.length())));
                    FileInputStream fileInputStream = new FileInputStream(str2);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            zipOutputStream.write(bArr, 0, read);
                        }
                    }
                    zipOutputStream.closeEntry();
                    fileInputStream.close();
                }
                zipOutputStream.close();
                fileOutputStream.close();
                return true;
            } catch (IOException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void zipSingleFile(File file, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, file, str) == null) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                fileInputStream.close();
                fileOutputStream.close();
                if (DEBUG) {
                    String str2 = file.getCanonicalPath() + " is zipped to " + str;
                }
            } catch (IOException e2) {
                if (DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
