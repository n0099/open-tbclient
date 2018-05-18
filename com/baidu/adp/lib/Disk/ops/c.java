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
    protected BitmapFactory.Options qj;
    protected a ql;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.qj = null;
        this.ql = null;
        this.ql = new a();
    }

    public boolean isGif() {
        return this.ql.mIsGif;
    }

    public void y(boolean z) {
        this.ql.mIsGif = z;
    }

    public boolean dL() {
        return this.ql.qp;
    }

    public void z(boolean z) {
        this.ql.qp = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.l(bArr)) {
            y(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dy() {
        if (this.mData == null) {
            return null;
        }
        return this.ql.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean j(byte[] bArr) {
        if (bArr != null && this.ql.k(bArr)) {
            if (this.ql.qo == 0 || this.ql.qo >= System.currentTimeMillis()) {
                if (this.qj == null) {
                    this.qj = new BitmapFactory.Options();
                    this.qj.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.qj);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] dM() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte qm = Byte.MIN_VALUE;
        private static byte qn = Byte.MIN_VALUE;
        boolean mIsGif = false;
        long qo = 0;
        boolean qp = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.mIsGif ? (byte) (qm | 0) : (byte) 0);
            allocate.putLong(this.qo);
            allocate.put(this.qp ? (byte) 0 : (byte) (qn | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean k(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & qm) != 0) {
                    this.mIsGif = true;
                }
                this.qo = wrap.getLong();
                if ((wrap.get() & qn) != 0) {
                    this.qp = false;
                }
                return true;
            }
            return false;
        }
    }
}
