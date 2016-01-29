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
    protected BitmapFactory.Options rN;
    protected a rO;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rN = null;
        this.rO = null;
        this.rO = new a();
    }

    public boolean fN() {
        return this.rO.rR;
    }

    public void r(boolean z) {
        this.rO.rR = z;
    }

    public boolean fO() {
        return this.rO.rT;
    }

    public void s(boolean z) {
        this.rO.rT = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fN() && k.z(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] fB() {
        if (this.mData == null) {
            return null;
        }
        return this.rO.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean x(byte[] bArr) {
        if (bArr != null && this.rO.y(bArr)) {
            if (this.rO.rS == 0 || this.rO.rS >= System.currentTimeMillis()) {
                if (this.rN == null) {
                    this.rN = new BitmapFactory.Options();
                    this.rN.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int fQ = a.fQ();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, fQ, bArr.length - fQ, this.rN);
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
        int fQ = a.fQ();
        byte[] bArr = new byte[this.mData.length - fQ];
        System.arraycopy(this.mData, fQ, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte rP = Byte.MIN_VALUE;
        private static byte rQ = Byte.MIN_VALUE;
        boolean rR = false;
        long rS = 0;
        boolean rT = true;

        a() {
        }

        public static int fQ() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(fQ());
            allocate.putInt(1786600511);
            allocate.put(this.rR ? (byte) (rP | 0) : (byte) 0);
            allocate.putLong(this.rS);
            allocate.put(this.rT ? (byte) 0 : (byte) (rQ | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean y(byte[] bArr) {
            if (bArr == null || bArr.length < fQ()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fQ());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & rP) != 0) {
                    this.rR = true;
                }
                this.rS = wrap.getLong();
                if ((wrap.get() & rQ) != 0) {
                    this.rT = false;
                }
                return true;
            }
            return false;
        }
    }
}
