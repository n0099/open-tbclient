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
    private e.a tA;
    private OperateType tp;
    protected boolean tq;
    protected Action tr;
    protected volatile byte[] ts;
    private volatile boolean tt;
    private boolean tu;

    /* renamed from: tv  reason: collision with root package name */
    private File f0tv;
    private boolean tw;
    private int tx;
    private String ty;
    private String tz;

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
        this.tp = OperateType.MUST_SUCCESS;
        this.tq = false;
        this.tr = Action.READ;
        this.ts = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.tt = false;
        this.tu = true;
        this.mOutputStream = null;
        this.f0tv = null;
        this.tw = true;
        this.tx = 0;
        this.ty = null;
        this.tz = null;
        this.tA = null;
        this.mPath = str;
        this.mName = str2;
        this.tr = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.tp = OperateType.MUST_SUCCESS;
        this.tq = false;
        this.tr = Action.READ;
        this.ts = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.tt = false;
        this.tu = true;
        this.mOutputStream = null;
        this.f0tv = null;
        this.tw = true;
        this.tx = 0;
        this.ty = null;
        this.tz = null;
        this.tA = null;
        this.mPath = str;
        this.mName = str2;
        this.ty = str3;
        this.tz = str4;
        this.tr = action;
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
        return this.ts;
    }

    public void setData(byte[] bArr) {
        this.ts = bArr;
    }

    public String getName() {
        return this.mName;
    }

    public String getPath() {
        return this.mPath;
    }

    public Action ea() {
        return this.tr;
    }

    public boolean n(byte[] bArr) {
        return true;
    }

    public byte[] eb() {
        return null;
    }

    public boolean isSuccess() {
        return this.tt;
    }

    public void setSuccess(boolean z) {
        this.tt = z;
    }

    public void s(boolean z) {
        this.tq = z;
    }

    public String ec() {
        if (this.tq && this.mName != null) {
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
        if (this.tq && this.tz != null) {
            int hashCode = this.tz.hashCode();
            if (hashCode < 0) {
                hashCode *= -1;
            }
            int i = (hashCode % 100) + 1;
            if (this.ty == null) {
                return String.valueOf(i);
            }
            return this.ty + "/" + i;
        }
        return this.ty;
    }

    public OperateType ee() {
        return this.tp;
    }

    public void a(OperateType operateType) {
        this.tp = operateType;
    }

    public void p(boolean z) {
    }

    public boolean ef() {
        return this.tu;
    }

    public void t(boolean z) {
        this.tu = z;
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
        return this.f0tv;
    }

    public void e(File file) {
        this.f0tv = file;
    }

    public boolean eh() {
        return this.tw;
    }

    public void u(boolean z) {
        this.tw = z;
    }

    public boolean dT() {
        return com.baidu.adp.lib.Disk.d.dS().b(this);
    }

    public int ei() {
        return this.tx;
    }

    public void Z(int i) {
        this.tx = i;
    }

    public String ej() {
        return this.ty;
    }

    public String ek() {
        return this.tz;
    }

    public e.a el() {
        return this.tA;
    }
}
