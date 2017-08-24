package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class g extends DiskFileOperate {
    protected a afY;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options tG;

    public g(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.tG = null;
        this.afY = null;
        this.afY = new a();
    }

    public boolean isGif() {
        return this.afY.tK;
    }

    public void v(boolean z) {
        this.afY.tK = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.k.p(bArr)) {
            v(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] eb() {
        if (this.mData == null) {
            return null;
        }
        return this.afY.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean n(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.tG == null) {
            this.tG = new BitmapFactory.Options();
            this.tG.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean o = this.afY.o(bArr);
        if (this.afY.tL == 0 || this.afY.tL >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!o) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.tG);
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
        private static byte tI = Byte.MIN_VALUE;
        boolean tK = false;
        long tL = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.tK ? (byte) (0 | tI) : (byte) 0);
            allocate.putLong(this.tL);
            allocate.flip();
            return allocate.array();
        }

        public boolean o(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & tI) != 0) {
                    this.tK = true;
                }
                this.tL = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
