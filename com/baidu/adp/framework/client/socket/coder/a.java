package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte pN = Byte.MIN_VALUE;
    private static byte pO = 64;
    private boolean pP = false;
    private boolean pQ = false;
    private int pR;
    private int pS;

    public static int eJ() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + eJ());
        byte b = z ? (byte) (pN | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | pO);
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

    public static a t(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, eJ());
        a aVar = new a();
        byte b = wrap.get();
        if ((pN & b) != 0) {
            aVar.pP = true;
        }
        if ((b & pO) != 0) {
            aVar.pQ = true;
        }
        aVar.pR = wrap.getInt();
        aVar.pS = wrap.getInt();
        return aVar;
    }

    public boolean eK() {
        return this.pQ;
    }

    public int eL() {
        return this.pR;
    }

    public boolean eM() {
        return this.pP;
    }

    public int eN() {
        return this.pS;
    }
}
