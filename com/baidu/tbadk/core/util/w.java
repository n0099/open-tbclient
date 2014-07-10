package com.baidu.tbadk.core.util;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class w {
    private static byte c = Byte.MIN_VALUE;
    boolean a = false;
    long b = 0;

    public static int a() {
        return 13;
    }

    public byte[] b() {
        ByteBuffer allocate = ByteBuffer.allocate(a());
        allocate.putInt(1786600510);
        allocate.put(this.a ? (byte) (0 | c) : (byte) 0);
        allocate.putLong(this.b);
        allocate.flip();
        return allocate.array();
    }

    public boolean a(byte[] bArr) {
        if (bArr == null || bArr.length < a()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, a());
        if (wrap.getInt() == 1786600510) {
            if ((wrap.get() & c) != 0) {
                this.a = true;
            }
            this.b = wrap.getLong();
            return true;
        }
        return false;
    }
}
