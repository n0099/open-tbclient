package com.baidu.android.nebula.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public final class n {
    private n() {
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00cd A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, String str3) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        fileOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        File file = new File(str2);
        if ((file.exists() || file.mkdirs()) && file.canWrite()) {
            int lastIndexOf = str3.lastIndexOf(".");
            String substring = str3.substring(0, lastIndexOf);
            String substring2 = str3.substring(lastIndexOf + 1, str3.length());
            String str4 = str2 + File.separator + substring + "." + substring2;
            String str5 = str4;
            File file2 = new File(str4);
            int i = 0;
            while (file2.exists()) {
                i++;
                str5 = str2 + File.separator + substring + "_" + i + "." + substring2;
                file2 = new File(str5);
            }
            try {
                if (new File(str).exists()) {
                    fileInputStream = new FileInputStream(str);
                    try {
                        fileOutputStream = new FileOutputStream(str5);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            z = true;
                        } catch (Exception e) {
                            e = e;
                            fileInputStream2 = fileInputStream;
                            try {
                                e.printStackTrace();
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (z) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                fileOutputStream2 = fileOutputStream;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            if (fileInputStream != null) {
                            }
                            if (fileOutputStream2 != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        fileOutputStream = null;
                        fileInputStream2 = fileInputStream;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    fileOutputStream = null;
                    fileInputStream = null;
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
            } catch (Exception e9) {
                e = e9;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
            }
            return z ? "" : str5;
        }
        return "";
    }
}
