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
    private e.a rA;
    private OperateType rq;
    protected boolean rr;
    protected Action rs;
    private volatile boolean rt;
    private boolean ru;
    private File rv;
    private boolean rw;
    private int rx;
    private String ry;
    private String rz;

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

        /* JADX DEBUG: Replace access to removed values field (rB) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (rC) with 'values()' method */
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
        this.rq = OperateType.MUST_SUCCESS;
        this.rr = false;
        this.rs = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rt = false;
        this.ru = true;
        this.mOutputStream = null;
        this.rv = null;
        this.rw = true;
        this.rx = 0;
        this.ry = null;
        this.rz = null;
        this.rA = null;
        this.mPath = str;
        this.mName = str2;
        this.rs = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.rq = OperateType.MUST_SUCCESS;
        this.rr = false;
        this.rs = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rt = false;
        this.ru = true;
        this.mOutputStream = null;
        this.rv = null;
        this.rw = true;
        this.rx = 0;
        this.ry = null;
        this.rz = null;
        this.rA = null;
        this.mPath = str;
        this.mName = str2;
        this.ry = str3;
        this.rz = str4;
        this.rs = action;
    }

    public void h(Object obj) {
        this.mLock = obj;
    }

    public void fu() {
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

    public Action fv() {
        return this.rs;
    }

    public boolean x(byte[] bArr) {
        return true;
    }

    public byte[] fw() {
        return null;
    }

    public boolean isSuccess() {
        return this.rt;
    }

    public void setSuccess(boolean z) {
        this.rt = z;
    }

    public void o(boolean z) {
        this.rr = z;
    }

    public String fx() {
        if (this.rr && this.mName != null) {
            int abs = (Math.abs(this.mName.hashCode()) % 100) + 1;
            if (this.mPath == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.mPath) + "/" + abs;
        }
        return this.mPath;
    }

    public String fy() {
        if (this.rr && this.rz != null) {
            int abs = (Math.abs(this.rz.hashCode()) % 100) + 1;
            if (this.ry == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.ry) + "/" + abs;
        }
        return this.ry;
    }

    public OperateType fz() {
        return this.rq;
    }

    public void a(OperateType operateType) {
        this.rq = operateType;
    }

    public void l(boolean z) {
    }

    public boolean fA() {
        return this.ru;
    }

    public void p(boolean z) {
        this.ru = z;
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

    public File fB() {
        return this.rv;
    }

    public void e(File file) {
        this.rv = file;
    }

    public boolean fC() {
        return this.rw;
    }

    public void q(boolean z) {
        this.rw = z;
    }

    public boolean fn() {
        return com.baidu.adp.lib.Disk.d.fm().b(this);
    }

    public int fD() {
        return this.rx;
    }

    public void I(int i) {
        this.rx = i;
    }

    public String fE() {
        return this.ry;
    }

    public String fF() {
        return this.rz;
    }

    public e.a fG() {
        return this.rA;
    }
}
