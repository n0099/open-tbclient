package com.baidu.ar.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes3.dex */
public final class AssetsUtil {
    private AssetsUtil() {
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    public static boolean copyAssetFile(Context context, String str, File file) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                IoUtils.copyStream(inputStream, file);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                IoUtils.closeQuietly(inputStream);
                return false;
            }
        } finally {
            IoUtils.closeQuietly(inputStream);
        }
    }

    public static String getFileHeader(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        String str2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                try {
                    byte[] bArr = new byte[4];
                    fileInputStream.read(bArr, 0, bArr.length);
                    str2 = a(bArr).toUpperCase();
                    IoUtils.closeQuietly(fileInputStream);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    IoUtils.closeQuietly(fileInputStream);
                    return str2;
                }
            } catch (Throwable th2) {
                th = th2;
                IoUtils.closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            IoUtils.closeQuietly(fileInputStream);
            throw th;
        }
        return str2;
    }

    public static String getFromAssets(Context context, String str) {
        String str2 = "";
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            str2 = IoUtils.loadContent(inputStream);
        } catch (Exception e) {
        } finally {
            IoUtils.closeQuietly(inputStream);
        }
        return str2;
    }

    public static Bitmap getImageFromAssets(Context context, String str) {
        InputStream inputStream;
        Throwable th;
        Bitmap bitmap = null;
        try {
            inputStream = context.getAssets().open(str);
        } catch (IOException e) {
            inputStream = null;
        } catch (Throwable th2) {
            inputStream = null;
            th = th2;
        }
        try {
            bitmap = BitmapFactory.decodeStream(inputStream);
            IoUtils.closeQuietly(inputStream);
        } catch (IOException e2) {
            IoUtils.closeQuietly(inputStream);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            IoUtils.closeQuietly(inputStream);
            throw th;
        }
        return bitmap;
    }

    public static boolean isImage(String str) {
        String fileHeader = getFileHeader(str);
        return fileHeader != null && (fileHeader.contains("FFD8FF") || fileHeader.contains("89504E47") || fileHeader.contains("47494638") || fileHeader.contains("49492A00") || fileHeader.contains("424D"));
    }

    public static byte[] readBitmap(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeFile.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        decodeFile.recycle();
        return byteArrayOutputStream.toByteArray();
    }
}
