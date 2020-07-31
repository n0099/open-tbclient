package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
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
/* loaded from: classes7.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset bYB = Charset.forName("UTF-8");
    private boolean PZ;
    private byte[] Pm;
    private byte[] bYC;
    private int bYD;
    private String bYE;
    private OpCode bYz;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.Yv());
        dB(webSocketFrame.Yw());
        F(webSocketFrame.Yx());
        G(webSocketFrame.Yz());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        dB(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().Yx().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.bYD = (int) j;
        byte[] bArr = new byte[this.bYD];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.Yx(), 0, bArr, i, webSocketFrame.Yx().length);
            i = webSocketFrame.Yx().length + i;
        }
        F(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        F(bArr);
    }

    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        jp(str);
    }

    private void a(OpCode opCode) {
        this.bYz = opCode;
    }

    public OpCode Yv() {
        return this.bYz;
    }

    private void dB(boolean z) {
        this.PZ = z;
    }

    public boolean Yw() {
        return this.PZ;
    }

    private void F(byte[] bArr) {
        this.Pm = bArr;
        this.bYD = bArr.length;
        this.bYE = null;
    }

    public byte[] Yx() {
        return this.Pm;
    }

    private void jp(String str) {
        this.Pm = jq(str);
        this.bYD = str.length();
        this.bYE = str;
    }

    public String Yy() {
        if (this.bYE == null) {
            this.bYE = H(Yx());
        }
        return this.bYE;
    }

    private void G(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.bYC = bArr;
    }

    private byte[] Yz() {
        return this.bYC;
    }

    private boolean isMasked() {
        return this.bYC != null && this.bYC.length == 4;
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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

    private static String H(byte[] bArr) {
        return o(bArr, 0, bArr.length);
    }

    static String o(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, bYB);
    }

    private static int eR(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame k(InputStream inputStream) throws IOException {
        byte eR = (byte) eR(inputStream.read());
        boolean z = (eR & 128) != 0;
        OpCode find = OpCode.find((byte) (eR & 15));
        if ((eR & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(eR & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (eR & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.m(inputStream);
        webSocketFrame.l(inputStream);
        return webSocketFrame.Yv() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] jq(String str) {
        return str.getBytes(bYB);
    }

    private String YA() {
        if (this.Pm == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.Pm.length).append("b] ");
        if (Yv() == OpCode.Text) {
            String Yy = Yy();
            if (Yy.length() > 100) {
                sb.append(Yy.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(Yy);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.Pm.length, 50); i++) {
                sb.append(Integer.toHexString(this.Pm[i] & 255));
            }
            if (this.Pm.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void l(InputStream inputStream) throws IOException {
        this.Pm = new byte[this.bYD];
        int i = 0;
        while (i < this.bYD) {
            i += eR(inputStream.read(this.Pm, i, this.bYD - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.Pm.length; i2++) {
                byte[] bArr = this.Pm;
                bArr[i2] = (byte) (bArr[i2] ^ this.bYC[i2 % 4]);
            }
        }
        if (Yv() == OpCode.Text) {
            this.bYE = H(Yx());
        }
    }

    private void m(InputStream inputStream) throws IOException {
        int i = 0;
        byte eR = (byte) eR(inputStream.read());
        boolean z = (eR & 128) != 0;
        this.bYD = (byte) (eR & Byte.MAX_VALUE);
        if (this.bYD == 126) {
            this.bYD = ((eR(inputStream.read()) << 8) | eR(inputStream.read())) & 65535;
            if (this.bYD < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.bYD == 127) {
            long eR2 = (eR(inputStream.read()) << 56) | (eR(inputStream.read()) << 48) | (eR(inputStream.read()) << 40) | (eR(inputStream.read()) << 32) | (eR(inputStream.read()) << 24) | (eR(inputStream.read()) << 16) | (eR(inputStream.read()) << 8) | eR(inputStream.read());
            if (eR2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (eR2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.bYD = (int) eR2;
        }
        if (this.bYz.isControlFrame()) {
            if (this.bYD > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.bYz == OpCode.Close && this.bYD == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.bYC = new byte[4];
            while (i < this.bYC.length) {
                i += eR(inputStream.read(this.bYC, i, this.bYC.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = Yv();
        objArr[1] = Yw() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = YA();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.PZ ? (byte) 128 : (byte) 0) | (this.bYz.getValue() & 15)));
        this.bYD = Yx().length;
        if (this.bYD <= 125) {
            outputStream.write(isMasked() ? ((byte) this.bYD) | 128 : (byte) this.bYD);
        } else if (this.bYD < 65536) {
            outputStream.write(isMasked() ? 254 : Opcodes.IAND);
            outputStream.write(this.bYD >>> 8);
            outputStream.write(this.bYD);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.bYD >>> 24);
            outputStream.write(this.bYD >>> 16);
            outputStream.write(this.bYD >>> 8);
            outputStream.write(this.bYD);
        }
        if (isMasked()) {
            outputStream.write(this.bYC);
            for (int i = 0; i < this.bYD; i++) {
                outputStream.write(Yx()[i] ^ this.bYC[i % 4]);
            }
        } else {
            outputStream.write(Yx());
        }
        outputStream.flush();
    }

    /* loaded from: classes7.dex */
    public static class a extends WebSocketFrame {
        private CloseCode bYF;
        private String bYG;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] jq = jq(str);
                byte[] bArr = new byte[jq.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(jq, 0, bArr, 2, jq.length);
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
            if (webSocketFrame.Yx().length >= 2) {
                this.bYF = CloseCode.find(((webSocketFrame.Yx()[0] & 255) << 8) | (webSocketFrame.Yx()[1] & 255));
                this.bYG = o(Yx(), 2, Yx().length - 2);
            }
        }

        public CloseCode YB() {
            return this.bYF;
        }

        public String getCloseReason() {
            return this.bYG;
        }
    }
}
