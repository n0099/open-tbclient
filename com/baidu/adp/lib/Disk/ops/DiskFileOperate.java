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
    private OperateType rC;
    protected boolean rD;
    protected Action rE;
    protected volatile byte[] rF;
    private volatile boolean rG;
    private boolean rH;
    private File rI;
    private boolean rJ;
    private int rK;
    private String rL;
    private String rM;
    private e.a rN;

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

        /* JADX DEBUG: Replace access to removed values field (rO) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (rP) with 'values()' method */
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
        this.rC = OperateType.MUST_SUCCESS;
        this.rD = false;
        this.rE = Action.READ;
        this.rF = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rG = false;
        this.rH = true;
        this.mOutputStream = null;
        this.rI = null;
        this.rJ = true;
        this.rK = 0;
        this.rL = null;
        this.rM = null;
        this.rN = null;
        this.mPath = str;
        this.mName = str2;
        this.rE = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.rC = OperateType.MUST_SUCCESS;
        this.rD = false;
        this.rE = Action.READ;
        this.rF = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rG = false;
        this.rH = true;
        this.mOutputStream = null;
        this.rI = null;
        this.rJ = true;
        this.rK = 0;
        this.rL = null;
        this.rM = null;
        this.rN = null;
        this.mPath = str;
        this.mName = str2;
        this.rL = str3;
        this.rM = str4;
        this.rE = action;
    }

    public void k(Object obj) {
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
        return this.rF;
    }

    public void setData(byte[] bArr) {
        this.rF = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action dQ() {
        return this.rE;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] dR() {
        return null;
    }

    public boolean isSuccess() {
        return this.rG;
    }

    public void setSuccess(boolean z) {
        this.rG = z;
    }

    public void s(boolean z) {
        this.rD = z;
    }

    public String dS() {
        if (this.rD && this.mName != null) {
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

    public String dT() {
        if (this.rD && this.rM != null) {
            int hashCode = this.rM.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.rL == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.rL) + "/" + i;
        }
        return this.rL;
    }

    public OperateType dU() {
        return this.rC;
    }

    public void a(OperateType operateType) {
        this.rC = operateType;
    }

    public void p(boolean z) {
    }

    public boolean dV() {
        return this.rH;
    }

    public void t(boolean z) {
        this.rH = z;
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

    public File dW() {
        return this.rI;
    }

    public void e(File file) {
        this.rI = file;
    }

    public boolean dX() {
        return this.rJ;
    }

    public void u(boolean z) {
        this.rJ = z;
    }

    public boolean dI() {
        return com.baidu.adp.lib.Disk.d.dH().b(this);
    }

    public int dY() {
        return this.rK;
    }

    public void W(int i) {
        this.rK = i;
    }

    public String dZ() {
        return this.rL;
    }

    public String ea() {
        return this.rM;
    }

    public e.a eb() {
        return this.rN;
    }
}
