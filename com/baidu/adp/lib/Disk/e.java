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
    protected b wI;
    protected AtomicBoolean wR;
    private DiskFileOperate wS;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.wR.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.wI = null;
        this.wR = null;
        this.wS = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.gK() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.wR = new AtomicBoolean(false);
        this.wI = bVar;
        this.wS = diskFileOperate;
    }

    public boolean gD() {
        switch (this.wS.gK()) {
            case WRITE:
                return H(false);
            case WRITE_FORCE:
                return H(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return gE();
            case APPEND:
                return I(false);
            case APPEND_MORE:
                return I(true);
            case INFO:
                return gG();
            case RENAME:
                return gH();
            case READ:
                return gF();
            case CUSTOM:
                return gI();
            default:
                return false;
        }
    }

    private boolean f(File file) {
        if (file == null || !(this.wS instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.wS;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.wR.get(); i++) {
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

    private boolean gE() {
        boolean z = false;
        try {
            File b = this.wI.b(this.wS.getPath(), false, this.wS.gR(), this.wS.gS());
            z = f(b);
            if (z) {
                this.wS.g(b);
                this.wS.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.wS.gJ();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File b;
        try {
            try {
                b = this.wI.b(this.wS.gM(), this.wS.getName(), false, this.wS.gR(), this.wS.gS());
            } catch (Exception e) {
                e.getMessage();
                this.wS.gJ();
                z = false;
            }
            if (b == null || this.wR.get()) {
                return false;
            }
            z = b.exists() ? b.delete() : false;
            if (z) {
                this.wS.g(b);
                this.wS.setSuccess(true);
            }
            return z;
        } finally {
            this.wS.gJ();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean gF() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File b;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            b = this.wI.b(this.wS.gM(), this.wS.getName(), false, this.wS.gR(), this.wS.gS());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (b == null || !b.exists() || this.wR.get()) {
            com.baidu.adp.lib.g.a.g(null);
            com.baidu.adp.lib.g.a.c(null);
            this.wS.gJ();
            return false;
        }
        fileInputStream = new FileInputStream(b);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.wR.get()) {
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
                    com.baidu.adp.lib.g.a.c(byteArrayOutputStream);
                    this.wS.gJ();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.g(fileInputStream);
                    com.baidu.adp.lib.g.a.c(byteArrayOutputStream2);
                    this.wS.gJ();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.g(fileInputStream);
                com.baidu.adp.lib.g.a.c(byteArrayOutputStream2);
                this.wS.gJ();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.wR.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.wS.gP() || this.wS.i(byteArray)) {
                this.wS.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.g(fileInputStream);
                com.baidu.adp.lib.g.a.c(byteArrayOutputStream);
                if (z) {
                    this.wS.setSuccess(true);
                }
                this.wS.gJ();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.g(fileInputStream);
        com.baidu.adp.lib.g.a.c(byteArrayOutputStream);
        if (z) {
        }
        this.wS.gJ();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean H(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File b;
        FileOutputStream fileOutputStream2 = null;
        try {
            b = this.wI.b(this.wS.gM(), this.wS.getName(), true, this.wS.gR(), this.wS.gS());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.c(fileOutputStream2);
            this.wS.gJ();
            throw th;
        }
        if (b == null || this.wR.get()) {
            com.baidu.adp.lib.g.a.c(null);
            this.wS.gJ();
            return false;
        }
        if (b.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.c(null);
                this.wS.gJ();
                return true;
            }
            b.delete();
        }
        byte[] gL = this.wS.gL();
        byte[] data = this.wS.getData();
        if ((gL == null && data == null) || this.wR.get()) {
            com.baidu.adp.lib.g.a.c(null);
            this.wS.gJ();
            return false;
        }
        fileOutputStream = new FileOutputStream(b);
        if (gL != null) {
            try {
                try {
                    fileOutputStream.write(gL);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.c(fileOutputStream);
                    this.wS.gJ();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.c(fileOutputStream2);
                this.wS.gJ();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.c(fileOutputStream);
        this.wS.g(b);
        this.wS.setSuccess(true);
        this.wS.gJ();
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
        byte[] gL;
        byte[] data;
        OutputStream outputStream2 = this.wS.getOutputStream();
        File gQ = this.wS.gQ();
        if (outputStream2 == null) {
            try {
                gQ = this.wI.b(this.wS.gM(), this.wS.getName(), true, this.wS.gR(), this.wS.gS());
                if (gQ == null || this.wR.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.c(outputStream2);
                    }
                    this.wS.gJ();
                    return false;
                }
                outputStream = new FileOutputStream(gQ, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.wS.gJ();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.wS.gJ();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                gL = this.wS.gL();
                data = this.wS.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.c(outputStream);
                }
                this.wS.gJ();
                z2 = false;
                return z2;
            }
            if ((gL == null && data == null) || this.wR.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.c(outputStream);
                }
                this.wS.gJ();
                return false;
            }
            if (gL != null) {
                outputStream.write(gL);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.wS.g(gQ);
            this.wS.setSuccess(true);
            if (z) {
                this.wS.b(outputStream);
            } else {
                com.baidu.adp.lib.g.a.c(outputStream);
            }
            this.wS.gJ();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.c(outputStream2);
            }
            this.wS.gJ();
            throw th;
        }
    }

    public boolean gG() {
        File b;
        if (this.wS.getName() != null) {
            b = this.wI.b(this.wS.gM(), this.wS.getName(), false, this.wS.gR(), this.wS.gS());
        } else {
            b = this.wI.b(this.wS.gM(), false, this.wS.gR(), this.wS.gS());
        }
        if (b != null && b.exists()) {
            this.wS.g(b);
            this.wS.setSuccess(true);
            this.wS.gJ();
            return true;
        }
        this.wS.gJ();
        return false;
    }

    public boolean gH() {
        boolean z;
        try {
            File b = this.wI.b(this.wS.gM(), this.wS.getName(), false, this.wS.gR(), this.wS.gS());
            File b2 = this.wI.b(this.wS.gN(), this.wS.gV(), true, this.wS.gR(), this.wS.gS());
            if (b != null) {
                if (b2 != null) {
                    b2.delete();
                }
                z = b.renameTo(b2);
            } else {
                z = false;
            }
            if (z) {
                this.wS.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.wS.gJ();
        }
    }

    public boolean gI() {
        boolean z = false;
        try {
            if (this.wS.gW() != null) {
                z = this.wS.gW().a(this, this.wS, this.wI);
            }
            if (z) {
                this.wS.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.wS.gJ();
        }
        return z;
    }
}
