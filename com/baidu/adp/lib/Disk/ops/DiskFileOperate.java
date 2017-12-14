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
    private OperateType re;
    protected boolean rf;
    protected Action rg;
    private volatile boolean rh;
    private boolean ri;
    private File rj;
    private boolean rk;
    private int rl;
    private String rm;
    private String ro;
    private e.a rp;

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
        this.re = OperateType.MUST_SUCCESS;
        this.rf = false;
        this.rg = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rh = false;
        this.ri = true;
        this.mOutputStream = null;
        this.rj = null;
        this.rk = true;
        this.rl = 0;
        this.rm = null;
        this.ro = null;
        this.rp = null;
        this.mPath = str;
        this.mName = str2;
        this.rg = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.re = OperateType.MUST_SUCCESS;
        this.rf = false;
        this.rg = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rh = false;
        this.ri = true;
        this.mOutputStream = null;
        this.rj = null;
        this.rk = true;
        this.rl = 0;
        this.rm = null;
        this.ro = null;
        this.rp = null;
        this.mPath = str;
        this.mName = str2;
        this.rm = str3;
        this.ro = str4;
        this.rg = action;
    }

    public void j(Object obj) {
        this.mLock = obj;
    }

    public void dO() {
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

    public Action dP() {
        return this.rg;
    }

    public boolean h(byte[] bArr) {
        return true;
    }

    public byte[] dQ() {
        return null;
    }

    public boolean isSuccess() {
        return this.rh;
    }

    public void setSuccess(boolean z) {
        this.rh = z;
    }

    public void t(boolean z) {
        this.rf = z;
    }

    public String dR() {
        if (this.rf && this.mName != null) {
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

    public String dS() {
        if (this.rf && this.ro != null) {
            int hashCode = this.ro.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.rm == null) {
                return String.valueOf(i);
            }
            return this.rm + "/" + i;
        }
        return this.rm;
    }

    public OperateType dT() {
        return this.re;
    }

    public void a(OperateType operateType) {
        this.re = operateType;
    }

    public void p(boolean z) {
    }

    public boolean dU() {
        return this.ri;
    }

    public void u(boolean z) {
        this.ri = z;
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

    public File dV() {
        return this.rj;
    }

    public void e(File file) {
        this.rj = file;
    }

    public boolean dW() {
        return this.rk;
    }

    public void v(boolean z) {
        this.rk = z;
    }

    public boolean dI() {
        return com.baidu.adp.lib.Disk.d.dH().b(this);
    }

    public int dX() {
        return this.rl;
    }

    public void V(int i) {
        this.rl = i;
    }

    public String dY() {
        return this.rm;
    }

    public String dZ() {
        return this.ro;
    }

    public e.a ea() {
        return this.rp;
    }
}
