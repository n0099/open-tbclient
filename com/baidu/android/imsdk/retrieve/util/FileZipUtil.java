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
/* loaded from: classes4.dex */
public class FileZipUtil {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [62=4] */
    public static void zip(File file, List<ZipSrc> list) throws IOException {
        ZipOutputStream zipOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        if (file == null || !file.exists() || list == null || list.size() == 0) {
            return;
        }
        try {
            byte[] bArr = new byte[4096];
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            try {
                zipOutputStream.setComment(file.getName());
                fileInputStream = null;
                for (ZipSrc zipSrc : list) {
                    try {
                        try {
                            File file2 = zipSrc.mFile;
                            if (file2.canRead() && file2.isFile()) {
                                FileInputStream fileInputStream3 = new FileInputStream(file2);
                                try {
                                    zipOutputStream.putNextEntry(new ZipEntry(zipSrc.mOutName));
                                    while (true) {
                                        int read = fileInputStream3.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        zipOutputStream.write(bArr, 0, read);
                                    }
                                    fileInputStream3.close();
                                    fileInputStream2 = fileInputStream3;
                                } catch (FileNotFoundException e) {
                                    e = e;
                                    fileInputStream = fileInputStream3;
                                    e.printStackTrace();
                                    if (fileInputStream != null) {
                                        try {
                                            fileInputStream.close();
                                        } catch (IOException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    if (zipOutputStream != null) {
                                        try {
                                            zipOutputStream.close();
                                            return;
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                            return;
                                        }
                                    }
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    fileInputStream = fileInputStream3;
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
                            } else {
                                fileInputStream2 = fileInputStream;
                            }
                            fileInputStream = fileInputStream2;
                        } catch (FileNotFoundException e6) {
                            e = e6;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                zipOutputStream.flush();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                if (zipOutputStream != null) {
                    try {
                        zipOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
            } catch (FileNotFoundException e9) {
                e = e9;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
        } catch (FileNotFoundException e10) {
            e = e10;
            zipOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            zipOutputStream = null;
            fileInputStream = null;
        }
    }

    /* loaded from: classes4.dex */
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
            this.mOutName = this.mFile.getName();
        }
    }
}
