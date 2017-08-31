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
    protected BitmapFactory.Options rs;
    protected a rt;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rs = null;
        this.rt = null;
        this.rt = new a();
    }

    public boolean isGif() {
        return this.rt.rw;
    }

    public void w(boolean z) {
        this.rt.rw = z;
    }

    public boolean ed() {
        return this.rt.ry;
    }

    public void x(boolean z) {
        this.rt.ry = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && k.j(bArr)) {
            w(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dR() {
        if (this.mData == null) {
            return null;
        }
        return this.rt.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr != null && this.rt.i(bArr)) {
            if (this.rt.rx == 0 || this.rt.rx >= System.currentTimeMillis()) {
                if (this.rs == null) {
                    this.rs = new BitmapFactory.Options();
                    this.rs.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.rs);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] ee() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte ru = Byte.MIN_VALUE;
        private static byte rv = Byte.MIN_VALUE;
        boolean rw = false;
        long rx = 0;
        boolean ry = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.rw ? (byte) (ru | 0) : (byte) 0);
            allocate.putLong(this.rx);
            allocate.put(this.ry ? (byte) 0 : (byte) (rv | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & ru) != 0) {
                    this.rw = true;
                }
                this.rx = wrap.getLong();
                if ((wrap.get() & rv) != 0) {
                    this.ry = false;
                }
                return true;
            }
            return false;
        }
    }
}
