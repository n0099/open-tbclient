package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private int rF;
    private int rG;
    public static byte rx = 4;
    private static byte ry = Byte.MIN_VALUE;
    private static byte rz = 64;
    private static byte rA = 8;
    private static byte rB = 4;
    private boolean rC = false;
    private boolean rD = false;
    private boolean rE = false;
    private boolean rH = false;

    public static int dm() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + dm());
        byte b = z ? (byte) (ry | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | rz);
        }
        byte b2 = (byte) (b | rA);
        if (z3) {
            b2 = (byte) (b2 | rB);
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
        if ((ry & b) != 0) {
            aVar.rC = true;
        }
        if ((rz & b) != 0) {
            aVar.rD = true;
        }
        if ((rA & b) != 0) {
            aVar.rE = true;
        }
        if ((b & rB) != 0) {
            aVar.rH = true;
        }
        aVar.rF = wrap.getInt();
        aVar.rG = wrap.getInt();
        return aVar;
    }

    public boolean dn() {
        return this.rD;
    }

    /* renamed from: do  reason: not valid java name */
    public int m2do() {
        return this.rF;
    }

    public boolean dp() {
        return this.rC;
    }

    public int dq() {
        return this.rG;
    }

    public boolean dr() {
        return this.rE;
    }

    public boolean ds() {
        return this.rH;
    }
}
