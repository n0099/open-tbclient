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
    private OperateType rd;
    protected boolean re;
    protected Action rf;
    private volatile boolean rg;
    private boolean rh;
    private File ri;
    private boolean rj;
    private int rk;
    private String rl;
    private String rm;
    private e.a ro;

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
        this.rd = OperateType.MUST_SUCCESS;
        this.re = false;
        this.rf = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rg = false;
        this.rh = true;
        this.mOutputStream = null;
        this.ri = null;
        this.rj = true;
        this.rk = 0;
        this.rl = null;
        this.rm = null;
        this.ro = null;
        this.mPath = str;
        this.mName = str2;
        this.rf = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.rd = OperateType.MUST_SUCCESS;
        this.re = false;
        this.rf = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rg = false;
        this.rh = true;
        this.mOutputStream = null;
        this.ri = null;
        this.rj = true;
        this.rk = 0;
        this.rl = null;
        this.rm = null;
        this.ro = null;
        this.mPath = str;
        this.mName = str2;
        this.rl = str3;
        this.rm = str4;
        this.rf = action;
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
        return this.rf;
    }

    public boolean h(byte[] bArr) {
        return true;
    }

    public byte[] dQ() {
        return null;
    }

    public boolean isSuccess() {
        return this.rg;
    }

    public void setSuccess(boolean z) {
        this.rg = z;
    }

    public void t(boolean z) {
        this.re = z;
    }

    public String dR() {
        if (this.re && this.mName != null) {
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
        if (this.re && this.rm != null) {
            int hashCode = this.rm.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.rl == null) {
                return String.valueOf(i);
            }
            return this.rl + "/" + i;
        }
        return this.rl;
    }

    public OperateType dT() {
        return this.rd;
    }

    public void a(OperateType operateType) {
        this.rd = operateType;
    }

    public void p(boolean z) {
    }

    public boolean dU() {
        return this.rh;
    }

    public void u(boolean z) {
        this.rh = z;
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
        return this.ri;
    }

    public void e(File file) {
        this.ri = file;
    }

    public boolean dW() {
        return this.rj;
    }

    public void v(boolean z) {
        this.rj = z;
    }

    public boolean dI() {
        return com.baidu.adp.lib.Disk.d.dH().b(this);
    }

    public int dX() {
        return this.rk;
    }

    public void W(int i) {
        this.rk = i;
    }

    public String dY() {
        return this.rl;
    }

    public String dZ() {
        return this.rm;
    }

    public e.a ea() {
        return this.ro;
    }
}
