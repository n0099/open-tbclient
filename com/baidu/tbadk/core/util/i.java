package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class i extends DiskFileOperate {
    protected a YJ;
    protected BitmapFactory.Options kA;
    protected Bitmap mBitmap;

    public i(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.kA = null;
        this.YJ = null;
        this.YJ = new a();
    }

    public boolean cW() {
        return this.YJ.kE;
    }

    public void u(boolean z) {
        this.YJ.kE = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!cW() && com.baidu.adp.lib.util.k.m(bArr)) {
            u(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] cJ() {
        if (this.kl == null) {
            return null;
        }
        return this.YJ.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean k(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.kA == null) {
            this.kA = new BitmapFactory.Options();
            this.kA.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean l = this.YJ.l(bArr);
        if (this.YJ.kF == 0 || this.YJ.kF >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!l) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.kA);
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
        private static byte kC = Byte.MIN_VALUE;
        boolean kE = false;
        long kF = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.kE ? (byte) (0 | kC) : (byte) 0);
            allocate.putLong(this.kF);
            allocate.flip();
            return allocate.array();
        }

        public boolean l(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & kC) != 0) {
                    this.kE = true;
                }
                this.kF = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
