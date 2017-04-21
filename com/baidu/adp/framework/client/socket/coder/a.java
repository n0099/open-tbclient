package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte pQ = 4;
    private static byte pR = Byte.MIN_VALUE;
    private static byte pS = 64;
    private static byte pT = 8;
    private static byte pU = 1;
    private int pY;
    private int pZ;
    private boolean pV = false;
    private boolean pW = false;
    private boolean pX = false;
    private boolean qa = false;

    public static int dc() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + dc());
        byte b = z ? (byte) (pR | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | pS);
        }
        byte b2 = (byte) (b | pT);
        if (z3) {
            b2 = (byte) (b2 | pU);
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
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, dc());
        a aVar = new a();
        byte b = wrap.get();
        if ((pR & b) != 0) {
            aVar.pV = true;
        }
        if ((pS & b) != 0) {
            aVar.pW = true;
        }
        if ((pT & b) != 0) {
            aVar.pX = true;
        }
        if ((b & pU) != 0) {
            aVar.qa = true;
        }
        aVar.pY = wrap.getInt();
        aVar.pZ = wrap.getInt();
        return aVar;
    }

    public boolean dd() {
        return this.pW;
    }

    public int de() {
        return this.pY;
    }

    public boolean df() {
        return this.pV;
    }

    public int dg() {
        return this.pZ;
    }

    public boolean dh() {
        return this.pX;
    }

    public boolean di() {
        return this.qa;
    }
}
