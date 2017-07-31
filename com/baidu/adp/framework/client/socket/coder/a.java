package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte ru = 4;
    private static byte rv = Byte.MIN_VALUE;
    private static byte rw = 64;
    private static byte rx = 8;
    private static byte ry = 4;
    private int rC;
    private int rD;
    private boolean rz = false;
    private boolean rA = false;
    private boolean rB = false;
    private boolean rE = false;

    public static int dm() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + dm());
        byte b = z ? (byte) (rv | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | rw);
        }
        byte b2 = (byte) (b | rx);
        if (z3) {
            b2 = (byte) (b2 | ry);
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

    public static a k(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, dm());
        a aVar = new a();
        byte b = wrap.get();
        if ((rv & b) != 0) {
            aVar.rz = true;
        }
        if ((rw & b) != 0) {
            aVar.rA = true;
        }
        if ((rx & b) != 0) {
            aVar.rB = true;
        }
        if ((b & ry) != 0) {
            aVar.rE = true;
        }
        aVar.rC = wrap.getInt();
        aVar.rD = wrap.getInt();
        return aVar;
    }

    public boolean dn() {
        return this.rA;
    }

    /* renamed from: do  reason: not valid java name */
    public int m2do() {
        return this.rC;
    }

    public boolean dp() {
        return this.rz;
    }

    public int dq() {
        return this.rD;
    }

    public boolean dr() {
        return this.rB;
    }

    public boolean ds() {
        return this.rE;
    }
}
