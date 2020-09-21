package com.baidu.searchbox.ugc.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.digest4util.EncryptUtils;
/* loaded from: classes6.dex */
public class FileUtils {
    private static final boolean DEBUG = false;
    private static final String IMAGE_DIR = "imgDir";
    private static final String UPLOAD_DIR = "ugc_upload";
    public static final String VIDEOCOVER = File.separator + "baidu" + File.separator + "searchbox" + File.separator + "videocover";
    private static final String VIDEO_CLIP_DIR = "video_clip";
    private static final String VIDEO_DIR = "videoDir";

    public static File getUploadCacheDir() {
        File externalCacheDir = AppRuntime.getAppContext().getExternalCacheDir();
        if (externalCacheDir == null || !externalCacheDir.exists()) {
            externalCacheDir = AppRuntime.getAppContext().getFilesDir();
        }
        File file = new File(externalCacheDir, UPLOAD_DIR);
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

    public static String createTempFileName(File file, String str, String str2) {
        if (file == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        return file.getAbsolutePath() + File.separator + (EncryptUtils.encrypt("MD5", str2.getBytes(), true) + System.currentTimeMillis() + str);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [179=4] */
    public static Bitmap getLocalVideoBitmap(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th;
        Bitmap bitmap = null;
        try {
            mediaMetadataRetriever = getMediaMetadataRetriever(str);
        } catch (IllegalArgumentException e) {
            mediaMetadataRetriever = null;
        } catch (Throwable th2) {
            mediaMetadataRetriever = null;
            th = th2;
        }
        try {
            bitmap = mediaMetadataRetriever.getFrameAtTime(0L, 2);
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
        } catch (IllegalArgumentException e2) {
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
        return bitmap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [206=4] */
    public static Bitmap getVideoFrameBitmap(String str, long j) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th;
        Bitmap bitmap = null;
        try {
            mediaMetadataRetriever = getMediaMetadataRetriever(str);
            try {
                bitmap = mediaMetadataRetriever.getFrameAtTime(j);
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
            } catch (IllegalArgumentException e) {
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
        } catch (IllegalArgumentException e2) {
            mediaMetadataRetriever = null;
        } catch (Throwable th3) {
            mediaMetadataRetriever = null;
            th = th3;
        }
        return bitmap;
    }

    public static Bitmap getRotatedBitmap(Bitmap bitmap, int i) {
        if (i % EncoderTextureDrawer.X264_WIDTH != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(i);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return bitmap;
    }

    public static String saveBitmap(Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        if (bitmap == null) {
            return null;
        }
        File file = new File(Environment.getExternalStorageDirectory().getPath() + VIDEOCOVER);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, System.currentTimeMillis() + ".jpg");
        try {
            fileOutputStream = new FileOutputStream(file2);
        } catch (IOException e) {
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            Closeables.closeSafely(fileOutputStream);
        } catch (IOException e2) {
            fileOutputStream2 = fileOutputStream;
            Closeables.closeSafely(fileOutputStream2);
            return file2.getAbsolutePath();
        } catch (Throwable th3) {
            th = th3;
            Closeables.closeSafely(fileOutputStream);
            throw th;
        }
        return file2.getAbsolutePath();
    }

    public static void deleteCoverFile(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File file2 : listFiles) {
                deleteCoverFile(file2);
            }
            file.delete();
        }
    }

    public static String saveImageDraft(Context context, String str) {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        File file = new File(new ContextWrapper(context).getDir(IMAGE_DIR, 0), getFileNameFromPath(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        Bitmap loadBitmap = CompressImageUtil.loadBitmap(str);
        if (loadBitmap != null) {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e) {
            } catch (Throwable th2) {
                fileOutputStream = null;
                th = th2;
            }
            try {
                loadBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                Closeables.closeSafely(fileOutputStream);
            } catch (Exception e2) {
                fileOutputStream2 = fileOutputStream;
                Closeables.closeSafely(fileOutputStream2);
                return file.getAbsolutePath();
            } catch (Throwable th3) {
                th = th3;
                Closeables.closeSafely(fileOutputStream);
                throw th;
            }
            return file.getAbsolutePath();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [357=4] */
    public static String saveGifDraft(Context context, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        BufferedInputStream bufferedInputStream;
        InputStream inputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        BufferedInputStream bufferedInputStream2;
        InputStream inputStream2;
        FileOutputStream fileOutputStream2 = null;
        File file = new File(new ContextWrapper(context).getDir(IMAGE_DIR, 0), getFileNameFromPath(str));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        try {
            inputStream = FileHelper.getInputStream(str);
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = bufferedInputStream.read();
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(read);
                        } catch (IOException e) {
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            bufferedInputStream2 = bufferedInputStream;
                            inputStream2 = inputStream;
                        } catch (Throwable th2) {
                            fileOutputStream = null;
                            th = th2;
                        }
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(byteArrayOutputStream.toByteArray());
                        fileOutputStream.flush();
                        Closeables.closeSafely(inputStream);
                        Closeables.closeSafely(bufferedInputStream);
                        Closeables.closeSafely(byteArrayOutputStream);
                        Closeables.closeSafely(fileOutputStream);
                    } catch (IOException e2) {
                        fileOutputStream2 = fileOutputStream;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        bufferedInputStream2 = bufferedInputStream;
                        inputStream2 = inputStream;
                        Closeables.closeSafely(inputStream2);
                        Closeables.closeSafely(bufferedInputStream2);
                        Closeables.closeSafely(byteArrayOutputStream2);
                        Closeables.closeSafely(fileOutputStream2);
                        return file.getAbsolutePath();
                    } catch (Throwable th3) {
                        th = th3;
                        Closeables.closeSafely(inputStream);
                        Closeables.closeSafely(bufferedInputStream);
                        Closeables.closeSafely(byteArrayOutputStream);
                        Closeables.closeSafely(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e3) {
                    byteArrayOutputStream2 = null;
                    bufferedInputStream2 = bufferedInputStream;
                    inputStream2 = inputStream;
                } catch (Throwable th4) {
                    byteArrayOutputStream = null;
                    th = th4;
                    fileOutputStream = null;
                }
            } catch (IOException e4) {
                byteArrayOutputStream2 = null;
                bufferedInputStream2 = null;
                inputStream2 = inputStream;
            } catch (Throwable th5) {
                byteArrayOutputStream = null;
                bufferedInputStream = null;
                fileOutputStream = null;
                th = th5;
            }
        } catch (IOException e5) {
            byteArrayOutputStream2 = null;
            bufferedInputStream2 = null;
            inputStream2 = null;
        } catch (Throwable th6) {
            byteArrayOutputStream = null;
            bufferedInputStream = null;
            inputStream = null;
            th = th6;
            fileOutputStream = null;
        }
        return file.getAbsolutePath();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [398=5, 399=4] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String saveVideoDraft(Context context, String str) {
        FileOutputStream fileOutputStream;
        File file;
        FileOutputStream fileOutputStream2 = null;
        InputStream inputStream = FileHelper.getInputStream(str);
        try {
            try {
                file = new File(new ContextWrapper(context).getDir(VIDEO_DIR, 0), getFileNameFromPath(str) + ".mp4");
                try {
                } catch (Exception e) {
                    fileOutputStream = null;
                }
            } catch (Exception e2) {
                fileOutputStream = null;
                file = null;
            }
            if (file.exists()) {
                String absolutePath = file.getAbsolutePath();
                Closeables.closeSafely(inputStream);
                Closeables.closeSafely((Closeable) null);
                return absolutePath;
            }
            if (inputStream != null) {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e3) {
                    Closeables.closeSafely(inputStream);
                    Closeables.closeSafely(fileOutputStream);
                    if (file == null) {
                    }
                } catch (Throwable th) {
                    fileOutputStream2 = fileOutputStream;
                    th = th;
                    Closeables.closeSafely(inputStream);
                    Closeables.closeSafely(fileOutputStream2);
                    throw th;
                }
            } else {
                fileOutputStream = null;
            }
            Closeables.closeSafely(inputStream);
            Closeables.closeSafely(fileOutputStream);
            if (file == null) {
                return file.getAbsolutePath();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String getFileNameFromPath(String str) {
        String[] split = str.replaceAll("\\\\", "/").split("/");
        if (split.length <= 1) {
            return "";
        }
        return split[split.length - 1];
    }

    public static void deleteDraftFile(List<String> list) {
        for (String str : list) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void deleteDraftFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static Bitmap getResizedBitmap(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmap.recycle();
        return createBitmap;
    }

    public static File getClippedVideoCacheDir() {
        File externalCacheDir = AppRuntime.getAppContext().getExternalCacheDir();
        if (externalCacheDir == null || !externalCacheDir.exists()) {
            externalCacheDir = AppRuntime.getAppContext().getFilesDir();
        }
        File file = new File(externalCacheDir, VIDEO_CLIP_DIR);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static MediaMetadataRetriever getMediaMetadataRetriever(String str) {
        Context appContext = AppRuntime.getAppContext();
        if (appContext == null || TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = UgcUriUtils.getUri(str);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(appContext, uri);
        return mediaMetadataRetriever;
    }

    public static MediaExtractor getMediaExtractor(String str) {
        MediaExtractor mediaExtractor = null;
        Context appContext = AppRuntime.getAppContext();
        if (appContext != null && !TextUtils.isEmpty(str)) {
            Uri uri = UgcUriUtils.getUri(str);
            mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(appContext, uri, (Map<String, String>) null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mediaExtractor;
    }
}
