package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options afT;
    protected a afU;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.afT = null;
        this.afU = null;
        this.afU = new a();
    }

    public boolean isGif() {
        return this.afU.mIsGif;
    }

    public void ac(boolean z) {
        this.afU.mIsGif = z;
    }

    public boolean lG() {
        return this.afU.afY;
    }

    public void ad(boolean z) {
        this.afU.afY = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.j(bArr)) {
            ac(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] lu() {
        if (this.mData == null) {
            return null;
        }
        return this.afU.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr != null && this.afU.i(bArr)) {
            if (this.afU.afX == 0 || this.afU.afX >= System.currentTimeMillis()) {
                if (this.afT == null) {
                    this.afT = new BitmapFactory.Options();
                    this.afT.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.afT);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] lH() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte afV = Byte.MIN_VALUE;
        private static byte afW = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long afX = 0;
        boolean afY = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (afV | 0) : (byte) 0);
            allocate.putLong(this.afX);
            allocate.put(this.afY ? (byte) 0 : (byte) (afW | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & afV) != 0) {
                    this.mIsGif = true;
                }
                this.afX = wrap.getLong();
                if ((wrap.get() & afW) != 0) {
                    this.afY = false;
                }
                return true;
            }
            return false;
        }
    }
}
