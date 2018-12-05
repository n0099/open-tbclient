package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class h extends DiskFileOperate {
    protected a azZ;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options zw;

    public h(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.zw = null;
        this.azZ = null;
        this.azZ = new a();
    }

    public boolean isGif() {
        return this.azZ.mIsGif;
    }

    public void W(boolean z) {
        this.azZ.mIsGif = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.l.r(bArr)) {
            W(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] hJ() {
        if (this.mData == null) {
            return null;
        }
        return this.azZ.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean p(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.zw == null) {
            this.zw = new BitmapFactory.Options();
            this.zw.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean q = this.azZ.q(bArr);
        if (this.azZ.zB == 0 || this.azZ.zB >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!q) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.zw);
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
        private static byte zz = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long zB = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | zz) : (byte) 0);
            allocate.putLong(this.zB);
            allocate.flip();
            return allocate.array();
        }

        public boolean q(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & zz) != 0) {
                    this.mIsGif = true;
                }
                this.zB = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
