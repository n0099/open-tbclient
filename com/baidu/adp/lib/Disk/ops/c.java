package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rF;
    protected a rG;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rF = null;
        this.rG = null;
        this.rG = new a();
    }

    public boolean fF() {
        return this.rG.rJ;
    }

    public void r(boolean z) {
        this.rG.rJ = z;
    }

    public boolean fG() {
        return this.rG.rL;
    }

    public void s(boolean z) {
        this.rG.rL = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fF() && k.z(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] ft() {
        if (this.mData == null) {
            return null;
        }
        return this.rG.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean x(byte[] bArr) {
        if (bArr != null && this.rG.y(bArr)) {
            if (this.rG.rK == 0 || this.rG.rK >= System.currentTimeMillis()) {
                if (this.rF == null) {
                    this.rF = new BitmapFactory.Options();
                    this.rF.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int fI = a.fI();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, fI, bArr.length - fI, this.rF);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] fH() {
        int fI = a.fI();
        byte[] bArr = new byte[this.mData.length - fI];
        System.arraycopy(this.mData, fI, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte rH = Byte.MIN_VALUE;
        private static byte rI = Byte.MIN_VALUE;
        boolean rJ = false;
        long rK = 0;
        boolean rL = true;

        a() {
        }

        public static int fI() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(fI());
            allocate.putInt(1786600511);
            allocate.put(this.rJ ? (byte) (rH | 0) : (byte) 0);
            allocate.putLong(this.rK);
            allocate.put(this.rL ? (byte) 0 : (byte) (rI | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean y(byte[] bArr) {
            if (bArr == null || bArr.length < fI()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fI());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & rH) != 0) {
                    this.rJ = true;
                }
                this.rK = wrap.getLong();
                if ((wrap.get() & rI) != 0) {
                    this.rL = false;
                }
                return true;
            }
            return false;
        }
    }
}
