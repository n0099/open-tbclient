package com.baidu.searchbox.download.lightdownload;

import android.text.TextUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.CRC32;
import org.apache.commons.codec.digest4util.MD5Utils;
/* loaded from: classes3.dex */
public class LightFileUtils {
    public static final String DIRCTORY_DOWNLOAD = "downloads";
    public static final String DIRCTORY_DOWNLOAD_RESOURCE = "resource";

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0027 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:22:0x000a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public static long checkCrcFile(File file) {
        byte[] bArr = new byte[65536];
        CRC32 crc32 = new CRC32();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        fileInputStream = -1;
                        if (read == -1) {
                            break;
                        }
                        crc32.update(bArr, 0, read);
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        Closeables.closeSafely(fileInputStream);
                        fileInputStream = fileInputStream;
                        return crc32.getValue();
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        Closeables.closeSafely(fileInputStream);
                        throw th;
                    }
                }
                Closeables.closeSafely(fileInputStream2);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return crc32.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getDownloadResDirectory() {
        File file = new File(AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "downloads" + File.separator + DIRCTORY_DOWNLOAD_RESOURCE);
        boolean z = false;
        if (file.exists()) {
            if (!file.isDirectory()) {
                FileUtils.deleteFile(file);
            }
            if (z) {
                file.mkdirs();
            }
            return file.getPath();
        }
        z = true;
        if (z) {
        }
        return file.getPath();
    }

    public static String getFilePathByUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str3 = getDownloadResDirectory() + File.separator + MD5Utils.toMd5(str.getBytes(), false);
        if (!TextUtils.isEmpty(str2)) {
            return str3 + "." + str2;
        }
        return str3;
    }

    public static String getFilePathByUrlSafely(String str, String str2) {
        String filePathByUrl = getFilePathByUrl(str, str2);
        if (filePathByUrl != null) {
            File file = new File(filePathByUrl);
            if (TextUtils.equals(String.valueOf(checkCrcFile(file)), LightFileCache.getInstance().getChecksumByUrl(str))) {
                return filePathByUrl;
            }
        }
        return null;
    }
}
