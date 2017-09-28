package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte pl = 4;
    private static byte po = Byte.MIN_VALUE;
    private static byte pp = 64;
    private static byte pq = 8;
    private static byte pr = 4;
    private int pw;
    private int px;
    private boolean pt = false;
    private boolean pu = false;
    private boolean pv = false;
    private boolean py = false;

    public static int dc() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + dc());
        byte b = z ? (byte) (po | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | pp);
        }
        byte b2 = (byte) (b | pq);
        if (z3) {
            b2 = (byte) (b2 | pr);
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
        if ((po & b) != 0) {
            aVar.pt = true;
        }
        if ((pp & b) != 0) {
            aVar.pu = true;
        }
        if ((pq & b) != 0) {
            aVar.pv = true;
        }
        if ((b & pr) != 0) {
            aVar.py = true;
        }
        aVar.pw = wrap.getInt();
        aVar.px = wrap.getInt();
        return aVar;
    }

    public boolean dd() {
        return this.pu;
    }

    public int de() {
        return this.pw;
    }

    public boolean df() {
        return this.pt;
    }

    public int dg() {
        return this.px;
    }

    public boolean dh() {
        return this.pv;
    }

    public boolean di() {
        return this.py;
    }
}
