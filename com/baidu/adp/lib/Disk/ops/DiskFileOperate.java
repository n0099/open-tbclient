package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    protected volatile byte[] mData;
    protected volatile Object mLock;
    protected String mName;
    private OutputStream mOutputStream;
    protected String mPath;
    private OperateType zi;
    protected boolean zj;
    protected Action zk;
    private volatile boolean zl;
    private boolean zm;
    private File zn;
    private boolean zo;
    private boolean zp;
    private int zq;
    private String zr;
    private String zs;
    private e.a zt;

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
        this.zi = OperateType.MUST_SUCCESS;
        this.zj = false;
        this.zk = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.zl = false;
        this.zm = true;
        this.mOutputStream = null;
        this.zn = null;
        this.zo = true;
        this.zp = false;
        this.zq = 0;
        this.zr = null;
        this.zs = null;
        this.zt = null;
        this.mPath = str;
        this.mName = str2;
        this.zk = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.zi = OperateType.MUST_SUCCESS;
        this.zj = false;
        this.zk = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.zl = false;
        this.zm = true;
        this.mOutputStream = null;
        this.zn = null;
        this.zo = true;
        this.zp = false;
        this.zq = 0;
        this.zr = null;
        this.zs = null;
        this.zt = null;
        this.mPath = str;
        this.mName = str2;
        this.zr = str3;
        this.zs = str4;
        this.zk = action;
    }

    public void q(Object obj) {
        this.mLock = obj;
    }

    public void hG() {
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

    public Action hH() {
        return this.zk;
    }

    public boolean q(byte[] bArr) {
        return true;
    }

    public byte[] hI() {
        return null;
    }

    public boolean isSuccess() {
        return this.zl;
    }

    public void setSuccess(boolean z) {
        this.zl = z;
    }

    public void R(boolean z) {
        this.zj = z;
    }

    public String hJ() {
        if (this.zj && this.mName != null) {
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

    public String hK() {
        if (this.zj && this.zs != null) {
            int hashCode = this.zs.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.zr == null) {
                return String.valueOf(i);
            }
            return this.zr + "/" + i;
        }
        return this.zr;
    }

    public OperateType hL() {
        return this.zi;
    }

    public void a(OperateType operateType) {
        this.zi = operateType;
    }

    public void O(boolean z) {
    }

    public boolean hM() {
        return this.zm;
    }

    public void S(boolean z) {
        this.zm = z;
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

    public File hN() {
        return this.zn;
    }

    public void m(File file) {
        this.zn = file;
    }

    public boolean hO() {
        return this.zo;
    }

    public void T(boolean z) {
        this.zo = z;
    }

    public void U(boolean z) {
        this.zp = z;
    }

    public boolean hP() {
        return this.zp;
    }

    public boolean hA() {
        return com.baidu.adp.lib.Disk.d.hz().b(this);
    }

    public int hQ() {
        return this.zq;
    }

    public void Y(int i) {
        this.zq = i;
    }

    public String hR() {
        return this.zr;
    }

    public String hS() {
        return this.zs;
    }

    public e.a hT() {
        return this.zt;
    }
}
