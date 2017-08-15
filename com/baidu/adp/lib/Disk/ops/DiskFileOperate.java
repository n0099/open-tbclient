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
    private String tA;
    private String tB;
    private e.a tC;
    private OperateType tr;
    protected boolean ts;
    protected Action tt;
    protected volatile byte[] tu;

    /* renamed from: tv  reason: collision with root package name */
    private volatile boolean f0tv;
    private boolean tw;
    private File tx;
    private boolean ty;
    private int tz;

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
        this.tr = OperateType.MUST_SUCCESS;
        this.ts = false;
        this.tt = Action.READ;
        this.tu = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.f0tv = false;
        this.tw = true;
        this.mOutputStream = null;
        this.tx = null;
        this.ty = true;
        this.tz = 0;
        this.tA = null;
        this.tB = null;
        this.tC = null;
        this.mPath = str;
        this.mName = str2;
        this.tt = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.tr = OperateType.MUST_SUCCESS;
        this.ts = false;
        this.tt = Action.READ;
        this.tu = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.f0tv = false;
        this.tw = true;
        this.mOutputStream = null;
        this.tx = null;
        this.ty = true;
        this.tz = 0;
        this.tA = null;
        this.tB = null;
        this.tC = null;
        this.mPath = str;
        this.mName = str2;
        this.tA = str3;
        this.tB = str4;
        this.tt = action;
    }

    public void k(Object obj) {
        this.mLock = obj;
    }

    public void dZ() {
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
        return this.tu;
    }

    public void setData(byte[] bArr) {
        this.tu = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action ea() {
        return this.tt;
    }

    public boolean n(byte[] bArr) {
        return true;
    }

    public byte[] eb() {
        return null;
    }

    public boolean isSuccess() {
        return this.f0tv;
    }

    public void setSuccess(boolean z) {
        this.f0tv = z;
    }

    public void s(boolean z) {
        this.ts = z;
    }

    public String ec() {
        if (this.ts && this.mName != null) {
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

    public String ed() {
        if (this.ts && this.tB != null) {
            int hashCode = this.tB.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.tA == null) {
                return String.valueOf(i);
            }
            return this.tA + "/" + i;
        }
        return this.tA;
    }

    public OperateType ee() {
        return this.tr;
    }

    public void a(OperateType operateType) {
        this.tr = operateType;
    }

    public void p(boolean z) {
    }

    public boolean ef() {
        return this.tw;
    }

    public void t(boolean z) {
        this.tw = z;
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
                com.baidu.adp.lib.g.a.e(this.mOutputStream);
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

    public File eg() {
        return this.tx;
    }

    public void e(File file) {
        this.tx = file;
    }

    public boolean eh() {
        return this.ty;
    }

    public void u(boolean z) {
        this.ty = z;
    }

    public boolean dT() {
        return com.baidu.adp.lib.Disk.d.dS().b(this);
    }

    public int ei() {
        return this.tz;
    }

    public void Z(int i) {
        this.tz = i;
    }

    public String ej() {
        return this.tA;
    }

    public String ek() {
        return this.tB;
    }

    public e.a el() {
        return this.tC;
    }
}
