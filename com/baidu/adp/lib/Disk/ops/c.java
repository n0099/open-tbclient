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
    protected BitmapFactory.Options zt;
    protected a zu;
    protected boolean zv;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.zt = null;
        this.zu = null;
        this.zv = true;
        this.zu = new a();
    }

    public void H(boolean z) {
        this.zv = z;
    }

    public boolean isGif() {
        return this.zu.mIsGif;
    }

    public void I(boolean z) {
        this.zu.mIsGif = z;
    }

    public boolean hX() {
        return this.zu.zz;
    }

    public void J(boolean z) {
        this.zu.zz = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.s(bArr)) {
            I(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] hK() {
        if (this.mData == null || !this.zv) {
            return null;
        }
        return this.zu.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean q(byte[] bArr) {
        if (bArr != null && this.zu.r(bArr)) {
            if (this.zu.zy == 0 || this.zu.zy >= System.currentTimeMillis()) {
                if (this.zt == null) {
                    this.zt = new BitmapFactory.Options();
                    this.zt.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.zt);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] hY() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte zw = Byte.MIN_VALUE;
        private static byte zx = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long zy = 0;
        boolean zz = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (zw | 0) : (byte) 0);
            allocate.putLong(this.zy);
            allocate.put(this.zz ? (byte) 0 : (byte) (zx | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean r(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & zw) != 0) {
                    this.mIsGif = true;
                }
                this.zy = wrap.getLong();
                if ((wrap.get() & zx) != 0) {
                    this.zz = false;
                }
                return true;
            }
            return false;
        }
    }
}
