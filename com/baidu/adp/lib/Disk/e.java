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
    private static /* synthetic */ int[] ko;
    protected final int BUFFER_SIZE = 1024;
    protected b kd;
    protected AtomicBoolean km;
    private DiskFileOperate kn;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] cI() {
        int[] iArr = ko;
        if (iArr == null) {
            iArr = new int[DiskFileOperate.Action.valuesCustom().length];
            try {
                iArr[DiskFileOperate.Action.APPEND.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DiskFileOperate.Action.APPEND_MORE.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DiskFileOperate.Action.CUSTOM.ordinal()] = 10;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DiskFileOperate.Action.DELETE.ordinal()] = 6;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DiskFileOperate.Action.DELETE_FILES.ordinal()] = 7;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DiskFileOperate.Action.INFO.ordinal()] = 8;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DiskFileOperate.Action.READ.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[DiskFileOperate.Action.RENAME.ordinal()] = 9;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[DiskFileOperate.Action.WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[DiskFileOperate.Action.WRITE_FORCE.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            ko = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.km.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.kd = null;
        this.km = null;
        this.kn = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.cK() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.km = new AtomicBoolean(false);
        this.kd = bVar;
        this.kn = diskFileOperate;
    }

    public boolean cC() {
        switch (cI()[this.kn.cK().ordinal()]) {
            case 1:
                return cE();
            case 2:
                return p(false);
            case 3:
                return p(true);
            case 4:
                return q(false);
            case 5:
                return q(true);
            case 6:
                return delete();
            case 7:
                return cD();
            case 8:
                return cF();
            case 9:
                return cG();
            case 10:
                return cH();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.kn instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.kn;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.km.get(); i++) {
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

    private boolean cD() {
        boolean z = false;
        try {
            File c = this.kd.c(this.kn.getPath(), false, this.kn.cR());
            z = d(c);
            if (z) {
                this.kn.e(c);
                this.kn.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.kn.cJ();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.kd.a(this.kn.cM(), this.kn.getName(), false, this.kn.cR());
            if (a2 != null && !this.km.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.kn.e(a2);
                    this.kn.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.kn.cJ();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean cE() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.kd.a(this.kn.cM(), this.kn.getName(), false, this.kn.cR());
            if (a2 == null || !a2.exists() || this.km.get()) {
                com.baidu.adp.lib.h.a.j(null);
                com.baidu.adp.lib.h.a.d(null);
                this.kn.cJ();
            } else {
                fileInputStream = new FileInputStream(a2);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream = null;
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1 || this.km.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.km.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.kn.cP() || this.kn.k(byteArray)) {
                            this.kn.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.h.a.j(fileInputStream);
                    com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                    if (z) {
                        this.kn.setSuccess(true);
                    }
                    this.kn.cJ();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.j(fileInputStream2);
                        com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                        this.kn.cJ();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.h.a.j(fileInputStream);
                        com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                        this.kn.cJ();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.h.a.j(fileInputStream);
                    com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                    this.kn.cJ();
                    throw th;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [257=6, 252=6] */
    public boolean p(boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File a2 = this.kd.a(this.kn.cM(), this.kn.getName(), true, this.kn.cR());
                if (a2 == null || this.km.get()) {
                    com.baidu.adp.lib.h.a.d(null);
                    this.kn.cJ();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.h.a.d(null);
                        this.kn.cJ();
                        return true;
                    }
                    a2.delete();
                }
                byte[] cL = this.kn.cL();
                byte[] data = this.kn.getData();
                if ((cL == null && data == null) || this.km.get()) {
                    com.baidu.adp.lib.h.a.d(null);
                    this.kn.cJ();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (cL != null) {
                    try {
                        fileOutputStream2.write(cL);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.d(fileOutputStream);
                        this.kn.cJ();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.h.a.d(fileOutputStream);
                        this.kn.cJ();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.h.a.d(fileOutputStream2);
                this.kn.e(a2);
                this.kn.setSuccess(true);
                this.kn.cJ();
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
    public boolean q(boolean z) {
        OutputStream outputStream = this.kn.getOutputStream();
        File cQ = this.kn.cQ();
        if (outputStream == null) {
            try {
                try {
                    cQ = this.kd.a(this.kn.cM(), this.kn.getName(), true, this.kn.cR());
                    if (cQ == null || this.km.get()) {
                        if (!z) {
                            com.baidu.adp.lib.h.a.d(outputStream);
                        }
                        this.kn.cJ();
                        return false;
                    }
                    outputStream = new FileOutputStream(cQ, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.h.a.d(outputStream);
                    }
                    this.kn.cJ();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.h.a.d(outputStream);
                }
                this.kn.cJ();
                throw th;
            }
        }
        byte[] cL = this.kn.cL();
        byte[] data = this.kn.getData();
        if ((cL == null && data == null) || this.km.get()) {
            if (!z) {
                com.baidu.adp.lib.h.a.d(outputStream);
            }
            this.kn.cJ();
            return false;
        }
        if (cL != null) {
            outputStream.write(cL);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.kn.e(cQ);
        this.kn.setSuccess(true);
        if (z) {
            this.kn.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.h.a.d(outputStream);
        }
        this.kn.cJ();
        return true;
    }

    public boolean cF() {
        File c;
        if (this.kn.getName() != null) {
            c = this.kd.a(this.kn.cM(), this.kn.getName(), false, this.kn.cR());
        } else {
            c = this.kd.c(this.kn.cM(), false, this.kn.cR());
        }
        if (c != null && c.exists()) {
            this.kn.e(c);
            this.kn.setSuccess(true);
            this.kn.cJ();
            return true;
        }
        this.kn.cJ();
        return false;
    }

    public boolean cG() {
        boolean z = false;
        try {
            File a2 = this.kd.a(this.kn.cM(), this.kn.getName(), false, this.kn.cR());
            File a3 = this.kd.a(this.kn.cN(), this.kn.cU(), true, this.kn.cR());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.kn.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.kn.cJ();
        }
        return z;
    }

    public boolean cH() {
        boolean z = false;
        try {
            if (this.kn.cV() != null) {
                z = this.kn.cV().a(this, this.kn, this.kd);
            }
            if (z) {
                this.kn.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.kn.cJ();
        }
        return z;
    }
}
