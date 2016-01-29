package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class j extends DiskFileOperate {
    protected a aaS;
    protected Bitmap mBitmap;
    protected BitmapFactory.Options rN;

    public j(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rN = null;
        this.aaS = null;
        this.aaS = new a();
    }

    public boolean fN() {
        return this.aaS.rR;
    }

    public void r(boolean z) {
        this.aaS.rR = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!fN() && com.baidu.adp.lib.util.k.z(bArr)) {
            r(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] fB() {
        if (this.mData == null) {
            return null;
        }
        return this.aaS.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean x(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        if (this.rN == null) {
            this.rN = new BitmapFactory.Options();
            this.rN.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        boolean y = this.aaS.y(bArr);
        if (this.aaS.rS == 0 || this.aaS.rS >= System.currentTimeMillis()) {
            int fQ = a.fQ();
            if (!y) {
                fQ = 0;
            }
            try {
                this.mBitmap = BitmapFactory.decodeByteArray(bArr, fQ, bArr.length - fQ, this.rN);
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
        private static byte rP = Byte.MIN_VALUE;
        boolean rR = false;
        long rS = 0;

        a() {
        }

        public static int fQ() {
            return 13;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(fQ());
            allocate.putInt(1786600510);
            allocate.put(this.rR ? (byte) (0 | rP) : (byte) 0);
            allocate.putLong(this.rS);
            allocate.flip();
            return allocate.array();
        }

        public boolean y(byte[] bArr) {
            if (bArr == null || bArr.length < fQ()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fQ());
            if (wrap.getInt() == 1786600510) {
                if ((wrap.get() & rP) != 0) {
                    this.rR = true;
                }
                this.rS = wrap.getLong();
                return true;
            }
            return false;
        }
    }
}
