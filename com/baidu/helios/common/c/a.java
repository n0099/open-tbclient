package com.baidu.helios.common.c;

import android.content.Context;
import com.baidu.helios.common.a.b;
import com.baidu.helios.common.b.a.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class a {
    private C0153a ayh;
    private Context mContext;

    public a(Context context) {
        this.mContext = context;
        AC().mkdirs();
    }

    public File AB() {
        return new File(this.mContext.getApplicationInfo().dataDir);
    }

    private File AC() {
        return new File(AB(), ".helios");
    }

    public synchronized C0153a AD() {
        if (this.ayh == null) {
            this.ayh = new C0153a(".helios", null);
        }
        return this.ayh;
    }

    public static void l(File file) {
        file.mkdirs();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [93=4] */
    public static boolean b(File file, String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        l(file);
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
        l(file);
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
    /* loaded from: classes8.dex */
    public final class C0153a {
        private File ayi;
        private String ayj;
        private C0153a ayk;
        private boolean ayl;

        C0153a(String str, C0153a c0153a) {
            this.ayl = false;
            this.ayj = str;
            this.ayk = c0153a;
            this.ayl = false;
        }

        C0153a(File file) {
            this.ayl = false;
            this.ayl = true;
            this.ayi = file;
            this.ayj = file.getName();
        }

        public void AE() {
            AF().mkdirs();
        }

        public File AF() {
            File file = this.ayi;
            if (file == null) {
                if (this.ayk == null) {
                    file = new File(a.this.AB(), this.ayj);
                } else {
                    file = new File(this.ayk.AF(), this.ayj);
                }
                this.ayi = file;
            }
            return file;
        }

        public String AG() {
            return this.ayj;
        }

        public C0153a fD(String str) {
            return new C0153a(str, this);
        }

        public File getFile(String str) {
            return new File(this.ayi, str);
        }

        public C0153a AH() {
            return this.ayk;
        }

        public boolean d(String str, String str2, boolean z) {
            return a.b(AF(), str, str2, "UTF-8", z);
        }

        public String q(String str, boolean z) {
            return a.b(AF(), str, "UTF-8", z);
        }

        public C0153a m(File file) {
            if (this.ayl) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0153a c0153a = this;
            do {
                arrayList.add(c0153a.AG());
                c0153a = c0153a.AH();
            } while (c0153a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return new C0153a(file);
        }
    }
}
