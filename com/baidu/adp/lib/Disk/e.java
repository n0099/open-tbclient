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
    private static /* synthetic */ int[] ht;
    protected final int BUFFER_SIZE = 1024;
    protected b hi;
    protected AtomicBoolean hr;
    private DiskFileOperate hs;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] bN() {
        int[] iArr = ht;
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
            ht = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.hr.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.hi = null;
        this.hr = null;
        this.hs = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.bP() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.hr = new AtomicBoolean(false);
        this.hi = bVar;
        this.hs = diskFileOperate;
    }

    public boolean bH() {
        switch (bN()[this.hs.bP().ordinal()]) {
            case 1:
                return bJ();
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
                return bI();
            case 8:
                return bK();
            case 9:
                return bL();
            case 10:
                return bM();
            default:
                return false;
        }
    }

    private boolean c(File file) {
        if (file == null || !(this.hs instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.hs;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.hr.get(); i++) {
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

    private boolean bI() {
        boolean z = false;
        try {
            File c = this.hi.c(this.hs.getPath(), false, this.hs.bW());
            z = c(c);
            if (z) {
                this.hs.d(c);
                this.hs.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.hs.bO();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.hi.a(this.hs.bR(), this.hs.getName(), false, this.hs.bW());
            if (a2 != null && !this.hr.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.hs.d(a2);
                    this.hs.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.hs.bO();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean bJ() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.hi.a(this.hs.bR(), this.hs.getName(), false, this.hs.bW());
            if (a2 == null || !a2.exists() || this.hr.get()) {
                com.baidu.adp.lib.h.a.c(null);
                com.baidu.adp.lib.h.a.a((OutputStream) null);
                this.hs.bO();
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
                        if (read == -1 || this.hr.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.hr.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.hs.bU() || this.hs.h(byteArray)) {
                            this.hs.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.h.a.c(fileInputStream);
                    com.baidu.adp.lib.h.a.a((OutputStream) byteArrayOutputStream);
                    if (z) {
                        this.hs.setSuccess(true);
                    }
                    this.hs.bO();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.c(fileInputStream2);
                        com.baidu.adp.lib.h.a.a((OutputStream) byteArrayOutputStream);
                        this.hs.bO();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.h.a.c(fileInputStream);
                        com.baidu.adp.lib.h.a.a((OutputStream) byteArrayOutputStream);
                        this.hs.bO();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.h.a.c(fileInputStream);
                    com.baidu.adp.lib.h.a.a((OutputStream) byteArrayOutputStream);
                    this.hs.bO();
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
                File a2 = this.hi.a(this.hs.bR(), this.hs.getName(), true, this.hs.bW());
                if (a2 == null || this.hr.get()) {
                    com.baidu.adp.lib.h.a.a((OutputStream) null);
                    this.hs.bO();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.h.a.a((OutputStream) null);
                        this.hs.bO();
                        return true;
                    }
                    a2.delete();
                }
                byte[] bQ = this.hs.bQ();
                byte[] data = this.hs.getData();
                if ((bQ == null && data == null) || this.hr.get()) {
                    com.baidu.adp.lib.h.a.a((OutputStream) null);
                    this.hs.bO();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (bQ != null) {
                    try {
                        fileOutputStream2.write(bQ);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.a((OutputStream) fileOutputStream);
                        this.hs.bO();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.h.a.a((OutputStream) fileOutputStream);
                        this.hs.bO();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.h.a.a((OutputStream) fileOutputStream2);
                this.hs.d(a2);
                this.hs.setSuccess(true);
                this.hs.bO();
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
        OutputStream outputStream = this.hs.getOutputStream();
        File bV = this.hs.bV();
        if (outputStream == null) {
            try {
                try {
                    bV = this.hi.a(this.hs.bR(), this.hs.getName(), true, this.hs.bW());
                    if (bV == null || this.hr.get()) {
                        if (!z) {
                            com.baidu.adp.lib.h.a.a(outputStream);
                        }
                        this.hs.bO();
                        return false;
                    }
                    outputStream = new FileOutputStream(bV, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.h.a.a(outputStream);
                    }
                    this.hs.bO();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.h.a.a(outputStream);
                }
                this.hs.bO();
                throw th;
            }
        }
        byte[] bQ = this.hs.bQ();
        byte[] data = this.hs.getData();
        if ((bQ == null && data == null) || this.hr.get()) {
            if (!z) {
                com.baidu.adp.lib.h.a.a(outputStream);
            }
            this.hs.bO();
            return false;
        }
        if (bQ != null) {
            outputStream.write(bQ);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.hs.d(bV);
        this.hs.setSuccess(true);
        if (z) {
            this.hs.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.h.a.a(outputStream);
        }
        this.hs.bO();
        return true;
    }

    public boolean bK() {
        File c;
        if (this.hs.getName() != null) {
            c = this.hi.a(this.hs.bR(), this.hs.getName(), false, this.hs.bW());
        } else {
            c = this.hi.c(this.hs.bR(), false, this.hs.bW());
        }
        if (c != null && c.exists()) {
            this.hs.d(c);
            this.hs.setSuccess(true);
            this.hs.bO();
            return true;
        }
        this.hs.bO();
        return false;
    }

    public boolean bL() {
        boolean z = false;
        try {
            File a2 = this.hi.a(this.hs.bR(), this.hs.getName(), false, this.hs.bW());
            File a3 = this.hi.a(this.hs.bS(), this.hs.bZ(), true, this.hs.bW());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.hs.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.hs.bO();
        }
        return z;
    }

    public boolean bM() {
        boolean z = false;
        try {
            if (this.hs.ca() != null) {
                z = this.hs.ca().a(this, this.hs, this.hi);
            }
            if (z) {
                this.hs.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.hs.bO();
        }
        return z;
    }
}
