package com.baidu.live.adp.lib.disk;

import com.baidu.live.adp.lib.disk.ops.DiskFileOperate;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import com.baidu.live.adp.lib.util.BdLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class DiskWorker {
    protected final int BUFFER_SIZE = 1024;
    protected DiskFileFactory mDiskFileFactory;
    private DiskFileOperate mDiskFileOp;
    protected AtomicBoolean mIsCanceled;

    /* loaded from: classes6.dex */
    public interface DiskWorkerOperate {
        boolean operate(DiskWorker diskWorker, DiskFileOperate diskFileOperate, DiskFileFactory diskFileFactory);
    }

    public void cancel() {
        this.mIsCanceled.set(true);
    }

    public boolean IsCanceled() {
        return this.mIsCanceled.get();
    }

    public DiskWorker(DiskFileFactory diskFileFactory, DiskFileOperate diskFileOperate) {
        this.mDiskFileFactory = null;
        this.mIsCanceled = null;
        this.mDiskFileOp = null;
        if (diskFileFactory == null || diskFileOperate == null || diskFileOperate.getAction() == null) {
            throw new InvalidParameterException("DiskWorker Parameter is null");
        }
        this.mIsCanceled = new AtomicBoolean(false);
        this.mDiskFileFactory = diskFileFactory;
        this.mDiskFileOp = diskFileOperate;
    }

    public boolean call() {
        switch (this.mDiskFileOp.getAction()) {
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

    private boolean deleteFiles2(File file) {
        if (file == null || !(this.mDiskFileOp instanceof DiskFileComparator)) {
            return false;
        }
        DiskFileComparator diskFileComparator = (DiskFileComparator) this.mDiskFileOp;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (int i = 0; i < listFiles.length && !this.mIsCanceled.get(); i++) {
                    if (listFiles[i].isDirectory()) {
                        deleteFiles2(listFiles[i]);
                    } else if (diskFileComparator.compare(listFiles[i])) {
                        listFiles[i].delete();
                    }
                }
            }
            file.delete();
        } else if (diskFileComparator.compare(file)) {
            file.delete();
        }
        return true;
    }

    private boolean deleteFiles() {
        boolean z = false;
        try {
            File folder = this.mDiskFileFactory.getFolder(this.mDiskFileOp.getPath(), false, this.mDiskFileOp.isSdCard(), this.mDiskFileOp.isSavedCache());
            z = deleteFiles2(folder);
            if (z) {
                this.mDiskFileOp.setFileInfo(folder);
                this.mDiskFileOp.setSuccess(true);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.mDiskFileOp.unLock();
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [166=4] */
    private boolean delete() {
        boolean z;
        File file;
        try {
            try {
                file = this.mDiskFileFactory.getFile(this.mDiskFileOp.buildPath(), this.mDiskFileOp.getName(), false, this.mDiskFileOp.isSdCard(), this.mDiskFileOp.isSavedCache());
            } catch (Exception e) {
                e.getMessage();
                this.mDiskFileOp.unLock();
                z = false;
            }
            if (file == null || this.mIsCanceled.get()) {
                return false;
            }
            z = file.exists() ? file.delete() : false;
            if (z) {
                this.mDiskFileOp.setFileInfo(file);
                this.mDiskFileOp.setSuccess(true);
            }
            return z;
        } finally {
            this.mDiskFileOp.unLock();
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
            file = this.mDiskFileFactory.getFile(this.mDiskFileOp.buildPath(), this.mDiskFileOp.getName(), false, this.mDiskFileOp.isSdCard(), this.mDiskFileOp.isSavedCache());
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        if (file == null || !file.exists() || this.mIsCanceled.get()) {
            BdCloseHelper.close((InputStream) null);
            BdCloseHelper.close((OutputStream) null);
            this.mDiskFileOp.unLock();
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
                    BdCloseHelper.close((InputStream) fileInputStream2);
                    BdCloseHelper.close((OutputStream) byteArrayOutputStream);
                    this.mDiskFileOp.unLock();
                    z = false;
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    BdCloseHelper.close((InputStream) fileInputStream);
                    BdCloseHelper.close((OutputStream) byteArrayOutputStream2);
                    this.mDiskFileOp.unLock();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream2 = byteArrayOutputStream;
                BdCloseHelper.close((InputStream) fileInputStream);
                BdCloseHelper.close((OutputStream) byteArrayOutputStream2);
                this.mDiskFileOp.unLock();
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
            if (!this.mDiskFileOp.isFormatData() || this.mDiskFileOp.formatData(byteArray)) {
                this.mDiskFileOp.setData(byteArray);
                z = true;
                BdCloseHelper.close((InputStream) fileInputStream);
                BdCloseHelper.close((OutputStream) byteArrayOutputStream);
                if (z) {
                    this.mDiskFileOp.setSuccess(true);
                }
                this.mDiskFileOp.unLock();
                return z;
            }
        }
        z = false;
        BdCloseHelper.close((InputStream) fileInputStream);
        BdCloseHelper.close((OutputStream) byteArrayOutputStream);
        if (z) {
        }
        this.mDiskFileOp.unLock();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [256=6, 251=7] */
    public boolean write(boolean z) {
        FileOutputStream fileOutputStream;
        boolean z2;
        File file;
        FileOutputStream fileOutputStream2 = null;
        try {
            file = this.mDiskFileFactory.getFile(this.mDiskFileOp.buildPath(), this.mDiskFileOp.getName(), true, this.mDiskFileOp.isSdCard(), this.mDiskFileOp.isSavedCache());
        } catch (Exception e) {
            e = e;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            BdCloseHelper.close((OutputStream) fileOutputStream2);
            this.mDiskFileOp.unLock();
            throw th;
        }
        if (file == null || this.mIsCanceled.get()) {
            BdCloseHelper.close((OutputStream) null);
            this.mDiskFileOp.unLock();
            return false;
        }
        if (file.exists()) {
            if (!z) {
                BdCloseHelper.close((OutputStream) null);
                this.mDiskFileOp.unLock();
                return true;
            }
            file.delete();
        }
        byte[] buildFormatData = this.mDiskFileOp.buildFormatData();
        byte[] data = this.mDiskFileOp.getData();
        if ((buildFormatData == null && data == null) || this.mIsCanceled.get()) {
            BdCloseHelper.close((OutputStream) null);
            this.mDiskFileOp.unLock();
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
                    BdCloseHelper.close((OutputStream) fileOutputStream);
                    this.mDiskFileOp.unLock();
                    z2 = false;
                    return z2;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                BdCloseHelper.close((OutputStream) fileOutputStream2);
                this.mDiskFileOp.unLock();
                throw th;
            }
        }
        if (data != null) {
            fileOutputStream.write(data);
        }
        fileOutputStream.flush();
        BdCloseHelper.close((OutputStream) fileOutputStream);
        this.mDiskFileOp.setFileInfo(file);
        this.mDiskFileOp.setSuccess(true);
        this.mDiskFileOp.unLock();
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
        OutputStream outputStream2 = this.mDiskFileOp.getOutputStream();
        File fileInfo = this.mDiskFileOp.getFileInfo();
        if (outputStream2 == null) {
            try {
                fileInfo = this.mDiskFileFactory.getFile(this.mDiskFileOp.buildPath(), this.mDiskFileOp.getName(), true, this.mDiskFileOp.isSdCard(), this.mDiskFileOp.isSavedCache());
                if (fileInfo == null || this.mIsCanceled.get()) {
                    if (!z) {
                        BdCloseHelper.close(outputStream2);
                    }
                    this.mDiskFileOp.unLock();
                    return false;
                }
                outputStream = new FileOutputStream(fileInfo, true);
            } catch (Exception e) {
                e = e;
                outputStream = outputStream2;
                BdLog.e(e.getMessage());
                if (!z) {
                }
                this.mDiskFileOp.unLock();
                z2 = false;
                return z2;
            } catch (Throwable th) {
                th = th;
                if (!z) {
                }
                this.mDiskFileOp.unLock();
                throw th;
            }
        } else {
            outputStream = outputStream2;
        }
        try {
            try {
                buildFormatData = this.mDiskFileOp.buildFormatData();
                data = this.mDiskFileOp.getData();
            } catch (Exception e2) {
                e = e2;
                BdLog.e(e.getMessage());
                if (!z) {
                    BdCloseHelper.close(outputStream);
                }
                this.mDiskFileOp.unLock();
                z2 = false;
                return z2;
            }
            if ((buildFormatData == null && data == null) || this.mIsCanceled.get()) {
                if (!z) {
                    BdCloseHelper.close(outputStream);
                }
                this.mDiskFileOp.unLock();
                return false;
            }
            if (buildFormatData != null) {
                outputStream.write(buildFormatData);
            }
            if (data != null) {
                outputStream.write(data);
            }
            outputStream.flush();
            this.mDiskFileOp.setFileInfo(fileInfo);
            this.mDiskFileOp.setSuccess(true);
            if (z) {
                this.mDiskFileOp.setOutputStream(outputStream);
            } else {
                BdCloseHelper.close(outputStream);
            }
            this.mDiskFileOp.unLock();
            z2 = true;
            return z2;
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            if (!z) {
                BdCloseHelper.close(outputStream2);
            }
            this.mDiskFileOp.unLock();
            throw th;
        }
    }

    public boolean info() {
        File folder;
        if (this.mDiskFileOp.getName() != null) {
            folder = this.mDiskFileFactory.getFile(this.mDiskFileOp.buildPath(), this.mDiskFileOp.getName(), false, this.mDiskFileOp.isSdCard(), this.mDiskFileOp.isSavedCache());
        } else {
            folder = this.mDiskFileFactory.getFolder(this.mDiskFileOp.buildPath(), false, this.mDiskFileOp.isSdCard(), this.mDiskFileOp.isSavedCache());
        }
        if (folder != null && folder.exists()) {
            this.mDiskFileOp.setFileInfo(folder);
            this.mDiskFileOp.setSuccess(true);
            this.mDiskFileOp.unLock();
            return true;
        }
        this.mDiskFileOp.unLock();
        return false;
    }

    public boolean rename() {
        boolean z;
        try {
            File file = this.mDiskFileFactory.getFile(this.mDiskFileOp.buildPath(), this.mDiskFileOp.getName(), false, this.mDiskFileOp.isSdCard(), this.mDiskFileOp.isSavedCache());
            File file2 = this.mDiskFileFactory.getFile(this.mDiskFileOp.buildDesPath(), this.mDiskFileOp.getDesName(), true, this.mDiskFileOp.isSdCard(), this.mDiskFileOp.isSavedCache());
            if (file != null) {
                if (file2 != null) {
                    file2.delete();
                }
                z = file.renameTo(file2);
            } else {
                z = false;
            }
            if (z) {
                this.mDiskFileOp.setSuccess(true);
            }
            return z;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        } finally {
            this.mDiskFileOp.unLock();
        }
    }

    public boolean custom() {
        boolean z = false;
        try {
            if (this.mDiskFileOp.getCustomOperate() != null) {
                z = this.mDiskFileOp.getCustomOperate().operate(this, this.mDiskFileOp, this.mDiskFileFactory);
            }
            if (z) {
                this.mDiskFileOp.setSuccess(true);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        } finally {
            this.mDiskFileOp.unLock();
        }
        return z;
    }
}
