package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private String kA;
    private e.a kB;
    private OperateType ko;
    protected boolean kp;
    protected Action kq;
    protected volatile byte[] kr;
    private volatile boolean ks;
    private boolean kt;
    private File ku;
    private boolean kv;
    private int kx;
    private String ky;
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

        /* JADX DEBUG: Replace access to removed values field (kC) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (kD) with 'values()' method */
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
        this.ko = OperateType.MUST_SUCCESS;
        this.kp = false;
        this.kq = Action.READ;
        this.kr = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.ks = false;
        this.kt = true;
        this.mOutputStream = null;
        this.ku = null;
        this.kv = true;
        this.kx = 0;
        this.ky = null;
        this.kA = null;
        this.kB = null;
        this.mPath = str;
        this.mName = str2;
        this.kq = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.ko = OperateType.MUST_SUCCESS;
        this.kp = false;
        this.kq = Action.READ;
        this.kr = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.ks = false;
        this.kt = true;
        this.mOutputStream = null;
        this.ku = null;
        this.kv = true;
        this.kx = 0;
        this.ky = null;
        this.kA = null;
        this.kB = null;
        this.mPath = str;
        this.mName = str2;
        this.ky = str3;
        this.kA = str4;
        this.kq = action;
    }

    public void k(Object obj) {
        this.mLock = obj;
    }

    public void cJ() {
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
        return this.kr;
    }

    public void setData(byte[] bArr) {
        this.kr = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action cK() {
        return this.kq;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] cL() {
        return null;
    }

    public boolean isSuccess() {
        return this.ks;
    }

    public void setSuccess(boolean z) {
        this.ks = z;
    }

    public void r(boolean z) {
        this.kp = z;
    }

    public String cM() {
        if (this.kp && this.mName != null) {
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

    public String cN() {
        if (this.kp && this.kA != null) {
            int hashCode = this.kA.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.ky == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.ky) + "/" + i;
        }
        return this.ky;
    }

    public OperateType cO() {
        return this.ko;
    }

    public void a(OperateType operateType) {
        this.ko = operateType;
    }

    public void o(boolean z) {
    }

    public boolean cP() {
        return this.kt;
    }

    public void s(boolean z) {
        this.kt = z;
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
                com.baidu.adp.lib.h.a.d(this.mOutputStream);
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

    public File cQ() {
        return this.ku;
    }

    public void e(File file) {
        this.ku = file;
    }

    public boolean cR() {
        return this.kv;
    }

    public void t(boolean z) {
        this.kv = z;
    }

    public boolean cC() {
        return com.baidu.adp.lib.Disk.d.cB().b(this);
    }

    public int cS() {
        return this.kx;
    }

    public void X(int i) {
        this.kx = i;
    }

    public String cT() {
        return this.ky;
    }

    public String cU() {
        return this.kA;
    }

    public e.a cV() {
        return this.kB;
    }
}
