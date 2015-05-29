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
    private static /* synthetic */ int[] rs;
    protected final int BUFFER_SIZE = 1024;
    protected b rg;
    protected AtomicBoolean rq;
    private DiskFileOperate rr;

    static /* synthetic */ int[] fx() {
        int[] iArr = rs;
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
            rs = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.rq.set(true);
    }

    public boolean fq() {
        return this.rq.get();
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.rg = null;
        this.rq = null;
        this.rr = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.fz() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.rq = new AtomicBoolean(false);
        this.rg = bVar;
        this.rr = diskFileOperate;
    }

    public boolean fr() {
        switch (fx()[this.rr.fz().ordinal()]) {
            case 1:
                return ft();
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
                return fs();
            case 8:
                return fu();
            case 9:
                return fv();
            case 10:
                return fw();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.rr instanceof a)) {
            return false;
        }
        a aVar = (a) this.rr;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.rq.get(); i++) {
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

    private boolean fs() {
        boolean z = false;
        try {
            File b = this.rg.b(this.rr.getPath(), false, this.rr.fG());
            z = d(b);
            if (z) {
                this.rr.e(b);
                this.rr.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rr.fy();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a = this.rg.a(this.rr.fB(), this.rr.getName(), false, this.rr.fG());
            if (a != null && !this.rq.get()) {
                r0 = a.exists() ? a.delete() : false;
                if (r0) {
                    this.rr.e(a);
                    this.rr.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rr.fy();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean ft() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a = this.rg.a(this.rr.fB(), this.rr.getName(), false, this.rr.fG());
            if (a == null || !a.exists() || this.rq.get()) {
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.rr.fy();
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
                        if (read == -1 || this.rq.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.rq.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.rr.fE() || this.rr.k(byteArray)) {
                            this.rr.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                    if (z) {
                        this.rr.setSuccess(true);
                    }
                    this.rr.fy();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.d(fileInputStream2);
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        this.rr.fy();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        this.rr.fy();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                    this.rr.fy();
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
                File a = this.rg.a(this.rr.fB(), this.rr.getName(), true, this.rr.fG());
                if (a == null || this.rq.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.rr.fy();
                    return false;
                }
                if (a.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b((OutputStream) null);
                        this.rr.fy();
                        return true;
                    }
                    a.delete();
                }
                byte[] fA = this.rr.fA();
                byte[] data = this.rr.getData();
                if ((fA == null && data == null) || this.rq.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.rr.fy();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a);
                if (fA != null) {
                    try {
                        fileOutputStream2.write(fA);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.b(fileOutputStream);
                        this.rr.fy();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.b(fileOutputStream);
                        this.rr.fy();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.b(fileOutputStream2);
                this.rr.e(a);
                this.rr.setSuccess(true);
                this.rr.fy();
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
        OutputStream outputStream = this.rr.getOutputStream();
        File fF = this.rr.fF();
        if (outputStream == null) {
            try {
                try {
                    fF = this.rg.a(this.rr.fB(), this.rr.getName(), true, this.rr.fG());
                    if (fF == null || this.rq.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.b(outputStream);
                        }
                        this.rr.fy();
                        return false;
                    }
                    outputStream = new FileOutputStream(fF, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream);
                    }
                    this.rr.fy();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.rr.fy();
                throw th;
            }
        }
        byte[] fA = this.rr.fA();
        byte[] data = this.rr.getData();
        if ((fA == null && data == null) || this.rq.get()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.rr.fy();
            return false;
        }
        if (fA != null) {
            outputStream.write(fA);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.rr.e(fF);
        this.rr.setSuccess(true);
        if (z) {
            this.rr.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.g.a.b(outputStream);
        }
        this.rr.fy();
        return true;
    }

    public boolean fu() {
        File b;
        if (this.rr.getName() != null) {
            b = this.rg.a(this.rr.fB(), this.rr.getName(), false, this.rr.fG());
        } else {
            b = this.rg.b(this.rr.fB(), false, this.rr.fG());
        }
        if (b != null && b.exists()) {
            this.rr.e(b);
            this.rr.setSuccess(true);
            this.rr.fy();
            return true;
        }
        this.rr.fy();
        return false;
    }

    public boolean fv() {
        boolean z = false;
        try {
            File a = this.rg.a(this.rr.fB(), this.rr.getName(), false, this.rr.fG());
            File a2 = this.rg.a(this.rr.fC(), this.rr.fK(), true, this.rr.fG());
            if (a != null) {
                if (a2 != null) {
                    a2.delete();
                }
                z = a.renameTo(a2);
            }
            if (z) {
                this.rr.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rr.fy();
        }
        return z;
    }

    public boolean fw() {
        boolean z = false;
        try {
            if (this.rr.fL() != null) {
                z = this.rr.fL().a(this, this.rr, this.rg);
            }
            if (z) {
                this.rr.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rr.fy();
        }
        return z;
    }
}
