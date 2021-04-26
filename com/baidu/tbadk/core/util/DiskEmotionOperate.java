package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import d.a.c.e.p.l;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class DiskEmotionOperate extends DiskFileOperate {
    public Bitmap mBitmap;
    public DiskPicHeader mDiskPicHeader;
    public BitmapFactory.Options mOptions;

    /* loaded from: classes3.dex */
    public static class DiskPicHeader {
        public static byte GIF_FLAG = Byte.MIN_VALUE;
        public static final int MAGIC_DIGIT = 1786600510;
        public boolean mIsGif = false;
        public long mValidTime = 0;

        public static int getHeaderSize() {
            return 13;
        }

        public boolean paserFromByte(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() != 1786600510) {
                return false;
            }
            if ((wrap.get() & GIF_FLAG) != 0) {
                this.mIsGif = true;
            }
            this.mValidTime = wrap.getLong();
            return true;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(MAGIC_DIGIT);
            allocate.put(this.mIsGif ? (byte) (GIF_FLAG | 0) : (byte) 0);
            allocate.putLong(this.mValidTime);
            allocate.flip();
            return allocate.array();
        }
    }

    public DiskEmotionOperate(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.mOptions = null;
        this.mDiskPicHeader = null;
        this.mDiskPicHeader = new DiskPicHeader();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null) {
            return null;
        }
        return this.mDiskPicHeader.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.mOptions == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            this.mOptions = options;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean paserFromByte = this.mDiskPicHeader.paserFromByte(bArr);
        long j = this.mDiskPicHeader.mValidTime;
        if (j == 0 || j >= System.currentTimeMillis()) {
            int headerSize = DiskPicHeader.getHeaderSize();
            if (!paserFromByte) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.mOptions);
            } catch (Error e2) {
                BdLog.e(e2.getMessage());
            }
            return this.mBitmap != null;
        }
        return false;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public BitmapFactory.Options getOptions() {
        return this.mOptions;
    }

    public long getValidTime() {
        return this.mDiskPicHeader.mValidTime;
    }

    public boolean isGif() {
        return this.mDiskPicHeader.mIsGif;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (isGif() || !l.B(bArr)) {
            return;
        }
        setGif(true);
    }

    public void setGif(boolean z) {
        this.mDiskPicHeader.mIsGif = z;
    }

    public void setOptions(BitmapFactory.Options options) {
        this.mOptions = options;
    }

    public void setValidTime(long j) {
        this.mDiskPicHeader.mValidTime = j;
    }
}
