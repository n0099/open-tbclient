package com.baidu.live.adp.framework.client.socket.coder;

import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class CoderHeaderInfo {
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
        byte b2 = z ? (byte) (ENCRYPT_FLAG | 0) : (byte) 0;
        if (z2) {
            b2 = (byte) (b2 | COMPRESS_FLAG);
        }
        byte b3 = (byte) (b2 | LCS_SWITCH_HTTP_FLAG);
        if (z3) {
            b3 = (byte) (b3 | EXTRA_DATA_FLAG);
        }
        allocate.put(b3);
        allocate.putInt(i);
        allocate.putInt(i2);
        if (bArr != null) {
            allocate.put(bArr);
        }
        allocate.flip();
        return allocate.array();
    }

    public static CoderHeaderInfo extractFromRawBytes(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderLengthInBytes());
        CoderHeaderInfo coderHeaderInfo = new CoderHeaderInfo();
        byte b2 = wrap.get();
        if ((ENCRYPT_FLAG & b2) != 0) {
            coderHeaderInfo.encrypt = true;
        }
        if ((COMPRESS_FLAG & b2) != 0) {
            coderHeaderInfo.compress = true;
        }
        if ((LCS_SWITCH_HTTP_FLAG & b2) != 0) {
            coderHeaderInfo.lcsSwitchHttp = true;
        }
        if ((b2 & EXTRA_DATA_FLAG) != 0) {
            coderHeaderInfo.hasExtraData = true;
        }
        coderHeaderInfo.command = wrap.getInt();
        coderHeaderInfo.sequenceId = wrap.getInt();
        return coderHeaderInfo;
    }

    public boolean getCompressType() {
        return this.compress;
    }

    public void setCompressType(boolean z) {
        this.compress = z;
    }

    public int getCommand() {
        return this.command;
    }

    public void setCommand(int i) {
        this.command = i;
    }

    public boolean getEncryptType() {
        return this.encrypt;
    }

    public void setEncryptType(boolean z) {
        this.encrypt = z;
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
