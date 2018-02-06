package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte adO = 4;
    private static byte adP = Byte.MIN_VALUE;
    private static byte adQ = 64;
    private static byte adR = 8;
    private static byte adS = 4;
    private int adW;
    private int adX;
    private boolean adT = false;
    private boolean adU = false;
    private boolean adV = false;
    private boolean adY = false;

    public static int kG() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + kG());
        byte b = z ? (byte) (adP | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | adQ);
        }
        byte b2 = (byte) (b | adR);
        if (z3) {
            b2 = (byte) (b2 | adS);
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

    public static a d(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, kG());
        a aVar = new a();
        byte b = wrap.get();
        if ((adP & b) != 0) {
            aVar.adT = true;
        }
        if ((adQ & b) != 0) {
            aVar.adU = true;
        }
        if ((adR & b) != 0) {
            aVar.adV = true;
        }
        if ((b & adS) != 0) {
            aVar.adY = true;
        }
        aVar.adW = wrap.getInt();
        aVar.adX = wrap.getInt();
        return aVar;
    }

    public boolean kH() {
        return this.adU;
    }

    public int kI() {
        return this.adW;
    }

    public boolean kJ() {
        return this.adT;
    }

    public int kK() {
        return this.adX;
    }

    public boolean kL() {
        return this.adV;
    }

    public boolean kM() {
        return this.adY;
    }
}
