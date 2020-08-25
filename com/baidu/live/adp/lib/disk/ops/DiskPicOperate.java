package com.baidu.live.adp.lib.disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.live.adp.lib.disk.ops.DiskFileOperate;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class DiskPicOperate extends DiskFileOperate {
    protected Bitmap mBitmap;
    protected DiskPicHeader mDiskPicHeader;
    protected BitmapFactory.Options mOptions;

    public DiskPicOperate(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.mOptions = null;
        this.mDiskPicHeader = null;
        this.mDiskPicHeader = new DiskPicHeader();
    }

    public BitmapFactory.Options getOptions() {
        return this.mOptions;
    }

    public void setOptions(BitmapFactory.Options options) {
        this.mOptions = options;
    }

    public boolean isGif() {
        return this.mDiskPicHeader.mIsGif;
    }

    public void setGif(boolean z) {
        this.mDiskPicHeader.mIsGif = z;
    }

    public void setValidTime(long j) {
        this.mDiskPicHeader.mValidTime = j;
    }

    public long getValidTime() {
        return this.mDiskPicHeader.mValidTime;
    }

    public boolean isHighQuality() {
        return this.mDiskPicHeader.mIsHighQuality;
    }

    public void setHighQuality(boolean z) {
        this.mDiskPicHeader.mIsHighQuality = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.live.adp.lib.disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && BdUtilHelper.isGif(bArr)) {
            setGif(true);
        }
    }

    @Override // com.baidu.live.adp.lib.disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null) {
            return null;
        }
        return this.mDiskPicHeader.toByteArray();
    }

    @Override // com.baidu.live.adp.lib.disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr != null && this.mDiskPicHeader.paserFromByte(bArr)) {
            if (this.mDiskPicHeader.mValidTime == 0 || this.mDiskPicHeader.mValidTime >= System.currentTimeMillis()) {
                if (this.mOptions == null) {
                    this.mOptions = new BitmapFactory.Options();
                    this.mOptions.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = DiskPicHeader.getHeaderSize();
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
        int headerSize = DiskPicHeader.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class DiskPicHeader {
        private static byte GIF_FLAG = Byte.MIN_VALUE;
        private static byte HQ_FLAG = Byte.MIN_VALUE;
        private static final int MAGIC_DIGIT = 1786600511;
        boolean mIsGif = false;
        long mValidTime = 0;
        boolean mIsHighQuality = true;

        DiskPicHeader() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(MAGIC_DIGIT);
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
            if (wrap.getInt() == MAGIC_DIGIT) {
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
