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
    private String tA;
    private String tB;
    private e.a tC;
    private OperateType ts;
    protected boolean tt;
    protected Action tu;

    /* renamed from: tv  reason: collision with root package name */
    private volatile boolean f1tv;
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
        this.ts = OperateType.MUST_SUCCESS;
        this.tt = false;
        this.tu = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.f1tv = false;
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
        this.tu = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.ts = OperateType.MUST_SUCCESS;
        this.tt = false;
        this.tu = Action.READ;
        this.mData = null;
        this.mLock = null;
        this.mName = null;
        this.mPath = null;
        this.f1tv = false;
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
        this.tu = action;
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

    public Action ea() {
        return this.tu;
    }

    public boolean n(byte[] bArr) {
        return true;
    }

    public byte[] eb() {
        return null;
    }

    public boolean isSuccess() {
        return this.f1tv;
    }

    public void setSuccess(boolean z) {
        this.f1tv = z;
    }

    public void s(boolean z) {
        this.tt = z;
    }

    public String ec() {
        if (this.tt && this.mName != null) {
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
        if (this.tt && this.tB != null) {
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
        return this.ts;
    }

    public void a(OperateType operateType) {
        this.ts = operateType;
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
