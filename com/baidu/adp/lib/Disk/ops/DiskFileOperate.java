package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.f;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private OperateType fP;
    protected boolean fQ;
    protected Action fR;
    private volatile boolean fS;
    private boolean fT;
    private OutputStream fU;
    private File fV;
    private boolean fW;
    private int fX;
    private String fY;
    private String fZ;
    private f ga;
    protected volatile byte[] mData;
    protected volatile Object mLock;
    protected String mName;
    protected String mPath;

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

        /* JADX DEBUG: Replace access to removed values field (gb) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (gc) with 'values()' method */
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
        this.fP = OperateType.MUST_SUCCESS;
        this.fQ = false;
        this.fR = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.fS = false;
        this.fT = true;
        this.fU = null;
        this.fV = null;
        this.fW = true;
        this.fX = 0;
        this.fY = null;
        this.fZ = null;
        this.ga = null;
        this.mPath = str;
        this.mName = str2;
        this.fR = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.fP = OperateType.MUST_SUCCESS;
        this.fQ = false;
        this.fR = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.fS = false;
        this.fT = true;
        this.fU = null;
        this.fV = null;
        this.fW = true;
        this.fX = 0;
        this.fY = null;
        this.fZ = null;
        this.ga = null;
        this.mPath = str;
        this.mName = str2;
        this.fY = str3;
        this.fZ = str4;
        this.fR = action;
    }

    public void g(Object obj) {
        this.mLock = obj;
    }

    public void bV() {
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

    public Action bW() {
        return this.fR;
    }

    public boolean j(byte[] bArr) {
        return true;
    }

    public byte[] bX() {
        return null;
    }

    public boolean isSuccess() {
        return this.fS;
    }

    public void setSuccess(boolean z) {
        this.fS = z;
    }

    public void o(boolean z) {
        this.fQ = z;
    }

    public String bY() {
        if (this.fQ && this.mName != null) {
            int abs = (Math.abs(this.mName.hashCode()) % 100) + 1;
            if (this.mPath == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.mPath) + "/" + abs;
        }
        return this.mPath;
    }

    public String bZ() {
        if (this.fQ && this.fZ != null) {
            int abs = (Math.abs(this.fZ.hashCode()) % 100) + 1;
            if (this.fY == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.fY) + "/" + abs;
        }
        return this.fY;
    }

    public OperateType ca() {
        return this.fP;
    }

    public void a(OperateType operateType) {
        this.fP = operateType;
    }

    public void l(boolean z) {
    }

    public boolean cb() {
        return this.fT;
    }

    public void p(boolean z) {
        this.fT = z;
    }

    protected void finalize() {
        super.finalize();
        release();
    }

    public OutputStream getOutputStream() {
        OutputStream outputStream;
        synchronized (this) {
            outputStream = this.fU;
        }
        return outputStream;
    }

    public void release() {
        synchronized (this) {
            if (this.fU != null) {
                com.baidu.adp.lib.g.a.b(this.fU);
                this.fU = null;
            }
        }
    }

    public void setOutputStream(OutputStream outputStream) {
        synchronized (this) {
            if (outputStream != this.fU) {
                release();
                this.fU = outputStream;
            }
        }
    }

    public File cc() {
        return this.fV;
    }

    public void e(File file) {
        this.fV = file;
    }

    public boolean cd() {
        return this.fW;
    }

    public void q(boolean z) {
        this.fW = z;
    }

    public boolean bO() {
        return com.baidu.adp.lib.Disk.d.bM().b(this);
    }

    public boolean ce() {
        return com.baidu.adp.lib.Disk.d.bM().c(this);
    }

    public int cf() {
        return this.fX;
    }

    public void E(int i) {
        this.fX = i;
    }

    public String cg() {
        return this.fY;
    }

    public String ch() {
        return this.fZ;
    }

    public f ci() {
        return this.ga;
    }

    public void a(f fVar) {
        this.ga = fVar;
    }
}
