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
    private static /* synthetic */ int[] rq;
    protected final int BUFFER_SIZE = 1024;
    protected b re;
    protected AtomicBoolean ro;
    private DiskFileOperate rp;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] fq() {
        int[] iArr = rq;
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
            rq = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.ro.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.re = null;
        this.ro = null;
        this.rp = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.fs() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.ro = new AtomicBoolean(false);
        this.re = bVar;
        this.rp = diskFileOperate;
    }

    public boolean fk() {
        switch (fq()[this.rp.fs().ordinal()]) {
            case 1:
                return fm();
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
                return fl();
            case 8:
                return fn();
            case 9:
                return fo();
            case 10:
                return fp();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.rp instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.rp;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.ro.get(); i++) {
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

    private boolean fl() {
        boolean z = false;
        try {
            File c = this.re.c(this.rp.getPath(), false, this.rp.fz());
            z = d(c);
            if (z) {
                this.rp.e(c);
                this.rp.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rp.fr();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.re.a(this.rp.fu(), this.rp.getName(), false, this.rp.fz());
            if (a2 != null && !this.ro.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.rp.e(a2);
                    this.rp.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rp.fr();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean fm() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.re.a(this.rp.fu(), this.rp.getName(), false, this.rp.fz());
            if (a2 == null || !a2.exists() || this.ro.get()) {
                com.baidu.adp.lib.h.a.e((InputStream) null);
                com.baidu.adp.lib.h.a.b((OutputStream) null);
                this.rp.fr();
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
                        if (read == -1 || this.ro.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.ro.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.rp.fx() || this.rp.x(byteArray)) {
                            this.rp.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.h.a.e(fileInputStream);
                    com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                    if (z) {
                        this.rp.setSuccess(true);
                    }
                    this.rp.fr();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.e(fileInputStream2);
                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                        this.rp.fr();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.h.a.e(fileInputStream);
                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                        this.rp.fr();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.h.a.e(fileInputStream);
                    com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                    this.rp.fr();
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
                File a2 = this.re.a(this.rp.fu(), this.rp.getName(), true, this.rp.fz());
                if (a2 == null || this.ro.get()) {
                    com.baidu.adp.lib.h.a.b((OutputStream) null);
                    this.rp.fr();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.h.a.b((OutputStream) null);
                        this.rp.fr();
                        return true;
                    }
                    a2.delete();
                }
                byte[] ft = this.rp.ft();
                byte[] data = this.rp.getData();
                if ((ft == null && data == null) || this.ro.get()) {
                    com.baidu.adp.lib.h.a.b((OutputStream) null);
                    this.rp.fr();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (ft != null) {
                    try {
                        fileOutputStream2.write(ft);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
                        this.rp.fr();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
                        this.rp.fr();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                this.rp.e(a2);
                this.rp.setSuccess(true);
                this.rp.fr();
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
        OutputStream outputStream = this.rp.getOutputStream();
        File fy = this.rp.fy();
        if (outputStream == null) {
            try {
                try {
                    fy = this.re.a(this.rp.fu(), this.rp.getName(), true, this.rp.fz());
                    if (fy == null || this.ro.get()) {
                        if (!z) {
                            com.baidu.adp.lib.h.a.b(outputStream);
                        }
                        this.rp.fr();
                        return false;
                    }
                    outputStream = new FileOutputStream(fy, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.h.a.b(outputStream);
                    }
                    this.rp.fr();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.h.a.b(outputStream);
                }
                this.rp.fr();
                throw th;
            }
        }
        byte[] ft = this.rp.ft();
        byte[] data = this.rp.getData();
        if ((ft == null && data == null) || this.ro.get()) {
            if (!z) {
                com.baidu.adp.lib.h.a.b(outputStream);
            }
            this.rp.fr();
            return false;
        }
        if (ft != null) {
            outputStream.write(ft);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.rp.e(fy);
        this.rp.setSuccess(true);
        if (z) {
            this.rp.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.h.a.b(outputStream);
        }
        this.rp.fr();
        return true;
    }

    public boolean fn() {
        File c;
        if (this.rp.getName() != null) {
            c = this.re.a(this.rp.fu(), this.rp.getName(), false, this.rp.fz());
        } else {
            c = this.re.c(this.rp.fu(), false, this.rp.fz());
        }
        if (c != null && c.exists()) {
            this.rp.e(c);
            this.rp.setSuccess(true);
            this.rp.fr();
            return true;
        }
        this.rp.fr();
        return false;
    }

    public boolean fo() {
        boolean z = false;
        try {
            File a2 = this.re.a(this.rp.fu(), this.rp.getName(), false, this.rp.fz());
            File a3 = this.re.a(this.rp.fv(), this.rp.fC(), true, this.rp.fz());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.rp.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rp.fr();
        }
        return z;
    }

    public boolean fp() {
        boolean z = false;
        try {
            if (this.rp.fD() != null) {
                z = this.rp.fD().a(this, this.rp, this.re);
            }
            if (z) {
                this.rp.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rp.fr();
        }
        return z;
    }
}
