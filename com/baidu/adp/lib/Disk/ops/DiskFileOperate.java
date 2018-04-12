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
    private OperateType pX;
    protected boolean pY;
    protected Action pZ;
    private volatile boolean qa;
    private boolean qb;
    private File qc;
    private boolean qd;
    private boolean qe;
    private int qf;
    private String qg;
    private String qh;
    private e.a qi;

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
        this.pX = OperateType.MUST_SUCCESS;
        this.pY = false;
        this.pZ = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.qa = false;
        this.qb = true;
        this.mOutputStream = null;
        this.qc = null;
        this.qd = true;
        this.qe = false;
        this.qf = 0;
        this.qg = null;
        this.qh = null;
        this.qi = null;
        this.mPath = str;
        this.mName = str2;
        this.pZ = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.pX = OperateType.MUST_SUCCESS;
        this.pY = false;
        this.pZ = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.qa = false;
        this.qb = true;
        this.mOutputStream = null;
        this.qc = null;
        this.qd = true;
        this.qe = false;
        this.qf = 0;
        this.qg = null;
        this.qh = null;
        this.qi = null;
        this.mPath = str;
        this.mName = str2;
        this.qg = str3;
        this.qh = str4;
        this.pZ = action;
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
        return this.pZ;
    }

    public boolean j(byte[] bArr) {
        return true;
    }

    public byte[] dy() {
        return null;
    }

    public boolean isSuccess() {
        return this.qa;
    }

    public void setSuccess(boolean z) {
        this.qa = z;
    }

    public void u(boolean z) {
        this.pY = z;
    }

    public String dz() {
        if (this.pY && this.mName != null) {
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
        if (this.pY && this.qh != null) {
            int hashCode = this.qh.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.qg == null) {
                return String.valueOf(i);
            }
            return this.qg + "/" + i;
        }
        return this.qg;
    }

    public OperateType dB() {
        return this.pX;
    }

    public void a(OperateType operateType) {
        this.pX = operateType;
    }

    public void q(boolean z) {
    }

    public boolean dC() {
        return this.qb;
    }

    public void v(boolean z) {
        this.qb = z;
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
        return this.qc;
    }

    public void f(File file) {
        this.qc = file;
    }

    public boolean dE() {
        return this.qd;
    }

    public void w(boolean z) {
        this.qd = z;
    }

    public void x(boolean z) {
        this.qe = z;
    }

    public boolean dF() {
        return this.qe;
    }

    public boolean dq() {
        return com.baidu.adp.lib.Disk.d.dp().b(this);
    }

    public int dG() {
        return this.qf;
    }

    public void P(int i) {
        this.qf = i;
    }

    public String dH() {
        return this.qg;
    }

    public String dI() {
        return this.qh;
    }

    public e.a dJ() {
        return this.qi;
    }
}
