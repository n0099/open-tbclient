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
/* loaded from: classes3.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset cgq = Charset.forName("UTF-8");
    private boolean QW;
    private byte[] Qo;
    private OpCode cgo;
    private byte[] cgr;
    private int cgs;
    private String cgt;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.afl());
        dJ(webSocketFrame.afm());
        G(webSocketFrame.afn());
        H(webSocketFrame.afp());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        dJ(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().afn().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.cgs = (int) j;
        byte[] bArr = new byte[this.cgs];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.afn(), 0, bArr, i, webSocketFrame.afn().length);
            i = webSocketFrame.afn().length + i;
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
        lj(str);
    }

    private void a(OpCode opCode) {
        this.cgo = opCode;
    }

    public OpCode afl() {
        return this.cgo;
    }

    private void dJ(boolean z) {
        this.QW = z;
    }

    public boolean afm() {
        return this.QW;
    }

    private void G(byte[] bArr) {
        this.Qo = bArr;
        this.cgs = bArr.length;
        this.cgt = null;
    }

    public byte[] afn() {
        return this.Qo;
    }

    private void lj(String str) {
        this.Qo = lk(str);
        this.cgs = str.length();
        this.cgt = str;
    }

    public String afo() {
        if (this.cgt == null) {
            this.cgt = I(afn());
        }
        return this.cgt;
    }

    private void H(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.cgr = bArr;
    }

    private byte[] afp() {
        return this.cgr;
    }

    private boolean isMasked() {
        return this.cgr != null && this.cgr.length == 4;
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
        return new String(bArr, i, i2, cgq);
    }

    private static int gY(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame k(InputStream inputStream) throws IOException {
        byte gY = (byte) gY(inputStream.read());
        boolean z = (gY & 128) != 0;
        OpCode find = OpCode.find((byte) (gY & 15));
        if ((gY & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(gY & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (gY & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.m(inputStream);
        webSocketFrame.l(inputStream);
        return webSocketFrame.afl() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] lk(String str) {
        return str.getBytes(cgq);
    }

    private String afq() {
        if (this.Qo == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.Qo.length).append("b] ");
        if (afl() == OpCode.Text) {
            String afo = afo();
            if (afo.length() > 100) {
                sb.append(afo.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(afo);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.Qo.length, 50); i++) {
                sb.append(Integer.toHexString(this.Qo[i] & 255));
            }
            if (this.Qo.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void l(InputStream inputStream) throws IOException {
        this.Qo = new byte[this.cgs];
        int i = 0;
        while (i < this.cgs) {
            i += gY(inputStream.read(this.Qo, i, this.cgs - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.Qo.length; i2++) {
                byte[] bArr = this.Qo;
                bArr[i2] = (byte) (bArr[i2] ^ this.cgr[i2 % 4]);
            }
        }
        if (afl() == OpCode.Text) {
            this.cgt = I(afn());
        }
    }

    private void m(InputStream inputStream) throws IOException {
        int i = 0;
        byte gY = (byte) gY(inputStream.read());
        boolean z = (gY & 128) != 0;
        this.cgs = (byte) (gY & Byte.MAX_VALUE);
        if (this.cgs == 126) {
            this.cgs = ((gY(inputStream.read()) << 8) | gY(inputStream.read())) & 65535;
            if (this.cgs < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.cgs == 127) {
            long gY2 = (gY(inputStream.read()) << 56) | (gY(inputStream.read()) << 48) | (gY(inputStream.read()) << 40) | (gY(inputStream.read()) << 32) | (gY(inputStream.read()) << 24) | (gY(inputStream.read()) << 16) | (gY(inputStream.read()) << 8) | gY(inputStream.read());
            if (gY2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (gY2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.cgs = (int) gY2;
        }
        if (this.cgo.isControlFrame()) {
            if (this.cgs > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.cgo == OpCode.Close && this.cgs == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.cgr = new byte[4];
            while (i < this.cgr.length) {
                i += gY(inputStream.read(this.cgr, i, this.cgr.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = afl();
        objArr[1] = afm() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = afq();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.QW ? (byte) 128 : (byte) 0) | (this.cgo.getValue() & 15)));
        this.cgs = afn().length;
        if (this.cgs <= 125) {
            outputStream.write(isMasked() ? ((byte) this.cgs) | 128 : (byte) this.cgs);
        } else if (this.cgs < 65536) {
            outputStream.write(isMasked() ? 254 : Opcodes.IAND);
            outputStream.write(this.cgs >>> 8);
            outputStream.write(this.cgs);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.cgs >>> 24);
            outputStream.write(this.cgs >>> 16);
            outputStream.write(this.cgs >>> 8);
            outputStream.write(this.cgs);
        }
        if (isMasked()) {
            outputStream.write(this.cgr);
            for (int i = 0; i < this.cgs; i++) {
                outputStream.write(afn()[i] ^ this.cgr[i % 4]);
            }
        } else {
            outputStream.write(afn());
        }
        outputStream.flush();
    }

    /* loaded from: classes3.dex */
    public static class a extends WebSocketFrame {
        private CloseCode cgu;
        private String cgv;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] lk = lk(str);
                byte[] bArr = new byte[lk.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(lk, 0, bArr, 2, lk.length);
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
            if (webSocketFrame.afn().length >= 2) {
                this.cgu = CloseCode.find(((webSocketFrame.afn()[0] & 255) << 8) | (webSocketFrame.afn()[1] & 255));
                this.cgv = p(afn(), 2, afn().length - 2);
            }
        }

        public CloseCode afr() {
            return this.cgu;
        }

        public String getCloseReason() {
            return this.cgv;
        }
    }
}
