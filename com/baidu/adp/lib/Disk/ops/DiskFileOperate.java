package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private OperateType hV;
    protected boolean hW;
    protected Action hX;
    protected volatile byte[] hY;
    private volatile boolean hZ;
    private boolean ia;
    private File ib;
    private boolean ic;
    private int ie;

    /* renamed from: if  reason: not valid java name */
    private String f0if;
    private String ig;
    private e.a ih;
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

        /* JADX DEBUG: Replace access to removed values field (ii) with 'values()' method */
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

        /* JADX DEBUG: Replace access to removed values field (ij) with 'values()' method */
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
        this.hV = OperateType.MUST_SUCCESS;
        this.hW = false;
        this.hX = Action.READ;
        this.hY = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.hZ = false;
        this.ia = true;
        this.mOutputStream = null;
        this.ib = null;
        this.ic = true;
        this.ie = 0;
        this.f0if = null;
        this.ig = null;
        this.ih = null;
        this.mPath = str;
        this.mName = str2;
        this.hX = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.hV = OperateType.MUST_SUCCESS;
        this.hW = false;
        this.hX = Action.READ;
        this.hY = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.hZ = false;
        this.ia = true;
        this.mOutputStream = null;
        this.ib = null;
        this.ic = true;
        this.ie = 0;
        this.f0if = null;
        this.ig = null;
        this.ih = null;
        this.mPath = str;
        this.mName = str2;
        this.f0if = str3;
        this.ig = str4;
        this.hX = action;
    }

    public void k(Object obj) {
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
        return this.hY;
    }

    public void setData(byte[] bArr) {
        this.hY = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action bP() {
        return this.hX;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] bQ() {
        return null;
    }

    public boolean isSuccess() {
        return this.hZ;
    }

    public void setSuccess(boolean z) {
        this.hZ = z;
    }

    public void p(boolean z) {
        this.hW = z;
    }

    public String bR() {
        if (this.hW && this.mName != null) {
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
        if (this.hW && this.ig != null) {
            int hashCode = this.ig.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.f0if == null) {
                return String.valueOf(i);
            }
            return String.valueOf(this.f0if) + "/" + i;
        }
        return this.f0if;
    }

    public OperateType bT() {
        return this.hV;
    }

    public void a(OperateType operateType) {
        this.hV = operateType;
    }

    public void m(boolean z) {
    }

    public boolean bU() {
        return this.ia;
    }

    public void q(boolean z) {
        this.ia = z;
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

    public File bV() {
        return this.ib;
    }

    public void e(File file) {
        this.ib = file;
    }

    public boolean bW() {
        return this.ic;
    }

    public void r(boolean z) {
        this.ic = z;
    }

    public boolean bH() {
        return com.baidu.adp.lib.Disk.d.bG().b(this);
    }

    public int bX() {
        return this.ie;
    }

    public void K(int i) {
        this.ie = i;
    }

    public String bY() {
        return this.f0if;
    }

    public String bZ() {
        return this.ig;
    }

    public e.a ca() {
        return this.ih;
    }
}
