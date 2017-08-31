package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class g extends DiskFileOperate {
    protected a afi;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rs;

    public g(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rs = null;
        this.afi = null;
        this.afi = new a();
    }

    public boolean isGif() {
        return this.afi.rw;
    }

    public void w(boolean z) {
        this.afi.rw = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.k.j(bArr)) {
            w(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dR() {
        if (this.mData == null) {
            return null;
        }
        return this.afi.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.rs == null) {
            this.rs = new BitmapFactory.Options();
            this.rs.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean i = this.afi.i(bArr);
        if (this.afi.rx == 0 || this.afi.rx >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!i) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.rs);
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
        private static byte ru = Byte.MIN_VALUE;
        boolean rw = false;
        long rx = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.rw ? (byte) (0 | ru) : (byte) 0);
            allocate.putLong(this.rx);
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & ru) != 0) {
                    this.rw = true;
                }
                this.rx = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
