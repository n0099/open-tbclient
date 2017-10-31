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
    protected BitmapFactory.Options rv;
    protected a rw;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rv = null;
        this.rw = null;
        this.rw = new a();
    }

    public boolean isGif() {
        return this.rw.mIsGif;
    }

    public void w(boolean z) {
        this.rw.mIsGif = z;
    }

    public boolean ec() {
        return this.rw.rA;
    }

    public void x(boolean z) {
        this.rw.rA = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.j(bArr)) {
            w(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dQ() {
        if (this.mData == null) {
            return null;
        }
        return this.rw.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr != null && this.rw.i(bArr)) {
            if (this.rw.rz == 0 || this.rw.rz >= System.currentTimeMillis()) {
                if (this.rv == null) {
                    this.rv = new BitmapFactory.Options();
                    this.rv.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.rv);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] ed() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte rx = Byte.MIN_VALUE;
        private static byte ry = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long rz = 0;
        boolean rA = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (rx | 0) : (byte) 0);
            allocate.putLong(this.rz);
            allocate.put(this.rA ? (byte) 0 : (byte) (ry | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & rx) != 0) {
                    this.mIsGif = true;
                }
                this.rz = wrap.getLong();
                if ((wrap.get() & ry) != 0) {
                    this.rA = false;
                }
                return true;
            }
            return false;
        }
    }
}
