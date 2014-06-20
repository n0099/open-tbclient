package com.baidu.android.nebula.b;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class m {
    public static final String a = m.class.getSimpleName();
    protected Context c;
    protected boolean e;
    protected t b = null;
    protected int d = 6259;
    private int f = 0;

    public m(Context context) {
        this.c = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00a5 A[Catch: IOException -> 0x00a9, TRY_LEAVE, TryCatch #0 {IOException -> 0x00a9, blocks: (B:51:0x00a0, B:53:0x00a5), top: B:67:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(Context context, String str, String str2) {
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream = null;
        boolean z = false;
        File file = new File(str);
        if ((file.exists() || file.mkdirs()) && file.canWrite()) {
            String str3 = str + File.separator + str2;
            OutputStream outputStream = null;
            try {
                inputStream = m.class.getResourceAsStream(str2);
                if (inputStream == null) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (0 != 0) {
                        outputStream.close();
                    }
                } else {
                    try {
                        File file2 = new File(str3);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            }
                            inputStream.close();
                            fileOutputStream2.close();
                            z = true;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileOutputStream = fileOutputStream2;
                            inputStream2 = inputStream;
                            try {
                                e.printStackTrace();
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                return z;
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            if (inputStream != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e = e6;
                        inputStream2 = inputStream;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (Exception e7) {
                e = e7;
                inputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
        }
        return z;
    }

    private boolean a(File file) {
        this.b = new t("0.0.0.0", this.d, file, this.c);
        try {
            this.b.a();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            if (this.f >= com.baidu.android.a.b.a(this.c).a().size()) {
                this.e = false;
                return false;
            }
            this.d = ((Integer) com.baidu.android.a.b.a(this.c).a().get(this.f)).intValue();
            this.f++;
            return a(file);
        }
    }

    public boolean a() {
        boolean mkdir;
        if (this.e) {
            return true;
        }
        this.e = true;
        this.d = 6259;
        File file = new File(this.c.getFilesDir(), "local_http_server");
        if (file.exists() || (mkdir = file.mkdir())) {
            a(this.c, file.getAbsolutePath(), "crossdomain.xml");
            return a(file);
        }
        Log.d(a, "----------root.mkdir() = " + mkdir);
        this.e = false;
        return false;
    }

    public void b() {
        try {
            if (this.b != null) {
                this.b.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean c() {
        return this.b != null && this.b.e();
    }
}
