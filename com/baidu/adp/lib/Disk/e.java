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
    private static /* synthetic */ int[] sc;
    protected final int BUFFER_SIZE = 1024;
    protected b rR;
    protected AtomicBoolean sa;
    private DiskFileOperate sb;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] dP() {
        int[] iArr = sc;
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
            sc = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.sa.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.rR = null;
        this.sa = null;
        this.sb = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.dR() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.sa = new AtomicBoolean(false);
        this.rR = bVar;
        this.sb = diskFileOperate;
    }

    public boolean dJ() {
        switch (dP()[this.sb.dR().ordinal()]) {
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
        if (file == null || !(this.sb instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.sb;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.sa.get(); i++) {
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
            File c = this.rR.c(this.sb.getPath(), false, this.sb.dY());
            z = d(c);
            if (z) {
                this.sb.e(c);
                this.sb.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.sb.dQ();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.rR.a(this.sb.dT(), this.sb.getName(), false, this.sb.dY());
            if (a2 != null && !this.sa.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.sb.e(a2);
                    this.sb.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.sb.dQ();
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
            File a2 = this.rR.a(this.sb.dT(), this.sb.getName(), false, this.sb.dY());
            if (a2 == null || !a2.exists() || this.sa.get()) {
                com.baidu.adp.lib.g.a.j(null);
                com.baidu.adp.lib.g.a.d(null);
                this.sb.dQ();
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
                        if (read == -1 || this.sa.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.sa.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.sb.dW() || this.sb.k(byteArray)) {
                            this.sb.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.g.a.j(fileInputStream);
                    com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                    if (z) {
                        this.sb.setSuccess(true);
                    }
                    this.sb.dQ();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.j(fileInputStream2);
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        this.sb.dQ();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.j(fileInputStream);
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        this.sb.dQ();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.g.a.j(fileInputStream);
                    com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                    this.sb.dQ();
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
                File a2 = this.rR.a(this.sb.dT(), this.sb.getName(), true, this.sb.dY());
                if (a2 == null || this.sa.get()) {
                    com.baidu.adp.lib.g.a.d(null);
                    this.sb.dQ();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.d(null);
                        this.sb.dQ();
                        return true;
                    }
                    a2.delete();
                }
                byte[] dS = this.sb.dS();
                byte[] data = this.sb.getData();
                if ((dS == null && data == null) || this.sa.get()) {
                    com.baidu.adp.lib.g.a.d(null);
                    this.sb.dQ();
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
                        this.sb.dQ();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.d(fileOutputStream);
                        this.sb.dQ();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.d(fileOutputStream2);
                this.sb.e(a2);
                this.sb.setSuccess(true);
                this.sb.dQ();
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
        OutputStream outputStream = this.sb.getOutputStream();
        File dX = this.sb.dX();
        if (outputStream == null) {
            try {
                try {
                    dX = this.rR.a(this.sb.dT(), this.sb.getName(), true, this.sb.dY());
                    if (dX == null || this.sa.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.d(outputStream);
                        }
                        this.sb.dQ();
                        return false;
                    }
                    outputStream = new FileOutputStream(dX, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.d(outputStream);
                    }
                    this.sb.dQ();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.g.a.d(outputStream);
                }
                this.sb.dQ();
                throw th;
            }
        }
        byte[] dS = this.sb.dS();
        byte[] data = this.sb.getData();
        if ((dS == null && data == null) || this.sa.get()) {
            if (!z) {
                com.baidu.adp.lib.g.a.d(outputStream);
            }
            this.sb.dQ();
            return false;
        }
        if (dS != null) {
            outputStream.write(dS);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.sb.e(dX);
        this.sb.setSuccess(true);
        if (z) {
            this.sb.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.g.a.d(outputStream);
        }
        this.sb.dQ();
        return true;
    }

    public boolean dM() {
        File c;
        if (this.sb.getName() != null) {
            c = this.rR.a(this.sb.dT(), this.sb.getName(), false, this.sb.dY());
        } else {
            c = this.rR.c(this.sb.dT(), false, this.sb.dY());
        }
        if (c != null && c.exists()) {
            this.sb.e(c);
            this.sb.setSuccess(true);
            this.sb.dQ();
            return true;
        }
        this.sb.dQ();
        return false;
    }

    public boolean dN() {
        boolean z = false;
        try {
            File a2 = this.rR.a(this.sb.dT(), this.sb.getName(), false, this.sb.dY());
            File a3 = this.rR.a(this.sb.dU(), this.sb.eb(), true, this.sb.dY());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.sb.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.sb.dQ();
        }
        return z;
    }

    public boolean dO() {
        boolean z = false;
        try {
            if (this.sb.ec() != null) {
                z = this.sb.ec().a(this, this.sb, this.rR);
            }
            if (z) {
                this.sb.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.sb.dQ();
        }
        return z;
    }
}
