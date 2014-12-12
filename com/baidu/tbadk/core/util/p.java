package com.baidu.tbadk.core.util;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class p {
    private static byte ge = Byte.MIN_VALUE;
    boolean gg = false;
    long gh = 0;

    public static int cp() {
        return 13;
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(cp());
        allocate.putInt(1786600510);
        allocate.put(this.gg ? (byte) (0 | ge) : (byte) 0);
        allocate.putLong(this.gh);
        allocate.flip();
        return allocate.array();
    }

    public boolean k(byte[] bArr) {
        if (bArr == null || bArr.length < cp()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, cp());
        if (wrap.getInt() == 1786600510) {
            if ((wrap.get() & ge) != 0) {
                this.gg = true;
            }
            this.gh = wrap.getLong();
            return true;
        }
        return false;
    }
}
