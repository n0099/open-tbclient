package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte ej = Byte.MIN_VALUE;
    private static byte ek = 64;
    private boolean el = false;
    private boolean em = false;
    private int en;
    private int eo;

    public static int bf() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + bf());
        byte b = z ? (byte) (ej | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | ek);
        }
        allocate.put(b);
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static a f(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, bf());
        a aVar = new a();
        byte b = wrap.get();
        if ((ej & b) != 0) {
            aVar.el = true;
        }
        if ((b & ek) != 0) {
            aVar.em = true;
        }
        aVar.en = wrap.getInt();
        aVar.eo = wrap.getInt();
        return aVar;
    }

    public boolean bg() {
        return this.em;
    }

    public int bh() {
        return this.en;
    }

    public boolean bi() {
        return this.el;
    }

    public int bj() {
        return this.eo;
    }
}
