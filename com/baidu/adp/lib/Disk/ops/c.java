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
    protected BitmapFactory.Options sw;
    protected a sx;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.sw = null;
        this.sx = null;
        this.sx = new a();
    }

    public boolean ef() {
        return this.sx.sA;
    }

    public void v(boolean z) {
        this.sx.sA = z;
    }

    public boolean eg() {
        return this.sx.sC;
    }

    public void w(boolean z) {
        this.sx.sC = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!ef() && k.m(bArr)) {
            v(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dS() {
        if (this.sg == null) {
            return null;
        }
        return this.sx.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr != null && this.sx.l(bArr)) {
            if (this.sx.sB == 0 || this.sx.sB >= System.currentTimeMillis()) {
                if (this.sw == null) {
                    this.sw = new BitmapFactory.Options();
                    this.sw.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.sw);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] eh() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.sg.length - headerSize];
        System.arraycopy(this.sg, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte sy = Byte.MIN_VALUE;
        private static byte sz = Byte.MIN_VALUE;
        boolean sA = false;
        long sB = 0;
        boolean sC = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.sA ? (byte) (sy | 0) : (byte) 0);
            allocate.putLong(this.sB);
            allocate.put(this.sC ? (byte) 0 : (byte) (sz | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & sy) != 0) {
                    this.sA = true;
                }
                this.sB = wrap.getLong();
                if ((wrap.get() & sz) != 0) {
                    this.sC = false;
                }
                return true;
            }
            return false;
        }
    }
}
