package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected a Io;
    protected boolean Ip;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options mOptions;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.mOptions = null;
        this.Io = null;
        this.Ip = true;
        this.Io = new a();
    }

    public void ab(boolean z) {
        this.Ip = z;
    }

    public boolean isGif() {
        return this.Io.mIsGif;
    }

    public void setGif(boolean z) {
        this.Io.mIsGif = z;
    }

    public boolean isHighQuality() {
        return this.Io.mIsHighQuality;
    }

    public void setHighQuality(boolean z) {
        this.Io.mIsHighQuality = z;
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
        if (this.mData == null || !this.Ip) {
            return null;
        }
        return this.Io.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && this.Io.paserFromByte(bArr)) {
            if (this.Io.mValidTime == 0 || this.Io.mValidTime >= System.currentTimeMillis()) {
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
