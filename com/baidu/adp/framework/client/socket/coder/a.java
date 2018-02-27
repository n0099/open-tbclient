package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte adI = 4;
    private static byte adJ = Byte.MIN_VALUE;
    private static byte adK = 64;
    private static byte adL = 8;
    private static byte adM = 4;
    private int adQ;
    private int adR;
    private boolean adN = false;
    private boolean adO = false;
    private boolean adP = false;
    private boolean adS = false;

    public static int kG() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + kG());
        byte b = z ? (byte) (adJ | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | adK);
        }
        byte b2 = (byte) (b | adL);
        if (z3) {
            b2 = (byte) (b2 | adM);
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
        if ((adJ & b) != 0) {
            aVar.adN = true;
        }
        if ((adK & b) != 0) {
            aVar.adO = true;
        }
        if ((adL & b) != 0) {
            aVar.adP = true;
        }
        if ((b & adM) != 0) {
            aVar.adS = true;
        }
        aVar.adQ = wrap.getInt();
        aVar.adR = wrap.getInt();
        return aVar;
    }

    public boolean kH() {
        return this.adO;
    }

    public int kI() {
        return this.adQ;
    }

    public boolean kJ() {
        return this.adN;
    }

    public int kK() {
        return this.adR;
    }

    public boolean kL() {
        return this.adP;
    }

    public boolean kM() {
        return this.adS;
    }
}
