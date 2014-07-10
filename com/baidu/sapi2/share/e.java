package com.baidu.sapi2.share;

import android.content.Context;
import com.baidu.sapi2.utils.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;
/* loaded from: classes.dex */
final class e {
    private Context a;
    private JSONObject b;
    private File c;
    private boolean d = false;

    public e(Context context) {
        this.a = context;
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        File filesDir;
        File file;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        if (this.a.getFilesDir() != null) {
            File file2 = new File(filesDir.getAbsolutePath() + "/loginshare.json");
            this.c = new File(filesDir.getAbsolutePath() + "/android_sapi_loginshare");
            file = file2;
        } else {
            file = null;
        }
        if (file != null && file.exists() && this.c != null && this.c.exists()) {
            file.delete();
        } else if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        byte[] bArr = new byte[(int) file.length()];
                        fileInputStream.read(bArr);
                        this.b = new JSONObject(new String(bArr));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e) {
                            }
                        }
                    } catch (Exception e2) {
                        this.b = new JSONObject();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        a();
                        file.delete();
                        if (this.c == null) {
                        }
                        this.b = new JSONObject();
                    }
                } catch (Throwable th) {
                    fileInputStream3 = fileInputStream;
                    th = th;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream3 != null) {
                }
                throw th;
            }
            a();
            file.delete();
        }
        if (this.c == null && this.c.exists()) {
            try {
                try {
                    fileInputStream2 = new FileInputStream(this.c);
                } catch (Exception e6) {
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                byte[] bArr2 = new byte[(int) this.c.length()];
                fileInputStream2.read(bArr2);
                this.b = new JSONObject(a.b(this.a, new String(bArr2)));
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                        return;
                    } catch (Exception e7) {
                        return;
                    }
                }
                return;
            } catch (Exception e8) {
                fileInputStream3 = fileInputStream2;
                this.b = new JSONObject();
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                        return;
                    } catch (Exception e9) {
                        return;
                    }
                }
                return;
            } catch (Throwable th4) {
                fileInputStream3 = fileInputStream2;
                th = th4;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                    } catch (Exception e10) {
                    }
                }
                throw th;
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
                        fileWriter.write(a.a(this.a, this.b.toString()));
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
