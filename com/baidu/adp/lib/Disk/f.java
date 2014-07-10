package com.baidu.adp.lib.Disk;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class f {
    protected final int a = 1024;
    protected b b;
    protected AtomicBoolean c;
    private DiskFileOperate d;

    public void a() {
        this.c.set(true);
    }

    public f(b bVar, DiskFileOperate diskFileOperate) {
        this.b = null;
        this.c = null;
        this.d = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.e() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.c = new AtomicBoolean(false);
        this.b = bVar;
        this.d = diskFileOperate;
    }

    public boolean b() {
        if (this.d.e() == DiskFileOperate.Action.WRITE) {
            return a(false);
        }
        if (this.d.e() == DiskFileOperate.Action.WRITE_FORCE) {
            return a(true);
        }
        if (this.d.e() == DiskFileOperate.Action.DELETE) {
            return f();
        }
        if (this.d.e() == DiskFileOperate.Action.DELETE_FILES) {
            return e();
        }
        if (this.d.e() == DiskFileOperate.Action.APPEND) {
            return b(false);
        }
        if (this.d.e() == DiskFileOperate.Action.APPEND_MORE) {
            return b(true);
        }
        if (this.d.e() == DiskFileOperate.Action.INFO) {
            return c();
        }
        if (this.d.e() == DiskFileOperate.Action.RENAME) {
            return d();
        }
        return g();
    }

    private boolean a(File file) {
        if (file == null || !(this.d instanceof a)) {
            return false;
        }
        a aVar = (a) this.d;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.c.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        a(listFiles[i]);
                    } else if (aVar.a(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (aVar.a(file)) {
            file.delete();
        }
        return true;
    }

    private boolean e() {
        boolean z = false;
        try {
            File b = this.b.b(this.d.d(), false, this.d.o());
            z = a(b);
            if (z) {
                this.d.b(b);
                this.d.a(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.d.a();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [163=4] */
    private boolean f() {
        try {
            File a = this.b.a(this.d.h(), this.d.c(), false, this.d.o());
            if (a != null && !this.c.get()) {
                r0 = a.exists() ? a.delete() : false;
                if (r0) {
                    this.d.b(a);
                    this.d.a(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.d.a();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [199=4, 200=4, 204=4] */
    private boolean g() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a = this.b.a(this.d.h(), this.d.c(), false, this.d.o());
            if (a == null || !a.exists() || this.c.get()) {
                com.baidu.adp.lib.f.a.a((InputStream) null);
                com.baidu.adp.lib.f.a.a((OutputStream) null);
                this.d.a();
            } else {
                fileInputStream = new FileInputStream(a);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1 || this.c.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.c.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.d.k() || this.d.b(byteArray)) {
                            this.d.a(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.f.a.a((InputStream) fileInputStream);
                    com.baidu.adp.lib.f.a.a((OutputStream) byteArrayOutputStream);
                    if (z) {
                        this.d.a(true);
                    }
                    this.d.a();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.f.a.a((InputStream) fileInputStream2);
                        com.baidu.adp.lib.f.a.a((OutputStream) byteArrayOutputStream);
                        this.d.a();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.f.a.a((InputStream) fileInputStream);
                        com.baidu.adp.lib.f.a.a((OutputStream) byteArrayOutputStream);
                        this.d.a();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.f.a.a((InputStream) fileInputStream);
                    com.baidu.adp.lib.f.a.a((OutputStream) byteArrayOutputStream);
                    this.d.a();
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [248=6, 253=6] */
    public boolean a(boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File a = this.b.a(this.d.h(), this.d.c(), true, this.d.o());
                if (a == null || this.c.get()) {
                    com.baidu.adp.lib.f.a.a((OutputStream) null);
                    this.d.a();
                    return false;
                }
                if (a.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.f.a.a((OutputStream) null);
                        this.d.a();
                        return true;
                    }
                    a.delete();
                }
                byte[] f = this.d.f();
                byte[] b = this.d.b();
                if ((f == null && b == null) || this.c.get()) {
                    com.baidu.adp.lib.f.a.a((OutputStream) null);
                    this.d.a();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a);
                if (f != null) {
                    try {
                        fileOutputStream2.write(f);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.f.a.a((OutputStream) fileOutputStream);
                        this.d.a();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.f.a.a((OutputStream) fileOutputStream);
                        this.d.a();
                        throw th;
                    }
                }
                if (b != null) {
                    fileOutputStream2.write(b);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.f.a.a((OutputStream) fileOutputStream2);
                this.d.b(a);
                this.d.a(true);
                this.d.a();
                return true;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, IGET, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [296=5, 297=5, 301=5] */
    public boolean b(boolean z) {
        OutputStream l = this.d.l();
        File n = this.d.n();
        if (l == null) {
            try {
                try {
                    n = this.b.a(this.d.h(), this.d.c(), true, this.d.o());
                    if (n == null || this.c.get()) {
                        if (!z) {
                            com.baidu.adp.lib.f.a.a(l);
                        }
                        this.d.a();
                        return false;
                    }
                    l = new FileOutputStream(n, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.f.a.a(l);
                    }
                    this.d.a();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.f.a.a(l);
                }
                this.d.a();
                throw th;
            }
        }
        byte[] f = this.d.f();
        byte[] b = this.d.b();
        if ((f == null && b == null) || this.c.get()) {
            if (!z) {
                com.baidu.adp.lib.f.a.a(l);
            }
            this.d.a();
            return false;
        }
        if (f != null) {
            l.write(f);
        }
        if (b != null) {
            l.write(b);
        }
        l.flush();
        this.d.b(n);
        this.d.a(true);
        if (z) {
            this.d.a(l);
        } else {
            com.baidu.adp.lib.f.a.a(l);
        }
        this.d.a();
        return true;
    }

    public boolean c() {
        File b;
        if (this.d.c() != null) {
            b = this.b.a(this.d.h(), this.d.c(), false, this.d.o());
        } else {
            b = this.b.b(this.d.h(), false, this.d.o());
        }
        if (b != null && b.exists()) {
            this.d.b(b);
            this.d.a(true);
            this.d.a();
            return true;
        }
        this.d.a();
        return false;
    }

    public boolean d() {
        boolean z = false;
        try {
            File a = this.b.a(this.d.h(), this.d.c(), false, this.d.o());
            File a2 = this.b.a(this.d.i(), this.d.t(), true, this.d.o());
            if (a != null) {
                if (a2 != null) {
                    a2.delete();
                }
                z = a.renameTo(a2);
            }
            if (z) {
                this.d.a(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.d.a();
        }
        return z;
    }
}
