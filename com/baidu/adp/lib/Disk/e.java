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
    private static /* synthetic */ int[] kn;
    protected final int BUFFER_SIZE = 1024;
    protected b kc;
    protected AtomicBoolean kl;
    private DiskFileOperate km;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] cI() {
        int[] iArr = kn;
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
            kn = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.kl.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.kc = null;
        this.kl = null;
        this.km = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.cK() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.kl = new AtomicBoolean(false);
        this.kc = bVar;
        this.km = diskFileOperate;
    }

    public boolean cC() {
        switch (cI()[this.km.cK().ordinal()]) {
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
        if (file == null || !(this.km instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.km;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.kl.get(); i++) {
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
            File c = this.kc.c(this.km.getPath(), false, this.km.cR());
            z = d(c);
            if (z) {
                this.km.e(c);
                this.km.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.km.cJ();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.kc.a(this.km.cM(), this.km.getName(), false, this.km.cR());
            if (a2 != null && !this.kl.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.km.e(a2);
                    this.km.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.km.cJ();
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
            File a2 = this.kc.a(this.km.cM(), this.km.getName(), false, this.km.cR());
            if (a2 == null || !a2.exists() || this.kl.get()) {
                com.baidu.adp.lib.h.a.j(null);
                com.baidu.adp.lib.h.a.d(null);
                this.km.cJ();
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
                        if (read == -1 || this.kl.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.kl.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.km.cP() || this.km.k(byteArray)) {
                            this.km.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.h.a.j(fileInputStream);
                    com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                    if (z) {
                        this.km.setSuccess(true);
                    }
                    this.km.cJ();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.j(fileInputStream2);
                        com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                        this.km.cJ();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.h.a.j(fileInputStream);
                        com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                        this.km.cJ();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.h.a.j(fileInputStream);
                    com.baidu.adp.lib.h.a.d(byteArrayOutputStream);
                    this.km.cJ();
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
                File a2 = this.kc.a(this.km.cM(), this.km.getName(), true, this.km.cR());
                if (a2 == null || this.kl.get()) {
                    com.baidu.adp.lib.h.a.d(null);
                    this.km.cJ();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.h.a.d(null);
                        this.km.cJ();
                        return true;
                    }
                    a2.delete();
                }
                byte[] cL = this.km.cL();
                byte[] data = this.km.getData();
                if ((cL == null && data == null) || this.kl.get()) {
                    com.baidu.adp.lib.h.a.d(null);
                    this.km.cJ();
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
                        this.km.cJ();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.h.a.d(fileOutputStream);
                        this.km.cJ();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.h.a.d(fileOutputStream2);
                this.km.e(a2);
                this.km.setSuccess(true);
                this.km.cJ();
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
        OutputStream outputStream = this.km.getOutputStream();
        File cQ = this.km.cQ();
        if (outputStream == null) {
            try {
                try {
                    cQ = this.kc.a(this.km.cM(), this.km.getName(), true, this.km.cR());
                    if (cQ == null || this.kl.get()) {
                        if (!z) {
                            com.baidu.adp.lib.h.a.d(outputStream);
                        }
                        this.km.cJ();
                        return false;
                    }
                    outputStream = new FileOutputStream(cQ, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.h.a.d(outputStream);
                    }
                    this.km.cJ();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.h.a.d(outputStream);
                }
                this.km.cJ();
                throw th;
            }
        }
        byte[] cL = this.km.cL();
        byte[] data = this.km.getData();
        if ((cL == null && data == null) || this.kl.get()) {
            if (!z) {
                com.baidu.adp.lib.h.a.d(outputStream);
            }
            this.km.cJ();
            return false;
        }
        if (cL != null) {
            outputStream.write(cL);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.km.e(cQ);
        this.km.setSuccess(true);
        if (z) {
            this.km.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.h.a.d(outputStream);
        }
        this.km.cJ();
        return true;
    }

    public boolean cF() {
        File c;
        if (this.km.getName() != null) {
            c = this.kc.a(this.km.cM(), this.km.getName(), false, this.km.cR());
        } else {
            c = this.kc.c(this.km.cM(), false, this.km.cR());
        }
        if (c != null && c.exists()) {
            this.km.e(c);
            this.km.setSuccess(true);
            this.km.cJ();
            return true;
        }
        this.km.cJ();
        return false;
    }

    public boolean cG() {
        boolean z = false;
        try {
            File a2 = this.kc.a(this.km.cM(), this.km.getName(), false, this.km.cR());
            File a3 = this.kc.a(this.km.cN(), this.km.cU(), true, this.km.cR());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.km.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.km.cJ();
        }
        return z;
    }

    public boolean cH() {
        boolean z = false;
        try {
            if (this.km.cV() != null) {
                z = this.km.cV().a(this, this.km, this.kc);
            }
            if (z) {
                this.km.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.km.cJ();
        }
        return z;
    }
}
