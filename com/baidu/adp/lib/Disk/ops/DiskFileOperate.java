package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private File hA;
    private boolean hB;
    private int hC;
    private String hD;
    private String hE;
    private e.a hF;
    private OperateType hu;
    protected boolean hv;
    protected Action hw;
    protected volatile byte[] hx;
    private volatile boolean hy;
    private boolean hz;
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

        /* JADX DEBUG: Replace access to removed values field (hG) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (hH) with 'values()' method */
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
        this.hu = OperateType.MUST_SUCCESS;
        this.hv = false;
        this.hw = Action.READ;
        this.hx = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.hy = false;
        this.hz = true;
        this.mOutputStream = null;
        this.hA = null;
        this.hB = true;
        this.hC = 0;
        this.hD = null;
        this.hE = null;
        this.hF = null;
        this.mPath = str;
        this.mName = str2;
        this.hw = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.hu = OperateType.MUST_SUCCESS;
        this.hv = false;
        this.hw = Action.READ;
        this.hx = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.hy = false;
        this.hz = true;
        this.mOutputStream = null;
        this.hA = null;
        this.hB = true;
        this.hC = 0;
        this.hD = null;
        this.hE = null;
        this.hF = null;
        this.mPath = str;
        this.mName = str2;
        this.hD = str3;
        this.hE = str4;
        this.hw = action;
    }

    public void h(Object obj) {
        this.mLock = obj;
    }

    public void bO() {
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
        return this.hx;
    }

    public void setData(byte[] bArr) {
        this.hx = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action bP() {
        return this.hw;
    }

    public boolean h(byte[] bArr) {
        return true;
    }

    public byte[] bQ() {
        return null;
    }

    public boolean isSuccess() {
        return this.hy;
    }

    public void setSuccess(boolean z) {
        this.hy = z;
    }

    public void n(boolean z) {
        this.hv = z;
    }

    public String bR() {
        if (this.hv && this.mName != null) {
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

    public String bS() {
        if (this.hv && this.hE != null) {
            int hashCode = this.hE.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.hD == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.hD) + "/" + i;
        }
        return this.hD;
    }

    public OperateType bT() {
        return this.hu;
    }

    public void a(OperateType operateType) {
        this.hu = operateType;
    }

    public void k(boolean z) {
    }

    public boolean bU() {
        return this.hz;
    }

    public void o(boolean z) {
        this.hz = z;
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
                com.baidu.adp.lib.h.a.a(this.mOutputStream);
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

    public File bV() {
        return this.hA;
    }

    public void d(File file) {
        this.hA = file;
    }

    public boolean bW() {
        return this.hB;
    }

    public void p(boolean z) {
        this.hB = z;
    }

    public boolean bH() {
        return com.baidu.adp.lib.Disk.d.bG().b(this);
    }

    public int bX() {
        return this.hC;
    }

    public void H(int i) {
        this.hC = i;
    }

    public String bY() {
        return this.hD;
    }

    public String bZ() {
        return this.hE;
    }

    public e.a ca() {
        return this.hF;
    }
}
