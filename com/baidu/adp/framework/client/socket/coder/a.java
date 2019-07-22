package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte vh = 4;
    private static byte vi = Byte.MIN_VALUE;
    private static byte vj = 64;
    private static byte vk = 8;
    private static byte vl = 4;
    private int command;
    private int vp;
    private boolean vm = false;
    private boolean vn = false;
    private boolean vo = false;
    private boolean vq = false;

    public static int fW() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + fW());
        byte b = z ? (byte) (vi | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | vj);
        }
        byte b2 = (byte) (b | vk);
        if (z3) {
            b2 = (byte) (b2 | vl);
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
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fW());
        a aVar = new a();
        byte b = wrap.get();
        if ((vi & b) != 0) {
            aVar.vm = true;
        }
        if ((vj & b) != 0) {
            aVar.vn = true;
        }
        if ((vk & b) != 0) {
            aVar.vo = true;
        }
        if ((b & vl) != 0) {
            aVar.vq = true;
        }
        aVar.command = wrap.getInt();
        aVar.vp = wrap.getInt();
        return aVar;
    }

    public boolean fX() {
        return this.vn;
    }

    public int getCommand() {
        return this.command;
    }

    public boolean fY() {
        return this.vm;
    }

    public int fZ() {
        return this.vp;
    }

    public boolean ga() {
        return this.vo;
    }

    public boolean gb() {
        return this.vq;
    }
}
