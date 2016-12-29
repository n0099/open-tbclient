package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte ix = Byte.MIN_VALUE;
    private static byte iy = 64;
    private static byte iz = 8;
    private boolean iA = false;
    private boolean iB = false;
    private boolean iC = false;
    private int iD;
    private int iE;

    public static int bU() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + bU());
        byte b = z ? (byte) (ix | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | iy);
        }
        allocate.put((byte) (b | iz));
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
        if ((ix & b) != 0) {
            aVar.iA = true;
        }
        if ((iy & b) != 0) {
            aVar.iB = true;
        }
        if ((b & iz) != 0) {
            aVar.iC = true;
        }
        aVar.iD = wrap.getInt();
        aVar.iE = wrap.getInt();
        return aVar;
    }

    public boolean bV() {
        return this.iB;
    }

    public int bW() {
        return this.iD;
    }

    public boolean bX() {
        return this.iA;
    }

    public int bY() {
        return this.iE;
    }

    public boolean bZ() {
        return this.iC;
    }
}
