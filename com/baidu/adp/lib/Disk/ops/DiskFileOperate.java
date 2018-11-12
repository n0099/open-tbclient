package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    protected volatile byte[] mData;
    private volatile boolean mIsSuccess;
    protected volatile Object mLock;
    protected String mName;
    private OutputStream mOutputStream;
    protected String mPath;
    private OperateType zk;
    protected boolean zl;
    protected Action zm;
    private boolean zn;
    private File zo;
    private boolean zp;
    private boolean zq;
    private int zr;
    private String zs;
    private String zt;
    private e.a zu;

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
        this.zk = OperateType.MUST_SUCCESS;
        this.zl = false;
        this.zm = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.mIsSuccess = false;
        this.zn = true;
        this.mOutputStream = null;
        this.zo = null;
        this.zp = true;
        this.zq = false;
        this.zr = 0;
        this.zs = null;
        this.zt = null;
        this.zu = null;
        this.mPath = str;
        this.mName = str2;
        this.zm = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.zk = OperateType.MUST_SUCCESS;
        this.zl = false;
        this.zm = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.mIsSuccess = false;
        this.zn = true;
        this.mOutputStream = null;
        this.zo = null;
        this.zp = true;
        this.zq = false;
        this.zr = 0;
        this.zs = null;
        this.zt = null;
        this.zu = null;
        this.mPath = str;
        this.mName = str2;
        this.zs = str3;
        this.zt = str4;
        this.zm = action;
    }

    public void q(Object obj) {
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

    public Action hI() {
        return this.zm;
    }

    public boolean p(byte[] bArr) {
        return true;
    }

    public byte[] hJ() {
        return null;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void setSuccess(boolean z) {
        this.mIsSuccess = z;
    }

    public void R(boolean z) {
        this.zl = z;
    }

    public String hK() {
        if (this.zl && this.mName != null) {
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

    public String hL() {
        if (this.zl && this.zt != null) {
            int hashCode = this.zt.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.zs == null) {
                return String.valueOf(i);
            }
            return this.zs + "/" + i;
        }
        return this.zs;
    }

    public OperateType hM() {
        return this.zk;
    }

    public void a(OperateType operateType) {
        this.zk = operateType;
    }

    public void O(boolean z) {
    }

    public boolean hN() {
        return this.zn;
    }

    public void S(boolean z) {
        this.zn = z;
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
                com.baidu.adp.lib.g.a.b(this.mOutputStream);
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

    public File hO() {
        return this.zo;
    }

    public void l(File file) {
        this.zo = file;
    }

    public boolean hP() {
        return this.zp;
    }

    public void T(boolean z) {
        this.zp = z;
    }

    public void U(boolean z) {
        this.zq = z;
    }

    public boolean hQ() {
        return this.zq;
    }

    public boolean hC() {
        return com.baidu.adp.lib.Disk.d.hB().b(this);
    }

    public int hR() {
        return this.zr;
    }

    public void ap(int i) {
        this.zr = i;
    }

    public String hS() {
        return this.zs;
    }

    public String hT() {
        return this.zt;
    }

    public e.a hU() {
        return this.zu;
    }
}
