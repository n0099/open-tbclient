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
    protected BitmapFactory.Options rX;
    protected a rY;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rX = null;
        this.rY = null;
        this.rY = new a();
    }

    public boolean fO() {
        return this.rY.sb;
    }

    public void q(boolean z) {
        this.rY.sb = z;
    }

    public boolean fP() {
        return this.rY.sd;
    }

    public void r(boolean z) {
        this.rY.sd = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fO() && k.j(bArr)) {
            q(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] fC() {
        if (this.rK == null) {
            return null;
        }
        return this.rY.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr != null && this.rY.i(bArr)) {
            if (this.rY.sc == 0 || this.rY.sc >= System.currentTimeMillis()) {
                if (this.rX == null) {
                    this.rX = new BitmapFactory.Options();
                    this.rX.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.rX);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] fQ() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.rK.length - headerSize];
        System.arraycopy(this.rK, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte rZ = Byte.MIN_VALUE;
        private static byte sa = Byte.MIN_VALUE;
        boolean sb = false;
        long sc = 0;
        boolean sd = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.sb ? (byte) (rZ | 0) : (byte) 0);
            allocate.putLong(this.sc);
            allocate.put(this.sd ? (byte) 0 : (byte) (sa | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & rZ) != 0) {
                    this.sb = true;
                }
                this.sc = wrap.getLong();
                if ((wrap.get() & sa) != 0) {
                    this.sd = false;
                }
                return true;
            }
            return false;
        }
    }
}
