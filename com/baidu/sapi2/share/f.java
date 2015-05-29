package com.baidu.sapi2.share;

import android.content.Context;
import com.baidu.sapi2.utils.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class f {
    private Context a;
    private JSONObject b;
    private File c;
    private boolean d = false;

    public f(Context context) {
        this.a = context;
        b();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00dc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:42:0x00e5 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x00f3 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x0119 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:77:0x00a4 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:80:0x0071 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        File filesDir;
        File file;
        Throwable th;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = 0;
        if (this.a.getFilesDir() != null) {
            File file2 = new File(filesDir.getAbsolutePath() + "/loginshare.json");
            this.c = new File(filesDir.getAbsolutePath() + "/android_sapi_loginshare");
            file = file2;
        } else {
            file = null;
        }
        if (file != null && file.exists() && this.c != null && this.c.exists()) {
            file.delete();
        } else if (file != null) {
            ?? e = file.exists();
            try {
                if (e != 0) {
                    try {
                        e = new FileInputStream(file);
                        try {
                            byte[] bArr = new byte[(int) file.length()];
                            e.read(bArr);
                            this.b = new JSONObject(new String(bArr));
                            if (e != 0) {
                                try {
                                    e.close();
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            }
                        } catch (Exception e3) {
                            this.b = new JSONObject();
                            if (e != 0) {
                                try {
                                    e.close();
                                } catch (Exception e4) {
                                    e = e4;
                                }
                            }
                            a();
                            file.delete();
                            if (this.c != null) {
                            }
                            this.b = new JSONObject();
                        }
                    } catch (Exception e5) {
                        e = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw th;
                    }
                    a();
                    file.delete();
                }
            } catch (Throwable th3) {
                fileInputStream2 = e;
                th = th3;
            }
        }
        if (this.c != null) {
            try {
                if (this.c.exists()) {
                    try {
                        fileInputStream = new FileInputStream(this.c);
                    } catch (Exception e7) {
                    }
                    try {
                        byte[] bArr2 = new byte[(int) this.c.length()];
                        fileInputStream.read(bArr2);
                        fileInputStream2 = e.b(this.a, new String(bArr2));
                        this.b = new JSONObject((String) fileInputStream2);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e8) {
                            }
                        }
                    } catch (Exception e9) {
                        fileInputStream2 = fileInputStream;
                        this.b = new JSONObject();
                        if (fileInputStream2 != 0) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e10) {
                            }
                        }
                        return;
                    } catch (Throwable th4) {
                        fileInputStream2 = fileInputStream;
                        th = th4;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e11) {
                            }
                        }
                        throw th;
                    }
                    return;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        this.b = new JSONObject();
    }

    public String a(String str) {
        return this.b.optString(str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x002a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0044 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0046 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0008 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.io.FileWriter */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.io.FileWriter */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.io.FileWriter */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: java.io.FileWriter */
    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.io.FileWriter */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.FileWriter] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a() {
        boolean z = true;
        FileWriter fileWriter = this.d;
        if (fileWriter != 0) {
            try {
                try {
                    fileWriter = new FileWriter(this.c);
                    try {
                        fileWriter.write(e.a(this.a, this.b.toString()));
                        fileWriter.flush();
                        this.d = false;
                        if (fileWriter != 0) {
                            try {
                                fileWriter.close();
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        L.e(e);
                        if (fileWriter != 0) {
                            try {
                                fileWriter.close();
                            } catch (Exception e3) {
                            }
                        }
                        z = false;
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileWriter != 0) {
                        try {
                            fileWriter.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                fileWriter = 0;
            } catch (Throwable th2) {
                th = th2;
                fileWriter = 0;
                if (fileWriter != 0) {
                }
                throw th;
            }
        }
        return z;
    }
}
