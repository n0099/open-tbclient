package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options ge;
    protected d gf;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.ge = null;
        this.gf = null;
        this.gf = new d();
    }

    public boolean ck() {
        return this.gf.gi;
    }

    public void r(boolean z) {
        this.gf.gi = z;
    }

    public boolean cl() {
        return this.gf.gk;
    }

    public void s(boolean z) {
        this.gf.gk = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!ck() && l.l(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] bX() {
        if (this.mData == null) {
            return null;
        }
        return this.gf.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr != null && this.gf.k(bArr)) {
            if (this.gf.gj == 0 || this.gf.gj >= System.currentTimeMillis()) {
                if (this.ge == null) {
                    this.ge = new BitmapFactory.Options();
                    this.ge.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int cn = d.cn();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, cn, bArr.length - cn, this.ge);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] cm() {
        int cn = d.cn();
        byte[] bArr = new byte[this.mData.length - cn];
        System.arraycopy(this.mData, cn, bArr, 0, bArr.length);
        return bArr;
    }
}
