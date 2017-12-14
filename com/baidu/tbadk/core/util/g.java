package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class g extends DiskFileOperate {
    protected a afd;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options ru;

    public g(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.ru = null;
        this.afd = null;
        this.afd = new a();
    }

    public boolean isGif() {
        return this.afd.mIsGif;
    }

    public void w(boolean z) {
        this.afd.mIsGif = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.l.j(bArr)) {
            w(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dQ() {
        if (this.mData == null) {
            return null;
        }
        return this.afd.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.ru == null) {
            this.ru = new BitmapFactory.Options();
            this.ru.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean i = this.afd.i(bArr);
        if (this.afd.ry == 0 || this.afd.ry >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!i) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.ru);
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
        private static byte rw = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long ry = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | rw) : (byte) 0);
            allocate.putLong(this.ry);
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & rw) != 0) {
                    this.mIsGif = true;
                }
                this.ry = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
