package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected Bitmap mBitmap;
    protected a wA;
    protected BitmapFactory.Options wz;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.wz = null;
        this.wA = null;
        this.wA = new a();
    }

    public boolean isGif() {
        return this.wA.mIsGif;
    }

    public void A(boolean z) {
        this.wA.mIsGif = z;
    }

    public boolean gC() {
        return this.wA.wE;
    }

    public void B(boolean z) {
        this.wA.wE = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.l(bArr)) {
            A(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] go() {
        if (this.mData == null) {
            return null;
        }
        return this.wA.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr != null && this.wA.k(bArr)) {
            if (this.wA.wD == 0 || this.wA.wD >= System.currentTimeMillis()) {
                if (this.wz == null) {
                    this.wz = new BitmapFactory.Options();
                    this.wz.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.wz);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] gD() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte wB = Byte.MIN_VALUE;
        private static byte wC = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long wD = 0;
        boolean wE = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (wB | 0) : (byte) 0);
            allocate.putLong(this.wD);
            allocate.put(this.wE ? (byte) 0 : (byte) (wC | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean k(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & wB) != 0) {
                    this.mIsGif = true;
                }
                this.wD = wrap.getLong();
                if ((wrap.get() & wC) != 0) {
                    this.wE = false;
                }
                return true;
            }
            return false;
        }
    }
}
