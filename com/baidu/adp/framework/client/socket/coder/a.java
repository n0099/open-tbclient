package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte el = Byte.MIN_VALUE;
    private static byte em = 64;
    private boolean en = false;
    private boolean eo = false;
    private int ep;
    private int eq;

    public static int bf() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + bf());
        byte b = z ? (byte) (el | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | em);
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
        if ((el & b) != 0) {
            aVar.en = true;
        }
        if ((b & em) != 0) {
            aVar.eo = true;
        }
        aVar.ep = wrap.getInt();
        aVar.eq = wrap.getInt();
        return aVar;
    }

    public boolean bg() {
        return this.eo;
    }

    public int bh() {
        return this.ep;
    }

    public boolean bi() {
        return this.en;
    }

    public int bj() {
        return this.eq;
    }
}
