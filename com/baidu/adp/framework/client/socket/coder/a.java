package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte fC = Byte.MIN_VALUE;
    private static byte fD = 64;
    private static byte fE = 8;
    private boolean fF = false;
    private boolean fG = false;
    private boolean fH = false;
    private int fI;
    private int fJ;

    public static int ba() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + ba());
        byte b = z ? (byte) (fC | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | fD);
        }
        allocate.put((byte) (b | fE));
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static a d(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, ba());
        a aVar = new a();
        byte b = wrap.get();
        if ((fC & b) != 0) {
            aVar.fF = true;
        }
        if ((fD & b) != 0) {
            aVar.fG = true;
        }
        if ((b & fE) != 0) {
            aVar.fH = true;
        }
        aVar.fI = wrap.getInt();
        aVar.fJ = wrap.getInt();
        return aVar;
    }

    public boolean bb() {
        return this.fG;
    }

    public int bc() {
        return this.fI;
    }

    public boolean bd() {
        return this.fF;
    }

    public int be() {
        return this.fJ;
    }

    public boolean bf() {
        return this.fH;
    }
}
