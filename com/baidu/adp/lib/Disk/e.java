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
    private static /* synthetic */ int[] hs;
    protected final int BUFFER_SIZE = 1024;
    protected b hh;
    protected AtomicBoolean hq;
    private DiskFileOperate hr;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] bO() {
        int[] iArr = hs;
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
            hs = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.hq.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.hh = null;
        this.hq = null;
        this.hr = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.bQ() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.hq = new AtomicBoolean(false);
        this.hh = bVar;
        this.hr = diskFileOperate;
    }

    public boolean bI() {
        switch (bO()[this.hr.bQ().ordinal()]) {
            case 1:
                return bK();
            case 2:
                return l(false);
            case 3:
                return l(true);
            case 4:
                return m(false);
            case 5:
                return m(true);
            case 6:
                return delete();
            case 7:
                return bJ();
            case 8:
                return bL();
            case 9:
                return bM();
            case 10:
                return bN();
            default:
                return false;
        }
    }

    private boolean c(File file) {
        if (file == null || !(this.hr instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.hr;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.hq.get(); i++) {
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

    private boolean bJ() {
        boolean z = false;
        try {
            File c = this.hh.c(this.hr.getPath(), false, this.hr.bX());
            z = c(c);
            if (z) {
                this.hr.d(c);
                this.hr.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.hr.bP();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.hh.a(this.hr.bS(), this.hr.getName(), false, this.hr.bX());
            if (a2 != null && !this.hq.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.hr.d(a2);
                    this.hr.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.hr.bP();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean bK() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.hh.a(this.hr.bS(), this.hr.getName(), false, this.hr.bX());
            if (a2 == null || !a2.exists() || this.hq.get()) {
                com.baidu.adp.lib.h.a.c(null);
                com.baidu.adp.lib.h.a.b((OutputStream) null);
                this.hr.bP();
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
                        if (read == -1 || this.hq.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.hq.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.hr.bV() || this.hr.h(byteArray)) {
                            this.hr.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.h.a.c(fileInputStream);
                    com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                    if (z) {
                        this.hr.setSuccess(true);
                    }
                    this.hr.bP();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.c(fileInputStream2);
                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                        this.hr.bP();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.h.a.c(fileInputStream);
                        com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                        this.hr.bP();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.h.a.c(fileInputStream);
                    com.baidu.adp.lib.h.a.b((OutputStream) byteArrayOutputStream);
                    this.hr.bP();
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
    public boolean l(boolean z) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                File a2 = this.hh.a(this.hr.bS(), this.hr.getName(), true, this.hr.bX());
                if (a2 == null || this.hq.get()) {
                    com.baidu.adp.lib.h.a.b((OutputStream) null);
                    this.hr.bP();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.h.a.b((OutputStream) null);
                        this.hr.bP();
                        return true;
                    }
                    a2.delete();
                }
                byte[] bR = this.hr.bR();
                byte[] data = this.hr.getData();
                if ((bR == null && data == null) || this.hq.get()) {
                    com.baidu.adp.lib.h.a.b((OutputStream) null);
                    this.hr.bP();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (bR != null) {
                    try {
                        fileOutputStream2.write(bR);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
                        this.hr.bP();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream);
                        this.hr.bP();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.h.a.b((OutputStream) fileOutputStream2);
                this.hr.d(a2);
                this.hr.setSuccess(true);
                this.hr.bP();
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
    public boolean m(boolean z) {
        OutputStream outputStream = this.hr.getOutputStream();
        File bW = this.hr.bW();
        if (outputStream == null) {
            try {
                try {
                    bW = this.hh.a(this.hr.bS(), this.hr.getName(), true, this.hr.bX());
                    if (bW == null || this.hq.get()) {
                        if (!z) {
                            com.baidu.adp.lib.h.a.b(outputStream);
                        }
                        this.hr.bP();
                        return false;
                    }
                    outputStream = new FileOutputStream(bW, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.h.a.b(outputStream);
                    }
                    this.hr.bP();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.h.a.b(outputStream);
                }
                this.hr.bP();
                throw th;
            }
        }
        byte[] bR = this.hr.bR();
        byte[] data = this.hr.getData();
        if ((bR == null && data == null) || this.hq.get()) {
            if (!z) {
                com.baidu.adp.lib.h.a.b(outputStream);
            }
            this.hr.bP();
            return false;
        }
        if (bR != null) {
            outputStream.write(bR);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.hr.d(bW);
        this.hr.setSuccess(true);
        if (z) {
            this.hr.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.h.a.b(outputStream);
        }
        this.hr.bP();
        return true;
    }

    public boolean bL() {
        File c;
        if (this.hr.getName() != null) {
            c = this.hh.a(this.hr.bS(), this.hr.getName(), false, this.hr.bX());
        } else {
            c = this.hh.c(this.hr.bS(), false, this.hr.bX());
        }
        if (c != null && c.exists()) {
            this.hr.d(c);
            this.hr.setSuccess(true);
            this.hr.bP();
            return true;
        }
        this.hr.bP();
        return false;
    }

    public boolean bM() {
        boolean z = false;
        try {
            File a2 = this.hh.a(this.hr.bS(), this.hr.getName(), false, this.hr.bX());
            File a3 = this.hh.a(this.hr.bT(), this.hr.ca(), true, this.hr.bX());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.hr.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.hr.bP();
        }
        return z;
    }

    public boolean bN() {
        boolean z = false;
        try {
            if (this.hr.cb() != null) {
                z = this.hr.cb().a(this, this.hr, this.hh);
            }
            if (z) {
                this.hr.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.hr.bP();
        }
        return z;
    }
}
