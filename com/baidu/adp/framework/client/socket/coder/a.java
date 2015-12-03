package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte pK = Byte.MIN_VALUE;
    private static byte pL = 64;
    private boolean pM = false;
    private boolean pN = false;
    private int pO;
    private int pP;

    public static int eF() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + eF());
        byte b = z ? (byte) (pK | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | pL);
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
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, eF());
        a aVar = new a();
        byte b = wrap.get();
        if ((pK & b) != 0) {
            aVar.pM = true;
        }
        if ((b & pL) != 0) {
            aVar.pN = true;
        }
        aVar.pO = wrap.getInt();
        aVar.pP = wrap.getInt();
        return aVar;
    }

    public boolean eG() {
        return this.pN;
    }

    public int eH() {
        return this.pO;
    }

    public boolean eI() {
        return this.pM;
    }

    public int eJ() {
        return this.pP;
    }
}
