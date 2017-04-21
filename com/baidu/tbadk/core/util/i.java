package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class i extends DiskFileOperate {
    protected a aen;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rW;

    public i(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rW = null;
        this.aen = null;
        this.aen = new a();
    }

    public boolean ef() {
        return this.aen.sa;
    }

    public void v(boolean z) {
        this.aen.sa = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!ef() && com.baidu.adp.lib.util.k.m(bArr)) {
            v(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dS() {
        if (this.rK == null) {
            return null;
        }
        return this.aen.toByteArray();
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
        boolean l = this.aen.l(bArr);
        if (this.aen.sb == 0 || this.aen.sb >= System.currentTimeMillis()) {
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
