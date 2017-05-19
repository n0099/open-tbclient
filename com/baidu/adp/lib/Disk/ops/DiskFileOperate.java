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
    private OperateType rI;
    protected boolean rJ;
    protected Action rK;
    protected volatile byte[] rL;
    private volatile boolean rM;
    private boolean rN;
    private File rO;
    private boolean rP;
    private int rQ;
    private String rR;
    private String rS;
    private e.a rT;

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
        CUSTOM;

        /* JADX DEBUG: Replace access to removed values field (rU) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Action[] valuesCustom() {
            Action[] valuesCustom = values();
            int length = valuesCustom.length;
            Action[] actionArr = new Action[length];
            System.arraycopy(valuesCustom, 0, actionArr, 0, length);
            return actionArr;
        }
    }

    /* loaded from: classes.dex */
    public enum OperateType {
        MUST_SUCCESS,
        TRY_SUCCESS;

        /* JADX DEBUG: Replace access to removed values field (rV) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static OperateType[] valuesCustom() {
            OperateType[] valuesCustom = values();
            int length = valuesCustom.length;
            OperateType[] operateTypeArr = new OperateType[length];
            System.arraycopy(valuesCustom, 0, operateTypeArr, 0, length);
            return operateTypeArr;
        }
    }

    public DiskFileOperate(String str, String str2, Action action) {
        this.rI = OperateType.MUST_SUCCESS;
        this.rJ = false;
        this.rK = Action.READ;
        this.rL = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rM = false;
        this.rN = true;
        this.mOutputStream = null;
        this.rO = null;
        this.rP = true;
        this.rQ = 0;
        this.rR = null;
        this.rS = null;
        this.rT = null;
        this.mPath = str;
        this.mName = str2;
        this.rK = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.rI = OperateType.MUST_SUCCESS;
        this.rJ = false;
        this.rK = Action.READ;
        this.rL = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rM = false;
        this.rN = true;
        this.mOutputStream = null;
        this.rO = null;
        this.rP = true;
        this.rQ = 0;
        this.rR = null;
        this.rS = null;
        this.rT = null;
        this.mPath = str;
        this.mName = str2;
        this.rR = str3;
        this.rS = str4;
        this.rK = action;
    }

    public void k(Object obj) {
        this.mLock = obj;
    }

    public void dQ() {
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
        return this.rL;
    }

    public void setData(byte[] bArr) {
        this.rL = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action dR() {
        return this.rK;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] dS() {
        return null;
    }

    public boolean isSuccess() {
        return this.rM;
    }

    public void setSuccess(boolean z) {
        this.rM = z;
    }

    public void s(boolean z) {
        this.rJ = z;
    }

    public String dT() {
        if (this.rJ && this.mName != null) {
            int hashCode = this.mName.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.mPath == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.mPath) + "/" + i;
        }
        return this.mPath;
    }

    public String dU() {
        if (this.rJ && this.rS != null) {
            int hashCode = this.rS.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.rR == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.rR) + "/" + i;
        }
        return this.rR;
    }

    public OperateType dV() {
        return this.rI;
    }

    public void a(OperateType operateType) {
        this.rI = operateType;
    }

    public void p(boolean z) {
    }

    public boolean dW() {
        return this.rN;
    }

    public void t(boolean z) {
        this.rN = z;
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

    public File dX() {
        return this.rO;
    }

    public void e(File file) {
        this.rO = file;
    }

    public boolean dY() {
        return this.rP;
    }

    public void u(boolean z) {
        this.rP = z;
    }

    public boolean dJ() {
        return com.baidu.adp.lib.Disk.d.dI().b(this);
    }

    public int dZ() {
        return this.rQ;
    }

    public void W(int i) {
        this.rQ = i;
    }

    public String ea() {
        return this.rR;
    }

    public String eb() {
        return this.rS;
    }

    public e.a ec() {
        return this.rT;
    }
}
