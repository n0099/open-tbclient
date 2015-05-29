package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rI;
    protected d rJ;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rI = null;
        this.rJ = null;
        this.rJ = new d();
    }

    public boolean fN() {
        return this.rJ.rM;
    }

    public void r(boolean z) {
        this.rJ.rM = z;
    }

    public boolean fO() {
        return this.rJ.rO;
    }

    public void s(boolean z) {
        this.rJ.rO = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fN() && n.n(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] fA() {
        if (this.mData == null) {
            return null;
        }
        return this.rJ.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr != null && this.rJ.l(bArr)) {
            if (this.rJ.rN == 0 || this.rJ.rN >= System.currentTimeMillis()) {
                if (this.rI == null) {
                    this.rI = new BitmapFactory.Options();
                    this.rI.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int fQ = d.fQ();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, fQ, bArr.length - fQ, this.rI);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] fP() {
        int fQ = d.fQ();
        byte[] bArr = new byte[this.mData.length - fQ];
        System.arraycopy(this.mData, fQ, bArr, 0, bArr.length);
        return bArr;
    }
}
