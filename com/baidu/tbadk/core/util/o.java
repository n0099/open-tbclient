package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class o extends DiskFileOperate {
    protected p HA;
    protected BitmapFactory.Options gc;
    protected Bitmap mBitmap;

    public o(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.gc = null;
        this.HA = null;
        this.HA = new p();
    }

    public boolean cm() {
        return this.HA.gg;
    }

    public void r(boolean z) {
        this.HA.gg = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!cm() && com.baidu.adp.lib.util.l.l(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] bZ() {
        if (this.mData == null) {
            return null;
        }
        return this.HA.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.gc == null) {
            this.gc = new BitmapFactory.Options();
            this.gc.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean k = this.HA.k(bArr);
        if (this.HA.gh == 0 || this.HA.gh >= System.currentTimeMillis()) {
            int cp = p.cp();
            if (!k) {
                cp = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, cp, bArr.length - cp, this.gc);
            } catch (Error e) {
                BdLog.e(e.getMessage());
            }
            return this.mBitmap != null;
        }
        return false;
    }
}
