package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class g extends DiskFileOperate {
    protected a agi;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options qj;

    public g(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.qj = null;
        this.agi = null;
        this.agi = new a();
    }

    public boolean isGif() {
        return this.agi.mIsGif;
    }

    public void y(boolean z) {
        this.agi.mIsGif = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.l.l(bArr)) {
            y(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dy() {
        if (this.mData == null) {
            return null;
        }
        return this.agi.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.qj == null) {
            this.qj = new BitmapFactory.Options();
            this.qj.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean k = this.agi.k(bArr);
        if (this.agi.qo == 0 || this.agi.qo >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!k) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.qj);
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
        private static byte qm = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long qo = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.mIsGif ? (byte) (0 | qm) : (byte) 0);
            allocate.putLong(this.qo);
            allocate.flip();
            return allocate.array();
        }

        public boolean k(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & qm) != 0) {
                    this.mIsGif = true;
                }
                this.qo = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
