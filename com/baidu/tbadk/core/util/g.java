package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class g extends DiskFileOperate {
    protected a afW;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options tE;

    public g(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.tE = null;
        this.afW = null;
        this.afW = new a();
    }

    public boolean isGif() {
        return this.afW.tI;
    }

    public void v(boolean z) {
        this.afW.tI = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && com.baidu.adp.lib.util.k.p(bArr)) {
            v(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] eb() {
        if (this.ts == null) {
            return null;
        }
        return this.afW.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean n(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.tE == null) {
            this.tE = new BitmapFactory.Options();
            this.tE.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean o = this.afW.o(bArr);
        if (this.afW.tJ == 0 || this.afW.tJ >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!o) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.tE);
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
        private static byte tG = Byte.MIN_VALUE;
        boolean tI = false;
        long tJ = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.tI ? (byte) (0 | tG) : (byte) 0);
            allocate.putLong(this.tJ);
            allocate.flip();
            return allocate.array();
        }

        public boolean o(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & tG) != 0) {
                    this.tI = true;
                }
                this.tJ = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
