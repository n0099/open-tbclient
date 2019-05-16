package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected Bitmap mBitmap;
    protected BitmapFactory.Options xg;
    protected a xh;
    protected boolean xi;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.xg = null;
        this.xh = null;
        this.xi = true;
        this.xh = new a();
    }

    public void N(boolean z) {
        this.xi = z;
    }

    public boolean isGif() {
        return this.xh.mIsGif;
    }

    public void O(boolean z) {
        this.xh.mIsGif = z;
    }

    public boolean gP() {
        return this.xh.xm;
    }

    public void P(boolean z) {
        this.xh.xm = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.k(bArr)) {
            O(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] gC() {
        if (this.mData == null || !this.xi) {
            return null;
        }
        return this.xh.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr != null && this.xh.j(bArr)) {
            if (this.xh.xl == 0 || this.xh.xl >= System.currentTimeMillis()) {
                if (this.xg == null) {
                    this.xg = new BitmapFactory.Options();
                    this.xg.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.xg);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] gQ() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte xj = Byte.MIN_VALUE;
        private static byte xk = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long xl = 0;
        boolean xm = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (xj | 0) : (byte) 0);
            allocate.putLong(this.xl);
            allocate.put(this.xm ? (byte) 0 : (byte) (xk | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean j(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & xj) != 0) {
                    this.mIsGif = true;
                }
                this.xl = wrap.getLong();
                if ((wrap.get() & xk) != 0) {
                    this.xm = false;
                }
                return true;
            }
            return false;
        }
    }
}
