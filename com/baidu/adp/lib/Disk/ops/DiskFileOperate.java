package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    protected volatile Object mLock;
    protected String mName;
    private OutputStream mOutputStream;
    protected String mPath;
    private OperateType rH;
    protected boolean rI;
    protected Action rJ;
    protected volatile byte[] rK;
    private volatile boolean rL;
    private boolean rM;
    private File rN;
    private boolean rO;
    private int rP;
    private String rQ;
    private String rR;
    private e.a rS;

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
        this.rH = OperateType.MUST_SUCCESS;
        this.rI = false;
        this.rJ = Action.READ;
        this.rK = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rL = false;
        this.rM = true;
        this.mOutputStream = null;
        this.rN = null;
        this.rO = true;
        this.rP = 0;
        this.rQ = null;
        this.rR = null;
        this.rS = null;
        this.mPath = str;
        this.mName = str2;
        this.rJ = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.rH = OperateType.MUST_SUCCESS;
        this.rI = false;
        this.rJ = Action.READ;
        this.rK = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rL = false;
        this.rM = true;
        this.mOutputStream = null;
        this.rN = null;
        this.rO = true;
        this.rP = 0;
        this.rQ = null;
        this.rR = null;
        this.rS = null;
        this.mPath = str;
        this.mName = str2;
        this.rQ = str3;
        this.rR = str4;
        this.rJ = action;
    }

    public void k(Object obj) {
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
        return this.rK;
    }

    public void setData(byte[] bArr) {
        this.rK = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action dP() {
        return this.rJ;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] dQ() {
        return null;
    }

    public boolean isSuccess() {
        return this.rL;
    }

    public void setSuccess(boolean z) {
        this.rL = z;
    }

    public void s(boolean z) {
        this.rI = z;
    }

    public String dR() {
        if (this.rI && this.mName != null) {
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
        if (this.rI && this.rR != null) {
            int hashCode = this.rR.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.rQ == null) {
                return String.valueOf(i);
            }
            return this.rQ + "/" + i;
        }
        return this.rQ;
    }

    public OperateType dT() {
        return this.rH;
    }

    public void a(OperateType operateType) {
        this.rH = operateType;
    }

    public void p(boolean z) {
    }

    public boolean dU() {
        return this.rM;
    }

    public void t(boolean z) {
        this.rM = z;
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
                com.baidu.adp.lib.g.a.d(this.mOutputStream);
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
        return this.rN;
    }

    public void e(File file) {
        this.rN = file;
    }

    public boolean dW() {
        return this.rO;
    }

    public void u(boolean z) {
        this.rO = z;
    }

    public boolean dI() {
        return com.baidu.adp.lib.Disk.d.dH().b(this);
    }

    public int dX() {
        return this.rP;
    }

    public void W(int i) {
        this.rP = i;
    }

    public String dY() {
        return this.rQ;
    }

    public String dZ() {
        return this.rR;
    }

    public e.a ea() {
        return this.rS;
    }
}
