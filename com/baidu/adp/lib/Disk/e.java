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
    protected b yV;
    protected AtomicBoolean ze;
    private DiskFileOperate zf;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.ze.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.yV = null;
        this.ze = null;
        this.zf = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.hJ() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.ze = new AtomicBoolean(false);
        this.yV = bVar;
        this.zf = diskFileOperate;
    }

    public boolean hD() {
        switch (this.zf.hJ()) {
            case WRITE:
                return B(false);
            case WRITE_FORCE:
                return B(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return hE();
            case APPEND:
                return C(false);
            case APPEND_MORE:
                return C(true);
            case INFO:
                return hG();
            case RENAME:
                return hH();
            case READ:
                return hF();
            case CUSTOM:
                return hI();
            default:
                return false;
        }
    }

    private boolean k(File file) {
        if (file == null || !(this.zf instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.zf;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.ze.get(); i++) {
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

    private boolean hE() {
        boolean z = false;
        try {
            File b = this.yV.b(this.zf.getPath(), false, this.zf.hQ(), this.zf.hR());
            z = k(b);
            if (z) {
                this.zf.l(b);
                this.zf.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.zf.unLock();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File b;
        try {
            try {
                b = this.yV.b(this.zf.hL(), this.zf.getName(), false, this.zf.hQ(), this.zf.hR());
            } catch (Exception e) {
                e.getMessage();
                this.zf.unLock();
                z = false;
            }
            if (b == null || this.ze.get()) {
                return false;
            }
            z = b.exists() ? b.delete() : false;
            if (z) {
                this.zf.l(b);
                this.zf.setSuccess(true);
            }
            return z;
        } finally {
            this.zf.unLock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean hF() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File b;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            b = this.yV.b(this.zf.hL(), this.zf.getName(), false, this.zf.hQ(), this.zf.hR());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (b == null || !b.exists() || this.ze.get()) {
            com.baidu.adp.lib.g.a.h((InputStream) null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.zf.unLock();
            return false;
        }
        fileInputStream = new FileInputStream(b);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.ze.get()) {
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
                    this.zf.unLock();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.h(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.zf.unLock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.h(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.zf.unLock();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.ze.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.zf.hO() || this.zf.q(byteArray)) {
                this.zf.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.h(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.zf.setSuccess(true);
                }
                this.zf.unLock();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.h(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.zf.unLock();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean B(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File b;
        FileOutputStream fileOutputStream2 = null;
        try {
            b = this.yV.b(this.zf.hL(), this.zf.getName(), true, this.zf.hQ(), this.zf.hR());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.zf.unLock();
            throw th;
        }
        if (b == null || this.ze.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.zf.unLock();
            return false;
        }
        if (b.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.zf.unLock();
                return true;
            }
            b.delete();
        }
        byte[] hK = this.zf.hK();
        byte[] data = this.zf.getData();
        if ((hK == null && data == null) || this.ze.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.zf.unLock();
            return false;
        }
        fileOutputStream = new FileOutputStream(b);
        if (hK != null) {
            try {
                try {
                    fileOutputStream.write(hK);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    this.zf.unLock();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.zf.unLock();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.zf.l(b);
        this.zf.setSuccess(true);
        this.zf.unLock();
        z2 = true;
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=5, 300=5, 304=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean C(boolean z) {
        OutputStream outputStream;
        boolean z2;
        byte[] hK;
        byte[] data;
        OutputStream outputStream2 = this.zf.getOutputStream();
        File hP = this.zf.hP();
        if (outputStream2 == null) {
            try {
                hP = this.yV.b(this.zf.hL(), this.zf.getName(), true, this.zf.hQ(), this.zf.hR());
                if (hP == null || this.ze.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.zf.unLock();
                    return false;
                }
                outputStream = new FileOutputStream(hP, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.zf.unLock();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.zf.unLock();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                hK = this.zf.hK();
                data = this.zf.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.zf.unLock();
                z2 = false;
                return z2;
            }
            if ((hK == null && data == null) || this.ze.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.zf.unLock();
                return false;
            }
            if (hK != null) {
                outputStream.write(hK);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.zf.l(hP);
            this.zf.setSuccess(true);
            if (z) {
                this.zf.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.zf.unLock();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.zf.unLock();
            throw th;
        }
    }

    public boolean hG() {
        File b;
        if (this.zf.getName() != null) {
            b = this.yV.b(this.zf.hL(), this.zf.getName(), false, this.zf.hQ(), this.zf.hR());
        } else {
            b = this.yV.b(this.zf.hL(), false, this.zf.hQ(), this.zf.hR());
        }
        if (b != null && b.exists()) {
            this.zf.l(b);
            this.zf.setSuccess(true);
            this.zf.unLock();
            return true;
        }
        this.zf.unLock();
        return false;
    }

    public boolean hH() {
        boolean z;
        try {
            File b = this.yV.b(this.zf.hL(), this.zf.getName(), false, this.zf.hQ(), this.zf.hR());
            File b2 = this.yV.b(this.zf.hM(), this.zf.hU(), true, this.zf.hQ(), this.zf.hR());
            if (b != null) {
                if (b2 != null) {
                    b2.delete();
                }
                z = b.renameTo(b2);
            } else {
                z = false;
            }
            if (z) {
                this.zf.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.zf.unLock();
        }
    }

    public boolean hI() {
        boolean z = false;
        try {
            if (this.zf.hV() != null) {
                z = this.zf.hV().a(this, this.zf, this.yV);
            }
            if (z) {
                this.zf.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.zf.unLock();
        }
        return z;
    }
}
