package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options kH;
    protected a kI;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.kH = null;
        this.kI = null;
        this.kI = new a();
    }

    public boolean cY() {
        return this.kI.kL;
    }

    public void u(boolean z) {
        this.kI.kL = z;
    }

    public boolean cZ() {
        return this.kI.kN;
    }

    public void v(boolean z) {
        this.kI.kN = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!cY() && k.m(bArr)) {
            u(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] cL() {
        if (this.ks == null) {
            return null;
        }
        return this.kI.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr != null && this.kI.l(bArr)) {
            if (this.kI.kM == 0 || this.kI.kM >= System.currentTimeMillis()) {
                if (this.kH == null) {
                    this.kH = new BitmapFactory.Options();
                    this.kH.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.kH);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] da() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.ks.length - headerSize];
        System.arraycopy(this.ks, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte kJ = Byte.MIN_VALUE;
        private static byte kK = Byte.MIN_VALUE;
        boolean kL = false;
        long kM = 0;
        boolean kN = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.kL ? (byte) (kJ | 0) : (byte) 0);
            allocate.putLong(this.kM);
            allocate.put(this.kN ? (byte) 0 : (byte) (kK | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & kJ) != 0) {
                    this.kL = true;
                }
                this.kM = wrap.getLong();
                if ((wrap.get() & kK) != 0) {
                    this.kN = false;
                }
                return true;
            }
            return false;
        }
    }
}
