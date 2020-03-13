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
    private static final Charset blx = Charset.forName("UTF-8");
    private String blA;
    private OpCode blv;
    private byte[] bly;
    private int blz;
    private byte[] vE;
    private boolean wk;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.Mo());
        cj(webSocketFrame.Mp());
        u(webSocketFrame.Mq());
        v(webSocketFrame.Ms());
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
            j = it.next().Mq().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.blz = (int) j;
        byte[] bArr = new byte[this.blz];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.Mq(), 0, bArr, i, webSocketFrame.Mq().length);
            i = webSocketFrame.Mq().length + i;
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
        this.blv = opCode;
    }

    public OpCode Mo() {
        return this.blv;
    }

    private void cj(boolean z) {
        this.wk = z;
    }

    public boolean Mp() {
        return this.wk;
    }

    private void u(byte[] bArr) {
        this.vE = bArr;
        this.blz = bArr.length;
        this.blA = null;
    }

    public byte[] Mq() {
        return this.vE;
    }

    private void gJ(String str) {
        this.vE = gK(str);
        this.blz = str.length();
        this.blA = str;
    }

    public String Mr() {
        if (this.blA == null) {
            this.blA = w(Mq());
        }
        return this.blA;
    }

    private void v(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.bly = bArr;
    }

    private byte[] Ms() {
        return this.bly;
    }

    private boolean isMasked() {
        return this.bly != null && this.bly.length == 4;
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
        return new String(bArr, i, i2, blx);
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
        return webSocketFrame.Mo() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] gK(String str) {
        return str.getBytes(blx);
    }

    private String Mt() {
        if (this.vE == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.vE.length).append("b] ");
        if (Mo() == OpCode.Text) {
            String Mr = Mr();
            if (Mr.length() > 100) {
                sb.append(Mr.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(Mr);
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
        this.vE = new byte[this.blz];
        int i = 0;
        while (i < this.blz) {
            i += eo(inputStream.read(this.vE, i, this.blz - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.vE.length; i2++) {
                byte[] bArr = this.vE;
                bArr[i2] = (byte) (bArr[i2] ^ this.bly[i2 % 4]);
            }
        }
        if (Mo() == OpCode.Text) {
            this.blA = w(Mq());
        }
    }

    private void k(InputStream inputStream) throws IOException {
        int i = 0;
        byte eo = (byte) eo(inputStream.read());
        boolean z = (eo & 128) != 0;
        this.blz = (byte) (eo & Byte.MAX_VALUE);
        if (this.blz == 126) {
            this.blz = ((eo(inputStream.read()) << 8) | eo(inputStream.read())) & 65535;
            if (this.blz < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.blz == 127) {
            long eo2 = (eo(inputStream.read()) << 56) | (eo(inputStream.read()) << 48) | (eo(inputStream.read()) << 40) | (eo(inputStream.read()) << 32) | (eo(inputStream.read()) << 24) | (eo(inputStream.read()) << 16) | (eo(inputStream.read()) << 8) | eo(inputStream.read());
            if (eo2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (eo2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.blz = (int) eo2;
        }
        if (this.blv.isControlFrame()) {
            if (this.blz > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.blv == OpCode.Close && this.blz == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.bly = new byte[4];
            while (i < this.bly.length) {
                i += eo(inputStream.read(this.bly, i, this.bly.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = Mo();
        objArr[1] = Mp() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = Mt();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.wk ? (byte) 128 : (byte) 0) | (this.blv.getValue() & 15)));
        this.blz = Mq().length;
        if (this.blz <= 125) {
            outputStream.write(isMasked() ? ((byte) this.blz) | 128 : (byte) this.blz);
        } else if (this.blz < 65536) {
            outputStream.write(isMasked() ? 254 : Opcodes.IAND);
            outputStream.write(this.blz >>> 8);
            outputStream.write(this.blz);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.blz >>> 24);
            outputStream.write(this.blz >>> 16);
            outputStream.write(this.blz >>> 8);
            outputStream.write(this.blz);
        }
        if (isMasked()) {
            outputStream.write(this.bly);
            for (int i = 0; i < this.blz; i++) {
                outputStream.write(Mq()[i] ^ this.bly[i % 4]);
            }
        } else {
            outputStream.write(Mq());
        }
        outputStream.flush();
    }

    /* loaded from: classes11.dex */
    public static class a extends WebSocketFrame {
        private CloseCode blB;
        private String blC;

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
            if (webSocketFrame.Mq().length >= 2) {
                this.blB = CloseCode.find(((webSocketFrame.Mq()[0] & 255) << 8) | (webSocketFrame.Mq()[1] & 255));
                this.blC = k(Mq(), 2, Mq().length - 2);
            }
        }

        public CloseCode Mu() {
            return this.blB;
        }

        public String getCloseReason() {
            return this.blC;
        }
    }
}
