package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected a Kl;
    protected boolean Km;
    protected long Kn;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options mOptions;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.mOptions = null;
        this.Kl = null;
        this.Km = true;
        this.Kl = new a();
    }

    public void Z(boolean z) {
        this.Km = z;
    }

    public boolean isGif() {
        return this.Kl.mIsGif;
    }

    public void setGif(boolean z) {
        this.Kl.mIsGif = z;
    }

    public boolean isHighQuality() {
        return this.Kl.mIsHighQuality;
    }

    public void setHighQuality(boolean z) {
        this.Kl.mIsHighQuality = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.isGif(bArr)) {
            setGif(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null || !this.Km) {
            return null;
        }
        return this.Kl.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && this.Kl.paserFromByte(bArr)) {
            if (this.Kl.mValidTime == 0 || this.Kl.mValidTime >= System.currentTimeMillis()) {
                if (this.mOptions == null) {
                    this.mOptions = new BitmapFactory.Options();
                    this.mOptions.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.mOptions);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] getFormatedData() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void ll() {
        this.Kn = System.currentTimeMillis();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void lm() {
        com.baidu.adp.lib.e.a.f(isSuccess(), System.currentTimeMillis() - this.Kn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte GIF_FLAG = Byte.MIN_VALUE;
        private static byte HQ_FLAG = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long mValidTime = 0;
        boolean mIsHighQuality = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (GIF_FLAG | 0) : (byte) 0);
            allocate.putLong(this.mValidTime);
            allocate.put(this.mIsHighQuality ? (byte) 0 : (byte) (HQ_FLAG | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean paserFromByte(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & GIF_FLAG) != 0) {
                    this.mIsGif = true;
                }
                this.mValidTime = wrap.getLong();
                if ((wrap.get() & HQ_FLAG) != 0) {
                    this.mIsHighQuality = false;
                }
                return true;
            }
            return false;
        }
    }
}
