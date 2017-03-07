package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte qp = Byte.MIN_VALUE;
    private static byte qq = 64;
    private static byte qr = 8;
    private boolean qs = false;
    private boolean qt = false;
    private boolean qu = false;
    private int qv;
    private int qw;

    public static int dd() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + dd());
        byte b = z ? (byte) (qp | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | qq);
        }
        allocate.put((byte) (b | qr));
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static a h(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, dd());
        a aVar = new a();
        byte b = wrap.get();
        if ((qp & b) != 0) {
            aVar.qs = true;
        }
        if ((qq & b) != 0) {
            aVar.qt = true;
        }
        if ((b & qr) != 0) {
            aVar.qu = true;
        }
        aVar.qv = wrap.getInt();
        aVar.qw = wrap.getInt();
        return aVar;
    }

    public boolean de() {
        return this.qt;
    }

    public int df() {
        return this.qv;
    }

    public boolean dg() {
        return this.qs;
    }

    public int dh() {
        return this.qw;
    }

    public boolean di() {
        return this.qu;
    }
}
