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
    private static /* synthetic */ int[] rG;
    protected final int BUFFER_SIZE = 1024;
    protected AtomicBoolean rE;
    private DiskFileOperate rF;
    protected b rv;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] dP() {
        int[] iArr = rG;
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
            rG = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.rE.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.rv = null;
        this.rE = null;
        this.rF = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.dR() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.rE = new AtomicBoolean(false);
        this.rv = bVar;
        this.rF = diskFileOperate;
    }

    public boolean dJ() {
        switch (dP()[this.rF.dR().ordinal()]) {
            case 1:
                return dL();
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
                return dK();
            case 8:
                return dM();
            case 9:
                return dN();
            case 10:
                return dO();
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

    private boolean dK() {
        boolean z = false;
        try {
            File c = this.rv.c(this.rF.getPath(), false, this.rF.dY());
            z = d(c);
            if (z) {
                this.rF.e(c);
                this.rF.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rF.dQ();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.rv.a(this.rF.dT(), this.rF.getName(), false, this.rF.dY());
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
            this.rF.dQ();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean dL() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.rv.a(this.rF.dT(), this.rF.getName(), false, this.rF.dY());
            if (a2 == null || !a2.exists() || this.rE.get()) {
                com.baidu.adp.lib.g.a.j(null);
                com.baidu.adp.lib.g.a.d(null);
                this.rF.dQ();
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
                        if (read == -1 || this.rE.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.rE.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.rF.dW() || this.rF.k(byteArray)) {
                            this.rF.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.g.a.j(fileInputStream);
                    com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                    if (z) {
                        this.rF.setSuccess(true);
                    }
                    this.rF.dQ();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.j(fileInputStream2);
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        this.rF.dQ();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.j(fileInputStream);
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        this.rF.dQ();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.g.a.j(fileInputStream);
                    com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                    this.rF.dQ();
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
                File a2 = this.rv.a(this.rF.dT(), this.rF.getName(), true, this.rF.dY());
                if (a2 == null || this.rE.get()) {
                    com.baidu.adp.lib.g.a.d(null);
                    this.rF.dQ();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.d(null);
                        this.rF.dQ();
                        return true;
                    }
                    a2.delete();
                }
                byte[] dS = this.rF.dS();
                byte[] data = this.rF.getData();
                if ((dS == null && data == null) || this.rE.get()) {
                    com.baidu.adp.lib.g.a.d(null);
                    this.rF.dQ();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (dS != null) {
                    try {
                        fileOutputStream2.write(dS);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.d(fileOutputStream);
                        this.rF.dQ();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.d(fileOutputStream);
                        this.rF.dQ();
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
                this.rF.dQ();
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
        File dX = this.rF.dX();
        if (outputStream == null) {
            try {
                try {
                    dX = this.rv.a(this.rF.dT(), this.rF.getName(), true, this.rF.dY());
                    if (dX == null || this.rE.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.d(outputStream);
                        }
                        this.rF.dQ();
                        return false;
                    }
                    outputStream = new FileOutputStream(dX, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.d(outputStream);
                    }
                    this.rF.dQ();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.g.a.d(outputStream);
                }
                this.rF.dQ();
                throw th;
            }
        }
        byte[] dS = this.rF.dS();
        byte[] data = this.rF.getData();
        if ((dS == null && data == null) || this.rE.get()) {
            if (!z) {
                com.baidu.adp.lib.g.a.d(outputStream);
            }
            this.rF.dQ();
            return false;
        }
        if (dS != null) {
            outputStream.write(dS);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.rF.e(dX);
        this.rF.setSuccess(true);
        if (z) {
            this.rF.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.g.a.d(outputStream);
        }
        this.rF.dQ();
        return true;
    }

    public boolean dM() {
        File c;
        if (this.rF.getName() != null) {
            c = this.rv.a(this.rF.dT(), this.rF.getName(), false, this.rF.dY());
        } else {
            c = this.rv.c(this.rF.dT(), false, this.rF.dY());
        }
        if (c != null && c.exists()) {
            this.rF.e(c);
            this.rF.setSuccess(true);
            this.rF.dQ();
            return true;
        }
        this.rF.dQ();
        return false;
    }

    public boolean dN() {
        boolean z = false;
        try {
            File a2 = this.rv.a(this.rF.dT(), this.rF.getName(), false, this.rF.dY());
            File a3 = this.rv.a(this.rF.dU(), this.rF.eb(), true, this.rF.dY());
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
            this.rF.dQ();
        }
        return z;
    }

    public boolean dO() {
        boolean z = false;
        try {
            if (this.rF.ec() != null) {
                z = this.rF.ec().a(this, this.rF, this.rv);
            }
            if (z) {
                this.rF.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rF.dQ();
        }
        return z;
    }
}
