package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte pO = Byte.MIN_VALUE;
    private static byte pP = 64;
    private static byte pQ = 8;
    private boolean pR = false;
    private boolean pS = false;
    private boolean pT = false;
    private int pU;
    private int pV;

    public static int dc() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + dc());
        byte b = z ? (byte) (pO | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | pP);
        }
        allocate.put((byte) (b | pQ));
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
        if ((pO & b) != 0) {
            aVar.pR = true;
        }
        if ((pP & b) != 0) {
            aVar.pS = true;
        }
        if ((b & pQ) != 0) {
            aVar.pT = true;
        }
        aVar.pU = wrap.getInt();
        aVar.pV = wrap.getInt();
        return aVar;
    }

    public boolean dd() {
        return this.pS;
    }

    public int de() {
        return this.pU;
    }

    public boolean df() {
        return this.pR;
    }

    public int dg() {
        return this.pV;
    }

    public boolean dh() {
        return this.pT;
    }
}
