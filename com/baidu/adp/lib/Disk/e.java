package com.baidu.adp.lib.Disk;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    protected final int BUFFER_SIZE = 1024;
    protected b pL;
    protected AtomicBoolean pU;
    private DiskFileOperate pV;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.pU.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.pL = null;
        this.pU = null;
        this.pV = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.dx() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.pU = new AtomicBoolean(false);
        this.pL = bVar;
        this.pV = diskFileOperate;
    }

    public boolean dq() {
        switch (this.pV.dx()) {
            case WRITE:
                return s(false);
            case WRITE_FORCE:
                return s(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return dr();
            case APPEND:
                return t(false);
            case APPEND_MORE:
                return t(true);
            case INFO:
                return dt();
            case RENAME:
                return du();
            case READ:
                return ds();
            case CUSTOM:
                return dv();
            default:
                return false;
        }
    }

    private boolean e(File file) {
        if (file == null || !(this.pV instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.pV;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.pU.get(); i++) {
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

    private boolean dr() {
        boolean z = false;
        try {
            File b = this.pL.b(this.pV.getPath(), false, this.pV.dE(), this.pV.dF());
            z = e(b);
            if (z) {
                this.pV.f(b);
                this.pV.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.pV.dw();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File a2;
        try {
            try {
                a2 = this.pL.a(this.pV.dz(), this.pV.getName(), false, this.pV.dE(), this.pV.dF());
            } catch (Exception e) {
                e.getMessage();
                this.pV.dw();
                z = false;
            }
            if (a2 == null || this.pU.get()) {
                return false;
            }
            z = a2.exists() ? a2.delete() : false;
            if (z) {
                this.pV.f(a2);
                this.pV.setSuccess(true);
            }
            return z;
        } finally {
            this.pV.dw();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean ds() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File a2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            a2 = this.pL.a(this.pV.dz(), this.pV.getName(), false, this.pV.dE(), this.pV.dF());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (a2 == null || !a2.exists() || this.pU.get()) {
            com.baidu.adp.lib.g.a.d(null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.pV.dw();
            return false;
        }
        fileInputStream = new FileInputStream(a2);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.pU.get()) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                try {
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.d(fileInputStream2);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    this.pV.dw();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.pV.dw();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.pV.dw();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.pU.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.pV.dC() || this.pV.j(byteArray)) {
                this.pV.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.pV.setSuccess(true);
                }
                this.pV.dw();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.d(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.pV.dw();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean s(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File a2;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = this.pL.a(this.pV.dz(), this.pV.getName(), true, this.pV.dE(), this.pV.dF());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.pV.dw();
            throw th;
        }
        if (a2 == null || this.pU.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.pV.dw();
            return false;
        }
        if (a2.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.pV.dw();
                return true;
            }
            a2.delete();
        }
        byte[] dy = this.pV.dy();
        byte[] data = this.pV.getData();
        if ((dy == null && data == null) || this.pU.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.pV.dw();
            return false;
        }
        fileOutputStream = new FileOutputStream(a2);
        if (dy != null) {
            try {
                try {
                    fileOutputStream.write(dy);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    this.pV.dw();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.pV.dw();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.pV.f(a2);
        this.pV.setSuccess(true);
        this.pV.dw();
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
        byte[] dy;
        byte[] data;
        OutputStream outputStream2 = this.pV.getOutputStream();
        File dD = this.pV.dD();
        if (outputStream2 == null) {
            try {
                dD = this.pL.a(this.pV.dz(), this.pV.getName(), true, this.pV.dE(), this.pV.dF());
                if (dD == null || this.pU.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.pV.dw();
                    return false;
                }
                outputStream = new FileOutputStream(dD, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.pV.dw();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.pV.dw();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                dy = this.pV.dy();
                data = this.pV.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.pV.dw();
                z2 = false;
                return z2;
            }
            if ((dy == null && data == null) || this.pU.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.pV.dw();
                return false;
            }
            if (dy != null) {
                outputStream.write(dy);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.pV.f(dD);
            this.pV.setSuccess(true);
            if (z) {
                this.pV.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.pV.dw();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.pV.dw();
            throw th;
        }
    }

    public boolean dt() {
        File b;
        if (this.pV.getName() != null) {
            b = this.pL.a(this.pV.dz(), this.pV.getName(), false, this.pV.dE(), this.pV.dF());
        } else {
            b = this.pL.b(this.pV.dz(), false, this.pV.dE(), this.pV.dF());
        }
        if (b != null && b.exists()) {
            this.pV.f(b);
            this.pV.setSuccess(true);
            this.pV.dw();
            return true;
        }
        this.pV.dw();
        return false;
    }

    public boolean du() {
        boolean z;
        try {
            File a2 = this.pL.a(this.pV.dz(), this.pV.getName(), false, this.pV.dE(), this.pV.dF());
            File a3 = this.pL.a(this.pV.dA(), this.pV.dI(), true, this.pV.dE(), this.pV.dF());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            } else {
                z = false;
            }
            if (z) {
                this.pV.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.pV.dw();
        }
    }

    public boolean dv() {
        boolean z = false;
        try {
            if (this.pV.dJ() != null) {
                z = this.pV.dJ().a(this, this.pV, this.pL);
            }
            if (z) {
                this.pV.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.pV.dw();
        }
        return z;
    }
}
