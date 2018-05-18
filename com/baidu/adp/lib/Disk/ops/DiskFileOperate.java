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
    private OperateType pW;
    protected boolean pX;
    protected Action pY;
    private volatile boolean pZ;
    private boolean qa;
    private File qb;
    private boolean qc;
    private boolean qd;
    private int qe;
    private String qf;
    private String qg;
    private e.a qh;

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
        this.pW = OperateType.MUST_SUCCESS;
        this.pX = false;
        this.pY = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.pZ = false;
        this.qa = true;
        this.mOutputStream = null;
        this.qb = null;
        this.qc = true;
        this.qd = false;
        this.qe = 0;
        this.qf = null;
        this.qg = null;
        this.qh = null;
        this.mPath = str;
        this.mName = str2;
        this.pY = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.pW = OperateType.MUST_SUCCESS;
        this.pX = false;
        this.pY = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.pZ = false;
        this.qa = true;
        this.mOutputStream = null;
        this.qb = null;
        this.qc = true;
        this.qd = false;
        this.qe = 0;
        this.qf = null;
        this.qg = null;
        this.qh = null;
        this.mPath = str;
        this.mName = str2;
        this.qf = str3;
        this.qg = str4;
        this.pY = action;
    }

    public void j(Object obj) {
        this.mLock = obj;
    }

    public void dw() {
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

    public Action dx() {
        return this.pY;
    }

    public boolean j(byte[] bArr) {
        return true;
    }

    public byte[] dy() {
        return null;
    }

    public boolean isSuccess() {
        return this.pZ;
    }

    public void setSuccess(boolean z) {
        this.pZ = z;
    }

    public void u(boolean z) {
        this.pX = z;
    }

    public String dz() {
        if (this.pX && this.mName != null) {
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

    public String dA() {
        if (this.pX && this.qg != null) {
            int hashCode = this.qg.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.qf == null) {
                return String.valueOf(i);
            }
            return this.qf + "/" + i;
        }
        return this.qf;
    }

    public OperateType dB() {
        return this.pW;
    }

    public void a(OperateType operateType) {
        this.pW = operateType;
    }

    public void q(boolean z) {
    }

    public boolean dC() {
        return this.qa;
    }

    public void v(boolean z) {
        this.qa = z;
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

    public File dD() {
        return this.qb;
    }

    public void f(File file) {
        this.qb = file;
    }

    public boolean dE() {
        return this.qc;
    }

    public void w(boolean z) {
        this.qc = z;
    }

    public void x(boolean z) {
        this.qd = z;
    }

    public boolean dF() {
        return this.qd;
    }

    public boolean dq() {
        return com.baidu.adp.lib.Disk.d.dp().b(this);
    }

    public int dG() {
        return this.qe;
    }

    public void P(int i) {
        this.qe = i;
    }

    public String dH() {
        return this.qf;
    }

    public String dI() {
        return this.qg;
    }

    public e.a dJ() {
        return this.qh;
    }
}
