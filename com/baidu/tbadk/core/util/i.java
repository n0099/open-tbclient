package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class i extends DiskFileOperate {
    protected a aem;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rR;

    public i(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rR = null;
        this.aem = null;
        this.aem = new a();
    }

    public boolean ee() {
        return this.aem.rV;
    }

    public void v(boolean z) {
        this.aem.rV = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!ee() && com.baidu.adp.lib.util.k.m(bArr)) {
            v(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dR() {
        if (this.rF == null) {
            return null;
        }
        return this.aem.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.rR == null) {
            this.rR = new BitmapFactory.Options();
            this.rR.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean l = this.aem.l(bArr);
        if (this.aem.rW == 0 || this.aem.rW >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!l) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.rR);
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
        private static byte rT = Byte.MIN_VALUE;
        boolean rV = false;
        long rW = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.rV ? (byte) (0 | rT) : (byte) 0);
            allocate.putLong(this.rW);
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & rT) != 0) {
                    this.rV = true;
                }
                this.rW = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
