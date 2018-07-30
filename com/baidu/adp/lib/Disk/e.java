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
    protected b vQ;
    protected AtomicBoolean vZ;
    private DiskFileOperate wa;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.vZ.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.vQ = null;
        this.vZ = null;
        this.wa = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.gm() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.vZ = new AtomicBoolean(false);
        this.vQ = bVar;
        this.wa = diskFileOperate;
    }

    public boolean gf() {
        switch (this.wa.gm()) {
            case WRITE:
                return s(false);
            case WRITE_FORCE:
                return s(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return gg();
            case APPEND:
                return t(false);
            case APPEND_MORE:
                return t(true);
            case INFO:
                return gi();
            case RENAME:
                return gj();
            case READ:
                return gh();
            case CUSTOM:
                return gk();
            default:
                return false;
        }
    }

    private boolean e(File file) {
        if (file == null || !(this.wa instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.wa;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.vZ.get(); i++) {
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

    private boolean gg() {
        boolean z = false;
        try {
            File b = this.vQ.b(this.wa.getPath(), false, this.wa.gt(), this.wa.gu());
            z = e(b);
            if (z) {
                this.wa.f(b);
                this.wa.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.wa.gl();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File a2;
        try {
            try {
                a2 = this.vQ.a(this.wa.go(), this.wa.getName(), false, this.wa.gt(), this.wa.gu());
            } catch (Exception e) {
                e.getMessage();
                this.wa.gl();
                z = false;
            }
            if (a2 == null || this.vZ.get()) {
                return false;
            }
            z = a2.exists() ? a2.delete() : false;
            if (z) {
                this.wa.f(a2);
                this.wa.setSuccess(true);
            }
            return z;
        } finally {
            this.wa.gl();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean gh() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File a2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            a2 = this.vQ.a(this.wa.go(), this.wa.getName(), false, this.wa.gt(), this.wa.gu());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (a2 == null || !a2.exists() || this.vZ.get()) {
            com.baidu.adp.lib.g.a.f((InputStream) null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wa.gl();
            return false;
        }
        fileInputStream = new FileInputStream(a2);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.vZ.get()) {
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
                    this.wa.gl();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.wa.gl();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.f(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.wa.gl();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.vZ.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.wa.gr() || this.wa.i(byteArray)) {
                this.wa.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.f(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.wa.setSuccess(true);
                }
                this.wa.gl();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.f(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.wa.gl();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean s(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File a2;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = this.vQ.a(this.wa.go(), this.wa.getName(), true, this.wa.gt(), this.wa.gu());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.wa.gl();
            throw th;
        }
        if (a2 == null || this.vZ.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wa.gl();
            return false;
        }
        if (a2.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.wa.gl();
                return true;
            }
            a2.delete();
        }
        byte[] gn = this.wa.gn();
        byte[] data = this.wa.getData();
        if ((gn == null && data == null) || this.vZ.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wa.gl();
            return false;
        }
        fileOutputStream = new FileOutputStream(a2);
        if (gn != null) {
            try {
                try {
                    fileOutputStream.write(gn);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    this.wa.gl();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.wa.gl();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.wa.f(a2);
        this.wa.setSuccess(true);
        this.wa.gl();
        z2 = true;
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=5, 300=5, 304=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean t(boolean z) {
        OutputStream outputStream;
        boolean z2;
        byte[] gn;
        byte[] data;
        OutputStream outputStream2 = this.wa.getOutputStream();
        File gs = this.wa.gs();
        if (outputStream2 == null) {
            try {
                gs = this.vQ.a(this.wa.go(), this.wa.getName(), true, this.wa.gt(), this.wa.gu());
                if (gs == null || this.vZ.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.wa.gl();
                    return false;
                }
                outputStream = new FileOutputStream(gs, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.wa.gl();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.wa.gl();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                gn = this.wa.gn();
                data = this.wa.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.wa.gl();
                z2 = false;
                return z2;
            }
            if ((gn == null && data == null) || this.vZ.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.wa.gl();
                return false;
            }
            if (gn != null) {
                outputStream.write(gn);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.wa.f(gs);
            this.wa.setSuccess(true);
            if (z) {
                this.wa.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.wa.gl();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.wa.gl();
            throw th;
        }
    }

    public boolean gi() {
        File b;
        if (this.wa.getName() != null) {
            b = this.vQ.a(this.wa.go(), this.wa.getName(), false, this.wa.gt(), this.wa.gu());
        } else {
            b = this.vQ.b(this.wa.go(), false, this.wa.gt(), this.wa.gu());
        }
        if (b != null && b.exists()) {
            this.wa.f(b);
            this.wa.setSuccess(true);
            this.wa.gl();
            return true;
        }
        this.wa.gl();
        return false;
    }

    public boolean gj() {
        boolean z;
        try {
            File a2 = this.vQ.a(this.wa.go(), this.wa.getName(), false, this.wa.gt(), this.wa.gu());
            File a3 = this.vQ.a(this.wa.gp(), this.wa.gx(), true, this.wa.gt(), this.wa.gu());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            } else {
                z = false;
            }
            if (z) {
                this.wa.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.wa.gl();
        }
    }

    public boolean gk() {
        boolean z = false;
        try {
            if (this.wa.gy() != null) {
                z = this.wa.gy().a(this, this.wa, this.vQ);
            }
            if (z) {
                this.wa.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.wa.gl();
        }
        return z;
    }
}
