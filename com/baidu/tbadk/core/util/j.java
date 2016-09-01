package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class j extends DiskFileOperate {
    protected a Zq;
    protected BitmapFactory.Options kG;
    protected Bitmap mBitmap;

    public j(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.kG = null;
        this.Zq = null;
        this.Zq = new a();
    }

    public boolean cY() {
        return this.Zq.kK;
    }

    public void u(boolean z) {
        this.Zq.kK = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!cY() && com.baidu.adp.lib.util.k.m(bArr)) {
            u(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] cL() {
        if (this.kr == null) {
            return null;
        }
        return this.Zq.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.kG == null) {
            this.kG = new BitmapFactory.Options();
            this.kG.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean l = this.Zq.l(bArr);
        if (this.Zq.kL == 0 || this.Zq.kL >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!l) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.kG);
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
        private static byte kI = Byte.MIN_VALUE;
        boolean kK = false;
        long kL = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.kK ? (byte) (0 | kI) : (byte) 0);
            allocate.putLong(this.kL);
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & kI) != 0) {
                    this.kK = true;
                }
                this.kL = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
