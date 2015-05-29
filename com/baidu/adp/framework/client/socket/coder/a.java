package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte pJ = Byte.MIN_VALUE;
    private static byte pK = 64;
    private boolean pL = false;
    private boolean pM = false;
    private int pN;
    private int pO;

    public static int eF() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + eF());
        byte b = z ? (byte) (pJ | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | pK);
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
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, eF());
        a aVar = new a();
        byte b = wrap.get();
        if ((pJ & b) != 0) {
            aVar.pL = true;
        }
        if ((b & pK) != 0) {
            aVar.pM = true;
        }
        aVar.pN = wrap.getInt();
        aVar.pO = wrap.getInt();
        return aVar;
    }

    public boolean eG() {
        return this.pM;
    }

    public int eH() {
        return this.pN;
    }

    public boolean eI() {
        return this.pL;
    }

    public int eJ() {
        return this.pO;
    }
}
