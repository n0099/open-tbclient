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
    private volatile boolean yA;
    private boolean yB;
    private File yC;
    private boolean yD;
    private boolean yE;
    private int yF;
    private String yG;
    private String yH;
    private e.a yI;
    private OperateType yw;
    protected boolean yx;
    protected Action yy;
    protected String yz;

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
        this.yw = OperateType.MUST_SUCCESS;
        this.yx = false;
        this.yy = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.yz = null;
        this.yA = false;
        this.yB = true;
        this.mOutputStream = null;
        this.yC = null;
        this.yD = true;
        this.yE = false;
        this.yF = 0;
        this.yG = null;
        this.yH = null;
        this.yI = null;
        this.yz = str;
        this.mName = str2;
        this.yy = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.yw = OperateType.MUST_SUCCESS;
        this.yx = false;
        this.yy = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.yz = null;
        this.yA = false;
        this.yB = true;
        this.mOutputStream = null;
        this.yC = null;
        this.yD = true;
        this.yE = false;
        this.yF = 0;
        this.yG = null;
        this.yH = null;
        this.yI = null;
        this.yz = str;
        this.mName = str2;
        this.yG = str3;
        this.yH = str4;
        this.yy = action;
    }

    public void n(Object obj) {
        this.mLock = obj;
    }

    public void hs() {
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
        return this.yz;
    }

    public Action ht() {
        return this.yy;
    }

    public boolean q(byte[] bArr) {
        return true;
    }

    public byte[] hu() {
        return null;
    }

    public boolean isSuccess() {
        return this.yA;
    }

    public void setSuccess(boolean z) {
        this.yA = z;
    }

    public void D(boolean z) {
        this.yx = z;
    }

    public String hv() {
        if (this.yx && this.mName != null) {
            int hashCode = this.mName.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.yz == null) {
                return String.valueOf(i);
            }
            return this.yz + "/" + i;
        }
        return this.yz;
    }

    public String hw() {
        if (this.yx && this.yH != null) {
            int hashCode = this.yH.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.yG == null) {
                return String.valueOf(i);
            }
            return this.yG + "/" + i;
        }
        return this.yG;
    }

    public OperateType hx() {
        return this.yw;
    }

    public void a(OperateType operateType) {
        this.yw = operateType;
    }

    public void A(boolean z) {
    }

    public boolean hy() {
        return this.yB;
    }

    public void E(boolean z) {
        this.yB = z;
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

    public File hz() {
        return this.yC;
    }

    public void l(File file) {
        this.yC = file;
    }

    public boolean hA() {
        return this.yD;
    }

    public void F(boolean z) {
        this.yD = z;
    }

    public void G(boolean z) {
        this.yE = z;
    }

    public boolean hB() {
        return this.yE;
    }

    public boolean hm() {
        return com.baidu.adp.lib.Disk.d.hl().b(this);
    }

    public int hC() {
        return this.yF;
    }

    public void Y(int i) {
        this.yF = i;
    }

    public String hD() {
        return this.yG;
    }

    public String hE() {
        return this.yH;
    }

    public e.a hF() {
        return this.yI;
    }
}
