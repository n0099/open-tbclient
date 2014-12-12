package com.baidu.adp.lib.Disk.ops;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class d {
    private static byte ge = Byte.MIN_VALUE;
    private static byte gf = Byte.MIN_VALUE;
    boolean gg = false;
    long gh = 0;
    boolean gi = true;

    public static int cp() {
        return 14;
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(cp());
        allocate.putInt(1786600511);
        allocate.put(this.gg ? (byte) (ge | 0) : (byte) 0);
        allocate.putLong(this.gh);
        allocate.put(this.gi ? (byte) 0 : (byte) (gf | 0));
        allocate.flip();
        return allocate.array();
    }

    public boolean k(byte[] bArr) {
        if (bArr == null || bArr.length < cp()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, cp());
        if (wrap.getInt() == 1786600511) {
            if ((wrap.get() & ge) != 0) {
                this.gg = true;
            }
            this.gh = wrap.getLong();
            if ((wrap.get() & gf) != 0) {
                this.gi = false;
            }
            return true;
        }
        return false;
    }
}
