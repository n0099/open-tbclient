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
    protected b te;
    protected AtomicBoolean tp;
    private DiskFileOperate tq;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.tp.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.te = null;
        this.tp = null;
        this.tq = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.ea() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.tp = new AtomicBoolean(false);
        this.te = bVar;
        this.tq = diskFileOperate;
    }

    public boolean dT() {
        switch (this.tq.ea()) {
            case WRITE:
                return q(false);
            case WRITE_FORCE:
                return q(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return dU();
            case APPEND:
                return r(false);
            case APPEND_MORE:
                return r(true);
            case INFO:
                return dW();
            case RENAME:
                return dX();
            case READ:
                return dV();
            case CUSTOM:
                return dY();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.tq instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.tq;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.tp.get(); i++) {
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

    private boolean dU() {
        boolean z = false;
        try {
            File b = this.te.b(this.tq.getPath(), false, this.tq.eh());
            z = d(b);
            if (z) {
                this.tq.e(b);
                this.tq.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.tq.dZ();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.te.a(this.tq.ec(), this.tq.getName(), false, this.tq.eh());
            if (a2 != null && !this.tp.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.tq.e(a2);
                    this.tq.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.tq.dZ();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=5, 204=4, 208=4] */
    private boolean dV() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.te.a(this.tq.ec(), this.tq.getName(), false, this.tq.eh());
            if (a2 == null || !a2.exists() || this.tp.get()) {
                com.baidu.adp.lib.g.a.p(null);
                com.baidu.adp.lib.g.a.e((OutputStream) null);
                this.tq.dZ();
            } else {
                fileInputStream = new FileInputStream(a2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr, 0, 1024);
                            if (read == -1 || this.tp.get()) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (!this.tp.get()) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!this.tq.ef() || this.tq.n(byteArray)) {
                                this.tq.setData(byteArray);
                                z = true;
                            }
                        }
                        com.baidu.adp.lib.g.a.p(fileInputStream);
                        com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                        if (z) {
                            this.tq.setSuccess(true);
                        }
                        this.tq.dZ();
                    } catch (Exception e) {
                        e = e;
                        fileInputStream2 = fileInputStream;
                        try {
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.g.a.p(fileInputStream2);
                            com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                            this.tq.dZ();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            com.baidu.adp.lib.g.a.p(fileInputStream);
                            com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                            this.tq.dZ();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.p(fileInputStream);
                        com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                        this.tq.dZ();
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
                File a2 = this.te.a(this.tq.ec(), this.tq.getName(), true, this.tq.eh());
                if (a2 == null || this.tp.get()) {
                    com.baidu.adp.lib.g.a.e((OutputStream) null);
                    this.tq.dZ();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.e((OutputStream) null);
                        this.tq.dZ();
                        return true;
                    }
                    a2.delete();
                }
                byte[] eb = this.tq.eb();
                byte[] data = this.tq.getData();
                if ((eb == null && data == null) || this.tp.get()) {
                    com.baidu.adp.lib.g.a.e((OutputStream) null);
                    this.tq.dZ();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (eb != null) {
                    try {
                        fileOutputStream2.write(eb);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.e(fileOutputStream);
                        this.tq.dZ();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.e(fileOutputStream);
                        this.tq.dZ();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.e(fileOutputStream2);
                this.tq.e(a2);
                this.tq.setSuccess(true);
                this.tq.dZ();
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
        OutputStream outputStream = this.tq.getOutputStream();
        File eg = this.tq.eg();
        try {
            if (outputStream == null) {
                try {
                    eg = this.te.a(this.tq.ec(), this.tq.getName(), true, this.tq.eh());
                    if (eg == null || this.tp.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.e(outputStream);
                        }
                        this.tq.dZ();
                        return false;
                    }
                    outputStream = new FileOutputStream(eg, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.e(outputStream);
                    }
                    this.tq.dZ();
                    return false;
                }
            }
            byte[] eb = this.tq.eb();
            byte[] data = this.tq.getData();
            if ((eb == null && data == null) || this.tp.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.e(outputStream);
                }
                this.tq.dZ();
                return false;
            }
            if (eb != null) {
                outputStream.write(eb);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.tq.e(eg);
            this.tq.setSuccess(true);
            if (z) {
                this.tq.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.e(outputStream);
            }
            this.tq.dZ();
            return true;
        } catch (Throwable th) {
            if (!z) {
                com.baidu.adp.lib.g.a.e(outputStream);
            }
            this.tq.dZ();
            throw th;
        }
    }

    public boolean dW() {
        File b;
        if (this.tq.getName() != null) {
            b = this.te.a(this.tq.ec(), this.tq.getName(), false, this.tq.eh());
        } else {
            b = this.te.b(this.tq.ec(), false, this.tq.eh());
        }
        if (b != null && b.exists()) {
            this.tq.e(b);
            this.tq.setSuccess(true);
            this.tq.dZ();
            return true;
        }
        this.tq.dZ();
        return false;
    }

    public boolean dX() {
        boolean z = false;
        try {
            File a2 = this.te.a(this.tq.ec(), this.tq.getName(), false, this.tq.eh());
            File a3 = this.te.a(this.tq.ed(), this.tq.ek(), true, this.tq.eh());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.tq.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.tq.dZ();
        }
        return z;
    }

    public boolean dY() {
        boolean z = false;
        try {
            if (this.tq.el() != null) {
                z = this.tq.el().a(this, this.tq, this.te);
            }
            if (z) {
                this.tq.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.tq.dZ();
        }
        return z;
    }
}
