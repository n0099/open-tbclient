package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte pj = 4;
    private static byte pl = Byte.MIN_VALUE;
    private static byte po = 64;
    private static byte pp = 8;
    private static byte pq = 4;
    private int pv;
    private int pw;
    private boolean pr = false;
    private boolean pt = false;
    private boolean pu = false;
    private boolean px = false;

    public static int dc() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + dc());
        byte b = z ? (byte) (pl | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | po);
        }
        byte b2 = (byte) (b | pp);
        if (z3) {
            b2 = (byte) (b2 | pq);
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
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, dc());
        a aVar = new a();
        byte b = wrap.get();
        if ((pl & b) != 0) {
            aVar.pr = true;
        }
        if ((po & b) != 0) {
            aVar.pt = true;
        }
        if ((pp & b) != 0) {
            aVar.pu = true;
        }
        if ((b & pq) != 0) {
            aVar.px = true;
        }
        aVar.pv = wrap.getInt();
        aVar.pw = wrap.getInt();
        return aVar;
    }

    public boolean dd() {
        return this.pt;
    }

    public int de() {
        return this.pv;
    }

    public boolean df() {
        return this.pr;
    }

    public int dg() {
        return this.pw;
    }

    public boolean dh() {
        return this.pu;
    }

    public boolean di() {
        return this.px;
    }
}
