package com.baidu.tbadk.core.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
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
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.util.io.FileUtils;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.ld;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.nd;
import com.baidu.tieba.rd;
import com.baidu.tieba.sd;
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
/* loaded from: classes4.dex */
public class FileHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final File CACHE_DIR;
    public static final String DIR_ANIMATION = "animation";
    public static final String DIR_DOWNLOAD = "download";
    public static final String DIR_ROOT = "tieba";
    public static final File EXTERNAL_STORAGE_DCIM_DIRECTORY;
    public static final File EXTERNAL_STORAGE_DIRECTORY;
    public static final File EXTERNAL_STORAGE_PRIVATE_DIRECTORY;
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

    /* loaded from: classes4.dex */
    public interface MediaScanCallback {
        void callBack(HashMap<String, String> hashMap);
    }

    public static String getPrefixByType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65600, null, i)) == null) ? i != 1 ? i != 2 ? i != 3 ? "" : FILE_CACHE_BUBBLE : FILE_CACHE_EMOTION_PACKAGE : "voice" : (String) invokeI.objValue;
    }

    /* loaded from: classes4.dex */
    public static class DataDir {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String PACKAGE_DATA_DIR;
        public static final String PACKAGE_VERSION_CUR_DIR = "/package.cur";
        public static final String PACKAGE_VERSION_LAST_DIR = "/package.last";
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes4.dex */
        public static class CompratorByLastModified implements Comparator<File> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public CompratorByLastModified() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                    int i = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
                    if (i > 0) {
                        return 1;
                    }
                    if (i == 0) {
                        return 0;
                    }
                    return -1;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    TiebaStatic.file(e, "FileHelper.checkFile " + str);
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
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    TiebaStatic.file(e, "FileHelper.cleanDirectory " + str);
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
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    TiebaStatic.file(e, "FileHelper.createFile " + str);
                    return false;
                }
            }
            return invokeL.booleanValue;
        }

        public static void deleteFileOrDir(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65541, null, file) == null) {
                try {
                    if (file.exists()) {
                        if (file.isDirectory()) {
                            File[] listFiles = file.listFiles();
                            int length = listFiles.length;
                            for (int i = 0; i < length; i++) {
                                if (listFiles[i].isFile()) {
                                    listFiles[i].delete();
                                } else {
                                    deleteFileOrDir(listFiles[i]);
                                }
                            }
                        }
                        file.delete();
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    TiebaStatic.file(e, "FileHelper.deleteFileOrDir");
                }
            }
        }

        public static String getLatestFileName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
                String str2 = null;
                try {
                    File file = new File(PACKAGE_DATA_DIR + "/" + str);
                    if (file.exists() && file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        long j = 0;
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            if (j < listFiles[i].lastModified()) {
                                j = listFiles[i].lastModified();
                                str2 = listFiles[i].getName();
                            }
                        }
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    TiebaStatic.file(e, "FileHelper.getLatestFileName " + str);
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
                        if (file2 == null) {
                            return null;
                        }
                        return file2.getName();
                    }
                    return null;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return (String) invokeV.objValue;
        }
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
        EXTERNAL_STORAGE_PRIVATE_DIRECTORY = getExternalFilesDir();
        EXTERNAL_STORAGE_DCIM_DIRECTORY = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        CACHE_DIR = TbadkCoreApplication.getInst().getCacheDir();
    }

    public static long SDAvailableSize() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                str = Environment.getExternalStorageDirectory().getAbsolutePath();
            } else {
                str = null;
            }
            if (str == null) {
                return 0L;
            }
            StatFs statFs = new StatFs(str);
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        }
        return invokeV.longValue;
    }

    public static String getAnimationPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            return TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + TbConfig.getTempDirName() + "/animation/";
        }
        return (String) invokeV.objValue;
    }

    public static long getAvailableSize() {
        InterceptResult invokeV;
        String absolutePath;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
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

    public static String getDCIMDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            return EXTERNAL_STORAGE_DCIM_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
        }
        return (String) invokeV.objValue;
    }

    public FileHelper() {
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

    public static boolean CheckExternalDCIMDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return CheckSDCardDir(EXTERNAL_STORAGE_DCIM_DIRECTORY.getAbsolutePath());
        }
        return invokeV.booleanValue;
    }

    public static boolean CheckExternalPrivateDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return CheckSDCardDir(EXTERNAL_STORAGE_PRIVATE_DIRECTORY.getAbsolutePath());
        }
        return invokeV.booleanValue;
    }

    public static boolean checkSD() {
        String str;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            try {
                str = Environment.getExternalStorageState();
            } catch (Exception unused) {
                str = null;
            }
            return "mounted".equals(str);
        }
        return invokeV.booleanValue;
    }

    public static String getCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            return EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/";
        }
        return (String) invokeV.objValue;
    }

    public static String getDownloadDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65588, null)) == null) {
            return EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "download";
        }
        return (String) invokeV.objValue;
    }

    public static String getExternalCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) {
            return TbadkCoreApplication.getInst().getExternalCacheDir().getPath();
        }
        return (String) invokeV.objValue;
    }

    public static File getExternalFilesDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) {
            return TbadkCoreApplication.getInst().getExternalFilesDir(TbConfig.getTempDirName());
        }
        return (File) invokeV.objValue;
    }

    public static String getTmpPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65608, null)) == null) {
            return getExternalFilesDir().getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public static String getVideoTmpDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65609, null)) == null) {
            return EXTERNAL_STORAGE_DCIM_DIRECTORY + "/" + FILE_CACHE_VIDEO;
        }
        return (String) invokeV.objValue;
    }

    public static boolean CheckDCIMFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!checkSD()) {
                return false;
            }
            try {
                return new File(EXTERNAL_STORAGE_DCIM_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str).exists();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, rd.join("FileHelper", ".", "CheckFile", " ", str));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean DelExternalPrivateFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (!CheckExternalPrivateDir()) {
                return false;
            }
            File file = new File(getTmpPath() + "/" + str);
            try {
                if (!file.exists()) {
                    return false;
                }
                return file.delete();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                String message = th.getMessage();
                TiebaStatic.file(message, "FileHelper.DelFile " + str);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static byte[] GetFileData(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
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
            } catch (IOException e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.GetFileData " + str);
                return null;
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }

    public static File createDCIMFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, str)) == null) {
            if (!CheckExternalDCIMDir()) {
                return null;
            }
            File file = new File(EXTERNAL_STORAGE_DCIM_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
            try {
                if (file.exists() && !file.delete()) {
                    return null;
                }
                if (!file.createNewFile()) {
                    return null;
                }
                return file;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, rd.join("FileHelper", ".", "CreateFile", " ", str));
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static File createExternalFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, str)) == null) {
            if (!CheckExternalPrivateDir()) {
                return null;
            }
            File file = new File(EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/" + str);
            try {
                if (file.exists() && !file.delete()) {
                    return null;
                }
                if (!file.createNewFile()) {
                    return null;
                }
                return file;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, rd.join("FileHelper", ".", "CreateFile", " ", str));
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static Bitmap getImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65596, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = TbConfig.BitmapConfig;
                return BitmapFactory.decodeFile(str, options);
            } catch (OutOfMemoryError e) {
                TiebaStatic.file(e.getMessage(), rd.join("FileHelper", ".", "getImage", " ", str));
                System.gc();
                try {
                    return BitmapFactory.decodeFile(str);
                } catch (OutOfMemoryError unused) {
                    TiebaStatic.file(e.getMessage(), rd.join("FileHelper", ".", "getImage", " ", str));
                    return null;
                }
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static boolean CheckDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e) {
                TiebaStatic.file(e, rd.join("FileHelper", ".", "CheckDir", " ", str));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean CheckExternalPrivateFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (!checkSD()) {
                return false;
            }
            try {
                return new File(EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/" + str).exists();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, rd.join("FileHelper", ".", "CheckFile", " ", str));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean CheckSDCardDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (!checkSD()) {
                return false;
            }
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e) {
                TiebaStatic.file(e, rd.join("FileHelper", ".", "CheckTempDir", " ", str));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static File CreateFileIfNotFoundAbsolutePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            checkAndMkdirs(str);
            File file = new File(str);
            try {
                if (file.exists()) {
                    return file;
                }
                if (!file.createNewFile()) {
                    return null;
                }
                return file;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, rd.join("FileHelper", ".", "CreateFileIfNotFound", " ", str));
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static File GetFileByAbsolutePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            File file = new File(str);
            try {
                if (file.exists()) {
                    return file;
                }
                if (!file.createNewFile()) {
                    return null;
                }
                return file;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, rd.join("FileHelper", ".", "GetFile", " ", str));
                return null;
            }
        }
        return (File) invokeL.objValue;
    }

    public static boolean checkAndMkdirs(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            String dir = getDir(str);
            if (dir == null) {
                return false;
            }
            File file = new File(dir);
            if (!file.exists()) {
                try {
                    if (!file.mkdirs()) {
                        BdLog.e("error fulldirObj.mkdirs:" + dir);
                        return false;
                    }
                    return true;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean checkIsLongImage(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, bitmap)) == null) {
            if (bitmap == null || bitmap.isRecycled()) {
                return false;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (width == 0 || height == 0) {
                return false;
            }
            float f = width;
            float f2 = height / f;
            if (f * BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst()) < 100.0f || f2 < 3.0f || f2 > 50.0f) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean deleteFileOrDir(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65575, null, file)) == null) {
            if (file == null) {
                return false;
            }
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            if (listFiles[i].isFile()) {
                                listFiles[i].delete();
                            } else {
                                deleteFileOrDir(listFiles[i]);
                            }
                        }
                    }
                    file.delete();
                    return true;
                }
                return true;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.deleteFileOrDir");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException: Cannot read field "wordsInUse" because "set" is null
        	at java.base/java.util.BitSet.or(BitSet.java:943)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:732)
        	at jadx.core.utils.BlockUtils.getPathCross(BlockUtils.java:811)
        	at jadx.core.dex.visitors.regions.IfMakerHelper.restructureIf(IfMakerHelper.java:88)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:706)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static boolean detectHeifHeader(java.lang.String r4) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.baidu.tbadk.core.util.FileHelper.$ic
            if (r0 != 0) goto L38
        L4:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto Lc
            return r1
        Lc:
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = r0.exists()
            if (r4 == 0) goto L37
            boolean r4 = r0.isFile()
            if (r4 != 0) goto L1e
            goto L37
        L1e:
            com.facebook.imageformat.ImageFormatChecker r4 = com.facebook.imageformat.ImageFormatChecker.getInstance()     // Catch: java.lang.Exception -> L37
            okio.Source r0 = okio.Okio.source(r0)     // Catch: java.lang.Exception -> L37
            okio.BufferedSource r0 = okio.Okio.buffer(r0)     // Catch: java.lang.Exception -> L37
            java.io.InputStream r0 = r0.inputStream()     // Catch: java.lang.Exception -> L37
            com.facebook.imageformat.ImageFormat r4 = r4.determineImageFormat(r0)     // Catch: java.lang.Exception -> L37
            com.facebook.imageformat.ImageFormat r0 = com.facebook.imageformat.DefaultImageFormats.HEIF     // Catch: java.lang.Exception -> L37
            if (r4 != r0) goto L37
            r1 = 1
        L37:
            return r1
        L38:
            r1 = r0
            r2 = 65576(0x10028, float:9.1892E-41)
            r3 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r1.invokeL(r2, r3, r4)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tbadk.core.util.FileHelper.detectHeifHeader(java.lang.String):boolean");
    }

    public static String getApkFilePackageName(String str) {
        InterceptResult invokeL;
        PackageInfo packageArchiveInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            String str2 = EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/" + str;
            PackageManager packageManager = BdBaseApplication.getInst().getPackageManager();
            if (packageManager == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str2, 1)) == null) {
                return null;
            }
            return packageArchiveInfo.packageName;
        }
        return (String) invokeL.objValue;
    }

    public static String getCustomLoginCssStoragePath(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return null;
            }
            return (TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/") + parse.getLastPathSegment();
        }
        return (String) invokeL.objValue;
    }

    public static long getFileSize(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65594, null, file)) == null) {
            long j = 0;
            FileInputStream fileInputStream = null;
            try {
            } catch (Exception e) {
                TiebaStatic.file(e, "FileHelper.getFileSize");
            }
            try {
                try {
                    if (file.exists()) {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            j = fileInputStream2.available();
                            fileInputStream = fileInputStream2;
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream = fileInputStream2;
                            TiebaStatic.file(e, "FileHelper.getFileSize");
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return j;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e3) {
                                    TiebaStatic.file(e3, "FileHelper.getFileSize");
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return j;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return invokeL.longValue;
        }
    }

    public static int[] getImageFileWH(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65597, null, str)) == null) {
            int[] iArr = new int[2];
            if (StringUtils.isNull(str)) {
                return iArr;
            }
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        BitmapFactory.decodeStream(fileInputStream2, null, options);
                        sd.e(fileInputStream2);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        try {
                            th.printStackTrace();
                            iArr[0] = options.outWidth;
                            iArr[1] = options.outHeight;
                            return iArr;
                        } finally {
                            sd.e(fileInputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                iArr[0] = options.outWidth;
                iArr[1] = options.outHeight;
                return iArr;
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static boolean isGifImage(String str) {
        InterceptResult invokeL;
        InputStream w;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65611, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && !file.isDirectory() && (w = nd.w(file)) != null) {
                try {
                    byte[] bArr = new byte[7];
                    if (w.read(bArr, 0, 6) == 6) {
                        boolean isGif = BdUtilHelper.isGif(bArr);
                        BdCloseHelper.close(w);
                        return isGif;
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    BdCloseHelper.close(w);
                    throw th;
                }
                BdCloseHelper.close(w);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean CopyDir(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, str, str2, z)) == null) {
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

    /* JADX WARN: Removed duplicated region for block: B:50:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String SaveTempFile(int i, String str, byte[] bArr) {
        InterceptResult invokeILL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65555, null, i, str, bArr)) == null) {
            FileOutputStream fileOutputStream2 = null;
            if (str == null || bArr == null || bArr.length == 0) {
                return null;
            }
            String tempFilePath = getTempFilePath(i, str, true);
            if (tempFilePath != null) {
                return tempFilePath;
            }
            try {
                File createTempFile = File.createTempFile(getPrefixByType(i), str, CACHE_DIR);
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
                    } catch (IOException e) {
                        e = e;
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
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
        } else {
            return (String) invokeILL.objValue;
        }
    }

    public static String getTempFilePath(int i, String str, boolean z) {
        InterceptResult invokeCommon;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65606, null, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)})) == null) {
            File file = CACHE_DIR;
            if (file == null || (listFiles = file.listFiles()) == null) {
                return null;
            }
            String prefixByType = getPrefixByType(i);
            for (File file2 : listFiles) {
                if (file2 != null && !TextUtils.isEmpty(file2.getName()) && file2.getName().startsWith(prefixByType)) {
                    if (file2.getName().endsWith(str)) {
                        return file2.getAbsolutePath();
                    }
                    if (z) {
                        file2.delete();
                    }
                }
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    public static String saveGifByRelativePath(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65624, null, str, str2, str3)) == null) {
            if (StringUtils.isNull(str) || StringUtils.isNull(str3)) {
                return null;
            }
            if (str2 != null) {
                str4 = getTmpPath() + "/" + str2 + "/";
            } else {
                str4 = getTmpPath() + "/";
            }
            if (!CheckSDCardDir(str4)) {
                return null;
            }
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            File file2 = new File(str4, str3);
            if (file2.exists() && !file2.delete()) {
                return null;
            }
            FileUtils.copy(file, file2);
            return file2.getAbsolutePath();
        }
        return (String) invokeLLL.objValue;
    }

    public static File CreateFileIfNotFoundInCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            return CreateFileIfNotFoundAbsolutePath(new File(CACHE_DIR + "/" + str).getAbsolutePath());
        }
        return (File) invokeL.objValue;
    }

    public static InputStream GetStreamFromTmpFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            File file = new File(str);
            File file2 = null;
            try {
                if (!file.exists()) {
                    file = null;
                }
                file2 = file;
            } catch (SecurityException e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, "FileHelper.GetStreamFromTmpFile " + str);
            }
            return GetStreamFromFile(file2);
        }
        return (InputStream) invokeL.objValue;
    }

    public static void clearCacheDir(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65563, null, str) != null) || str == null) {
            return;
        }
        deleteCacheDirFiles(new File(CACHE_DIR + "/" + str));
    }

    public static File createExternalFileIfNotFound(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
            if (!CheckExternalPrivateDir()) {
                return null;
            }
            return CreateFileIfNotFoundAbsolutePath(new File(EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/" + str).getAbsolutePath());
        }
        return (File) invokeL.objValue;
    }

    public static void deleteCacheDirFiles(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65573, null, file) == null) && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
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

    public static File getDCIMFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65584, null, str)) == null) {
            if (!CheckExternalPrivateDir()) {
                return null;
            }
            return GetFileByAbsolutePath(EXTERNAL_STORAGE_DCIM_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + str);
        }
        return (File) invokeL.objValue;
    }

    public static File getExternalPrivateFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65592, null, str)) == null) {
            if (!CheckExternalPrivateDir()) {
                return null;
            }
            return GetFileByAbsolutePath(EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/" + str);
        }
        return (File) invokeL.objValue;
    }

    public static boolean isLocalFile(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65612, null, uri)) == null) {
            if (uri == null) {
                return false;
            }
            try {
                File file = new File(new URI(uri.toString()));
                if (!file.isFile() || !file.exists()) {
                    return false;
                }
                return true;
            } catch (IllegalArgumentException | URISyntaxException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void makeDirectory(String str) {
        String externalPrivateDir;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65613, null, str) == null) && (externalPrivateDir = getExternalPrivateDir(str)) != null) {
            try {
                File file = new File(externalPrivateDir);
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception e) {
                TiebaStatic.file(e, "FileHelper.makeDirectory " + externalPrivateDir);
            }
        }
    }

    public static boolean makeRootDirectory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdir();
                    return true;
                }
                return true;
            } catch (Exception e) {
                TiebaStatic.file(e, "FileHelper.makeRootDirectory " + str);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean DelFile(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65548, null, str, z)) == null) {
            if (!CheckExternalDCIMDir()) {
                return false;
            }
            File file = new File(getTmpPath() + "/" + str);
            try {
                if (!file.exists()) {
                    return false;
                }
                return file.delete();
            } catch (Throwable th) {
                BdLog.e(th.getMessage());
                String message = th.getMessage();
                TiebaStatic.file(message, "FileHelper.DelFile " + str);
                return false;
            }
        }
        return invokeLZ.booleanValue;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65598, null, context, uri)) == null) {
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
                    if (!"content".equals(scheme)) {
                        return null;
                    }
                    try {
                        context = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                    } catch (Exception e) {
                        e = e;
                        context = 0;
                    } catch (Throwable th) {
                        th = th;
                        BdCloseHelper.close(cursor);
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
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            context = context;
                            BdCloseHelper.close((Cursor) context);
                            return str;
                        }
                    }
                    BdCloseHelper.close((Cursor) context);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = context;
                }
            } else {
                return uri.getPath();
            }
        } else {
            return (String) invokeLL.objValue;
        }
    }

    public static boolean saveFileByAbsolutePath(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65620, null, str, bArr)) == null) {
            File file = new File(str);
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                        return false;
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr, 0, bArr.length);
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                        return true;
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e2) {
                                BdLog.e(e2.getMessage());
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                BdLog.e(e3.getMessage());
                            }
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return invokeLL.booleanValue;
        }
    }

    public static File GetFileInCache(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            return GetFileByAbsolutePath(CACHE_DIR + "/" + str);
        }
        return (File) invokeL.objValue;
    }

    public static InputStream GetStreamFromFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, file)) == null) {
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

    public static boolean checkIsCssFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return str.endsWith(FILE_CACHE_CSS);
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean checkIsHeifImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            if (!str.endsWith(FILE_CACHE_HEIF) && !str.endsWith(FILE_CACHE_HEIC)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean deleteFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, file)) == null) {
            try {
                return file.delete();
            } catch (Exception e) {
                TiebaStatic.file(e, "FileHelper.deleteFile");
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String getCustomLoginCssFileName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return null;
            }
            return parse.getLastPathSegment();
        }
        return (String) invokeL.objValue;
    }

    public static String getDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, str)) == null) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf > 0 && lastIndexOf < str.length()) {
                return str.substring(0, lastIndexOf);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getExternalPrivateDir(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65591, null, str)) == null) {
            if (str == null) {
                return null;
            }
            return EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/" + str;
        }
        return (String) invokeL.objValue;
    }

    public static long getFileSize(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65595, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return 0L;
            }
            return getFileSize(new File(str));
        }
        return invokeL.longValue;
    }

    public static InputStream getStreamFromExternalPrivateFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65604, null, str)) == null) {
            return GetStreamFromFile(getExternalPrivateFile(str));
        }
        return (InputStream) invokeL.objValue;
    }

    public static boolean checkFileSize(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, str, i)) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    if (file.length() < i * 1024) {
                        return true;
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public static long getDirectorySize(File file, boolean z) {
        InterceptResult invokeLZ;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65586, null, file, z)) == null) {
            File[] listFiles = file.listFiles();
            long j = 0;
            if (listFiles == null) {
                return 0L;
            }
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory() && !z) {
                    length = getDirectorySize(listFiles[i], false);
                } else {
                    length = listFiles[i].length();
                }
                j += length;
            }
            return j;
        }
        return invokeLZ.longValue;
    }

    public static String getPrefixPath(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65601, null, str, z)) == null) {
            String str2 = EXTERNAL_STORAGE_DCIM_DIRECTORY + "/" + str;
            if (!z || !str.startsWith(EXTERNAL_STORAGE_DCIM_DIRECTORY.toString())) {
                return str2;
            }
            return str;
        }
        return (String) invokeLZ.objValue;
    }

    public static String getStoreFile(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65603, null, str, i)) == null) {
            if (str == null) {
                return null;
            }
            if (checkSD()) {
                if (!CheckExternalPrivateFile(getFilePath(str, i, false))) {
                    return null;
                }
                return getFilePath(str, i, true);
            }
            return getTempFilePath(1, str);
        }
        return (String) invokeLI.objValue;
    }

    public static boolean renameTo(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65615, null, str, str2)) == null) {
            File file = new File(str);
            File file2 = new File(str2);
            String parent = file2.getParent();
            if (!StringUtils.isNull(parent)) {
                File file3 = new File(parent);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
            }
            if (!file.exists()) {
                return false;
            }
            return file.renameTo(file2);
        }
        return invokeLL.booleanValue;
    }

    public static boolean checkIsLongImage(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            int[] imageFileWH = getImageFileWH(str);
            if (imageFileWH[0] == 0 || imageFileWH[1] == 0) {
                return false;
            }
            float equipmentDensity = BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst());
            float f = imageFileWH[1] / imageFileWH[0];
            if (imageFileWH[0] * equipmentDensity < 100.0f || f < 3.0f || f > 50.0f) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String compressBitmapToFile(String str, Bitmap bitmap, float f, int i) {
        InterceptResult invokeCommon;
        File dataDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65564, null, new Object[]{str, bitmap, Float.valueOf(f), Integer.valueOf(i)})) == null) {
            if (bitmap == null) {
                return null;
            }
            if (checkSD()) {
                dataDirectory = new File(EXTERNAL_STORAGE_PRIVATE_DIRECTORY.getAbsolutePath());
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
                if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                    return null;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                while (byteArrayOutputStream.toByteArray().length > f) {
                    byteArrayOutputStream.reset();
                    i -= 5;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, rd.join("FileHelper", ".", "compressBitmapToFile", " ", file.getAbsolutePath()));
                return null;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String tmpSuffixRenameTo(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        String str5;
        String str6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65627, null, str, str2, str3, str4)) == null) {
            if (str != null) {
                str5 = getTmpPath() + "/" + str + "/";
            } else {
                str5 = getTmpPath() + "/";
            }
            if (str3 != null) {
                str6 = getTmpPath() + "/" + str3 + "/";
            } else {
                str6 = getTmpPath() + "/";
            }
            if (!CheckSDCardDir(str5) || !CheckSDCardDir(str6)) {
                return null;
            }
            File file = new File(str5 + str2);
            File file2 = new File(str6 + str4);
            if (!file.renameTo(file2)) {
                TiebaStatic.file(rd.join("renameTo", NotificationCompat.CATEGORY_ERROR), rd.join("FileHelper", ".", "renameTo"));
                return null;
            }
            return file2.getAbsolutePath();
        }
        return (String) invokeLLLL.objValue;
    }

    public static String compressBitmapToFile(String str, String str2, Bitmap bitmap, float f, int i) {
        InterceptResult invokeCommon;
        File dataDirectory;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, null, new Object[]{str, str2, bitmap, Float.valueOf(f), Integer.valueOf(i)})) == null) {
            if (bitmap == null) {
                return null;
            }
            if (str != null) {
                try {
                    dataDirectory = new File(str);
                } catch (Exception unused) {
                    if (checkSD()) {
                        dataDirectory = new File(EXTERNAL_STORAGE_PRIVATE_DIRECTORY.getAbsolutePath());
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
                if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                    return null;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                while (byteArrayOutputStream.toByteArray().length > f) {
                    byteArrayOutputStream.reset();
                    i -= 5;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, rd.join("FileHelper", ".", "compressBitmapToFile", " ", file.getAbsolutePath()));
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, str, str2)) == null) {
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
                                        if (fileOutputStream == null) {
                                            return false;
                                        }
                                        try {
                                            fileOutputStream.close();
                                            return false;
                                        } catch (Throwable th4) {
                                            BdLog.e(th4.toString());
                                            TiebaStatic.file(th4.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                            return false;
                                        }
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
        } else {
            return invokeLL.booleanValue;
        }
    }

    public static void copyFileByRelativelyPath(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, str, str2) == null) {
            copyFileByRelativelyPath(str, str2, false);
        }
    }

    public static long getDirectorySize(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65587, null, str, z)) == null) {
            return getDirectorySize(new File(str), z);
        }
        return invokeLZ.longValue;
    }

    public static String getTempFilePath(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65605, null, i, str)) == null) {
            return getTempFilePath(i, str, false);
        }
        return (String) invokeIL.objValue;
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
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65568, null, str, str2, z)) == null) {
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
                                        if (fileOutputStream != null) {
                                            return false;
                                        }
                                        try {
                                            fileOutputStream.close();
                                            return false;
                                        } catch (Throwable th3) {
                                            BdLog.e(th3.toString());
                                            TiebaStatic.file(th3.getMessage(), "FileHelper.CopyFile " + str + " to " + str2);
                                            return false;
                                        }
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
                        if (fileOutputStream != null) {
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
        } else {
            return invokeLLZ.booleanValue;
        }
    }

    public static int copyImageFile(String str, String str2, Context context) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65569, null, str, str2, context)) == null) {
            if (str2 != null && str2.length() != 0 && context != null) {
                try {
                    String str3 = ".jpg";
                    if (isGifImage(str)) {
                        str3 = ".gif";
                    }
                    String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str2);
                    if (nameMd5FromUrl == null) {
                        return -1;
                    }
                    String str4 = nameMd5FromUrl + str3;
                    for (int i = 0; CheckDCIMFile(str4) && i < 10000; i++) {
                        str4 = nameMd5FromUrl + Math.round(Math.random() * 9.9999999E7d) + str3;
                    }
                    String str5 = getDCIMDir() + str4;
                    nd.f(new File(str), new File(str5));
                    new MediaScannerClient(context).saveImage(str5);
                    return 0;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static int saveImageFileByUser(String str, byte[] bArr, Context context) {
        InterceptResult invokeLLL;
        Bitmap decodeByteArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65625, null, str, bArr, context)) == null) {
            if (bArr != null && str != null && str.length() != 0 && context != null) {
                try {
                    String str2 = ".jpg";
                    if (BdUtilHelper.isGif(bArr)) {
                        str2 = ".gif";
                    }
                    if (BdUtilHelper.isDataWebpFormat(bArr) && (decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length)) != null) {
                        bArr = ld.d().a(decodeByteArray, 100);
                        decodeByteArray.recycle();
                    }
                    String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(str);
                    if (nameMd5FromUrl == null) {
                        return -1;
                    }
                    String str3 = nameMd5FromUrl + str2;
                    for (int i = 0; CheckDCIMFile(str3) && i < 10000; i++) {
                        str3 = nameMd5FromUrl + Math.round(Math.random() * 9.9999999E7d) + str2;
                    }
                    String saveFileByBytes = saveFileByBytes(null, str3, bArr);
                    if (saveFileByBytes != null) {
                        new MediaScannerClient(context).saveImage(saveFileByBytes);
                        return 0;
                    }
                    return -2;
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
            return -1;
        }
        return invokeLLL.intValue;
    }

    public static String getFilePath(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65593, null, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (checkSD()) {
                StringBuilder sb = new StringBuilder();
                if (z) {
                    sb.append(getCacheDir());
                }
                sb.append(getPrefixByType(i));
                sb.append(File.separator);
                sb.append(str);
                return sb.toString();
            }
            return null;
        }
        return (String) invokeCommon.objValue;
    }

    @Nullable
    public static String getPackNameFromFile(Context context, String str) {
        InterceptResult invokeLL;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65599, null, context, str)) == null) {
            if (context == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.e("downloadFile", "下载完成解析apk包名失败，context=null，filePath=" + str);
                return null;
            } else if (rd.isEmpty(str)) {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.e("downloadFile", "下载完成解析apk包名失败，filePath" + str);
                return null;
            } else if (!FileUtils.exists(str)) {
                TbLog defaultLog3 = DefaultLog.getInstance();
                defaultLog3.e("downloadFile", "下载完成解析apk包名失败，文件不存在，filePath" + str);
                return null;
            } else {
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
                if (packageArchiveInfo != null && (applicationInfo = packageArchiveInfo.applicationInfo) != null) {
                    return applicationInfo.packageName;
                }
                TbLog defaultLog4 = DefaultLog.getInstance();
                defaultLog4.e("downloadFile", "下载完成解析apk包名失败，path=" + str);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String saveFileByStream(String str, InputStream inputStream) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65623, null, str, inputStream)) == null) {
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
                    sd.f(null);
                    return null;
                } else if (!file.createNewFile()) {
                    sd.f(null);
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
                                    sd.f(fileOutputStream);
                                    return path;
                                }
                            }
                        } catch (IOException e) {
                            e = e;
                            BdLog.e(e.getMessage());
                            TiebaStatic.file(e, "FileHelper.saveFile " + str);
                            sd.f(fileOutputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        sd.f(fileOutputStream2);
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                sd.f(fileOutputStream2);
                throw th;
            }
        } else {
            return (String) invokeLL.objValue;
        }
    }

    public static String getSdErrorString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65602, null)) == null) {
            String externalStorageState = Environment.getExternalStorageState();
            if (externalStorageState.equals("removed")) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.error_no_sdcard);
            }
            if (!externalStorageState.equals("unmounted") && !externalStorageState.equals("unmountable")) {
                if (externalStorageState.equals(SwanKV.FLAVOR_SHARED)) {
                    return TbadkCoreApplication.getInst().getApp().getString(R.string.error_sd_shared);
                }
                return TbadkCoreApplication.getInst().getApp().getString(R.string.error_sd_error);
            }
            return TbadkCoreApplication.getInst().getApp().getString(R.string.error_no_sdcard);
        }
        return (String) invokeV.objValue;
    }

    public static Bitmap getTempImg(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65607, null, str, str2)) == null) {
            if (str != null) {
                str3 = getTmpPath() + "/" + str + "/";
            } else {
                str3 = getTmpPath() + "/";
            }
            return getImage(str3 + str2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static void scanMediaFile(String[] strArr, MediaScanCallback mediaScanCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65626, null, strArr, mediaScanCallback) == null) {
            if (strArr != null && strArr.length != 0) {
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
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
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
                                SafeHandler.getInst().post(new Runnable(this) { // from class: com.baidu.tbadk.core.util.FileHelper.1.1
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
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
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
                                        if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && (mediaScanCallback2 = (anonymousClass1 = this.this$0).val$callback) != null) {
                                            mediaScanCallback2.callBack(anonymousClass1.val$map);
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
            } else if (mediaScanCallback != null) {
                mediaScanCallback.callBack(null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65610, null, str, str2)) == null) {
            if (str != null) {
                str3 = EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/" + str + "/";
            } else {
                str3 = EXTERNAL_STORAGE_PRIVATE_DIRECTORY + "/";
            }
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(new File(str3 + str2));
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                try {
                    byte[] bArr = new byte[7];
                    if (fileInputStream.read(bArr, 0, 6) == 6) {
                        z = BdUtilHelper.isGif(bArr);
                    } else {
                        z = false;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            TiebaStatic.file(e3, rd.join("FileHelper", ".", "isGif", " ", str, "/", str2));
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                fileInputStream2 = fileInputStream;
                z = false;
                e.printStackTrace();
                TiebaStatic.file(e, rd.join("FileHelper", ".", "isGif", " ", str, "/", str2));
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e5) {
                        exc = e5;
                        exc.printStackTrace();
                        join = rd.join("FileHelper", ".", "isGif", " ", str, "/", str2);
                        TiebaStatic.file(exc, join);
                        return z;
                    }
                }
                return z;
            } catch (IOException e6) {
                e = e6;
                fileInputStream2 = fileInputStream;
                z = false;
                e.printStackTrace();
                TiebaStatic.file(e, rd.join("FileHelper", "isGif", " ", str, "/", str2));
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e7) {
                        exc = e7;
                        exc.printStackTrace();
                        join = rd.join("FileHelper", ".", "isGif", " ", str, "/", str2);
                        TiebaStatic.file(exc, join);
                        return z;
                    }
                }
                return z;
            }
            try {
                fileInputStream.close();
                if (0 != 0) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e8) {
                        exc = e8;
                        exc.printStackTrace();
                        join = rd.join("FileHelper", ".", "isGif", " ", str, "/", str2);
                        TiebaStatic.file(exc, join);
                        return z;
                    }
                }
            } catch (FileNotFoundException e9) {
                e = e9;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                TiebaStatic.file(e, rd.join("FileHelper", ".", "isGif", " ", str, "/", str2));
                if (fileInputStream2 != null) {
                }
                return z;
            } catch (IOException e10) {
                e = e10;
                fileInputStream2 = fileInputStream;
                e.printStackTrace();
                TiebaStatic.file(e, rd.join("FileHelper", "isGif", " ", str, "/", str2));
                if (fileInputStream2 != null) {
                }
                return z;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static String saveBitmapByAbsolutelyPath(String str, String str2, Bitmap bitmap, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65616, null, str, str2, bitmap, i)) == null) {
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
                    if ((file2.exists() && !file2.delete()) || !file2.createNewFile()) {
                        return null;
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file2.getAbsolutePath();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    TiebaStatic.file(e, rd.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file2.getAbsolutePath()));
                }
            }
            return null;
        }
        return (String) invokeLLLI.objValue;
    }

    public static String saveBitmapByRelativelyPath(String str, String str2, Bitmap bitmap, int i) {
        InterceptResult invokeLLLI;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65617, null, str, str2, bitmap, i)) == null) {
            if (bitmap == null) {
                return null;
            }
            if (str != null) {
                str3 = getTmpPath() + "/" + str + "/";
            } else {
                str3 = getTmpPath() + "/";
            }
            if (!CheckSDCardDir(str3)) {
                return null;
            }
            File file = new File(str3 + str2);
            try {
                if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                    return null;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getPath();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, rd.join("FileHelper", ".", "SaveFile1", " '", str, "/", str2));
                return null;
            }
        }
        return (String) invokeLLLI.objValue;
    }

    public static String saveFileAsPNG(String str, String str2, Bitmap bitmap, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65618, null, str, str2, bitmap, i)) == null) {
            return saveFileAsPic(str, str2, bitmap, i, Bitmap.CompressFormat.PNG);
        }
        return (String) invokeLLLI.objValue;
    }

    public static String saveFileAsPic(String str, String str2, Bitmap bitmap, int i, Bitmap.CompressFormat compressFormat) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65619, null, new Object[]{str, str2, bitmap, Integer.valueOf(i), compressFormat})) == null) {
            if (bitmap == null || !CheckDir(str)) {
                return null;
            }
            File file = new File(str + str2);
            try {
                if ((file.exists() && !file.delete()) || !file.createNewFile()) {
                    return null;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(compressFormat, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getPath();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                TiebaStatic.file(e, rd.join("FileHelper", ".", "saveFileAsPNG", " '", str, "/", str2));
                return null;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String saveFileByBytes(String str, String str2, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65621, null, str, str2, bArr)) == null) {
            return saveFileByBytes(str, str2, bArr, false);
        }
        return (String) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String saveFileByBytes(String str, String str2, byte[] bArr, boolean z) {
        InterceptResult invokeCommon;
        String str3;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65622, null, new Object[]{str, str2, bArr, Boolean.valueOf(z)})) == null) {
            if (!z) {
                if (str != null) {
                    str3 = EXTERNAL_STORAGE_DCIM_DIRECTORY + "/" + str + "/";
                } else {
                    str3 = EXTERNAL_STORAGE_DCIM_DIRECTORY + "/" + TbConfig.getTempDirName() + "/";
                }
            } else {
                str3 = str;
            }
            FileOutputStream fileOutputStream = null;
            if (!CheckSDCardDir(str3) || bArr == null || str2 == null) {
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
                if (file.exists()) {
                    try {
                        try {
                            if (!file.delete()) {
                                return null;
                            }
                        } catch (IOException e) {
                            e = e;
                            BdLog.e(e.getMessage());
                            TiebaStatic.file(e, rd.join("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return null;
                                } catch (Throwable th2) {
                                    BdLog.e(th2.getMessage());
                                    TiebaStatic.file(th2.getMessage(), rd.join("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                                    return null;
                                }
                            }
                            return null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th4) {
                                BdLog.e(th4.getMessage());
                                TiebaStatic.file(th4.getMessage(), rd.join("FileHelper", ".", "SaveFile", " ", str, "/", str2));
                            }
                        }
                        throw th;
                    }
                }
                if (!file.createNewFile()) {
                    return null;
                }
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bArr, 0, bArr.length);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getPath();
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } else {
            return (String) invokeCommon.objValue;
        }
    }
}
