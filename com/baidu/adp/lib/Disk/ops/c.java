package com.baidu.adp.lib.Disk.ops;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class c extends DiskFileOperate {
    protected Bitmap mBitmap;
    protected BitmapFactory.Options tE;
    protected a tF;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.tE = null;
        this.tF = null;
        this.tF = new a();
    }

    public boolean isGif() {
        return this.tF.tI;
    }

    public void v(boolean z) {
        this.tF.tI = z;
    }

    public boolean eo() {
        return this.tF.tK;
    }

    public void w(boolean z) {
        this.tF.tK = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && k.p(bArr)) {
            v(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] eb() {
        if (this.ts == null) {
            return null;
        }
        return this.tF.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean n(byte[] bArr) {
        if (bArr != null && this.tF.o(bArr)) {
            if (this.tF.tJ == 0 || this.tF.tJ >= System.currentTimeMillis()) {
                if (this.tE == null) {
                    this.tE = new BitmapFactory.Options();
                    this.tE.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.tE);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] ep() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.ts.length - headerSize];
        System.arraycopy(this.ts, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte tG = Byte.MIN_VALUE;
        private static byte tH = Byte.MIN_VALUE;
        boolean tI = false;
        long tJ = 0;
        boolean tK = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.tI ? (byte) (tG | 0) : (byte) 0);
            allocate.putLong(this.tJ);
            allocate.put(this.tK ? (byte) 0 : (byte) (tH | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean o(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & tG) != 0) {
                    this.tI = true;
                }
                this.tJ = wrap.getLong();
                if ((wrap.get() & tH) != 0) {
                    this.tK = false;
                }
                return true;
            }
            return false;
        }
    }
}
