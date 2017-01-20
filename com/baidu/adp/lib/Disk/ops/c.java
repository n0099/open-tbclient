package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options kA;
    protected a kB;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.kA = null;
        this.kB = null;
        this.kB = new a();
    }

    public boolean cW() {
        return this.kB.kE;
    }

    public void u(boolean z) {
        this.kB.kE = z;
    }

    public boolean cX() {
        return this.kB.kG;
    }

    public void v(boolean z) {
        this.kB.kG = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!cW() && k.m(bArr)) {
            u(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] cJ() {
        if (this.kl == null) {
            return null;
        }
        return this.kB.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr != null && this.kB.l(bArr)) {
            if (this.kB.kF == 0 || this.kB.kF >= System.currentTimeMillis()) {
                if (this.kA == null) {
                    this.kA = new BitmapFactory.Options();
                    this.kA.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.kA);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] cY() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.kl.length - headerSize];
        System.arraycopy(this.kl, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte kC = Byte.MIN_VALUE;
        private static byte kD = Byte.MIN_VALUE;
        boolean kE = false;
        long kF = 0;
        boolean kG = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.kE ? (byte) (kC | 0) : (byte) 0);
            allocate.putLong(this.kF);
            allocate.put(this.kG ? (byte) 0 : (byte) (kD | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & kC) != 0) {
                    this.kE = true;
                }
                this.kF = wrap.getLong();
                if ((wrap.get() & kD) != 0) {
                    this.kG = false;
                }
                return true;
            }
            return false;
        }
    }
}
