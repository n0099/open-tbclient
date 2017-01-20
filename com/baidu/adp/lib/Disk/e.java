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
    private static /* synthetic */ int[] kh;
    protected final int BUFFER_SIZE = 1024;
    protected b jV;
    protected AtomicBoolean kf;
    private DiskFileOperate kg;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] cG() {
        int[] iArr = kh;
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
            kh = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.kf.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.jV = null;
        this.kf = null;
        this.kg = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.cI() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.kf = new AtomicBoolean(false);
        this.jV = bVar;
        this.kg = diskFileOperate;
    }

    public boolean cA() {
        switch (cG()[this.kg.cI().ordinal()]) {
            case 1:
                return cC();
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
                return cB();
            case 8:
                return cD();
            case 9:
                return cE();
            case 10:
                return cF();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.kg instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.kg;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.kf.get(); i++) {
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

    private boolean cB() {
        boolean z = false;
        try {
            File c = this.jV.c(this.kg.getPath(), false, this.kg.cP());
            z = d(c);
            if (z) {
                this.kg.e(c);
                this.kg.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.kg.cH();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.jV.a(this.kg.cK(), this.kg.getName(), false, this.kg.cP());
            if (a2 != null && !this.kf.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.kg.e(a2);
                    this.kg.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.kg.cH();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean cC() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.jV.a(this.kg.cK(), this.kg.getName(), false, this.kg.cP());
            if (a2 == null || !a2.exists() || this.kf.get()) {
                com.baidu.adp.lib.g.a.j(null);
                com.baidu.adp.lib.g.a.d(null);
                this.kg.cH();
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
                        if (read == -1 || this.kf.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.kf.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.kg.cN() || this.kg.k(byteArray)) {
                            this.kg.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.g.a.j(fileInputStream);
                    com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                    if (z) {
                        this.kg.setSuccess(true);
                    }
                    this.kg.cH();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.j(fileInputStream2);
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        this.kg.cH();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.j(fileInputStream);
                        com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                        this.kg.cH();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.g.a.j(fileInputStream);
                    com.baidu.adp.lib.g.a.d(byteArrayOutputStream);
                    this.kg.cH();
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
                File a2 = this.jV.a(this.kg.cK(), this.kg.getName(), true, this.kg.cP());
                if (a2 == null || this.kf.get()) {
                    com.baidu.adp.lib.g.a.d(null);
                    this.kg.cH();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.d(null);
                        this.kg.cH();
                        return true;
                    }
                    a2.delete();
                }
                byte[] cJ = this.kg.cJ();
                byte[] data = this.kg.getData();
                if ((cJ == null && data == null) || this.kf.get()) {
                    com.baidu.adp.lib.g.a.d(null);
                    this.kg.cH();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (cJ != null) {
                    try {
                        fileOutputStream2.write(cJ);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.d(fileOutputStream);
                        this.kg.cH();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.d(fileOutputStream);
                        this.kg.cH();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.d(fileOutputStream2);
                this.kg.e(a2);
                this.kg.setSuccess(true);
                this.kg.cH();
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
        OutputStream outputStream = this.kg.getOutputStream();
        File cO = this.kg.cO();
        if (outputStream == null) {
            try {
                try {
                    cO = this.jV.a(this.kg.cK(), this.kg.getName(), true, this.kg.cP());
                    if (cO == null || this.kf.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.d(outputStream);
                        }
                        this.kg.cH();
                        return false;
                    }
                    outputStream = new FileOutputStream(cO, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.d(outputStream);
                    }
                    this.kg.cH();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.g.a.d(outputStream);
                }
                this.kg.cH();
                throw th;
            }
        }
        byte[] cJ = this.kg.cJ();
        byte[] data = this.kg.getData();
        if ((cJ == null && data == null) || this.kf.get()) {
            if (!z) {
                com.baidu.adp.lib.g.a.d(outputStream);
            }
            this.kg.cH();
            return false;
        }
        if (cJ != null) {
            outputStream.write(cJ);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.kg.e(cO);
        this.kg.setSuccess(true);
        if (z) {
            this.kg.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.g.a.d(outputStream);
        }
        this.kg.cH();
        return true;
    }

    public boolean cD() {
        File c;
        if (this.kg.getName() != null) {
            c = this.jV.a(this.kg.cK(), this.kg.getName(), false, this.kg.cP());
        } else {
            c = this.jV.c(this.kg.cK(), false, this.kg.cP());
        }
        if (c != null && c.exists()) {
            this.kg.e(c);
            this.kg.setSuccess(true);
            this.kg.cH();
            return true;
        }
        this.kg.cH();
        return false;
    }

    public boolean cE() {
        boolean z = false;
        try {
            File a2 = this.jV.a(this.kg.cK(), this.kg.getName(), false, this.kg.cP());
            File a3 = this.jV.a(this.kg.cL(), this.kg.cS(), true, this.kg.cP());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.kg.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.kg.cH();
        }
        return z;
    }

    public boolean cF() {
        boolean z = false;
        try {
            if (this.kg.cT() != null) {
                z = this.kg.cT().a(this, this.kg, this.jV);
            }
            if (z) {
                this.kg.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.kg.cH();
        }
        return z;
    }
}
