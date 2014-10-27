package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.m;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options ea;
    protected d eb;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.ea = null;
        this.eb = null;
        this.eb = new d();
    }

    public boolean bM() {
        return this.eb.ee;
    }

    public void n(boolean z) {
        this.eb.ee = z;
    }

    public boolean bN() {
        return this.eb.eg;
    }

    public void o(boolean z) {
        this.eb.eg = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!bM() && m.l(bArr)) {
            n(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] by() {
        if (this.dL == null) {
            return null;
        }
        return this.eb.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr != null && this.eb.j(bArr)) {
            if (this.eb.ef == 0 || this.eb.ef >= System.currentTimeMillis()) {
                if (this.ea == null) {
                    this.ea = new BitmapFactory.Options();
                    this.ea.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int bP = d.bP();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, bP, bArr.length - bP, this.ea);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] bO() {
        int bP = d.bP();
        byte[] bArr = new byte[this.dL.length - bP];
        System.arraycopy(this.dL, bP, bArr, 0, bArr.length);
        return bArr;
    }
}
