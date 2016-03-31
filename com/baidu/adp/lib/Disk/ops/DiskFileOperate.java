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
        CUSTOM;

        /* JADX DEBUG: Replace access to removed values field (rT) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (rU) with 'values()' method */
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

    public void h(Object obj) {
        this.mLock = obj;
    }

    public void fA() {
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

    public Action fB() {
        return this.rJ;
    }

    public boolean h(byte[] bArr) {
        return true;
    }

    public byte[] fC() {
        return null;
    }

    public boolean isSuccess() {
        return this.rL;
    }

    public void setSuccess(boolean z) {
        this.rL = z;
    }

    public void n(boolean z) {
        this.rI = z;
    }

    public String fD() {
        if (this.rI && this.mName != null) {
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

    public String fE() {
        if (this.rI && this.rR != null) {
            int hashCode = this.rR.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.rQ == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.rQ) + "/" + i;
        }
        return this.rQ;
    }

    public OperateType fF() {
        return this.rH;
    }

    public void a(OperateType operateType) {
        this.rH = operateType;
    }

    public void k(boolean z) {
    }

    public boolean fG() {
        return this.rM;
    }

    public void o(boolean z) {
        this.rM = z;
    }

    protected void finalize() {
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
                com.baidu.adp.lib.h.a.b(this.mOutputStream);
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

    public File fH() {
        return this.rN;
    }

    public void d(File file) {
        this.rN = file;
    }

    public boolean fI() {
        return this.rO;
    }

    public void p(boolean z) {
        this.rO = z;
    }

    public boolean ft() {
        return com.baidu.adp.lib.Disk.d.fs().b(this);
    }

    public int fJ() {
        return this.rP;
    }

    public void T(int i) {
        this.rP = i;
    }

    public String fK() {
        return this.rQ;
    }

    public String fL() {
        return this.rR;
    }

    public e.a fM() {
        return this.rS;
    }
}
