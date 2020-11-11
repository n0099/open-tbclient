package com.baidu.a.a;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes17.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f987a;

    public a(File file) {
        this.f987a = null;
        this.f987a = file.getAbsolutePath();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0082 A[Catch: Exception -> 0x0086, TRY_LEAVE, TryCatch #5 {Exception -> 0x0086, blocks: (B:41:0x007d, B:43:0x0082), top: B:63:0x007d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b() {
        ZipInputStream zipInputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = true;
        if (TextUtils.isEmpty(this.f987a)) {
            return false;
        }
        File file = new File(this.f987a);
        new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            if (zipInputStream != null) {
                                try {
                                    zipInputStream.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return z;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                        } else if (!nextEntry.isDirectory() && nextEntry.getName().contains("../")) {
                            if (zipInputStream != null) {
                                try {
                                    zipInputStream.close();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    return false;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                                return false;
                            }
                            return false;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileInputStream2 = fileInputStream;
                        try {
                            e.printStackTrace();
                            if (zipInputStream != null) {
                                try {
                                    zipInputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    z = false;
                                    return z;
                                }
                            }
                            if (fileInputStream2 != null) {
                                fileInputStream2.close();
                            }
                            z = false;
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (zipInputStream != null) {
                                try {
                                    zipInputStream.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (zipInputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                zipInputStream = null;
                fileInputStream2 = fileInputStream;
            } catch (Throwable th3) {
                th = th3;
                zipInputStream = null;
            }
        } catch (Exception e7) {
            e = e7;
            zipInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            zipInputStream = null;
            fileInputStream = null;
        }
    }

    public boolean a() {
        return b();
    }
}
