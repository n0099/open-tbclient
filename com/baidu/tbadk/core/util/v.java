package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class v extends DiskFileOperate {
    protected Bitmap g;
    protected BitmapFactory.Options h;
    protected w i;

    public v(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.g = null;
        this.h = null;
        this.i = null;
        this.i = new w();
    }

    public boolean u() {
        return this.i.a;
    }

    public void f(boolean z) {
        this.i.a = z;
    }

    public Bitmap v() {
        return this.g;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void a(byte[] bArr) {
        super.a(bArr);
        if (!u() && com.baidu.adp.lib.util.j.a(bArr)) {
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
        if (bArr == null) {
            return false;
        }
        if (this.h == null) {
            this.h = new BitmapFactory.Options();
            this.h.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean a = this.i.a(bArr);
        if (this.i.b == 0 || this.i.b >= System.currentTimeMillis()) {
            int a2 = w.a();
            if (!a) {
                a2 = 0;
            }
            try {
                this.g = BitmapFactory.decodeByteArray(bArr, a2, bArr.length - a2, this.h);
            } catch (Error e) {
                BdLog.e(e.getMessage());
            }
            return this.g != null;
        }
        return false;
    }
}
