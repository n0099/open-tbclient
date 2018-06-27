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
    protected BitmapFactory.Options wx;
    protected a wy;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.wx = null;
        this.wy = null;
        this.wy = new a();
    }

    public boolean isGif() {
        return this.wy.mIsGif;
    }

    public void A(boolean z) {
        this.wy.mIsGif = z;
    }

    public boolean gC() {
        return this.wy.wC;
    }

    public void B(boolean z) {
        this.wy.wC = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.m(bArr)) {
            A(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] go() {
        if (this.mData == null) {
            return null;
        }
        return this.wy.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr != null && this.wy.l(bArr)) {
            if (this.wy.wB == 0 || this.wy.wB >= System.currentTimeMillis()) {
                if (this.wx == null) {
                    this.wx = new BitmapFactory.Options();
                    this.wx.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.wx);
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
        boolean mIsGif = false;
        long wB = 0;
        boolean wC = true;
        private static byte wz = Byte.MIN_VALUE;
        private static byte wA = Byte.MIN_VALUE;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (wz | 0) : (byte) 0);
            allocate.putLong(this.wB);
            allocate.put(this.wC ? (byte) 0 : (byte) (wA | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & wz) != 0) {
                    this.mIsGif = true;
                }
                this.wB = wrap.getLong();
                if ((wrap.get() & wA) != 0) {
                    this.wC = false;
                }
                return true;
            }
            return false;
        }
    }
}
