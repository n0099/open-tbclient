package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte uq = 4;
    private static byte ur = Byte.MIN_VALUE;
    private static byte us = 64;
    private static byte ut = 8;
    private static byte uu = 4;
    private int uy;
    private int uz;
    private boolean uv = false;
    private boolean uw = false;
    private boolean ux = false;
    private boolean uA = false;

    public static int fy() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + fy());
        byte b = z ? (byte) (ur | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | us);
        }
        byte b2 = (byte) (b | ut);
        if (z3) {
            b2 = (byte) (b2 | uu);
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
        if ((ur & b) != 0) {
            aVar.uv = true;
        }
        if ((us & b) != 0) {
            aVar.uw = true;
        }
        if ((ut & b) != 0) {
            aVar.ux = true;
        }
        if ((b & uu) != 0) {
            aVar.uA = true;
        }
        aVar.uy = wrap.getInt();
        aVar.uz = wrap.getInt();
        return aVar;
    }

    public boolean fz() {
        return this.uw;
    }

    public int fA() {
        return this.uy;
    }

    public boolean fB() {
        return this.uv;
    }

    public int fC() {
        return this.uz;
    }

    public boolean fD() {
        return this.ux;
    }

    public boolean fE() {
        return this.uA;
    }
}
