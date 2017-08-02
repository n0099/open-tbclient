package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte pR = 4;
    private static byte pS = Byte.MIN_VALUE;
    private static byte pT = 64;
    private static byte pU = 8;
    private static byte pV = 4;
    private int pZ;
    private int qa;
    private boolean pW = false;
    private boolean pX = false;
    private boolean pY = false;
    private boolean qb = false;

    public static int db() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + db());
        byte b = z ? (byte) (pS | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | pT);
        }
        byte b2 = (byte) (b | pU);
        if (z3) {
            b2 = (byte) (b2 | pV);
        }
        allocate.put(b2);
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static a h(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, db());
        a aVar = new a();
        byte b = wrap.get();
        if ((pS & b) != 0) {
            aVar.pW = true;
        }
        if ((pT & b) != 0) {
            aVar.pX = true;
        }
        if ((pU & b) != 0) {
            aVar.pY = true;
        }
        if ((b & pV) != 0) {
            aVar.qb = true;
        }
        aVar.pZ = wrap.getInt();
        aVar.qa = wrap.getInt();
        return aVar;
    }

    public boolean dc() {
        return this.pX;
    }

    public int dd() {
        return this.pZ;
    }

    public boolean de() {
        return this.pW;
    }

    public int df() {
        return this.qa;
    }

    public boolean dg() {
        return this.pY;
    }

    public boolean dh() {
        return this.qb;
    }
}
