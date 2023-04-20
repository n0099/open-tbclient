package com.baidu.android.util.io;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.p81;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes.dex */
public final class FileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 1024;
    public static final boolean DEBUG = false;
    public static final String EXTERNAL_STORAGE_DIRECTORY = "/baidu";
    public static final String FILE_SCHEMA = "file://";
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    public static int FS_BLOCK_SIZE = 0;
    public static int INVALID_INDEX = -1;
    public static int ONE_INCREAMENT = 1;
    public static final String SEARCHBOX_FOLDER = "searchbox";
    public static final String TAG = "FileUtils";
    public static final String UNKNOW = "未知";
    public static final int UNZIP_BUFFER = 2048;
    public static String sCacheDir;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-157102896, "Lcom/baidu/android/util/io/FileUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-157102896, "Lcom/baidu/android/util/io/FileUtils;");
        }
    }

    public FileUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @TargetApi(8)
    @Deprecated
    public static String getCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return getCacheDir(AppRuntime.getAppContext());
        }
        return (String) invokeV.objValue;
    }

    public static int getFSBlockSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (FS_BLOCK_SIZE == 0) {
                int blockSize = new StatFs("/data").getBlockSize();
                FS_BLOCK_SIZE = blockSize;
                if (blockSize <= 0) {
                    FS_BLOCK_SIZE = 8192;
                }
            }
            return FS_BLOCK_SIZE;
        }
        return invokeV.intValue;
    }

    public static boolean cache(Context context, String str, String str2, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65538, null, context, str, str2, i)) == null) {
            return cache(context, str, str2.getBytes(), i);
        }
        return invokeLLLI.booleanValue;
    }

    public static boolean cache(Context context, String str, byte[] bArr, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65539, null, context, str, bArr, i)) == null) {
            boolean z = false;
            if (bArr == null) {
                bArr = new byte[0];
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    try {
                        try {
                            fileOutputStream = context.openFileOutput(str, i);
                            fileOutputStream.write(bArr);
                            fileOutputStream.flush();
                            z = true;
                        } catch (IOException e) {
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Throwable th) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return z;
        }
        return invokeLLLI.booleanValue;
    }

    public static long copy(File file, File file2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, file, file2)) == null) {
            long j = 0;
            if (file == null || file2 == null || !file.exists()) {
                return 0L;
            }
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                j = copyStream(fileInputStream, fileOutputStream);
                Closeables.closeSafely(fileInputStream);
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    Closeables.closeSafely(fileInputStream2);
                    Closeables.closeSafely(fileOutputStream);
                    return j;
                } catch (Throwable th3) {
                    th = th3;
                    Closeables.closeSafely(fileInputStream2);
                    Closeables.closeSafely(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = fileInputStream;
                Closeables.closeSafely(fileInputStream2);
                Closeables.closeSafely(fileOutputStream);
                throw th;
            }
            Closeables.closeSafely(fileOutputStream);
            return j;
        }
        return invokeLL.longValue;
    }

    public static String insertTagInFileName(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                int lastIndexOf = str.lastIndexOf(46);
                StringBuilder sb = new StringBuilder();
                if (lastIndexOf > -1 && lastIndexOf < str.length()) {
                    sb.append(str.substring(0, lastIndexOf));
                    if (!TextUtils.isEmpty(str2)) {
                        sb.append(str2);
                    }
                    sb.append(str.substring(lastIndexOf));
                    return sb.toString();
                }
                return str;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void saveToGzip(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65584, null, bArr, file) == null) && bArr != null && bArr.length > 0 && file != null) {
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file, false));
                try {
                    byte[] bArr2 = new byte[1024];
                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                    while (true) {
                        try {
                            int read = byteArrayInputStream.read(bArr2, 0, 1024);
                            if (read <= 0) {
                                break;
                            }
                            gZIPOutputStream2.write(bArr2, 0, read);
                        } catch (IOException e) {
                            e = e;
                            gZIPOutputStream = gZIPOutputStream2;
                            try {
                                e.printStackTrace();
                                Closeables.closeSafely(gZIPOutputStream);
                                Closeables.closeSafely(byteArrayInputStream);
                            } catch (Throwable th) {
                                th = th;
                                Closeables.closeSafely(gZIPOutputStream);
                                Closeables.closeSafely(byteArrayInputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            gZIPOutputStream = gZIPOutputStream2;
                            Closeables.closeSafely(gZIPOutputStream);
                            Closeables.closeSafely(byteArrayInputStream);
                            throw th;
                        }
                    }
                    gZIPOutputStream2.finish();
                    Closeables.closeSafely(gZIPOutputStream2);
                } catch (IOException e2) {
                    e = e2;
                    byteArrayInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayInputStream = null;
                }
            } catch (IOException e3) {
                e = e3;
                byteArrayInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayInputStream = null;
            }
            Closeables.closeSafely(byteArrayInputStream);
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, inputStream, outputStream)) == null) {
            if (inputStream != null && outputStream != null) {
                try {
                    byte[] bArr = new byte[p81.a];
                    long j = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                            j += read;
                        } else {
                            outputStream.flush();
                            return j;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    public static File getPublicExternalDiretory(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65562, null, str, str2)) == null) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            File file = new File(externalStorageDirectory, EXTERNAL_STORAGE_DIRECTORY + File.separator + str2);
            if (ensureDirectoryExist(file)) {
                return new File(file, str);
            }
            return null;
        }
        return (File) invokeLL.objValue;
    }

    public static void saveToFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65579, null, inputStream, file) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                copyStream(inputStream, fileOutputStream);
                fileOutputStream.close();
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    @Deprecated
    public static long copyFile(File file, File file2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, file, file2)) == null) {
            return copy(file, file2);
        }
        return invokeLL.longValue;
    }

    @Deprecated
    public static long copyStream(InputStream inputStream, OutputStream outputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, inputStream, outputStream)) == null) {
            return copy(inputStream, outputStream);
        }
        return invokeLL.longValue;
    }

    public static boolean deleteCache(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            try {
                return context.deleteFile(str);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public static String readAssetData(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, context, str)) == null) {
            return AssetUtils.readAsset(context, str);
        }
        return (String) invokeLL.objValue;
    }

    public static String readCacheData(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65569, null, context, str)) == null) {
            try {
                return readInputStream(context.openFileInput(str));
            } catch (FileNotFoundException unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean saveFile(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65575, null, str, file)) == null) {
            if (TextUtils.isEmpty(str) || file.exists()) {
                return false;
            }
            saveFileCommon(str.getBytes(), file);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void saveFileCommon(byte[] bArr, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65578, null, bArr, file) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            saveToFile(byteArrayInputStream, file);
            Closeables.closeSafely(byteArrayInputStream);
        }
    }

    @Deprecated
    public static boolean unzipFile(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65587, null, str, str2)) == null) {
            return ZipUtils.unzipFile(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean createFileSafely(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, file)) == null) {
            if (file != null && !file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    return file.createNewFile();
                } catch (IOException unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean createNewFileSafely(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, file)) == null) {
            return createFileSafely(file);
        }
        return invokeL.booleanValue;
    }

    public static boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (!file.exists()) {
                return false;
            }
            return deleteFile(file);
        }
        return invokeL.booleanValue;
    }

    public static boolean ensureDirectoryExist(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, file)) == null) {
            if (file == null) {
                return false;
            }
            if (!file.exists()) {
                try {
                    file.mkdirs();
                    return true;
                } catch (SecurityException unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean exists(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @TargetApi(8)
    public static String getCacheDir(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (TextUtils.isEmpty(sCacheDir)) {
                sCacheDir = getDeviceCacheDir(context.getApplicationContext());
            }
            return sCacheDir;
        }
        return (String) invokeL.objValue;
    }

    public static String getDeviceCacheDir(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir == null) {
                externalCacheDir = context.getFilesDir();
            }
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getFileNameNoExt(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) > -1 && lastIndexOf < str.length()) {
                return str.substring(0, lastIndexOf);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static File getPublicExternalDiretory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            return getPublicExternalDiretory(str, SEARCHBOX_FOLDER);
        }
        return (File) invokeL.objValue;
    }

    @Deprecated
    public static boolean isExistFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            return exists(str);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isGzipFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            return GZIP.isGzipFile(str);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean isZipFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, file)) == null) {
            return ZipUtils.isZipFile(file);
        }
        return invokeL.booleanValue;
    }

    public static String readFileData(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, file)) == null) {
            try {
                return readInputStream(new FileInputStream(file));
            } catch (FileNotFoundException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean deleteFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, file)) == null) {
            if (file == null) {
                return false;
            }
            boolean z = true;
            if (!file.exists()) {
                return true;
            }
            if (file.isFile()) {
                return true & file.delete();
            }
            if (!file.isDirectory()) {
                return true;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    z &= deleteFile(file2);
                }
            }
            return z & file.delete();
        }
        return invokeL.booleanValue;
    }

    public static String readInputStream(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, inputStream)) == null) {
            if (inputStream == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            try {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    String sb2 = sb.toString();
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return sb2;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return "";
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean safeDeleteFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, file)) == null) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        String absolutePath = file.getAbsolutePath();
                        File file2 = new File(absolutePath);
                        long currentTimeMillis = System.currentTimeMillis();
                        File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
                        file2.renameTo(file3);
                        return file3.delete();
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String generateFileSizeText(long j) {
        InterceptResult invokeJ;
        Float valueOf;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65551, null, j)) == null) {
            if (j <= 0) {
                return UNKNOW;
            }
            if (j < 1024) {
                return j + "B";
            }
            if (j < 1048576) {
                valueOf = Float.valueOf(((float) j) / 1024.0f);
                str = "KB";
            } else if (j < 1073741824) {
                valueOf = Float.valueOf(((float) j) / 1048576.0f);
                str = "MB";
            } else {
                valueOf = Float.valueOf(((float) j) / 1.0737418E9f);
                str = "GB";
            }
            DecimalFormat decimalFormat = new DecimalFormat("####.##");
            return decimalFormat.format(valueOf) + str;
        }
        return (String) invokeJ.objValue;
    }

    public static long getDirectorySize(File file) throws IOException {
        InterceptResult invokeL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, file)) == null) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return file.length();
            }
            int length2 = listFiles.length;
            long j = 0;
            for (int i = 0; i < length2; i++) {
                if (listFiles[i].isDirectory()) {
                    length = getDirectorySize(listFiles[i]);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
            return j;
        }
        return invokeL.longValue;
    }

    public static String getFileNameFromPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.endsWith(File.separator)) {
                int lastIndexOf = str.lastIndexOf(File.separator);
                int length = str.length();
                if (lastIndexOf != INVALID_INDEX && length > lastIndexOf) {
                    return str.substring(lastIndexOf + ONE_INCREAMENT, length);
                }
                return str;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String getFileNameFromUrl(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            String decode = Uri.decode(str);
            if (decode != null) {
                int indexOf = decode.indexOf(63);
                if (indexOf > 0) {
                    decode = decode.substring(0, indexOf);
                }
                if (!decode.endsWith("/") && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
                    return decode.substring(lastIndexOf);
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static Drawable getSkinDrawableFromBaiduFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (!file.exists() && file.isDirectory()) {
                return null;
            }
            try {
                System.currentTimeMillis();
                Drawable createFromPath = Drawable.createFromPath(str);
                System.currentTimeMillis();
                return createFromPath;
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Drawable) invokeL.objValue;
    }

    public static long getDirectorySize(String str) throws IOException {
        InterceptResult invokeL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            File file = new File(str);
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return file.length();
            }
            int length2 = listFiles.length;
            long j = 0;
            for (int i = 0; i < length2; i++) {
                if (listFiles[i].isDirectory()) {
                    length = getDirectorySize(listFiles[i]);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
            return j;
        }
        return invokeL.longValue;
    }

    public static File saveCacheFile(Context context, byte[] bArr, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65573, null, context, bArr, str)) == null) {
            if (context != null && bArr != null && !TextUtils.isEmpty(str)) {
                File file = new File(context.getCacheDir(), str);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                saveToFile(byteArrayInputStream, file);
                Closeables.closeSafely(byteArrayInputStream);
                return file;
            }
            return null;
        }
        return (File) invokeLLL.objValue;
    }

    @Deprecated
    public static void saveToFile(InputStream inputStream, File file, boolean z) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65580, null, inputStream, file, z) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file, z);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                copyStream(inputStream, fileOutputStream);
                fileOutputStream.close();
            } catch (FileNotFoundException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public static boolean saveToFileWithReturn(InputStream inputStream, File file, boolean z) {
        InterceptResult invokeLLZ;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65582, null, inputStream, file, z)) == null) {
            boolean z2 = false;
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file, z);
            } catch (FileNotFoundException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (copyStream(inputStream, fileOutputStream) != 0) {
                    z2 = true;
                }
                Closeables.closeSafely(fileOutputStream);
                return z2;
            } catch (FileNotFoundException unused2) {
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
        return invokeLLZ.booleanValue;
    }

    public static File saveFile(Context context, byte[] bArr, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65574, null, context, bArr, str, str2)) == null) {
            if (context != null && bArr != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File externalFilesDir = context.getExternalFilesDir(str);
                if (externalFilesDir != null && !externalFilesDir.exists()) {
                    externalFilesDir.mkdirs();
                }
                File file = new File(externalFilesDir, str2);
                saveFileCommon(bArr, file);
                return file;
            }
            return null;
        }
        return (File) invokeLLLL.objValue;
    }

    public static boolean saveFile(String str, File file, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65576, null, str, file, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (file.exists() && !z) {
                return false;
            }
            saveFileCommon(str.getBytes(), file);
            return true;
        }
        return invokeLLZ.booleanValue;
    }

    @Deprecated
    public static void saveToFile(String str, File file, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(65581, null, str, file, z) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        saveToFile(new ByteArrayInputStream(str.getBytes()), file, z);
    }

    public static boolean saveToFileWithReturn(String str, File file, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65583, null, str, file, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return saveToFileWithReturn(new ByteArrayInputStream(str.getBytes()), file, z);
        }
        return invokeLLZ.booleanValue;
    }

    @Deprecated
    public static boolean unzipFileFromAsset(String str, String str2, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65588, null, str, str2, context)) == null) {
            return AssetUtils.unzipFileFromAsset(str, str2, context);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean saveFile(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65577, null, str, str2, z)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return saveFile(str, new File(str2), z);
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    @Deprecated
    public static String toHexString(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65585, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b : bArr) {
                String hexString = Integer.toHexString(b & 255);
                if (z) {
                    hexString = hexString.toUpperCase(Locale.getDefault());
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    @Deprecated
    public static boolean unGzipFile(File file, File file2) {
        InterceptResult invokeLL;
        GZIPInputStream gZIPInputStream;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65586, null, file, file2)) == null) {
            if (file == null) {
                return false;
            }
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    gZIPInputStream = new GZIPInputStream(fileInputStream2);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = gZIPInputStream.read(bArr, 0, 8192);
                                if (read != -1) {
                                    fileOutputStream.write(bArr, 0, read);
                                } else {
                                    fileOutputStream.flush();
                                    Closeables.closeSafely(fileInputStream2);
                                    Closeables.closeSafely(fileOutputStream);
                                    Closeables.closeSafely(gZIPInputStream);
                                    return true;
                                }
                            }
                        } catch (Exception unused) {
                            fileInputStream = fileInputStream2;
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(fileOutputStream);
                            Closeables.closeSafely(gZIPInputStream);
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            Closeables.closeSafely(fileInputStream);
                            Closeables.closeSafely(fileOutputStream);
                            Closeables.closeSafely(gZIPInputStream);
                            throw th;
                        }
                    } catch (Exception unused2) {
                        fileOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                } catch (Exception unused3) {
                    gZIPInputStream = null;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    gZIPInputStream = null;
                    fileOutputStream = null;
                }
            } catch (Exception unused4) {
                gZIPInputStream = null;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                gZIPInputStream = null;
                fileOutputStream = null;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }
}
