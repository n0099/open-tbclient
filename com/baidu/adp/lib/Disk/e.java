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
    private static /* synthetic */ int[] rp;
    protected final int BUFFER_SIZE = 1024;
    protected b rd;
    protected AtomicBoolean rm;
    private DiskFileOperate ro;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] ft() {
        int[] iArr = rp;
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
            rp = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.rm.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.rd = null;
        this.rm = null;
        this.ro = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.fv() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.rm = new AtomicBoolean(false);
        this.rd = bVar;
        this.ro = diskFileOperate;
    }

    public boolean fn() {
        switch (ft()[this.ro.fv().ordinal()]) {
            case 1:
                return fp();
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
                return fo();
            case 8:
                return fq();
            case 9:
                return fr();
            case 10:
                return fs();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.ro instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.ro;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.rm.get(); i++) {
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

    private boolean fo() {
        boolean z = false;
        try {
            File c = this.rd.c(this.ro.getPath(), false, this.ro.fC());
            z = d(c);
            if (z) {
                this.ro.e(c);
                this.ro.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.ro.fu();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.rd.a(this.ro.fx(), this.ro.getName(), false, this.ro.fC());
            if (a2 != null && !this.rm.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.ro.e(a2);
                    this.ro.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.ro.fu();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean fp() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.rd.a(this.ro.fx(), this.ro.getName(), false, this.ro.fC());
            if (a2 == null || !a2.exists() || this.rm.get()) {
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.ro.fu();
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
                        if (read == -1 || this.rm.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.rm.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.ro.fA() || this.ro.x(byteArray)) {
                            this.ro.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    if (z) {
                        this.ro.setSuccess(true);
                    }
                    this.ro.fu();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.d(fileInputStream2);
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        this.ro.fu();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                        this.ro.fu();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    this.ro.fu();
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
                File a2 = this.rd.a(this.ro.fx(), this.ro.getName(), true, this.ro.fC());
                if (a2 == null || this.rm.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.ro.fu();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b((OutputStream) null);
                        this.ro.fu();
                        return true;
                    }
                    a2.delete();
                }
                byte[] fw = this.ro.fw();
                byte[] data = this.ro.getData();
                if ((fw == null && data == null) || this.rm.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.ro.fu();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (fw != null) {
                    try {
                        fileOutputStream2.write(fw);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        this.ro.fu();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                        this.ro.fu();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.ro.e(a2);
                this.ro.setSuccess(true);
                this.ro.fu();
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
        OutputStream outputStream = this.ro.getOutputStream();
        File fB = this.ro.fB();
        if (outputStream == null) {
            try {
                try {
                    fB = this.rd.a(this.ro.fx(), this.ro.getName(), true, this.ro.fC());
                    if (fB == null || this.rm.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.b(outputStream);
                        }
                        this.ro.fu();
                        return false;
                    }
                    outputStream = new FileOutputStream(fB, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream);
                    }
                    this.ro.fu();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.ro.fu();
                throw th;
            }
        }
        byte[] fw = this.ro.fw();
        byte[] data = this.ro.getData();
        if ((fw == null && data == null) || this.rm.get()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.ro.fu();
            return false;
        }
        if (fw != null) {
            outputStream.write(fw);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.ro.e(fB);
        this.ro.setSuccess(true);
        if (z) {
            this.ro.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.g.a.b(outputStream);
        }
        this.ro.fu();
        return true;
    }

    public boolean fq() {
        File c;
        if (this.ro.getName() != null) {
            c = this.rd.a(this.ro.fx(), this.ro.getName(), false, this.ro.fC());
        } else {
            c = this.rd.c(this.ro.fx(), false, this.ro.fC());
        }
        if (c != null && c.exists()) {
            this.ro.e(c);
            this.ro.setSuccess(true);
            this.ro.fu();
            return true;
        }
        this.ro.fu();
        return false;
    }

    public boolean fr() {
        boolean z = false;
        try {
            File a2 = this.rd.a(this.ro.fx(), this.ro.getName(), false, this.ro.fC());
            File a3 = this.rd.a(this.ro.fy(), this.ro.fF(), true, this.ro.fC());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.ro.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.ro.fu();
        }
        return z;
    }

    public boolean fs() {
        boolean z = false;
        try {
            if (this.ro.fG() != null) {
                z = this.ro.fG().a(this, this.ro, this.rd);
            }
            if (z) {
                this.ro.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.ro.fu();
        }
        return z;
    }
}
