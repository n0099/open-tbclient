package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class h extends DiskFileOperate {
    protected a cYB;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options mOptions;

    public h(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.mOptions = null;
        this.cYB = null;
        this.cYB = new a();
    }

    public boolean isGif() {
        return this.cYB.mIsGif;
    }

    public void setGif(boolean z) {
        this.cYB.mIsGif = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.l.isGif(bArr)) {
            setGif(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        if (this.mData == null) {
            return null;
        }
        return this.cYB.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.mOptions == null) {
            this.mOptions = new BitmapFactory.Options();
            this.mOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean paserFromByte = this.cYB.paserFromByte(bArr);
        if (this.cYB.mValidTime == 0 || this.cYB.mValidTime >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!paserFromByte) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.mOptions);
            } catch (Error e) {
                BdLog.e(e.getMessage());
            }
            return this.mBitmap != null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte GIF_FLAG = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long mValidTime = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | GIF_FLAG) : (byte) 0);
            allocate.putLong(this.mValidTime);
            allocate.flip();
            return allocate.array();
        }

        public boolean paserFromByte(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & GIF_FLAG) != 0) {
                    this.mIsGif = true;
                }
                this.mValidTime = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
