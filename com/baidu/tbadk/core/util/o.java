package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class o extends DiskFileOperate {
    protected p Do;
    protected BitmapFactory.Options ea;
    protected Bitmap mBitmap;

    public o(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.ea = null;
        this.Do = null;
        this.Do = new p();
    }

    public boolean bM() {
        return this.Do.ee;
    }

    public void n(boolean z) {
        this.Do.ee = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!bM() && com.baidu.adp.lib.util.m.l(bArr)) {
            n(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] by() {
        if (this.dL == null) {
            return null;
        }
        return this.Do.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.ea == null) {
            this.ea = new BitmapFactory.Options();
            this.ea.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean j = this.Do.j(bArr);
        if (this.Do.ef == 0 || this.Do.ef >= System.currentTimeMillis()) {
            int bP = p.bP();
            if (!j) {
                bP = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, bP, bArr.length - bP, this.ea);
            } catch (Error e) {
                BdLog.e(e.getMessage());
            }
            return this.mBitmap != null;
        }
        return false;
    }
}
