package com.baidu.searchbox.aperf.bosuploader;

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
/* loaded from: classes6.dex */
public class ZipUtils {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [67=4] */
    public static void zip(File file, List<ZipSrc> list) throws IOException {
        ZipOutputStream zipOutputStream;
        byte[] bArr;
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        ZipOutputStream zipOutputStream2 = null;
        if (file == null || !file.exists() || list == null || list.size() == 0) {
            return;
        }
        try {
            bArr = new byte[4096];
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream = null;
        }
        try {
            zipOutputStream.setComment(file.getName());
            FileInputStream fileInputStream3 = null;
            for (ZipSrc zipSrc : list) {
                File file2 = zipSrc.mFile;
                try {
                    if (file2.canRead()) {
                        fileInputStream = new FileInputStream(file2);
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(zipSrc.mOutName));
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            fileInputStream2 = fileInputStream;
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            fileInputStream2 = fileInputStream;
                            try {
                                e.printStackTrace();
                                Closeables.closeSafely(fileInputStream2);
                                fileInputStream3 = fileInputStream2;
                            } catch (Throwable th3) {
                                th = th3;
                                fileInputStream = fileInputStream2;
                                Closeables.closeSafely(fileInputStream);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            Closeables.closeSafely(fileInputStream);
                            throw th;
                        }
                    } else {
                        fileInputStream2 = fileInputStream3;
                    }
                    Closeables.closeSafely(fileInputStream2);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream3;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream3;
                }
                fileInputStream3 = fileInputStream2;
            }
            zipOutputStream.flush();
            Closeables.closeSafely(zipOutputStream);
        } catch (FileNotFoundException e4) {
            zipOutputStream2 = zipOutputStream;
            Closeables.closeSafely(zipOutputStream2);
        } catch (Throwable th6) {
            th = th6;
            Closeables.closeSafely(zipOutputStream);
            throw th;
        }
    }

    /* loaded from: classes6.dex */
    public static final class ZipSrc {
        @NonNull
        public File mFile;
        @NonNull
        public String mOutName;

        public ZipSrc(@NonNull File file, @NonNull String str) {
            this.mFile = file;
            if (TextUtils.isEmpty(str)) {
                this.mOutName = this.mFile.getName();
            } else {
                this.mOutName = str;
            }
        }

        public ZipSrc(@NonNull File file) {
            this.mFile = file;
            this.mOutName = this.mFile.getName();
        }
    }
}
