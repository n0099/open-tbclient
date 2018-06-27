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
    protected b vX;
    protected AtomicBoolean wg;
    private DiskFileOperate wh;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.wg.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.vX = null;
        this.wg = null;
        this.wh = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.gn() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.wg = new AtomicBoolean(false);
        this.vX = bVar;
        this.wh = diskFileOperate;
    }

    public boolean gg() {
        switch (this.wh.gn()) {
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
        if (file == null || !(this.wh instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.wh;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.wg.get(); i++) {
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
            File b = this.vX.b(this.wh.getPath(), false, this.wh.gu(), this.wh.gv());
            z = e(b);
            if (z) {
                this.wh.f(b);
                this.wh.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.wh.gm();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File a2;
        try {
            try {
                a2 = this.vX.a(this.wh.gp(), this.wh.getName(), false, this.wh.gu(), this.wh.gv());
            } catch (Exception e) {
                e.getMessage();
                this.wh.gm();
                z = false;
            }
            if (a2 == null || this.wg.get()) {
                return false;
            }
            z = a2.exists() ? a2.delete() : false;
            if (z) {
                this.wh.f(a2);
                this.wh.setSuccess(true);
            }
            return z;
        } finally {
            this.wh.gm();
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
            a2 = this.vX.a(this.wh.gp(), this.wh.getName(), false, this.wh.gu(), this.wh.gv());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (a2 == null || !a2.exists() || this.wg.get()) {
            com.baidu.adp.lib.g.a.f((InputStream) null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wh.gm();
            return false;
        }
        fileInputStream = new FileInputStream(a2);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.wg.get()) {
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
                    this.wh.gm();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.wh.gm();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.f(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.wh.gm();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.wg.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.wh.gs() || this.wh.k(byteArray)) {
                this.wh.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.f(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.wh.setSuccess(true);
                }
                this.wh.gm();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.f(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.wh.gm();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean u(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File a2;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = this.vX.a(this.wh.gp(), this.wh.getName(), true, this.wh.gu(), this.wh.gv());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.wh.gm();
            throw th;
        }
        if (a2 == null || this.wg.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wh.gm();
            return false;
        }
        if (a2.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.wh.gm();
                return true;
            }
            a2.delete();
        }
        byte[] go = this.wh.go();
        byte[] data = this.wh.getData();
        if ((go == null && data == null) || this.wg.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wh.gm();
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
                    this.wh.gm();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.wh.gm();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.wh.f(a2);
        this.wh.setSuccess(true);
        this.wh.gm();
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
        OutputStream outputStream2 = this.wh.getOutputStream();
        File gt = this.wh.gt();
        if (outputStream2 == null) {
            try {
                gt = this.vX.a(this.wh.gp(), this.wh.getName(), true, this.wh.gu(), this.wh.gv());
                if (gt == null || this.wg.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.wh.gm();
                    return false;
                }
                outputStream = new FileOutputStream(gt, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.wh.gm();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.wh.gm();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                go = this.wh.go();
                data = this.wh.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.wh.gm();
                z2 = false;
                return z2;
            }
            if ((go == null && data == null) || this.wg.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.wh.gm();
                return false;
            }
            if (go != null) {
                outputStream.write(go);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.wh.f(gt);
            this.wh.setSuccess(true);
            if (z) {
                this.wh.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.wh.gm();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.wh.gm();
            throw th;
        }
    }

    public boolean gj() {
        File b;
        if (this.wh.getName() != null) {
            b = this.vX.a(this.wh.gp(), this.wh.getName(), false, this.wh.gu(), this.wh.gv());
        } else {
            b = this.vX.b(this.wh.gp(), false, this.wh.gu(), this.wh.gv());
        }
        if (b != null && b.exists()) {
            this.wh.f(b);
            this.wh.setSuccess(true);
            this.wh.gm();
            return true;
        }
        this.wh.gm();
        return false;
    }

    public boolean gk() {
        boolean z;
        try {
            File a2 = this.vX.a(this.wh.gp(), this.wh.getName(), false, this.wh.gu(), this.wh.gv());
            File a3 = this.vX.a(this.wh.gq(), this.wh.gy(), true, this.wh.gu(), this.wh.gv());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            } else {
                z = false;
            }
            if (z) {
                this.wh.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.wh.gm();
        }
    }

    public boolean gl() {
        boolean z = false;
        try {
            if (this.wh.gA() != null) {
                z = this.wh.gA().a(this, this.wh, this.vX);
            }
            if (z) {
                this.wh.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.wh.gm();
        }
        return z;
    }
}
