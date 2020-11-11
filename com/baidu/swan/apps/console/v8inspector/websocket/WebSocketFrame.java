package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.swan.apps.b;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset cHa = Charset.forName("UTF-8");
    private byte[] QG;
    private boolean Rn;
    private OpCode cGY;
    private byte[] cHb;
    private int cHc;
    private String cHd;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.amq());
        eB(webSocketFrame.amr());
        G(webSocketFrame.ams());
        H(webSocketFrame.amu());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        eB(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().ams().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.cHc = (int) j;
        byte[] bArr = new byte[this.cHc];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.ams(), 0, bArr, i, webSocketFrame.ams().length);
            i = webSocketFrame.ams().length + i;
        }
        G(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        G(bArr);
    }

    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        mD(str);
    }

    private void a(OpCode opCode) {
        this.cGY = opCode;
    }

    public OpCode amq() {
        return this.cGY;
    }

    private void eB(boolean z) {
        this.Rn = z;
    }

    public boolean amr() {
        return this.Rn;
    }

    private void G(byte[] bArr) {
        this.QG = bArr;
        this.cHc = bArr.length;
        this.cHd = null;
    }

    public byte[] ams() {
        return this.QG;
    }

    private void mD(String str) {
        this.QG = mE(str);
        this.cHc = str.length();
        this.cHd = str;
    }

    public String amt() {
        if (this.cHd == null) {
            this.cHd = I(ams());
        }
        return this.cHd;
    }

    private void H(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.cHb = bArr;
    }

    private byte[] amu() {
        return this.cHb;
    }

    private boolean isMasked() {
        return this.cHb != null && this.cHb.length == 4;
    }

    /* loaded from: classes10.dex */
    public enum CloseCode {
        NormalClosure(1000),
        ProtocolError(1002),
        MessageTooLong(1009);
        
        private final int mCode;

        public static CloseCode find(int i) {
            CloseCode[] values;
            for (CloseCode closeCode : values()) {
                if (closeCode.getValue() == i) {
                    return closeCode;
                }
            }
            return null;
        }

        CloseCode(int i) {
            this.mCode = i;
        }

        public int getValue() {
            return this.mCode;
        }
    }

    /* loaded from: classes10.dex */
    public enum OpCode {
        Continuation(0),
        Text(1),
        Binary(2),
        Close(8),
        Ping(9),
        Pong(10);
        
        private final byte mCode;

        public static OpCode find(byte b) {
            OpCode[] values;
            for (OpCode opCode : values()) {
                if (opCode.getValue() == b) {
                    return opCode;
                }
            }
            return null;
        }

        OpCode(int i) {
            this.mCode = (byte) i;
        }

        public byte getValue() {
            return this.mCode;
        }

        public boolean isControlFrame() {
            return this == Close || this == Ping || this == Pong;
        }
    }

    private static String I(byte[] bArr) {
        return r(bArr, 0, bArr.length);
    }

    static String r(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, cHa);
    }

    private static int hQ(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame l(InputStream inputStream) throws IOException {
        byte hQ = (byte) hQ(inputStream.read());
        boolean z = (hQ & 128) != 0;
        OpCode find = OpCode.find((byte) (hQ & 15));
        if ((hQ & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(hQ & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (hQ & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.n(inputStream);
        webSocketFrame.m(inputStream);
        return webSocketFrame.amq() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] mE(String str) {
        return str.getBytes(cHa);
    }

    private String amv() {
        if (this.QG == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.QG.length).append("b] ");
        if (amq() == OpCode.Text) {
            String amt = amt();
            if (amt.length() > 100) {
                sb.append(amt.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(amt);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.QG.length, 50); i++) {
                sb.append(Integer.toHexString(this.QG[i] & 255));
            }
            if (this.QG.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void m(InputStream inputStream) throws IOException {
        this.QG = new byte[this.cHc];
        int i = 0;
        while (i < this.cHc) {
            i += hQ(inputStream.read(this.QG, i, this.cHc - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.QG.length; i2++) {
                byte[] bArr = this.QG;
                bArr[i2] = (byte) (bArr[i2] ^ this.cHb[i2 % 4]);
            }
        }
        if (amq() == OpCode.Text) {
            this.cHd = I(ams());
        }
    }

    private void n(InputStream inputStream) throws IOException {
        int i = 0;
        byte hQ = (byte) hQ(inputStream.read());
        boolean z = (hQ & 128) != 0;
        this.cHc = (byte) (hQ & Byte.MAX_VALUE);
        if (this.cHc == 126) {
            this.cHc = ((hQ(inputStream.read()) << 8) | hQ(inputStream.read())) & 65535;
            if (this.cHc < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.cHc == 127) {
            long hQ2 = (hQ(inputStream.read()) << 56) | (hQ(inputStream.read()) << 48) | (hQ(inputStream.read()) << 40) | (hQ(inputStream.read()) << 32) | (hQ(inputStream.read()) << 24) | (hQ(inputStream.read()) << 16) | (hQ(inputStream.read()) << 8) | hQ(inputStream.read());
            if (hQ2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (hQ2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.cHc = (int) hQ2;
        }
        if (this.cGY.isControlFrame()) {
            if (this.cHc > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.cGY == OpCode.Close && this.cHc == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.cHb = new byte[4];
            while (i < this.cHb.length) {
                i += hQ(inputStream.read(this.cHb, i, this.cHb.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = amq();
        objArr[1] = amr() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = amv();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Rn ? (byte) 128 : (byte) 0) | (this.cGY.getValue() & 15)));
        this.cHc = ams().length;
        if (this.cHc <= 125) {
            outputStream.write(isMasked() ? ((byte) this.cHc) | 128 : (byte) this.cHc);
        } else if (this.cHc < 65536) {
            outputStream.write(isMasked() ? GDiffPatcher.COPY_INT_INT : Opcodes.IAND);
            outputStream.write(this.cHc >>> 8);
            outputStream.write(this.cHc);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.cHc >>> 24);
            outputStream.write(this.cHc >>> 16);
            outputStream.write(this.cHc >>> 8);
            outputStream.write(this.cHc);
        }
        if (isMasked()) {
            outputStream.write(this.cHb);
            for (int i = 0; i < this.cHc; i++) {
                outputStream.write(ams()[i] ^ this.cHb[i % 4]);
            }
        } else {
            outputStream.write(ams());
        }
        outputStream.flush();
    }

    /* loaded from: classes10.dex */
    public static class a extends WebSocketFrame {
        private CloseCode cHe;
        private String cHf;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] mE = mE(str);
                byte[] bArr = new byte[mE.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(mE, 0, bArr, 2, mE.length);
                return bArr;
            }
            return new byte[0];
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(CloseCode closeCode, String str) {
            super(OpCode.Close, true, b(closeCode, str));
        }

        private a(WebSocketFrame webSocketFrame) {
            super(webSocketFrame);
            if (webSocketFrame.ams().length >= 2) {
                this.cHe = CloseCode.find(((webSocketFrame.ams()[0] & 255) << 8) | (webSocketFrame.ams()[1] & 255));
                this.cHf = r(ams(), 2, ams().length - 2);
            }
        }

        public CloseCode amw() {
            return this.cHe;
        }

        public String getCloseReason() {
            return this.cHf;
        }
    }
}
