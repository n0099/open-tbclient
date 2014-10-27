package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte cd = Byte.MIN_VALUE;
    private static byte ce = 64;
    private boolean cf = false;
    private boolean cg = false;
    private int ch;
    private int ci;

    public static int aF() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + aF());
        byte b = z ? (byte) (cd | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | ce);
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

    public static a e(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, aF());
        a aVar = new a();
        byte b = wrap.get();
        if ((cd & b) != 0) {
            aVar.cf = true;
        }
        if ((b & ce) != 0) {
            aVar.cg = true;
        }
        aVar.ch = wrap.getInt();
        aVar.ci = wrap.getInt();
        return aVar;
    }

    public boolean aG() {
        return this.cg;
    }

    public int aH() {
        return this.ch;
    }

    public boolean aI() {
        return this.cf;
    }

    public int aJ() {
        return this.ci;
    }
}
