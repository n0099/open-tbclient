package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    protected boolean afA;
    protected Action afB;
    private volatile boolean afC;
    private boolean afD;
    private File afE;
    private boolean afF;
    private boolean afG;
    private int afH;
    private String afI;
    private String afJ;
    private e.a afK;
    private OperateType afz;
    protected volatile byte[] mData;
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
        CUSTOM
    }

    /* loaded from: classes.dex */
    public enum OperateType {
        MUST_SUCCESS,
        TRY_SUCCESS
    }

    public DiskFileOperate(String str, String str2, Action action) {
        this.afz = OperateType.MUST_SUCCESS;
        this.afA = false;
        this.afB = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.afC = false;
        this.afD = true;
        this.mOutputStream = null;
        this.afE = null;
        this.afF = true;
        this.afG = false;
        this.afH = 0;
        this.afI = null;
        this.afJ = null;
        this.afK = null;
        this.mPath = str;
        this.mName = str2;
        this.afB = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.afz = OperateType.MUST_SUCCESS;
        this.afA = false;
        this.afB = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.afC = false;
        this.afD = true;
        this.mOutputStream = null;
        this.afE = null;
        this.afF = true;
        this.afG = false;
        this.afH = 0;
        this.afI = null;
        this.afJ = null;
        this.afK = null;
        this.mPath = str;
        this.mName = str2;
        this.afI = str3;
        this.afJ = str4;
        this.afB = action;
    }

    public void ao(Object obj) {
        this.mLock = obj;
    }

    public void ls() {
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

    public Action lt() {
        return this.afB;
    }

    public boolean h(byte[] bArr) {
        return true;
    }

    public byte[] lu() {
        return null;
    }

    public boolean isSuccess() {
        return this.afC;
    }

    public void setSuccess(boolean z) {
        this.afC = z;
    }

    public void ab(boolean z) {
        this.afA = z;
    }

    public String lv() {
        if (this.afA && this.mName != null) {
            int hashCode = this.mName.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.mPath == null) {
                return String.valueOf(i);
            }
            return this.mPath + "/" + i;
        }
        return this.mPath;
    }

    public String lw() {
        if (this.afA && this.afJ != null) {
            int hashCode = this.afJ.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.afI == null) {
                return String.valueOf(i);
            }
            return this.afI + "/" + i;
        }
        return this.afI;
    }

    public OperateType lx() {
        return this.afz;
    }

    public void a(OperateType operateType) {
        this.afz = operateType;
    }

    public void Y(boolean z) {
    }

    public boolean ly() {
        return this.afD;
    }

    public void ac(boolean z) {
        this.afD = z;
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

    public File lz() {
        return this.afE;
    }

    public void g(File file) {
        this.afE = file;
    }

    public boolean lA() {
        return this.afF;
    }

    public void ad(boolean z) {
        this.afF = z;
    }

    public void ae(boolean z) {
        this.afG = z;
    }

    public boolean lB() {
        return this.afG;
    }

    public boolean lm() {
        return com.baidu.adp.lib.Disk.d.ll().b(this);
    }

    public int lC() {
        return this.afH;
    }

    public void cP(int i) {
        this.afH = i;
    }

    public String lD() {
        return this.afI;
    }

    public String lE() {
        return this.afJ;
    }

    public e.a lF() {
        return this.afK;
    }
}
