package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class g extends DiskFileOperate {
    protected a aTt;
    protected BitmapFactory.Options afW;
    protected Bitmap mBitmap;

    public g(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.afW = null;
        this.aTt = null;
        this.aTt = new a();
    }

    public boolean isGif() {
        return this.aTt.mIsGif;
    }

    public void ad(boolean z) {
        this.aTt.mIsGif = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.l.j(bArr)) {
            ad(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] lu() {
        if (this.mData == null) {
            return null;
        }
        return this.aTt.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.afW == null) {
            this.afW = new BitmapFactory.Options();
            this.afW.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean i = this.aTt.i(bArr);
        if (this.aTt.aga == 0 || this.aTt.aga >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!i) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.afW);
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
        private static byte afY = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long aga = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | afY) : (byte) 0);
            allocate.putLong(this.aga);
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & afY) != 0) {
                    this.mIsGif = true;
                }
                this.aga = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
