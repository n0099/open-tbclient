package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class h extends DiskFileOperate {
    protected a aoN;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options wx;

    public h(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.wx = null;
        this.aoN = null;
        this.aoN = new a();
    }

    public boolean isGif() {
        return this.aoN.mIsGif;
    }

    public void A(boolean z) {
        this.aoN.mIsGif = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.l.m(bArr)) {
            A(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] go() {
        if (this.mData == null) {
            return null;
        }
        return this.aoN.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.wx == null) {
            this.wx = new BitmapFactory.Options();
            this.wx.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean l = this.aoN.l(bArr);
        if (this.aoN.wB == 0 || this.aoN.wB >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!l) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.wx);
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
        private static byte wz = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long wB = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | wz) : (byte) 0);
            allocate.putLong(this.wB);
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & wz) != 0) {
                    this.mIsGif = true;
                }
                this.wB = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
