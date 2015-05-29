package com.baidu.adp.lib.Disk.ops;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class d {
    private static byte rK = Byte.MIN_VALUE;
    private static byte rL = Byte.MIN_VALUE;
    boolean rM = false;
    long rN = 0;
    boolean rO = true;

    public static int fQ() {
        return 14;
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(fQ());
        allocate.putInt(1786600511);
        allocate.put(this.rM ? (byte) (rK | 0) : (byte) 0);
        allocate.putLong(this.rN);
        allocate.put(this.rO ? (byte) 0 : (byte) (rL | 0));
        allocate.flip();
        return allocate.array();
    }

    public boolean l(byte[] bArr) {
        if (bArr == null || bArr.length < fQ()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fQ());
        if (wrap.getInt() == 1786600511) {
            if ((wrap.get() & rK) != 0) {
                this.rM = true;
            }
            this.rN = wrap.getLong();
            if ((wrap.get() & rL) != 0) {
                this.rO = false;
            }
            return true;
        }
        return false;
    }
}
