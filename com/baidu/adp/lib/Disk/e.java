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
    protected AtomicBoolean afC;
    private DiskFileOperate afD;
    protected b aft;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.afC.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.aft = null;
        this.afC = null;
        this.afD = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.lt() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.afC = new AtomicBoolean(false);
        this.aft = bVar;
        this.afD = diskFileOperate;
    }

    public boolean lm() {
        switch (this.afD.lt()) {
            case WRITE:
                return Z(false);
            case WRITE_FORCE:
                return Z(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return ln();
            case APPEND:
                return aa(false);
            case APPEND_MORE:
                return aa(true);
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

    private boolean f(File file) {
        if (file == null || !(this.afD instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.afD;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.afC.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        f(listFiles[i]);
                    } else if (aVar.e(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (aVar.e(file)) {
            file.delete();
        }
        return true;
    }

    private boolean ln() {
        boolean z = false;
        try {
            File b = this.aft.b(this.afD.getPath(), false, this.afD.lA(), this.afD.lB());
            z = f(b);
            if (z) {
                this.afD.g(b);
                this.afD.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.afD.ls();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File a2;
        try {
            try {
                a2 = this.aft.a(this.afD.lv(), this.afD.getName(), false, this.afD.lA(), this.afD.lB());
            } catch (Exception e) {
                e.getMessage();
                this.afD.ls();
                z = false;
            }
            if (a2 == null || this.afC.get()) {
                return false;
            }
            z = a2.exists() ? a2.delete() : false;
            if (z) {
                this.afD.g(a2);
                this.afD.setSuccess(true);
            }
            return z;
        } finally {
            this.afD.ls();
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
            a2 = this.aft.a(this.afD.lv(), this.afD.getName(), false, this.afD.lA(), this.afD.lB());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (a2 == null || !a2.exists() || this.afC.get()) {
            com.baidu.adp.lib.g.a.d(null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.afD.ls();
            return false;
        }
        fileInputStream = new FileInputStream(a2);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.afC.get()) {
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
                    this.afD.ls();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.afD.ls();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.afD.ls();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.afC.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.afD.ly() || this.afD.h(byteArray)) {
                this.afD.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.afD.setSuccess(true);
                }
                this.afD.ls();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.d(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.afD.ls();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean Z(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File a2;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = this.aft.a(this.afD.lv(), this.afD.getName(), true, this.afD.lA(), this.afD.lB());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.afD.ls();
            throw th;
        }
        if (a2 == null || this.afC.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.afD.ls();
            return false;
        }
        if (a2.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.afD.ls();
                return true;
            }
            a2.delete();
        }
        byte[] lu = this.afD.lu();
        byte[] data = this.afD.getData();
        if ((lu == null && data == null) || this.afC.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.afD.ls();
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
                    this.afD.ls();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.afD.ls();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.afD.g(a2);
        this.afD.setSuccess(true);
        this.afD.ls();
        z2 = true;
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=5, 300=5, 304=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean aa(boolean z) {
        OutputStream outputStream;
        boolean z2;
        byte[] lu;
        byte[] data;
        OutputStream outputStream2 = this.afD.getOutputStream();
        File lz = this.afD.lz();
        if (outputStream2 == null) {
            try {
                lz = this.aft.a(this.afD.lv(), this.afD.getName(), true, this.afD.lA(), this.afD.lB());
                if (lz == null || this.afC.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.afD.ls();
                    return false;
                }
                outputStream = new FileOutputStream(lz, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.afD.ls();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.afD.ls();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                lu = this.afD.lu();
                data = this.afD.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.afD.ls();
                z2 = false;
                return z2;
            }
            if ((lu == null && data == null) || this.afC.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.afD.ls();
                return false;
            }
            if (lu != null) {
                outputStream.write(lu);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.afD.g(lz);
            this.afD.setSuccess(true);
            if (z) {
                this.afD.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.afD.ls();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.afD.ls();
            throw th;
        }
    }

    public boolean lp() {
        File b;
        if (this.afD.getName() != null) {
            b = this.aft.a(this.afD.lv(), this.afD.getName(), false, this.afD.lA(), this.afD.lB());
        } else {
            b = this.aft.b(this.afD.lv(), false, this.afD.lA(), this.afD.lB());
        }
        if (b != null && b.exists()) {
            this.afD.g(b);
            this.afD.setSuccess(true);
            this.afD.ls();
            return true;
        }
        this.afD.ls();
        return false;
    }

    public boolean lq() {
        boolean z;
        try {
            File a2 = this.aft.a(this.afD.lv(), this.afD.getName(), false, this.afD.lA(), this.afD.lB());
            File a3 = this.aft.a(this.afD.lw(), this.afD.lE(), true, this.afD.lA(), this.afD.lB());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            } else {
                z = false;
            }
            if (z) {
                this.afD.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.afD.ls();
        }
    }

    public boolean lr() {
        boolean z = false;
        try {
            if (this.afD.lF() != null) {
                z = this.afD.lF().a(this, this.afD, this.aft);
            }
            if (z) {
                this.afD.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.afD.ls();
        }
        return z;
    }
}
