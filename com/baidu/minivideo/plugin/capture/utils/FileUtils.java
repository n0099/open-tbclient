package com.baidu.minivideo.plugin.capture.utils;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.minivideo.plugin.capture.Application;
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
/* loaded from: classes18.dex */
public class FileUtils {
    public static final String PUBLIC_SUCCESS_TEMP_DIR = "public_succes_temp";
    public static final String VIDEO_COVER_DIR = "video_cover";
    public static final String VIDEO_UPLOAD_DIR = "video_upload";
    private static File sPublishedFolder;

    public static File getVideoCoverCacheDir() {
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

    public static void deleteAllFiles(File file) {
        File[] listFiles;
        if (file != null && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (!file2.isDirectory()) {
                    file2.delete();
                }
            }
        }
    }

    public static String createTempFileName(File file, String str) {
        if (file == null) {
            return null;
        }
        return file.getAbsolutePath() + File.separator + (System.currentTimeMillis() + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + new Random().nextInt(10000) + str);
    }

    public static boolean isExistFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean deleteFile(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                return file.delete();
            }
        }
        return false;
    }

    public static String getFileMD5(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                return EncryptUtils.encrypt("MD5", file, false);
            }
        }
        return null;
    }

    public static String getSuffix(String str) {
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(".")) <= 0) ? "" : str.substring(lastIndexOf);
    }

    public static long getDirectorySize(String str) throws IOException {
        long length;
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

    public static long getDirectorySize(File file) throws IOException {
        long length;
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

    public static Bitmap getLocalVideoBitmap(String str) {
        Bitmap bitmap;
        IllegalArgumentException illegalArgumentException;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(str);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                try {
                    bitmap = BitmapUtils.scaleCover(frameAtTime, Integer.parseInt(mediaMetadataRetriever.extractMetadata(18)), Integer.parseInt(mediaMetadataRetriever.extractMetadata(19)), true);
                } catch (IllegalArgumentException e) {
                    bitmap = frameAtTime;
                    illegalArgumentException = e;
                    illegalArgumentException.printStackTrace();
                    mediaMetadataRetriever.release();
                    return bitmap;
                } catch (Exception e2) {
                    bitmap = frameAtTime;
                    return bitmap;
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        } catch (IllegalArgumentException e3) {
            bitmap = null;
            illegalArgumentException = e3;
        } catch (Exception e4) {
            bitmap = null;
        }
        return bitmap;
    }

    public static String saveBitmap(Bitmap bitmap) {
        File file = new File(getVideoCoverCacheDir(), System.currentTimeMillis() + ".jpg");
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

    public static void unzipFile(File file, String str) throws ZipException, IOException {
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

    public static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!deleteDir(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        deleteNotCheck(file);
        return !file.exists();
    }

    private static void deleteNotCheck(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            file.delete();
            return;
        }
        for (File file2 : listFiles) {
            deleteNotCheck(file2);
            file.delete();
        }
    }

    public static boolean getExistFile(File file) {
        return file.exists();
    }

    public static boolean isSDMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
