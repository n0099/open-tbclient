package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options afU;
    protected a afV;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.afU = null;
        this.afV = null;
        this.afV = new a();
    }

    public boolean isGif() {
        return this.afV.mIsGif;
    }

    public void af(boolean z) {
        this.afV.mIsGif = z;
    }

    public boolean lH() {
        return this.afV.afZ;
    }

    public void ag(boolean z) {
        this.afV.afZ = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.j(bArr)) {
            af(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] lu() {
        if (this.mData == null) {
            return null;
        }
        return this.afV.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr != null && this.afV.i(bArr)) {
            if (this.afV.afY == 0 || this.afV.afY >= System.currentTimeMillis()) {
                if (this.afU == null) {
                    this.afU = new BitmapFactory.Options();
                    this.afU.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.afU);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] lI() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte afW = Byte.MIN_VALUE;
        private static byte afX = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long afY = 0;
        boolean afZ = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (afW | 0) : (byte) 0);
            allocate.putLong(this.afY);
            allocate.put(this.afZ ? (byte) 0 : (byte) (afX | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & afW) != 0) {
                    this.mIsGif = true;
                }
                this.afY = wrap.getLong();
                if ((wrap.get() & afX) != 0) {
                    this.afZ = false;
                }
                return true;
            }
            return false;
        }
    }
}
