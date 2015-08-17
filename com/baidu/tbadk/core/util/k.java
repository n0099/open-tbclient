package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class k extends DiskFileOperate {
    protected a YX;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rE;

    public k(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rE = null;
        this.YX = null;
        this.YX = new a();
    }

    public boolean fI() {
        return this.YX.rI;
    }

    public void r(boolean z) {
        this.YX.rI = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fI() && com.baidu.adp.lib.util.k.z(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] fw() {
        if (this.mData == null) {
            return null;
        }
        return this.YX.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean x(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.rE == null) {
            this.rE = new BitmapFactory.Options();
            this.rE.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean y = this.YX.y(bArr);
        if (this.YX.rJ == 0 || this.YX.rJ >= System.currentTimeMillis()) {
            int fL = a.fL();
            if (!y) {
                fL = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, fL, bArr.length - fL, this.rE);
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
        private static byte rG = Byte.MIN_VALUE;
        boolean rI = false;
        long rJ = 0;

        a() {
        }

        public static int fL() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(fL());
            allocate.putInt(1786600510);
            allocate.put(this.rI ? (byte) (0 | rG) : (byte) 0);
            allocate.putLong(this.rJ);
            allocate.flip();
            return allocate.array();
        }

        public boolean y(byte[] bArr) {
            if (bArr == null || bArr.length < fL()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fL());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & rG) != 0) {
                    this.rI = true;
                }
                this.rJ = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
