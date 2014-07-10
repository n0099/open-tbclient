package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected Bitmap g;
    protected BitmapFactory.Options h;
    protected d i;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.g = null;
        this.h = null;
        this.i = null;
        this.i = new d();
    }

    public boolean v() {
        return this.i.a;
    }

    public void f(boolean z) {
        this.i.a = z;
    }

    public Bitmap w() {
        return this.g;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void a(byte[] bArr) {
        super.a(bArr);
        if (!v() && j.a(bArr)) {
            f(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] f() {
        if (this.c == null) {
            return null;
        }
        return this.i.b();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean b(byte[] bArr) {
        if (bArr != null && this.i.a(bArr)) {
            if (this.i.b == 0 || this.i.b >= System.currentTimeMillis()) {
                if (this.h == null) {
                    this.h = new BitmapFactory.Options();
                    this.h.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int a = d.a();
                try {
                    this.g = BitmapFactory.decodeByteArray(bArr, a, bArr.length - a, this.h);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.g != null;
            }
            return false;
        }
        return false;
    }
}
