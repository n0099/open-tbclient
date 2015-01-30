package com.baidu.adp.lib.Disk.ops;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class d {
    private static byte gg = Byte.MIN_VALUE;
    private static byte gh = Byte.MIN_VALUE;
    boolean gi = false;
    long gj = 0;
    boolean gk = true;

    public static int cn() {
        return 14;
    }

    public byte[] toByteArray() {
        ByteBuffer allocate = ByteBuffer.allocate(cn());
        allocate.putInt(1786600511);
        allocate.put(this.gi ? (byte) (gg | 0) : (byte) 0);
        allocate.putLong(this.gj);
        allocate.put(this.gk ? (byte) 0 : (byte) (gh | 0));
        allocate.flip();
        return allocate.array();
    }

    public boolean k(byte[] bArr) {
        if (bArr == null || bArr.length < cn()) {
            return false;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, cn());
        if (wrap.getInt() == 1786600511) {
            if ((wrap.get() & gg) != 0) {
                this.gi = true;
            }
            this.gj = wrap.getLong();
            if ((wrap.get() & gh) != 0) {
                this.gk = false;
            }
            return true;
        }
        return false;
    }
}
