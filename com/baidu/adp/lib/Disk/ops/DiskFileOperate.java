package com.baidu.adp.lib.Disk.ops;

import com.baidu.adp.lib.util.BdLog;
import java.io.File;
import java.io.OutputStream;
/* loaded from: classes.dex */
public class DiskFileOperate {
    protected boolean a;
    protected Action b;
    protected volatile byte[] c;
    protected volatile Object d;
    protected String e;
    protected String f;
    private OperateType g;
    private volatile boolean h;
    private boolean i;
    private OutputStream j;
    private File k;
    private boolean l;
    private int m;
    private String n;
    private String o;

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
        RENAME;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static Action[] valuesCustom() {
            Action[] valuesCustom = values();
            int length = valuesCustom.length;
            Action[] actionArr = new Action[length];
            System.arraycopy(valuesCustom, 0, actionArr, 0, length);
            return actionArr;
        }
    }

    /* loaded from: classes.dex */
    public enum OperateType {
        MUST_SUCCESS,
        TRY_SUCCESS;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static OperateType[] valuesCustom() {
            OperateType[] valuesCustom = values();
            int length = valuesCustom.length;
            OperateType[] operateTypeArr = new OperateType[length];
            System.arraycopy(valuesCustom, 0, operateTypeArr, 0, length);
            return operateTypeArr;
        }
    }

    public DiskFileOperate(String str, String str2, Action action) {
        this.g = OperateType.MUST_SUCCESS;
        this.a = false;
        this.b = Action.READ;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = false;
        this.i = true;
        this.j = null;
        this.k = null;
        this.l = true;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.f = str;
        this.e = str2;
        this.b = action;
    }

    public DiskFileOperate(String str, String str2, String str3, String str4, Action action) {
        this.g = OperateType.MUST_SUCCESS;
        this.a = false;
        this.b = Action.READ;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = false;
        this.i = true;
        this.j = null;
        this.k = null;
        this.l = true;
        this.m = 0;
        this.n = null;
        this.o = null;
        this.f = str;
        this.e = str2;
        this.n = str3;
        this.o = str4;
        this.b = action;
    }

    public void a(Object obj) {
        this.d = obj;
    }

    public void a() {
        if (this.d != null) {
            try {
                synchronized (this.d) {
                    this.d.notifyAll();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public byte[] b() {
        return this.c;
    }

    public void a(byte[] bArr) {
        this.c = bArr;
    }

    public String c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }

    public Action e() {
        return this.b;
    }

    public boolean b(byte[] bArr) {
        return true;
    }

    public byte[] f() {
        return null;
    }

    public boolean g() {
        return this.h;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(boolean z) {
        this.a = z;
    }

    public String h() {
        if (this.a && this.e != null) {
            int abs = (Math.abs(this.e.hashCode()) % 100) + 1;
            if (this.f == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.f) + "/" + abs;
        }
        return this.f;
    }

    public String i() {
        if (this.a && this.o != null) {
            int abs = (Math.abs(this.o.hashCode()) % 100) + 1;
            if (this.n == null) {
                return String.valueOf(abs);
            }
            return String.valueOf(this.n) + "/" + abs;
        }
        return this.n;
    }

    public OperateType j() {
        return this.g;
    }

    public void a(OperateType operateType) {
        this.g = operateType;
    }

    public void c(boolean z) {
    }

    public boolean k() {
        return this.i;
    }

    public void d(boolean z) {
        this.i = z;
    }

    protected void finalize() {
        super.finalize();
        m();
    }

    public OutputStream l() {
        OutputStream outputStream;
        synchronized (this) {
            outputStream = this.j;
        }
        return outputStream;
    }

    public void m() {
        synchronized (this) {
            if (this.j != null) {
                com.baidu.adp.lib.f.a.a(this.j);
                this.j = null;
            }
        }
    }

    public void a(OutputStream outputStream) {
        synchronized (this) {
            if (outputStream != this.j) {
                m();
                this.j = outputStream;
            }
        }
    }

    public File n() {
        return this.k;
    }

    public void b(File file) {
        this.k = file;
    }

    public boolean o() {
        return this.l;
    }

    public void e(boolean z) {
        this.l = z;
    }

    public boolean p() {
        return com.baidu.adp.lib.Disk.d.a().a(this);
    }

    public boolean q() {
        return com.baidu.adp.lib.Disk.d.a().b(this);
    }

    public int r() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public String s() {
        return this.n;
    }

    public String t() {
        return this.o;
    }
}
