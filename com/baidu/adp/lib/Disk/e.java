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
    protected AtomicBoolean afC;
    private DiskFileOperate afD;
    protected b aft;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.afC.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.aft = null;
        this.afC = null;
        this.afD = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.lt() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.afC = new AtomicBoolean(false);
        this.aft = bVar;
        this.afD = diskFileOperate;
    }

    public boolean lm() {
        switch (this.afD.lt()) {
            case WRITE:
                return X(false);
            case WRITE_FORCE:
                return X(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return ln();
            case APPEND:
                return Y(false);
            case APPEND_MORE:
                return Y(true);
            case INFO:
                return lp();
            case RENAME:
                return lq();
            case READ:
                return lo();
            case CUSTOM:
                return lr();
            default:
                return false;
        }
    }

    private boolean e(File file) {
        if (file == null || !(this.afD instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.afD;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.afC.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        e(listFiles[i]);
                    } else if (aVar.d(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (aVar.d(file)) {
            file.delete();
        }
        return true;
    }

    private boolean ln() {
        boolean z = false;
        try {
            File b = this.aft.b(this.afD.getPath(), false, this.afD.lA());
            z = e(b);
            if (z) {
                this.afD.f(b);
                this.afD.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.afD.ls();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.aft.a(this.afD.lv(), this.afD.getName(), false, this.afD.lA());
            if (a2 != null && !this.afC.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.afD.f(a2);
                    this.afD.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.afD.ls();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=5, 204=4, 208=4] */
    private boolean lo() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.aft.a(this.afD.lv(), this.afD.getName(), false, this.afD.lA());
            if (a2 == null || !a2.exists() || this.afC.get()) {
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.afD.ls();
            } else {
                fileInputStream = new FileInputStream(a2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr, 0, 1024);
                            if (read == -1 || this.afC.get()) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        if (!this.afC.get()) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            if (!this.afD.ly() || this.afD.h(byteArray)) {
                                this.afD.setData(byteArray);
                                z = true;
                            }
                        }
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        if (z) {
                            this.afD.setSuccess(true);
                        }
                        this.afD.ls();
                    } catch (Exception e) {
                        e = e;
                        fileInputStream2 = fileInputStream;
                        try {
                            BdLog.e(e.getMessage());
                            com.baidu.adp.lib.g.a.d(fileInputStream2);
                            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                            this.afD.ls();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            com.baidu.adp.lib.g.a.d(fileInputStream);
                            com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                            this.afD.ls();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        this.afD.ls();
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
    public boolean X(boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File a2 = this.aft.a(this.afD.lv(), this.afD.getName(), true, this.afD.lA());
                if (a2 == null || this.afC.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.afD.ls();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b((OutputStream) null);
                        this.afD.ls();
                        return true;
                    }
                    a2.delete();
                }
                byte[] lu = this.afD.lu();
                byte[] data = this.afD.getData();
                if ((lu == null && data == null) || this.afC.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.afD.ls();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (lu != null) {
                    try {
                        fileOutputStream2.write(lu);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        this.afD.ls();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        this.afD.ls();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.afD.f(a2);
                this.afD.setSuccess(true);
                this.afD.ls();
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
    public boolean Y(boolean z) {
        OutputStream outputStream = this.afD.getOutputStream();
        File lz = this.afD.lz();
        try {
            if (outputStream == null) {
                try {
                    lz = this.aft.a(this.afD.lv(), this.afD.getName(), true, this.afD.lA());
                    if (lz == null || this.afC.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.b(outputStream);
                        }
                        this.afD.ls();
                        return false;
                    }
                    outputStream = new FileOutputStream(lz, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream);
                    }
                    this.afD.ls();
                    return false;
                }
            }
            byte[] lu = this.afD.lu();
            byte[] data = this.afD.getData();
            if ((lu == null && data == null) || this.afC.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.afD.ls();
                return false;
            }
            if (lu != null) {
                outputStream.write(lu);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.afD.f(lz);
            this.afD.setSuccess(true);
            if (z) {
                this.afD.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.afD.ls();
            return true;
        } catch (Throwable th) {
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.afD.ls();
            throw th;
        }
    }

    public boolean lp() {
        File b;
        if (this.afD.getName() != null) {
            b = this.aft.a(this.afD.lv(), this.afD.getName(), false, this.afD.lA());
        } else {
            b = this.aft.b(this.afD.lv(), false, this.afD.lA());
        }
        if (b != null && b.exists()) {
            this.afD.f(b);
            this.afD.setSuccess(true);
            this.afD.ls();
            return true;
        }
        this.afD.ls();
        return false;
    }

    public boolean lq() {
        boolean z = false;
        try {
            File a2 = this.aft.a(this.afD.lv(), this.afD.getName(), false, this.afD.lA());
            File a3 = this.aft.a(this.afD.lw(), this.afD.lD(), true, this.afD.lA());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.afD.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.afD.ls();
        }
        return z;
    }

    public boolean lr() {
        boolean z = false;
        try {
            if (this.afD.lE() != null) {
                z = this.afD.lE().a(this, this.afD, this.aft);
            }
            if (z) {
                this.afD.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.afD.ls();
        }
        return z;
    }
}
