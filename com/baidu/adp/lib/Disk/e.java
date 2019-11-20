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
    protected AtomicBoolean mIsCanceled;
    protected b mj;
    private DiskFileOperate mq;

    /* loaded from: classes.dex */
    public interface a {
        boolean a(e eVar, DiskFileOperate diskFileOperate, b bVar);
    }

    public void cancel() {
        this.mIsCanceled.set(true);
    }

    public e(b bVar, DiskFileOperate diskFileOperate) {
        this.mj = null;
        this.mIsCanceled = null;
        this.mq = null;
        if (bVar == null || diskFileOperate == null || diskFileOperate.eQ() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.mIsCanceled = new AtomicBoolean(false);
        this.mj = bVar;
        this.mq = diskFileOperate;
    }

    public boolean call() {
        switch (this.mq.eQ()) {
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

    private boolean e(File file) {
        if (file == null || !(this.mq instanceof com.baidu.adp.lib.Disk.a)) {
            return false;
        }
        com.baidu.adp.lib.Disk.a aVar = (com.baidu.adp.lib.Disk.a) this.mq;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.mIsCanceled.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        e(listFiles[i]);
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
            File folder = this.mj.getFolder(this.mq.getPath(), false, this.mq.isSdCard(), this.mq.isSavedCache());
            z = e(folder);
            if (z) {
                this.mq.setFileInfo(folder);
                this.mq.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.mq.unLock();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File file;
        try {
            try {
                file = this.mj.getFile(this.mq.buildPath(), this.mq.getName(), false, this.mq.isSdCard(), this.mq.isSavedCache());
            } catch (Exception e) {
                e.getMessage();
                this.mq.unLock();
                z = false;
            }
            if (file == null || this.mIsCanceled.get()) {
                return false;
            }
            z = file.exists() ? file.delete() : false;
            if (z) {
                this.mq.setFileInfo(file);
                this.mq.setSuccess(true);
            }
            return z;
        } finally {
            this.mq.unLock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5, 203=4, 207=4] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean read() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        File file;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byteArrayOutputStream2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            file = this.mj.getFile(this.mq.buildPath(), this.mq.getName(), false, this.mq.isSdCard(), this.mq.isSavedCache());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (file == null || !file.exists() || this.mIsCanceled.get()) {
            com.baidu.adp.lib.g.a.close((InputStream) null);
            com.baidu.adp.lib.g.a.close((OutputStream) null);
            this.mq.unLock();
            return false;
        }
        fileInputStream = new FileInputStream(file);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
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
                fileInputStream2 = fileInputStream;
                try {
                    BdLog.e(e.getMessage());
                    com.baidu.adp.lib.g.a.close((InputStream) fileInputStream2);
                    com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
                    this.mq.unLock();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                    com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream2);
                    this.mq.unLock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream2);
                this.mq.unLock();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
            fileInputStream2 = fileInputStream;
        } catch (Throwable th4) {
            th = th4;
        }
        if (!this.mIsCanceled.get()) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!this.mq.isFormatData() || this.mq.formatData(byteArray)) {
                this.mq.setData(byteArray);
                z = true;
                com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
                com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.mq.setSuccess(true);
                }
                this.mq.unLock();
                return z;
            }
        }
        z = false;
        com.baidu.adp.lib.g.a.close((InputStream) fileInputStream);
        com.baidu.adp.lib.g.a.close((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.mq.unLock();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean write(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File file;
        FileOutputStream fileOutputStream2 = null;
        try {
            file = this.mj.getFile(this.mq.buildPath(), this.mq.getName(), true, this.mq.isSdCard(), this.mq.isSavedCache());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
            this.mq.unLock();
            throw th;
        }
        if (file == null || this.mIsCanceled.get()) {
            com.baidu.adp.lib.g.a.close((OutputStream) null);
            this.mq.unLock();
            return false;
        }
        if (file.exists()) {
            if (!z) {
                com.baidu.adp.lib.g.a.close((OutputStream) null);
                this.mq.unLock();
                return true;
            }
            file.delete();
        }
        byte[] buildFormatData = this.mq.buildFormatData();
        byte[] data = this.mq.getData();
        if ((buildFormatData == null && data == null) || this.mIsCanceled.get()) {
            com.baidu.adp.lib.g.a.close((OutputStream) null);
            this.mq.unLock();
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
                    com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream);
                    this.mq.unLock();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream2);
                this.mq.unLock();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        com.baidu.adp.lib.g.a.close((OutputStream) fileOutputStream);
        this.mq.setFileInfo(file);
        this.mq.setSuccess(true);
        this.mq.unLock();
        z2 = true;
        return z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [299=5, 300=5, 304=5] */
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
        OutputStream outputStream2 = this.mq.getOutputStream();
        File fileInfo = this.mq.getFileInfo();
        if (outputStream2 == null) {
            try {
                fileInfo = this.mj.getFile(this.mq.buildPath(), this.mq.getName(), true, this.mq.isSdCard(), this.mq.isSavedCache());
                if (fileInfo == null || this.mIsCanceled.get()) {
                    if (!z) {
                        com.baidu.adp.lib.g.a.close(outputStream2);
                    }
                    this.mq.unLock();
                    return false;
                }
                outputStream = new FileOutputStream(fileInfo, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.mq.unLock();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.mq.unLock();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                buildFormatData = this.mq.buildFormatData();
                data = this.mq.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    com.baidu.adp.lib.g.a.close(outputStream);
                }
                this.mq.unLock();
                z2 = false;
                return z2;
            }
            if ((buildFormatData == null && data == null) || this.mIsCanceled.get()) {
                if (!z) {
                    com.baidu.adp.lib.g.a.close(outputStream);
                }
                this.mq.unLock();
                return false;
            }
            if (buildFormatData != null) {
                outputStream.write(buildFormatData);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.mq.setFileInfo(fileInfo);
            this.mq.setSuccess(true);
            if (z) {
                this.mq.setOutputStream(outputStream);
            } else {
                com.baidu.adp.lib.g.a.close(outputStream);
            }
            this.mq.unLock();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                com.baidu.adp.lib.g.a.close(outputStream2);
            }
            this.mq.unLock();
            throw th;
        }
    }

    public boolean info() {
        File folder;
        if (this.mq.getName() != null) {
            folder = this.mj.getFile(this.mq.buildPath(), this.mq.getName(), false, this.mq.isSdCard(), this.mq.isSavedCache());
        } else {
            folder = this.mj.getFolder(this.mq.buildPath(), false, this.mq.isSdCard(), this.mq.isSavedCache());
        }
        if (folder != null && folder.exists()) {
            this.mq.setFileInfo(folder);
            this.mq.setSuccess(true);
            this.mq.unLock();
            return true;
        }
        this.mq.unLock();
        return false;
    }

    public boolean rename() {
        boolean z;
        try {
            File file = this.mj.getFile(this.mq.buildPath(), this.mq.getName(), false, this.mq.isSdCard(), this.mq.isSavedCache());
            File file2 = this.mj.getFile(this.mq.buildDesPath(), this.mq.getDesName(), true, this.mq.isSdCard(), this.mq.isSavedCache());
            if (file != null) {
                if (file2 != null) {
                    file2.delete();
                }
                z = file.renameTo(file2);
            } else {
                z = false;
            }
            if (z) {
                this.mq.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.mq.unLock();
        }
    }

    public boolean custom() {
        boolean z = false;
        try {
            if (this.mq.eS() != null) {
                z = this.mq.eS().a(this, this.mq, this.mj);
            }
            if (z) {
                this.mq.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.mq.unLock();
        }
        return z;
    }
}
