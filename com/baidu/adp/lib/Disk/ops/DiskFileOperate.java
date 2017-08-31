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
    private OperateType rc;
    protected boolean rd;
    protected Action re;
    private volatile boolean rf;
    private boolean rg;
    private File rh;
    private boolean ri;
    private int rj;
    private String rk;
    private String rl;
    private e.a rm;

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
        this.rc = OperateType.MUST_SUCCESS;
        this.rd = false;
        this.re = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rf = false;
        this.rg = true;
        this.mOutputStream = null;
        this.rh = null;
        this.ri = true;
        this.rj = 0;
        this.rk = null;
        this.rl = null;
        this.rm = null;
        this.mPath = str;
        this.mName = str2;
        this.re = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.rc = OperateType.MUST_SUCCESS;
        this.rd = false;
        this.re = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rf = false;
        this.rg = true;
        this.mOutputStream = null;
        this.rh = null;
        this.ri = true;
        this.rj = 0;
        this.rk = null;
        this.rl = null;
        this.rm = null;
        this.mPath = str;
        this.mName = str2;
        this.rk = str3;
        this.rl = str4;
        this.re = action;
    }

    public void j(Object obj) {
        this.mLock = obj;
    }

    public void dP() {
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

    public Action dQ() {
        return this.re;
    }

    public boolean h(byte[] bArr) {
        return true;
    }

    public byte[] dR() {
        return null;
    }

    public boolean isSuccess() {
        return this.rf;
    }

    public void setSuccess(boolean z) {
        this.rf = z;
    }

    public void t(boolean z) {
        this.rd = z;
    }

    public String dS() {
        if (this.rd && this.mName != null) {
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

    public String dT() {
        if (this.rd && this.rl != null) {
            int hashCode = this.rl.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.rk == null) {
                return String.valueOf(i);
            }
            return this.rk + "/" + i;
        }
        return this.rk;
    }

    public OperateType dU() {
        return this.rc;
    }

    public void a(OperateType operateType) {
        this.rc = operateType;
    }

    public void p(boolean z) {
    }

    public boolean dV() {
        return this.rg;
    }

    public void u(boolean z) {
        this.rg = z;
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

    public File dW() {
        return this.rh;
    }

    public void e(File file) {
        this.rh = file;
    }

    public boolean dX() {
        return this.ri;
    }

    public void v(boolean z) {
        this.ri = z;
    }

    public boolean dJ() {
        return com.baidu.adp.lib.Disk.d.dI().b(this);
    }

    public int dY() {
        return this.rj;
    }

    public void W(int i) {
        this.rj = i;
    }

    public String dZ() {
        return this.rk;
    }

    public String ea() {
        return this.rl;
    }

    public e.a eb() {
        return this.rm;
    }
}
