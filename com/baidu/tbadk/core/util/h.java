package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class h extends DiskFileOperate {
    protected a bIw;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options zv;

    public h(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.zv = null;
        this.bIw = null;
        this.bIw = new a();
    }

    public boolean isGif() {
        return this.bIw.mIsGif;
    }

    public void W(boolean z) {
        this.bIw.mIsGif = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.l.s(bArr)) {
            W(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] hI() {
        if (this.mData == null) {
            return null;
        }
        return this.bIw.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean q(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.zv == null) {
            this.zv = new BitmapFactory.Options();
            this.zv.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean r = this.bIw.r(bArr);
        if (this.bIw.zA == 0 || this.bIw.zA >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!r) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.zv);
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
        private static byte zy = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long zA = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | zy) : (byte) 0);
            allocate.putLong(this.zA);
            allocate.flip();
            return allocate.array();
        }

        public boolean r(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & zy) != 0) {
                    this.mIsGif = true;
                }
                this.zA = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
