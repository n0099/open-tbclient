package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class j extends DiskFileOperate {
    protected a aab;
    protected BitmapFactory.Options kH;
    protected Bitmap mBitmap;

    public j(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.kH = null;
        this.aab = null;
        this.aab = new a();
    }

    public boolean cY() {
        return this.aab.kL;
    }

    public void u(boolean z) {
        this.aab.kL = z;
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
        if (this.ks == null) {
            return null;
        }
        return this.aab.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.kH == null) {
            this.kH = new BitmapFactory.Options();
            this.kH.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean l = this.aab.l(bArr);
        if (this.aab.kM == 0 || this.aab.kM >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!l) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.kH);
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
        private static byte kJ = Byte.MIN_VALUE;
        boolean kL = false;
        long kM = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.kL ? (byte) (0 | kJ) : (byte) 0);
            allocate.putLong(this.kM);
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & kJ) != 0) {
                    this.kL = true;
                }
                this.kM = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
