package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options hJ;
    protected a hK;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.hJ = null;
        this.hK = null;
        this.hK = new a();
    }

    public boolean ce() {
        return this.hK.hN;
    }

    public void q(boolean z) {
        this.hK.hN = z;
    }

    public boolean cf() {
        return this.hK.hP;
    }

    public void r(boolean z) {
        this.hK.hP = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!ce() && k.j(bArr)) {
            q(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] bR() {
        if (this.hw == null) {
            return null;
        }
        return this.hK.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr != null && this.hK.i(bArr)) {
            if (this.hK.hO == 0 || this.hK.hO >= System.currentTimeMillis()) {
                if (this.hJ == null) {
                    this.hJ = new BitmapFactory.Options();
                    this.hJ.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.hJ);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] cg() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.hw.length - headerSize];
        System.arraycopy(this.hw, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte hL = Byte.MIN_VALUE;
        private static byte hM = Byte.MIN_VALUE;
        boolean hN = false;
        long hO = 0;
        boolean hP = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.hN ? (byte) (hL | 0) : (byte) 0);
            allocate.putLong(this.hO);
            allocate.put(this.hP ? (byte) 0 : (byte) (hM | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & hL) != 0) {
                    this.hN = true;
                }
                this.hO = wrap.getLong();
                if ((wrap.get() & hM) != 0) {
                    this.hP = false;
                }
                return true;
            }
            return false;
        }
    }
}
