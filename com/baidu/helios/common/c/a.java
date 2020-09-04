package com.baidu.helios.common.c;

import android.content.Context;
import com.baidu.helios.common.a.b;
import com.baidu.helios.common.b.a.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private C0148a awW;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        Ag().mkdirs();
    }

    public File Af() {
        return new File(this.mContext.getApplicationInfo().dataDir);
    }

    private File Ag() {
        return new File(Af(), ".helios");
    }

    public synchronized C0148a Ah() {
        if (this.awW == null) {
            this.awW = new C0148a(".helios", null);
        }
        return this.awW;
    }

    public static void k(File file) {
        file.mkdirs();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=4] */
    public static boolean b(File file, String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        k(file);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(new File(file, str));
        } catch (Exception e) {
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
        }
        try {
            if (z) {
                fileOutputStream.write(new b().A(str2.getBytes()));
            } else {
                fileOutputStream.write(str2.getBytes(str3));
            }
            c.b(fileOutputStream);
            return true;
        } catch (Exception e2) {
            fileOutputStream2 = fileOutputStream;
            c.b(fileOutputStream2);
            return false;
        } catch (Throwable th3) {
            th = th3;
            c.b(fileOutputStream);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [131=4] */
    public static String b(File file, String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        k(file);
        File file2 = new File(file, str);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Exception e) {
                fileInputStream2 = null;
                byteArrayOutputStream2 = byteArrayOutputStream;
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
            }
        } catch (Exception e2) {
            fileInputStream2 = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            byteArrayOutputStream = null;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String str3 = new String(z ? new b().B(byteArray) : byteArray, str2);
            c.b(fileInputStream);
            c.b(byteArrayOutputStream);
            return str3;
        } catch (Exception e3) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            fileInputStream2 = fileInputStream;
            c.b(fileInputStream2);
            c.b(byteArrayOutputStream2);
            return "";
        } catch (Throwable th4) {
            th = th4;
            c.b(fileInputStream);
            c.b(byteArrayOutputStream);
            throw th;
        }
    }

    /* renamed from: com.baidu.helios.common.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public final class C0148a {
        private File awX;
        private String awY;
        private C0148a awZ;
        private boolean axa;

        C0148a(String str, C0148a c0148a) {
            this.axa = false;
            this.awY = str;
            this.awZ = c0148a;
            this.axa = false;
        }

        C0148a(File file) {
            this.axa = false;
            this.axa = true;
            this.awX = file;
            this.awY = file.getName();
        }

        public void Ai() {
            Aj().mkdirs();
        }

        public File Aj() {
            File file = this.awX;
            if (file == null) {
                if (this.awZ == null) {
                    file = new File(a.this.Af(), this.awY);
                } else {
                    file = new File(this.awZ.Aj(), this.awY);
                }
                this.awX = file;
            }
            return file;
        }

        public String Ak() {
            return this.awY;
        }

        public C0148a fw(String str) {
            return new C0148a(str, this);
        }

        public File getFile(String str) {
            return new File(this.awX, str);
        }

        public C0148a Al() {
            return this.awZ;
        }

        public boolean d(String str, String str2, boolean z) {
            return a.b(Aj(), str, str2, "UTF-8", z);
        }

        public String q(String str, boolean z) {
            return a.b(Aj(), str, "UTF-8", z);
        }

        public C0148a l(File file) {
            if (this.axa) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0148a c0148a = this;
            do {
                arrayList.add(c0148a.Ak());
                c0148a = c0148a.Al();
            } while (c0148a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return new C0148a(file);
        }
    }
}
