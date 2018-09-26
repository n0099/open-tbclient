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
    protected final int BUFFER_SIZE = 1024;
    protected b yk;
    protected AtomicBoolean yt;
    private DiskFileOperate yu;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.yt.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.yk = null;
        this.yt = null;
        this.yu = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.ht() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.yt = new AtomicBoolean(false);
        this.yk = bVar;
        this.yu = diskFileOperate;
    }

    public boolean hm() {
        switch (this.yu.ht()) {
            case WRITE:
                return B(false);
            case WRITE_FORCE:
                return B(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return hn();
            case APPEND:
                return C(false);
            case APPEND_MORE:
                return C(true);
            case INFO:
                return hp();
            case RENAME:
                return hq();
            case READ:
                return ho();
            case CUSTOM:
                return hr();
            default:
                return false;
        }
    }

    private boolean k(File file) {
        if (file == null || !(this.yu instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.yu;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.yt.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        k(listFiles[i]);
                    } else if (aVar.j(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (aVar.j(file)) {
            file.delete();
        }
        return true;
    }

    private boolean hn() {
        boolean z = false;
        try {
            File b = this.yk.b(this.yu.getPath(), false, this.yu.hA(), this.yu.hB());
            z = k(b);
            if (z) {
                this.yu.l(b);
                this.yu.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.yu.hs();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File b;
        try {
            try {
                b = this.yk.b(this.yu.hv(), this.yu.getName(), false, this.yu.hA(), this.yu.hB());
            } catch (Exception e) {
                e.getMessage();
                this.yu.hs();
                z = false;
            }
            if (b == null || this.yt.get()) {
                return false;
            }
            z = b.exists() ? b.delete() : false;
            if (z) {
                this.yu.l(b);
                this.yu.setSuccess(true);
            }
            return z;
        } finally {
            this.yu.hs();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean ho() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File b;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            b = this.yk.b(this.yu.hv(), this.yu.getName(), false, this.yu.hA(), this.yu.hB());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (b == null || !b.exists() || this.yt.get()) {
            com.baidu.adp.lib.g.a.h(null);
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.yu.hs();
            return false;
        }
        fileInputStream = new FileInputStream(b);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read == -1 || this.yt.get()) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream2 = fileInputStream;
                try {
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.h(fileInputStream2);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                    this.yu.hs();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.h(fileInputStream);
                    com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                    this.yu.hs();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.h(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream2);
                this.yu.hs();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.yt.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.yu.hy() || this.yu.q(byteArray)) {
                this.yu.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.h(fileInputStream);
                com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.yu.setSuccess(true);
                }
                this.yu.hs();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.h(fileInputStream);
        com.baidu.adp.lib.g.a.b((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.yu.hs();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean B(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File b;
        FileOutputStream fileOutputStream2 = null;
        try {
            b = this.yk.b(this.yu.hv(), this.yu.getName(), true, this.yu.hA(), this.yu.hB());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
            this.yu.hs();
            throw th;
        }
        if (b == null || this.yt.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.yu.hs();
            return false;
        }
        if (b.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.b((OutputStream) null);
                this.yu.hs();
                return true;
            }
            b.delete();
        }
        byte[] hu = this.yu.hu();
        byte[] data = this.yu.getData();
        if ((hu == null && data == null) || this.yt.get()) {
            com.baidu.adp.lib.g.a.b((OutputStream) null);
            this.yu.hs();
            return false;
        }
        fileOutputStream = new FileOutputStream(b);
        if (hu != null) {
            try {
                try {
                    fileOutputStream.write(hu);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
                    this.yu.hs();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream2);
                this.yu.hs();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.b((OutputStream) fileOutputStream);
        this.yu.l(b);
        this.yu.setSuccess(true);
        this.yu.hs();
        z2 = true;
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=5, 300=5, 304=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean C(boolean z) {
        OutputStream outputStream;
        boolean z2;
        byte[] hu;
        byte[] data;
        OutputStream outputStream2 = this.yu.getOutputStream();
        File hz = this.yu.hz();
        if (outputStream2 == null) {
            try {
                hz = this.yk.b(this.yu.hv(), this.yu.getName(), true, this.yu.hA(), this.yu.hB());
                if (hz == null || this.yt.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.b(outputStream2);
                    }
                    this.yu.hs();
                    return false;
                }
                outputStream = new FileOutputStream(hz, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.yu.hs();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.yu.hs();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                hu = this.yu.hu();
                data = this.yu.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.yu.hs();
                z2 = false;
                return z2;
            }
            if ((hu == null && data == null) || this.yt.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.b(outputStream);
                }
                this.yu.hs();
                return false;
            }
            if (hu != null) {
                outputStream.write(hu);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.yu.l(hz);
            this.yu.setSuccess(true);
            if (z) {
                this.yu.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.b(outputStream);
            }
            this.yu.hs();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.b(outputStream2);
            }
            this.yu.hs();
            throw th;
        }
    }

    public boolean hp() {
        File b;
        if (this.yu.getName() != null) {
            b = this.yk.b(this.yu.hv(), this.yu.getName(), false, this.yu.hA(), this.yu.hB());
        } else {
            b = this.yk.b(this.yu.hv(), false, this.yu.hA(), this.yu.hB());
        }
        if (b != null && b.exists()) {
            this.yu.l(b);
            this.yu.setSuccess(true);
            this.yu.hs();
            return true;
        }
        this.yu.hs();
        return false;
    }

    public boolean hq() {
        boolean z;
        try {
            File b = this.yk.b(this.yu.hv(), this.yu.getName(), false, this.yu.hA(), this.yu.hB());
            File b2 = this.yk.b(this.yu.hw(), this.yu.hE(), true, this.yu.hA(), this.yu.hB());
            if (b != null) {
                if (b2 != null) {
                    b2.delete();
                }
                z = b.renameTo(b2);
            } else {
                z = false;
            }
            if (z) {
                this.yu.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.yu.hs();
        }
    }

    public boolean hr() {
        boolean z = false;
        try {
            if (this.yu.hF() != null) {
                z = this.yu.hF().a(this, this.yu, this.yk);
            }
            if (z) {
                this.yu.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.yu.hs();
        }
        return z;
    }
}
