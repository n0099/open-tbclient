package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private boolean hA;
    private int hB;
    private String hC;
    private String hD;
    private e.a hE;
    private OperateType ht;
    protected boolean hu;
    protected Action hv;
    protected volatile byte[] hw;
    private volatile boolean hx;
    private boolean hy;
    private File hz;
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

        /* JADX DEBUG: Replace access to removed values field (hF) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (hG) with 'values()' method */
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
        this.ht = OperateType.MUST_SUCCESS;
        this.hu = false;
        this.hv = Action.READ;
        this.hw = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.hx = false;
        this.hy = true;
        this.mOutputStream = null;
        this.hz = null;
        this.hA = true;
        this.hB = 0;
        this.hC = null;
        this.hD = null;
        this.hE = null;
        this.mPath = str;
        this.mName = str2;
        this.hv = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.ht = OperateType.MUST_SUCCESS;
        this.hu = false;
        this.hv = Action.READ;
        this.hw = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.hx = false;
        this.hy = true;
        this.mOutputStream = null;
        this.hz = null;
        this.hA = true;
        this.hB = 0;
        this.hC = null;
        this.hD = null;
        this.hE = null;
        this.mPath = str;
        this.mName = str2;
        this.hC = str3;
        this.hD = str4;
        this.hv = action;
    }

    public void h(Object obj) {
        this.mLock = obj;
    }

    public void bP() {
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
        return this.hw;
    }

    public void setData(byte[] bArr) {
        this.hw = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action bQ() {
        return this.hv;
    }

    public boolean h(byte[] bArr) {
        return true;
    }

    public byte[] bR() {
        return null;
    }

    public boolean isSuccess() {
        return this.hx;
    }

    public void setSuccess(boolean z) {
        this.hx = z;
    }

    public void n(boolean z) {
        this.hu = z;
    }

    public String bS() {
        if (this.hu && this.mName != null) {
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

    public String bT() {
        if (this.hu && this.hD != null) {
            int hashCode = this.hD.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.hC == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.hC) + "/" + i;
        }
        return this.hC;
    }

    public OperateType bU() {
        return this.ht;
    }

    public void a(OperateType operateType) {
        this.ht = operateType;
    }

    public void k(boolean z) {
    }

    public boolean bV() {
        return this.hy;
    }

    public void o(boolean z) {
        this.hy = z;
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

    public File bW() {
        return this.hz;
    }

    public void d(File file) {
        this.hz = file;
    }

    public boolean bX() {
        return this.hA;
    }

    public void p(boolean z) {
        this.hA = z;
    }

    public boolean bI() {
        return com.baidu.adp.lib.Disk.d.bH().b(this);
    }

    public int bY() {
        return this.hB;
    }

    public void H(int i) {
        this.hB = i;
    }

    public String bZ() {
        return this.hC;
    }

    public String ca() {
        return this.hD;
    }

    public e.a cb() {
        return this.hE;
    }
}
