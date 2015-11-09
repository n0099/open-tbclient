package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class k extends DiskFileOperate {
    protected a Zg;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rC;

    public k(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rC = null;
        this.Zg = null;
        this.Zg = new a();
    }

    public boolean fF() {
        return this.Zg.rG;
    }

    public void r(boolean z) {
        this.Zg.rG = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fF() && com.baidu.adp.lib.util.k.z(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] ft() {
        if (this.mData == null) {
            return null;
        }
        return this.Zg.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean x(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.rC == null) {
            this.rC = new BitmapFactory.Options();
            this.rC.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean y = this.Zg.y(bArr);
        if (this.Zg.rH == 0 || this.Zg.rH >= System.currentTimeMillis()) {
            int fI = a.fI();
            if (!y) {
                fI = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, fI, bArr.length - fI, this.rC);
            } catch (Error e) {
                BdLog.e(e.getMessage());
            }
            return this.mBitmap != null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte rE = Byte.MIN_VALUE;
        boolean rG = false;
        long rH = 0;

        a() {
        }

        public static int fI() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(fI());
            allocate.putInt(1786600510);
            allocate.put(this.rG ? (byte) (0 | rE) : (byte) 0);
            allocate.putLong(this.rH);
            allocate.flip();
            return allocate.array();
        }

        public boolean y(byte[] bArr) {
            if (bArr == null || bArr.length < fI()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fI());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & rE) != 0) {
                    this.rG = true;
                }
                this.rH = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
