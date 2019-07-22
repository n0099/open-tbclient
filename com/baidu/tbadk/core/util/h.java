package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class h extends DiskFileOperate {
    protected a bRl;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options xi;

    public h(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.xi = null;
        this.bRl = null;
        this.bRl = new a();
    }

    public boolean isGif() {
        return this.bRl.mIsGif;
    }

    public void O(boolean z) {
        this.bRl.mIsGif = z;
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
    public byte[] gL() {
        if (this.mData == null) {
            return null;
        }
        return this.bRl.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.xi == null) {
            this.xi = new BitmapFactory.Options();
            this.xi.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean j = this.bRl.j(bArr);
        if (this.bRl.xn == 0 || this.bRl.xn >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!j) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.xi);
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
        private static byte xl = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long xn = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | xl) : (byte) 0);
            allocate.putLong(this.xn);
            allocate.flip();
            return allocate.array();
        }

        public boolean j(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & xl) != 0) {
                    this.mIsGif = true;
                }
                this.xn = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
