package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected Bitmap mBitmap;
    protected BitmapFactory.Options yK;
    protected a yL;
    protected boolean yM;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.yK = null;
        this.yL = null;
        this.yM = true;
        this.yL = new a();
    }

    public void H(boolean z) {
        this.yM = z;
    }

    public boolean isGif() {
        return this.yL.mIsGif;
    }

    public void I(boolean z) {
        this.yL.mIsGif = z;
    }

    public boolean hH() {
        return this.yL.yQ;
    }

    public void J(boolean z) {
        this.yL.yQ = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.s(bArr)) {
            I(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] hu() {
        if (this.mData == null || !this.yM) {
            return null;
        }
        return this.yL.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean q(byte[] bArr) {
        if (bArr != null && this.yL.r(bArr)) {
            if (this.yL.yP == 0 || this.yL.yP >= System.currentTimeMillis()) {
                if (this.yK == null) {
                    this.yK = new BitmapFactory.Options();
                    this.yK.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.yK);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] hI() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte yN = Byte.MIN_VALUE;
        private static byte yO = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long yP = 0;
        boolean yQ = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (yN | 0) : (byte) 0);
            allocate.putLong(this.yP);
            allocate.put(this.yQ ? (byte) 0 : (byte) (yO | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean r(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & yN) != 0) {
                    this.mIsGif = true;
                }
                this.yP = wrap.getLong();
                if ((wrap.get() & yO) != 0) {
                    this.yQ = false;
                }
                return true;
            }
            return false;
        }
    }
}
