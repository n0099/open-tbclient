package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.a.d;
import d.a.c.e.a.e;
import d.a.c.e.m.a;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    public Action mAction;
    public e.b mCustomOperate;
    public volatile byte[] mData;
    public String mDesName;
    public String mDesPath;
    public File mFileInfo;
    public boolean mFormatData;
    public boolean mIsSubFolder;
    public volatile boolean mIsSuccess;
    public volatile Object mLock;
    public String mName;
    public OperateType mOperateType;
    public OutputStream mOutputStream;
    public String mPath;
    public boolean mSavedCache;
    public boolean mSdCard;
    public int mTrySuccessWeight;

    /* loaded from: classes.dex */
    public enum Action {
        READ,
        WRITE,
        WRITE_FORCE,
        APPEND,
        APPEND_MORE,
        DELETE,
        DELETE_FILES,
        INFO,
        RENAME,
        CUSTOM
    }

    /* loaded from: classes.dex */
    public enum OperateType {
        MUST_SUCCESS,
        TRY_SUCCESS
    }

    public DiskFileOperate(String str, String str2, Action action) {
        this.mOperateType = OperateType.MUST_SUCCESS;
        this.mIsSubFolder = false;
        this.mAction = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.mIsSuccess = false;
        this.mFormatData = true;
        this.mOutputStream = null;
        this.mFileInfo = null;
        this.mSdCard = true;
        this.mSavedCache = false;
        this.mTrySuccessWeight = 0;
        this.mDesPath = null;
        this.mDesName = null;
        this.mCustomOperate = null;
        this.mPath = str;
        this.mName = str2;
        this.mAction = action;
    }

    public boolean asyncCall() {
        return d.g().a(this);
    }

    public String buildDesPath() {
        String str;
        if (this.mIsSubFolder && (str = this.mDesName) != null) {
            int hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i2 = (hashCode % 100) + 1;
            if (this.mDesPath == null) {
                return String.valueOf(i2);
            }
            return this.mDesPath + "/" + i2;
        }
        return this.mDesPath;
    }

    public byte[] buildFormatData() {
        return null;
    }

    public String buildPath() {
        String str;
        if (this.mIsSubFolder && (str = this.mName) != null) {
            int hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i2 = (hashCode % 100) + 1;
            if (this.mPath == null) {
                return String.valueOf(i2);
            }
            return this.mPath + "/" + i2;
        }
        return this.mPath;
    }

    public boolean call() {
        return d.g().d(this);
    }

    public void callback(boolean z) {
    }

    public void cancelAsyncCall() {
        d.g().e(this);
    }

    public void endLog() {
    }

    public void finalize() throws Throwable {
        super.finalize();
        release();
    }

    public boolean formatData(byte[] bArr) {
        return true;
    }

    public Action getAction() {
        return this.mAction;
    }

    public e.b getCustomOperate() {
        return this.mCustomOperate;
    }

    public byte[] getData() {
        return this.mData;
    }

    public String getDesName() {
        return this.mDesName;
    }

    public String getDesPath() {
        return this.mDesPath;
    }

    public File getFileInfo() {
        return this.mFileInfo;
    }

    public Object getLock() {
        return this.mLock;
    }

    public String getName() {
        return this.mName;
    }

    public OperateType getOperateType() {
        return this.mOperateType;
    }

    public OutputStream getOutputStream() {
        OutputStream outputStream;
        synchronized (this) {
            outputStream = this.mOutputStream;
        }
        return outputStream;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getTrySuccessWeight() {
        return this.mTrySuccessWeight;
    }

    public boolean isFormatData() {
        return this.mFormatData;
    }

    public boolean isSavedCache() {
        return this.mSavedCache;
    }

    public boolean isSdCard() {
        return this.mSdCard;
    }

    public boolean isSubFolder() {
        return this.mIsSubFolder;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void release() {
        synchronized (this) {
            if (this.mOutputStream != null) {
                a.d(this.mOutputStream);
                this.mOutputStream = null;
            }
        }
    }

    public void setCustomOperate(e.b bVar) {
        this.mCustomOperate = bVar;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setFileInfo(File file) {
        this.mFileInfo = file;
    }

    public void setIsFormatData(boolean z) {
        this.mFormatData = z;
    }

    public void setLock(Object obj) {
        this.mLock = obj;
    }

    public void setOperateType(OperateType operateType) {
        this.mOperateType = operateType;
    }

    public void setOutputStream(OutputStream outputStream) {
        synchronized (this) {
            if (outputStream == this.mOutputStream) {
                return;
            }
            release();
            this.mOutputStream = outputStream;
        }
    }

    public void setSavedCache(boolean z) {
        this.mSavedCache = z;
    }

    public void setSdCard(boolean z) {
        this.mSdCard = z;
    }

    public void setSubFolder(boolean z) {
        this.mIsSubFolder = z;
    }

    public void setSuccess(boolean z) {
        this.mIsSuccess = z;
    }

    public void setTrySuccessWeight(int i2) {
        this.mTrySuccessWeight = i2;
    }

    public void startLog() {
    }

    public void unLock() {
        if (this.mLock != null) {
            try {
                synchronized (this.mLock) {
                    this.mLock.notifyAll();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.mOperateType = OperateType.MUST_SUCCESS;
        this.mIsSubFolder = false;
        this.mAction = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.mIsSuccess = false;
        this.mFormatData = true;
        this.mOutputStream = null;
        this.mFileInfo = null;
        this.mSdCard = true;
        this.mSavedCache = false;
        this.mTrySuccessWeight = 0;
        this.mDesPath = null;
        this.mDesName = null;
        this.mCustomOperate = null;
        this.mPath = str;
        this.mName = str2;
        this.mDesPath = str3;
        this.mDesName = str4;
        this.mAction = action;
    }
}
