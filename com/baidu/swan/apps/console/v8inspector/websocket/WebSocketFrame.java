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
/* loaded from: classes11.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset blv = Charset.forName("UTF-8");
    private OpCode blt;
    private byte[] blw;
    private int blx;
    private String bly;
    private byte[] vE;
    private boolean wk;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.Mm());
        cj(webSocketFrame.Mn());
        u(webSocketFrame.Mo());
        v(webSocketFrame.Mq());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        cj(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().Mo().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.blx = (int) j;
        byte[] bArr = new byte[this.blx];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.Mo(), 0, bArr, i, webSocketFrame.Mo().length);
            i = webSocketFrame.Mo().length + i;
        }
        u(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        u(bArr);
    }

    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        gJ(str);
    }

    private void a(OpCode opCode) {
        this.blt = opCode;
    }

    public OpCode Mm() {
        return this.blt;
    }

    private void cj(boolean z) {
        this.wk = z;
    }

    public boolean Mn() {
        return this.wk;
    }

    private void u(byte[] bArr) {
        this.vE = bArr;
        this.blx = bArr.length;
        this.bly = null;
    }

    public byte[] Mo() {
        return this.vE;
    }

    private void gJ(String str) {
        this.vE = gK(str);
        this.blx = str.length();
        this.bly = str;
    }

    public String Mp() {
        if (this.bly == null) {
            this.bly = w(Mo());
        }
        return this.bly;
    }

    private void v(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.blw = bArr;
    }

    private byte[] Mq() {
        return this.blw;
    }

    private boolean isMasked() {
        return this.blw != null && this.blw.length == 4;
    }

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
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

    private static String w(byte[] bArr) {
        return k(bArr, 0, bArr.length);
    }

    static String k(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, blv);
    }

    private static int eo(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame i(InputStream inputStream) throws IOException {
        byte eo = (byte) eo(inputStream.read());
        boolean z = (eo & 128) != 0;
        OpCode find = OpCode.find((byte) (eo & 15));
        if ((eo & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(eo & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (eo & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.k(inputStream);
        webSocketFrame.j(inputStream);
        return webSocketFrame.Mm() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] gK(String str) {
        return str.getBytes(blv);
    }

    private String Mr() {
        if (this.vE == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.vE.length).append("b] ");
        if (Mm() == OpCode.Text) {
            String Mp = Mp();
            if (Mp.length() > 100) {
                sb.append(Mp.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(Mp);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.vE.length, 50); i++) {
                sb.append(Integer.toHexString(this.vE[i] & 255));
            }
            if (this.vE.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void j(InputStream inputStream) throws IOException {
        this.vE = new byte[this.blx];
        int i = 0;
        while (i < this.blx) {
            i += eo(inputStream.read(this.vE, i, this.blx - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.vE.length; i2++) {
                byte[] bArr = this.vE;
                bArr[i2] = (byte) (bArr[i2] ^ this.blw[i2 % 4]);
            }
        }
        if (Mm() == OpCode.Text) {
            this.bly = w(Mo());
        }
    }

    private void k(InputStream inputStream) throws IOException {
        int i = 0;
        byte eo = (byte) eo(inputStream.read());
        boolean z = (eo & 128) != 0;
        this.blx = (byte) (eo & Byte.MAX_VALUE);
        if (this.blx == 126) {
            this.blx = ((eo(inputStream.read()) << 8) | eo(inputStream.read())) & 65535;
            if (this.blx < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.blx == 127) {
            long eo2 = (eo(inputStream.read()) << 56) | (eo(inputStream.read()) << 48) | (eo(inputStream.read()) << 40) | (eo(inputStream.read()) << 32) | (eo(inputStream.read()) << 24) | (eo(inputStream.read()) << 16) | (eo(inputStream.read()) << 8) | eo(inputStream.read());
            if (eo2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (eo2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.blx = (int) eo2;
        }
        if (this.blt.isControlFrame()) {
            if (this.blx > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.blt == OpCode.Close && this.blx == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.blw = new byte[4];
            while (i < this.blw.length) {
                i += eo(inputStream.read(this.blw, i, this.blw.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = Mm();
        objArr[1] = Mn() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = Mr();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.wk ? (byte) 128 : (byte) 0) | (this.blt.getValue() & 15)));
        this.blx = Mo().length;
        if (this.blx <= 125) {
            outputStream.write(isMasked() ? ((byte) this.blx) | 128 : (byte) this.blx);
        } else if (this.blx < 65536) {
            outputStream.write(isMasked() ? 254 : Opcodes.IAND);
            outputStream.write(this.blx >>> 8);
            outputStream.write(this.blx);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.blx >>> 24);
            outputStream.write(this.blx >>> 16);
            outputStream.write(this.blx >>> 8);
            outputStream.write(this.blx);
        }
        if (isMasked()) {
            outputStream.write(this.blw);
            for (int i = 0; i < this.blx; i++) {
                outputStream.write(Mo()[i] ^ this.blw[i % 4]);
            }
        } else {
            outputStream.write(Mo());
        }
        outputStream.flush();
    }

    /* loaded from: classes11.dex */
    public static class a extends WebSocketFrame {
        private String blA;
        private CloseCode blz;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] gK = gK(str);
                byte[] bArr = new byte[gK.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(gK, 0, bArr, 2, gK.length);
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
            if (webSocketFrame.Mo().length >= 2) {
                this.blz = CloseCode.find(((webSocketFrame.Mo()[0] & 255) << 8) | (webSocketFrame.Mo()[1] & 255));
                this.blA = k(Mo(), 2, Mo().length - 2);
            }
        }

        public CloseCode Ms() {
            return this.blz;
        }

        public String getCloseReason() {
            return this.blA;
        }
    }
}
