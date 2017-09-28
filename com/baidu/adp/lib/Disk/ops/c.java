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
    protected BitmapFactory.Options rt;
    protected a ru;

    public c(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        this.mBitmap = null;
        this.rt = null;
        this.ru = null;
        this.ru = new a();
    }

    public boolean isGif() {
        return this.ru.rx;
    }

    public void w(boolean z) {
        this.ru.rx = z;
    }

    public boolean ec() {
        return this.ru.rz;
    }

    public void x(boolean z) {
        this.ru.rz = z;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        super.setData(bArr);
        if (!isGif() && l.j(bArr)) {
            w(true);
        }
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] dQ() {
        if (this.mData == null) {
            return null;
        }
        return this.ru.toByteArray();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean h(byte[] bArr) {
        if (bArr != null && this.ru.i(bArr)) {
            if (this.ru.ry == 0 || this.ru.ry >= System.currentTimeMillis()) {
                if (this.rt == null) {
                    this.rt = new BitmapFactory.Options();
                    this.rt.inPreferredConfig = Bitmap.Config.RGB_565;
                }
                int headerSize = a.getHeaderSize();
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.rt);
                } catch (Error e) {
                    BdLog.e(e.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return false;
    }

    public byte[] ed() {
        int headerSize = a.getHeaderSize();
        byte[] bArr = new byte[this.mData.length - headerSize];
        System.arraycopy(this.mData, headerSize, bArr, 0, bArr.length);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        private static byte rv = Byte.MIN_VALUE;
        private static byte rw = Byte.MIN_VALUE;
        boolean rx = false;
        long ry = 0;
        boolean rz = true;

        a() {
        }

        public static int getHeaderSize() {
            return 14;
        }

        public byte[] toByteArray() {
            ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
            allocate.putInt(1786600511);
            allocate.put(this.rx ? (byte) (rv | 0) : (byte) 0);
            allocate.putLong(this.ry);
            allocate.put(this.rz ? (byte) 0 : (byte) (rw | 0));
            allocate.flip();
            return allocate.array();
        }

        public boolean i(byte[] bArr) {
            if (bArr == null || bArr.length < getHeaderSize()) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
            if (wrap.getInt() == 1786600511) {
                if ((wrap.get() & rv) != 0) {
                    this.rx = true;
                }
                this.ry = wrap.getLong();
                if ((wrap.get() & rw) != 0) {
                    this.rz = false;
                }
                return true;
            }
            return false;
        }
    }
}
