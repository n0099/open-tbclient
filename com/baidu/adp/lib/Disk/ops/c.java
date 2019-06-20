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
    protected BitmapFactory.Options xf;
    protected a xg;
    protected boolean xh;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.xf = null;
        this.xg = null;
        this.xh = true;
        this.xg = new a();
    }

    public void N(boolean z) {
        this.xh = z;
    }

    public boolean isGif() {
        return this.xg.mIsGif;
    }

    public void O(boolean z) {
        this.xg.mIsGif = z;
    }

    public boolean gP() {
        return this.xg.xl;
    }

    public void P(boolean z) {
        this.xg.xl = z;
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
        if (this.mData == null || !this.xh) {
            return null;
        }
        return this.xg.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr != null && this.xg.j(bArr)) {
            if (this.xg.xk == 0 || this.xg.xk >= System.currentTimeMillis()) {
                if (this.xf == null) {
                    this.xf = new BitmapFactory.Options();
                    this.xf.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.xf);
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
        private static byte xi = Byte.MIN_VALUE;
        private static byte xj = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long xk = 0;
        boolean xl = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (xi | 0) : (byte) 0);
            allocate.putLong(this.xk);
            allocate.put(this.xl ? (byte) 0 : (byte) (xj | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean j(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & xi) != 0) {
                    this.mIsGif = true;
                }
                this.xk = wrap.getLong();
                if ((wrap.get() & xj) != 0) {
                    this.xl = false;
                }
                return true;
            }
            return false;
        }
    }
}
