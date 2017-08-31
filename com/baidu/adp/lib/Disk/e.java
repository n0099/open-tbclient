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
    protected b qQ;
    protected AtomicBoolean qZ;
    private DiskFileOperate ra;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.qZ.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.qQ = null;
        this.qZ = null;
        this.ra = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.dQ() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.qZ = new AtomicBoolean(false);
        this.qQ = bVar;
        this.ra = diskFileOperate;
    }

    public boolean dJ() {
        switch (this.ra.dQ()) {
            case WRITE:
                return q(false);
            case WRITE_FORCE:
                return q(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return dK();
            case APPEND:
                return s(false);
            case APPEND_MORE:
                return s(true);
            case INFO:
                return dM();
            case RENAME:
                return dN();
            case READ:
                return dL();
            case CUSTOM:
                return dO();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.ra instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.ra;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.qZ.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        d(listFiles[i]);
                    } else if (aVar.c(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (aVar.c(file)) {
            file.delete();
        }
        return true;
    }

    private boolean dK() {
        boolean z = false;
        try {
            File b = this.qQ.b(this.ra.getPath(), false, this.ra.dX());
            z = d(b);
            if (z) {
                this.ra.e(b);
                this.ra.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.ra.dP();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.qQ.a(this.ra.dS(), this.ra.getName(), false, this.ra.dX());
            if (a2 != null && !this.qZ.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.ra.e(a2);
                    this.ra.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.ra.dP();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=5, 204=4, 208=4] */
    private boolean dL() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.qQ.a(this.ra.dS(), this.ra.getName(), false, this.ra.dX());
            if (a2 == null || !a2.exists() || this.qZ.get()) {
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.ra.dP();
            } else {
                fileInputStream = new FileInputStream(a2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr, 0, 1024);
                            if (read == -1 || this.qZ.get()) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (!this.qZ.get()) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!this.ra.dV() || this.ra.h(byteArray)) {
                                this.ra.setData(byteArray);
                                z = true;
                            }
                        }
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        if (z) {
                            this.ra.setSuccess(true);
                        }
                        this.ra.dP();
                    } catch (Exception e) {
                        e = e;
                        fileInputStream2 = fileInputStream;
                        try {
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.g.a.d(fileInputStream2);
                            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                            this.ra.dP();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                            this.ra.dP();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        this.ra.dP();
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [257=6, 252=7] */
    public boolean q(boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File a2 = this.qQ.a(this.ra.dS(), this.ra.getName(), true, this.ra.dX());
                if (a2 == null || this.qZ.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.ra.dP();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b((OutputStream) null);
                        this.ra.dP();
                        return true;
                    }
                    a2.delete();
                }
                byte[] dR = this.ra.dR();
                byte[] data = this.ra.getData();
                if ((dR == null && data == null) || this.qZ.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.ra.dP();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (dR != null) {
                    try {
                        fileOutputStream2.write(dR);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        this.ra.dP();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        this.ra.dP();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.ra.e(a2);
                this.ra.setSuccess(true);
                this.ra.dP();
                return true;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, IGET, INVOKE, INVOKE, IGET, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [300=5, 301=5, 305=5] */
    public boolean s(boolean z) {
        OutputStream outputStream = this.ra.getOutputStream();
        File dW = this.ra.dW();
        try {
            if (outputStream == null) {
                try {
                    dW = this.qQ.a(this.ra.dS(), this.ra.getName(), true, this.ra.dX());
                    if (dW == null || this.qZ.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.b(outputStream);
                        }
                        this.ra.dP();
                        return false;
                    }
                    outputStream = new FileOutputStream(dW, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream);
                    }
                    this.ra.dP();
                    return false;
                }
            }
            byte[] dR = this.ra.dR();
            byte[] data = this.ra.getData();
            if ((dR == null && data == null) || this.qZ.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.ra.dP();
                return false;
            }
            if (dR != null) {
                outputStream.write(dR);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.ra.e(dW);
            this.ra.setSuccess(true);
            if (z) {
                this.ra.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.ra.dP();
            return true;
        } catch (Throwable th) {
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.ra.dP();
            throw th;
        }
    }

    public boolean dM() {
        File b;
        if (this.ra.getName() != null) {
            b = this.qQ.a(this.ra.dS(), this.ra.getName(), false, this.ra.dX());
        } else {
            b = this.qQ.b(this.ra.dS(), false, this.ra.dX());
        }
        if (b != null && b.exists()) {
            this.ra.e(b);
            this.ra.setSuccess(true);
            this.ra.dP();
            return true;
        }
        this.ra.dP();
        return false;
    }

    public boolean dN() {
        boolean z = false;
        try {
            File a2 = this.qQ.a(this.ra.dS(), this.ra.getName(), false, this.ra.dX());
            File a3 = this.qQ.a(this.ra.dT(), this.ra.ea(), true, this.ra.dX());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.ra.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.ra.dP();
        }
        return z;
    }

    public boolean dO() {
        boolean z = false;
        try {
            if (this.ra.eb() != null) {
                z = this.ra.eb().a(this, this.ra, this.qQ);
            }
            if (z) {
                this.ra.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.ra.dP();
        }
        return z;
    }
}
