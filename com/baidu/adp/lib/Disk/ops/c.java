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
    protected BitmapFactory.Options rR;
    protected a rS;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rR = null;
        this.rS = null;
        this.rS = new a();
    }

    public boolean ee() {
        return this.rS.rV;
    }

    public void v(boolean z) {
        this.rS.rV = z;
    }

    public boolean ef() {
        return this.rS.rX;
    }

    public void w(boolean z) {
        this.rS.rX = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!ee() && k.m(bArr)) {
            v(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dR() {
        if (this.rF == null) {
            return null;
        }
        return this.rS.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr != null && this.rS.l(bArr)) {
            if (this.rS.rW == 0 || this.rS.rW >= System.currentTimeMillis()) {
                if (this.rR == null) {
                    this.rR = new BitmapFactory.Options();
                    this.rR.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.rR);
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
        byte[] bArr = new byte[this.rF.length - headerSize];
        System.arraycopy(this.rF, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte rT = Byte.MIN_VALUE;
        private static byte rU = Byte.MIN_VALUE;
        boolean rV = false;
        long rW = 0;
        boolean rX = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.rV ? (byte) (rT | 0) : (byte) 0);
            allocate.putLong(this.rW);
            allocate.put(this.rX ? (byte) 0 : (byte) (rU | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & rT) != 0) {
                    this.rV = true;
                }
                this.rW = wrap.getLong();
                if ((wrap.get() & rU) != 0) {
                    this.rX = false;
                }
                return true;
            }
            return false;
        }
    }
}
