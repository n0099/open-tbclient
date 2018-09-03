package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte ur = 4;
    private static byte us = Byte.MIN_VALUE;
    private static byte ut = 64;
    private static byte uu = 8;
    private static byte uv = 4;
    private int uA;
    private int uz;
    private boolean uw = false;
    private boolean ux = false;
    private boolean uy = false;
    private boolean uB = false;

    public static int fy() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + fy());
        byte b = z ? (byte) (us | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | ut);
        }
        byte b2 = (byte) (b | uu);
        if (z3) {
            b2 = (byte) (b2 | uv);
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
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fy());
        a aVar = new a();
        byte b = wrap.get();
        if ((us & b) != 0) {
            aVar.uw = true;
        }
        if ((ut & b) != 0) {
            aVar.ux = true;
        }
        if ((uu & b) != 0) {
            aVar.uy = true;
        }
        if ((b & uv) != 0) {
            aVar.uB = true;
        }
        aVar.uz = wrap.getInt();
        aVar.uA = wrap.getInt();
        return aVar;
    }

    public boolean fz() {
        return this.ux;
    }

    public int fA() {
        return this.uz;
    }

    public boolean fB() {
        return this.uw;
    }

    public int fC() {
        return this.uA;
    }

    public boolean fD() {
        return this.uy;
    }

    public boolean fE() {
        return this.uB;
    }
}
