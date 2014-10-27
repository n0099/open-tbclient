package com.baidu.tbadk.core.util;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class p {
    private static byte ec = Byte.MIN_VALUE;
    boolean ee = false;
    long ef = 0;

    public static int bP() {
        return 13;
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(bP());
        allocate.putInt(1786600510);
        allocate.put(this.ee ? (byte) (0 | ec) : (byte) 0);
        allocate.putLong(this.ef);
        allocate.flip();
        return allocate.array();
    }

    public boolean j(byte[] bArr) {
        if (bArr == null || bArr.length < bP()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, bP());
        if (wrap.getInt() == 1786600510) {
            if ((wrap.get() & ec) != 0) {
                this.ee = true;
            }
            this.ef = wrap.getLong();
            return true;
        }
        return false;
    }
}
