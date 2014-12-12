package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options gc;
    protected d gd;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.gc = null;
        this.gd = null;
        this.gd = new d();
    }

    public boolean cm() {
        return this.gd.gg;
    }

    public void r(boolean z) {
        this.gd.gg = z;
    }

    public boolean cn() {
        return this.gd.gi;
    }

    public void s(boolean z) {
        this.gd.gi = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!cm() && l.l(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] bZ() {
        if (this.mData == null) {
            return null;
        }
        return this.gd.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr != null && this.gd.k(bArr)) {
            if (this.gd.gh == 0 || this.gd.gh >= System.currentTimeMillis()) {
                if (this.gc == null) {
                    this.gc = new BitmapFactory.Options();
                    this.gc.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int cp = d.cp();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, cp, bArr.length - cp, this.gc);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] co() {
        int cp = d.cp();
        byte[] bArr = new byte[this.mData.length - cp];
        System.arraycopy(this.mData, cp, bArr, 0, bArr.length);
        return bArr;
    }
}
