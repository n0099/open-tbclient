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
    protected b yY;
    protected AtomicBoolean zh;
    private DiskFileOperate zi;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.zh.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.yY = null;
        this.zh = null;
        this.zi = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.hI() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.zh = new AtomicBoolean(false);
        this.yY = bVar;
        this.zi = diskFileOperate;
    }

    public boolean hC() {
        switch (this.zi.hI()) {
            case WRITE:
                return P(false);
            case WRITE_FORCE:
                return P(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return hD();
            case APPEND:
                return Q(false);
            case APPEND_MORE:
                return Q(true);
            case INFO:
                return hF();
            case RENAME:
                return hG();
            case READ:
                return hE();
            case CUSTOM:
                return hH();
            default:
                return false;
        }
    }

    private boolean k(File file) {
        if (file == null || !(this.zi instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.zi;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.zh.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        k(listFiles[i]);
                    } else if (aVar.j(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (aVar.j(file)) {
            file.delete();
        }
        return true;
    }

    private boolean hD() {
        boolean z = false;
        try {
            File b = this.yY.b(this.zi.getPath(), false, this.zi.hP(), this.zi.hQ());
            z = k(b);
            if (z) {
                this.zi.l(b);
                this.zi.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.zi.unLock();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File b;
        try {
            try {
                b = this.yY.b(this.zi.hK(), this.zi.getName(), false, this.zi.hP(), this.zi.hQ());
            } catch (Exception e) {
                e.getMessage();
                this.zi.unLock();
                z = false;
            }
            if (b == null || this.zh.get()) {
                return false;
            }
            z = b.exists() ? b.delete() : false;
            if (z) {
                this.zi.l(b);
                this.zi.setSuccess(true);
            }
            return z;
        } finally {
            this.zi.unLock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean hE() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File b;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            b = this.yY.b(this.zi.hK(), this.zi.getName(), false, this.zi.hP(), this.zi.hQ());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (b == null || !b.exists() || this.zh.get()) {
            com.baidu.adp.lib.g.a.h((InputStream) null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.zi.unLock();
            return false;
        }
        fileInputStream = new FileInputStream(b);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.zh.get()) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                try {
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.h(fileInputStream2);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    this.zi.unLock();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.h(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.zi.unLock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.h(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.zi.unLock();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.zh.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.zi.hN() || this.zi.p(byteArray)) {
                this.zi.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.h(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.zi.setSuccess(true);
                }
                this.zi.unLock();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.h(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.zi.unLock();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean P(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File b;
        FileOutputStream fileOutputStream2 = null;
        try {
            b = this.yY.b(this.zi.hK(), this.zi.getName(), true, this.zi.hP(), this.zi.hQ());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.zi.unLock();
            throw th;
        }
        if (b == null || this.zh.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.zi.unLock();
            return false;
        }
        if (b.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.zi.unLock();
                return true;
            }
            b.delete();
        }
        byte[] hJ = this.zi.hJ();
        byte[] data = this.zi.getData();
        if ((hJ == null && data == null) || this.zh.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.zi.unLock();
            return false;
        }
        fileOutputStream = new FileOutputStream(b);
        if (hJ != null) {
            try {
                try {
                    fileOutputStream.write(hJ);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    this.zi.unLock();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.zi.unLock();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.zi.l(b);
        this.zi.setSuccess(true);
        this.zi.unLock();
        z2 = true;
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=5, 300=5, 304=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Q(boolean z) {
        OutputStream outputStream;
        boolean z2;
        byte[] hJ;
        byte[] data;
        OutputStream outputStream2 = this.zi.getOutputStream();
        File hO = this.zi.hO();
        if (outputStream2 == null) {
            try {
                hO = this.yY.b(this.zi.hK(), this.zi.getName(), true, this.zi.hP(), this.zi.hQ());
                if (hO == null || this.zh.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.zi.unLock();
                    return false;
                }
                outputStream = new FileOutputStream(hO, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.zi.unLock();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.zi.unLock();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                hJ = this.zi.hJ();
                data = this.zi.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.zi.unLock();
                z2 = false;
                return z2;
            }
            if ((hJ == null && data == null) || this.zh.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.zi.unLock();
                return false;
            }
            if (hJ != null) {
                outputStream.write(hJ);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.zi.l(hO);
            this.zi.setSuccess(true);
            if (z) {
                this.zi.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.zi.unLock();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.zi.unLock();
            throw th;
        }
    }

    public boolean hF() {
        File b;
        if (this.zi.getName() != null) {
            b = this.yY.b(this.zi.hK(), this.zi.getName(), false, this.zi.hP(), this.zi.hQ());
        } else {
            b = this.yY.b(this.zi.hK(), false, this.zi.hP(), this.zi.hQ());
        }
        if (b != null && b.exists()) {
            this.zi.l(b);
            this.zi.setSuccess(true);
            this.zi.unLock();
            return true;
        }
        this.zi.unLock();
        return false;
    }

    public boolean hG() {
        boolean z;
        try {
            File b = this.yY.b(this.zi.hK(), this.zi.getName(), false, this.zi.hP(), this.zi.hQ());
            File b2 = this.yY.b(this.zi.hL(), this.zi.hT(), true, this.zi.hP(), this.zi.hQ());
            if (b != null) {
                if (b2 != null) {
                    b2.delete();
                }
                z = b.renameTo(b2);
            } else {
                z = false;
            }
            if (z) {
                this.zi.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.zi.unLock();
        }
    }

    public boolean hH() {
        boolean z = false;
        try {
            if (this.zi.hU() != null) {
                z = this.zi.hU().a(this, this.zi, this.yY);
            }
            if (z) {
                this.zi.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.zi.unLock();
        }
        return z;
    }
}
