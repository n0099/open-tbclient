package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class k extends DiskFileOperate {
    protected l TU;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rI;

    public k(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rI = null;
        this.TU = null;
        this.TU = new l();
    }

    public boolean fN() {
        return this.TU.rM;
    }

    public void r(boolean z) {
        this.TU.rM = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fN() && com.baidu.adp.lib.util.n.n(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] fA() {
        if (this.mData == null) {
            return null;
        }
        return this.TU.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.rI == null) {
            this.rI = new BitmapFactory.Options();
            this.rI.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean l = this.TU.l(bArr);
        if (this.TU.rN == 0 || this.TU.rN >= System.currentTimeMillis()) {
            int fQ = l.fQ();
            if (!l) {
                fQ = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, fQ, bArr.length - fQ, this.rI);
            } catch (Error e) {
                BdLog.e(e.getMessage());
            }
            return this.mBitmap != null;
        }
        return false;
    }
}
