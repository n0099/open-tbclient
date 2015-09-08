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
    protected BitmapFactory.Options rC;
    protected a rD;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rC = null;
        this.rD = null;
        this.rD = new a();
    }

    public boolean fF() {
        return this.rD.rG;
    }

    public void r(boolean z) {
        this.rD.rG = z;
    }

    public boolean fG() {
        return this.rD.rI;
    }

    public void s(boolean z) {
        this.rD.rI = z;
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
        return this.rD.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean x(byte[] bArr) {
        if (bArr != null && this.rD.y(bArr)) {
            if (this.rD.rH == 0 || this.rD.rH >= System.currentTimeMillis()) {
                if (this.rC == null) {
                    this.rC = new BitmapFactory.Options();
                    this.rC.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int fI = a.fI();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, fI, bArr.length - fI, this.rC);
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
        private static byte rE = Byte.MIN_VALUE;
        private static byte rF = Byte.MIN_VALUE;
        boolean rG = false;
        long rH = 0;
        boolean rI = true;

        a() {
        }

        public static int fI() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(fI());
            allocate.putInt(1786600511);
            allocate.put(this.rG ? (byte) (rE | 0) : (byte) 0);
            allocate.putLong(this.rH);
            allocate.put(this.rI ? (byte) 0 : (byte) (rF | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean y(byte[] bArr) {
            if (bArr == null || bArr.length < fI()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fI());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & rE) != 0) {
                    this.rG = true;
                }
                this.rH = wrap.getLong();
                if ((wrap.get() & rF) != 0) {
                    this.rI = false;
                }
                return true;
            }
            return false;
        }
    }
}
