package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte pE = Byte.MIN_VALUE;
    private static byte pF = 64;
    private boolean pG = false;
    private boolean pH = false;
    private int pI;
    private int pJ;

    public static int eC() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + eC());
        byte b = z ? (byte) (pE | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | pF);
        }
        allocate.put(b);
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static a f(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, eC());
        a aVar = new a();
        byte b = wrap.get();
        if ((pE & b) != 0) {
            aVar.pG = true;
        }
        if ((b & pF) != 0) {
            aVar.pH = true;
        }
        aVar.pI = wrap.getInt();
        aVar.pJ = wrap.getInt();
        return aVar;
    }

    public boolean eD() {
        return this.pH;
    }

    public int eE() {
        return this.pI;
    }

    public boolean eF() {
        return this.pG;
    }

    public int eG() {
        return this.pJ;
    }
}
