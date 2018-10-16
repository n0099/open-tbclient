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
    private OperateType zh;
    protected boolean zi;
    protected Action zj;
    private boolean zk;
    private File zl;
    private boolean zm;
    private boolean zn;
    private int zo;
    private String zp;
    private String zq;
    private e.a zr;

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
        this.zh = OperateType.MUST_SUCCESS;
        this.zi = false;
        this.zj = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.mIsSuccess = false;
        this.zk = true;
        this.mOutputStream = null;
        this.zl = null;
        this.zm = true;
        this.zn = false;
        this.zo = 0;
        this.zp = null;
        this.zq = null;
        this.zr = null;
        this.mPath = str;
        this.mName = str2;
        this.zj = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.zh = OperateType.MUST_SUCCESS;
        this.zi = false;
        this.zj = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.mIsSuccess = false;
        this.zk = true;
        this.mOutputStream = null;
        this.zl = null;
        this.zm = true;
        this.zn = false;
        this.zo = 0;
        this.zp = null;
        this.zq = null;
        this.zr = null;
        this.mPath = str;
        this.mName = str2;
        this.zp = str3;
        this.zq = str4;
        this.zj = action;
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

    public Action hJ() {
        return this.zj;
    }

    public boolean q(byte[] bArr) {
        return true;
    }

    public byte[] hK() {
        return null;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public void setSuccess(boolean z) {
        this.mIsSuccess = z;
    }

    public void D(boolean z) {
        this.zi = z;
    }

    public String hL() {
        if (this.zi && this.mName != null) {
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

    public String hM() {
        if (this.zi && this.zq != null) {
            int hashCode = this.zq.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.zp == null) {
                return String.valueOf(i);
            }
            return this.zp + "/" + i;
        }
        return this.zp;
    }

    public OperateType hN() {
        return this.zh;
    }

    public void a(OperateType operateType) {
        this.zh = operateType;
    }

    public void A(boolean z) {
    }

    public boolean hO() {
        return this.zk;
    }

    public void E(boolean z) {
        this.zk = z;
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

    public File hP() {
        return this.zl;
    }

    public void l(File file) {
        this.zl = file;
    }

    public boolean hQ() {
        return this.zm;
    }

    public void F(boolean z) {
        this.zm = z;
    }

    public void G(boolean z) {
        this.zn = z;
    }

    public boolean hR() {
        return this.zn;
    }

    public boolean hD() {
        return com.baidu.adp.lib.Disk.d.hC().b(this);
    }

    public int hS() {
        return this.zo;
    }

    public void Y(int i) {
        this.zo = i;
    }

    public String hT() {
        return this.zp;
    }

    public String hU() {
        return this.zq;
    }

    public e.a hV() {
        return this.zr;
    }
}
