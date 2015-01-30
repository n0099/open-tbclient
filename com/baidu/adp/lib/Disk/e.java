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
    private static /* synthetic */ int[] fO;
    protected final int BUFFER_SIZE = 1024;
    protected b fI;
    protected AtomicBoolean fM;
    private DiskFileOperate fN;

    static /* synthetic */ int[] bU() {
        int[] iArr = fO;
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
            fO = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.fM.set(true);
    }

    public boolean bN() {
        return this.fM.get();
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.fI = null;
        this.fM = null;
        this.fN = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.bW() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.fM = new AtomicBoolean(false);
        this.fI = bVar;
        this.fN = diskFileOperate;
    }

    public boolean bO() {
        switch (bU()[this.fN.bW().ordinal()]) {
            case 1:
                return bQ();
            case 2:
                return m(false);
            case 3:
                return m(true);
            case 4:
                return n(false);
            case 5:
                return n(true);
            case 6:
                return delete();
            case 7:
                return bP();
            case 8:
                return bR();
            case 9:
                return bS();
            case 10:
                return bT();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.fN instanceof a)) {
            return false;
        }
        a aVar = (a) this.fN;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.fM.get(); i++) {
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

    private boolean bP() {
        boolean z = false;
        try {
            File b = this.fI.b(this.fN.getPath(), false, this.fN.cd());
            z = d(b);
            if (z) {
                this.fN.e(b);
                this.fN.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.fN.bV();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a = this.fI.a(this.fN.bY(), this.fN.getName(), false, this.fN.cd());
            if (a != null && !this.fM.get()) {
                r0 = a.exists() ? a.delete() : false;
                if (r0) {
                    this.fN.e(a);
                    this.fN.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.fN.bV();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean bQ() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a = this.fI.a(this.fN.bY(), this.fN.getName(), false, this.fN.cd());
            if (a == null || !a.exists() || this.fM.get()) {
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.fN.bV();
            } else {
                fileInputStream = new FileInputStream(a);
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
                        if (read == -1 || this.fM.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.fM.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.fN.cb() || this.fN.j(byteArray)) {
                            this.fN.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                    if (z) {
                        this.fN.setSuccess(true);
                    }
                    this.fN.bV();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.d(fileInputStream2);
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        this.fN.bV();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        this.fN.bV();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                    this.fN.bV();
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
    public boolean m(boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File a = this.fI.a(this.fN.bY(), this.fN.getName(), true, this.fN.cd());
                if (a == null || this.fM.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.fN.bV();
                    return false;
                }
                if (a.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b((OutputStream) null);
                        this.fN.bV();
                        return true;
                    }
                    a.delete();
                }
                byte[] bX = this.fN.bX();
                byte[] data = this.fN.getData();
                if ((bX == null && data == null) || this.fM.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.fN.bV();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a);
                if (bX != null) {
                    try {
                        fileOutputStream2.write(bX);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.b(fileOutputStream);
                        this.fN.bV();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.b(fileOutputStream);
                        this.fN.bV();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.b(fileOutputStream2);
                this.fN.e(a);
                this.fN.setSuccess(true);
                this.fN.bV();
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
    public boolean n(boolean z) {
        OutputStream outputStream = this.fN.getOutputStream();
        File cc = this.fN.cc();
        if (outputStream == null) {
            try {
                try {
                    cc = this.fI.a(this.fN.bY(), this.fN.getName(), true, this.fN.cd());
                    if (cc == null || this.fM.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.b(outputStream);
                        }
                        this.fN.bV();
                        return false;
                    }
                    outputStream = new FileOutputStream(cc, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream);
                    }
                    this.fN.bV();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.fN.bV();
                throw th;
            }
        }
        byte[] bX = this.fN.bX();
        byte[] data = this.fN.getData();
        if ((bX == null && data == null) || this.fM.get()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.fN.bV();
            return false;
        }
        if (bX != null) {
            outputStream.write(bX);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.fN.e(cc);
        this.fN.setSuccess(true);
        if (z) {
            this.fN.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.g.a.b(outputStream);
        }
        this.fN.bV();
        return true;
    }

    public boolean bR() {
        File b;
        if (this.fN.getName() != null) {
            b = this.fI.a(this.fN.bY(), this.fN.getName(), false, this.fN.cd());
        } else {
            b = this.fI.b(this.fN.bY(), false, this.fN.cd());
        }
        if (b != null && b.exists()) {
            this.fN.e(b);
            this.fN.setSuccess(true);
            this.fN.bV();
            return true;
        }
        this.fN.bV();
        return false;
    }

    public boolean bS() {
        boolean z = false;
        try {
            File a = this.fI.a(this.fN.bY(), this.fN.getName(), false, this.fN.cd());
            File a2 = this.fI.a(this.fN.bZ(), this.fN.ch(), true, this.fN.cd());
            if (a != null) {
                if (a2 != null) {
                    a2.delete();
                }
                z = a.renameTo(a2);
            }
            if (z) {
                this.fN.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.fN.bV();
        }
        return z;
    }

    public boolean bT() {
        boolean z = false;
        try {
            if (this.fN.ci() != null) {
                z = this.fN.ci().a(this, this.fN, this.fI);
            }
            if (z) {
                this.fN.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.fN.bV();
        }
        return z;
    }
}
