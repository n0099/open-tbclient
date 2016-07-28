package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options im;
    protected a io;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.im = null;
        this.io = null;
        this.io = new a();
    }

    public boolean cd() {
        return this.io.iu;
    }

    public void s(boolean z) {
        this.io.iu = z;
    }

    public boolean ce() {
        return this.io.ix;
    }

    public void t(boolean z) {
        this.io.ix = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!cd() && k.m(bArr)) {
            s(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] bQ() {
        if (this.hY == null) {
            return null;
        }
        return this.io.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr != null && this.io.l(bArr)) {
            if (this.io.iw == 0 || this.io.iw >= System.currentTimeMillis()) {
                if (this.im == null) {
                    this.im = new BitmapFactory.Options();
                    this.im.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.im);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] cf() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.hY.length - headerSize];
        System.arraycopy(this.hY, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte iq = Byte.MIN_VALUE;
        private static byte ir = Byte.MIN_VALUE;
        boolean iu = false;
        long iw = 0;
        boolean ix = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.iu ? (byte) (iq | 0) : (byte) 0);
            allocate.putLong(this.iw);
            allocate.put(this.ix ? (byte) 0 : (byte) (ir | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & iq) != 0) {
                    this.iu = true;
                }
                this.iw = wrap.getLong();
                if ((wrap.get() & ir) != 0) {
                    this.ix = false;
                }
                return true;
            }
            return false;
        }
    }
}
