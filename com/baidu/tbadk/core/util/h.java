package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class h extends DiskFileOperate {
    protected a bIA;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options zu;

    public h(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.zu = null;
        this.bIA = null;
        this.bIA = new a();
    }

    public boolean isGif() {
        return this.bIA.mIsGif;
    }

    public void W(boolean z) {
        this.bIA.mIsGif = z;
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
        return this.bIA.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean q(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.zu == null) {
            this.zu = new BitmapFactory.Options();
            this.zu.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean r = this.bIA.r(bArr);
        if (this.bIA.zz == 0 || this.bIA.zz >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!r) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.zu);
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
        private static byte zx = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long zz = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | zx) : (byte) 0);
            allocate.putLong(this.zz);
            allocate.flip();
            return allocate.array();
        }

        public boolean r(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & zx) != 0) {
                    this.mIsGif = true;
                }
                this.zz = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
