package com.baidu.helios.common.c;

import android.content.Context;
import com.baidu.helios.common.a.b;
import com.baidu.helios.common.b.a.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private C0143a asb;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        uJ().mkdirs();
    }

    public File uI() {
        return new File(this.mContext.getApplicationInfo().dataDir);
    }

    private File uJ() {
        return new File(uI(), ".helios");
    }

    public synchronized C0143a uK() {
        if (this.asb == null) {
            this.asb = new C0143a(".helios", null);
        }
        return this.asb;
    }

    public static void j(File file) {
        file.mkdirs();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=4] */
    public static boolean b(File file, String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        j(file);
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
                fileOutputStream.write(new b().z(str2.getBytes()));
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
        j(file);
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
            String str3 = new String(z ? new b().A(byteArray) : byteArray, str2);
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
    /* loaded from: classes6.dex */
    public final class C0143a {
        private File asc;
        private String asd;
        private C0143a ase;
        private boolean asf;

        C0143a(String str, C0143a c0143a) {
            this.asf = false;
            this.asd = str;
            this.ase = c0143a;
            this.asf = false;
        }

        C0143a(File file) {
            this.asf = false;
            this.asf = true;
            this.asc = file;
            this.asd = file.getName();
        }

        public void uL() {
            uM().mkdirs();
        }

        public File uM() {
            File file = this.asc;
            if (file == null) {
                if (this.ase == null) {
                    file = new File(a.this.uI(), this.asd);
                } else {
                    file = new File(this.ase.uM(), this.asd);
                }
                this.asc = file;
            }
            return file;
        }

        public String uN() {
            return this.asd;
        }

        public C0143a ed(String str) {
            return new C0143a(str, this);
        }

        public File getFile(String str) {
            return new File(this.asc, str);
        }

        public C0143a uO() {
            return this.ase;
        }

        public boolean d(String str, String str2, boolean z) {
            return a.b(uM(), str, str2, "UTF-8", z);
        }

        public String q(String str, boolean z) {
            return a.b(uM(), str, "UTF-8", z);
        }

        public C0143a k(File file) {
            if (this.asf) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0143a c0143a = this;
            do {
                arrayList.add(c0143a.uN());
                c0143a = c0143a.uO();
            } while (c0143a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return new C0143a(file);
        }
    }
}
