package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private boolean iB = false;
    private boolean iC = false;
    private boolean iD = false;
    private int iE;
    private int iF;
    private static byte iy = Byte.MIN_VALUE;
    private static byte iz = 64;
    private static byte iA = 8;

    public static int bU() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + bU());
        byte b = z ? (byte) (iy | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | iz);
        }
        allocate.put((byte) (b | iA));
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
        if ((iy & b) != 0) {
            aVar.iB = true;
        }
        if ((iz & b) != 0) {
            aVar.iC = true;
        }
        if ((b & iA) != 0) {
            aVar.iD = true;
        }
        aVar.iE = wrap.getInt();
        aVar.iF = wrap.getInt();
        return aVar;
    }

    public boolean bV() {
        return this.iC;
    }

    public int bW() {
        return this.iE;
    }

    public boolean bX() {
        return this.iB;
    }

    public int bY() {
        return this.iF;
    }

    public boolean bZ() {
        return this.iD;
    }
}
