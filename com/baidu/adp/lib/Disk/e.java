package com.baidu.adp.lib.Disk;

import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    private static /* synthetic */ int[] dH;
    protected final int BUFFER_SIZE = 1024;
    protected b dB;
    protected AtomicBoolean dF;
    private DiskFileOperate dG;

    static /* synthetic */ int[] bv() {
        int[] iArr = dH;
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
            dH = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.dF.set(true);
    }

    public boolean bo() {
        return this.dF.get();
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.dB = null;
        this.dF = null;
        this.dG = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.bx() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.dF = new AtomicBoolean(false);
        this.dB = bVar;
        this.dG = diskFileOperate;
    }

    public boolean bp() {
        switch (bv()[this.dG.bx().ordinal()]) {
            case 1:
                return br();
            case 2:
                return i(false);
            case 3:
                return i(true);
            case 4:
                return j(false);
            case 5:
                return j(true);
            case 6:
                return delete();
            case 7:
                return bq();
            case 8:
                return bs();
            case 9:
                return bt();
            case 10:
                return bu();
            default:
                return false;
        }
    }

    private boolean c(File file) {
        if (file == null || !(this.dG instanceof a)) {
            return false;
        }
        a aVar = (a) this.dG;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.dF.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        c(listFiles[i]);
                    } else if (aVar.b(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (aVar.b(file)) {
            file.delete();
        }
        return true;
    }

    private boolean bq() {
        boolean z = false;
        try {
            File b = this.dB.b(this.dG.getPath(), false, this.dG.bE());
            z = c(b);
            if (z) {
                this.dG.d(b);
                this.dG.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.dG.bw();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a = this.dB.a(this.dG.bz(), this.dG.getName(), false, this.dG.bE());
            if (a != null && !this.dF.get()) {
                r0 = a.exists() ? a.delete() : false;
                if (r0) {
                    this.dG.d(a);
                    this.dG.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.dG.bw();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean br() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a = this.dB.a(this.dG.bz(), this.dG.getName(), false, this.dG.bE());
            if (a == null || !a.exists() || this.dF.get()) {
                com.baidu.adp.lib.g.a.a((InputStream) null);
                com.baidu.adp.lib.g.a.a((OutputStream) null);
                this.dG.bw();
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
                        if (read == -1 || this.dF.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.dF.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.dG.bC() || this.dG.i(byteArray)) {
                            this.dG.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.g.a.a((InputStream) fileInputStream);
                    com.baidu.adp.lib.g.a.a((OutputStream) byteArrayOutputStream);
                    if (z) {
                        this.dG.setSuccess(true);
                    }
                    this.dG.bw();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.a((InputStream) fileInputStream2);
                        com.baidu.adp.lib.g.a.a((OutputStream) byteArrayOutputStream);
                        this.dG.bw();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.a((InputStream) fileInputStream);
                        com.baidu.adp.lib.g.a.a((OutputStream) byteArrayOutputStream);
                        this.dG.bw();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.g.a.a((InputStream) fileInputStream);
                    com.baidu.adp.lib.g.a.a((OutputStream) byteArrayOutputStream);
                    this.dG.bw();
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
    public boolean i(boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File a = this.dB.a(this.dG.bz(), this.dG.getName(), true, this.dG.bE());
                if (a == null || this.dF.get()) {
                    com.baidu.adp.lib.g.a.a((OutputStream) null);
                    this.dG.bw();
                    return false;
                }
                if (a.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.a((OutputStream) null);
                        this.dG.bw();
                        return true;
                    }
                    a.delete();
                }
                byte[] by = this.dG.by();
                byte[] data = this.dG.getData();
                if ((by == null && data == null) || this.dF.get()) {
                    com.baidu.adp.lib.g.a.a((OutputStream) null);
                    this.dG.bw();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a);
                if (by != null) {
                    try {
                        fileOutputStream2.write(by);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.a((OutputStream) fileOutputStream);
                        this.dG.bw();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.a((OutputStream) fileOutputStream);
                        this.dG.bw();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.a((OutputStream) fileOutputStream2);
                this.dG.d(a);
                this.dG.setSuccess(true);
                this.dG.bw();
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
    public boolean j(boolean z) {
        OutputStream outputStream = this.dG.getOutputStream();
        File bD = this.dG.bD();
        if (outputStream == null) {
            try {
                try {
                    bD = this.dB.a(this.dG.bz(), this.dG.getName(), true, this.dG.bE());
                    if (bD == null || this.dF.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.a(outputStream);
                        }
                        this.dG.bw();
                        return false;
                    }
                    outputStream = new FileOutputStream(bD, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.a(outputStream);
                    }
                    this.dG.bw();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.g.a.a(outputStream);
                }
                this.dG.bw();
                throw th;
            }
        }
        byte[] by = this.dG.by();
        byte[] data = this.dG.getData();
        if ((by == null && data == null) || this.dF.get()) {
            if (!z) {
                com.baidu.adp.lib.g.a.a(outputStream);
            }
            this.dG.bw();
            return false;
        }
        if (by != null) {
            outputStream.write(by);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.dG.d(bD);
        this.dG.setSuccess(true);
        if (z) {
            this.dG.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.g.a.a(outputStream);
        }
        this.dG.bw();
        return true;
    }

    public boolean bs() {
        File b;
        if (this.dG.getName() != null) {
            b = this.dB.a(this.dG.bz(), this.dG.getName(), false, this.dG.bE());
        } else {
            b = this.dB.b(this.dG.bz(), false, this.dG.bE());
        }
        if (b != null && b.exists()) {
            this.dG.d(b);
            this.dG.setSuccess(true);
            this.dG.bw();
            return true;
        }
        this.dG.bw();
        return false;
    }

    public boolean bt() {
        boolean z = false;
        try {
            File a = this.dB.a(this.dG.bz(), this.dG.getName(), false, this.dG.bE());
            File a2 = this.dB.a(this.dG.bA(), this.dG.bI(), true, this.dG.bE());
            if (a != null) {
                if (a2 != null) {
                    a2.delete();
                }
                z = a.renameTo(a2);
            }
            if (z) {
                this.dG.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.dG.bw();
        }
        return z;
    }

    public boolean bu() {
        boolean z = false;
        try {
            if (this.dG.bJ() != null) {
                z = this.dG.bJ().a(this, this.dG, this.dB);
            }
            if (z) {
                this.dG.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.dG.bw();
        }
        return z;
    }
}
