package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    public static byte vf = 4;
    private static byte vg = Byte.MIN_VALUE;
    private static byte vh = 64;
    private static byte vi = 8;
    private static byte vj = 4;
    private int command;
    private int vn;
    private boolean vk = false;
    private boolean vl = false;
    private boolean vm = false;
    private boolean vo = false;

    public static int fO() {
        return 9;
    }

    public static byte[] a(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + fO());
        byte b = z ? (byte) (vg | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | vh);
        }
        byte b2 = (byte) (b | vi);
        if (z3) {
            b2 = (byte) (b2 | vj);
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
        if ((vg & b) != 0) {
            aVar.vk = true;
        }
        if ((vh & b) != 0) {
            aVar.vl = true;
        }
        if ((vi & b) != 0) {
            aVar.vm = true;
        }
        if ((b & vj) != 0) {
            aVar.vo = true;
        }
        aVar.command = wrap.getInt();
        aVar.vn = wrap.getInt();
        return aVar;
    }

    public boolean fP() {
        return this.vl;
    }

    public int getCommand() {
        return this.command;
    }

    public boolean fQ() {
        return this.vk;
    }

    public int fR() {
        return this.vn;
    }

    public boolean fS() {
        return this.vm;
    }

    public boolean fT() {
        return this.vo;
    }
}
