package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k extends DiskFileOperate {
    protected l Tj;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options ry;

    public k(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.ry = null;
        this.Tj = null;
        this.Tj = new l();
    }

    public boolean fI() {
        return this.Tj.rC;
    }

    public void r(boolean z) {
        this.Tj.rC = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fI() && com.baidu.adp.lib.util.n.n(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] fv() {
        if (this.mData == null) {
            return null;
        }
        return this.Tj.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.ry == null) {
            this.ry = new BitmapFactory.Options();
            this.ry.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean l = this.Tj.l(bArr);
        if (this.Tj.rD == 0 || this.Tj.rD >= System.currentTimeMillis()) {
            int fL = l.fL();
            if (!l) {
                fL = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, fL, bArr.length - fL, this.ry);
            } catch (Error e) {
                BdLog.e(e.getMessage());
            }
            return this.mBitmap != null;
        }
        return false;
    }
}
