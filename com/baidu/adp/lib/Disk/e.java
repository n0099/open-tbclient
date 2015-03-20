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
    private static /* synthetic */ int[] rh;
    protected final int BUFFER_SIZE = 1024;
    protected b rb;
    protected AtomicBoolean rf;
    private DiskFileOperate rg;

    static /* synthetic */ int[] fs() {
        int[] iArr = rh;
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
            rh = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.rf.set(true);
    }

    public boolean fl() {
        return this.rf.get();
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.rb = null;
        this.rf = null;
        this.rg = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.fu() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.rf = new AtomicBoolean(false);
        this.rb = bVar;
        this.rg = diskFileOperate;
    }

    public boolean fm() {
        switch (fs()[this.rg.fu().ordinal()]) {
            case 1:
                return fo();
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
                return fn();
            case 8:
                return fp();
            case 9:
                return fq();
            case 10:
                return fr();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.rg instanceof a)) {
            return false;
        }
        a aVar = (a) this.rg;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.rf.get(); i++) {
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

    private boolean fn() {
        boolean z = false;
        try {
            File b = this.rb.b(this.rg.getPath(), false, this.rg.fB());
            z = d(b);
            if (z) {
                this.rg.e(b);
                this.rg.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rg.ft();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a = this.rb.a(this.rg.fw(), this.rg.getName(), false, this.rg.fB());
            if (a != null && !this.rf.get()) {
                r0 = a.exists() ? a.delete() : false;
                if (r0) {
                    this.rg.e(a);
                    this.rg.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rg.ft();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean fo() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a = this.rb.a(this.rg.fw(), this.rg.getName(), false, this.rg.fB());
            if (a == null || !a.exists() || this.rf.get()) {
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.rg.ft();
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
                        if (read == -1 || this.rf.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.rf.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.rg.fz() || this.rg.k(byteArray)) {
                            this.rg.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                    if (z) {
                        this.rg.setSuccess(true);
                    }
                    this.rg.ft();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.d(fileInputStream2);
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        this.rg.ft();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        this.rg.ft();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                    this.rg.ft();
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
                File a = this.rb.a(this.rg.fw(), this.rg.getName(), true, this.rg.fB());
                if (a == null || this.rf.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.rg.ft();
                    return false;
                }
                if (a.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b((OutputStream) null);
                        this.rg.ft();
                        return true;
                    }
                    a.delete();
                }
                byte[] fv = this.rg.fv();
                byte[] data = this.rg.getData();
                if ((fv == null && data == null) || this.rf.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.rg.ft();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a);
                if (fv != null) {
                    try {
                        fileOutputStream2.write(fv);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.b(fileOutputStream);
                        this.rg.ft();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.b(fileOutputStream);
                        this.rg.ft();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.b(fileOutputStream2);
                this.rg.e(a);
                this.rg.setSuccess(true);
                this.rg.ft();
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
        OutputStream outputStream = this.rg.getOutputStream();
        File fA = this.rg.fA();
        if (outputStream == null) {
            try {
                try {
                    fA = this.rb.a(this.rg.fw(), this.rg.getName(), true, this.rg.fB());
                    if (fA == null || this.rf.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.b(outputStream);
                        }
                        this.rg.ft();
                        return false;
                    }
                    outputStream = new FileOutputStream(fA, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream);
                    }
                    this.rg.ft();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.rg.ft();
                throw th;
            }
        }
        byte[] fv = this.rg.fv();
        byte[] data = this.rg.getData();
        if ((fv == null && data == null) || this.rf.get()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.rg.ft();
            return false;
        }
        if (fv != null) {
            outputStream.write(fv);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.rg.e(fA);
        this.rg.setSuccess(true);
        if (z) {
            this.rg.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.g.a.b(outputStream);
        }
        this.rg.ft();
        return true;
    }

    public boolean fp() {
        File b;
        if (this.rg.getName() != null) {
            b = this.rb.a(this.rg.fw(), this.rg.getName(), false, this.rg.fB());
        } else {
            b = this.rb.b(this.rg.fw(), false, this.rg.fB());
        }
        if (b != null && b.exists()) {
            this.rg.e(b);
            this.rg.setSuccess(true);
            this.rg.ft();
            return true;
        }
        this.rg.ft();
        return false;
    }

    public boolean fq() {
        boolean z = false;
        try {
            File a = this.rb.a(this.rg.fw(), this.rg.getName(), false, this.rg.fB());
            File a2 = this.rb.a(this.rg.fx(), this.rg.fF(), true, this.rg.fB());
            if (a != null) {
                if (a2 != null) {
                    a2.delete();
                }
                z = a.renameTo(a2);
            }
            if (z) {
                this.rg.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rg.ft();
        }
        return z;
    }

    public boolean fr() {
        boolean z = false;
        try {
            if (this.rg.fG() != null) {
                z = this.rg.fG().a(this, this.rg, this.rb);
            }
            if (z) {
                this.rg.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rg.ft();
        }
        return z;
    }
}
