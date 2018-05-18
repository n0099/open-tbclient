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
    protected b pK;
    protected AtomicBoolean pT;
    private DiskFileOperate pU;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.pT.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.pK = null;
        this.pT = null;
        this.pU = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.dx() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.pT = new AtomicBoolean(false);
        this.pK = bVar;
        this.pU = diskFileOperate;
    }

    public boolean dq() {
        switch (this.pU.dx()) {
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
        if (file == null || !(this.pU instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.pU;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.pT.get(); i++) {
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
            File b = this.pK.b(this.pU.getPath(), false, this.pU.dE(), this.pU.dF());
            z = e(b);
            if (z) {
                this.pU.f(b);
                this.pU.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.pU.dw();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File a2;
        try {
            try {
                a2 = this.pK.a(this.pU.dz(), this.pU.getName(), false, this.pU.dE(), this.pU.dF());
            } catch (Exception e) {
                e.getMessage();
                this.pU.dw();
                z = false;
            }
            if (a2 == null || this.pT.get()) {
                return false;
            }
            z = a2.exists() ? a2.delete() : false;
            if (z) {
                this.pU.f(a2);
                this.pU.setSuccess(true);
            }
            return z;
        } finally {
            this.pU.dw();
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
            a2 = this.pK.a(this.pU.dz(), this.pU.getName(), false, this.pU.dE(), this.pU.dF());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (a2 == null || !a2.exists() || this.pT.get()) {
            com.baidu.adp.lib.g.a.d(null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.pU.dw();
            return false;
        }
        fileInputStream = new FileInputStream(a2);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.pT.get()) {
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
                    this.pU.dw();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.pU.dw();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.pU.dw();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.pT.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.pU.dC() || this.pU.j(byteArray)) {
                this.pU.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.pU.setSuccess(true);
                }
                this.pU.dw();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.d(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.pU.dw();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean s(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File a2;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = this.pK.a(this.pU.dz(), this.pU.getName(), true, this.pU.dE(), this.pU.dF());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.pU.dw();
            throw th;
        }
        if (a2 == null || this.pT.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.pU.dw();
            return false;
        }
        if (a2.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.pU.dw();
                return true;
            }
            a2.delete();
        }
        byte[] dy = this.pU.dy();
        byte[] data = this.pU.getData();
        if ((dy == null && data == null) || this.pT.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.pU.dw();
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
                    this.pU.dw();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.pU.dw();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.pU.f(a2);
        this.pU.setSuccess(true);
        this.pU.dw();
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
        OutputStream outputStream2 = this.pU.getOutputStream();
        File dD = this.pU.dD();
        if (outputStream2 == null) {
            try {
                dD = this.pK.a(this.pU.dz(), this.pU.getName(), true, this.pU.dE(), this.pU.dF());
                if (dD == null || this.pT.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.pU.dw();
                    return false;
                }
                outputStream = new FileOutputStream(dD, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.pU.dw();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.pU.dw();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                dy = this.pU.dy();
                data = this.pU.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.pU.dw();
                z2 = false;
                return z2;
            }
            if ((dy == null && data == null) || this.pT.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.pU.dw();
                return false;
            }
            if (dy != null) {
                outputStream.write(dy);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.pU.f(dD);
            this.pU.setSuccess(true);
            if (z) {
                this.pU.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.pU.dw();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.pU.dw();
            throw th;
        }
    }

    public boolean dt() {
        File b;
        if (this.pU.getName() != null) {
            b = this.pK.a(this.pU.dz(), this.pU.getName(), false, this.pU.dE(), this.pU.dF());
        } else {
            b = this.pK.b(this.pU.dz(), false, this.pU.dE(), this.pU.dF());
        }
        if (b != null && b.exists()) {
            this.pU.f(b);
            this.pU.setSuccess(true);
            this.pU.dw();
            return true;
        }
        this.pU.dw();
        return false;
    }

    public boolean du() {
        boolean z;
        try {
            File a2 = this.pK.a(this.pU.dz(), this.pU.getName(), false, this.pU.dE(), this.pU.dF());
            File a3 = this.pK.a(this.pU.dA(), this.pU.dI(), true, this.pU.dE(), this.pU.dF());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            } else {
                z = false;
            }
            if (z) {
                this.pU.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.pU.dw();
        }
    }

    public boolean dv() {
        boolean z = false;
        try {
            if (this.pU.dJ() != null) {
                z = this.pU.dJ().a(this, this.pU, this.pK);
            }
            if (z) {
                this.pU.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.pU.dw();
        }
        return z;
    }
}
