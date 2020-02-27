package com.baidu.live.adp.lib.disk.ops;

import com.baidu.live.adp.lib.disk.DiskManager;
import com.baidu.live.adp.lib.disk.DiskWorker;
import com.baidu.live.adp.lib.safe.BdCloseHelper;
import com.baidu.live.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public class DiskFileOperate {
    protected Action mAction;
    private DiskWorker.DiskWorkerOperate mCustomOperate;
    protected volatile byte[] mData;
    private String mDesName;
    private String mDesPath;
    private File mFileInfo;
    private boolean mFormatData;
    protected boolean mIsSubFolder;
    private volatile boolean mIsSuccess;
    protected volatile Object mLock;
    protected String mName;
    private OperateType mOperateType;
    private OutputStream mOutputStream;
    protected String mPath;
    private boolean mSavedCache;
    private boolean mSdCard;
    private int mTrySuccessWeight;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    public Object getLock() {
        return this.mLock;
    }

    public void setLock(Object obj) {
        this.mLock = obj;
    }

    public void unLock() {
        if (this.mLock != null) {
            try {
                synchronized (this.mLock) {
                    this.mLock.notifyAll();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public byte[] getData() {
        return this.mData;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action getAction() {
        return this.mAction;
    }

    public boolean formatData(byte[] bArr) {
        return true;
    }

    public byte[] buildFormatData() {
        return null;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void setSuccess(boolean z) {
        this.mIsSuccess = z;
    }

    public boolean isSubFolder() {
        return this.mIsSubFolder;
    }

    public void setSubFolder(boolean z) {
        this.mIsSubFolder = z;
    }

    public String buildPath() {
        if (this.mIsSubFolder && this.mName != null) {
            int hashCode = this.mName.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.mPath == null) {
                return String.valueOf(i);
            }
            return this.mPath + "/" + i;
        }
        return this.mPath;
    }

    public String buildDesPath() {
        if (this.mIsSubFolder && this.mDesName != null) {
            int hashCode = this.mDesName.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.mDesPath == null) {
                return String.valueOf(i);
            }
            return this.mDesPath + "/" + i;
        }
        return this.mDesPath;
    }

    public OperateType getOperateType() {
        return this.mOperateType;
    }

    public void setOperateType(OperateType operateType) {
        this.mOperateType = operateType;
    }

    public void callback(boolean z) {
    }

    public boolean isFormatData() {
        return this.mFormatData;
    }

    public void setIsFormatData(boolean z) {
        this.mFormatData = z;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        release();
    }

    public OutputStream getOutputStream() {
        OutputStream outputStream;
        synchronized (this) {
            outputStream = this.mOutputStream;
        }
        return outputStream;
    }

    public void release() {
        synchronized (this) {
            if (this.mOutputStream != null) {
                BdCloseHelper.close(this.mOutputStream);
                this.mOutputStream = null;
            }
        }
    }

    public void setOutputStream(OutputStream outputStream) {
        synchronized (this) {
            if (outputStream != this.mOutputStream) {
                release();
                this.mOutputStream = outputStream;
            }
        }
    }

    public File getFileInfo() {
        return this.mFileInfo;
    }

    public void setFileInfo(File file) {
        this.mFileInfo = file;
    }

    public boolean isSdCard() {
        return this.mSdCard;
    }

    public void setSdCard(boolean z) {
        this.mSdCard = z;
    }

    public void setSavedCache(boolean z) {
        this.mSavedCache = z;
    }

    public boolean isSavedCache() {
        return this.mSavedCache;
    }

    public boolean call() {
        return DiskManager.getInstance().call(this);
    }

    public boolean asyncCall() {
        return DiskManager.getInstance().asyncCall(this);
    }

    public void cancelAsyncCall() {
        DiskManager.getInstance().cancelAsyncCall(this);
    }

    public int getTrySuccessWeight() {
        return this.mTrySuccessWeight;
    }

    public void setTrySuccessWeight(int i) {
        this.mTrySuccessWeight = i;
    }

    public String getDesPath() {
        return this.mDesPath;
    }

    public String getDesName() {
        return this.mDesName;
    }

    public DiskWorker.DiskWorkerOperate getCustomOperate() {
        return this.mCustomOperate;
    }

    public void setCustomOperate(DiskWorker.DiskWorkerOperate diskWorkerOperate) {
        this.mCustomOperate = diskWorkerOperate;
    }
}
