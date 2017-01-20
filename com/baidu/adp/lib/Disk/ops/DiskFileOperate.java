package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private OperateType ki;
    protected boolean kj;
    protected Action kk;
    protected volatile byte[] kl;
    private volatile boolean km;
    private boolean kn;
    private File ko;
    private boolean kp;
    private int kq;
    private String kr;
    private String ks;
    private e.a kt;
    protected volatile Object mLock;
    protected String mName;
    private OutputStream mOutputStream;
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

        /* JADX DEBUG: Replace access to removed values field (ku) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (kv) with 'values()' method */
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
        this.ki = OperateType.MUST_SUCCESS;
        this.kj = false;
        this.kk = Action.READ;
        this.kl = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.km = false;
        this.kn = true;
        this.mOutputStream = null;
        this.ko = null;
        this.kp = true;
        this.kq = 0;
        this.kr = null;
        this.ks = null;
        this.kt = null;
        this.mPath = str;
        this.mName = str2;
        this.kk = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.ki = OperateType.MUST_SUCCESS;
        this.kj = false;
        this.kk = Action.READ;
        this.kl = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.km = false;
        this.kn = true;
        this.mOutputStream = null;
        this.ko = null;
        this.kp = true;
        this.kq = 0;
        this.kr = null;
        this.ks = null;
        this.kt = null;
        this.mPath = str;
        this.mName = str2;
        this.kr = str3;
        this.ks = str4;
        this.kk = action;
    }

    public void k(Object obj) {
        this.mLock = obj;
    }

    public void cH() {
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
        return this.kl;
    }

    public void setData(byte[] bArr) {
        this.kl = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action cI() {
        return this.kk;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] cJ() {
        return null;
    }

    public boolean isSuccess() {
        return this.km;
    }

    public void setSuccess(boolean z) {
        this.km = z;
    }

    public void r(boolean z) {
        this.kj = z;
    }

    public String cK() {
        if (this.kj && this.mName != null) {
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

    public String cL() {
        if (this.kj && this.ks != null) {
            int hashCode = this.ks.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.kr == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.kr) + "/" + i;
        }
        return this.kr;
    }

    public OperateType cM() {
        return this.ki;
    }

    public void a(OperateType operateType) {
        this.ki = operateType;
    }

    public void o(boolean z) {
    }

    public boolean cN() {
        return this.kn;
    }

    public void s(boolean z) {
        this.kn = z;
    }

    protected void finalize() throws Throwable {
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
                com.baidu.adp.lib.g.a.d(this.mOutputStream);
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

    public File cO() {
        return this.ko;
    }

    public void e(File file) {
        this.ko = file;
    }

    public boolean cP() {
        return this.kp;
    }

    public void t(boolean z) {
        this.kp = z;
    }

    public boolean cA() {
        return com.baidu.adp.lib.Disk.d.cz().b(this);
    }

    public int cQ() {
        return this.kq;
    }

    public void Y(int i) {
        this.kq = i;
    }

    public String cR() {
        return this.kr;
    }

    public String cS() {
        return this.ks;
    }

    public e.a cT() {
        return this.kt;
    }
}
