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
    protected BitmapFactory.Options zu;
    protected a zv;
    protected boolean zw;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.zu = null;
        this.zv = null;
        this.zw = true;
        this.zv = new a();
    }

    public void V(boolean z) {
        this.zw = z;
    }

    public boolean isGif() {
        return this.zv.mIsGif;
    }

    public void W(boolean z) {
        this.zv.mIsGif = z;
    }

    public boolean hV() {
        return this.zv.zA;
    }

    public void X(boolean z) {
        this.zv.zA = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.s(bArr)) {
            W(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] hI() {
        if (this.mData == null || !this.zw) {
            return null;
        }
        return this.zv.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean q(byte[] bArr) {
        if (bArr != null && this.zv.r(bArr)) {
            if (this.zv.zz == 0 || this.zv.zz >= System.currentTimeMillis()) {
                if (this.zu == null) {
                    this.zu = new BitmapFactory.Options();
                    this.zu.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.zu);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] hW() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte zx = Byte.MIN_VALUE;
        private static byte zy = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long zz = 0;
        boolean zA = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (zx | 0) : (byte) 0);
            allocate.putLong(this.zz);
            allocate.put(this.zA ? (byte) 0 : (byte) (zy | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean r(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & zx) != 0) {
                    this.mIsGif = true;
                }
                this.zz = wrap.getLong();
                if ((wrap.get() & zy) != 0) {
                    this.zA = false;
                }
                return true;
            }
            return false;
        }
    }
}
