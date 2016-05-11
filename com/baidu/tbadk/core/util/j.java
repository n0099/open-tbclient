package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class j extends DiskFileOperate {
    protected a VD;
    protected BitmapFactory.Options hK;
    protected Bitmap mBitmap;

    public j(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.hK = null;
        this.VD = null;
        this.VD = new a();
    }

    public boolean cd() {
        return this.VD.hO;
    }

    public void q(boolean z) {
        this.VD.hO = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!cd() && com.baidu.adp.lib.util.k.j(bArr)) {
            q(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] bQ() {
        if (this.hx == null) {
            return null;
        }
        return this.VD.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.hK == null) {
            this.hK = new BitmapFactory.Options();
            this.hK.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean i = this.VD.i(bArr);
        if (this.VD.hP == 0 || this.VD.hP >= System.currentTimeMillis()) {
            int headerSize = a.getHeaderSize();
            if (!i) {
                headerSize = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.hK);
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
        private static byte hM = Byte.MIN_VALUE;
        boolean hO = false;
        long hP = 0;

        a() {
        }

        public static int getHeaderSize() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600510);
            allocate.put(this.hO ? (byte) (0 | hM) : (byte) 0);
            allocate.putLong(this.hP);
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & hM) != 0) {
                    this.hO = true;
                }
                this.hP = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
