package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte fD = Byte.MIN_VALUE;
    private static byte fE = 64;
    private static byte fF = 8;
    private boolean fG = false;
    private boolean fH = false;
    private boolean fI = false;
    private int fJ;
    private int fK;

    public static int aZ() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + aZ());
        byte b = z ? (byte) (fD | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | fE);
        }
        allocate.put((byte) (b | fF));
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static a d(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, aZ());
        a aVar = new a();
        byte b = wrap.get();
        if ((fD & b) != 0) {
            aVar.fG = true;
        }
        if ((fE & b) != 0) {
            aVar.fH = true;
        }
        if ((b & fF) != 0) {
            aVar.fI = true;
        }
        aVar.fJ = wrap.getInt();
        aVar.fK = wrap.getInt();
        return aVar;
    }

    public boolean ba() {
        return this.fH;
    }

    public int bb() {
        return this.fJ;
    }

    public boolean bc() {
        return this.fG;
    }

    public int bd() {
        return this.fK;
    }

    public boolean be() {
        return this.fI;
    }
}
