package com.baidu.minivideo.plugin.capture.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.minivideo.plugin.capture.Application;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* loaded from: classes2.dex */
public class FileUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PUBLIC_SUCCESS_TEMP_DIR = "public_succes_temp";
    public static final String VIDEO_COVER_DIR = "video_cover";
    public static final String VIDEO_UPLOAD_DIR = "video_upload";
    public static File sPublishedFolder;
    public transient /* synthetic */ FieldHolder $fh;

    public FileUtils() {
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

    public static String createTempFileName(File file, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, str)) == null) {
            if (file == null) {
                return null;
            }
            return file.getAbsolutePath() + File.separator + (System.currentTimeMillis() + "_" + new Random().nextInt(10000) + str);
        }
        return (String) invokeLL.objValue;
    }

    public static boolean delete(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            if (file == null) {
                return false;
            }
            deleteNotCheck(file);
            return !file.exists();
        }
        return invokeL.booleanValue;
    }

    public static void deleteAllFiles(File file) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, file) == null) || file == null || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (!file2.isDirectory()) {
                file2.delete();
            }
        }
    }

    public static boolean deleteDir(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file)) == null) {
            if (file.isDirectory()) {
                for (String str : file.list()) {
                    if (!deleteDir(new File(file, str))) {
                        return false;
                    }
                }
            }
            return file.delete();
        }
        return invokeL.booleanValue;
    }

    public static boolean deleteFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
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

    public static void deleteNotCheck(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, file) == null) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    deleteNotCheck(file2);
                    file.delete();
                }
                return;
            }
            file.delete();
        }
    }

    public static long getDirectorySize(String str) throws IOException {
        InterceptResult invokeL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
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

    public static boolean getExistFile(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, file)) == null) ? file.exists() : invokeL.booleanValue;
    }

    public static String getFileMD5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.exists()) {
                return EncryptUtils.encrypt("MD5", file, false);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static Bitmap getLocalVideoBitmap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            Bitmap bitmap = null;
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    bitmap = mediaMetadataRetriever.getFrameAtTime();
                    return BitmapUtils.scaleCover(bitmap, Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)), Integer.parseInt(mediaMetadataRetriever.extractMetadata(19)), true);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    mediaMetadataRetriever.release();
                    return bitmap;
                } catch (Exception unused) {
                    mediaMetadataRetriever.release();
                    return bitmap;
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public static String getSuffix(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(".")) <= 0) ? "" : str.substring(lastIndexOf) : (String) invokeL.objValue;
    }

    public static File getVideoCoverCacheDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            File externalCacheDir = Application.get().getExternalCacheDir();
            if (externalCacheDir == null || !externalCacheDir.exists()) {
                externalCacheDir = Application.get().getFilesDir();
            }
            File file = new File(externalCacheDir, VIDEO_COVER_DIR);
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static boolean isExistFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return new File(str).exists();
        }
        return invokeL.booleanValue;
    }

    public static boolean isSDMounted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? Environment.getExternalStorageState().equals("mounted") : invokeV.booleanValue;
    }

    public static String saveBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, bitmap)) == null) {
            File videoCoverCacheDir = getVideoCoverCacheDir();
            File file = new File(videoCoverCacheDir, System.currentTimeMillis() + ".jpg");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                if (bitmap != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return file.getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    public static void unzipFile(File file, String str) throws ZipException, IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, file, str) == null) {
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (!"./".equals(name) && !".".equals(name) && !name.endsWith("/")) {
                    InputStream inputStream = zipFile.getInputStream(nextElement);
                    File file3 = new File(str + File.separator + name);
                    if (!file3.exists()) {
                        File parentFile = file3.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        file3.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    inputStream.close();
                    fileOutputStream.close();
                }
            }
        }
    }

    public static long getDirectorySize(File file) throws IOException {
        InterceptResult invokeL;
        long length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
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
}
