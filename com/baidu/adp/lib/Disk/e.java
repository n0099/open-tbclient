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
    protected b td;
    protected AtomicBoolean tm;
    private DiskFileOperate tp;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.tm.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.td = null;
        this.tm = null;
        this.tp = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.ea() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.tm = new AtomicBoolean(false);
        this.td = bVar;
        this.tp = diskFileOperate;
    }

    public boolean dT() {
        switch (this.tp.ea()) {
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
        if (file == null || !(this.tp instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.tp;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.tm.get(); i++) {
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
            File c = this.td.c(this.tp.getPath(), false, this.tp.eh());
            z = d(c);
            if (z) {
                this.tp.e(c);
                this.tp.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.tp.dZ();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.td.a(this.tp.ec(), this.tp.getName(), false, this.tp.eh());
            if (a2 != null && !this.tm.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.tp.e(a2);
                    this.tp.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.tp.dZ();
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
            File a2 = this.td.a(this.tp.ec(), this.tp.getName(), false, this.tp.eh());
            if (a2 == null || !a2.exists() || this.tm.get()) {
                com.baidu.adp.lib.g.a.p(null);
                com.baidu.adp.lib.g.a.e((OutputStream) null);
                this.tp.dZ();
            } else {
                fileInputStream = new FileInputStream(a2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr, 0, 1024);
                            if (read == -1 || this.tm.get()) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (!this.tm.get()) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!this.tp.ef() || this.tp.n(byteArray)) {
                                this.tp.setData(byteArray);
                                z = true;
                            }
                        }
                        com.baidu.adp.lib.g.a.p(fileInputStream);
                        com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                        if (z) {
                            this.tp.setSuccess(true);
                        }
                        this.tp.dZ();
                    } catch (Exception e) {
                        e = e;
                        fileInputStream2 = fileInputStream;
                        try {
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.g.a.p(fileInputStream2);
                            com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                            this.tp.dZ();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            com.baidu.adp.lib.g.a.p(fileInputStream);
                            com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                            this.tp.dZ();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.p(fileInputStream);
                        com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                        this.tp.dZ();
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
                File a2 = this.td.a(this.tp.ec(), this.tp.getName(), true, this.tp.eh());
                if (a2 == null || this.tm.get()) {
                    com.baidu.adp.lib.g.a.e((OutputStream) null);
                    this.tp.dZ();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.e((OutputStream) null);
                        this.tp.dZ();
                        return true;
                    }
                    a2.delete();
                }
                byte[] eb = this.tp.eb();
                byte[] data = this.tp.getData();
                if ((eb == null && data == null) || this.tm.get()) {
                    com.baidu.adp.lib.g.a.e((OutputStream) null);
                    this.tp.dZ();
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
                        this.tp.dZ();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.e(fileOutputStream);
                        this.tp.dZ();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.e(fileOutputStream2);
                this.tp.e(a2);
                this.tp.setSuccess(true);
                this.tp.dZ();
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
        OutputStream outputStream = this.tp.getOutputStream();
        File eg = this.tp.eg();
        try {
            if (outputStream == null) {
                try {
                    eg = this.td.a(this.tp.ec(), this.tp.getName(), true, this.tp.eh());
                    if (eg == null || this.tm.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.e(outputStream);
                        }
                        this.tp.dZ();
                        return false;
                    }
                    outputStream = new FileOutputStream(eg, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.e(outputStream);
                    }
                    this.tp.dZ();
                    return false;
                }
            }
            byte[] eb = this.tp.eb();
            byte[] data = this.tp.getData();
            if ((eb == null && data == null) || this.tm.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.e(outputStream);
                }
                this.tp.dZ();
                return false;
            }
            if (eb != null) {
                outputStream.write(eb);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.tp.e(eg);
            this.tp.setSuccess(true);
            if (z) {
                this.tp.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.e(outputStream);
            }
            this.tp.dZ();
            return true;
        } catch (Throwable th) {
            if (!z) {
                com.baidu.adp.lib.g.a.e(outputStream);
            }
            this.tp.dZ();
            throw th;
        }
    }

    public boolean dW() {
        File c;
        if (this.tp.getName() != null) {
            c = this.td.a(this.tp.ec(), this.tp.getName(), false, this.tp.eh());
        } else {
            c = this.td.c(this.tp.ec(), false, this.tp.eh());
        }
        if (c != null && c.exists()) {
            this.tp.e(c);
            this.tp.setSuccess(true);
            this.tp.dZ();
            return true;
        }
        this.tp.dZ();
        return false;
    }

    public boolean dX() {
        boolean z = false;
        try {
            File a2 = this.td.a(this.tp.ec(), this.tp.getName(), false, this.tp.eh());
            File a3 = this.td.a(this.tp.ed(), this.tp.ek(), true, this.tp.eh());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.tp.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.tp.dZ();
        }
        return z;
    }

    public boolean dY() {
        boolean z = false;
        try {
            if (this.tp.el() != null) {
                z = this.tp.el().a(this, this.tp, this.td);
            }
            if (z) {
                this.tp.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.tp.dZ();
        }
        return z;
    }
}
