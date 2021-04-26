package com.baidu.fsg.face.base.d;

import android.content.Context;
import android.os.Environment;
import com.baidu.fsg.base.ApollonConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f5804a = ApollonConstants.VIDEO_DEBUG;

    /* renamed from: b  reason: collision with root package name */
    public static final String f5805b = "SapiBioFileUtils";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5806c = "liveness_video.mp4";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5807d = "liveness_action_video.mp4";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5808e = "BI0_VIDEO";

    public static String a(Context context) {
        return context.getDir(f5808e, 0).getAbsolutePath();
    }

    public static String b(Context context) {
        String a2 = f5804a ? a() : a(context);
        return a2 + File.separator + f5806c;
    }

    public static String c(Context context) {
        String a2 = f5804a ? a() : a(context);
        return a2 + File.separator + f5807d;
    }

    public static String d(Context context) {
        return context.getDir(f5808e, 0).getAbsolutePath();
    }

    public static String a() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static boolean b(String str) {
        if (c(str)) {
            return false;
        }
        if (a(str)) {
            return a(new File(str));
        }
        return true;
    }

    public static boolean c(String str) {
        return str == null || "".equals(str);
    }

    public static String a(String str, String str2) {
        if (!str2.startsWith(".")) {
            str2 = "." + str2;
        }
        return str + str2;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean b(File file) throws IOException {
        if (file.exists()) {
            return true;
        }
        file.getParentFile().mkdirs();
        return file.createNewFile();
    }

    public static boolean a(File file) {
        try {
            return file.delete();
        } catch (Exception e2) {
            d.a(e2);
            return false;
        }
    }

    public static boolean a(File file, byte[] bArr) throws IOException {
        return a(file, bArr, true);
    }

    public static boolean a(File file, byte[] bArr, boolean z) throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            if (file.canWrite()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
                try {
                    fileOutputStream2.write(bArr);
                    fileOutputStream2.close();
                    return true;
                } catch (Throwable unused) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable unused2) {
        }
    }
}
