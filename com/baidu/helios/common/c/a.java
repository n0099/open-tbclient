package com.baidu.helios.common.c;

import android.content.Context;
import com.baidu.helios.common.a.b;
import com.baidu.helios.common.b.a.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private C0133a atc;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        vj().mkdirs();
    }

    public File vi() {
        return new File(this.mContext.getApplicationInfo().dataDir);
    }

    private File vj() {
        return new File(vi(), ".helios");
    }

    public synchronized C0133a vk() {
        if (this.atc == null) {
            this.atc = new C0133a(".helios", null);
        }
        return this.atc;
    }

    public static void k(File file) {
        file.mkdirs();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=4] */
    public static boolean b(File file, String str, String str2, String str3, boolean z) {
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        k(file);
        FileOutputStream fileOutputStream3 = null;
        try {
            fileOutputStream2 = new FileOutputStream(new File(file, str));
        } catch (Exception e) {
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            if (z) {
                fileOutputStream2.write(new b().w(str2.getBytes(str3)));
            } else {
                fileOutputStream2.write(str2.getBytes(str3));
            }
            c.c(fileOutputStream2);
            return true;
        } catch (Exception e2) {
            fileOutputStream3 = fileOutputStream2;
            c.c(fileOutputStream3);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = fileOutputStream2;
            c.c(fileOutputStream);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [131=4] */
    public static String b(File file, String str, String str2, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        k(file);
        File file2 = new File(file, str);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
            } catch (Exception e) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
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
                String str3 = new String(z ? new b().x(byteArray) : byteArray, str2);
                c.c(fileInputStream);
                c.c(byteArrayOutputStream);
                return str3;
            } catch (Exception e2) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                c.c(fileInputStream);
                c.c(byteArrayOutputStream2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                c.c(fileInputStream);
                c.c(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            byteArrayOutputStream2 = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
    }

    /* renamed from: com.baidu.helios.common.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public final class C0133a {
        private File atd;
        private String ate;
        private C0133a atf;
        private boolean atg;

        C0133a(String str, C0133a c0133a) {
            this.atg = false;
            this.ate = str;
            this.atf = c0133a;
            this.atg = false;
        }

        C0133a(File file) {
            this.atg = false;
            this.atg = true;
            this.atd = file;
            this.ate = file.getName();
        }

        public void vl() {
            vm().mkdirs();
        }

        public File vm() {
            File file = this.atd;
            if (file == null) {
                if (this.atf == null) {
                    file = new File(a.this.vi(), this.ate);
                } else {
                    file = new File(this.atf.vm(), this.ate);
                }
                this.atd = file;
            }
            return file;
        }

        public String vn() {
            return this.ate;
        }

        public C0133a ea(String str) {
            return new C0133a(str, this);
        }

        public File getFile(String str) {
            return new File(this.atd, str);
        }

        public C0133a vo() {
            return this.atf;
        }

        public boolean c(String str, String str2, boolean z) {
            return a.b(vm(), str, str2, "UTF-8", z);
        }

        public String p(String str, boolean z) {
            return a.b(vm(), str, "UTF-8", z);
        }

        public C0133a l(File file) {
            if (this.atg) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0133a c0133a = this;
            do {
                arrayList.add(c0133a.vn());
                c0133a = c0133a.vo();
            } while (c0133a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return new C0133a(file);
        }
    }
}
