package com.baidu.pass.biometrics.base.utils;

import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public class PassBioFileUtils {
    public static final String TAG = "PassBioFileUtils";

    public static boolean checkAndCreadFile(File file) throws IOException {
        if (file.exists()) {
            return true;
        }
        file.getParentFile().mkdirs();
        return file.createNewFile();
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (isFileExist(str)) {
            return deleteFile(new File(str));
        }
        return true;
    }

    public static boolean isFileExist(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean write(File file, byte[] bArr) throws IOException {
        return write(file, bArr, true);
    }

    public static boolean write(File file, byte[] bArr, boolean z) throws IOException {
        FileOutputStream fileOutputStream;
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            if (file.canWrite()) {
                fileOutputStream = new FileOutputStream(file, z);
                try {
                    fileOutputStream.write(bArr);
                    fileOutputStream.close();
                    return true;
                } catch (Throwable unused) {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return false;
                }
            }
            return false;
        } catch (Throwable unused2) {
            fileOutputStream = null;
        }
    }

    public static boolean deleteFile(File file) {
        try {
            return file.delete();
        } catch (Exception e2) {
            Log.e(e2);
            return false;
        }
    }
}
