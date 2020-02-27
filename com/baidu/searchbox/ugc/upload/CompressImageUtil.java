package com.baidu.searchbox.ugc.upload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.support.media.ExifInterface;
import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ugc.utils.FileHelper;
import com.baidu.searchbox.ugc.utils.MediaUtils;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import com.baidu.searchbox.ugc.utils.UgcUriUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
/* loaded from: classes13.dex */
public class CompressImageUtil {
    private static final int COMPRESS_MAX = 100;
    private static final int DEFAULT_COMPRESS_VALUE = 40;
    private static final float SHORTEST_SIDE_LENGTH = 1080.0f;
    private static int sCompressValue = 40;
    private static boolean isNeedCompress = false;

    public static Bitmap loadBitmap(String str) {
        float height;
        float width;
        boolean z;
        int decodeImageDegree = decodeImageDegree(str);
        BitmapFactory.Options options = SelectUtil.getOptions(str);
        int i = options.outHeight;
        int i2 = options.outWidth;
        if (decodeImageDegree == 90 || decodeImageDegree == 270) {
            i2 = options.outWidth;
            i = options.outHeight;
        }
        boolean isLargeImage = SelectUtil.isLargeImage(str);
        options.inSampleSize = (int) calculateInSampleSize(i2, i);
        options.inJustDecodeBounds = false;
        Bitmap loadBitmap = MediaUtils.loadBitmap(str, options);
        if (loadBitmap == null) {
            return null;
        }
        if (decodeImageDegree == 90 || decodeImageDegree == 270) {
            height = SHORTEST_SIDE_LENGTH / loadBitmap.getHeight();
            width = SHORTEST_SIDE_LENGTH / loadBitmap.getWidth();
        } else {
            height = SHORTEST_SIDE_LENGTH / loadBitmap.getWidth();
            width = SHORTEST_SIDE_LENGTH / loadBitmap.getHeight();
        }
        float f = width < height ? width : height;
        boolean z2 = decodeImageDegree != 0;
        if (decodeImageDegree == 90 || decodeImageDegree == 270) {
            z = ((float) loadBitmap.getWidth()) > SHORTEST_SIDE_LENGTH || ((float) loadBitmap.getHeight()) > SHORTEST_SIDE_LENGTH;
        } else {
            z = ((float) loadBitmap.getWidth()) > SHORTEST_SIDE_LENGTH || ((float) loadBitmap.getHeight()) > SHORTEST_SIDE_LENGTH;
        }
        if (z2 || z) {
            Matrix matrix = new Matrix();
            if (z2) {
                matrix.postRotate(decodeImageDegree, loadBitmap.getWidth() / 2.0f, loadBitmap.getHeight() / 2.0f);
            }
            if (z) {
                if (isLargeImage) {
                    isNeedCompress = true;
                    if (width < height) {
                        matrix.postScale(height, height);
                    } else {
                        matrix.postScale(width, width);
                    }
                } else {
                    matrix.postScale(f, f);
                }
            }
            return Bitmap.createBitmap(loadBitmap, 0, 0, loadBitmap.getWidth(), loadBitmap.getHeight(), matrix, true);
        }
        return loadBitmap;
    }

    public static float calculateInSampleSize(int i, int i2) {
        int i3 = i2 < i ? i2 : i;
        isNeedCompress = false;
        if (i3 > SHORTEST_SIDE_LENGTH) {
            if (i2 < i) {
                return i2 / SHORTEST_SIDE_LENGTH;
            }
            return i / SHORTEST_SIDE_LENGTH;
        }
        isNeedCompress = true;
        return 1.0f;
    }

    public static int decodeImageDegree(String str) {
        ExifInterface loadExifInterface;
        if (str == null || (loadExifInterface = loadExifInterface(str)) == null) {
            return 0;
        }
        switch (loadExifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)) {
            case 3:
                return 180;
            case 4:
            case 5:
            case 7:
            default:
                return 0;
            case 6:
                return 90;
            case 8:
                return 270;
        }
    }

    public static boolean saveBitmap(Bitmap bitmap, String str, int i) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(new File(str));
                try {
                    z = bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                    Closeables.closeSafely(fileOutputStream);
                } catch (FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    Closeables.closeSafely(fileOutputStream);
                    return z;
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream2 = fileOutputStream;
                Closeables.closeSafely(fileOutputStream2);
                throw th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely(fileOutputStream2);
            throw th;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void copyFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        int i = 0;
        InputStream inputStream = FileHelper.getInputStream(str);
        if (inputStream != null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            i += read;
                            System.out.println(i);
                            fileOutputStream.write(bArr, 0, read);
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    if (0 != 0) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                }
                if (0 != 0) {
                }
                throw th;
            }
        }
    }

    public static boolean copyJpegExif(String str, String str2) {
        try {
            ExifInterface loadExifInterface = loadExifInterface(str);
            ExifInterface loadExifInterface2 = loadExifInterface(str2);
            Field[] fields = ExifInterface.class.getFields();
            for (int i = 0; i < fields.length; i++) {
                String name = fields[i].getName();
                if (!TextUtils.isEmpty(name) && name.startsWith("TAG")) {
                    String obj = fields[i].get(ExifInterface.class).toString();
                    String attribute = loadExifInterface.getAttribute(obj);
                    if (!TextUtils.isEmpty(obj)) {
                        char c = 65535;
                        switch (obj.hashCode()) {
                            case -2093253645:
                                if (obj.equals(ExifInterface.TAG_PIXEL_Y_DIMENSION)) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case -1896740140:
                                if (obj.equals(ExifInterface.TAG_PIXEL_X_DIMENSION)) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case -666122239:
                                if (obj.equals(ExifInterface.TAG_IMAGE_LENGTH)) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 228367792:
                                if (obj.equals(ExifInterface.TAG_ORIENTATION)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 542970187:
                                if (obj.equals(ExifInterface.TAG_IMAGE_WIDTH)) {
                                    c = 1;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                break;
                            default:
                                if (attribute != null) {
                                    loadExifInterface2.setAttribute(obj, attribute);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
            }
            loadExifInterface2.saveAttributes();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static synchronized boolean compressImage(String str, String str2) {
        boolean z = false;
        synchronized (CompressImageUtil.class) {
            Bitmap loadBitmap = loadBitmap(str);
            if (loadBitmap != null) {
                if (saveBitmap(loadBitmap, str2, isNeedCompress ? sCompressValue : 100)) {
                    copyJpegExif(str, str2);
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [338=4] */
    public static ExifInterface loadExifInterface(String str) {
        InputStream inputStream;
        InputStream inputStream2;
        ExifInterface exifInterface;
        Context appContext = AppRuntime.getAppContext();
        Uri uri = UgcUriUtils.getUri(str);
        if (appContext == null || TextUtils.isEmpty(str) || uri == null) {
            return null;
        }
        if (!UgcUriUtils.isLocalContentUri(uri)) {
            if (UgcUriUtils.isLocalFileUri(uri)) {
                try {
                    return new ExifInterface(uri.getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        try {
            inputStream = appContext.getContentResolver().openInputStream(uri);
        } catch (Exception e2) {
            inputStream2 = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            exifInterface = new ExifInterface(inputStream);
            Closeables.closeSafely(inputStream);
        } catch (Exception e3) {
            inputStream2 = inputStream;
            Closeables.closeSafely(inputStream2);
            exifInterface = null;
            return exifInterface;
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely(inputStream);
            throw th;
        }
        return exifInterface;
    }

    public static void setCompressValue(int i) {
        if (i < 0 || i > 100) {
            sCompressValue = 40;
        } else {
            sCompressValue = i;
        }
    }
}
