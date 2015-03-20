package com.baidu.tbadk.core.util;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class l {
    private static byte rA = Byte.MIN_VALUE;
    boolean rC = false;
    long rD = 0;

    public static int fL() {
        return 13;
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(fL());
        allocate.putInt(1786600510);
        allocate.put(this.rC ? (byte) (0 | rA) : (byte) 0);
        allocate.putLong(this.rD);
        allocate.flip();
        return allocate.array();
    }

    public boolean l(byte[] bArr) {
        if (bArr == null || bArr.length < fL()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fL());
        if (wrap.getInt() == 1786600510) {
            if ((wrap.get() & rA) != 0) {
                this.rC = true;
            }
            this.rD = wrap.getLong();
            return true;
        }
        return false;
    }
}
