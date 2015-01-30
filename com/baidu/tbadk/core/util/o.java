package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class o extends DiskFileOperate {
    protected p HJ;
    protected BitmapFactory.Options ge;
    protected Bitmap mBitmap;

    public o(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.ge = null;
        this.HJ = null;
        this.HJ = new p();
    }

    public boolean ck() {
        return this.HJ.gi;
    }

    public void r(boolean z) {
        this.HJ.gi = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!ck() && com.baidu.adp.lib.util.l.l(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] bX() {
        if (this.mData == null) {
            return null;
        }
        return this.HJ.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.ge == null) {
            this.ge = new BitmapFactory.Options();
            this.ge.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean k = this.HJ.k(bArr);
        if (this.HJ.gj == 0 || this.HJ.gj >= System.currentTimeMillis()) {
            int cn = p.cn();
            if (!k) {
                cn = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, cn, bArr.length - cn, this.ge);
            } catch (Error e) {
                BdLog.e(e.getMessage());
            }
            return this.mBitmap != null;
        }
        return false;
    }
}
