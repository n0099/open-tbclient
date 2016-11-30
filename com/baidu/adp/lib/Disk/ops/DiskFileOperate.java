package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private String kA;
    private String kB;
    private e.a kC;
    private OperateType kp;
    protected boolean kq;
    protected Action kr;
    protected volatile byte[] ks;
    private volatile boolean kt;
    private boolean ku;
    private File kv;
    private boolean kx;
    private int ky;
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

        /* JADX DEBUG: Replace access to removed values field (kD) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (kE) with 'values()' method */
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
        this.kp = OperateType.MUST_SUCCESS;
        this.kq = false;
        this.kr = Action.READ;
        this.ks = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.kt = false;
        this.ku = true;
        this.mOutputStream = null;
        this.kv = null;
        this.kx = true;
        this.ky = 0;
        this.kA = null;
        this.kB = null;
        this.kC = null;
        this.mPath = str;
        this.mName = str2;
        this.kr = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.kp = OperateType.MUST_SUCCESS;
        this.kq = false;
        this.kr = Action.READ;
        this.ks = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.kt = false;
        this.ku = true;
        this.mOutputStream = null;
        this.kv = null;
        this.kx = true;
        this.ky = 0;
        this.kA = null;
        this.kB = null;
        this.kC = null;
        this.mPath = str;
        this.mName = str2;
        this.kA = str3;
        this.kB = str4;
        this.kr = action;
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
        return this.ks;
    }

    public void setData(byte[] bArr) {
        this.ks = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action cK() {
        return this.kr;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] cL() {
        return null;
    }

    public boolean isSuccess() {
        return this.kt;
    }

    public void setSuccess(boolean z) {
        this.kt = z;
    }

    public void r(boolean z) {
        this.kq = z;
    }

    public String cM() {
        if (this.kq && this.mName != null) {
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
        if (this.kq && this.kB != null) {
            int hashCode = this.kB.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.kA == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.kA) + "/" + i;
        }
        return this.kA;
    }

    public OperateType cO() {
        return this.kp;
    }

    public void a(OperateType operateType) {
        this.kp = operateType;
    }

    public void o(boolean z) {
    }

    public boolean cP() {
        return this.ku;
    }

    public void s(boolean z) {
        this.ku = z;
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
        return this.kv;
    }

    public void e(File file) {
        this.kv = file;
    }

    public boolean cR() {
        return this.kx;
    }

    public void t(boolean z) {
        this.kx = z;
    }

    public boolean cC() {
        return com.baidu.adp.lib.Disk.d.cB().b(this);
    }

    public int cS() {
        return this.ky;
    }

    public void X(int i) {
        this.ky = i;
    }

    public String cT() {
        return this.kA;
    }

    public String cU() {
        return this.kB;
    }

    public e.a cV() {
        return this.kC;
    }
}
