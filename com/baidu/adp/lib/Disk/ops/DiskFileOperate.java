package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.f;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private OperateType fN;
    protected boolean fO;
    protected Action fP;
    private volatile boolean fQ;
    private boolean fR;
    private OutputStream fS;
    private File fT;
    private boolean fU;
    private int fV;
    private String fW;
    private String fX;
    private f fY;
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

        /* JADX DEBUG: Replace access to removed values field (fZ) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (ga) with 'values()' method */
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
        this.fN = OperateType.MUST_SUCCESS;
        this.fO = false;
        this.fP = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.fQ = false;
        this.fR = true;
        this.fS = null;
        this.fT = null;
        this.fU = true;
        this.fV = 0;
        this.fW = null;
        this.fX = null;
        this.fY = null;
        this.mPath = str;
        this.mName = str2;
        this.fP = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.fN = OperateType.MUST_SUCCESS;
        this.fO = false;
        this.fP = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.fQ = false;
        this.fR = true;
        this.fS = null;
        this.fT = null;
        this.fU = true;
        this.fV = 0;
        this.fW = null;
        this.fX = null;
        this.fY = null;
        this.mPath = str;
        this.mName = str2;
        this.fW = str3;
        this.fX = str4;
        this.fP = action;
    }

    public void g(Object obj) {
        this.mLock = obj;
    }

    public void bX() {
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

    public Action bY() {
        return this.fP;
    }

    public boolean j(byte[] bArr) {
        return true;
    }

    public byte[] bZ() {
        return null;
    }

    public boolean isSuccess() {
        return this.fQ;
    }

    public void setSuccess(boolean z) {
        this.fQ = z;
    }

    public void o(boolean z) {
        this.fO = z;
    }

    public String ca() {
        if (this.fO && this.mName != null) {
            int abs = (Math.abs(this.mName.hashCode()) % 100) + 1;
            if (this.mPath == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.mPath) + "/" + abs;
        }
        return this.mPath;
    }

    public String cb() {
        if (this.fO && this.fX != null) {
            int abs = (Math.abs(this.fX.hashCode()) % 100) + 1;
            if (this.fW == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.fW) + "/" + abs;
        }
        return this.fW;
    }

    public OperateType cc() {
        return this.fN;
    }

    public void a(OperateType operateType) {
        this.fN = operateType;
    }

    public void l(boolean z) {
    }

    public boolean cd() {
        return this.fR;
    }

    public void p(boolean z) {
        this.fR = z;
    }

    protected void finalize() {
        super.finalize();
        release();
    }

    public OutputStream getOutputStream() {
        OutputStream outputStream;
        synchronized (this) {
            outputStream = this.fS;
        }
        return outputStream;
    }

    public void release() {
        synchronized (this) {
            if (this.fS != null) {
                com.baidu.adp.lib.g.a.b(this.fS);
                this.fS = null;
            }
        }
    }

    public void setOutputStream(OutputStream outputStream) {
        synchronized (this) {
            if (outputStream != this.fS) {
                release();
                this.fS = outputStream;
            }
        }
    }

    public File ce() {
        return this.fT;
    }

    public void e(File file) {
        this.fT = file;
    }

    public boolean cf() {
        return this.fU;
    }

    public void q(boolean z) {
        this.fU = z;
    }

    public boolean bQ() {
        return com.baidu.adp.lib.Disk.d.bO().b(this);
    }

    public boolean cg() {
        return com.baidu.adp.lib.Disk.d.bO().c(this);
    }

    public int ch() {
        return this.fV;
    }

    public void z(int i) {
        this.fV = i;
    }

    public String ci() {
        return this.fW;
    }

    public String cj() {
        return this.fX;
    }

    public f ck() {
        return this.fY;
    }

    public void a(f fVar) {
        this.fY = fVar;
    }
}
