package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private OperateType afF;
    protected boolean afG;
    protected Action afH;
    private volatile boolean afI;
    private boolean afJ;
    private File afK;
    private boolean afL;
    private int afM;
    private String afN;
    private String afO;
    private e.a afP;
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
        this.afF = OperateType.MUST_SUCCESS;
        this.afG = false;
        this.afH = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.afI = false;
        this.afJ = true;
        this.mOutputStream = null;
        this.afK = null;
        this.afL = true;
        this.afM = 0;
        this.afN = null;
        this.afO = null;
        this.afP = null;
        this.mPath = str;
        this.mName = str2;
        this.afH = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.afF = OperateType.MUST_SUCCESS;
        this.afG = false;
        this.afH = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.afI = false;
        this.afJ = true;
        this.mOutputStream = null;
        this.afK = null;
        this.afL = true;
        this.afM = 0;
        this.afN = null;
        this.afO = null;
        this.afP = null;
        this.mPath = str;
        this.mName = str2;
        this.afN = str3;
        this.afO = str4;
        this.afH = action;
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
        return this.afH;
    }

    public boolean h(byte[] bArr) {
        return true;
    }

    public byte[] lu() {
        return null;
    }

    public boolean isSuccess() {
        return this.afI;
    }

    public void setSuccess(boolean z) {
        this.afI = z;
    }

    public void Z(boolean z) {
        this.afG = z;
    }

    public String lv() {
        if (this.afG && this.mName != null) {
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
        if (this.afG && this.afO != null) {
            int hashCode = this.afO.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.afN == null) {
                return String.valueOf(i);
            }
            return this.afN + "/" + i;
        }
        return this.afN;
    }

    public OperateType lx() {
        return this.afF;
    }

    public void a(OperateType operateType) {
        this.afF = operateType;
    }

    public void W(boolean z) {
    }

    public boolean ly() {
        return this.afJ;
    }

    public void aa(boolean z) {
        this.afJ = z;
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
        return this.afK;
    }

    public void f(File file) {
        this.afK = file;
    }

    public boolean lA() {
        return this.afL;
    }

    public void ab(boolean z) {
        this.afL = z;
    }

    public boolean lm() {
        return com.baidu.adp.lib.Disk.d.ll().b(this);
    }

    public int lB() {
        return this.afM;
    }

    public void cP(int i) {
        this.afM = i;
    }

    public String lC() {
        return this.afN;
    }

    public String lD() {
        return this.afO;
    }

    public e.a lE() {
        return this.afP;
    }
}
