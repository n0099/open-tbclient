package com.baidu.tbadk.core.util;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class p {
    private static byte gg = Byte.MIN_VALUE;
    boolean gi = false;
    long gj = 0;

    public static int cn() {
        return 13;
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(cn());
        allocate.putInt(1786600510);
        allocate.put(this.gi ? (byte) (0 | gg) : (byte) 0);
        allocate.putLong(this.gj);
        allocate.flip();
        return allocate.array();
    }

    public boolean k(byte[] bArr) {
        if (bArr == null || bArr.length < cn()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, cn());
        if (wrap.getInt() == 1786600510) {
            if ((wrap.get() & gg) != 0) {
                this.gi = true;
            }
            this.gj = wrap.getLong();
            return true;
        }
        return false;
    }
}
