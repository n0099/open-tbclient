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
    private OperateType wc;
    protected boolean wd;
    protected Action we;
    protected String wf;
    private volatile boolean wg;
    private boolean wh;
    private File wi;
    private boolean wj;
    private boolean wk;
    private int wl;
    private String wn;
    private String wo;
    private e.a wp;

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
        this.wc = OperateType.MUST_SUCCESS;
        this.wd = false;
        this.we = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.wf = null;
        this.wg = false;
        this.wh = true;
        this.mOutputStream = null;
        this.wi = null;
        this.wj = true;
        this.wk = false;
        this.wl = 0;
        this.wn = null;
        this.wo = null;
        this.wp = null;
        this.wf = str;
        this.mName = str2;
        this.we = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.wc = OperateType.MUST_SUCCESS;
        this.wd = false;
        this.we = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.wf = null;
        this.wg = false;
        this.wh = true;
        this.mOutputStream = null;
        this.wi = null;
        this.wj = true;
        this.wk = false;
        this.wl = 0;
        this.wn = null;
        this.wo = null;
        this.wp = null;
        this.wf = str;
        this.mName = str2;
        this.wn = str3;
        this.wo = str4;
        this.we = action;
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
        return this.wf;
    }

    public Action gm() {
        return this.we;
    }

    public boolean i(byte[] bArr) {
        return true;
    }

    public byte[] gn() {
        return null;
    }

    public boolean isSuccess() {
        return this.wg;
    }

    public void setSuccess(boolean z) {
        this.wg = z;
    }

    public void u(boolean z) {
        this.wd = z;
    }

    public String go() {
        if (this.wd && this.mName != null) {
            int hashCode = this.mName.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.wf == null) {
                return String.valueOf(i);
            }
            return this.wf + "/" + i;
        }
        return this.wf;
    }

    public String gp() {
        if (this.wd && this.wo != null) {
            int hashCode = this.wo.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.wn == null) {
                return String.valueOf(i);
            }
            return this.wn + "/" + i;
        }
        return this.wn;
    }

    public OperateType gq() {
        return this.wc;
    }

    public void a(OperateType operateType) {
        this.wc = operateType;
    }

    public void q(boolean z) {
    }

    public boolean gr() {
        return this.wh;
    }

    public void v(boolean z) {
        this.wh = z;
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
        return this.wi;
    }

    public void f(File file) {
        this.wi = file;
    }

    public boolean gt() {
        return this.wj;
    }

    public void w(boolean z) {
        this.wj = z;
    }

    public void x(boolean z) {
        this.wk = z;
    }

    public boolean gu() {
        return this.wk;
    }

    public boolean gf() {
        return com.baidu.adp.lib.Disk.d.ge().b(this);
    }

    public int gv() {
        return this.wl;
    }

    public void Q(int i) {
        this.wl = i;
    }

    public String gw() {
        return this.wn;
    }

    public String gx() {
        return this.wo;
    }

    public e.a gy() {
        return this.wp;
    }
}
