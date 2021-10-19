package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.a;
import c.a.e.e.m.e;
import c.a.e.e.p.d;
import c.a.e.e.p.f;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.e.e.p.m;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class FileHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final File CACHE_DIR;
    public static final String DIR_ANIMATION = "animation";
    public static final String DIR_DOWNLOAD = "download";
    public static final String DIR_ROOT = "tieba";
    public static final File EXTERNAL_STORAGE_DIRECTORY;
    public static final String FILE_CACHE_BUBBLE = "bubble";
    public static final String FILE_CACHE_CSS = ".css";
    public static final String FILE_CACHE_EMOTION_PACKAGE = "emotion";
    public static final String FILE_CACHE_HEIC = ".heic";
    public static final String FILE_CACHE_HEIF = ".heif";
    public static final String FILE_CACHE_VIDEO = ".video";
    public static final String FILE_CACHE_VOICE = "voice";
    public static final int FILE_TYPE_BUBBLE = 3;
    public static final int FILE_TYPE_EMOTION_PACKAGE = 2;
    public static final int FILE_TYPE_VOICE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class DataDir {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String PACKAGE_DATA_DIR;
        public static final String PACKAGE_VERSION_CUR_DIR = "/package.cur";
        public static final String PACKAGE_VERSION_LAST_DIR = "/package.last";
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes6.dex */
        public static class CompratorByLastModified implements Comparator<File> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public CompratorByLastModified() {
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) {
                    int i2 = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
                    if (i2 > 0) {
                        return 1;
                    }
                    return i2 == 0 ? 0 : -1;
                }
                return invokeLL.intValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2104140686, "Lcom/baidu/tbadk/core/util/FileHelper$DataDir;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2104140686, "Lcom/baidu/tbadk/core/util/FileHelper$DataDir;");
                    return;
                }
            }
            PACKAGE_DATA_DIR = TbadkCoreApplication.getInst().getApp().getFileStreamPath("").getAbsolutePath();
        }

        public DataDir() {
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

        public static boolean checkFile(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                try {
                    return new File(PACKAGE_DATA_DIR + "/" + str).exists();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, "FileHelper.checkFile " + str);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public static boolean cleanDirectory(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                try {
                    File file = new File(PACKAGE_DATA_DIR + "/" + str);
                    if (file.exists()) {
                        if (!file.isDirectory()) {
                            return false;
                        }
                        deleteFileOrDir(file);
                    }
                    return file.mkdirs();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, "FileHelper.cleanDirectory " + str);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public static boolean createFile(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
                try {
                    File file = new File(PACKAGE_DATA_DIR + "/" + str);
                    if (file.exists()) {
                        return false;
                    }
                    return file.createNewFile();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, "FileHelper.createFile " + str);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public static void deleteFileOrDir(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, file) == null) {
                try {
                    if (file.exists()) {
                        if (file.isDirectory()) {
                            File[] listFiles = file.listFiles();
                            int length = listFiles.length;
                            for (int i2 = 0; i2 < length; i2++) {
                                if (listFiles[i2].isFile()) {
                                    listFiles[i2].delete();
                                } else {
                                    deleteFileOrDir(listFiles[i2]);
                                }
                            }
                        }
                        file.delete();
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, "FileHelper.deleteFileOrDir");
                }
            }
        }

        public static String getLatestFileName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
                String str2 = null;
                try {
                    File file = new File(PACKAGE_DATA_DIR + "/" + str);
                    if (file.exists() && file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        long j2 = 0;
                        int length = listFiles.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (j2 < listFiles[i2].lastModified()) {
                                j2 = listFiles[i2].lastModified();
                                str2 = listFiles[i2].getName();
                            }
                        }
                    }
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, "FileHelper.getLatestFileName " + str);
                }
                return str2;
            }
            return (String) invokeL.objValue;
        }

        public static String getLatestVersion() {
            InterceptResult invokeV;
            File[] listFiles;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                try {
                    File file = new File(PACKAGE_DATA_DIR + "/" + PACKAGE_VERSION_CUR_DIR);
                    if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                        Arrays.sort(listFiles, new CompratorByLastModified());
                        File file2 = listFiles[0];
                        if (file2 != null) {
                            return file2.getName();
                        }
                        return null;
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface MediaScanCallback {
        void callBack(HashMap<String, String> hashMap);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1245988433, "Lcom/baidu/tbadk/core/util/FileHelper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1245988433, "Lcom/baidu/tbadk/core/util/FileHelper;");
                return;
            }
        }
        EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory();
        CACHE_DIR = TbadkCoreApplication.getInst().getApp().getCacheDir();
    }

    public FileHelper() {
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

    public static boolean CheckFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (checkSD()) {
                try {
                    return new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str).exists();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, k.join("FileHelper", ".", "CheckFile", " ", str));
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean CheckTempDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (checkSD()) {
                File file = new File(str);
                if (file.exists()) {
                    return true;
                }
                try {
                    return file.mkdirs();
                } catch (Exception e2) {
                    TiebaStatic.file(e2, k.join("FileHelper", ".", "CheckTempDir", " ", str));
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean CopyDir(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, null, str, str2, z)) == null) {
            try {
                File file = new File(str);
                File file2 = new File(str2);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                File[] listFiles = file.listFiles();
                byte[] bArr = new byte[1024];
                if (listFiles != null) {
                    for (File file3 : listFiles) {
                        File file4 = new File(str, file3.getName());
                        File file5 = new File(file2, file3.getName());
                        if (file4.isFile()) {
                            FileInputStream fileInputStream = new FileInputStream(file4);
                            FileOutputStream fileOutputStream = new FileOutputStream(file5);
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileInputStream.close();
                            fileOutputStream.close();
                        } else if (file4.isDirectory()) {
                            CopyDir(file4.toString(), file5.toString(), z);
                        }
                        if (z) {
                            file4.delete();
                        }
                    }
                }
                if (z) {
                    file.delete();
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static File CreateFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (CheckTempDir()) {
                File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
                try {
                    if (!file.exists() || file.delete()) {
                        if (file.createNewFile()) {
                            return file;
                        }
                        return null;
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, k.join("FileHelper", ".", "CreateFile", " ", str));
                    return null;
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static File CreateFileIfNotFound(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (CheckTempDir()) {
                return CreateFileIfNotFoundAbsolutePath(new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str).getAbsolutePath());
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static File CreateFileIfNotFoundAbsolutePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            File file = new File(str);
            try {
                if (file.exists()) {
                    return file;
                }
                if (file.createNewFile()) {
                    return file;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "CreateFileIfNotFound", " ", str));
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static File CreateFileIfNotFoundInCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            return CreateFileIfNotFoundAbsolutePath(new File(CACHE_DIR + "/" + str).getAbsolutePath());
        }
        return (File) invokeL.objValue;
    }

    public static FileOutputStream CreateFileOutputStream(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            try {
                File CreateFile = CreateFile(str);
                if (CreateFile != null) {
                    return new FileOutputStream(CreateFile, true);
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "CreateFileOutputStream", " ", str));
                return null;
            }
        }
        return (FileOutputStream) invokeL.objValue;
    }

    public static boolean DelFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (CheckTempDir()) {
                File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
                try {
                    if (file.exists()) {
                        return file.delete();
                    }
                    return false;
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                    String message = th.getMessage();
                    TiebaStatic.file(message, "FileHelper.DelFile " + str);
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static File FileObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (CheckTempDir()) {
                return new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static File GetFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (CheckTempDir()) {
                return GetFileByAbsolutePath(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static File GetFileByAbsolutePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            File file = new File(str);
            try {
                if (file.exists()) {
                    return file;
                }
                return null;
            } catch (SecurityException e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "GetFile", " ", str));
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static byte[] GetFileData(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, str, str2)) == null) {
            if (!CheckTempDir() || str2 == null) {
                return null;
            }
            if (str != null) {
                str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
            } else {
                str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
            }
            return GetFileData(str3 + str2);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static File GetFileInCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            return GetFileByAbsolutePath(CACHE_DIR + "/" + str);
        }
        return (File) invokeL.objValue;
    }

    public static InputStream GetStreamFromFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) ? GetStreamFromFile(GetFile(str)) : (InputStream) invokeL.objValue;
    }

    public static InputStream GetStreamFromTmpFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            File file = new File(str);
            File file2 = null;
            try {
                if (!file.exists()) {
                    file = null;
                }
                file2 = file;
            } catch (SecurityException e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.GetStreamFromTmpFile " + str);
            }
            return GetStreamFromFile(file2);
        }
        return (InputStream) invokeL.objValue;
    }

    public static long SDAvailableSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            String absolutePath = "mounted".equals(Environment.getExternalStorageState()) ? Environment.getExternalStorageDirectory().getAbsolutePath() : null;
            if (absolutePath == null) {
                return 0L;
            }
            StatFs statFs = new StatFs(absolutePath);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return invokeV.longValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String SaveGifFile(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        String str3;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65558, null, str, str2, bArr)) != null) {
            return (String) invokeLLL.objValue;
        }
        if (str != null) {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        FileOutputStream fileOutputStream2 = null;
        if (!CheckTempDir(str3) || bArr == null) {
            return null;
        }
        File file = new File(str3 + str2);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file.getPath();
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        TiebaStatic.file(e, k.join("FileHelper", ".", "SaveGifFile", " ", str2));
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.getMessage());
                                TiebaStatic.file(e3, k.join("FileHelper", ".", "SaveGifFile", " ", str2));
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e4) {
                            BdLog.e(e4.getMessage());
                            TiebaStatic.file(e4, k.join("FileHelper", ".", "SaveGifFile", " ", str2));
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String SaveTempFile(int i2, String str, byte[] bArr) {
        InterceptResult invokeILL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeILL = interceptable.invokeILL(65559, null, i2, str, bArr)) != null) {
            return (String) invokeILL.objValue;
        }
        FileOutputStream fileOutputStream2 = null;
        if (str == null || bArr == null || bArr.length == 0) {
            return null;
        }
        String tempFilePath = getTempFilePath(i2, str, true);
        if (tempFilePath != null) {
            return tempFilePath;
        }
        try {
            File createTempFile = File.createTempFile(getPrefixByType(i2), str, CACHE_DIR);
            if (createTempFile == null) {
                return null;
            }
            fileOutputStream = new FileOutputStream(createTempFile);
            try {
                try {
                    fileOutputStream.write(bArr, 0, bArr.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return createTempFile.getPath();
                } catch (IOException e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    TiebaStatic.file(e, "FileHelper.SaveFile ");
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            BdLog.e(th.getMessage());
                            TiebaStatic.file(th.getMessage(), "FileHelper.SaveFile ");
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th3) {
                        BdLog.e(th3.getMessage());
                        TiebaStatic.file(th3.getMessage(), "FileHelper.SaveFile ");
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
    }

    public static long checkFileSize(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, str, str2)) == null) {
            if (checkSD()) {
                try {
                    File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/" + str2);
                    if (file.exists()) {
                        return file.length();
                    }
                    return -1L;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, "FileHelper.checkFileSize " + str + "/" + str2);
                    return -1L;
                }
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public static long checkImageFileSize(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, str2)) == null) {
            if (checkSD()) {
                try {
                    if (new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/" + str2).exists()) {
                        return TbConfig.getBigImageSize();
                    }
                    return -1L;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, k.join("FileHelper", ".", "checkImageFileSize", " ", str, "/", str2));
                    return -1L;
                }
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public static boolean checkIsCssFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return str.endsWith(FILE_CACHE_CSS);
        }
        return invokeL.booleanValue;
    }

    public static boolean checkIsHeifImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) ? str.endsWith(FILE_CACHE_HEIF) || str.endsWith(FILE_CACHE_HEIC) : invokeL.booleanValue;
    }

    public static boolean checkIsLongImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            int[] imageFileWH = getImageFileWH(str);
            if (imageFileWH[0] == 0 || imageFileWH[1] == 0) {
                return false;
            }
            float h2 = l.h(TbadkCoreApplication.getInst());
            float f2 = imageFileWH[1] / imageFileWH[0];
            return ((float) imageFileWH[0]) * h2 >= 100.0f && f2 >= 3.0f && f2 <= 50.0f;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkSD() {
        String str;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            try {
                str = Environment.getExternalStorageState();
            } catch (Exception unused) {
                str = null;
            }
            return "mounted".equals(str);
        }
        return invokeV.booleanValue;
    }

    public static boolean cleanDirectory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            try {
                File file = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        return false;
                    }
                    deleteFileOrDir(file);
                }
                return file.mkdirs();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.cleanDirectory " + str);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void clearCacheDir(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65568, null, str) == null) || str == null) {
            return;
        }
        deleteCacheDirFiles(new File(CACHE_DIR + "/" + str));
    }

    public static String compressBitmapToFile(String str, Bitmap bitmap, float f2, int i2) {
        InterceptResult invokeCommon;
        File dataDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65569, null, new Object[]{str, bitmap, Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            if (bitmap == null) {
                return null;
            }
            if (checkSD()) {
                dataDirectory = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName());
            } else {
                dataDirectory = Environment.getDataDirectory();
            }
            if (dataDirectory.exists() && !dataDirectory.isDirectory()) {
                dataDirectory.delete();
            }
            if (!dataDirectory.exists()) {
                dataDirectory.mkdirs();
            }
            File file = new File(dataDirectory, str);
            try {
                if ((!file.exists() || file.delete()) && file.createNewFile()) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                    while (byteArrayOutputStream.toByteArray().length > f2) {
                        byteArrayOutputStream.reset();
                        i2 -= 5;
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file.getAbsolutePath();
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "compressBitmapToFile", " ", file.getAbsolutePath()));
                return null;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean copyFileByAbsolutelyPath(String str, String str2) {
        InterceptResult invokeLL;
        FileInputStream fileInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65571, null, str, str2)) != null) {
            return invokeLL.booleanValue;
        }
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (!file.exists()) {
                return false;
            }
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileInputStream.close();
                            try {
                                fileOutputStream.close();
                                return true;
                            } catch (Throwable th2) {
                                fileInputStream = null;
                                th = th2;
                                try {
                                    BdLog.e(th.toString());
                                    TiebaStatic.file(th.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th3) {
                                            BdLog.e(th3.toString());
                                            TiebaStatic.file(th3.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                            return false;
                                        } catch (Throwable th4) {
                                            BdLog.e(th4.toString());
                                            TiebaStatic.file(th4.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                            return false;
                                        }
                                    }
                                    return false;
                                } catch (Throwable th5) {
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th6) {
                                            BdLog.e(th6.toString());
                                            TiebaStatic.file(th6.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Throwable th7) {
                                            BdLog.e(th7.toString());
                                            TiebaStatic.file(th7.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    throw th5;
                                }
                            }
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                }
            } catch (Throwable th9) {
                fileOutputStream = null;
                th = th9;
            }
        } catch (Throwable th10) {
            fileInputStream = null;
            th = th10;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean copyFileByRelativelyPath(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(65573, null, str, str2, z)) != null) {
            return invokeLLZ.booleanValue;
        }
        String prefixPath = getPrefixPath(str, z);
        String prefixPath2 = getPrefixPath(str2, z);
        FileInputStream fileInputStream = null;
        try {
            File file = new File(prefixPath);
            File file2 = new File(prefixPath2);
            if (!file.exists()) {
                return false;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileInputStream2.close();
                            try {
                                fileOutputStream.close();
                                return true;
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    BdLog.e(th.toString());
                                    TiebaStatic.file(th.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th2) {
                                            BdLog.e(th2.toString());
                                            TiebaStatic.file(th2.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    if (fileOutputStream == null) {
                                        try {
                                            fileOutputStream.close();
                                            return false;
                                        } catch (Throwable th3) {
                                            BdLog.e(th3.toString());
                                            TiebaStatic.file(th3.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                            return false;
                                        }
                                    }
                                    return false;
                                } catch (Throwable th4) {
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (Throwable th5) {
                                            BdLog.e(th5.toString());
                                            TiebaStatic.file(th5.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (Throwable th6) {
                                            BdLog.e(th6.toString());
                                            TiebaStatic.file(th6.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                        }
                                    }
                                    throw th4;
                                }
                            }
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    fileInputStream = fileInputStream2;
                    BdLog.e(th.toString());
                    TiebaStatic.file(th.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream == null) {
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        } catch (Throwable th9) {
            th = th9;
            fileOutputStream = null;
        }
    }

    public static int copyImageFile(String str, String str2, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65574, null, str, str2, context)) == null) {
            if (str2 != null && str2.length() != 0 && context != null) {
                try {
                    String str3 = ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                    if (isGifImage(str)) {
                        str3 = ".gif";
                    }
                    String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                    if (nameMd5FromUrl == null) {
                        return -1;
                    }
                    String str4 = nameMd5FromUrl + str3;
                    for (int i2 = 0; CheckFile(str4) && i2 < 10000; i2++) {
                        str4 = nameMd5FromUrl + Math.round(Math.random() * 9.9999999E7d) + str3;
                    }
                    String str5 = getCacheDir() + str4;
                    f.f(new File(str), new File(str5));
                    new MediaScannerClient(context).saveImage(str5);
                    return 0;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static void deleteCacheDirFiles(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65575, null, file) == null) && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    deleteCacheDirFiles(file2);
                    file2.delete();
                } else {
                    file2.delete();
                }
            }
        }
    }

    public static boolean deleteFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65576, null, file)) == null) {
            try {
                return file.delete();
            } catch (Exception e2) {
                TiebaStatic.file(e2, "FileHelper.deleteFile");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void deleteFileOrDir(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, file) == null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        int length = listFiles.length;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (listFiles[i2].isFile()) {
                                listFiles[i2].delete();
                            } else {
                                deleteFileOrDir(listFiles[i2]);
                            }
                        }
                    }
                    file.delete();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.deleteFileOrDir");
            }
        }
    }

    public static InputStream getAnimationInputStream(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65578, null, str, str2)) == null) {
            String animationPath = getAnimationPath();
            if (CheckTempDir(animationPath)) {
                String str3 = animationPath + str + "/";
                if (new File(str3).exists()) {
                    File file = new File(str3 + str2);
                    if (file.exists()) {
                        return f.x(file);
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (InputStream) invokeLL.objValue;
    }

    public static String getAnimationPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.getTempDirName() + "/animation/";
        }
        return (String) invokeV.objValue;
    }

    public static PackageInfo getApkFileMetaData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            String str2 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
            PackageManager packageManager = BdBaseApplication.getInst().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return packageManager.getPackageArchiveInfo(str2, 128);
        }
        return (PackageInfo) invokeL.objValue;
    }

    public static String getApkFilePackageName(String str) {
        InterceptResult invokeL;
        PackageInfo packageArchiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            String str2 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
            PackageManager packageManager = BdBaseApplication.getInst().getPackageManager();
            if (packageManager == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str2, 1)) == null) {
                return null;
            }
            return packageArchiveInfo.packageName;
        }
        return (String) invokeL.objValue;
    }

    public static long getAvailableSize() {
        InterceptResult invokeV;
        String absolutePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) {
            if (checkSD()) {
                absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            } else {
                absolutePath = Environment.getRootDirectory().getAbsolutePath();
            }
            if (absolutePath == null) {
                return 0L;
            }
            StatFs statFs = new StatFs(absolutePath);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return invokeV.longValue;
    }

    public static String getCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            return EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        return (String) invokeV.objValue;
    }

    public static String getCustomLoginCssFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return null;
            }
            return parse.getLastPathSegment();
        }
        return (String) invokeL.objValue;
    }

    public static String getCustomLoginCssStoragePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, str)) == null) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return null;
            }
            return (TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/") + parse.getLastPathSegment();
        }
        return (String) invokeL.objValue;
    }

    public static long getDirectorySize(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65587, null, str, z)) == null) ? getDirectorySize(new File(str), z) : invokeLZ.longValue;
    }

    public static String getDownloadDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            return EXTERNAL_STORAGE_DIRECTORY + "/tieba/download";
        }
        return (String) invokeV.objValue;
    }

    public static String getFileDireciory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
        }
        return (String) invokeL.objValue;
    }

    public static String getFilePath(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65590, null, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (checkSD()) {
                StringBuilder sb = new StringBuilder();
                if (z) {
                    sb.append(getCacheDir());
                }
                sb.append(getPrefixByType(i2));
                sb.append(File.separator);
                sb.append(str);
                return sb.toString();
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static long getFileSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return 0L;
            }
            return getFileSize(new File(str));
        }
        return invokeL.longValue;
    }

    public static Bitmap getImage(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65594, null, str, str2)) == null) {
            if (str != null) {
                str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
            } else {
                str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
            }
            return getImage(str3 + str2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static int[] getImageFileWH(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, str)) == null) {
            int[] iArr = new int[2];
            if (StringUtils.isNull(str)) {
                return iArr;
            }
            File file = new File(str);
            if (!file.exists() || file.isDirectory()) {
                return iArr;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    BitmapFactory.decodeStream(fileInputStream2, null, options);
                    m.e(fileInputStream2);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        th.printStackTrace();
                        iArr[0] = options.outWidth;
                        iArr[1] = options.outHeight;
                        return iArr;
                    } finally {
                        m.e(fileInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            iArr[0] = options.outWidth;
            iArr[1] = options.outHeight;
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x0048 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x004a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0021 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static String getImageRealPathFromUri(Context context, Uri uri) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65596, null, context, uri)) != null) {
            return (String) invokeLL.objValue;
        }
        Cursor cursor = null;
        r1 = null;
        r1 = null;
        r1 = null;
        String str = null;
        if (uri == null || context == 0) {
            return null;
        }
        String scheme = uri.getScheme();
        if (scheme != null && !"file".equals(scheme)) {
            try {
                if ("content".equals(scheme)) {
                    try {
                        context = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                    } catch (Exception e2) {
                        e = e2;
                        context = 0;
                    } catch (Throwable th) {
                        th = th;
                        a.a(cursor);
                        throw th;
                    }
                    if (context != 0) {
                        try {
                            boolean moveToFirst = context.moveToFirst();
                            context = context;
                            if (moveToFirst) {
                                int columnIndex = context.getColumnIndex("_data");
                                context = context;
                                if (columnIndex > -1) {
                                    str = context.getString(columnIndex);
                                    context = context;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            e.printStackTrace();
                            context = context;
                            a.a(context);
                            return str;
                        }
                    }
                    a.a(context);
                    return str;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                cursor = context;
            }
        } else {
            return uri.getPath();
        }
    }

    public static String getPrefixByType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65597, null, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "" : FILE_CACHE_BUBBLE : FILE_CACHE_EMOTION_PACKAGE : "voice" : (String) invokeI.objValue;
    }

    public static String getPrefixPath(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65598, null, str, z)) == null) {
            return (z && str.startsWith(EXTERNAL_STORAGE_DIRECTORY.toString())) ? str : EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str;
        }
        return (String) invokeLZ.objValue;
    }

    public static String getSdErrorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65599, null)) == null) {
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState.equals("removed")) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.error_no_sdcard);
            }
            if (!externalStorageState.equals("unmounted") && !externalStorageState.equals("unmountable")) {
                if (externalStorageState.equals("shared")) {
                    return TbadkCoreApplication.getInst().getApp().getString(R.string.error_sd_shared);
                }
                return TbadkCoreApplication.getInst().getApp().getString(R.string.error_sd_error);
            }
            return TbadkCoreApplication.getInst().getApp().getString(R.string.error_no_sdcard);
        }
        return (String) invokeV.objValue;
    }

    public static String getStoreFile(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65600, null, str, i2)) == null) {
            if (str == null) {
                return null;
            }
            if (checkSD()) {
                if (CheckFile(getFilePath(str, i2, false))) {
                    return getFilePath(str, i2, true);
                }
                return null;
            }
            return getTempFilePath(1, str);
        }
        return (String) invokeLI.objValue;
    }

    public static String getTempFilePath(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65601, null, i2, str)) == null) ? getTempFilePath(i2, str, false) : (String) invokeIL.objValue;
    }

    public static String getVideoTmpDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, null)) == null) {
            return EXTERNAL_STORAGE_DIRECTORY + "/tieba/" + FILE_CACHE_VIDEO;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0126 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isGif(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Throwable th;
        boolean z;
        Exception exc;
        String join;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65604, null, str, str2)) == null) {
            if (str != null) {
                str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
            } else {
                str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
            }
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(str3 + str2));
                    try {
                        try {
                            byte[] bArr = new byte[7];
                            z = fileInputStream2.read(bArr, 0, 6) == 6 ? l.B(bArr) : false;
                            try {
                                fileInputStream2.close();
                                if (0 != 0) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e2) {
                                        exc = e2;
                                        exc.printStackTrace();
                                        join = k.join("FileHelper", ".", "isGif", " ", str, "/", str2);
                                        TiebaStatic.file(exc, join);
                                        return z;
                                    }
                                }
                            } catch (FileNotFoundException e3) {
                                e = e3;
                                fileInputStream = fileInputStream2;
                                e.printStackTrace();
                                TiebaStatic.file(e, k.join("FileHelper", ".", "isGif", " ", str, "/", str2));
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e4) {
                                        exc = e4;
                                        exc.printStackTrace();
                                        join = k.join("FileHelper", ".", "isGif", " ", str, "/", str2);
                                        TiebaStatic.file(exc, join);
                                        return z;
                                    }
                                }
                                return z;
                            } catch (IOException e5) {
                                e = e5;
                                fileInputStream = fileInputStream2;
                                e.printStackTrace();
                                TiebaStatic.file(e, k.join("FileHelper", "isGif", " ", str, "/", str2));
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (Exception e6) {
                                        exc = e6;
                                        exc.printStackTrace();
                                        join = k.join("FileHelper", ".", "isGif", " ", str, "/", str2);
                                        TiebaStatic.file(exc, join);
                                        return z;
                                    }
                                }
                                return z;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e7) {
                                    e7.printStackTrace();
                                    TiebaStatic.file(e7, k.join("FileHelper", ".", "isGif", " ", str, "/", str2));
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e8) {
                        e = e8;
                        fileInputStream = fileInputStream2;
                        z = false;
                        e.printStackTrace();
                        TiebaStatic.file(e, k.join("FileHelper", ".", "isGif", " ", str, "/", str2));
                        if (fileInputStream != null) {
                        }
                        return z;
                    } catch (IOException e9) {
                        e = e9;
                        fileInputStream = fileInputStream2;
                        z = false;
                        e.printStackTrace();
                        TiebaStatic.file(e, k.join("FileHelper", "isGif", " ", str, "/", str2));
                        if (fileInputStream != null) {
                        }
                        return z;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (FileNotFoundException e10) {
                e = e10;
            } catch (IOException e11) {
                e = e11;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isGifImage(String str) {
        InterceptResult invokeL;
        InputStream x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65605, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && !file.isDirectory() && (x = f.x(file)) != null) {
                try {
                    byte[] bArr = new byte[7];
                    if (x.read(bArr, 0, 6) == 6) {
                        boolean B = l.B(bArr);
                        a.c(x);
                        return B;
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    a.c(x);
                    throw th;
                }
                a.c(x);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean isLocalFile(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            try {
                File file = new File(new URI(uri.toString()));
                return file.isFile() && file.exists();
            } catch (IllegalArgumentException | URISyntaxException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean isLocalImagePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65607, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().startsWith("content:") || str.toLowerCase().startsWith("file:");
        }
        return invokeL.booleanValue;
    }

    public static void makeDirectory(String str) {
        String fileDireciory;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65608, null, str) == null) || (fileDireciory = getFileDireciory(str)) == null) {
            return;
        }
        try {
            File file = new File(fileDireciory);
            if (file.exists()) {
                return;
            }
            file.mkdir();
        } catch (Exception e2) {
            TiebaStatic.file(e2, "FileHelper.makeDirectory " + fileDireciory);
        }
    }

    public static void makeRootDirectory(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65609, null, str) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    return;
                }
                file.mkdir();
            } catch (Exception e2) {
                TiebaStatic.file(e2, "FileHelper.makeRootDirectory " + str);
            }
        }
    }

    public static String renameTo(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65610, null, str, str2, str3, str4)) == null) {
            if (str != null) {
                str5 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
            } else {
                str5 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
            }
            if (str3 != null) {
                str6 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str3 + "/";
            } else {
                str6 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
            }
            if (CheckTempDir(str5) && CheckTempDir(str6)) {
                File file = new File(str5 + str2);
                File file2 = new File(str6 + str4);
                if (!file.renameTo(file2)) {
                    TiebaStatic.file(k.join("renameTo", NotificationCompat.CATEGORY_ERROR), k.join("FileHelper", ".", "renameTo"));
                    return null;
                }
                return file2.getAbsolutePath();
            }
            return null;
        }
        return (String) invokeLLLL.objValue;
    }

    public static String saveBitmapByAbsolutelyPath(String str, String str2, Bitmap bitmap, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65612, null, str, str2, bitmap, i2)) == null) {
            if (bitmap != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                File file = new File(str);
                if (file.exists() && !file.isDirectory()) {
                    file.delete();
                }
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, str2);
                try {
                    if ((!file2.exists() || file2.delete()) && file2.createNewFile()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file2.getAbsolutePath();
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, k.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file2.getAbsolutePath()));
                }
            }
            return null;
        }
        return (String) invokeLLLI.objValue;
    }

    public static String saveBitmapByRelativelyPath(String str, String str2, Bitmap bitmap, int i2) {
        InterceptResult invokeLLLI;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65613, null, str, str2, bitmap, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (str != null) {
                str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
            } else {
                str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
            }
            if (CheckTempDir(str3) && bitmap != null) {
                File file = new File(str3 + str2);
                try {
                    if ((!file.exists() || file.delete()) && file.createNewFile()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file.getPath();
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, k.join("FileHelper", ".", "SaveFile1", " '", str, "/", str2));
                }
            }
            return null;
        }
        return (String) invokeLLLI.objValue;
    }

    public static String saveFileAsPNG(String str, String str2, Bitmap bitmap, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65614, null, str, str2, bitmap, i2)) == null) ? saveFileAsPic(str, str2, bitmap, i2, Bitmap.CompressFormat.PNG) : (String) invokeLLLI.objValue;
    }

    public static String saveFileAsPic(String str, String str2, Bitmap bitmap, int i2, Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65615, null, new Object[]{str, str2, bitmap, Integer.valueOf(i2), compressFormat})) == null) {
            if (bitmap != null && CheckTempDir(str) && bitmap != null) {
                File file = new File(str + str2);
                try {
                    if ((!file.exists() || file.delete()) && file.createNewFile()) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        bitmap.compress(compressFormat, i2, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file.getPath();
                    }
                    return null;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                    TiebaStatic.file(e2, k.join("FileHelper", ".", "saveFileAsPNG", " '", str, "/", str2));
                }
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean saveFileByAbsolutePath(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65616, null, str, bArr)) != null) {
            return invokeLL.booleanValue;
        }
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if ((!file.exists() || file.delete()) && file.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr, 0, bArr.length);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.getMessage());
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                BdLog.e(e4.getMessage());
                            }
                        }
                        throw th;
                    }
                }
                return false;
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String saveFileByBytes(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65618, null, str, bArr)) == null) ? saveFileByBytes((String) null, str, bArr) : (String) invokeLL.objValue;
    }

    public static String saveFileByStream(String str, String str2, InputStream inputStream) {
        InterceptResult invokeLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65621, null, str, str2, inputStream)) == null) {
            if (str != null) {
                str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
            } else {
                str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
            }
            if (!CheckTempDir(str3) || inputStream == null || str2 == null) {
                return null;
            }
            return saveFileByStream(str3 + "/" + str2, inputStream);
        }
        return (String) invokeLLL.objValue;
    }

    public static String saveFileToSDOrMemory(String str, Bitmap bitmap, int i2) {
        InterceptResult invokeLLI;
        String absolutePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65622, null, str, bitmap, i2)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (checkSD()) {
                absolutePath = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName();
            } else {
                absolutePath = Environment.getDataDirectory().getAbsolutePath();
            }
            return saveBitmapByAbsolutelyPath(absolutePath, str, bitmap, i2);
        }
        return (String) invokeLLI.objValue;
    }

    public static int saveImageFileByUser(String str, byte[] bArr, Context context) {
        InterceptResult invokeLLL;
        Bitmap decodeByteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65623, null, str, bArr, context)) == null) {
            if (bArr != null && str != null && str.length() != 0 && context != null) {
                try {
                    String str2 = ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                    if (l.B(bArr)) {
                        str2 = ".gif";
                    }
                    if (l.z(bArr) && (decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) != null) {
                        bArr = d.d().a(decodeByteArray, 100);
                        decodeByteArray.recycle();
                    }
                    String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
                    if (nameMd5FromUrl == null) {
                        return -1;
                    }
                    String str3 = nameMd5FromUrl + str2;
                    for (int i2 = 0; CheckFile(str3) && i2 < 10000; i2++) {
                        str3 = nameMd5FromUrl + Math.round(Math.random() * 9.9999999E7d) + str2;
                    }
                    String saveFileByBytes = saveFileByBytes(str3, bArr);
                    if (saveFileByBytes != null) {
                        new MediaScannerClient(context).saveImage(saveFileByBytes);
                        return 0;
                    }
                    return -2;
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static void scanMediaFile(String[] strArr, MediaScanCallback mediaScanCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65624, null, strArr, mediaScanCallback) == null) {
            if (strArr == null || strArr.length == 0) {
                if (mediaScanCallback != null) {
                    mediaScanCallback.callBack(null);
                    return;
                }
                return;
            }
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    if (mediaScanCallback != null) {
                        mediaScanCallback.callBack(null);
                        return;
                    }
                    return;
                }
            }
            HashMap hashMap = new HashMap();
            for (String str2 : strArr) {
                hashMap.put(str2, null);
            }
            MediaScannerConnection.scanFile(TbadkCoreApplication.getInst(), strArr, null, new MediaScannerConnection.OnScanCompletedListener(hashMap, strArr.length, mediaScanCallback) { // from class: com.baidu.tbadk.core.util.FileHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public int currentNumbers;
                public final /* synthetic */ MediaScanCallback val$callback;
                public final /* synthetic */ HashMap val$map;
                public final /* synthetic */ int val$numbers;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {hashMap, Integer.valueOf(r7), mediaScanCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$map = hashMap;
                    this.val$numbers = r7;
                    this.val$callback = mediaScanCallback;
                    this.currentNumbers = 0;
                }

                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str3, Uri uri) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str3, uri) == null) {
                        this.currentNumbers++;
                        if (uri != null) {
                            this.val$map.put(str3, uri.toString());
                        }
                        if (this.currentNumbers == this.val$numbers) {
                            e.a().post(new Runnable(this) { // from class: com.baidu.tbadk.core.util.FileHelper.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 this$0;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass1 anonymousClass1;
                                    MediaScanCallback mediaScanCallback2;
                                    Interceptable interceptable3 = $ic;
                                    if (!(interceptable3 == null || interceptable3.invokeV(1048576, this) == null) || (mediaScanCallback2 = (anonymousClass1 = this.this$0).val$callback) == null) {
                                        return;
                                    }
                                    mediaScanCallback2.callBack(anonymousClass1.val$map);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    public static InputStream GetStreamFromFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, file)) == null) {
            if (file != null) {
                try {
                    return new FileInputStream(file);
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                    TiebaStatic.file(th.getMessage(), "FileHelper.GetStreamFromFile");
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }

    public static long getDirectorySize(File file, boolean z) {
        InterceptResult invokeLZ;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65586, null, file, z)) == null) {
            File[] listFiles = file.listFiles();
            long j2 = 0;
            if (listFiles == null) {
                return 0L;
            }
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2].isDirectory() && !z) {
                    length = getDirectorySize(listFiles[i2], false);
                } else {
                    length = listFiles[i2].length();
                }
                j2 += length;
            }
            return j2;
        }
        return invokeLZ.longValue;
    }

    public static String getTempFilePath(int i2, String str, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65602, null, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)})) == null) {
            File file = CACHE_DIR;
            if (file == null) {
                return null;
            }
            File[] listFiles = file.listFiles();
            String prefixByType = getPrefixByType(i2);
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                if (listFiles[i3] != null && listFiles[i3].getName().startsWith(prefixByType)) {
                    if (listFiles[i3].getName().endsWith(str)) {
                        return listFiles[i3].getAbsolutePath();
                    }
                    if (z) {
                        listFiles[i3].delete();
                    }
                }
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static String saveFileByBytes(String str, byte[] bArr, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65619, null, str, bArr, i2)) == null) {
            if (checkSD()) {
                return saveFileByBytes((String) null, getFilePath(str, i2, false), bArr);
            }
            return SaveTempFile(i2, str, bArr);
        }
        return (String) invokeLLI.objValue;
    }

    public static long getFileSize(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65591, null, file)) != null) {
            return invokeL.longValue;
        }
        long j2 = 0;
        FileInputStream fileInputStream = null;
        try {
        } catch (Exception e2) {
            TiebaStatic.file(e2, "FileHelper.getFileSize");
        }
        try {
            try {
                if (file.exists()) {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        j2 = fileInputStream2.available();
                        fileInputStream = fileInputStream2;
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        TiebaStatic.file(e, "FileHelper.getFileSize");
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return j2;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                                TiebaStatic.file(e4, "FileHelper.getFileSize");
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return j2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String saveFileByBytes(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        String str3;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65617, null, str, str2, bArr)) != null) {
            return (String) invokeLLL.objValue;
        }
        if (str != null) {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str + "/";
        } else {
            str3 = EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        FileOutputStream fileOutputStream = null;
        if (!CheckTempDir(str3) || bArr == null || str2 == null) {
            return null;
        }
        File file = new File(str3 + str2);
        String parent = file.getParent();
        if (!StringUtils.isNull(parent)) {
            File file2 = new File(parent);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        try {
            try {
                if (file.exists()) {
                    try {
                        if (!file.delete()) {
                            return null;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        TiebaStatic.file(e, k.join("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return null;
                            } catch (Throwable th2) {
                                BdLog.e(th2.getMessage());
                                TiebaStatic.file(th2.getMessage(), k.join("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                                return null;
                            }
                        }
                        return null;
                    }
                }
                if (file.createNewFile()) {
                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(bArr, 0, bArr.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file.getPath();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th4) {
                        BdLog.e(th4.getMessage());
                        TiebaStatic.file(th4.getMessage(), k.join("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static boolean CheckTempDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return CheckTempDir(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/");
        }
        return invokeV.booleanValue;
    }

    public static boolean checkIsLongImage(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, bitmap)) == null) {
            if (bitmap == null || bitmap.isRecycled()) {
                return false;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width == 0 || height == 0) {
                return false;
            }
            float f2 = width;
            float f3 = height / f2;
            return f2 * l.h(TbadkCoreApplication.getInst()) >= 100.0f && f3 >= 3.0f && f3 <= 50.0f;
        }
        return invokeL.booleanValue;
    }

    public static Bitmap getImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                return BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e2) {
                TiebaStatic.file(e2.getMessage(), k.join("FileHelper", ".", "getImage", " ", str));
                System.gc();
                try {
                    return BitmapFactory.decodeFile(str);
                } catch (OutOfMemoryError unused) {
                    TiebaStatic.file(e2.getMessage(), k.join("FileHelper", ".", "getImage", " ", str));
                    return null;
                }
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static byte[] GetFileData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65551, null, str)) != null) {
            return (byte[]) invokeL.objValue;
        }
        if (StringUtils.isNull(str)) {
            return null;
        }
        File file = new File(str);
        try {
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            BdLog.e(e2.getMessage());
            TiebaStatic.file(e2, "FileHelper.GetFileData " + str);
            return null;
        }
    }

    public static String saveFileByStream(String str, InputStream inputStream) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65620, null, str, inputStream)) != null) {
            return (String) invokeLL.objValue;
        }
        FileOutputStream fileOutputStream2 = null;
        if (StringUtils.isNull(str) || inputStream == null) {
            return null;
        }
        File file = new File(str);
        String parent = file.getParent();
        if (!StringUtils.isNull(parent)) {
            File file2 = new File(parent);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        try {
            if (file.exists() && !file.delete()) {
                m.f(null);
                return null;
            } else if (!file.createNewFile()) {
                m.f(null);
                return null;
            } else {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                fileOutputStream.flush();
                                String path = file.getPath();
                                m.f(fileOutputStream);
                                return path;
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        TiebaStatic.file(e, "FileHelper.saveFile " + str);
                        m.f(fileOutputStream);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    m.f(fileOutputStream2);
                    throw th;
                }
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            m.f(fileOutputStream2);
            throw th;
        }
    }

    public static boolean renameTo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65611, null, str, str2)) == null) {
            File file = new File(str);
            File file2 = new File(str2);
            String parent = file2.getParent();
            if (!StringUtils.isNull(parent)) {
                File file3 = new File(parent);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
            }
            if (file.exists()) {
                return file.renameTo(file2);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String compressBitmapToFile(String str, String str2, Bitmap bitmap, float f2, int i2) {
        InterceptResult invokeCommon;
        File dataDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65570, null, new Object[]{str, str2, bitmap, Float.valueOf(f2), Integer.valueOf(i2)})) == null) {
            if (bitmap == null) {
                return null;
            }
            if (str != null) {
                try {
                    dataDirectory = new File(str);
                } catch (Exception unused) {
                    if (checkSD()) {
                        dataDirectory = new File(EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName());
                    } else {
                        dataDirectory = Environment.getDataDirectory();
                    }
                }
            } else {
                dataDirectory = null;
            }
            if (dataDirectory == null) {
                return null;
            }
            if (dataDirectory.exists() && !dataDirectory.isDirectory()) {
                dataDirectory.delete();
            }
            if (!dataDirectory.exists()) {
                dataDirectory.mkdirs();
            }
            File file = new File(dataDirectory, str2);
            try {
                if ((!file.exists() || file.delete()) && file.createNewFile()) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                    while (byteArrayOutputStream.toByteArray().length > f2) {
                        byteArrayOutputStream.reset();
                        i2 -= 5;
                        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file.getAbsolutePath();
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, k.join("FileHelper", ".", "compressBitmapToFile", " ", file.getAbsolutePath()));
                return null;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static boolean copyFileByRelativelyPath(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65572, null, str, str2)) == null) ? copyFileByRelativelyPath(str, str2, false) : invokeLL.booleanValue;
    }
}
