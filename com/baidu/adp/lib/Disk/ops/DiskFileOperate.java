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
    private OperateType wd;
    protected boolean we;
    protected Action wf;
    protected String wg;
    private volatile boolean wh;
    private boolean wi;
    private File wj;
    private boolean wk;
    private boolean wl;
    private int wn;
    private String wo;
    private String wp;
    private e.a wq;

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
        this.wd = OperateType.MUST_SUCCESS;
        this.we = false;
        this.wf = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.wg = null;
        this.wh = false;
        this.wi = true;
        this.mOutputStream = null;
        this.wj = null;
        this.wk = true;
        this.wl = false;
        this.wn = 0;
        this.wo = null;
        this.wp = null;
        this.wq = null;
        this.wg = str;
        this.mName = str2;
        this.wf = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.wd = OperateType.MUST_SUCCESS;
        this.we = false;
        this.wf = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.wg = null;
        this.wh = false;
        this.wi = true;
        this.mOutputStream = null;
        this.wj = null;
        this.wk = true;
        this.wl = false;
        this.wn = 0;
        this.wo = null;
        this.wp = null;
        this.wq = null;
        this.wg = str;
        this.mName = str2;
        this.wo = str3;
        this.wp = str4;
        this.wf = action;
    }

    public void m(Object obj) {
        this.mLock = obj;
    }

    public void gl() {
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
        return this.wg;
    }

    public Action gm() {
        return this.wf;
    }

    public boolean i(byte[] bArr) {
        return true;
    }

    public byte[] gn() {
        return null;
    }

    public boolean isSuccess() {
        return this.wh;
    }

    public void setSuccess(boolean z) {
        this.wh = z;
    }

    public void u(boolean z) {
        this.we = z;
    }

    public String go() {
        if (this.we && this.mName != null) {
            int hashCode = this.mName.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.wg == null) {
                return String.valueOf(i);
            }
            return this.wg + "/" + i;
        }
        return this.wg;
    }

    public String gp() {
        if (this.we && this.wp != null) {
            int hashCode = this.wp.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.wo == null) {
                return String.valueOf(i);
            }
            return this.wo + "/" + i;
        }
        return this.wo;
    }

    public OperateType gq() {
        return this.wd;
    }

    public void a(OperateType operateType) {
        this.wd = operateType;
    }

    public void q(boolean z) {
    }

    public boolean gr() {
        return this.wi;
    }

    public void v(boolean z) {
        this.wi = z;
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

    public File gs() {
        return this.wj;
    }

    public void f(File file) {
        this.wj = file;
    }

    public boolean gt() {
        return this.wk;
    }

    public void w(boolean z) {
        this.wk = z;
    }

    public void x(boolean z) {
        this.wl = z;
    }

    public boolean gu() {
        return this.wl;
    }

    public boolean gf() {
        return com.baidu.adp.lib.Disk.d.ge().b(this);
    }

    public int gv() {
        return this.wn;
    }

    public void Q(int i) {
        this.wn = i;
    }

    public String gw() {
        return this.wo;
    }

    public String gx() {
        return this.wp;
    }

    public e.a gy() {
        return this.wq;
    }
}
