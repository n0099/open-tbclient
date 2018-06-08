package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class h extends DiskFileOperate {
    protected a aoo;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options wz;

    public h(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.wz = null;
        this.aoo = null;
        this.aoo = new a();
    }

    public boolean isGif() {
        return this.aoo.mIsGif;
    }

    public void A(boolean z) {
        this.aoo.mIsGif = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.l.l(bArr)) {
            A(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] go() {
        if (this.mData == null) {
            return null;
        }
        return this.aoo.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.wz == null) {
            this.wz = new BitmapFactory.Options();
            this.wz.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean k = this.aoo.k(bArr);
        if (this.aoo.wD == 0 || this.aoo.wD >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!k) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.wz);
            } catch (Error e) {
                BdLog.e(e.getMessage());
            }
            return this.mBitmap != null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte wB = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long wD = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | wB) : (byte) 0);
            allocate.putLong(this.wD);
            allocate.flip();
            return allocate.array();
        }

        public boolean k(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & wB) != 0) {
                    this.mIsGif = true;
                }
                this.wD = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
