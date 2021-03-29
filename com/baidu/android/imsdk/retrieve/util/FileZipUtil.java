package com.baidu.android.imsdk.retrieve.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes.dex */
public class FileZipUtil {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x009a -> B:69:0x009d). Please submit an issue!!! */
    public static void zip(File file, List<ZipSrc> list) throws IOException {
        ZipOutputStream zipOutputStream;
        if (file == null || !file.exists() || list == null || list.size() == 0) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                byte[] bArr = new byte[4096];
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
                try {
                    try {
                        zipOutputStream.setComment(file.getName());
                        for (ZipSrc zipSrc : list) {
                            File file2 = zipSrc.mFile;
                            if (file2.canRead() && file2.isFile()) {
                                FileInputStream fileInputStream2 = new FileInputStream(file2);
                                try {
                                    zipOutputStream.putNextEntry(new ZipEntry(zipSrc.mOutName));
                                    while (true) {
                                        int read = fileInputStream2.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        zipOutputStream.write(bArr, 0, read);
                                    }
                                    fileInputStream2.close();
                                    fileInputStream = fileInputStream2;
                                } catch (FileNotFoundException e2) {
                                    e = e2;
                                    fileInputStream = fileInputStream2;
                                    e.printStackTrace();
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    if (zipOutputStream != null) {
                                        zipOutputStream.close();
                                    }
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (zipOutputStream != null) {
                                        try {
                                            zipOutputStream.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                        zipOutputStream.flush();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        zipOutputStream.close();
                    } catch (FileNotFoundException e7) {
                        e = e7;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        } catch (FileNotFoundException e9) {
            e = e9;
            zipOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
    }

    /* loaded from: classes.dex */
    public static final class ZipSrc {
        public boolean mDelete;
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

        public ZipSrc(@NonNull File file, @NonNull String str, boolean z) {
            this.mFile = file;
            if (TextUtils.isEmpty(str)) {
                this.mOutName = this.mFile.getName();
            } else {
                this.mOutName = str;
            }
            this.mDelete = z;
        }

        public ZipSrc(@NonNull File file) {
            this.mFile = file;
            this.mOutName = file.getName();
        }
    }
}
