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
    protected b qR;
    protected AtomicBoolean ra;
    private DiskFileOperate rb;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.ra.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.qR = null;
        this.ra = null;
        this.rb = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.dP() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.ra = new AtomicBoolean(false);
        this.qR = bVar;
        this.rb = diskFileOperate;
    }

    public boolean dI() {
        switch (this.rb.dP()) {
            case WRITE:
                return q(false);
            case WRITE_FORCE:
                return q(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return dJ();
            case APPEND:
                return s(false);
            case APPEND_MORE:
                return s(true);
            case INFO:
                return dL();
            case RENAME:
                return dM();
            case READ:
                return dK();
            case CUSTOM:
                return dN();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.rb instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.rb;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.ra.get(); i++) {
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

    private boolean dJ() {
        boolean z = false;
        try {
            File b = this.qR.b(this.rb.getPath(), false, this.rb.dW());
            z = d(b);
            if (z) {
                this.rb.e(b);
                this.rb.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rb.dO();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.qR.a(this.rb.dR(), this.rb.getName(), false, this.rb.dW());
            if (a2 != null && !this.ra.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.rb.e(a2);
                    this.rb.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rb.dO();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=5, 204=4, 208=4] */
    private boolean dK() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.qR.a(this.rb.dR(), this.rb.getName(), false, this.rb.dW());
            if (a2 == null || !a2.exists() || this.ra.get()) {
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.rb.dO();
            } else {
                fileInputStream = new FileInputStream(a2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr, 0, 1024);
                            if (read == -1 || this.ra.get()) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (!this.ra.get()) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!this.rb.dU() || this.rb.h(byteArray)) {
                                this.rb.setData(byteArray);
                                z = true;
                            }
                        }
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        if (z) {
                            this.rb.setSuccess(true);
                        }
                        this.rb.dO();
                    } catch (Exception e) {
                        e = e;
                        fileInputStream2 = fileInputStream;
                        try {
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.g.a.d(fileInputStream2);
                            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                            this.rb.dO();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                            this.rb.dO();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        this.rb.dO();
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
                File a2 = this.qR.a(this.rb.dR(), this.rb.getName(), true, this.rb.dW());
                if (a2 == null || this.ra.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.rb.dO();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b((OutputStream) null);
                        this.rb.dO();
                        return true;
                    }
                    a2.delete();
                }
                byte[] dQ = this.rb.dQ();
                byte[] data = this.rb.getData();
                if ((dQ == null && data == null) || this.ra.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.rb.dO();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (dQ != null) {
                    try {
                        fileOutputStream2.write(dQ);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        this.rb.dO();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        this.rb.dO();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.rb.e(a2);
                this.rb.setSuccess(true);
                this.rb.dO();
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
        OutputStream outputStream = this.rb.getOutputStream();
        File dV = this.rb.dV();
        try {
            if (outputStream == null) {
                try {
                    dV = this.qR.a(this.rb.dR(), this.rb.getName(), true, this.rb.dW());
                    if (dV == null || this.ra.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.b(outputStream);
                        }
                        this.rb.dO();
                        return false;
                    }
                    outputStream = new FileOutputStream(dV, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream);
                    }
                    this.rb.dO();
                    return false;
                }
            }
            byte[] dQ = this.rb.dQ();
            byte[] data = this.rb.getData();
            if ((dQ == null && data == null) || this.ra.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.rb.dO();
                return false;
            }
            if (dQ != null) {
                outputStream.write(dQ);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.rb.e(dV);
            this.rb.setSuccess(true);
            if (z) {
                this.rb.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.rb.dO();
            return true;
        } catch (Throwable th) {
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.rb.dO();
            throw th;
        }
    }

    public boolean dL() {
        File b;
        if (this.rb.getName() != null) {
            b = this.qR.a(this.rb.dR(), this.rb.getName(), false, this.rb.dW());
        } else {
            b = this.qR.b(this.rb.dR(), false, this.rb.dW());
        }
        if (b != null && b.exists()) {
            this.rb.e(b);
            this.rb.setSuccess(true);
            this.rb.dO();
            return true;
        }
        this.rb.dO();
        return false;
    }

    public boolean dM() {
        boolean z = false;
        try {
            File a2 = this.qR.a(this.rb.dR(), this.rb.getName(), false, this.rb.dW());
            File a3 = this.qR.a(this.rb.dS(), this.rb.dZ(), true, this.rb.dW());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.rb.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rb.dO();
        }
        return z;
    }

    public boolean dN() {
        boolean z = false;
        try {
            if (this.rb.ea() != null) {
                z = this.rb.ea().a(this, this.rb, this.qR);
            }
            if (z) {
                this.rb.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rb.dO();
        }
        return z;
    }
}
