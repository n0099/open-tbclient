package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private int xE;
    private int xF;
    public static byte xw = 4;
    private static byte xx = Byte.MIN_VALUE;
    private static byte xy = 64;
    private static byte xz = 8;
    private static byte xA = 4;
    private boolean xB = false;
    private boolean xC = false;
    private boolean xD = false;
    private boolean xG = false;

    public static int gZ() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + gZ());
        byte b = z ? (byte) (xx | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | xy);
        }
        byte b2 = (byte) (b | xz);
        if (z3) {
            b2 = (byte) (b2 | xA);
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
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, gZ());
        a aVar = new a();
        byte b = wrap.get();
        if ((xx & b) != 0) {
            aVar.xB = true;
        }
        if ((xy & b) != 0) {
            aVar.xC = true;
        }
        if ((xz & b) != 0) {
            aVar.xD = true;
        }
        if ((b & xA) != 0) {
            aVar.xG = true;
        }
        aVar.xE = wrap.getInt();
        aVar.xF = wrap.getInt();
        return aVar;
    }

    public boolean ha() {
        return this.xC;
    }

    public int getCommand() {
        return this.xE;
    }

    public boolean hb() {
        return this.xB;
    }

    public int hc() {
        return this.xF;
    }

    public boolean hd() {
        return this.xD;
    }

    public boolean he() {
        return this.xG;
    }
}
