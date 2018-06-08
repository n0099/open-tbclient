package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte uA = 4;
    private static byte uB = Byte.MIN_VALUE;
    private static byte uC = 64;
    private static byte uD = 8;
    private static byte uE = 4;
    private int uI;
    private int uJ;
    private boolean uF = false;
    private boolean uG = false;
    private boolean uH = false;
    private boolean uK = false;

    public static int fz() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + fz());
        byte b = z ? (byte) (uB | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | uC);
        }
        byte b2 = (byte) (b | uD);
        if (z3) {
            b2 = (byte) (b2 | uE);
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

    public static a f(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fz());
        a aVar = new a();
        byte b = wrap.get();
        if ((uB & b) != 0) {
            aVar.uF = true;
        }
        if ((uC & b) != 0) {
            aVar.uG = true;
        }
        if ((uD & b) != 0) {
            aVar.uH = true;
        }
        if ((b & uE) != 0) {
            aVar.uK = true;
        }
        aVar.uI = wrap.getInt();
        aVar.uJ = wrap.getInt();
        return aVar;
    }

    public boolean fA() {
        return this.uG;
    }

    public int fB() {
        return this.uI;
    }

    public boolean fC() {
        return this.uF;
    }

    public int fD() {
        return this.uJ;
    }

    public boolean fE() {
        return this.uH;
    }

    public boolean fF() {
        return this.uK;
    }
}
