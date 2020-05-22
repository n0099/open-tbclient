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
    private C0141a aqJ;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        ur().mkdirs();
    }

    public File uq() {
        return new File(this.mContext.getApplicationInfo().dataDir);
    }

    private File ur() {
        return new File(uq(), ".helios");
    }

    public synchronized C0141a us() {
        if (this.aqJ == null) {
            this.aqJ = new C0141a(".helios", null);
        }
        return this.aqJ;
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
                fileOutputStream.write(new b().x(str2.getBytes()));
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
            String str3 = new String(z ? new b().y(byteArray) : byteArray, str2);
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
    public final class C0141a {
        private File aqK;
        private String aqL;
        private C0141a aqM;
        private boolean aqN;

        C0141a(String str, C0141a c0141a) {
            this.aqN = false;
            this.aqL = str;
            this.aqM = c0141a;
            this.aqN = false;
        }

        C0141a(File file) {
            this.aqN = false;
            this.aqN = true;
            this.aqK = file;
            this.aqL = file.getName();
        }

        public void ut() {
            uu().mkdirs();
        }

        public File uu() {
            File file = this.aqK;
            if (file == null) {
                if (this.aqM == null) {
                    file = new File(a.this.uq(), this.aqL);
                } else {
                    file = new File(this.aqM.uu(), this.aqL);
                }
                this.aqK = file;
            }
            return file;
        }

        public String uv() {
            return this.aqL;
        }

        public C0141a eb(String str) {
            return new C0141a(str, this);
        }

        public File getFile(String str) {
            return new File(this.aqK, str);
        }

        public C0141a uw() {
            return this.aqM;
        }

        public boolean d(String str, String str2, boolean z) {
            return a.b(uu(), str, str2, "UTF-8", z);
        }

        public String q(String str, boolean z) {
            return a.b(uu(), str, "UTF-8", z);
        }

        public C0141a k(File file) {
            if (this.aqN) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0141a c0141a = this;
            do {
                arrayList.add(c0141a.uv());
                c0141a = c0141a.uw();
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
