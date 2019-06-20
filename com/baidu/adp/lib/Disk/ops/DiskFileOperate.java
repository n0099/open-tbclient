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
    private OperateType wR;
    protected boolean wS;
    protected Action wT;
    protected String wU;
    private volatile boolean wV;
    private boolean wW;
    private File wX;
    private boolean wY;
    private boolean wZ;
    private int xa;
    private String xb;
    private String xc;
    private e.a xd;

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
        this.wR = OperateType.MUST_SUCCESS;
        this.wS = false;
        this.wT = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.wU = null;
        this.wV = false;
        this.wW = true;
        this.mOutputStream = null;
        this.wX = null;
        this.wY = true;
        this.wZ = false;
        this.xa = 0;
        this.xb = null;
        this.xc = null;
        this.xd = null;
        this.wU = str;
        this.mName = str2;
        this.wT = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.wR = OperateType.MUST_SUCCESS;
        this.wS = false;
        this.wT = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.wU = null;
        this.wV = false;
        this.wW = true;
        this.mOutputStream = null;
        this.wX = null;
        this.wY = true;
        this.wZ = false;
        this.xa = 0;
        this.xb = null;
        this.xc = null;
        this.xd = null;
        this.wU = str;
        this.mName = str2;
        this.xb = str3;
        this.xc = str4;
        this.wT = action;
    }

    public void q(Object obj) {
        this.mLock = obj;
    }

    public void gA() {
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
        return this.wU;
    }

    public Action gB() {
        return this.wT;
    }

    public boolean i(byte[] bArr) {
        return true;
    }

    public byte[] gC() {
        return null;
    }

    public boolean isSuccess() {
        return this.wV;
    }

    public void setSuccess(boolean z) {
        this.wV = z;
    }

    public void J(boolean z) {
        this.wS = z;
    }

    public String gD() {
        if (this.wS && this.mName != null) {
            int hashCode = this.mName.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.wU == null) {
                return String.valueOf(i);
            }
            return this.wU + "/" + i;
        }
        return this.wU;
    }

    public String gE() {
        if (this.wS && this.xc != null) {
            int hashCode = this.xc.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.xb == null) {
                return String.valueOf(i);
            }
            return this.xb + "/" + i;
        }
        return this.xb;
    }

    public OperateType gF() {
        return this.wR;
    }

    public void a(OperateType operateType) {
        this.wR = operateType;
    }

    public void G(boolean z) {
    }

    public boolean gG() {
        return this.wW;
    }

    public void K(boolean z) {
        this.wW = z;
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

    public File gH() {
        return this.wX;
    }

    public void g(File file) {
        this.wX = file;
    }

    public boolean gI() {
        return this.wY;
    }

    public void L(boolean z) {
        this.wY = z;
    }

    public void M(boolean z) {
        this.wZ = z;
    }

    public boolean gJ() {
        return this.wZ;
    }

    public boolean gu() {
        return com.baidu.adp.lib.Disk.d.gt().b(this);
    }

    public int gK() {
        return this.xa;
    }

    public void Q(int i) {
        this.xa = i;
    }

    public String gL() {
        return this.xb;
    }

    public String gM() {
        return this.xc;
    }

    public e.a gN() {
        return this.xd;
    }
}
