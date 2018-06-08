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
    private OperateType wl;
    protected boolean wn;
    protected Action wo;
    private volatile boolean wp;
    private boolean wq;
    private File wr;
    private boolean ws;
    private boolean wt;
    private int wu;
    private String wv;
    private String ww;
    private e.a wx;

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
        this.wl = OperateType.MUST_SUCCESS;
        this.wn = false;
        this.wo = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.wp = false;
        this.wq = true;
        this.mOutputStream = null;
        this.wr = null;
        this.ws = true;
        this.wt = false;
        this.wu = 0;
        this.wv = null;
        this.ww = null;
        this.wx = null;
        this.mPath = str;
        this.mName = str2;
        this.wo = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.wl = OperateType.MUST_SUCCESS;
        this.wn = false;
        this.wo = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.wp = false;
        this.wq = true;
        this.mOutputStream = null;
        this.wr = null;
        this.ws = true;
        this.wt = false;
        this.wu = 0;
        this.wv = null;
        this.ww = null;
        this.wx = null;
        this.mPath = str;
        this.mName = str2;
        this.wv = str3;
        this.ww = str4;
        this.wo = action;
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
        return this.wo;
    }

    public boolean j(byte[] bArr) {
        return true;
    }

    public byte[] go() {
        return null;
    }

    public boolean isSuccess() {
        return this.wp;
    }

    public void setSuccess(boolean z) {
        this.wp = z;
    }

    public void w(boolean z) {
        this.wn = z;
    }

    public String gp() {
        if (this.wn && this.mName != null) {
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
        if (this.wn && this.ww != null) {
            int hashCode = this.ww.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.wv == null) {
                return String.valueOf(i);
            }
            return this.wv + "/" + i;
        }
        return this.wv;
    }

    public OperateType gr() {
        return this.wl;
    }

    public void a(OperateType operateType) {
        this.wl = operateType;
    }

    public void t(boolean z) {
    }

    public boolean gs() {
        return this.wq;
    }

    public void x(boolean z) {
        this.wq = z;
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
        return this.wr;
    }

    public void f(File file) {
        this.wr = file;
    }

    public boolean gu() {
        return this.ws;
    }

    public void y(boolean z) {
        this.ws = z;
    }

    public void z(boolean z) {
        this.wt = z;
    }

    public boolean gv() {
        return this.wt;
    }

    public boolean gg() {
        return com.baidu.adp.lib.Disk.d.gf().b(this);
    }

    public int gw() {
        return this.wu;
    }

    public void Q(int i) {
        this.wu = i;
    }

    public String gx() {
        return this.wv;
    }

    public String gy() {
        return this.ww;
    }

    public e.a gA() {
        return this.wx;
    }
}
