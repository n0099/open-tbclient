package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rW;
    protected a rX;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rW = null;
        this.rX = null;
        this.rX = new a();
    }

    public boolean isGif() {
        return this.rX.sa;
    }

    public void v(boolean z) {
        this.rX.sa = z;
    }

    public boolean ef() {
        return this.rX.sc;
    }

    public void w(boolean z) {
        this.rX.sc = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && k.m(bArr)) {
            v(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dS() {
        if (this.rK == null) {
            return null;
        }
        return this.rX.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr != null && this.rX.l(bArr)) {
            if (this.rX.sb == 0 || this.rX.sb >= System.currentTimeMillis()) {
                if (this.rW == null) {
                    this.rW = new BitmapFactory.Options();
                    this.rW.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.rW);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] eg() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.rK.length - headerSize];
        System.arraycopy(this.rK, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte rY = Byte.MIN_VALUE;
        private static byte rZ = Byte.MIN_VALUE;
        boolean sa = false;
        long sb = 0;
        boolean sc = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.sa ? (byte) (rY | 0) : (byte) 0);
            allocate.putLong(this.sb);
            allocate.put(this.sc ? (byte) 0 : (byte) (rZ | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & rY) != 0) {
                    this.sa = true;
                }
                this.sb = wrap.getLong();
                if ((wrap.get() & rZ) != 0) {
                    this.sc = false;
                }
                return true;
            }
            return false;
        }
    }
}
