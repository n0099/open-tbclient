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
    private C0141a axO;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        ze().mkdirs();
    }

    public File zd() {
        return new File(this.mContext.getApplicationInfo().dataDir);
    }

    private File ze() {
        return new File(zd(), ".helios");
    }

    public synchronized C0141a zf() {
        if (this.axO == null) {
            this.axO = new C0141a(".helios", null);
        }
        return this.axO;
    }

    public static void l(File file) {
        file.mkdirs();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=4] */
    public static boolean b(File file, String str, String str2, String str3, boolean z) {
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        l(file);
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
                fileOutputStream2.write(new b().x(str2.getBytes(str3)));
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
        l(file);
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
                String str3 = new String(z ? new b().y(byteArray) : byteArray, str2);
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
    /* loaded from: classes4.dex */
    public final class C0141a {
        private File axP;
        private String axQ;
        private C0141a axR;
        private boolean axS;

        C0141a(String str, C0141a c0141a) {
            this.axS = false;
            this.axQ = str;
            this.axR = c0141a;
            this.axS = false;
        }

        C0141a(File file) {
            this.axS = false;
            this.axS = true;
            this.axP = file;
            this.axQ = file.getName();
        }

        public void zg() {
            zh().mkdirs();
        }

        public File zh() {
            File file = this.axP;
            if (file == null) {
                if (this.axR == null) {
                    file = new File(a.this.zd(), this.axQ);
                } else {
                    file = new File(this.axR.zh(), this.axQ);
                }
                this.axP = file;
            }
            return file;
        }

        public String zi() {
            return this.axQ;
        }

        public C0141a fm(String str) {
            return new C0141a(str, this);
        }

        public File getFile(String str) {
            return new File(this.axP, str);
        }

        public C0141a zj() {
            return this.axR;
        }

        public boolean c(String str, String str2, boolean z) {
            return a.b(zh(), str, str2, "UTF-8", z);
        }

        public String p(String str, boolean z) {
            return a.b(zh(), str, "UTF-8", z);
        }

        public C0141a m(File file) {
            if (this.axS) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0141a c0141a = this;
            do {
                arrayList.add(c0141a.zi());
                c0141a = c0141a.zj();
            } while (c0141a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return new C0141a(file);
        }
    }
}
