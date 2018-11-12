package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private int xH;
    private int xI;
    public static byte xz = 4;
    private static byte xA = Byte.MIN_VALUE;
    private static byte xB = 64;
    private static byte xC = 8;
    private static byte xD = 4;
    private boolean xE = false;
    private boolean xF = false;
    private boolean xG = false;
    private boolean xJ = false;

    public static int gY() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + gY());
        byte b = z ? (byte) (xA | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | xB);
        }
        byte b2 = (byte) (b | xC);
        if (z3) {
            b2 = (byte) (b2 | xD);
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

    public static a m(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, gY());
        a aVar = new a();
        byte b = wrap.get();
        if ((xA & b) != 0) {
            aVar.xE = true;
        }
        if ((xB & b) != 0) {
            aVar.xF = true;
        }
        if ((xC & b) != 0) {
            aVar.xG = true;
        }
        if ((b & xD) != 0) {
            aVar.xJ = true;
        }
        aVar.xH = wrap.getInt();
        aVar.xI = wrap.getInt();
        return aVar;
    }

    public boolean gZ() {
        return this.xF;
    }

    public int getCommand() {
        return this.xH;
    }

    public boolean ha() {
        return this.xE;
    }

    public int hb() {
        return this.xI;
    }

    public boolean hc() {
        return this.xG;
    }

    public boolean hd() {
        return this.xJ;
    }
}
