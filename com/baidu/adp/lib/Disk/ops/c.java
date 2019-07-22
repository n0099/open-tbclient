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
    protected BitmapFactory.Options xi;
    protected a xj;
    protected boolean xk;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.xi = null;
        this.xj = null;
        this.xk = true;
        this.xj = new a();
    }

    public void N(boolean z) {
        this.xk = z;
    }

    public boolean isGif() {
        return this.xj.mIsGif;
    }

    public void O(boolean z) {
        this.xj.mIsGif = z;
    }

    public boolean gY() {
        return this.xj.xo;
    }

    public void P(boolean z) {
        this.xj.xo = z;
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
    public byte[] gL() {
        if (this.mData == null || !this.xk) {
            return null;
        }
        return this.xj.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr != null && this.xj.j(bArr)) {
            if (this.xj.xn == 0 || this.xj.xn >= System.currentTimeMillis()) {
                if (this.xi == null) {
                    this.xi = new BitmapFactory.Options();
                    this.xi.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.xi);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] gZ() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte xl = Byte.MIN_VALUE;
        private static byte xm = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long xn = 0;
        boolean xo = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (xl | 0) : (byte) 0);
            allocate.putLong(this.xn);
            allocate.put(this.xo ? (byte) 0 : (byte) (xm | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean j(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & xl) != 0) {
                    this.mIsGif = true;
                }
                this.xn = wrap.getLong();
                if ((wrap.get() & xm) != 0) {
                    this.xo = false;
                }
                return true;
            }
            return false;
        }
    }
}
