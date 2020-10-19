package com.baidu.cesium.e;

import android.content.Context;
import com.baidu.cesium.c.b.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private C0102a amg;
    private Context d;

    /* renamed from: com.baidu.cesium.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C0102a {
        private C0102a amK;
        private File b;
        private String c;
        private boolean e;

        C0102a(File file) {
            this.e = false;
            this.e = true;
            this.b = file;
            this.c = file.getName();
        }

        C0102a(String str, C0102a c0102a) {
            this.e = false;
            this.c = str;
            this.amK = c0102a;
            this.e = false;
        }

        public String a(String str, boolean z) {
            return a.a(b(), str, "UTF-8", z);
        }

        public void a() {
            b().mkdirs();
        }

        public File b() {
            File file = this.b;
            if (file == null) {
                file = this.amK == null ? new File(a.this.a(), this.c) : new File(this.amK.b(), this.c);
                this.b = file;
            }
            return file;
        }

        public File b(String str) {
            return new File(this.b, str);
        }

        public String c() {
            return this.c;
        }

        public boolean c(String str, String str2, boolean z) {
            return a.a(b(), str, str2, "UTF-8", z);
        }

        /* renamed from: do  reason: not valid java name */
        public C0102a m20do(String str) {
            return new C0102a(str, this);
        }

        public C0102a j(File file) {
            if (this.e) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0102a c0102a = this;
            do {
                arrayList.add(c0102a.c());
                c0102a = c0102a.ux();
            } while (c0102a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return new C0102a(file);
        }

        public C0102a ux() {
            return this.amK;
        }
    }

    public a(Context context) {
        this.d = context;
        c().mkdirs();
    }

    public static String a(File file, String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        a(file);
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
            String str3 = new String(z ? new c().b(byteArray) : byteArray, str2);
            com.baidu.cesium.f.c.a(fileInputStream);
            com.baidu.cesium.f.c.a(byteArrayOutputStream);
            return str3;
        } catch (Exception e3) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            fileInputStream2 = fileInputStream;
            com.baidu.cesium.f.c.a(fileInputStream2);
            com.baidu.cesium.f.c.a(byteArrayOutputStream2);
            return "";
        } catch (Throwable th4) {
            th = th4;
            com.baidu.cesium.f.c.a(fileInputStream);
            com.baidu.cesium.f.c.a(byteArrayOutputStream);
            throw th;
        }
    }

    public static void a(File file) {
        file.mkdirs();
    }

    public static boolean a(File file, String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        a(file);
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
                fileOutputStream.write(new c().a(str2.getBytes()));
            } else {
                fileOutputStream.write(str2.getBytes(str3));
            }
            com.baidu.cesium.f.c.a(fileOutputStream);
            return true;
        } catch (Exception e2) {
            fileOutputStream2 = fileOutputStream;
            com.baidu.cesium.f.c.a(fileOutputStream2);
            return false;
        } catch (Throwable th3) {
            th = th3;
            com.baidu.cesium.f.c.a(fileOutputStream);
            throw th;
        }
    }

    private File c() {
        return new File(a(), ".cesium");
    }

    public File a() {
        return new File(this.d.getApplicationInfo().dataDir);
    }

    public synchronized C0102a uw() {
        if (this.amg == null) {
            this.amg = new C0102a(".cesium", null);
        }
        return this.amg;
    }
}
