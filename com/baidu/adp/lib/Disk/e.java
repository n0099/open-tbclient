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
    protected b tb;
    protected AtomicBoolean tk;
    private DiskFileOperate tl;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.tk.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.tb = null;
        this.tk = null;
        this.tl = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.ea() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.tk = new AtomicBoolean(false);
        this.tb = bVar;
        this.tl = diskFileOperate;
    }

    public boolean dT() {
        switch (this.tl.ea()) {
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
        if (file == null || !(this.tl instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.tl;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.tk.get(); i++) {
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
            File c = this.tb.c(this.tl.getPath(), false, this.tl.eh());
            z = d(c);
            if (z) {
                this.tl.e(c);
                this.tl.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.tl.dZ();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.tb.a(this.tl.ec(), this.tl.getName(), false, this.tl.eh());
            if (a2 != null && !this.tk.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.tl.e(a2);
                    this.tl.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.tl.dZ();
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
            File a2 = this.tb.a(this.tl.ec(), this.tl.getName(), false, this.tl.eh());
            if (a2 == null || !a2.exists() || this.tk.get()) {
                com.baidu.adp.lib.g.a.p(null);
                com.baidu.adp.lib.g.a.e((OutputStream) null);
                this.tl.dZ();
            } else {
                fileInputStream = new FileInputStream(a2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr, 0, 1024);
                            if (read == -1 || this.tk.get()) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (!this.tk.get()) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!this.tl.ef() || this.tl.n(byteArray)) {
                                this.tl.setData(byteArray);
                                z = true;
                            }
                        }
                        com.baidu.adp.lib.g.a.p(fileInputStream);
                        com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                        if (z) {
                            this.tl.setSuccess(true);
                        }
                        this.tl.dZ();
                    } catch (Exception e) {
                        e = e;
                        fileInputStream2 = fileInputStream;
                        try {
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.g.a.p(fileInputStream2);
                            com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                            this.tl.dZ();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            com.baidu.adp.lib.g.a.p(fileInputStream);
                            com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                            this.tl.dZ();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.p(fileInputStream);
                        com.baidu.adp.lib.g.a.e(byteArrayOutputStream);
                        this.tl.dZ();
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
                File a2 = this.tb.a(this.tl.ec(), this.tl.getName(), true, this.tl.eh());
                if (a2 == null || this.tk.get()) {
                    com.baidu.adp.lib.g.a.e((OutputStream) null);
                    this.tl.dZ();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.e((OutputStream) null);
                        this.tl.dZ();
                        return true;
                    }
                    a2.delete();
                }
                byte[] eb = this.tl.eb();
                byte[] data = this.tl.getData();
                if ((eb == null && data == null) || this.tk.get()) {
                    com.baidu.adp.lib.g.a.e((OutputStream) null);
                    this.tl.dZ();
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
                        this.tl.dZ();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.e(fileOutputStream);
                        this.tl.dZ();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.e(fileOutputStream2);
                this.tl.e(a2);
                this.tl.setSuccess(true);
                this.tl.dZ();
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
        OutputStream outputStream = this.tl.getOutputStream();
        File eg = this.tl.eg();
        try {
            if (outputStream == null) {
                try {
                    eg = this.tb.a(this.tl.ec(), this.tl.getName(), true, this.tl.eh());
                    if (eg == null || this.tk.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.e(outputStream);
                        }
                        this.tl.dZ();
                        return false;
                    }
                    outputStream = new FileOutputStream(eg, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.e(outputStream);
                    }
                    this.tl.dZ();
                    return false;
                }
            }
            byte[] eb = this.tl.eb();
            byte[] data = this.tl.getData();
            if ((eb == null && data == null) || this.tk.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.e(outputStream);
                }
                this.tl.dZ();
                return false;
            }
            if (eb != null) {
                outputStream.write(eb);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.tl.e(eg);
            this.tl.setSuccess(true);
            if (z) {
                this.tl.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.e(outputStream);
            }
            this.tl.dZ();
            return true;
        } catch (Throwable th) {
            if (!z) {
                com.baidu.adp.lib.g.a.e(outputStream);
            }
            this.tl.dZ();
            throw th;
        }
    }

    public boolean dW() {
        File c;
        if (this.tl.getName() != null) {
            c = this.tb.a(this.tl.ec(), this.tl.getName(), false, this.tl.eh());
        } else {
            c = this.tb.c(this.tl.ec(), false, this.tl.eh());
        }
        if (c != null && c.exists()) {
            this.tl.e(c);
            this.tl.setSuccess(true);
            this.tl.dZ();
            return true;
        }
        this.tl.dZ();
        return false;
    }

    public boolean dX() {
        boolean z = false;
        try {
            File a2 = this.tb.a(this.tl.ec(), this.tl.getName(), false, this.tl.eh());
            File a3 = this.tb.a(this.tl.ed(), this.tl.ek(), true, this.tl.eh());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.tl.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.tl.dZ();
        }
        return z;
    }

    public boolean dY() {
        boolean z = false;
        try {
            if (this.tl.el() != null) {
                z = this.tl.el().a(this, this.tl, this.tb);
            }
            if (z) {
                this.tl.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.tl.dZ();
        }
        return z;
    }
}
