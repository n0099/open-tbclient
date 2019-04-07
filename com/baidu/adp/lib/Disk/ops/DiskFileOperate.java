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
    private OperateType zh;
    protected boolean zi;
    protected Action zj;
    private volatile boolean zk;
    private boolean zl;
    private File zm;
    private boolean zn;
    private boolean zo;
    private int zp;
    private String zq;
    private String zr;
    private e.a zs;

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
        this.zk = false;
        this.zl = true;
        this.mOutputStream = null;
        this.zm = null;
        this.zn = true;
        this.zo = false;
        this.zp = 0;
        this.zq = null;
        this.zr = null;
        this.zs = null;
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
        this.zk = false;
        this.zl = true;
        this.mOutputStream = null;
        this.zm = null;
        this.zn = true;
        this.zo = false;
        this.zp = 0;
        this.zq = null;
        this.zr = null;
        this.zs = null;
        this.mPath = str;
        this.mName = str2;
        this.zq = str3;
        this.zr = str4;
        this.zj = action;
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
        return this.zj;
    }

    public boolean q(byte[] bArr) {
        return true;
    }

    public byte[] hI() {
        return null;
    }

    public boolean isSuccess() {
        return this.zk;
    }

    public void setSuccess(boolean z) {
        this.zk = z;
    }

    public void R(boolean z) {
        this.zi = z;
    }

    public String hJ() {
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

    public String hK() {
        if (this.zi && this.zr != null) {
            int hashCode = this.zr.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.zq == null) {
                return String.valueOf(i);
            }
            return this.zq + "/" + i;
        }
        return this.zq;
    }

    public OperateType hL() {
        return this.zh;
    }

    public void a(OperateType operateType) {
        this.zh = operateType;
    }

    public void O(boolean z) {
    }

    public boolean hM() {
        return this.zl;
    }

    public void S(boolean z) {
        this.zl = z;
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
        return this.zm;
    }

    public void m(File file) {
        this.zm = file;
    }

    public boolean hO() {
        return this.zn;
    }

    public void T(boolean z) {
        this.zn = z;
    }

    public void U(boolean z) {
        this.zo = z;
    }

    public boolean hP() {
        return this.zo;
    }

    public boolean hA() {
        return com.baidu.adp.lib.Disk.d.hz().b(this);
    }

    public int hQ() {
        return this.zp;
    }

    public void X(int i) {
        this.zp = i;
    }

    public String hR() {
        return this.zq;
    }

    public String hS() {
        return this.zr;
    }

    public e.a hT() {
        return this.zs;
    }
}
