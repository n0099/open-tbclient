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
    private static /* synthetic */ int[] rG;
    protected final int BUFFER_SIZE = 1024;
    protected AtomicBoolean rE;
    private DiskFileOperate rF;
    protected b rv;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    static /* synthetic */ int[] fz() {
        int[] iArr = rG;
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
            rG = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.rE.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.rv = null;
        this.rE = null;
        this.rF = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.fB() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.rE = new AtomicBoolean(false);
        this.rv = bVar;
        this.rF = diskFileOperate;
    }

    public boolean ft() {
        switch (fz()[this.rF.fB().ordinal()]) {
            case 1:
                return fv();
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
                return fu();
            case 8:
                return fw();
            case 9:
                return fx();
            case 10:
                return fy();
            default:
                return false;
        }
    }

    private boolean c(File file) {
        if (file == null || !(this.rF instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.rF;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.rE.get(); i++) {
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

    private boolean fu() {
        boolean z = false;
        try {
            File c = this.rv.c(this.rF.getPath(), false, this.rF.fI());
            z = c(c);
            if (z) {
                this.rF.d(c);
                this.rF.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rF.fA();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a2 = this.rv.a(this.rF.fD(), this.rF.getName(), false, this.rF.fI());
            if (a2 != null && !this.rE.get()) {
                r0 = a2.exists() ? a2.delete() : false;
                if (r0) {
                    this.rF.d(a2);
                    this.rF.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.rF.fA();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean fv() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a2 = this.rv.a(this.rF.fD(), this.rF.getName(), false, this.rF.fI());
            if (a2 == null || !a2.exists() || this.rE.get()) {
                com.baidu.adp.lib.h.a.c(null);
                com.baidu.adp.lib.h.a.b(null);
                this.rF.fA();
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
                        if (read == -1 || this.rE.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.rE.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.rF.fG() || this.rF.h(byteArray)) {
                            this.rF.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.h.a.c(fileInputStream);
                    com.baidu.adp.lib.h.a.b(byteArrayOutputStream);
                    if (z) {
                        this.rF.setSuccess(true);
                    }
                    this.rF.fA();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.c(fileInputStream2);
                        com.baidu.adp.lib.h.a.b(byteArrayOutputStream);
                        this.rF.fA();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.h.a.c(fileInputStream);
                        com.baidu.adp.lib.h.a.b(byteArrayOutputStream);
                        this.rF.fA();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.h.a.c(fileInputStream);
                    com.baidu.adp.lib.h.a.b(byteArrayOutputStream);
                    this.rF.fA();
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
                File a2 = this.rv.a(this.rF.fD(), this.rF.getName(), true, this.rF.fI());
                if (a2 == null || this.rE.get()) {
                    com.baidu.adp.lib.h.a.b(null);
                    this.rF.fA();
                    return false;
                }
                if (a2.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.h.a.b(null);
                        this.rF.fA();
                        return true;
                    }
                    a2.delete();
                }
                byte[] fC = this.rF.fC();
                byte[] data = this.rF.getData();
                if ((fC == null && data == null) || this.rE.get()) {
                    com.baidu.adp.lib.h.a.b(null);
                    this.rF.fA();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a2);
                if (fC != null) {
                    try {
                        fileOutputStream2.write(fC);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.h.a.b(fileOutputStream);
                        this.rF.fA();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.h.a.b(fileOutputStream);
                        this.rF.fA();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.h.a.b(fileOutputStream2);
                this.rF.d(a2);
                this.rF.setSuccess(true);
                this.rF.fA();
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
        OutputStream outputStream = this.rF.getOutputStream();
        File fH = this.rF.fH();
        if (outputStream == null) {
            try {
                try {
                    fH = this.rv.a(this.rF.fD(), this.rF.getName(), true, this.rF.fI());
                    if (fH == null || this.rE.get()) {
                        if (!z) {
                            com.baidu.adp.lib.h.a.b(outputStream);
                        }
                        this.rF.fA();
                        return false;
                    }
                    outputStream = new FileOutputStream(fH, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.h.a.b(outputStream);
                    }
                    this.rF.fA();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.h.a.b(outputStream);
                }
                this.rF.fA();
                throw th;
            }
        }
        byte[] fC = this.rF.fC();
        byte[] data = this.rF.getData();
        if ((fC == null && data == null) || this.rE.get()) {
            if (!z) {
                com.baidu.adp.lib.h.a.b(outputStream);
            }
            this.rF.fA();
            return false;
        }
        if (fC != null) {
            outputStream.write(fC);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.rF.d(fH);
        this.rF.setSuccess(true);
        if (z) {
            this.rF.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.h.a.b(outputStream);
        }
        this.rF.fA();
        return true;
    }

    public boolean fw() {
        File c;
        if (this.rF.getName() != null) {
            c = this.rv.a(this.rF.fD(), this.rF.getName(), false, this.rF.fI());
        } else {
            c = this.rv.c(this.rF.fD(), false, this.rF.fI());
        }
        if (c != null && c.exists()) {
            this.rF.d(c);
            this.rF.setSuccess(true);
            this.rF.fA();
            return true;
        }
        this.rF.fA();
        return false;
    }

    public boolean fx() {
        boolean z = false;
        try {
            File a2 = this.rv.a(this.rF.fD(), this.rF.getName(), false, this.rF.fI());
            File a3 = this.rv.a(this.rF.fE(), this.rF.fL(), true, this.rF.fI());
            if (a2 != null) {
                if (a3 != null) {
                    a3.delete();
                }
                z = a2.renameTo(a3);
            }
            if (z) {
                this.rF.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rF.fA();
        }
        return z;
    }

    public boolean fy() {
        boolean z = false;
        try {
            if (this.rF.fM() != null) {
                z = this.rF.fM().a(this, this.rF, this.rv);
            }
            if (z) {
                this.rF.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.rF.fA();
        }
        return z;
    }
}
