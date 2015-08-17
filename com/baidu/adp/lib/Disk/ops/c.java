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
    protected BitmapFactory.Options rE;
    protected a rF;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rE = null;
        this.rF = null;
        this.rF = new a();
    }

    public boolean fI() {
        return this.rF.rI;
    }

    public void r(boolean z) {
        this.rF.rI = z;
    }

    public boolean fJ() {
        return this.rF.rK;
    }

    public void s(boolean z) {
        this.rF.rK = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fI() && k.z(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] fw() {
        if (this.mData == null) {
            return null;
        }
        return this.rF.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean x(byte[] bArr) {
        if (bArr != null && this.rF.y(bArr)) {
            if (this.rF.rJ == 0 || this.rF.rJ >= System.currentTimeMillis()) {
                if (this.rE == null) {
                    this.rE = new BitmapFactory.Options();
                    this.rE.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int fL = a.fL();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, fL, bArr.length - fL, this.rE);
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
        int fL = a.fL();
        byte[] bArr = new byte[this.mData.length - fL];
        System.arraycopy(this.mData, fL, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte rG = Byte.MIN_VALUE;
        private static byte rH = Byte.MIN_VALUE;
        boolean rI = false;
        long rJ = 0;
        boolean rK = true;

        a() {
        }

        public static int fL() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(fL());
            allocate.putInt(1786600511);
            allocate.put(this.rI ? (byte) (rG | 0) : (byte) 0);
            allocate.putLong(this.rJ);
            allocate.put(this.rK ? (byte) 0 : (byte) (rH | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean y(byte[] bArr) {
            if (bArr == null || bArr.length < fL()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fL());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & rG) != 0) {
                    this.rI = true;
                }
                this.rJ = wrap.getLong();
                if ((wrap.get() & rH) != 0) {
                    this.rK = false;
                }
                return true;
            }
            return false;
        }
    }
}
