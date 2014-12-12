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
    private static /* synthetic */ int[] fM;
    protected final int BUFFER_SIZE = 1024;
    protected b fG;
    protected AtomicBoolean fK;
    private DiskFileOperate fL;

    static /* synthetic */ int[] bW() {
        int[] iArr = fM;
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
            fM = iArr;
        }
        return iArr;
    }

    public void cancel() {
        this.fK.set(true);
    }

    public boolean bP() {
        return this.fK.get();
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.fG = null;
        this.fK = null;
        this.fL = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.bY() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.fK = new AtomicBoolean(false);
        this.fG = bVar;
        this.fL = diskFileOperate;
    }

    public boolean bQ() {
        switch (bW()[this.fL.bY().ordinal()]) {
            case 1:
                return bS();
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
                return bR();
            case 8:
                return bT();
            case 9:
                return bU();
            case 10:
                return bV();
            default:
                return false;
        }
    }

    private boolean d(File file) {
        if (file == null || !(this.fL instanceof a)) {
            return false;
        }
        a aVar = (a) this.fL;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.fK.get(); i++) {
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

    private boolean bR() {
        boolean z = false;
        try {
            File b = this.fG.b(this.fL.getPath(), false, this.fL.cf());
            z = d(b);
            if (z) {
                this.fL.e(b);
                this.fL.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.fL.bX();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    private boolean delete() {
        try {
            File a = this.fG.a(this.fL.ca(), this.fL.getName(), false, this.fL.cf());
            if (a != null && !this.fK.get()) {
                r0 = a.exists() ? a.delete() : false;
                if (r0) {
                    this.fL.e(a);
                    this.fL.setSuccess(true);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.fL.bX();
        }
        return r0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=4, 204=4, 208=4] */
    private boolean bS() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        boolean z = false;
        try {
            File a = this.fG.a(this.fL.ca(), this.fL.getName(), false, this.fL.cf());
            if (a == null || !a.exists() || this.fK.get()) {
                com.baidu.adp.lib.g.a.d(null);
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.fL.bX();
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
                        if (read == -1 || this.fK.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    if (!this.fK.get()) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.fL.cd() || this.fL.j(byteArray)) {
                            this.fL.setData(byteArray);
                            z = true;
                        }
                    }
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                    if (z) {
                        this.fL.setSuccess(true);
                    }
                    this.fL.bX();
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream2 = fileInputStream;
                    try {
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.d(fileInputStream2);
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        this.fL.bX();
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        com.baidu.adp.lib.g.a.d(fileInputStream);
                        com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                        this.fL.bX();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    com.baidu.adp.lib.g.a.d(fileInputStream);
                    com.baidu.adp.lib.g.a.b(byteArrayOutputStream);
                    this.fL.bX();
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
                File a = this.fG.a(this.fL.ca(), this.fL.getName(), true, this.fL.cf());
                if (a == null || this.fK.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.fL.bX();
                    return false;
                }
                if (a.exists()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b((OutputStream) null);
                        this.fL.bX();
                        return true;
                    }
                    a.delete();
                }
                byte[] bZ = this.fL.bZ();
                byte[] data = this.fL.getData();
                if ((bZ == null && data == null) || this.fK.get()) {
                    com.baidu.adp.lib.g.a.b((OutputStream) null);
                    this.fL.bX();
                    return false;
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(a);
                if (bZ != null) {
                    try {
                        fileOutputStream2.write(bZ);
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        BdLog.e(e.getMessage());
                        com.baidu.adp.lib.g.a.b(fileOutputStream);
                        this.fL.bX();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        com.baidu.adp.lib.g.a.b(fileOutputStream);
                        this.fL.bX();
                        throw th;
                    }
                }
                if (data != null) {
                    fileOutputStream2.write(data);
                }
                fileOutputStream2.flush();
                com.baidu.adp.lib.g.a.b(fileOutputStream2);
                this.fL.e(a);
                this.fL.setSuccess(true);
                this.fL.bX();
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
        OutputStream outputStream = this.fL.getOutputStream();
        File ce = this.fL.ce();
        if (outputStream == null) {
            try {
                try {
                    ce = this.fG.a(this.fL.ca(), this.fL.getName(), true, this.fL.cf());
                    if (ce == null || this.fK.get()) {
                        if (!z) {
                            com.baidu.adp.lib.g.a.b(outputStream);
                        }
                        this.fL.bX();
                        return false;
                    }
                    outputStream = new FileOutputStream(ce, true);
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream);
                    }
                    this.fL.bX();
                    return false;
                }
            } catch (Throwable th) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.fL.bX();
                throw th;
            }
        }
        byte[] bZ = this.fL.bZ();
        byte[] data = this.fL.getData();
        if ((bZ == null && data == null) || this.fK.get()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.fL.bX();
            return false;
        }
        if (bZ != null) {
            outputStream.write(bZ);
        }
        if (data != null) {
            outputStream.write(data);
        }
        outputStream.flush();
        this.fL.e(ce);
        this.fL.setSuccess(true);
        if (z) {
            this.fL.setOutputStream(outputStream);
        } else {
            com.baidu.adp.lib.g.a.b(outputStream);
        }
        this.fL.bX();
        return true;
    }

    public boolean bT() {
        File b;
        if (this.fL.getName() != null) {
            b = this.fG.a(this.fL.ca(), this.fL.getName(), false, this.fL.cf());
        } else {
            b = this.fG.b(this.fL.ca(), false, this.fL.cf());
        }
        if (b != null && b.exists()) {
            this.fL.e(b);
            this.fL.setSuccess(true);
            this.fL.bX();
            return true;
        }
        this.fL.bX();
        return false;
    }

    public boolean bU() {
        boolean z = false;
        try {
            File a = this.fG.a(this.fL.ca(), this.fL.getName(), false, this.fL.cf());
            File a2 = this.fG.a(this.fL.cb(), this.fL.cj(), true, this.fL.cf());
            if (a != null) {
                if (a2 != null) {
                    a2.delete();
                }
                z = a.renameTo(a2);
            }
            if (z) {
                this.fL.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.fL.bX();
        }
        return z;
    }

    public boolean bV() {
        boolean z = false;
        try {
            if (this.fL.ck() != null) {
                z = this.fL.ck().a(this, this.fL, this.fG);
            }
            if (z) {
                this.fL.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.fL.bX();
        }
        return z;
    }
}
