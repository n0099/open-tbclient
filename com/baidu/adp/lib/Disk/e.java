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
    protected b wG;
    protected AtomicBoolean wP;
    private DiskFileOperate wQ;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.wP.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.wG = null;
        this.wP = null;
        this.wQ = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.gB() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.wP = new AtomicBoolean(false);
        this.wG = bVar;
        this.wQ = diskFileOperate;
    }

    public boolean gu() {
        switch (this.wQ.gB()) {
            case WRITE:
                return H(false);
            case WRITE_FORCE:
                return H(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return gv();
            case APPEND:
                return I(false);
            case APPEND_MORE:
                return I(true);
            case INFO:
                return gx();
            case RENAME:
                return gy();
            case READ:
                return gw();
            case CUSTOM:
                return gz();
            default:
                return false;
        }
    }

    private boolean f(File file) {
        if (file == null || !(this.wQ instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.wQ;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.wP.get(); i++) {
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

    private boolean gv() {
        boolean z = false;
        try {
            File b = this.wG.b(this.wQ.getPath(), false, this.wQ.gI(), this.wQ.gJ());
            z = f(b);
            if (z) {
                this.wQ.g(b);
                this.wQ.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.wQ.gA();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File b;
        try {
            try {
                b = this.wG.b(this.wQ.gD(), this.wQ.getName(), false, this.wQ.gI(), this.wQ.gJ());
            } catch (Exception e) {
                e.getMessage();
                this.wQ.gA();
                z = false;
            }
            if (b == null || this.wP.get()) {
                return false;
            }
            z = b.exists() ? b.delete() : false;
            if (z) {
                this.wQ.g(b);
                this.wQ.setSuccess(true);
            }
            return z;
        } finally {
            this.wQ.gA();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean gw() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File b;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            b = this.wG.b(this.wQ.gD(), this.wQ.getName(), false, this.wQ.gI(), this.wQ.gJ());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (b == null || !b.exists() || this.wP.get()) {
            com.baidu.adp.lib.g.a.g(null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wQ.gA();
            return false;
        }
        fileInputStream = new FileInputStream(b);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.wP.get()) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                try {
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.g(fileInputStream2);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    this.wQ.gA();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.g(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.wQ.gA();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.g(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.wQ.gA();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.wP.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.wQ.gG() || this.wQ.i(byteArray)) {
                this.wQ.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.g(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.wQ.setSuccess(true);
                }
                this.wQ.gA();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.g(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.wQ.gA();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean H(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File b;
        FileOutputStream fileOutputStream2 = null;
        try {
            b = this.wG.b(this.wQ.gD(), this.wQ.getName(), true, this.wQ.gI(), this.wQ.gJ());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.wQ.gA();
            throw th;
        }
        if (b == null || this.wP.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wQ.gA();
            return false;
        }
        if (b.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.wQ.gA();
                return true;
            }
            b.delete();
        }
        byte[] gC = this.wQ.gC();
        byte[] data = this.wQ.getData();
        if ((gC == null && data == null) || this.wP.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.wQ.gA();
            return false;
        }
        fileOutputStream = new FileOutputStream(b);
        if (gC != null) {
            try {
                try {
                    fileOutputStream.write(gC);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    this.wQ.gA();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.wQ.gA();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.wQ.g(b);
        this.wQ.setSuccess(true);
        this.wQ.gA();
        z2 = true;
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=5, 300=5, 304=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean I(boolean z) {
        OutputStream outputStream;
        boolean z2;
        byte[] gC;
        byte[] data;
        OutputStream outputStream2 = this.wQ.getOutputStream();
        File gH = this.wQ.gH();
        if (outputStream2 == null) {
            try {
                gH = this.wG.b(this.wQ.gD(), this.wQ.getName(), true, this.wQ.gI(), this.wQ.gJ());
                if (gH == null || this.wP.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.wQ.gA();
                    return false;
                }
                outputStream = new FileOutputStream(gH, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.wQ.gA();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.wQ.gA();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                gC = this.wQ.gC();
                data = this.wQ.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.wQ.gA();
                z2 = false;
                return z2;
            }
            if ((gC == null && data == null) || this.wP.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.wQ.gA();
                return false;
            }
            if (gC != null) {
                outputStream.write(gC);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.wQ.g(gH);
            this.wQ.setSuccess(true);
            if (z) {
                this.wQ.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.wQ.gA();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.wQ.gA();
            throw th;
        }
    }

    public boolean gx() {
        File b;
        if (this.wQ.getName() != null) {
            b = this.wG.b(this.wQ.gD(), this.wQ.getName(), false, this.wQ.gI(), this.wQ.gJ());
        } else {
            b = this.wG.b(this.wQ.gD(), false, this.wQ.gI(), this.wQ.gJ());
        }
        if (b != null && b.exists()) {
            this.wQ.g(b);
            this.wQ.setSuccess(true);
            this.wQ.gA();
            return true;
        }
        this.wQ.gA();
        return false;
    }

    public boolean gy() {
        boolean z;
        try {
            File b = this.wG.b(this.wQ.gD(), this.wQ.getName(), false, this.wQ.gI(), this.wQ.gJ());
            File b2 = this.wG.b(this.wQ.gE(), this.wQ.gM(), true, this.wQ.gI(), this.wQ.gJ());
            if (b != null) {
                if (b2 != null) {
                    b2.delete();
                }
                z = b.renameTo(b2);
            } else {
                z = false;
            }
            if (z) {
                this.wQ.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.wQ.gA();
        }
    }

    public boolean gz() {
        boolean z = false;
        try {
            if (this.wQ.gN() != null) {
                z = this.wQ.gN().a(this, this.wQ, this.wG);
            }
            if (z) {
                this.wQ.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.wQ.gA();
        }
        return z;
    }
}
