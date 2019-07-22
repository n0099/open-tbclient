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
    private OperateType wU;
    protected boolean wV;
    protected Action wW;
    protected String wX;
    private volatile boolean wY;
    private boolean wZ;
    private File xa;
    private boolean xb;
    private boolean xc;
    private int xd;
    private String xe;
    private String xf;
    private e.a xg;

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
        this.wU = OperateType.MUST_SUCCESS;
        this.wV = false;
        this.wW = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.wX = null;
        this.wY = false;
        this.wZ = true;
        this.mOutputStream = null;
        this.xa = null;
        this.xb = true;
        this.xc = false;
        this.xd = 0;
        this.xe = null;
        this.xf = null;
        this.xg = null;
        this.wX = str;
        this.mName = str2;
        this.wW = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.wU = OperateType.MUST_SUCCESS;
        this.wV = false;
        this.wW = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.wX = null;
        this.wY = false;
        this.wZ = true;
        this.mOutputStream = null;
        this.xa = null;
        this.xb = true;
        this.xc = false;
        this.xd = 0;
        this.xe = null;
        this.xf = null;
        this.xg = null;
        this.wX = str;
        this.mName = str2;
        this.xe = str3;
        this.xf = str4;
        this.wW = action;
    }

    public void q(Object obj) {
        this.mLock = obj;
    }

    public void gJ() {
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
        return this.wX;
    }

    public Action gK() {
        return this.wW;
    }

    public boolean i(byte[] bArr) {
        return true;
    }

    public byte[] gL() {
        return null;
    }

    public boolean isSuccess() {
        return this.wY;
    }

    public void setSuccess(boolean z) {
        this.wY = z;
    }

    public void J(boolean z) {
        this.wV = z;
    }

    public String gM() {
        if (this.wV && this.mName != null) {
            int hashCode = this.mName.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.wX == null) {
                return String.valueOf(i);
            }
            return this.wX + "/" + i;
        }
        return this.wX;
    }

    public String gN() {
        if (this.wV && this.xf != null) {
            int hashCode = this.xf.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.xe == null) {
                return String.valueOf(i);
            }
            return this.xe + "/" + i;
        }
        return this.xe;
    }

    public OperateType gO() {
        return this.wU;
    }

    public void a(OperateType operateType) {
        this.wU = operateType;
    }

    public void G(boolean z) {
    }

    public boolean gP() {
        return this.wZ;
    }

    public void K(boolean z) {
        this.wZ = z;
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
                com.baidu.adp.lib.g.a.c(this.mOutputStream);
                this.mOutputStream = null;
            }
        }
    }

    public void b(OutputStream outputStream) {
        synchronized (this) {
            if (outputStream != this.mOutputStream) {
                release();
                this.mOutputStream = outputStream;
            }
        }
    }

    public File gQ() {
        return this.xa;
    }

    public void g(File file) {
        this.xa = file;
    }

    public boolean gR() {
        return this.xb;
    }

    public void L(boolean z) {
        this.xb = z;
    }

    public void M(boolean z) {
        this.xc = z;
    }

    public boolean gS() {
        return this.xc;
    }

    public boolean gD() {
        return com.baidu.adp.lib.Disk.d.gC().b(this);
    }

    public int gT() {
        return this.xd;
    }

    public void Q(int i) {
        this.xd = i;
    }

    public String gU() {
        return this.xe;
    }

    public String gV() {
        return this.xf;
    }

    public e.a gW() {
        return this.xg;
    }
}
