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
    private C0139a aus;
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

    public synchronized C0139a vk() {
        if (this.aus == null) {
            this.aus = new C0139a(".helios", null);
        }
        return this.aus;
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
                fileOutputStream2.write(new b().y(str2.getBytes(str3)));
            } else {
                fileOutputStream2.write(str2.getBytes(str3));
            }
            c.b(fileOutputStream2);
            return true;
        } catch (Exception e2) {
            fileOutputStream3 = fileOutputStream2;
            c.b(fileOutputStream3);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = fileOutputStream2;
            c.b(fileOutputStream);
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
                String str3 = new String(z ? new b().z(byteArray) : byteArray, str2);
                c.b(fileInputStream);
                c.b(byteArrayOutputStream);
                return str3;
            } catch (Exception e2) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                c.b(fileInputStream);
                c.b(byteArrayOutputStream2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                c.b(fileInputStream);
                c.b(byteArrayOutputStream);
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
    public final class C0139a {
        private File aut;
        private String auu;
        private C0139a auv;
        private boolean auw;

        C0139a(String str, C0139a c0139a) {
            this.auw = false;
            this.auu = str;
            this.auv = c0139a;
            this.auw = false;
        }

        C0139a(File file) {
            this.auw = false;
            this.auw = true;
            this.aut = file;
            this.auu = file.getName();
        }

        public void vl() {
            vm().mkdirs();
        }

        public File vm() {
            File file = this.aut;
            if (file == null) {
                if (this.auv == null) {
                    file = new File(a.this.vi(), this.auu);
                } else {
                    file = new File(this.auv.vm(), this.auu);
                }
                this.aut = file;
            }
            return file;
        }

        public String vn() {
            return this.auu;
        }

        public C0139a eg(String str) {
            return new C0139a(str, this);
        }

        public File getFile(String str) {
            return new File(this.aut, str);
        }

        public C0139a vo() {
            return this.auv;
        }

        public boolean c(String str, String str2, boolean z) {
            return a.b(vm(), str, str2, "UTF-8", z);
        }

        public String p(String str, boolean z) {
            return a.b(vm(), str, "UTF-8", z);
        }

        public C0139a l(File file) {
            if (this.auw) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0139a c0139a = this;
            do {
                arrayList.add(c0139a.vn());
                c0139a = c0139a.vo();
            } while (c0139a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return new C0139a(file);
        }
    }
}
