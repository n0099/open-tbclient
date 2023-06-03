package com.baidu.searchbox.logsystem.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.util.io.Closeables;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes4.dex */
public class ZipUtils {

    /* loaded from: classes4.dex */
    public static final class ZipSrc {
        @NonNull
        public File mFile;
        @NonNull
        public String mOutName;

        public ZipSrc(@NonNull File file) {
            this.mFile = file;
            this.mOutName = file.getName();
        }

        public ZipSrc(@NonNull File file, @NonNull String str) {
            this.mFile = file;
            if (TextUtils.isEmpty(str)) {
                this.mOutName = this.mFile.getName();
            } else {
                this.mOutName = str;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.FileInputStream, java.io.InputStream] */
    public static void zip(File file, List<ZipSrc> list) throws IOException {
        byte[] bArr;
        ZipOutputStream zipOutputStream;
        if (file != null && file.exists() && list != null && list.size() != 0) {
            ZipOutputStream zipOutputStream2 = null;
            try {
                try {
                    bArr = new byte[4096];
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            }
            try {
                zipOutputStream.setComment(file.getName());
                for (ZipSrc zipSrc : list) {
                    File file2 = zipSrc.mFile;
                    try {
                        try {
                            if (file2.canRead()) {
                                ?? fileInputStream = new FileInputStream(file2);
                                try {
                                    zipOutputStream.putNextEntry(new ZipEntry(zipSrc.mOutName));
                                    while (true) {
                                        int read = fileInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        zipOutputStream.write(bArr, 0, read);
                                    }
                                    zipOutputStream2 = fileInputStream;
                                } catch (FileNotFoundException e2) {
                                    e = e2;
                                    zipOutputStream2 = fileInputStream;
                                    e.printStackTrace();
                                    Closeables.closeSafely(zipOutputStream2);
                                } catch (Throwable th2) {
                                    th = th2;
                                    zipOutputStream2 = fileInputStream;
                                    Closeables.closeSafely(zipOutputStream2);
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (FileNotFoundException e3) {
                        e = e3;
                    }
                    Closeables.closeSafely(zipOutputStream2);
                }
                zipOutputStream.flush();
                Closeables.closeSafely(zipOutputStream);
            } catch (FileNotFoundException e4) {
                e = e4;
                zipOutputStream2 = zipOutputStream;
                if (LLog.sDebug) {
                    e.printStackTrace();
                }
                Closeables.closeSafely(zipOutputStream2);
            } catch (Throwable th4) {
                th = th4;
                zipOutputStream2 = zipOutputStream;
                Closeables.closeSafely(zipOutputStream2);
                throw th;
            }
        }
    }
}
