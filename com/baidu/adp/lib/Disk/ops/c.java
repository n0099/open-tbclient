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
    protected BitmapFactory.Options zw;
    protected a zx;
    protected boolean zy;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.zw = null;
        this.zx = null;
        this.zy = true;
        this.zx = new a();
    }

    public void V(boolean z) {
        this.zy = z;
    }

    public boolean isGif() {
        return this.zx.mIsGif;
    }

    public void W(boolean z) {
        this.zx.mIsGif = z;
    }

    public boolean hW() {
        return this.zx.zC;
    }

    public void X(boolean z) {
        this.zx.zC = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.r(bArr)) {
            W(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] hJ() {
        if (this.mData == null || !this.zy) {
            return null;
        }
        return this.zx.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean p(byte[] bArr) {
        if (bArr != null && this.zx.q(bArr)) {
            if (this.zx.zB == 0 || this.zx.zB >= System.currentTimeMillis()) {
                if (this.zw == null) {
                    this.zw = new BitmapFactory.Options();
                    this.zw.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.zw);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] hX() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        boolean mIsGif = false;
        long zB = 0;
        boolean zC = true;
        private static byte zz = Byte.MIN_VALUE;
        private static byte zA = Byte.MIN_VALUE;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (zz | 0) : (byte) 0);
            allocate.putLong(this.zB);
            allocate.put(this.zC ? (byte) 0 : (byte) (zA | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean q(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & zz) != 0) {
                    this.mIsGif = true;
                }
                this.zB = wrap.getLong();
                if ((wrap.get() & zA) != 0) {
                    this.zC = false;
                }
                return true;
            }
            return false;
        }
    }
}
