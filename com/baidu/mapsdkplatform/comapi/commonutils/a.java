package com.baidu.mapsdkplatform.comapi.commonutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes20.dex */
public class a {
    private static final boolean a;

    static {
        a = Build.VERSION.SDK_INT >= 8;
    }

    public static Bitmap a(String str, Context context) {
        try {
            InputStream open = context.getAssets().open(str);
            if (open != null) {
                return BitmapFactory.decodeStream(open);
            }
            return null;
        } catch (Exception e) {
            return BitmapFactory.decodeFile(a("assets/" + str, str, context));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(String str, String str2, Context context) {
        ZipFile zipFile;
        File file;
        File file2;
        ZipEntry entry;
        ZipFile zipFile2 = null;
        StringBuilder sb = new StringBuilder(context.getFilesDir().getAbsolutePath());
        try {
            zipFile = new ZipFile(a ? context.getPackageCodePath() : "");
        } catch (Exception e) {
            e = e;
        } catch (Throwable th) {
            th = th;
            zipFile = null;
        }
        try {
            int lastIndexOf = str2.lastIndexOf("/");
            if (lastIndexOf > 0) {
                file = new File(context.getFilesDir().getAbsolutePath());
                file2 = new File(file.getAbsolutePath() + "/" + str2.substring(0, lastIndexOf), str2.substring(lastIndexOf + 1, str2.length()));
            } else {
                file = new File(context.getFilesDir(), "assets");
                file2 = new File(file.getAbsolutePath(), str2);
            }
            file.mkdirs();
            entry = zipFile.getEntry(str);
        } catch (Exception e2) {
            e = e2;
            zipFile2 = zipFile;
            try {
                Log.e(a.class.getSimpleName(), "copyAssetsError", e);
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException e3) {
                    }
                }
                return sb.toString();
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (zipFile != null) {
            }
            throw th;
        }
        if (entry == null) {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e5) {
                }
            }
            return null;
        }
        a(zipFile.getInputStream(entry), new FileOutputStream(file2));
        sb.append("/").append(str);
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e6) {
            }
        }
        return sb.toString();
    }

    private static void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                }
            }
        }
        fileOutputStream.flush();
    }
}
