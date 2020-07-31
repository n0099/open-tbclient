package com.baidu.browser.sailor.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.Base64;
import com.baidu.webkit.sdk.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes8.dex */
public final class d {
    private static int a(BitmapFactory.Options options, int i) {
        int i2 = 1;
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(options.outWidth / i), Math.floor(options.outHeight / i));
        if (min <= 0) {
            min = 1;
        } else if (i == -1) {
            min = 1;
        } else if (i == -1) {
            min = 1;
        }
        if (min <= 8) {
            while (i2 < min) {
                i2 <<= 1;
            }
            return i2;
        }
        return ((min + 7) / 8) * 8;
    }

    private static int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            switch (new ExifInterface(str).getAttributeInt(android.support.media.ExifInterface.TAG_ORIENTATION, 1)) {
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
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap a(String str, int i) {
        File file = new File(str);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = b(fileInputStream, i);
            fileInputStream.close();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream2, null, options);
            int a = a(str);
            if (decodeStream == null || !(a == 90 || a == 270)) {
                fileInputStream2.close();
            } else {
                Matrix matrix = new Matrix();
                matrix.setRotate(a, decodeStream.getWidth() / 2.0f, decodeStream.getHeight() / 2.0f);
                Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, true);
                decodeStream.recycle();
                decodeStream = createBitmap;
            }
            return decodeStream;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static boolean a(Bitmap bitmap, String str, int i) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        if (b.a()) {
            try {
                File file = new File(str);
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        z = bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                        Log.w("ImageUtils", String.format("compress jpg file:%b->%s", Boolean.valueOf(z), file.toString()));
                        b.a(fileOutputStream);
                    } catch (FileNotFoundException e) {
                        Log.w("ImageUtils", "FileNotFoundException");
                        b.a(fileOutputStream);
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    b.a(fileOutputStream);
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                b.a(fileOutputStream);
                throw th;
            }
        }
        return z;
    }

    private static int b(InputStream inputStream, int i) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStream, null, options);
            if (options.outHeight <= 0 || options.outWidth <= 0) {
                return 1;
            }
            return a(options, i);
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    public static String b(Bitmap bitmap, int i) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        String str = null;
        if (bitmap != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    str = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                    try {
                        byteArrayOutputStream.flush();
                        b.a(byteArrayOutputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e2) {
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.flush();
                            b.a(byteArrayOutputStream);
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.flush();
                            b.a(byteArrayOutputStream);
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                byteArrayOutputStream = null;
                th = th3;
            }
        }
        return str;
    }
}
