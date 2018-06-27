package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.Disk.e;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    protected volatile byte[] mData;
    protected volatile Object mLock;
    protected String mName;
    private OutputStream mOutputStream;
    protected String mPath;
    private OperateType wj;
    protected boolean wk;
    protected Action wl;
    private volatile boolean wn;
    private boolean wo;
    private File wp;
    private boolean wq;
    private boolean wr;
    private int ws;
    private String wt;
    private String wu;
    private e.a wv;

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
        this.wj = OperateType.MUST_SUCCESS;
        this.wk = false;
        this.wl = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.wn = false;
        this.wo = true;
        this.mOutputStream = null;
        this.wp = null;
        this.wq = true;
        this.wr = false;
        this.ws = 0;
        this.wt = null;
        this.wu = null;
        this.wv = null;
        this.mPath = str;
        this.mName = str2;
        this.wl = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.wj = OperateType.MUST_SUCCESS;
        this.wk = false;
        this.wl = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.wn = false;
        this.wo = true;
        this.mOutputStream = null;
        this.wp = null;
        this.wq = true;
        this.wr = false;
        this.ws = 0;
        this.wt = null;
        this.wu = null;
        this.wv = null;
        this.mPath = str;
        this.mName = str2;
        this.wt = str3;
        this.wu = str4;
        this.wl = action;
    }

    public void m(Object obj) {
        this.mLock = obj;
    }

    public void gm() {
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

    public Action gn() {
        return this.wl;
    }

    public boolean k(byte[] bArr) {
        return true;
    }

    public byte[] go() {
        return null;
    }

    public boolean isSuccess() {
        return this.wn;
    }

    public void setSuccess(boolean z) {
        this.wn = z;
    }

    public void w(boolean z) {
        this.wk = z;
    }

    public String gp() {
        if (this.wk && this.mName != null) {
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

    public String gq() {
        if (this.wk && this.wu != null) {
            int hashCode = this.wu.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.wt == null) {
                return String.valueOf(i);
            }
            return this.wt + "/" + i;
        }
        return this.wt;
    }

    public OperateType gr() {
        return this.wj;
    }

    public void a(OperateType operateType) {
        this.wj = operateType;
    }

    public void t(boolean z) {
    }

    public boolean gs() {
        return this.wo;
    }

    public void x(boolean z) {
        this.wo = z;
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

    public File gt() {
        return this.wp;
    }

    public void f(File file) {
        this.wp = file;
    }

    public boolean gu() {
        return this.wq;
    }

    public void y(boolean z) {
        this.wq = z;
    }

    public void z(boolean z) {
        this.wr = z;
    }

    public boolean gv() {
        return this.wr;
    }

    public boolean gg() {
        return com.baidu.adp.lib.Disk.d.gf().b(this);
    }

    public int gw() {
        return this.ws;
    }

    public void Q(int i) {
        this.ws = i;
    }

    public String gx() {
        return this.wt;
    }

    public String gy() {
        return this.wu;
    }

    public e.a gA() {
        return this.wv;
    }
}
