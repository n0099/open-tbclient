package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class g extends DiskFileOperate {
    protected a aeC;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rW;

    public g(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rW = null;
        this.aeC = null;
        this.aeC = new a();
    }

    public boolean isGif() {
        return this.aeC.sa;
    }

    public void v(boolean z) {
        this.aeC.sa = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.k.m(bArr)) {
            v(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dQ() {
        if (this.rK == null) {
            return null;
        }
        return this.aeC.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.rW == null) {
            this.rW = new BitmapFactory.Options();
            this.rW.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean l = this.aeC.l(bArr);
        if (this.aeC.sb == 0 || this.aeC.sb >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!l) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.rW);
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
        private static byte rY = Byte.MIN_VALUE;
        boolean sa = false;
        long sb = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.sa ? (byte) (0 | rY) : (byte) 0);
            allocate.putLong(this.sb);
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & rY) != 0) {
                    this.sa = true;
                }
                this.sb = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
