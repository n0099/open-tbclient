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
    private OperateType wS;
    protected boolean wT;
    protected Action wU;
    protected String wV;
    private volatile boolean wW;
    private boolean wX;
    private File wY;
    private boolean wZ;
    private boolean xa;
    private int xb;
    private String xc;
    private String xd;
    private e.a xe;

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
        this.wS = OperateType.MUST_SUCCESS;
        this.wT = false;
        this.wU = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.wV = null;
        this.wW = false;
        this.wX = true;
        this.mOutputStream = null;
        this.wY = null;
        this.wZ = true;
        this.xa = false;
        this.xb = 0;
        this.xc = null;
        this.xd = null;
        this.xe = null;
        this.wV = str;
        this.mName = str2;
        this.wU = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.wS = OperateType.MUST_SUCCESS;
        this.wT = false;
        this.wU = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.wV = null;
        this.wW = false;
        this.wX = true;
        this.mOutputStream = null;
        this.wY = null;
        this.wZ = true;
        this.xa = false;
        this.xb = 0;
        this.xc = null;
        this.xd = null;
        this.xe = null;
        this.wV = str;
        this.mName = str2;
        this.xc = str3;
        this.xd = str4;
        this.wU = action;
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
        return this.wV;
    }

    public Action gB() {
        return this.wU;
    }

    public boolean i(byte[] bArr) {
        return true;
    }

    public byte[] gC() {
        return null;
    }

    public boolean isSuccess() {
        return this.wW;
    }

    public void setSuccess(boolean z) {
        this.wW = z;
    }

    public void J(boolean z) {
        this.wT = z;
    }

    public String gD() {
        if (this.wT && this.mName != null) {
            int hashCode = this.mName.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.wV == null) {
                return String.valueOf(i);
            }
            return this.wV + "/" + i;
        }
        return this.wV;
    }

    public String gE() {
        if (this.wT && this.xd != null) {
            int hashCode = this.xd.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.xc == null) {
                return String.valueOf(i);
            }
            return this.xc + "/" + i;
        }
        return this.xc;
    }

    public OperateType gF() {
        return this.wS;
    }

    public void a(OperateType operateType) {
        this.wS = operateType;
    }

    public void G(boolean z) {
    }

    public boolean gG() {
        return this.wX;
    }

    public void K(boolean z) {
        this.wX = z;
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
        return this.wY;
    }

    public void g(File file) {
        this.wY = file;
    }

    public boolean gI() {
        return this.wZ;
    }

    public void L(boolean z) {
        this.wZ = z;
    }

    public void M(boolean z) {
        this.xa = z;
    }

    public boolean gJ() {
        return this.xa;
    }

    public boolean gu() {
        return com.baidu.adp.lib.Disk.d.gt().b(this);
    }

    public int gK() {
        return this.xb;
    }

    public void Q(int i) {
        this.xb = i;
    }

    public String gL() {
        return this.xc;
    }

    public String gM() {
        return this.xd;
    }

    public e.a gN() {
        return this.xe;
    }
}
