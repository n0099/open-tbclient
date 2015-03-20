package com.baidu.adp.lib.Disk.ops;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class d {
    private static byte rA = Byte.MIN_VALUE;
    private static byte rB = Byte.MIN_VALUE;
    boolean rC = false;
    long rD = 0;
    boolean rE = true;

    public static int fL() {
        return 14;
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(fL());
        allocate.putInt(1786600511);
        allocate.put(this.rC ? (byte) (rA | 0) : (byte) 0);
        allocate.putLong(this.rD);
        allocate.put(this.rE ? (byte) 0 : (byte) (rB | 0));
        allocate.flip();
        return allocate.array();
    }

    public boolean l(byte[] bArr) {
        if (bArr == null || bArr.length < fL()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fL());
        if (wrap.getInt() == 1786600511) {
            if ((wrap.get() & rA) != 0) {
                this.rC = true;
            }
            this.rD = wrap.getLong();
            if ((wrap.get() & rB) != 0) {
                this.rE = false;
            }
            return true;
        }
        return false;
    }
}
