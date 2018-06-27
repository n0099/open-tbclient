package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private int uG;
    private int uH;
    public static byte uy = 4;
    private static byte uz = Byte.MIN_VALUE;
    private static byte uA = 64;
    private static byte uB = 8;
    private static byte uC = 4;
    private boolean uD = false;
    private boolean uE = false;
    private boolean uF = false;
    private boolean uI = false;

    public static int fz() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + fz());
        byte b = z ? (byte) (uz | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | uA);
        }
        byte b2 = (byte) (b | uB);
        if (z3) {
            b2 = (byte) (b2 | uC);
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

    public static a h(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fz());
        a aVar = new a();
        byte b = wrap.get();
        if ((uz & b) != 0) {
            aVar.uD = true;
        }
        if ((uA & b) != 0) {
            aVar.uE = true;
        }
        if ((uB & b) != 0) {
            aVar.uF = true;
        }
        if ((b & uC) != 0) {
            aVar.uI = true;
        }
        aVar.uG = wrap.getInt();
        aVar.uH = wrap.getInt();
        return aVar;
    }

    public boolean fA() {
        return this.uE;
    }

    public int fB() {
        return this.uG;
    }

    public boolean fC() {
        return this.uD;
    }

    public int fD() {
        return this.uH;
    }

    public boolean fE() {
        return this.uF;
    }

    public boolean fF() {
        return this.uI;
    }
}
