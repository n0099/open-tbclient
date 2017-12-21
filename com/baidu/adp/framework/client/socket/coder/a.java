package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte po = 4;
    private static byte pp = Byte.MIN_VALUE;
    private static byte pq = 64;
    private static byte pr = 8;
    private static byte pt = 4;
    private int px;
    private int py;
    private boolean pu = false;
    private boolean pv = false;
    private boolean pw = false;
    private boolean pz = false;

    public static int dc() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + dc());
        byte b = z ? (byte) (pp | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | pq);
        }
        byte b2 = (byte) (b | pr);
        if (z3) {
            b2 = (byte) (b2 | pt);
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
        if ((pp & b) != 0) {
            aVar.pu = true;
        }
        if ((pq & b) != 0) {
            aVar.pv = true;
        }
        if ((pr & b) != 0) {
            aVar.pw = true;
        }
        if ((b & pt) != 0) {
            aVar.pz = true;
        }
        aVar.px = wrap.getInt();
        aVar.py = wrap.getInt();
        return aVar;
    }

    public boolean dd() {
        return this.pv;
    }

    public int de() {
        return this.px;
    }

    public boolean df() {
        return this.pu;
    }

    public int dg() {
        return this.py;
    }

    public boolean dh() {
        return this.pw;
    }

    public boolean di() {
        return this.pz;
    }
}
