package com.baidu.a.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.retrieve.Constants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f1130a;

    public a(File file) {
        this.f1130a = null;
        this.f1130a = file.getAbsolutePath();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0083 A[Catch: Exception -> 0x0087, TRY_LEAVE, TryCatch #2 {Exception -> 0x0087, blocks: (B:41:0x007e, B:43:0x0083), top: B:59:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x007e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b() {
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        boolean z = true;
        if (TextUtils.isEmpty(this.f1130a)) {
            return false;
        }
        File file = new File(this.f1130a);
        new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            zipInputStream = null;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            zipInputStream = null;
            fileInputStream = null;
        }
        try {
            zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
            while (true) {
                try {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            if (zipInputStream != null) {
                                try {
                                    zipInputStream.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return z;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } else if (!nextEntry.isDirectory() && nextEntry.getName().contains(Constants.PATH_PARENT)) {
                            if (zipInputStream != null) {
                                try {
                                    zipInputStream.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                    return false;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return false;
                            }
                            return false;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        if (zipInputStream != null) {
                            try {
                                zipInputStream.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                                z = false;
                                return z;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        z = false;
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (Exception e6) {
                            e6.printStackTrace();
                            throw th;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            }
        } catch (Exception e7) {
            e = e7;
            zipInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipInputStream = null;
            if (zipInputStream != null) {
            }
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public boolean a() {
        return b();
    }
}
