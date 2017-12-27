package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte adQ = 4;
    private static byte adR = Byte.MIN_VALUE;
    private static byte adS = 64;
    private static byte adT = 8;
    private static byte adU = 4;
    private int adY;
    private int adZ;
    private boolean adV = false;
    private boolean adW = false;
    private boolean adX = false;
    private boolean aea = false;

    public static int kG() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + kG());
        byte b = z ? (byte) (adR | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | adS);
        }
        byte b2 = (byte) (b | adT);
        if (z3) {
            b2 = (byte) (b2 | adU);
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
        if ((adR & b) != 0) {
            aVar.adV = true;
        }
        if ((adS & b) != 0) {
            aVar.adW = true;
        }
        if ((adT & b) != 0) {
            aVar.adX = true;
        }
        if ((b & adU) != 0) {
            aVar.aea = true;
        }
        aVar.adY = wrap.getInt();
        aVar.adZ = wrap.getInt();
        return aVar;
    }

    public boolean kH() {
        return this.adW;
    }

    public int kI() {
        return this.adY;
    }

    public boolean kJ() {
        return this.adV;
    }

    public int kK() {
        return this.adZ;
    }

    public boolean kL() {
        return this.adX;
    }

    public boolean kM() {
        return this.aea;
    }
}
