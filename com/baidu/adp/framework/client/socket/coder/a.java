package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private int rE;
    private int rF;
    public static byte rw = 4;
    private static byte rx = Byte.MIN_VALUE;
    private static byte ry = 64;
    private static byte rz = 8;
    private static byte rA = 4;
    private boolean rB = false;
    private boolean rC = false;
    private boolean rD = false;
    private boolean rG = false;

    public static int dm() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + dm());
        byte b = z ? (byte) (rx | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | ry);
        }
        byte b2 = (byte) (b | rz);
        if (z3) {
            b2 = (byte) (b2 | rA);
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
        if ((rx & b) != 0) {
            aVar.rB = true;
        }
        if ((ry & b) != 0) {
            aVar.rC = true;
        }
        if ((rz & b) != 0) {
            aVar.rD = true;
        }
        if ((b & rA) != 0) {
            aVar.rG = true;
        }
        aVar.rE = wrap.getInt();
        aVar.rF = wrap.getInt();
        return aVar;
    }

    public boolean dn() {
        return this.rC;
    }

    /* renamed from: do  reason: not valid java name */
    public int m2do() {
        return this.rE;
    }

    public boolean dp() {
        return this.rB;
    }

    public int dq() {
        return this.rF;
    }

    public boolean dr() {
        return this.rD;
    }

    public boolean ds() {
        return this.rG;
    }
}
