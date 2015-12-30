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
    private String rA;
    private e.a rB;
    private OperateType rr;
    protected boolean rs;
    protected Action rt;
    private volatile boolean ru;
    private boolean rv;
    private File rw;
    private boolean rx;
    private int ry;
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

        /* JADX DEBUG: Replace access to removed values field (rC) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (rD) with 'values()' method */
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
        this.rr = OperateType.MUST_SUCCESS;
        this.rs = false;
        this.rt = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.ru = false;
        this.rv = true;
        this.mOutputStream = null;
        this.rw = null;
        this.rx = true;
        this.ry = 0;
        this.rz = null;
        this.rA = null;
        this.rB = null;
        this.mPath = str;
        this.mName = str2;
        this.rt = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.rr = OperateType.MUST_SUCCESS;
        this.rs = false;
        this.rt = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.ru = false;
        this.rv = true;
        this.mOutputStream = null;
        this.rw = null;
        this.rx = true;
        this.ry = 0;
        this.rz = null;
        this.rA = null;
        this.rB = null;
        this.mPath = str;
        this.mName = str2;
        this.rz = str3;
        this.rA = str4;
        this.rt = action;
    }

    public void h(Object obj) {
        this.mLock = obj;
    }

    public void fr() {
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

    public Action fs() {
        return this.rt;
    }

    public boolean x(byte[] bArr) {
        return true;
    }

    public byte[] ft() {
        return null;
    }

    public boolean isSuccess() {
        return this.ru;
    }

    public void setSuccess(boolean z) {
        this.ru = z;
    }

    public void o(boolean z) {
        this.rs = z;
    }

    public String fu() {
        if (this.rs && this.mName != null) {
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

    public String fv() {
        if (this.rs && this.rA != null) {
            int hashCode = this.rA.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.rz == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.rz) + "/" + i;
        }
        return this.rz;
    }

    public OperateType fw() {
        return this.rr;
    }

    public void a(OperateType operateType) {
        this.rr = operateType;
    }

    public void l(boolean z) {
    }

    public boolean fx() {
        return this.rv;
    }

    public void p(boolean z) {
        this.rv = z;
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

    public File fy() {
        return this.rw;
    }

    public void e(File file) {
        this.rw = file;
    }

    public boolean fz() {
        return this.rx;
    }

    public void q(boolean z) {
        this.rx = z;
    }

    public boolean fk() {
        return com.baidu.adp.lib.Disk.d.fj().b(this);
    }

    public int fA() {
        return this.ry;
    }

    public void J(int i) {
        this.ry = i;
    }

    public String fB() {
        return this.rz;
    }

    public String fC() {
        return this.rA;
    }

    public e.a fD() {
        return this.rB;
    }
}
