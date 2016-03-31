package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte pP = Byte.MIN_VALUE;
    private static byte pQ = 64;
    private static byte pR = 8;
    private boolean pS = false;
    private boolean pT = false;
    private boolean pU = false;
    private int pV;
    private int pW;

    public static int eJ() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + eJ());
        byte b = z ? (byte) (pP | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | pQ);
        }
        allocate.put((byte) (b | pR));
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static a d(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, eJ());
        a aVar = new a();
        byte b = wrap.get();
        if ((pP & b) != 0) {
            aVar.pS = true;
        }
        if ((pQ & b) != 0) {
            aVar.pT = true;
        }
        if ((b & pR) != 0) {
            aVar.pU = true;
        }
        aVar.pV = wrap.getInt();
        aVar.pW = wrap.getInt();
        return aVar;
    }

    public boolean eK() {
        return this.pT;
    }

    public int eL() {
        return this.pV;
    }

    public boolean eM() {
        return this.pS;
    }

    public int eN() {
        return this.pW;
    }

    public boolean eO() {
        return this.pU;
    }
}
