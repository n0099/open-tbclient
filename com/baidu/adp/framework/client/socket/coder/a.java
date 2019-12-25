package com.baidu.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class a {
    private int command;
    private int sequenceId;
    public static byte EXTRA_DATA_HEADER_LEN = 4;
    private static byte ENCRYPT_FLAG = Byte.MIN_VALUE;
    private static byte COMPRESS_FLAG = 64;
    private static byte LCS_SWITCH_HTTP_FLAG = 8;
    private static byte EXTRA_DATA_FLAG = 4;
    private boolean encrypt = false;
    private boolean compress = false;
    private boolean lcsSwitchHttp = false;
    private boolean hasExtraData = false;

    public static int getHeaderLengthInBytes() {
        return 9;
    }

    public static byte[] wrapHeaderIntoBody(boolean z, boolean z2, int i, int i2, byte[] bArr, boolean z3) {
        ByteBuffer allocate = ByteBuffer.allocate((bArr != null ? bArr.length : 0) + getHeaderLengthInBytes());
        byte b = z ? (byte) (ENCRYPT_FLAG | 0) : (byte) 0;
        if (z2) {
            b = (byte) (b | COMPRESS_FLAG);
        }
        byte b2 = (byte) (b | LCS_SWITCH_HTTP_FLAG);
        if (z3) {
            b2 = (byte) (b2 | EXTRA_DATA_FLAG);
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

    public static a e(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderLengthInBytes());
        a aVar = new a();
        byte b = wrap.get();
        if ((ENCRYPT_FLAG & b) != 0) {
            aVar.encrypt = true;
        }
        if ((COMPRESS_FLAG & b) != 0) {
            aVar.compress = true;
        }
        if ((LCS_SWITCH_HTTP_FLAG & b) != 0) {
            aVar.lcsSwitchHttp = true;
        }
        if ((b & EXTRA_DATA_FLAG) != 0) {
            aVar.hasExtraData = true;
        }
        aVar.command = wrap.getInt();
        aVar.sequenceId = wrap.getInt();
        return aVar;
    }

    public boolean getCompressType() {
        return this.compress;
    }

    public int getCommand() {
        return this.command;
    }

    public boolean getEncryptType() {
        return this.encrypt;
    }

    public int getSequenceID() {
        return this.sequenceId;
    }

    public boolean getLcsSwitchHttp() {
        return this.lcsSwitchHttp;
    }

    public boolean getHasExtraData() {
        return this.hasExtraData;
    }
}
