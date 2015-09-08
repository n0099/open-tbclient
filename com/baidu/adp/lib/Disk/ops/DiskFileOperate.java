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
    private OperateType ro;
    protected boolean rp;
    protected Action rq;
    private volatile boolean rr;
    private boolean rs;
    private File rt;
    private boolean ru;
    private int rv;
    private String rw;
    private String rx;
    private e.a ry;

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

        /* JADX DEBUG: Replace access to removed values field (rz) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (rA) with 'values()' method */
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
        this.ro = OperateType.MUST_SUCCESS;
        this.rp = false;
        this.rq = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rr = false;
        this.rs = true;
        this.mOutputStream = null;
        this.rt = null;
        this.ru = true;
        this.rv = 0;
        this.rw = null;
        this.rx = null;
        this.ry = null;
        this.mPath = str;
        this.mName = str2;
        this.rq = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.ro = OperateType.MUST_SUCCESS;
        this.rp = false;
        this.rq = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rr = false;
        this.rs = true;
        this.mOutputStream = null;
        this.rt = null;
        this.ru = true;
        this.rv = 0;
        this.rw = null;
        this.rx = null;
        this.ry = null;
        this.mPath = str;
        this.mName = str2;
        this.rw = str3;
        this.rx = str4;
        this.rq = action;
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
        return this.rq;
    }

    public boolean x(byte[] bArr) {
        return true;
    }

    public byte[] ft() {
        return null;
    }

    public boolean isSuccess() {
        return this.rr;
    }

    public void setSuccess(boolean z) {
        this.rr = z;
    }

    public void o(boolean z) {
        this.rp = z;
    }

    public String fu() {
        if (this.rp && this.mName != null) {
            int abs = (Math.abs(this.mName.hashCode()) % 100) + 1;
            if (this.mPath == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.mPath) + "/" + abs;
        }
        return this.mPath;
    }

    public String fv() {
        if (this.rp && this.rx != null) {
            int abs = (Math.abs(this.rx.hashCode()) % 100) + 1;
            if (this.rw == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.rw) + "/" + abs;
        }
        return this.rw;
    }

    public OperateType fw() {
        return this.ro;
    }

    public void a(OperateType operateType) {
        this.ro = operateType;
    }

    public void l(boolean z) {
    }

    public boolean fx() {
        return this.rs;
    }

    public void p(boolean z) {
        this.rs = z;
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

    public File fy() {
        return this.rt;
    }

    public void e(File file) {
        this.rt = file;
    }

    public boolean fz() {
        return this.ru;
    }

    public void q(boolean z) {
        this.ru = z;
    }

    public boolean fk() {
        return com.baidu.adp.lib.Disk.d.fj().b(this);
    }

    public int fA() {
        return this.rv;
    }

    public void I(int i) {
        this.rv = i;
    }

    public String fB() {
        return this.rw;
    }

    public String fC() {
        return this.rx;
    }

    public e.a fD() {
        return this.ry;
    }
}
