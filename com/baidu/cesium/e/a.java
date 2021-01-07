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
    private C0094a anQ;
    private Context d;

    /* renamed from: com.baidu.cesium.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public final class C0094a {
        private C0094a aor;

        /* renamed from: b  reason: collision with root package name */
        private File f1699b;
        private String c;
        private boolean e;

        C0094a(File file) {
            this.e = false;
            this.e = true;
            this.f1699b = file;
            this.c = file.getName();
        }

        C0094a(String str, C0094a c0094a) {
            this.e = false;
            this.c = str;
            this.aor = c0094a;
            this.e = false;
        }

        public String a(String str, boolean z) {
            return a.a(b(), str, "UTF-8", z);
        }

        public void a() {
            b().mkdirs();
        }

        public boolean a(String str, String str2, boolean z) {
            return a.a(b(), str, str2, "UTF-8", z);
        }

        public File b() {
            File file = this.f1699b;
            if (file == null) {
                file = this.aor == null ? new File(a.this.a(), this.c) : new File(this.aor.b(), this.c);
                this.f1699b = file;
            }
            return file;
        }

        public File b(String str) {
            return new File(this.f1699b, str);
        }

        public String c() {
            return this.c;
        }

        public C0094a dm(String str) {
            return new C0094a(str, this);
        }

        public C0094a j(File file) {
            if (this.e) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0094a c0094a = this;
            do {
                arrayList.add(c0094a.c());
                c0094a = c0094a.tY();
            } while (c0094a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                File file2 = new File(file, (String) arrayList.get(size));
                size--;
                file = file2;
            }
            return new C0094a(file);
        }

        public C0094a tY() {
            return this.aor;
        }
    }

    public a(Context context) {
        this.d = context;
        c().mkdirs();
    }

    public static String a(File file, String str, String str2, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        a(file);
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
                String str3 = new String(z ? new c().b(byteArray) : byteArray, str2);
                com.baidu.cesium.f.c.a(fileInputStream);
                com.baidu.cesium.f.c.a(byteArrayOutputStream);
                return str3;
            } catch (Exception e2) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.cesium.f.c.a(fileInputStream);
                com.baidu.cesium.f.c.a(byteArrayOutputStream2);
                return "";
            } catch (Throwable th2) {
                th = th2;
                com.baidu.cesium.f.c.a(fileInputStream);
                com.baidu.cesium.f.c.a(byteArrayOutputStream);
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

    public static void a(File file) {
        file.mkdirs();
    }

    public static boolean a(File file, String str, String str2, String str3, boolean z) {
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        a(file);
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
                fileOutputStream2.write(new c().a(str2.getBytes()));
            } else {
                fileOutputStream2.write(str2.getBytes(str3));
            }
            com.baidu.cesium.f.c.a(fileOutputStream2);
            return true;
        } catch (Exception e2) {
            fileOutputStream3 = fileOutputStream2;
            com.baidu.cesium.f.c.a(fileOutputStream3);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = fileOutputStream2;
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

    public synchronized C0094a tX() {
        if (this.anQ == null) {
            this.anQ = new C0094a(".cesium", null);
        }
        return this.anQ;
    }
}
