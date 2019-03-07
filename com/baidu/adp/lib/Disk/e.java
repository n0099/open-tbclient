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
    protected b yW;
    protected AtomicBoolean zf;
    private DiskFileOperate zg;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.zf.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.yW = null;
        this.zf = null;
        this.zg = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.hH() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.zf = new AtomicBoolean(false);
        this.yW = bVar;
        this.zg = diskFileOperate;
    }

    public boolean hA() {
        switch (this.zg.hH()) {
            case WRITE:
                return P(false);
            case WRITE_FORCE:
                return P(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return hB();
            case APPEND:
                return Q(false);
            case APPEND_MORE:
                return Q(true);
            case INFO:
                return hD();
            case RENAME:
                return hE();
            case READ:
                return hC();
            case CUSTOM:
                return hF();
            default:
                return false;
        }
    }

    private boolean l(File file) {
        if (file == null || !(this.zg instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.zg;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.zf.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        l(listFiles[i]);
                    } else if (aVar.k(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (aVar.k(file)) {
            file.delete();
        }
        return true;
    }

    private boolean hB() {
        boolean z = false;
        try {
            File b = this.yW.b(this.zg.getPath(), false, this.zg.hO(), this.zg.hP());
            z = l(b);
            if (z) {
                this.zg.m(b);
                this.zg.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.zg.hG();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File b;
        try {
            try {
                b = this.yW.b(this.zg.hJ(), this.zg.getName(), false, this.zg.hO(), this.zg.hP());
            } catch (Exception e) {
                e.getMessage();
                this.zg.hG();
                z = false;
            }
            if (b == null || this.zf.get()) {
                return false;
            }
            z = b.exists() ? b.delete() : false;
            if (z) {
                this.zg.m(b);
                this.zg.setSuccess(true);
            }
            return z;
        } finally {
            this.zg.hG();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean hC() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File b;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            b = this.yW.b(this.zg.hJ(), this.zg.getName(), false, this.zg.hO(), this.zg.hP());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (b == null || !b.exists() || this.zf.get()) {
            com.baidu.adp.lib.g.a.i(null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.zg.hG();
            return false;
        }
        fileInputStream = new FileInputStream(b);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.zf.get()) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                try {
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.i(fileInputStream2);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    this.zg.hG();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.i(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.zg.hG();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.i(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.zg.hG();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.zf.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.zg.hM() || this.zg.q(byteArray)) {
                this.zg.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.i(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.zg.setSuccess(true);
                }
                this.zg.hG();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.i(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.zg.hG();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean P(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File b;
        FileOutputStream fileOutputStream2 = null;
        try {
            b = this.yW.b(this.zg.hJ(), this.zg.getName(), true, this.zg.hO(), this.zg.hP());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.zg.hG();
            throw th;
        }
        if (b == null || this.zf.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.zg.hG();
            return false;
        }
        if (b.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.zg.hG();
                return true;
            }
            b.delete();
        }
        byte[] hI = this.zg.hI();
        byte[] data = this.zg.getData();
        if ((hI == null && data == null) || this.zf.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.zg.hG();
            return false;
        }
        fileOutputStream = new FileOutputStream(b);
        if (hI != null) {
            try {
                try {
                    fileOutputStream.write(hI);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    this.zg.hG();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.zg.hG();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.zg.m(b);
        this.zg.setSuccess(true);
        this.zg.hG();
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
        byte[] hI;
        byte[] data;
        OutputStream outputStream2 = this.zg.getOutputStream();
        File hN = this.zg.hN();
        if (outputStream2 == null) {
            try {
                hN = this.yW.b(this.zg.hJ(), this.zg.getName(), true, this.zg.hO(), this.zg.hP());
                if (hN == null || this.zf.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.zg.hG();
                    return false;
                }
                outputStream = new FileOutputStream(hN, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.zg.hG();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.zg.hG();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                hI = this.zg.hI();
                data = this.zg.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.zg.hG();
                z2 = false;
                return z2;
            }
            if ((hI == null && data == null) || this.zf.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.zg.hG();
                return false;
            }
            if (hI != null) {
                outputStream.write(hI);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.zg.m(hN);
            this.zg.setSuccess(true);
            if (z) {
                this.zg.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.zg.hG();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.zg.hG();
            throw th;
        }
    }

    public boolean hD() {
        File b;
        if (this.zg.getName() != null) {
            b = this.yW.b(this.zg.hJ(), this.zg.getName(), false, this.zg.hO(), this.zg.hP());
        } else {
            b = this.yW.b(this.zg.hJ(), false, this.zg.hO(), this.zg.hP());
        }
        if (b != null && b.exists()) {
            this.zg.m(b);
            this.zg.setSuccess(true);
            this.zg.hG();
            return true;
        }
        this.zg.hG();
        return false;
    }

    public boolean hE() {
        boolean z;
        try {
            File b = this.yW.b(this.zg.hJ(), this.zg.getName(), false, this.zg.hO(), this.zg.hP());
            File b2 = this.yW.b(this.zg.hK(), this.zg.hS(), true, this.zg.hO(), this.zg.hP());
            if (b != null) {
                if (b2 != null) {
                    b2.delete();
                }
                z = b.renameTo(b2);
            } else {
                z = false;
            }
            if (z) {
                this.zg.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.zg.hG();
        }
    }

    public boolean hF() {
        boolean z = false;
        try {
            if (this.zg.hT() != null) {
                z = this.zg.hT().a(this, this.zg, this.yW);
            }
            if (z) {
                this.zg.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.zg.hG();
        }
        return z;
    }
}
