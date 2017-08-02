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
    protected AtomicBoolean rE;
    private DiskFileOperate rF;
    protected b rv;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.rE.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.rv = null;
        this.rE = null;
        this.rF = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.dP() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.rE = new AtomicBoolean(false);
        this.rv = bVar;
        this.rF = diskFileOperate;
    }

    public boolean dI() {
        switch (this.rF.dP()) {
            case WRITE:
                return q(false);
            case WRITE_FORCE:
                return q(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return dJ();
            case APPEND:
                return r(false);
            case APPEND_MORE:
                return r(true);
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
        if (file == null || !(this.rF instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.rF;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.rE.get(); i++) {
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
            File c = this.rv.c(this.rF.getPath(), false, this.rF.dW());
            z = d(c);
            if (z) {
                this.rF.e(c);
                this.rF.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rF.dO();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.rv.a(this.rF.dR(), this.rF.getName(), false, this.rF.dW());
            if (a2 != null && !this.rE.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.rF.e(a2);
                    this.rF.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rF.dO();
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
            File a2 = this.rv.a(this.rF.dR(), this.rF.getName(), false, this.rF.dW());
            if (a2 == null || !a2.exists() || this.rE.get()) {
                com.baidu.adp.lib.g.a.j(null);
                com.baidu.adp.lib.g.a.d(null);
                this.rF.dO();
            } else {
                fileInputStream = new FileInputStream(a2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr, 0, 1024);
                            if (read == -1 || this.rE.get()) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (!this.rE.get()) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!this.rF.dU() || this.rF.k(byteArray)) {
                                this.rF.setData(byteArray);
                                z = true;
                            }
                        }
                        com.baidu.adp.lib.g.a.j(fileInputStream);
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        if (z) {
                            this.rF.setSuccess(true);
                        }
                        this.rF.dO();
                    } catch (Exception e) {
                        e = e;
                        fileInputStream2 = fileInputStream;
                        try {
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.g.a.j(fileInputStream2);
                            com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                            this.rF.dO();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            com.baidu.adp.lib.g.a.j(fileInputStream);
                            com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                            this.rF.dO();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.j(fileInputStream);
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        this.rF.dO();
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
                File a2 = this.rv.a(this.rF.dR(), this.rF.getName(), true, this.rF.dW());
                if (a2 == null || this.rE.get()) {
                    com.baidu.adp.lib.g.a.d(null);
                    this.rF.dO();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.d(null);
                        this.rF.dO();
                        return true;
                    }
                    a2.delete();
                }
                byte[] dQ = this.rF.dQ();
                byte[] data = this.rF.getData();
                if ((dQ == null && data == null) || this.rE.get()) {
                    com.baidu.adp.lib.g.a.d(null);
                    this.rF.dO();
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
                        com.baidu.adp.lib.g.a.d(fileOutputStream);
                        this.rF.dO();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.d(fileOutputStream);
                        this.rF.dO();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.d(fileOutputStream2);
                this.rF.e(a2);
                this.rF.setSuccess(true);
                this.rF.dO();
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
    public boolean r(boolean z) {
        OutputStream outputStream = this.rF.getOutputStream();
        File dV = this.rF.dV();
        try {
            if (outputStream == null) {
                try {
                    dV = this.rv.a(this.rF.dR(), this.rF.getName(), true, this.rF.dW());
                    if (dV == null || this.rE.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.d(outputStream);
                        }
                        this.rF.dO();
                        return false;
                    }
                    outputStream = new FileOutputStream(dV, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.d(outputStream);
                    }
                    this.rF.dO();
                    return false;
                }
            }
            byte[] dQ = this.rF.dQ();
            byte[] data = this.rF.getData();
            if ((dQ == null && data == null) || this.rE.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.d(outputStream);
                }
                this.rF.dO();
                return false;
            }
            if (dQ != null) {
                outputStream.write(dQ);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.rF.e(dV);
            this.rF.setSuccess(true);
            if (z) {
                this.rF.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.d(outputStream);
            }
            this.rF.dO();
            return true;
        } catch (Throwable th) {
            if (!z) {
                com.baidu.adp.lib.g.a.d(outputStream);
            }
            this.rF.dO();
            throw th;
        }
    }

    public boolean dL() {
        File c;
        if (this.rF.getName() != null) {
            c = this.rv.a(this.rF.dR(), this.rF.getName(), false, this.rF.dW());
        } else {
            c = this.rv.c(this.rF.dR(), false, this.rF.dW());
        }
        if (c != null && c.exists()) {
            this.rF.e(c);
            this.rF.setSuccess(true);
            this.rF.dO();
            return true;
        }
        this.rF.dO();
        return false;
    }

    public boolean dM() {
        boolean z = false;
        try {
            File a2 = this.rv.a(this.rF.dR(), this.rF.getName(), false, this.rF.dW());
            File a3 = this.rv.a(this.rF.dS(), this.rF.dZ(), true, this.rF.dW());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.rF.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rF.dO();
        }
        return z;
    }

    public boolean dN() {
        boolean z = false;
        try {
            if (this.rF.ea() != null) {
                z = this.rF.ea().a(this, this.rF, this.rv);
            }
            if (z) {
                this.rF.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rF.dO();
        }
        return z;
    }
}
