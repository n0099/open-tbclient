package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    protected volatile Object mLock;
    protected String mName;
    private OutputStream mOutputStream;
    protected String mPath;
    private OperateType sd;
    protected boolean se;
    protected Action sf;
    protected volatile byte[] sg;
    private volatile boolean sh;
    private boolean si;
    private File sj;
    private boolean sk;
    private int sl;
    private String sm;
    private String so;
    private e.a sq;

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

        /* JADX DEBUG: Replace access to removed values field (sr) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (ss) with 'values()' method */
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
        this.sd = OperateType.MUST_SUCCESS;
        this.se = false;
        this.sf = Action.READ;
        this.sg = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.sh = false;
        this.si = true;
        this.mOutputStream = null;
        this.sj = null;
        this.sk = true;
        this.sl = 0;
        this.sm = null;
        this.so = null;
        this.sq = null;
        this.mPath = str;
        this.mName = str2;
        this.sf = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.sd = OperateType.MUST_SUCCESS;
        this.se = false;
        this.sf = Action.READ;
        this.sg = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.sh = false;
        this.si = true;
        this.mOutputStream = null;
        this.sj = null;
        this.sk = true;
        this.sl = 0;
        this.sm = null;
        this.so = null;
        this.sq = null;
        this.mPath = str;
        this.mName = str2;
        this.sm = str3;
        this.so = str4;
        this.sf = action;
    }

    public void k(Object obj) {
        this.mLock = obj;
    }

    public void dQ() {
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
        return this.sg;
    }

    public void setData(byte[] bArr) {
        this.sg = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action dR() {
        return this.sf;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] dS() {
        return null;
    }

    public boolean isSuccess() {
        return this.sh;
    }

    public void setSuccess(boolean z) {
        this.sh = z;
    }

    public void s(boolean z) {
        this.se = z;
    }

    public String dT() {
        if (this.se && this.mName != null) {
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

    public String dU() {
        if (this.se && this.so != null) {
            int hashCode = this.so.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.sm == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.sm) + "/" + i;
        }
        return this.sm;
    }

    public OperateType dV() {
        return this.sd;
    }

    public void a(OperateType operateType) {
        this.sd = operateType;
    }

    public void p(boolean z) {
    }

    public boolean dW() {
        return this.si;
    }

    public void t(boolean z) {
        this.si = z;
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

    public File dX() {
        return this.sj;
    }

    public void e(File file) {
        this.sj = file;
    }

    public boolean dY() {
        return this.sk;
    }

    public void u(boolean z) {
        this.sk = z;
    }

    public boolean dJ() {
        return com.baidu.adp.lib.Disk.d.dI().b(this);
    }

    public int dZ() {
        return this.sl;
    }

    public void Y(int i) {
        this.sl = i;
    }

    public String ea() {
        return this.sm;
    }

    public String eb() {
        return this.so;
    }

    public e.a ec() {
        return this.sq;
    }
}
