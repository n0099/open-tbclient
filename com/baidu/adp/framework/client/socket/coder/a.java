package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte ge = Byte.MIN_VALUE;
    private static byte gf = 64;
    private static byte gg = 8;
    private boolean gh = false;
    private boolean gi = false;
    private boolean gj = false;
    private int gk;
    private int gl;

    public static int aZ() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + aZ());
        byte b = z ? (byte) (ge | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | gf);
        }
        allocate.put((byte) (b | gg));
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static a h(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, aZ());
        a aVar = new a();
        byte b = wrap.get();
        if ((ge & b) != 0) {
            aVar.gh = true;
        }
        if ((gf & b) != 0) {
            aVar.gi = true;
        }
        if ((b & gg) != 0) {
            aVar.gj = true;
        }
        aVar.gk = wrap.getInt();
        aVar.gl = wrap.getInt();
        return aVar;
    }

    public boolean ba() {
        return this.gi;
    }

    public int bb() {
        return this.gk;
    }

    public boolean bc() {
        return this.gh;
    }

    public int bd() {
        return this.gl;
    }

    public boolean be() {
        return this.gj;
    }
}
