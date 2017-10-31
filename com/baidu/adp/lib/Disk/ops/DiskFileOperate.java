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
    private OperateType rf;
    protected boolean rg;
    protected Action rh;
    private volatile boolean ri;
    private boolean rj;
    private File rk;
    private boolean rl;
    private int rm;
    private String ro;
    private String rp;
    private e.a rq;

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
        this.rf = OperateType.MUST_SUCCESS;
        this.rg = false;
        this.rh = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.ri = false;
        this.rj = true;
        this.mOutputStream = null;
        this.rk = null;
        this.rl = true;
        this.rm = 0;
        this.ro = null;
        this.rp = null;
        this.rq = null;
        this.mPath = str;
        this.mName = str2;
        this.rh = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.rf = OperateType.MUST_SUCCESS;
        this.rg = false;
        this.rh = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.ri = false;
        this.rj = true;
        this.mOutputStream = null;
        this.rk = null;
        this.rl = true;
        this.rm = 0;
        this.ro = null;
        this.rp = null;
        this.rq = null;
        this.mPath = str;
        this.mName = str2;
        this.ro = str3;
        this.rp = str4;
        this.rh = action;
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
        return this.rh;
    }

    public boolean h(byte[] bArr) {
        return true;
    }

    public byte[] dQ() {
        return null;
    }

    public boolean isSuccess() {
        return this.ri;
    }

    public void setSuccess(boolean z) {
        this.ri = z;
    }

    public void t(boolean z) {
        this.rg = z;
    }

    public String dR() {
        if (this.rg && this.mName != null) {
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
        if (this.rg && this.rp != null) {
            int hashCode = this.rp.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.ro == null) {
                return String.valueOf(i);
            }
            return this.ro + "/" + i;
        }
        return this.ro;
    }

    public OperateType dT() {
        return this.rf;
    }

    public void a(OperateType operateType) {
        this.rf = operateType;
    }

    public void p(boolean z) {
    }

    public boolean dU() {
        return this.rj;
    }

    public void u(boolean z) {
        this.rj = z;
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
        return this.rk;
    }

    public void e(File file) {
        this.rk = file;
    }

    public boolean dW() {
        return this.rl;
    }

    public void v(boolean z) {
        this.rl = z;
    }

    public boolean dI() {
        return com.baidu.adp.lib.Disk.d.dH().b(this);
    }

    public int dX() {
        return this.rm;
    }

    public void W(int i) {
        this.rm = i;
    }

    public String dY() {
        return this.ro;
    }

    public String dZ() {
        return this.rp;
    }

    public e.a ea() {
        return this.rq;
    }
}
