package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte ve = 4;
    private static byte vf = Byte.MIN_VALUE;
    private static byte vg = 64;
    private static byte vh = 8;
    private static byte vi = 4;
    private int command;
    private int vm;
    private boolean vj = false;
    private boolean vk = false;
    private boolean vl = false;
    private boolean vn = false;

    public static int fO() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + fO());
        byte b = z ? (byte) (vf | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | vg);
        }
        byte b2 = (byte) (b | vh);
        if (z3) {
            b2 = (byte) (b2 | vi);
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
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, fO());
        a aVar = new a();
        byte b = wrap.get();
        if ((vf & b) != 0) {
            aVar.vj = true;
        }
        if ((vg & b) != 0) {
            aVar.vk = true;
        }
        if ((vh & b) != 0) {
            aVar.vl = true;
        }
        if ((b & vi) != 0) {
            aVar.vn = true;
        }
        aVar.command = wrap.getInt();
        aVar.vm = wrap.getInt();
        return aVar;
    }

    public boolean fP() {
        return this.vk;
    }

    public int getCommand() {
        return this.command;
    }

    public boolean fQ() {
        return this.vj;
    }

    public int fR() {
        return this.vm;
    }

    public boolean fS() {
        return this.vl;
    }

    public boolean fT() {
        return this.vn;
    }
}
