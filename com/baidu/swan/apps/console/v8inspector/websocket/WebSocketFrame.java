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
/* loaded from: classes8.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset cep = Charset.forName("UTF-8");
    private byte[] PV;
    private boolean QD;
    private OpCode cen;
    private byte[] ceq;
    private int cer;
    private String ces;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.aeB());
        dL(webSocketFrame.aeC());
        G(webSocketFrame.aeD());
        H(webSocketFrame.aeF());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        dL(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().aeD().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.cer = (int) j;
        byte[] bArr = new byte[this.cer];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.aeD(), 0, bArr, i, webSocketFrame.aeD().length);
            i = webSocketFrame.aeD().length + i;
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
        kQ(str);
    }

    private void a(OpCode opCode) {
        this.cen = opCode;
    }

    public OpCode aeB() {
        return this.cen;
    }

    private void dL(boolean z) {
        this.QD = z;
    }

    public boolean aeC() {
        return this.QD;
    }

    private void G(byte[] bArr) {
        this.PV = bArr;
        this.cer = bArr.length;
        this.ces = null;
    }

    public byte[] aeD() {
        return this.PV;
    }

    private void kQ(String str) {
        this.PV = kR(str);
        this.cer = str.length();
        this.ces = str;
    }

    public String aeE() {
        if (this.ces == null) {
            this.ces = I(aeD());
        }
        return this.ces;
    }

    private void H(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.ceq = bArr;
    }

    private byte[] aeF() {
        return this.ceq;
    }

    private boolean isMasked() {
        return this.ceq != null && this.ceq.length == 4;
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
        return p(bArr, 0, bArr.length);
    }

    static String p(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, cep);
    }

    private static int gP(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame k(InputStream inputStream) throws IOException {
        byte gP = (byte) gP(inputStream.read());
        boolean z = (gP & 128) != 0;
        OpCode find = OpCode.find((byte) (gP & 15));
        if ((gP & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(gP & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (gP & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.m(inputStream);
        webSocketFrame.l(inputStream);
        return webSocketFrame.aeB() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] kR(String str) {
        return str.getBytes(cep);
    }

    private String aeG() {
        if (this.PV == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.PV.length).append("b] ");
        if (aeB() == OpCode.Text) {
            String aeE = aeE();
            if (aeE.length() > 100) {
                sb.append(aeE.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(aeE);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.PV.length, 50); i++) {
                sb.append(Integer.toHexString(this.PV[i] & 255));
            }
            if (this.PV.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void l(InputStream inputStream) throws IOException {
        this.PV = new byte[this.cer];
        int i = 0;
        while (i < this.cer) {
            i += gP(inputStream.read(this.PV, i, this.cer - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.PV.length; i2++) {
                byte[] bArr = this.PV;
                bArr[i2] = (byte) (bArr[i2] ^ this.ceq[i2 % 4]);
            }
        }
        if (aeB() == OpCode.Text) {
            this.ces = I(aeD());
        }
    }

    private void m(InputStream inputStream) throws IOException {
        int i = 0;
        byte gP = (byte) gP(inputStream.read());
        boolean z = (gP & 128) != 0;
        this.cer = (byte) (gP & Byte.MAX_VALUE);
        if (this.cer == 126) {
            this.cer = ((gP(inputStream.read()) << 8) | gP(inputStream.read())) & 65535;
            if (this.cer < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.cer == 127) {
            long gP2 = (gP(inputStream.read()) << 56) | (gP(inputStream.read()) << 48) | (gP(inputStream.read()) << 40) | (gP(inputStream.read()) << 32) | (gP(inputStream.read()) << 24) | (gP(inputStream.read()) << 16) | (gP(inputStream.read()) << 8) | gP(inputStream.read());
            if (gP2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (gP2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.cer = (int) gP2;
        }
        if (this.cen.isControlFrame()) {
            if (this.cer > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.cen == OpCode.Close && this.cer == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.ceq = new byte[4];
            while (i < this.ceq.length) {
                i += gP(inputStream.read(this.ceq, i, this.ceq.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = aeB();
        objArr[1] = aeC() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = aeG();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.QD ? (byte) 128 : (byte) 0) | (this.cen.getValue() & 15)));
        this.cer = aeD().length;
        if (this.cer <= 125) {
            outputStream.write(isMasked() ? ((byte) this.cer) | 128 : (byte) this.cer);
        } else if (this.cer < 65536) {
            outputStream.write(isMasked() ? 254 : Opcodes.IAND);
            outputStream.write(this.cer >>> 8);
            outputStream.write(this.cer);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.cer >>> 24);
            outputStream.write(this.cer >>> 16);
            outputStream.write(this.cer >>> 8);
            outputStream.write(this.cer);
        }
        if (isMasked()) {
            outputStream.write(this.ceq);
            for (int i = 0; i < this.cer; i++) {
                outputStream.write(aeD()[i] ^ this.ceq[i % 4]);
            }
        } else {
            outputStream.write(aeD());
        }
        outputStream.flush();
    }

    /* loaded from: classes8.dex */
    public static class a extends WebSocketFrame {
        private CloseCode cet;
        private String ceu;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] kR = kR(str);
                byte[] bArr = new byte[kR.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(kR, 0, bArr, 2, kR.length);
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
            if (webSocketFrame.aeD().length >= 2) {
                this.cet = CloseCode.find(((webSocketFrame.aeD()[0] & 255) << 8) | (webSocketFrame.aeD()[1] & 255));
                this.ceu = p(aeD(), 2, aeD().length - 2);
            }
        }

        public CloseCode aeH() {
            return this.cet;
        }

        public String getCloseReason() {
            return this.ceu;
        }
    }
}
