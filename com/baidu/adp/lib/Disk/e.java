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
public class e {
    protected final int BUFFER_SIZE = 1024;
    protected b vZ;
    protected AtomicBoolean wi;
    private DiskFileOperate wj;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.wi.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.vZ = null;
        this.wi = null;
        this.wj = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.gn() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.wi = new AtomicBoolean(false);
        this.vZ = bVar;
        this.wj = diskFileOperate;
    }

    public boolean gg() {
        switch (this.wj.gn()) {
            case WRITE:
                return u(false);
            case WRITE_FORCE:
                return u(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return gh();
            case APPEND:
                return v(false);
            case APPEND_MORE:
                return v(true);
            case INFO:
                return gj();
            case RENAME:
                return gk();
            case READ:
                return gi();
            case CUSTOM:
                return gl();
            default:
                return false;
        }
    }

    private boolean e(File file) {
        if (file == null || !(this.wj instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.wj;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.wi.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        e(listFiles[i]);
                    } else if (aVar.d(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (aVar.d(file)) {
            file.delete();
        }
        return true;
    }

    private boolean gh() {
        boolean z = false;
        try {
            File b = this.vZ.b(this.wj.getPath(), false, this.wj.gu(), this.wj.gv());
            z = e(b);
            if (z) {
                this.wj.f(b);
                this.wj.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.wj.gm();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File a2;
        try {
            try {
                a2 = this.vZ.a(this.wj.gp(), this.wj.getName(), false, this.wj.gu(), this.wj.gv());
            } catch (Exception e) {
                e.getMessage();
                this.wj.gm();
                z = false;
            }
            if (a2 == null || this.wi.get()) {
                return false;
            }
            z = a2.exists() ? a2.delete() : false;
            if (z) {
                this.wj.f(a2);
                this.wj.setSuccess(true);
            }
            return z;
        } finally {
            this.wj.gm();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean gi() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File a2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            a2 = this.vZ.a(this.wj.gp(), this.wj.getName(), false, this.wj.gu(), this.wj.gv());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (a2 == null || !a2.exists() || this.wi.get()) {
            com.baidu.adp.lib.g.a.f((InputStream) null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wj.gm();
            return false;
        }
        fileInputStream = new FileInputStream(a2);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.wi.get()) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                try {
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.f(fileInputStream2);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    this.wj.gm();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.wj.gm();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.f(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.wj.gm();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.wi.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.wj.gs() || this.wj.j(byteArray)) {
                this.wj.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.f(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.wj.setSuccess(true);
                }
                this.wj.gm();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.f(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.wj.gm();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean u(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File a2;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = this.vZ.a(this.wj.gp(), this.wj.getName(), true, this.wj.gu(), this.wj.gv());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.wj.gm();
            throw th;
        }
        if (a2 == null || this.wi.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wj.gm();
            return false;
        }
        if (a2.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.wj.gm();
                return true;
            }
            a2.delete();
        }
        byte[] go = this.wj.go();
        byte[] data = this.wj.getData();
        if ((go == null && data == null) || this.wi.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wj.gm();
            return false;
        }
        fileOutputStream = new FileOutputStream(a2);
        if (go != null) {
            try {
                try {
                    fileOutputStream.write(go);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    this.wj.gm();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.wj.gm();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.wj.f(a2);
        this.wj.setSuccess(true);
        this.wj.gm();
        z2 = true;
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=5, 300=5, 304=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean v(boolean z) {
        OutputStream outputStream;
        boolean z2;
        byte[] go;
        byte[] data;
        OutputStream outputStream2 = this.wj.getOutputStream();
        File gt = this.wj.gt();
        if (outputStream2 == null) {
            try {
                gt = this.vZ.a(this.wj.gp(), this.wj.getName(), true, this.wj.gu(), this.wj.gv());
                if (gt == null || this.wi.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.wj.gm();
                    return false;
                }
                outputStream = new FileOutputStream(gt, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.wj.gm();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.wj.gm();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                go = this.wj.go();
                data = this.wj.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.wj.gm();
                z2 = false;
                return z2;
            }
            if ((go == null && data == null) || this.wi.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.wj.gm();
                return false;
            }
            if (go != null) {
                outputStream.write(go);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.wj.f(gt);
            this.wj.setSuccess(true);
            if (z) {
                this.wj.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.wj.gm();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.wj.gm();
            throw th;
        }
    }

    public boolean gj() {
        File b;
        if (this.wj.getName() != null) {
            b = this.vZ.a(this.wj.gp(), this.wj.getName(), false, this.wj.gu(), this.wj.gv());
        } else {
            b = this.vZ.b(this.wj.gp(), false, this.wj.gu(), this.wj.gv());
        }
        if (b != null && b.exists()) {
            this.wj.f(b);
            this.wj.setSuccess(true);
            this.wj.gm();
            return true;
        }
        this.wj.gm();
        return false;
    }

    public boolean gk() {
        boolean z;
        try {
            File a2 = this.vZ.a(this.wj.gp(), this.wj.getName(), false, this.wj.gu(), this.wj.gv());
            File a3 = this.vZ.a(this.wj.gq(), this.wj.gy(), true, this.wj.gu(), this.wj.gv());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            } else {
                z = false;
            }
            if (z) {
                this.wj.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.wj.gm();
        }
    }

    public boolean gl() {
        boolean z = false;
        try {
            if (this.wj.gA() != null) {
                z = this.wj.gA().a(this, this.wj, this.vZ);
            }
            if (z) {
                this.wj.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.wj.gm();
        }
        return z;
    }
}
