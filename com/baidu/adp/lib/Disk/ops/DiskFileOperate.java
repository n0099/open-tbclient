package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.f;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    protected volatile byte[] mData;
    protected volatile Object mLock;
    protected String mName;
    protected String mPath;
    private OperateType ri;
    protected boolean rj;
    protected Action rk;
    private volatile boolean rl;
    private boolean rm;
    private OutputStream ro;
    private File rp;
    private boolean rq;
    private int rr;
    private String rs;
    private String rt;
    private f ru;

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

        /* JADX DEBUG: Replace access to removed values field (rv) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (rw) with 'values()' method */
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
        this.ri = OperateType.MUST_SUCCESS;
        this.rj = false;
        this.rk = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rl = false;
        this.rm = true;
        this.ro = null;
        this.rp = null;
        this.rq = true;
        this.rr = 0;
        this.rs = null;
        this.rt = null;
        this.ru = null;
        this.mPath = str;
        this.mName = str2;
        this.rk = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.ri = OperateType.MUST_SUCCESS;
        this.rj = false;
        this.rk = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.rl = false;
        this.rm = true;
        this.ro = null;
        this.rp = null;
        this.rq = true;
        this.rr = 0;
        this.rs = null;
        this.rt = null;
        this.ru = null;
        this.mPath = str;
        this.mName = str2;
        this.rs = str3;
        this.rt = str4;
        this.rk = action;
    }

    public void g(Object obj) {
        this.mLock = obj;
    }

    public void ft() {
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

    public Action fu() {
        return this.rk;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] fv() {
        return null;
    }

    public boolean isSuccess() {
        return this.rl;
    }

    public void setSuccess(boolean z) {
        this.rl = z;
    }

    public void o(boolean z) {
        this.rj = z;
    }

    public String fw() {
        if (this.rj && this.mName != null) {
            int abs = (Math.abs(this.mName.hashCode()) % 100) + 1;
            if (this.mPath == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.mPath) + "/" + abs;
        }
        return this.mPath;
    }

    public String fx() {
        if (this.rj && this.rt != null) {
            int abs = (Math.abs(this.rt.hashCode()) % 100) + 1;
            if (this.rs == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.rs) + "/" + abs;
        }
        return this.rs;
    }

    public OperateType fy() {
        return this.ri;
    }

    public void a(OperateType operateType) {
        this.ri = operateType;
    }

    public void l(boolean z) {
    }

    public boolean fz() {
        return this.rm;
    }

    public void p(boolean z) {
        this.rm = z;
    }

    protected void finalize() {
        super.finalize();
        release();
    }

    public OutputStream getOutputStream() {
        OutputStream outputStream;
        synchronized (this) {
            outputStream = this.ro;
        }
        return outputStream;
    }

    public void release() {
        synchronized (this) {
            if (this.ro != null) {
                com.baidu.adp.lib.g.a.b(this.ro);
                this.ro = null;
            }
        }
    }

    public void setOutputStream(OutputStream outputStream) {
        synchronized (this) {
            if (outputStream != this.ro) {
                release();
                this.ro = outputStream;
            }
        }
    }

    public File fA() {
        return this.rp;
    }

    public void e(File file) {
        this.rp = file;
    }

    public boolean fB() {
        return this.rq;
    }

    public void q(boolean z) {
        this.rq = z;
    }

    public boolean fm() {
        return com.baidu.adp.lib.Disk.d.fk().b(this);
    }

    public boolean fC() {
        return com.baidu.adp.lib.Disk.d.fk().c(this);
    }

    public int fD() {
        return this.rr;
    }

    public void F(int i) {
        this.rr = i;
    }

    public String fE() {
        return this.rs;
    }

    public String fF() {
        return this.rt;
    }

    public f fG() {
        return this.ru;
    }

    public void a(f fVar) {
        this.ru = fVar;
    }
}
