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
    private static /* synthetic */ int[] rB;
    protected final int BUFFER_SIZE = 1024;
    private DiskFileOperate rA;
    protected b rq;
    protected AtomicBoolean rz;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] dO() {
        int[] iArr = rB;
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
            rB = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.rz.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.rq = null;
        this.rz = null;
        this.rA = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.dQ() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.rz = new AtomicBoolean(false);
        this.rq = bVar;
        this.rA = diskFileOperate;
    }

    public boolean dI() {
        switch (dO()[this.rA.dQ().ordinal()]) {
            case 1:
                return dK();
            case 2:
                return q(false);
            case 3:
                return q(true);
            case 4:
                return r(false);
            case 5:
                return r(true);
            case 6:
                return delete();
            case 7:
                return dJ();
            case 8:
                return dL();
            case 9:
                return dM();
            case 10:
                return dN();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.rA instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.rA;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.rz.get(); i++) {
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
            File c = this.rq.c(this.rA.getPath(), false, this.rA.dX());
            z = d(c);
            if (z) {
                this.rA.e(c);
                this.rA.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rA.dP();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.rq.a(this.rA.dS(), this.rA.getName(), false, this.rA.dX());
            if (a2 != null && !this.rz.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.rA.e(a2);
                    this.rA.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rA.dP();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean dK() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.rq.a(this.rA.dS(), this.rA.getName(), false, this.rA.dX());
            if (a2 == null || !a2.exists() || this.rz.get()) {
                com.baidu.adp.lib.g.a.j(null);
                com.baidu.adp.lib.g.a.d(null);
                this.rA.dP();
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
                        if (read == -1 || this.rz.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.rz.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.rA.dV() || this.rA.k(byteArray)) {
                            this.rA.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.g.a.j(fileInputStream);
                    com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                    if (z) {
                        this.rA.setSuccess(true);
                    }
                    this.rA.dP();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.j(fileInputStream2);
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        this.rA.dP();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.j(fileInputStream);
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        this.rA.dP();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.g.a.j(fileInputStream);
                    com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                    this.rA.dP();
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
    public boolean q(boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File a2 = this.rq.a(this.rA.dS(), this.rA.getName(), true, this.rA.dX());
                if (a2 == null || this.rz.get()) {
                    com.baidu.adp.lib.g.a.d(null);
                    this.rA.dP();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.d(null);
                        this.rA.dP();
                        return true;
                    }
                    a2.delete();
                }
                byte[] dR = this.rA.dR();
                byte[] data = this.rA.getData();
                if ((dR == null && data == null) || this.rz.get()) {
                    com.baidu.adp.lib.g.a.d(null);
                    this.rA.dP();
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
                        com.baidu.adp.lib.g.a.d(fileOutputStream);
                        this.rA.dP();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.d(fileOutputStream);
                        this.rA.dP();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.d(fileOutputStream2);
                this.rA.e(a2);
                this.rA.setSuccess(true);
                this.rA.dP();
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
        OutputStream outputStream = this.rA.getOutputStream();
        File dW = this.rA.dW();
        if (outputStream == null) {
            try {
                try {
                    dW = this.rq.a(this.rA.dS(), this.rA.getName(), true, this.rA.dX());
                    if (dW == null || this.rz.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.d(outputStream);
                        }
                        this.rA.dP();
                        return false;
                    }
                    outputStream = new FileOutputStream(dW, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.d(outputStream);
                    }
                    this.rA.dP();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.g.a.d(outputStream);
                }
                this.rA.dP();
                throw th;
            }
        }
        byte[] dR = this.rA.dR();
        byte[] data = this.rA.getData();
        if ((dR == null && data == null) || this.rz.get()) {
            if (!z) {
                com.baidu.adp.lib.g.a.d(outputStream);
            }
            this.rA.dP();
            return false;
        }
        if (dR != null) {
            outputStream.write(dR);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.rA.e(dW);
        this.rA.setSuccess(true);
        if (z) {
            this.rA.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.g.a.d(outputStream);
        }
        this.rA.dP();
        return true;
    }

    public boolean dL() {
        File c;
        if (this.rA.getName() != null) {
            c = this.rq.a(this.rA.dS(), this.rA.getName(), false, this.rA.dX());
        } else {
            c = this.rq.c(this.rA.dS(), false, this.rA.dX());
        }
        if (c != null && c.exists()) {
            this.rA.e(c);
            this.rA.setSuccess(true);
            this.rA.dP();
            return true;
        }
        this.rA.dP();
        return false;
    }

    public boolean dM() {
        boolean z = false;
        try {
            File a2 = this.rq.a(this.rA.dS(), this.rA.getName(), false, this.rA.dX());
            File a3 = this.rq.a(this.rA.dT(), this.rA.ea(), true, this.rA.dX());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.rA.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rA.dP();
        }
        return z;
    }

    public boolean dN() {
        boolean z = false;
        try {
            if (this.rA.eb() != null) {
                z = this.rA.eb().a(this, this.rA, this.rq);
            }
            if (z) {
                this.rA.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rA.dP();
        }
        return z;
    }
}
