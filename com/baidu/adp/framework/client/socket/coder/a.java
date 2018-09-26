package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte wK = 4;
    private static byte wL = Byte.MIN_VALUE;
    private static byte wM = 64;
    private static byte wN = 8;
    private static byte wO = 4;
    private int wS;
    private int wT;
    private boolean wP = false;
    private boolean wQ = false;
    private boolean wR = false;
    private boolean wU = false;

    public static int gH() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + gH());
        byte b = z ? (byte) (wL | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | wM);
        }
        byte b2 = (byte) (b | wN);
        if (z3) {
            b2 = (byte) (b2 | wO);
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

    public static a n(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, gH());
        a aVar = new a();
        byte b = wrap.get();
        if ((wL & b) != 0) {
            aVar.wP = true;
        }
        if ((wM & b) != 0) {
            aVar.wQ = true;
        }
        if ((wN & b) != 0) {
            aVar.wR = true;
        }
        if ((b & wO) != 0) {
            aVar.wU = true;
        }
        aVar.wS = wrap.getInt();
        aVar.wT = wrap.getInt();
        return aVar;
    }

    public boolean gI() {
        return this.wQ;
    }

    public int getCommand() {
        return this.wS;
    }

    public boolean gJ() {
        return this.wP;
    }

    public int gK() {
        return this.wT;
    }

    public boolean gL() {
        return this.wR;
    }

    public boolean gM() {
        return this.wU;
    }
}
