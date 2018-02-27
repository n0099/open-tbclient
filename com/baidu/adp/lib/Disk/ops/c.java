package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected BitmapFactory.Options afO;
    protected a afP;
    protected Bitmap mBitmap;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.afO = null;
        this.afP = null;
        this.afP = new a();
    }

    public boolean isGif() {
        return this.afP.mIsGif;
    }

    public void af(boolean z) {
        this.afP.mIsGif = z;
    }

    public boolean lH() {
        return this.afP.afT;
    }

    public void ag(boolean z) {
        this.afP.afT = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.j(bArr)) {
            af(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] lu() {
        if (this.mData == null) {
            return null;
        }
        return this.afP.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr != null && this.afP.i(bArr)) {
            if (this.afP.afS == 0 || this.afP.afS >= System.currentTimeMillis()) {
                if (this.afO == null) {
                    this.afO = new BitmapFactory.Options();
                    this.afO.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.afO);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] lI() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte afQ = Byte.MIN_VALUE;
        private static byte afR = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long afS = 0;
        boolean afT = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (afQ | 0) : (byte) 0);
            allocate.putLong(this.afS);
            allocate.put(this.afT ? (byte) 0 : (byte) (afR | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & afQ) != 0) {
                    this.mIsGif = true;
                }
                this.afS = wrap.getLong();
                if ((wrap.get() & afR) != 0) {
                    this.afT = false;
                }
                return true;
            }
            return false;
        }
    }
}
