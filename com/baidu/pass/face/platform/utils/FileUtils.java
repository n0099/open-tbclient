package com.baidu.pass.face.platform.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class FileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern RESERVED_CHARS_PATTERN;
    public static final Pattern SAFE_FILENAME_PATTERN;
    public static final int S_IRGRP = 32;
    public static final int S_IROTH = 4;
    public static final int S_IRUSR = 256;
    public static final int S_IRWXG = 56;
    public static final int S_IRWXO = 7;
    public static final int S_IRWXU = 448;
    public static final int S_IWGRP = 16;
    public static final int S_IWOTH = 2;
    public static final int S_IWUSR = 128;
    public static final int S_IXGRP = 8;
    public static final int S_IXOTH = 1;
    public static final int S_IXUSR = 64;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(862567262, "Lcom/baidu/pass/face/platform/utils/FileUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(862567262, "Lcom/baidu/pass/face/platform/utils/FileUtils;");
                return;
            }
        }
        SAFE_FILENAME_PATTERN = Pattern.compile("[\\w%+,./=_-]+");
        RESERVED_CHARS_PATTERN = Pattern.compile("[\\\\/:\\*\\?\\\"<>|]");
    }

    public FileUtils() {
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

    public static void cleanDir(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, file) == null) {
            deleteDir(file, false);
        }
    }

    public static long computeFolderSize(File file) {
        InterceptResult invokeL;
        long computeFolderSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file)) == null) {
            long j = 0;
            if (file == null) {
                return 0L;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        computeFolderSize = file2.length();
                    } else if (file2.isDirectory()) {
                        j += file2.length();
                        computeFolderSize = computeFolderSize(file2);
                    }
                    j += computeFolderSize;
                }
            }
            return j;
        }
        return invokeL.longValue;
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, file, file2) == null) && file.exists()) {
            file2.mkdirs();
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file3 : listFiles) {
                if (file3.isDirectory()) {
                    copyDirectory(file3, new File(file2, file3.getName()));
                } else {
                    copyFile(file3, new File(file2, file3.getName()));
                }
            }
        }
    }

    public static void copyFile(String str, String str2) {
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                IoUtils.copyStream(fileInputStream, new File(str2));
                IoUtils.closeQuietly(fileInputStream);
            } catch (IOException e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                IoUtils.closeQuietly(fileInputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                IoUtils.closeQuietly(fileInputStream2);
                throw th;
            }
        }
    }

    public static File createCollectDirectory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File sDRootFile = getSDRootFile();
            if (sDRootFile == null || !sDRootFile.exists()) {
                return null;
            }
            File file = new File(sDRootFile, "CollectBest");
            if (file.exists()) {
                return file;
            }
            file.mkdirs();
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static void deleteDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            deleteDir(new File(str));
        }
    }

    public static boolean deleteFileIfExist(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void ensureDir(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, file) == null) {
            if (file.exists()) {
                if (file.isFile()) {
                    file.delete();
                    file.mkdirs();
                    return;
                }
                return;
            }
            file.mkdirs();
        }
    }

    public static boolean ensureMkdir(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, file)) == null) {
            if (file == null) {
                return false;
            }
            int i2 = 1;
            File file2 = file;
            while (file2.exists()) {
                String parent = file.getParent();
                file2 = new File(parent, file.getName() + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX);
                i2++;
            }
            return file2.mkdir();
        }
        return invokeL.booleanValue;
    }

    public static void ensureParent(File file) {
        File parentFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65557, null, file) == null) || file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static boolean existsFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return existsFile(new File(str));
        }
        return invokeL.booleanValue;
    }

    public static String getExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return getExtension(new File(str));
        }
        return (String) invokeL.objValue;
    }

    public static String getFileNameWithoutExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            int lastIndexOf = str.lastIndexOf(46);
            return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
        }
        return (String) invokeL.objValue;
    }

    public static String getFileNameWithoutExtensionByPath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return getFileNameWithoutExtension(new File(str));
        }
        return (String) invokeL.objValue;
    }

    public static File getSDRootFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, null)) == null) {
            if (isSdCardAvailable()) {
                return Environment.getExternalStorageDirectory();
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static File getUserDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) ? new File(System.getProperty("user.dir")) : (File) invokeV.objValue;
    }

    public static File getUserHome() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? new File(System.getProperty("user.home")) : (File) invokeV.objValue;
    }

    public static boolean isFilenameSafe(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, file)) == null) ? SAFE_FILENAME_PATTERN.matcher(file.getPath()).matches() : invokeL.booleanValue;
    }

    public static boolean isFilenameValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) ? (TextUtils.isEmpty(str) || RESERVED_CHARS_PATTERN.matcher(str).find()) ? false : true : invokeL.booleanValue;
    }

    public static boolean isSdCardAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? Environment.getExternalStorageState().equals("mounted") : invokeV.booleanValue;
    }

    public static FileOutputStream openNewFileOutput(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, file)) == null) {
            deleteFileIfExist(file);
            ensureParent(file);
            file.createNewFile();
            return new FileOutputStream(file);
        }
        return (FileOutputStream) invokeL.objValue;
    }

    public static byte[] readAssetFileContent(AssetManager assetManager, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, assetManager, str)) == null) {
            Log.i("FileUtil", " try to read asset file :" + str);
            InputStream open = assetManager.open(str);
            int available = open.available();
            byte[] bArr = new byte[available];
            int read = open.read(bArr);
            if (read == available) {
                open.close();
                return bArr;
            }
            throw new IOException("realSize is not equal to size: " + read + ZeusCrashHandler.NAME_SEPERATOR + available);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String readAssetFileUtf8String(AssetManager assetManager, String str) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65573, null, assetManager, str)) == null) ? new String(readAssetFileContent(assetManager, str), Charset.forName("UTF-8")) : (String) invokeLL.objValue;
    }

    public static Map<String, String> readConfig(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, file)) == null) {
            HashMap hashMap = new HashMap();
            String readFileText = readFileText(file);
            if (readFileText != null && !TextUtils.isEmpty(readFileText)) {
                for (String str : readFileText.split("\n")) {
                    String trim = str.trim();
                    if (!TextUtils.isEmpty(trim) && !trim.startsWith("#")) {
                        String[] split = trim.split("=", 2);
                        if (split.length >= 2) {
                            hashMap.put(split[0].trim(), split[1].trim());
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static byte[] readFileBytes(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            if (existsFile(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            byte[] loadBytes = IoUtils.loadBytes(fileInputStream);
                            IoUtils.closeQuietly(fileInputStream);
                            return loadBytes;
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            IoUtils.closeQuietly(fileInputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        IoUtils.closeQuietly(fileInputStream2);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    IoUtils.closeQuietly(fileInputStream2);
                    throw th;
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }

    public static String readFileText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return readFileText(new File(str));
        }
        return (String) invokeL.objValue;
    }

    public static void writeToFile(File file, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65579, null, file, str) == null) {
            writeToFile(file, str, false, "utf-8");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static void writeToFileNio(InputStream inputStream, File file) {
        ReadableByteChannel readableByteChannel;
        FileChannel fileChannel;
        int available;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65585, null, inputStream, file) == null) {
            FileChannel fileChannel2 = null;
            try {
                available = inputStream.available();
                readableByteChannel = Channels.newChannel(inputStream);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    fileChannel = null;
                } catch (Throwable th) {
                    th = th;
                    fileChannel = null;
                }
            } catch (IOException e3) {
                e = e3;
                readableByteChannel = null;
                fileChannel = null;
            } catch (Throwable th2) {
                th = th2;
                readableByteChannel = null;
                fileChannel = null;
            }
            try {
                fileChannel2 = fileOutputStream.getChannel();
                fileChannel2.transferFrom(readableByteChannel, 0L, available);
                IoUtils.closeQuietly(fileOutputStream);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel2);
            } catch (IOException e4) {
                e = e4;
                fileChannel = fileChannel2;
                fileChannel2 = fileOutputStream;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileChannel2);
                    IoUtils.closeQuietly(readableByteChannel);
                    IoUtils.closeQuietly(fileChannel);
                } catch (Throwable th3) {
                    th = th3;
                    IoUtils.closeQuietly(fileChannel2);
                    IoUtils.closeQuietly(readableByteChannel);
                    IoUtils.closeQuietly(fileChannel);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = fileChannel2;
                fileChannel2 = fileOutputStream;
                IoUtils.closeQuietly(fileChannel2);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel);
                throw th;
            }
        }
    }

    public static void cleanDir(File file, FilenameFilter filenameFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, null, file, filenameFilter) == null) {
            deleteDir(file, false, filenameFilter);
        }
    }

    public static void deleteDir(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, file) == null) {
            deleteDir(file, true);
        }
    }

    public static void writeToFile(File file, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, file, str, z) == null) {
            writeToFile(file, str, z, "utf-8");
        }
    }

    public static void cleanDir(File file, FileFilter fileFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, file, fileFilter) == null) {
            deleteDir(file, false, fileFilter);
        }
    }

    public static void deleteDir(File file, FileFilter fileFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, file, fileFilter) == null) {
            deleteDir(file, true, fileFilter);
        }
    }

    public static boolean existsFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, file)) == null) ? file != null && file.exists() && file.isFile() : invokeL.booleanValue;
    }

    public static String getExtension(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, file)) == null) {
            if (file == null) {
                return null;
            }
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            return lastIndexOf >= 0 ? name.substring(lastIndexOf + 1) : "";
        }
        return (String) invokeL.objValue;
    }

    public static String getFileNameWithoutExtension(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, file)) == null) {
            if (file == null) {
                return null;
            }
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            return lastIndexOf >= 0 ? name.substring(0, lastIndexOf) : name;
        }
        return (String) invokeL.objValue;
    }

    public static String readFileText(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            if (existsFile(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        try {
                            String loadContent = IoUtils.loadContent(fileInputStream);
                            IoUtils.closeQuietly(fileInputStream);
                            return loadContent;
                        } catch (IOException e2) {
                            e = e2;
                            e.printStackTrace();
                            IoUtils.closeQuietly(fileInputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        IoUtils.closeQuietly(fileInputStream2);
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    IoUtils.closeQuietly(fileInputStream2);
                    throw th;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static void writeToFile(File file, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65580, null, file, str, str2) == null) {
            writeToFile(file, str, false, str2);
        }
    }

    public static void deleteDir(File file, FilenameFilter filenameFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, file, filenameFilter) == null) {
            deleteDir(file, true, filenameFilter);
        }
    }

    public static void writeToFile(File file, String str, boolean z, String str2) {
        OutputStreamWriter outputStreamWriter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65582, null, new Object[]{file, str, Boolean.valueOf(z), str2}) == null) || file == null || TextUtils.isEmpty(str)) {
            return;
        }
        ensureParent(file);
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, z), str2);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            outputStreamWriter.write(str);
            IoUtils.closeQuietly(outputStreamWriter);
        } catch (IOException e3) {
            e = e3;
            outputStreamWriter2 = outputStreamWriter;
            e.printStackTrace();
            IoUtils.closeQuietly(outputStreamWriter2);
        } catch (Throwable th2) {
            th = th2;
            outputStreamWriter2 = outputStreamWriter;
            IoUtils.closeQuietly(outputStreamWriter2);
            throw th;
        }
    }

    public static void deleteDir(File file, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65549, null, file, z) == null) && file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDir(file2, z);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    public static boolean deleteFileIfExist(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, file)) == null) {
            if (file != null && file.exists()) {
                return file.delete();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.io.FileInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static void copyFile(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65543, null, file, file2) != null) {
            return;
        }
        FileChannel fileChannel3 = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
                fileChannel = null;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                fileChannel = null;
            }
            try {
                fileChannel = fileInputStream.getChannel();
                try {
                    fileChannel3 = fileOutputStream.getChannel();
                    fileChannel.transferTo(0L, fileChannel.size(), fileChannel3);
                    IoUtils.closeQuietly(fileInputStream);
                    IoUtils.closeQuietly(fileChannel);
                    IoUtils.closeQuietly(fileOutputStream);
                    IoUtils.closeQuietly(fileChannel3);
                } catch (IOException e3) {
                    e = e3;
                    fileChannel2 = fileChannel3;
                    fileChannel3 = fileInputStream;
                    try {
                        e.printStackTrace();
                        IoUtils.closeQuietly(fileChannel3);
                        IoUtils.closeQuietly(fileChannel);
                        IoUtils.closeQuietly(fileOutputStream);
                        IoUtils.closeQuietly(fileChannel2);
                    } catch (Throwable th2) {
                        th = th2;
                        IoUtils.closeQuietly(fileChannel3);
                        IoUtils.closeQuietly(fileChannel);
                        IoUtils.closeQuietly(fileOutputStream);
                        IoUtils.closeQuietly(fileChannel2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel2 = fileChannel3;
                    fileChannel3 = fileInputStream;
                    IoUtils.closeQuietly(fileChannel3);
                    IoUtils.closeQuietly(fileChannel);
                    IoUtils.closeQuietly(fileOutputStream);
                    IoUtils.closeQuietly(fileChannel2);
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
                fileChannel = null;
                fileChannel3 = fileInputStream;
                fileChannel2 = fileChannel;
                e.printStackTrace();
                IoUtils.closeQuietly(fileChannel3);
                IoUtils.closeQuietly(fileChannel);
                IoUtils.closeQuietly(fileOutputStream);
                IoUtils.closeQuietly(fileChannel2);
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                fileChannel3 = fileInputStream;
                fileChannel2 = fileChannel;
                IoUtils.closeQuietly(fileChannel3);
                IoUtils.closeQuietly(fileChannel);
                IoUtils.closeQuietly(fileOutputStream);
                IoUtils.closeQuietly(fileChannel2);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
            fileChannel = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            fileChannel = null;
        }
    }

    public static String readFileText(String str, String str2) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65578, null, str, str2)) != null) {
            return (String) invokeLL.objValue;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                try {
                    String loadContent = IoUtils.loadContent(fileInputStream, str2);
                    IoUtils.closeQuietly(fileInputStream);
                    return loadContent;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                IoUtils.closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            IoUtils.closeQuietly(fileInputStream2);
            throw th;
        }
    }

    public static final void writeToFile(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65583, null, file, bArr) == null) || file == null || bArr == null) {
            return;
        }
        ensureParent(file);
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
            fileOutputStream.write(bArr);
            IoUtils.closeQuietly(fileOutputStream);
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            IoUtils.closeQuietly(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            IoUtils.closeQuietly(fileOutputStream2);
            throw th;
        }
    }

    public static void deleteDir(File file, boolean z, FileFilter fileFilter) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{file, Boolean.valueOf(z), fileFilter}) == null) && file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles(fileFilter);
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDir(file2, z, fileFilter);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: java.io.FileOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static void writeToFileNio(File file, byte[] bArr) {
        FileChannel fileChannel;
        ReadableByteChannel readableByteChannel;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65584, null, file, bArr) == null) {
            FileChannel fileChannel2 = null;
            try {
                readableByteChannel = Channels.newChannel(new ByteArrayInputStream(bArr));
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                    fileChannel = null;
                } catch (Throwable th) {
                    th = th;
                    fileChannel = null;
                }
            } catch (IOException e3) {
                e = e3;
                fileChannel = null;
                readableByteChannel = null;
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
                readableByteChannel = null;
            }
            try {
                fileChannel2 = fileOutputStream.getChannel();
                fileChannel2.transferFrom(readableByteChannel, 0L, bArr.length);
                IoUtils.closeQuietly(fileOutputStream);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel2);
            } catch (IOException e4) {
                e = e4;
                fileChannel = fileChannel2;
                fileChannel2 = fileOutputStream;
                try {
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileChannel2);
                    IoUtils.closeQuietly(readableByteChannel);
                    IoUtils.closeQuietly(fileChannel);
                } catch (Throwable th3) {
                    th = th3;
                    IoUtils.closeQuietly(fileChannel2);
                    IoUtils.closeQuietly(readableByteChannel);
                    IoUtils.closeQuietly(fileChannel);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileChannel = fileChannel2;
                fileChannel2 = fileOutputStream;
                IoUtils.closeQuietly(fileChannel2);
                IoUtils.closeQuietly(readableByteChannel);
                IoUtils.closeQuietly(fileChannel);
                throw th;
            }
        }
    }

    public static void deleteDir(File file, boolean z, FilenameFilter filenameFilter) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{file, Boolean.valueOf(z), filenameFilter}) == null) && file != null && file.isDirectory()) {
            File[] listFiles = file.listFiles(filenameFilter);
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        deleteDir(file2, z, filenameFilter);
                    } else {
                        file2.delete();
                    }
                }
            }
            if (z) {
                file.delete();
            }
        }
    }
}
