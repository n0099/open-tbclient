package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Log;
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
/* loaded from: classes9.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset bgu = Charset.forName("UTF-8");
    private OpCode bgr;
    private byte[] bgv;
    private int bgw;
    private String bgx;
    private boolean vP;
    private byte[] vj;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.JB());
        bX(webSocketFrame.JC());
        p(webSocketFrame.JD());
        q(webSocketFrame.JF());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        bX(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().JD().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.bgw = (int) j;
        byte[] bArr = new byte[this.bgw];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.JD(), 0, bArr, i, webSocketFrame.JD().length);
            i = webSocketFrame.JD().length + i;
        }
        p(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        p(bArr);
    }

    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        gq(str);
    }

    private void a(OpCode opCode) {
        this.bgr = opCode;
    }

    public OpCode JB() {
        return this.bgr;
    }

    private void bX(boolean z) {
        this.vP = z;
    }

    public boolean JC() {
        return this.vP;
    }

    private void p(byte[] bArr) {
        this.vj = bArr;
        this.bgw = bArr.length;
        this.bgx = null;
    }

    public byte[] JD() {
        return this.vj;
    }

    private void gq(String str) {
        this.vj = gr(str);
        this.bgw = str.length();
        this.bgx = str;
    }

    public String JE() {
        if (this.bgx == null) {
            this.bgx = r(JD());
        }
        return this.bgx;
    }

    private void q(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.bgv = bArr;
    }

    private byte[] JF() {
        return this.bgv;
    }

    private boolean isMasked() {
        return this.bgv != null && this.bgv.length == 4;
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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

    private static String r(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    static String g(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, bgu);
    }

    private static int dX(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame i(InputStream inputStream) throws IOException {
        byte dX = (byte) dX(inputStream.read());
        boolean z = (dX & 128) != 0;
        OpCode find = OpCode.find((byte) (dX & 15));
        if ((dX & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(dX & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (dX & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.k(inputStream);
        webSocketFrame.j(inputStream);
        return webSocketFrame.JB() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] gr(String str) {
        return str.getBytes(bgu);
    }

    private String JG() {
        if (this.vj == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.vj.length).append("b] ");
        if (JB() == OpCode.Text) {
            String JE = JE();
            if (JE.length() > 100) {
                sb.append(JE.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(JE);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.vj.length, 50); i++) {
                sb.append(Integer.toHexString(this.vj[i] & 255));
            }
            if (this.vj.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void j(InputStream inputStream) throws IOException {
        this.vj = new byte[this.bgw];
        int i = 0;
        while (i < this.bgw) {
            i += dX(inputStream.read(this.vj, i, this.bgw - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.vj.length; i2++) {
                byte[] bArr = this.vj;
                bArr[i2] = (byte) (bArr[i2] ^ this.bgv[i2 % 4]);
            }
        }
        if (JB() == OpCode.Text) {
            this.bgx = r(JD());
        }
    }

    private void k(InputStream inputStream) throws IOException {
        int i = 0;
        byte dX = (byte) dX(inputStream.read());
        boolean z = (dX & 128) != 0;
        this.bgw = (byte) (dX & Byte.MAX_VALUE);
        if (this.bgw == 126) {
            this.bgw = ((dX(inputStream.read()) << 8) | dX(inputStream.read())) & 65535;
            if (this.bgw < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.bgw == 127) {
            long dX2 = (dX(inputStream.read()) << 56) | (dX(inputStream.read()) << 48) | (dX(inputStream.read()) << 40) | (dX(inputStream.read()) << 32) | (dX(inputStream.read()) << 24) | (dX(inputStream.read()) << 16) | (dX(inputStream.read()) << 8) | dX(inputStream.read());
            if (dX2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (dX2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.bgw = (int) dX2;
        }
        if (this.bgr.isControlFrame()) {
            if (this.bgw > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.bgr == OpCode.Close && this.bgw == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.bgv = new byte[4];
            while (i < this.bgv.length) {
                i += dX(inputStream.read(this.bgv, i, this.bgv.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = JB();
        objArr[1] = JC() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = JG();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.vP ? (byte) 128 : (byte) 0) | (this.bgr.getValue() & 15)));
        this.bgw = JD().length;
        if (this.bgw <= 125) {
            outputStream.write(isMasked() ? ((byte) this.bgw) | 128 : (byte) this.bgw);
        } else if (this.bgw < 65536) {
            outputStream.write(isMasked() ? 254 : 126);
            outputStream.write(this.bgw >>> 8);
            outputStream.write(this.bgw);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.bgw >>> 24);
            outputStream.write(this.bgw >>> 16);
            outputStream.write(this.bgw >>> 8);
            outputStream.write(this.bgw);
        }
        if (isMasked()) {
            outputStream.write(this.bgv);
            for (int i = 0; i < this.bgw; i++) {
                outputStream.write(JD()[i] ^ this.bgv[i % 4]);
            }
        } else {
            outputStream.write(JD());
        }
        outputStream.flush();
    }

    /* loaded from: classes9.dex */
    public static class a extends WebSocketFrame {
        private CloseCode bgy;
        private String bgz;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] gr = gr(str);
                byte[] bArr = new byte[gr.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(gr, 0, bArr, 2, gr.length);
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
            if (webSocketFrame.JD().length >= 2) {
                this.bgy = CloseCode.find(((webSocketFrame.JD()[0] & 255) << 8) | (webSocketFrame.JD()[1] & 255));
                this.bgz = g(JD(), 2, JD().length - 2);
            }
        }

        public CloseCode JH() {
            return this.bgy;
        }

        public String getCloseReason() {
            return this.bgz;
        }
    }
}
