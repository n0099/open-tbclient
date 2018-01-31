package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    private OperateType afH;
    protected boolean afI;
    protected Action afJ;
    private volatile boolean afK;
    private boolean afL;
    private File afM;
    private boolean afN;
    private boolean afO;
    private int afP;
    private String afQ;
    private String afR;
    private e.a afS;
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
        this.afH = OperateType.MUST_SUCCESS;
        this.afI = false;
        this.afJ = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.afK = false;
        this.afL = true;
        this.mOutputStream = null;
        this.afM = null;
        this.afN = true;
        this.afO = false;
        this.afP = 0;
        this.afQ = null;
        this.afR = null;
        this.afS = null;
        this.mPath = str;
        this.mName = str2;
        this.afJ = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.afH = OperateType.MUST_SUCCESS;
        this.afI = false;
        this.afJ = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.afK = false;
        this.afL = true;
        this.mOutputStream = null;
        this.afM = null;
        this.afN = true;
        this.afO = false;
        this.afP = 0;
        this.afQ = null;
        this.afR = null;
        this.afS = null;
        this.mPath = str;
        this.mName = str2;
        this.afQ = str3;
        this.afR = str4;
        this.afJ = action;
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
        return this.afJ;
    }

    public boolean h(byte[] bArr) {
        return true;
    }

    public byte[] lu() {
        return null;
    }

    public boolean isSuccess() {
        return this.afK;
    }

    public void setSuccess(boolean z) {
        this.afK = z;
    }

    public void Z(boolean z) {
        this.afI = z;
    }

    public String lv() {
        if (this.afI && this.mName != null) {
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
        if (this.afI && this.afR != null) {
            int hashCode = this.afR.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.afQ == null) {
                return String.valueOf(i);
            }
            return this.afQ + "/" + i;
        }
        return this.afQ;
    }

    public OperateType lx() {
        return this.afH;
    }

    public void a(OperateType operateType) {
        this.afH = operateType;
    }

    public void W(boolean z) {
    }

    public boolean ly() {
        return this.afL;
    }

    public void aa(boolean z) {
        this.afL = z;
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
        return this.afM;
    }

    public void f(File file) {
        this.afM = file;
    }

    public boolean lA() {
        return this.afN;
    }

    public void ab(boolean z) {
        this.afN = z;
    }

    public void ac(boolean z) {
        this.afO = z;
    }

    public boolean lB() {
        return this.afO;
    }

    public boolean lm() {
        return com.baidu.adp.lib.Disk.d.ll().b(this);
    }

    public int lC() {
        return this.afP;
    }

    public void cP(int i) {
        this.afP = i;
    }

    public String lD() {
        return this.afQ;
    }

    public String lE() {
        return this.afR;
    }

    public e.a lF() {
        return this.afS;
    }
}
