package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.f;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private OperateType dI;
    protected boolean dJ;
    protected Action dK;
    protected volatile byte[] dL;
    protected String dM;
    private volatile boolean dN;
    private boolean dO;
    private OutputStream dP;
    private File dQ;
    private boolean dR;
    private int dS;
    private String dT;
    private String dU;
    private f dV;
    protected volatile Object mLock;
    protected String mName;

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

        /* JADX DEBUG: Replace access to removed values field (dW) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (dX) with 'values()' method */
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
        this.dI = OperateType.MUST_SUCCESS;
        this.dJ = false;
        this.dK = Action.READ;
        this.dL = null;
        this.mLock = null;
        this.mName = null;
        this.dM = null;
        this.dN = false;
        this.dO = true;
        this.dP = null;
        this.dQ = null;
        this.dR = true;
        this.dS = 0;
        this.dT = null;
        this.dU = null;
        this.dV = null;
        this.dM = str;
        this.mName = str2;
        this.dK = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.dI = OperateType.MUST_SUCCESS;
        this.dJ = false;
        this.dK = Action.READ;
        this.dL = null;
        this.mLock = null;
        this.mName = null;
        this.dM = null;
        this.dN = false;
        this.dO = true;
        this.dP = null;
        this.dQ = null;
        this.dR = true;
        this.dS = 0;
        this.dT = null;
        this.dU = null;
        this.dV = null;
        this.dM = str;
        this.mName = str2;
        this.dT = str3;
        this.dU = str4;
        this.dK = action;
    }

    public void b(Object obj) {
        this.mLock = obj;
    }

    public void bw() {
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
        return this.dL;
    }

    public void setData(byte[] bArr) {
        this.dL = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.dM;
    }

    public Action bx() {
        return this.dK;
    }

    public boolean i(byte[] bArr) {
        return true;
    }

    public byte[] by() {
        return null;
    }

    public boolean isSuccess() {
        return this.dN;
    }

    public void setSuccess(boolean z) {
        this.dN = z;
    }

    public void k(boolean z) {
        this.dJ = z;
    }

    public String bz() {
        if (this.dJ && this.mName != null) {
            int abs = (Math.abs(this.mName.hashCode()) % 100) + 1;
            if (this.dM == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.dM) + "/" + abs;
        }
        return this.dM;
    }

    public String bA() {
        if (this.dJ && this.dU != null) {
            int abs = (Math.abs(this.dU.hashCode()) % 100) + 1;
            if (this.dT == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.dT) + "/" + abs;
        }
        return this.dT;
    }

    public OperateType bB() {
        return this.dI;
    }

    public void a(OperateType operateType) {
        this.dI = operateType;
    }

    public void h(boolean z) {
    }

    public boolean bC() {
        return this.dO;
    }

    public void l(boolean z) {
        this.dO = z;
    }

    protected void finalize() {
        super.finalize();
        release();
    }

    public OutputStream getOutputStream() {
        OutputStream outputStream;
        synchronized (this) {
            outputStream = this.dP;
        }
        return outputStream;
    }

    public void release() {
        synchronized (this) {
            if (this.dP != null) {
                com.baidu.adp.lib.g.a.a(this.dP);
                this.dP = null;
            }
        }
    }

    public void setOutputStream(OutputStream outputStream) {
        synchronized (this) {
            if (outputStream != this.dP) {
                release();
                this.dP = outputStream;
            }
        }
    }

    public File bD() {
        return this.dQ;
    }

    public void d(File file) {
        this.dQ = file;
    }

    public boolean bE() {
        return this.dR;
    }

    public void m(boolean z) {
        this.dR = z;
    }

    public boolean bp() {
        return com.baidu.adp.lib.Disk.d.bn().b(this);
    }

    public boolean bF() {
        return com.baidu.adp.lib.Disk.d.bn().c(this);
    }

    public int bG() {
        return this.dS;
    }

    public void n(int i) {
        this.dS = i;
    }

    public String bH() {
        return this.dT;
    }

    public String bI() {
        return this.dU;
    }

    public f bJ() {
        return this.dV;
    }

    public void a(f fVar) {
        this.dV = fVar;
    }
}
