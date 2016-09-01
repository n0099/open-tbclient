package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options kG;
    protected a kH;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.kG = null;
        this.kH = null;
        this.kH = new a();
    }

    public boolean cY() {
        return this.kH.kK;
    }

    public void u(boolean z) {
        this.kH.kK = z;
    }

    public boolean cZ() {
        return this.kH.kM;
    }

    public void v(boolean z) {
        this.kH.kM = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!cY() && k.m(bArr)) {
            u(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] cL() {
        if (this.kr == null) {
            return null;
        }
        return this.kH.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr != null && this.kH.l(bArr)) {
            if (this.kH.kL == 0 || this.kH.kL >= System.currentTimeMillis()) {
                if (this.kG == null) {
                    this.kG = new BitmapFactory.Options();
                    this.kG.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.kG);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] da() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.kr.length - headerSize];
        System.arraycopy(this.kr, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte kI = Byte.MIN_VALUE;
        private static byte kJ = Byte.MIN_VALUE;
        boolean kK = false;
        long kL = 0;
        boolean kM = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.kK ? (byte) (kI | 0) : (byte) 0);
            allocate.putLong(this.kL);
            allocate.put(this.kM ? (byte) 0 : (byte) (kJ | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & kI) != 0) {
                    this.kK = true;
                }
                this.kL = wrap.getLong();
                if ((wrap.get() & kJ) != 0) {
                    this.kM = false;
                }
                return true;
            }
            return false;
        }
    }
}
