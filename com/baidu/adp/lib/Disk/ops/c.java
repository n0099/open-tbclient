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
    protected BitmapFactory.Options ws;
    protected a wt;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.ws = null;
        this.wt = null;
        this.wt = new a();
    }

    public boolean isGif() {
        return this.wt.mIsGif;
    }

    public void y(boolean z) {
        this.wt.mIsGif = z;
    }

    public boolean gB() {
        return this.wt.wx;
    }

    public void z(boolean z) {
        this.wt.wx = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.k(bArr)) {
            y(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] gn() {
        if (this.mData == null) {
            return null;
        }
        return this.wt.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean i(byte[] bArr) {
        if (bArr != null && this.wt.j(bArr)) {
            if (this.wt.ww == 0 || this.wt.ww >= System.currentTimeMillis()) {
                if (this.ws == null) {
                    this.ws = new BitmapFactory.Options();
                    this.ws.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.ws);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] gC() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte wu = Byte.MIN_VALUE;
        private static byte wv = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long ww = 0;
        boolean wx = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (wu | 0) : (byte) 0);
            allocate.putLong(this.ww);
            allocate.put(this.wx ? (byte) 0 : (byte) (wv | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean j(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & wu) != 0) {
                    this.mIsGif = true;
                }
                this.ww = wrap.getLong();
                if ((wrap.get() & wv) != 0) {
                    this.wx = false;
                }
                return true;
            }
            return false;
        }
    }
}
