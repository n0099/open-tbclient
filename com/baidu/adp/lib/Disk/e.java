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
    protected AtomicBoolean afE;
    private DiskFileOperate afF;
    protected b afv;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.afE.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.afv = null;
        this.afE = null;
        this.afF = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.lt() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.afE = new AtomicBoolean(false);
        this.afv = bVar;
        this.afF = diskFileOperate;
    }

    public boolean lm() {
        switch (this.afF.lt()) {
            case WRITE:
                return X(false);
            case WRITE_FORCE:
                return X(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return ln();
            case APPEND:
                return Y(false);
            case APPEND_MORE:
                return Y(true);
            case INFO:
                return lp();
            case RENAME:
                return lq();
            case READ:
                return lo();
            case CUSTOM:
                return lr();
            default:
                return false;
        }
    }

    private boolean e(File file) {
        if (file == null || !(this.afF instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.afF;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.afE.get(); i++) {
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

    private boolean ln() {
        boolean z = false;
        try {
            File b = this.afv.b(this.afF.getPath(), false, this.afF.lA(), this.afF.lB());
            z = e(b);
            if (z) {
                this.afF.f(b);
                this.afF.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.afF.ls();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File a2;
        try {
            try {
                a2 = this.afv.a(this.afF.lv(), this.afF.getName(), false, this.afF.lA(), this.afF.lB());
            } catch (Exception e) {
                e.getMessage();
                this.afF.ls();
                z = false;
            }
            if (a2 == null || this.afE.get()) {
                return false;
            }
            z = a2.exists() ? a2.delete() : false;
            if (z) {
                this.afF.f(a2);
                this.afF.setSuccess(true);
            }
            return z;
        } finally {
            this.afF.ls();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean lo() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File a2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            a2 = this.afv.a(this.afF.lv(), this.afF.getName(), false, this.afF.lA(), this.afF.lB());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (a2 == null || !a2.exists() || this.afE.get()) {
            com.baidu.adp.lib.g.a.d(null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.afF.ls();
            return false;
        }
        fileInputStream = new FileInputStream(a2);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.afE.get()) {
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
                    this.afF.ls();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.afF.ls();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.afF.ls();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.afE.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.afF.ly() || this.afF.h(byteArray)) {
                this.afF.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.afF.setSuccess(true);
                }
                this.afF.ls();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.d(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.afF.ls();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean X(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File a2;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = this.afv.a(this.afF.lv(), this.afF.getName(), true, this.afF.lA(), this.afF.lB());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.afF.ls();
            throw th;
        }
        if (a2 == null || this.afE.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.afF.ls();
            return false;
        }
        if (a2.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.afF.ls();
                return true;
            }
            a2.delete();
        }
        byte[] lu = this.afF.lu();
        byte[] data = this.afF.getData();
        if ((lu == null && data == null) || this.afE.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.afF.ls();
            return false;
        }
        fileOutputStream = new FileOutputStream(a2);
        if (lu != null) {
            try {
                try {
                    fileOutputStream.write(lu);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    this.afF.ls();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.afF.ls();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.afF.f(a2);
        this.afF.setSuccess(true);
        this.afF.ls();
        z2 = true;
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=5, 300=5, 304=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Y(boolean z) {
        OutputStream outputStream;
        boolean z2;
        byte[] lu;
        byte[] data;
        OutputStream outputStream2 = this.afF.getOutputStream();
        File lz = this.afF.lz();
        if (outputStream2 == null) {
            try {
                lz = this.afv.a(this.afF.lv(), this.afF.getName(), true, this.afF.lA(), this.afF.lB());
                if (lz == null || this.afE.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.afF.ls();
                    return false;
                }
                outputStream = new FileOutputStream(lz, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.afF.ls();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.afF.ls();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                lu = this.afF.lu();
                data = this.afF.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.afF.ls();
                z2 = false;
                return z2;
            }
            if ((lu == null && data == null) || this.afE.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.afF.ls();
                return false;
            }
            if (lu != null) {
                outputStream.write(lu);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.afF.f(lz);
            this.afF.setSuccess(true);
            if (z) {
                this.afF.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.afF.ls();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.afF.ls();
            throw th;
        }
    }

    public boolean lp() {
        File b;
        if (this.afF.getName() != null) {
            b = this.afv.a(this.afF.lv(), this.afF.getName(), false, this.afF.lA(), this.afF.lB());
        } else {
            b = this.afv.b(this.afF.lv(), false, this.afF.lA(), this.afF.lB());
        }
        if (b != null && b.exists()) {
            this.afF.f(b);
            this.afF.setSuccess(true);
            this.afF.ls();
            return true;
        }
        this.afF.ls();
        return false;
    }

    public boolean lq() {
        boolean z;
        try {
            File a2 = this.afv.a(this.afF.lv(), this.afF.getName(), false, this.afF.lA(), this.afF.lB());
            File a3 = this.afv.a(this.afF.lw(), this.afF.lE(), true, this.afF.lA(), this.afF.lB());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            } else {
                z = false;
            }
            if (z) {
                this.afF.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.afF.ls();
        }
    }

    public boolean lr() {
        boolean z = false;
        try {
            if (this.afF.lF() != null) {
                z = this.afF.lF().a(this, this.afF, this.afv);
            }
            if (z) {
                this.afF.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.afF.ls();
        }
        return z;
    }
}
