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
    protected Action rA;
    private volatile boolean rB;
    private boolean rC;
    private File rD;
    private boolean rE;
    private int rF;
    private String rG;
    private String rH;
    private e.a rI;
    private OperateType ry;
    protected boolean rz;

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

        /* JADX DEBUG: Replace access to removed values field (rJ) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (rK) with 'values()' method */
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
        this.ry = OperateType.MUST_SUCCESS;
        this.rz = false;
        this.rA = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rB = false;
        this.rC = true;
        this.mOutputStream = null;
        this.rD = null;
        this.rE = true;
        this.rF = 0;
        this.rG = null;
        this.rH = null;
        this.rI = null;
        this.mPath = str;
        this.mName = str2;
        this.rA = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.ry = OperateType.MUST_SUCCESS;
        this.rz = false;
        this.rA = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rB = false;
        this.rC = true;
        this.mOutputStream = null;
        this.rD = null;
        this.rE = true;
        this.rF = 0;
        this.rG = null;
        this.rH = null;
        this.rI = null;
        this.mPath = str;
        this.mName = str2;
        this.rG = str3;
        this.rH = str4;
        this.rA = action;
    }

    public void h(Object obj) {
        this.mLock = obj;
    }

    public void fz() {
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

    public Action fA() {
        return this.rA;
    }

    public boolean x(byte[] bArr) {
        return true;
    }

    public byte[] fB() {
        return null;
    }

    public boolean isSuccess() {
        return this.rB;
    }

    public void setSuccess(boolean z) {
        this.rB = z;
    }

    public void o(boolean z) {
        this.rz = z;
    }

    public String fC() {
        if (this.rz && this.mName != null) {
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

    public String fD() {
        if (this.rz && this.rH != null) {
            int hashCode = this.rH.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.rG == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.rG) + "/" + i;
        }
        return this.rG;
    }

    public OperateType fE() {
        return this.ry;
    }

    public void a(OperateType operateType) {
        this.ry = operateType;
    }

    public void l(boolean z) {
    }

    public boolean fF() {
        return this.rC;
    }

    public void p(boolean z) {
        this.rC = z;
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

    public File fG() {
        return this.rD;
    }

    public void e(File file) {
        this.rD = file;
    }

    public boolean fH() {
        return this.rE;
    }

    public void q(boolean z) {
        this.rE = z;
    }

    public boolean fs() {
        return com.baidu.adp.lib.Disk.d.fr().b(this);
    }

    public int fI() {
        return this.rF;
    }

    public void U(int i) {
        this.rF = i;
    }

    public String fJ() {
        return this.rG;
    }

    public String fK() {
        return this.rH;
    }

    public e.a fL() {
        return this.rI;
    }
}
