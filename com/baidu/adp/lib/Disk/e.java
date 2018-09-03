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
    protected b vR;
    protected AtomicBoolean wa;
    private DiskFileOperate wb;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.wa.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.vR = null;
        this.wa = null;
        this.wb = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.gm() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.wa = new AtomicBoolean(false);
        this.vR = bVar;
        this.wb = diskFileOperate;
    }

    public boolean gf() {
        switch (this.wb.gm()) {
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
        if (file == null || !(this.wb instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.wb;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.wa.get(); i++) {
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
            File b = this.vR.b(this.wb.getPath(), false, this.wb.gt(), this.wb.gu());
            z = e(b);
            if (z) {
                this.wb.f(b);
                this.wb.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.wb.gl();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File a2;
        try {
            try {
                a2 = this.vR.a(this.wb.go(), this.wb.getName(), false, this.wb.gt(), this.wb.gu());
            } catch (Exception e) {
                e.getMessage();
                this.wb.gl();
                z = false;
            }
            if (a2 == null || this.wa.get()) {
                return false;
            }
            z = a2.exists() ? a2.delete() : false;
            if (z) {
                this.wb.f(a2);
                this.wb.setSuccess(true);
            }
            return z;
        } finally {
            this.wb.gl();
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
            a2 = this.vR.a(this.wb.go(), this.wb.getName(), false, this.wb.gt(), this.wb.gu());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (a2 == null || !a2.exists() || this.wa.get()) {
            com.baidu.adp.lib.g.a.f((InputStream) null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wb.gl();
            return false;
        }
        fileInputStream = new FileInputStream(a2);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.wa.get()) {
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
                    this.wb.gl();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.f(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.wb.gl();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.f(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.wb.gl();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.wa.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.wb.gr() || this.wb.i(byteArray)) {
                this.wb.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.f(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.wb.setSuccess(true);
                }
                this.wb.gl();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.f(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.wb.gl();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean s(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File a2;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = this.vR.a(this.wb.go(), this.wb.getName(), true, this.wb.gt(), this.wb.gu());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.wb.gl();
            throw th;
        }
        if (a2 == null || this.wa.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wb.gl();
            return false;
        }
        if (a2.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.wb.gl();
                return true;
            }
            a2.delete();
        }
        byte[] gn = this.wb.gn();
        byte[] data = this.wb.getData();
        if ((gn == null && data == null) || this.wa.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wb.gl();
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
                    this.wb.gl();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.wb.gl();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.wb.f(a2);
        this.wb.setSuccess(true);
        this.wb.gl();
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
        OutputStream outputStream2 = this.wb.getOutputStream();
        File gs = this.wb.gs();
        if (outputStream2 == null) {
            try {
                gs = this.vR.a(this.wb.go(), this.wb.getName(), true, this.wb.gt(), this.wb.gu());
                if (gs == null || this.wa.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.wb.gl();
                    return false;
                }
                outputStream = new FileOutputStream(gs, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.wb.gl();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.wb.gl();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                gn = this.wb.gn();
                data = this.wb.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.wb.gl();
                z2 = false;
                return z2;
            }
            if ((gn == null && data == null) || this.wa.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.wb.gl();
                return false;
            }
            if (gn != null) {
                outputStream.write(gn);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.wb.f(gs);
            this.wb.setSuccess(true);
            if (z) {
                this.wb.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.wb.gl();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.wb.gl();
            throw th;
        }
    }

    public boolean gi() {
        File b;
        if (this.wb.getName() != null) {
            b = this.vR.a(this.wb.go(), this.wb.getName(), false, this.wb.gt(), this.wb.gu());
        } else {
            b = this.vR.b(this.wb.go(), false, this.wb.gt(), this.wb.gu());
        }
        if (b != null && b.exists()) {
            this.wb.f(b);
            this.wb.setSuccess(true);
            this.wb.gl();
            return true;
        }
        this.wb.gl();
        return false;
    }

    public boolean gj() {
        boolean z;
        try {
            File a2 = this.vR.a(this.wb.go(), this.wb.getName(), false, this.wb.gt(), this.wb.gu());
            File a3 = this.vR.a(this.wb.gp(), this.wb.gx(), true, this.wb.gt(), this.wb.gu());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            } else {
                z = false;
            }
            if (z) {
                this.wb.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.wb.gl();
        }
    }

    public boolean gk() {
        boolean z = false;
        try {
            if (this.wb.gy() != null) {
                z = this.wb.gy().a(this, this.wb, this.vR);
            }
            if (z) {
                this.wb.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.wb.gl();
        }
        return z;
    }
}
