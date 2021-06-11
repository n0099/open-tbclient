package com.baidu.mobads.cid.cesium.e;

import android.content.Context;
import com.baidu.mobads.cid.cesium.c.b.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f8249a;

    /* renamed from: b  reason: collision with root package name */
    public C0107a f8250b;

    /* renamed from: com.baidu.mobads.cid.cesium.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public final class C0107a {

        /* renamed from: b  reason: collision with root package name */
        public File f8252b;

        /* renamed from: c  reason: collision with root package name */
        public String f8253c;

        /* renamed from: d  reason: collision with root package name */
        public C0107a f8254d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8255e;

        public C0107a(File file) {
            this.f8255e = false;
            this.f8255e = true;
            this.f8252b = file;
            this.f8253c = file.getName();
        }

        public C0107a(String str, C0107a c0107a) {
            this.f8255e = false;
            this.f8253c = str;
            this.f8254d = c0107a;
            this.f8255e = false;
        }

        public C0107a a(File file) {
            if (this.f8255e) {
                throw new IllegalStateException("isolate session is not support");
            }
            ArrayList arrayList = new ArrayList();
            C0107a c0107a = this;
            do {
                arrayList.add(c0107a.c());
                c0107a = c0107a.d();
            } while (c0107a != null);
            int size = arrayList.size() - 1;
            while (size >= 0) {
                size--;
                file = new File(file, (String) arrayList.get(size));
            }
            return new C0107a(file);
        }

        public C0107a a(String str) {
            return new C0107a(str, this);
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
            File file = this.f8252b;
            if (file != null) {
                return file;
            }
            File file2 = this.f8254d == null ? new File(a.this.a(), this.f8253c) : new File(this.f8254d.b(), this.f8253c);
            this.f8252b = file2;
            return file2;
        }

        public String c() {
            return this.f8253c;
        }

        public C0107a d() {
            return this.f8254d;
        }
    }

    public a(Context context) {
        this.f8249a = context;
        c().mkdirs();
    }

    public static String a(File file, String str, String str2, boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        a(file);
        File file2 = new File(file, str);
        FileInputStream fileInputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file2);
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
                    if (z) {
                        byteArray = new c().b(byteArray);
                    }
                    String str3 = new String(byteArray, str2);
                    com.baidu.mobads.cid.cesium.f.c.a(fileInputStream);
                    com.baidu.mobads.cid.cesium.f.c.a(byteArrayOutputStream);
                    return str3;
                } catch (Exception unused) {
                    fileInputStream2 = fileInputStream;
                    com.baidu.mobads.cid.cesium.f.c.a(fileInputStream2);
                    com.baidu.mobads.cid.cesium.f.c.a(byteArrayOutputStream);
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.mobads.cid.cesium.f.c.a(fileInputStream);
                    com.baidu.mobads.cid.cesium.f.c.a(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        } catch (Exception unused3) {
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }

    public static void a(File file) {
        file.mkdirs();
    }

    public static boolean a(File file, String str, String str2, String str3, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable th;
        a(file);
        File file2 = new File(file, str);
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                if (z) {
                    fileOutputStream.write(new c().a(str2.getBytes()));
                } else {
                    fileOutputStream.write(str2.getBytes(str3));
                }
                com.baidu.mobads.cid.cesium.f.c.a(fileOutputStream);
                return true;
            } catch (Exception unused) {
                fileOutputStream2 = fileOutputStream;
                com.baidu.mobads.cid.cesium.f.c.a(fileOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.mobads.cid.cesium.f.c.a(fileOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
        }
    }

    private File c() {
        return new File(a(), ".cesium");
    }

    public File a() {
        return new File(this.f8249a.getApplicationInfo().dataDir);
    }

    public synchronized C0107a b() {
        if (this.f8250b == null) {
            this.f8250b = new C0107a(".cesium", null);
        }
        return this.f8250b;
    }
}
