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
    private static /* synthetic */ int[] rx;
    protected final int BUFFER_SIZE = 1024;
    protected b rl;
    protected AtomicBoolean rv;
    private DiskFileOperate rw;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] fy() {
        int[] iArr = rx;
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
            rx = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.rv.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.rl = null;
        this.rv = null;
        this.rw = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.fA() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.rv = new AtomicBoolean(false);
        this.rl = bVar;
        this.rw = diskFileOperate;
    }

    public boolean fs() {
        switch (fy()[this.rw.fA().ordinal()]) {
            case 1:
                return fu();
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
                return ft();
            case 8:
                return fv();
            case 9:
                return fw();
            case 10:
                return fx();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.rw instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.rw;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.rv.get(); i++) {
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

    private boolean ft() {
        boolean z = false;
        try {
            File c = this.rl.c(this.rw.getPath(), false, this.rw.fH());
            z = d(c);
            if (z) {
                this.rw.e(c);
                this.rw.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rw.fz();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.rl.a(this.rw.fC(), this.rw.getName(), false, this.rw.fH());
            if (a2 != null && !this.rv.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.rw.e(a2);
                    this.rw.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rw.fz();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean fu() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.rl.a(this.rw.fC(), this.rw.getName(), false, this.rw.fH());
            if (a2 == null || !a2.exists() || this.rv.get()) {
                com.baidu.adp.lib.h.a.e((InputStream) null);
                com.baidu.adp.lib.h.a.b((OutputStream) null);
                this.rw.fz();
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
                        if (read == -1 || this.rv.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.rv.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.rw.fF() || this.rw.x(byteArray)) {
                            this.rw.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.h.a.e(fileInputStream);
                    com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                    if (z) {
                        this.rw.setSuccess(true);
                    }
                    this.rw.fz();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.e(fileInputStream2);
                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                        this.rw.fz();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.h.a.e(fileInputStream);
                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                        this.rw.fz();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.h.a.e(fileInputStream);
                    com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                    this.rw.fz();
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
                File a2 = this.rl.a(this.rw.fC(), this.rw.getName(), true, this.rw.fH());
                if (a2 == null || this.rv.get()) {
                    com.baidu.adp.lib.h.a.b((OutputStream) null);
                    this.rw.fz();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.h.a.b((OutputStream) null);
                        this.rw.fz();
                        return true;
                    }
                    a2.delete();
                }
                byte[] fB = this.rw.fB();
                byte[] data = this.rw.getData();
                if ((fB == null && data == null) || this.rv.get()) {
                    com.baidu.adp.lib.h.a.b((OutputStream) null);
                    this.rw.fz();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (fB != null) {
                    try {
                        fileOutputStream2.write(fB);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
                        this.rw.fz();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
                        this.rw.fz();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                this.rw.e(a2);
                this.rw.setSuccess(true);
                this.rw.fz();
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
        OutputStream outputStream = this.rw.getOutputStream();
        File fG = this.rw.fG();
        if (outputStream == null) {
            try {
                try {
                    fG = this.rl.a(this.rw.fC(), this.rw.getName(), true, this.rw.fH());
                    if (fG == null || this.rv.get()) {
                        if (!z) {
                            com.baidu.adp.lib.h.a.b(outputStream);
                        }
                        this.rw.fz();
                        return false;
                    }
                    outputStream = new FileOutputStream(fG, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.h.a.b(outputStream);
                    }
                    this.rw.fz();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.h.a.b(outputStream);
                }
                this.rw.fz();
                throw th;
            }
        }
        byte[] fB = this.rw.fB();
        byte[] data = this.rw.getData();
        if ((fB == null && data == null) || this.rv.get()) {
            if (!z) {
                com.baidu.adp.lib.h.a.b(outputStream);
            }
            this.rw.fz();
            return false;
        }
        if (fB != null) {
            outputStream.write(fB);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.rw.e(fG);
        this.rw.setSuccess(true);
        if (z) {
            this.rw.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.h.a.b(outputStream);
        }
        this.rw.fz();
        return true;
    }

    public boolean fv() {
        File c;
        if (this.rw.getName() != null) {
            c = this.rl.a(this.rw.fC(), this.rw.getName(), false, this.rw.fH());
        } else {
            c = this.rl.c(this.rw.fC(), false, this.rw.fH());
        }
        if (c != null && c.exists()) {
            this.rw.e(c);
            this.rw.setSuccess(true);
            this.rw.fz();
            return true;
        }
        this.rw.fz();
        return false;
    }

    public boolean fw() {
        boolean z = false;
        try {
            File a2 = this.rl.a(this.rw.fC(), this.rw.getName(), false, this.rw.fH());
            File a3 = this.rl.a(this.rw.fD(), this.rw.fK(), true, this.rw.fH());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.rw.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rw.fz();
        }
        return z;
    }

    public boolean fx() {
        boolean z = false;
        try {
            if (this.rw.fL() != null) {
                z = this.rw.fL().a(this, this.rw, this.rl);
            }
            if (z) {
                this.rw.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rw.fz();
        }
        return z;
    }
}
