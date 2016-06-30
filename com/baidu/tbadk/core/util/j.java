package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class j extends DiskFileOperate {
    protected a VT;
    protected BitmapFactory.Options hJ;
    protected Bitmap mBitmap;

    public j(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.hJ = null;
        this.VT = null;
        this.VT = new a();
    }

    public boolean ce() {
        return this.VT.hN;
    }

    public void q(boolean z) {
        this.VT.hN = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!ce() && com.baidu.adp.lib.util.k.j(bArr)) {
            q(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] bR() {
        if (this.hw == null) {
            return null;
        }
        return this.VT.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.hJ == null) {
            this.hJ = new BitmapFactory.Options();
            this.hJ.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean i = this.VT.i(bArr);
        if (this.VT.hO == 0 || this.VT.hO >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!i) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.hJ);
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
        private static byte hL = Byte.MIN_VALUE;
        boolean hN = false;
        long hO = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.hN ? (byte) (0 | hL) : (byte) 0);
            allocate.putLong(this.hO);
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & hL) != 0) {
                    this.hN = true;
                }
                this.hO = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
