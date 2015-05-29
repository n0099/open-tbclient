package com.baidu.tbadk.core.util;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class l {
    private static byte rK = Byte.MIN_VALUE;
    boolean rM = false;
    long rN = 0;

    public static int fQ() {
        return 13;
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(fQ());
        allocate.putInt(1786600510);
        allocate.put(this.rM ? (byte) (0 | rK) : (byte) 0);
        allocate.putLong(this.rN);
        allocate.flip();
        return allocate.array();
    }

    public boolean l(byte[] bArr) {
        if (bArr == null || bArr.length < fQ()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fQ());
        if (wrap.getInt() == 1786600510) {
            if ((wrap.get() & rK) != 0) {
                this.rM = true;
            }
            this.rN = wrap.getLong();
            return true;
        }
        return false;
    }
}
