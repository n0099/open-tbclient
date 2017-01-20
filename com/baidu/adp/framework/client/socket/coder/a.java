package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte it = Byte.MIN_VALUE;
    private static byte iu = 64;
    private static byte iw = 8;
    private int iA;
    private int iB;
    private boolean ix = false;
    private boolean iy = false;
    private boolean iz = false;

    public static int bU() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + bU());
        byte b = z ? (byte) (it | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | iu);
        }
        allocate.put((byte) (b | iw));
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static a h(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, bU());
        a aVar = new a();
        byte b = wrap.get();
        if ((it & b) != 0) {
            aVar.ix = true;
        }
        if ((iu & b) != 0) {
            aVar.iy = true;
        }
        if ((b & iw) != 0) {
            aVar.iz = true;
        }
        aVar.iA = wrap.getInt();
        aVar.iB = wrap.getInt();
        return aVar;
    }

    public boolean bV() {
        return this.iy;
    }

    public int bW() {
        return this.iA;
    }

    public boolean bX() {
        return this.ix;
    }

    public int bY() {
        return this.iB;
    }

    public boolean bZ() {
        return this.iz;
    }
}
