package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte ob = 4;
    private static byte oc = Byte.MIN_VALUE;
    private static byte od = 64;
    private static byte oe = 8;
    private static byte of = 4;
    private int oj;
    private int ol;
    private boolean og = false;
    private boolean oh = false;
    private boolean oi = false;
    private boolean om = false;

    public static int cK() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + cK());
        byte b = z ? (byte) (oc | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | od);
        }
        byte b2 = (byte) (b | oe);
        if (z3) {
            b2 = (byte) (b2 | of);
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
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, cK());
        a aVar = new a();
        byte b = wrap.get();
        if ((oc & b) != 0) {
            aVar.og = true;
        }
        if ((od & b) != 0) {
            aVar.oh = true;
        }
        if ((oe & b) != 0) {
            aVar.oi = true;
        }
        if ((b & of) != 0) {
            aVar.om = true;
        }
        aVar.oj = wrap.getInt();
        aVar.ol = wrap.getInt();
        return aVar;
    }

    public boolean cL() {
        return this.oh;
    }

    public int cM() {
        return this.oj;
    }

    public boolean cN() {
        return this.og;
    }

    public int cO() {
        return this.ol;
    }

    public boolean cP() {
        return this.oi;
    }

    public boolean cQ() {
        return this.om;
    }
}
