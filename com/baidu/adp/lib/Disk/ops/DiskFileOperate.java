package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    protected volatile byte[] mData;
    protected volatile Object mLock;
    protected String mName;
    protected String mPath;
    private boolean rA;
    private int rB;
    private String rC;
    private String rD;
    private com.baidu.adp.lib.Disk.f rE;
    private OperateType rt;
    protected boolean ru;
    protected Action rv;
    private volatile boolean rw;
    private boolean rx;
    private OutputStream ry;
    private File rz;

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

        /* JADX DEBUG: Replace access to removed values field (rF) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (rG) with 'values()' method */
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
        this.rt = OperateType.MUST_SUCCESS;
        this.ru = false;
        this.rv = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rw = false;
        this.rx = true;
        this.ry = null;
        this.rz = null;
        this.rA = true;
        this.rB = 0;
        this.rC = null;
        this.rD = null;
        this.rE = null;
        this.mPath = str;
        this.mName = str2;
        this.rv = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.rt = OperateType.MUST_SUCCESS;
        this.ru = false;
        this.rv = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rw = false;
        this.rx = true;
        this.ry = null;
        this.rz = null;
        this.rA = true;
        this.rB = 0;
        this.rC = null;
        this.rD = null;
        this.rE = null;
        this.mPath = str;
        this.mName = str2;
        this.rC = str3;
        this.rD = str4;
        this.rv = action;
    }

    public void g(Object obj) {
        this.mLock = obj;
    }

    public void fy() {
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

    public Action fz() {
        return this.rv;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] fA() {
        return null;
    }

    public boolean isSuccess() {
        return this.rw;
    }

    public void setSuccess(boolean z) {
        this.rw = z;
    }

    public void o(boolean z) {
        this.ru = z;
    }

    public String fB() {
        if (this.ru && this.mName != null) {
            int abs = (Math.abs(this.mName.hashCode()) % 100) + 1;
            if (this.mPath == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.mPath) + "/" + abs;
        }
        return this.mPath;
    }

    public String fC() {
        if (this.ru && this.rD != null) {
            int abs = (Math.abs(this.rD.hashCode()) % 100) + 1;
            if (this.rC == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.rC) + "/" + abs;
        }
        return this.rC;
    }

    public OperateType fD() {
        return this.rt;
    }

    public void a(OperateType operateType) {
        this.rt = operateType;
    }

    public void l(boolean z) {
    }

    public boolean fE() {
        return this.rx;
    }

    public void p(boolean z) {
        this.rx = z;
    }

    protected void finalize() {
        super.finalize();
        release();
    }

    public OutputStream getOutputStream() {
        OutputStream outputStream;
        synchronized (this) {
            outputStream = this.ry;
        }
        return outputStream;
    }

    public void release() {
        synchronized (this) {
            if (this.ry != null) {
                com.baidu.adp.lib.g.a.b(this.ry);
                this.ry = null;
            }
        }
    }

    public void setOutputStream(OutputStream outputStream) {
        synchronized (this) {
            if (outputStream != this.ry) {
                release();
                this.ry = outputStream;
            }
        }
    }

    public File fF() {
        return this.rz;
    }

    public void e(File file) {
        this.rz = file;
    }

    public boolean fG() {
        return this.rA;
    }

    public void q(boolean z) {
        this.rA = z;
    }

    public boolean fr() {
        return com.baidu.adp.lib.Disk.d.fp().b(this);
    }

    public boolean fH() {
        return com.baidu.adp.lib.Disk.d.fp().c(this);
    }

    public int fI() {
        return this.rB;
    }

    public void G(int i) {
        this.rB = i;
    }

    public String fJ() {
        return this.rC;
    }

    public String fK() {
        return this.rD;
    }

    public com.baidu.adp.lib.Disk.f fL() {
        return this.rE;
    }

    public void a(com.baidu.adp.lib.Disk.f fVar) {
        this.rE = fVar;
    }
}
