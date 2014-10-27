package com.baidu.adp.lib.Disk.ops;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class d {
    private static byte ec = Byte.MIN_VALUE;
    private static byte ed = Byte.MIN_VALUE;
    boolean ee = false;
    long ef = 0;
    boolean eg = true;

    public static int bP() {
        return 14;
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(bP());
        allocate.putInt(1786600511);
        allocate.put(this.ee ? (byte) (ec | 0) : (byte) 0);
        allocate.putLong(this.ef);
        allocate.put(this.eg ? (byte) 0 : (byte) (ed | 0));
        allocate.flip();
        return allocate.array();
    }

    public boolean j(byte[] bArr) {
        if (bArr == null || bArr.length < bP()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, bP());
        if (wrap.getInt() == 1786600511) {
            if ((wrap.get() & ec) != 0) {
                this.ee = true;
            }
            this.ef = wrap.getLong();
            if ((wrap.get() & ed) != 0) {
                this.eg = false;
            }
            return true;
        }
        return false;
    }
}
