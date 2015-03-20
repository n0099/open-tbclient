package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected Bitmap mBitmap;
    protected BitmapFactory.Options ry;
    protected d rz;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.ry = null;
        this.rz = null;
        this.rz = new d();
    }

    public boolean fI() {
        return this.rz.rC;
    }

    public void r(boolean z) {
        this.rz.rC = z;
    }

    public boolean fJ() {
        return this.rz.rE;
    }

    public void s(boolean z) {
        this.rz.rE = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fI() && n.n(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] fv() {
        if (this.mData == null) {
            return null;
        }
        return this.rz.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr != null && this.rz.l(bArr)) {
            if (this.rz.rD == 0 || this.rz.rD >= System.currentTimeMillis()) {
                if (this.ry == null) {
                    this.ry = new BitmapFactory.Options();
                    this.ry.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int fL = d.fL();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, fL, bArr.length - fL, this.ry);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] fK() {
        int fL = d.fL();
        byte[] bArr = new byte[this.mData.length - fL];
        System.arraycopy(this.mData, fL, bArr, 0, bArr.length);
        return bArr;
    }
}
