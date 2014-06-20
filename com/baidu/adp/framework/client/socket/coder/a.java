package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private static byte a = Byte.MIN_VALUE;
    private static byte b = 64;
    private boolean c = false;
    private boolean d = false;
    private int e;
    private int f;

    public static int a() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + a());
        byte b2 = z ? (byte) (a | 0) : (byte) 0;
        if (z2) {
            b2 = (byte) (b2 | b);
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

    public static a a(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, a());
        a aVar = new a();
        byte b2 = wrap.get();
        if ((a & b2) != 0) {
            aVar.c = true;
        }
        if ((b2 & b) != 0) {
            aVar.d = true;
        }
        aVar.e = wrap.getInt();
        aVar.f = wrap.getInt();
        return aVar;
    }

    public boolean b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public boolean d() {
        return this.c;
    }

    public int e() {
        return this.f;
    }
}
