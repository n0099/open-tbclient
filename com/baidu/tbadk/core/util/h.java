package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class h extends DiskFileOperate {
    protected a bQl;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options xf;

    public h(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.xf = null;
        this.bQl = null;
        this.bQl = new a();
    }

    public boolean isGif() {
        return this.bQl.mIsGif;
    }

    public void O(boolean z) {
        this.bQl.mIsGif = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.l.k(bArr)) {
            O(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] gC() {
        if (this.mData == null) {
            return null;
        }
        return this.bQl.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.xf == null) {
            this.xf = new BitmapFactory.Options();
            this.xf.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean j = this.bQl.j(bArr);
        if (this.bQl.xk == 0 || this.bQl.xk >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!j) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.xf);
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
        private static byte xi = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long xk = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | xi) : (byte) 0);
            allocate.putLong(this.xk);
            allocate.flip();
            return allocate.array();
        }

        public boolean j(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & xi) != 0) {
                    this.mIsGif = true;
                }
                this.xk = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
