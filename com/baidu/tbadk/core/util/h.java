package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class h extends DiskFileOperate {
    protected a aoq;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options ws;

    public h(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.ws = null;
        this.aoq = null;
        this.aoq = new a();
    }

    public boolean isGif() {
        return this.aoq.mIsGif;
    }

    public void y(boolean z) {
        this.aoq.mIsGif = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.l.k(bArr)) {
            y(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] gn() {
        if (this.mData == null) {
            return null;
        }
        return this.aoq.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.ws == null) {
            this.ws = new BitmapFactory.Options();
            this.ws.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean j = this.aoq.j(bArr);
        if (this.aoq.ww == 0 || this.aoq.ww >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!j) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.ws);
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
        private static byte wu = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long ww = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | wu) : (byte) 0);
            allocate.putLong(this.ww);
            allocate.flip();
            return allocate.array();
        }

        public boolean j(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & wu) != 0) {
                    this.mIsGif = true;
                }
                this.ww = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
