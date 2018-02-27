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
    protected b afn;
    protected AtomicBoolean afw;
    private DiskFileOperate afx;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.afw.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.afn = null;
        this.afw = null;
        this.afx = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.lt() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.afw = new AtomicBoolean(false);
        this.afn = bVar;
        this.afx = diskFileOperate;
    }

    public boolean lm() {
        switch (this.afx.lt()) {
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
        if (file == null || !(this.afx instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.afx;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.afw.get(); i++) {
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
            File b = this.afn.b(this.afx.getPath(), false, this.afx.lA(), this.afx.lB());
            z = f(b);
            if (z) {
                this.afx.g(b);
                this.afx.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.afx.ls();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File a2;
        try {
            try {
                a2 = this.afn.a(this.afx.lv(), this.afx.getName(), false, this.afx.lA(), this.afx.lB());
            } catch (Exception e) {
                e.getMessage();
                this.afx.ls();
                z = false;
            }
            if (a2 == null || this.afw.get()) {
                return false;
            }
            z = a2.exists() ? a2.delete() : false;
            if (z) {
                this.afx.g(a2);
                this.afx.setSuccess(true);
            }
            return z;
        } finally {
            this.afx.ls();
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
            a2 = this.afn.a(this.afx.lv(), this.afx.getName(), false, this.afx.lA(), this.afx.lB());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (a2 == null || !a2.exists() || this.afw.get()) {
            com.baidu.adp.lib.g.a.d(null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.afx.ls();
            return false;
        }
        fileInputStream = new FileInputStream(a2);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.afw.get()) {
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
                    this.afx.ls();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.afx.ls();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.afx.ls();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.afw.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.afx.ly() || this.afx.h(byteArray)) {
                this.afx.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.d(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.afx.setSuccess(true);
                }
                this.afx.ls();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.d(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.afx.ls();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean Z(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File a2;
        FileOutputStream fileOutputStream2 = null;
        try {
            a2 = this.afn.a(this.afx.lv(), this.afx.getName(), true, this.afx.lA(), this.afx.lB());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.afx.ls();
            throw th;
        }
        if (a2 == null || this.afw.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.afx.ls();
            return false;
        }
        if (a2.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.afx.ls();
                return true;
            }
            a2.delete();
        }
        byte[] lu = this.afx.lu();
        byte[] data = this.afx.getData();
        if ((lu == null && data == null) || this.afw.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.afx.ls();
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
                    this.afx.ls();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.afx.ls();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.afx.g(a2);
        this.afx.setSuccess(true);
        this.afx.ls();
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
        OutputStream outputStream2 = this.afx.getOutputStream();
        File lz = this.afx.lz();
        if (outputStream2 == null) {
            try {
                lz = this.afn.a(this.afx.lv(), this.afx.getName(), true, this.afx.lA(), this.afx.lB());
                if (lz == null || this.afw.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.afx.ls();
                    return false;
                }
                outputStream = new FileOutputStream(lz, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.afx.ls();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.afx.ls();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                lu = this.afx.lu();
                data = this.afx.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.afx.ls();
                z2 = false;
                return z2;
            }
            if ((lu == null && data == null) || this.afw.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.afx.ls();
                return false;
            }
            if (lu != null) {
                outputStream.write(lu);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.afx.g(lz);
            this.afx.setSuccess(true);
            if (z) {
                this.afx.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.afx.ls();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.afx.ls();
            throw th;
        }
    }

    public boolean lp() {
        File b;
        if (this.afx.getName() != null) {
            b = this.afn.a(this.afx.lv(), this.afx.getName(), false, this.afx.lA(), this.afx.lB());
        } else {
            b = this.afn.b(this.afx.lv(), false, this.afx.lA(), this.afx.lB());
        }
        if (b != null && b.exists()) {
            this.afx.g(b);
            this.afx.setSuccess(true);
            this.afx.ls();
            return true;
        }
        this.afx.ls();
        return false;
    }

    public boolean lq() {
        boolean z;
        try {
            File a2 = this.afn.a(this.afx.lv(), this.afx.getName(), false, this.afx.lA(), this.afx.lB());
            File a3 = this.afn.a(this.afx.lw(), this.afx.lE(), true, this.afx.lA(), this.afx.lB());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            } else {
                z = false;
            }
            if (z) {
                this.afx.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.afx.ls();
        }
    }

    public boolean lr() {
        boolean z = false;
        try {
            if (this.afx.lF() != null) {
                z = this.afx.lF().a(this, this.afx, this.afn);
            }
            if (z) {
                this.afx.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.afx.ls();
        }
        return z;
    }
}
