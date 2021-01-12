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
    protected final int BUFFER_SIZE = 1024;
    protected b JY;
    private DiskFileOperate Kf;
    protected AtomicBoolean mIsCanceled;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.mIsCanceled.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.JY = null;
        this.mIsCanceled = null;
        this.Kf = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.li() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.mIsCanceled = new AtomicBoolean(false);
        this.JY = bVar;
        this.Kf = diskFileOperate;
    }

    public boolean call() {
        switch (this.Kf.li()) {
            case WRITE:
                return write(false);
            case WRITE_FORCE:
                return write(true);
            case DELETE:
                return delete();
            case DELETE_FILES:
                return deleteFiles();
            case APPEND:
                return append(false);
            case APPEND_MORE:
                return append(true);
            case INFO:
                return info();
            case RENAME:
                return rename();
            case READ:
                return read();
            case CUSTOM:
                return custom();
            default:
                return false;
        }
    }

    private boolean h(File file) {
        if (file == null || !(this.Kf instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.Kf;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.mIsCanceled.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        h(listFiles[i]);
                    } else if (aVar.compare(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (aVar.compare(file)) {
            file.delete();
        }
        return true;
    }

    private boolean deleteFiles() {
        boolean z = false;
        try {
            File folder = this.JY.getFolder(this.Kf.getPath(), false, this.Kf.isSdCard(), this.Kf.isSavedCache());
            z = h(folder);
            if (z) {
                this.Kf.setFileInfo(folder);
                this.Kf.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.Kf.unLock();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File file;
        try {
            try {
                file = this.JY.getFile(this.Kf.buildPath(), this.Kf.getName(), false, this.Kf.isSdCard(), this.Kf.isSavedCache());
            } catch (Exception e) {
                e.getMessage();
                this.Kf.unLock();
                z = false;
            }
            if (file == null || this.mIsCanceled.get()) {
                return false;
            }
            z = file.exists() ? file.delete() : false;
            if (z) {
                this.Kf.setFileInfo(file);
                this.Kf.setSuccess(true);
            }
            return z;
        } finally {
            this.Kf.unLock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [203=5, 204=4, 208=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean read() {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        boolean z;
        File file;
        this.Kf.ll();
        try {
            file = this.JY.getFile(this.Kf.buildPath(), this.Kf.getName(), false, this.Kf.isSdCard(), this.Kf.isSavedCache());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        if (file == null || !file.exists() || this.mIsCanceled.get()) {
            com.baidu.adp.lib.f.a.close((InputStream) null);
            com.baidu.adp.lib.f.a.close((OutputStream) null);
            this.Kf.unLock();
            return false;
        }
        fileInputStream = new FileInputStream(file);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1 || this.mIsCanceled.get()) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                    com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                    this.Kf.unLock();
                    z = false;
                    this.Kf.lm();
                    return z;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                this.Kf.unLock();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
            com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
            this.Kf.unLock();
            throw th;
        }
        if (!this.mIsCanceled.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.Kf.isFormatData() || this.Kf.formatData(byteArray)) {
                this.Kf.setData(byteArray);
                z = true;
                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.Kf.setSuccess(true);
                }
                this.Kf.unLock();
                this.Kf.lm();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
        com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.Kf.unLock();
        this.Kf.lm();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [258=6, 253=7] */
    public boolean write(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File file;
        FileOutputStream fileOutputStream2 = null;
        try {
            file = this.JY.getFile(this.Kf.buildPath(), this.Kf.getName(), true, this.Kf.isSdCard(), this.Kf.isSavedCache());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
            this.Kf.unLock();
            throw th;
        }
        if (file == null || this.mIsCanceled.get()) {
            com.baidu.adp.lib.f.a.close((OutputStream) null);
            this.Kf.unLock();
            return false;
        }
        if (file.exists()) {
            if (!z) {
                com.baidu.adp.lib.f.a.close((OutputStream) null);
                this.Kf.unLock();
                return true;
            }
            file.delete();
        }
        byte[] buildFormatData = this.Kf.buildFormatData();
        byte[] data = this.Kf.getData();
        if ((buildFormatData == null && data == null) || this.mIsCanceled.get()) {
            com.baidu.adp.lib.f.a.close((OutputStream) null);
            this.Kf.unLock();
            return false;
        }
        fileOutputStream = new FileOutputStream(file);
        if (buildFormatData != null) {
            try {
                try {
                    fileOutputStream.write(buildFormatData);
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
                    this.Kf.unLock();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream2);
                this.Kf.unLock();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.f.a.close((OutputStream) fileOutputStream);
        this.Kf.setFileInfo(file);
        this.Kf.setSuccess(true);
        this.Kf.unLock();
        z2 = true;
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [301=5, 302=5, 306=5] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean append(boolean z) {
        OutputStream outputStream;
        boolean z2;
        byte[] buildFormatData;
        byte[] data;
        OutputStream outputStream2 = this.Kf.getOutputStream();
        File fileInfo = this.Kf.getFileInfo();
        if (outputStream2 == null) {
            try {
                fileInfo = this.JY.getFile(this.Kf.buildPath(), this.Kf.getName(), true, this.Kf.isSdCard(), this.Kf.isSavedCache());
                if (fileInfo == null || this.mIsCanceled.get()) {
                    if (!z) {
                        com.baidu.adp.lib.f.a.close(outputStream2);
                    }
                    this.Kf.unLock();
                    return false;
                }
                outputStream = new FileOutputStream(fileInfo, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.Kf.unLock();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.Kf.unLock();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                buildFormatData = this.Kf.buildFormatData();
                data = this.Kf.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.f.a.close(outputStream);
                }
                this.Kf.unLock();
                z2 = false;
                return z2;
            }
            if ((buildFormatData == null && data == null) || this.mIsCanceled.get()) {
                if (!z) {
                    com.baidu.adp.lib.f.a.close(outputStream);
                }
                this.Kf.unLock();
                return false;
            }
            if (buildFormatData != null) {
                outputStream.write(buildFormatData);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.Kf.setFileInfo(fileInfo);
            this.Kf.setSuccess(true);
            if (z) {
                this.Kf.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.f.a.close(outputStream);
            }
            this.Kf.unLock();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.f.a.close(outputStream2);
            }
            this.Kf.unLock();
            throw th;
        }
    }

    public boolean info() {
        File folder;
        if (this.Kf.getName() != null) {
            folder = this.JY.getFile(this.Kf.buildPath(), this.Kf.getName(), false, this.Kf.isSdCard(), this.Kf.isSavedCache());
        } else {
            folder = this.JY.getFolder(this.Kf.buildPath(), false, this.Kf.isSdCard(), this.Kf.isSavedCache());
        }
        if (folder != null && folder.exists()) {
            this.Kf.setFileInfo(folder);
            this.Kf.setSuccess(true);
            this.Kf.unLock();
            return true;
        }
        this.Kf.unLock();
        return false;
    }

    public boolean rename() {
        boolean z;
        try {
            File file = this.JY.getFile(this.Kf.buildPath(), this.Kf.getName(), false, this.Kf.isSdCard(), this.Kf.isSavedCache());
            File file2 = this.JY.getFile(this.Kf.buildDesPath(), this.Kf.getDesName(), true, this.Kf.isSdCard(), this.Kf.isSavedCache());
            if (file != null) {
                if (file2 != null) {
                    file2.delete();
                }
                z = file.renameTo(file2);
            } else {
                z = false;
            }
            if (z) {
                this.Kf.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.Kf.unLock();
        }
    }

    public boolean custom() {
        boolean z = false;
        try {
            if (this.Kf.lk() != null) {
                z = this.Kf.lk().a(this, this.Kf, this.JY);
            }
            if (z) {
                this.Kf.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.Kf.unLock();
        }
        return z;
    }
}
