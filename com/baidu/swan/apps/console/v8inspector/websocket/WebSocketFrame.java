package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Log;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.swan.apps.b;
import com.thunder.livesdk.system.ThunderNetStateService;
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
    private static final Charset cQh = Charset.forName("UTF-8");
    private byte[] SY;
    private boolean TD;
    private OpCode cQf;
    private byte[] cQi;
    private int cQj;
    private String cQk;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.amK());
        fa(webSocketFrame.amL());
        F(webSocketFrame.amM());
        G(webSocketFrame.amO());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        fa(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().amM().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.cQj = (int) j;
        byte[] bArr = new byte[this.cQj];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.amM(), 0, bArr, i, webSocketFrame.amM().length);
            i = webSocketFrame.amM().length + i;
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
        ml(str);
    }

    private void a(OpCode opCode) {
        this.cQf = opCode;
    }

    public OpCode amK() {
        return this.cQf;
    }

    private void fa(boolean z) {
        this.TD = z;
    }

    public boolean amL() {
        return this.TD;
    }

    private void F(byte[] bArr) {
        this.SY = bArr;
        this.cQj = bArr.length;
        this.cQk = null;
    }

    public byte[] amM() {
        return this.SY;
    }

    private void ml(String str) {
        this.SY = mm(str);
        this.cQj = str.length();
        this.cQk = str;
    }

    public String amN() {
        if (this.cQk == null) {
            this.cQk = H(amM());
        }
        return this.cQk;
    }

    private void G(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.cQi = bArr;
    }

    private byte[] amO() {
        return this.cQi;
    }

    private boolean isMasked() {
        return this.cQi != null && this.cQi.length == 4;
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

    private static String H(byte[] bArr) {
        return q(bArr, 0, bArr.length);
    }

    static String q(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, cQh);
    }

    private static int gC(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame l(InputStream inputStream) throws IOException {
        byte gC = (byte) gC(inputStream.read());
        boolean z = (gC & 128) != 0;
        OpCode find = OpCode.find((byte) (gC & 15));
        if ((gC & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(gC & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (gC & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.n(inputStream);
        webSocketFrame.m(inputStream);
        return webSocketFrame.amK() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] mm(String str) {
        return str.getBytes(cQh);
    }

    private String amP() {
        if (this.SY == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.SY.length).append("b] ");
        if (amK() == OpCode.Text) {
            String amN = amN();
            if (amN.length() > 100) {
                sb.append(amN.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(amN);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.SY.length, 50); i++) {
                sb.append(Integer.toHexString(this.SY[i] & 255));
            }
            if (this.SY.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void m(InputStream inputStream) throws IOException {
        this.SY = new byte[this.cQj];
        int i = 0;
        while (i < this.cQj) {
            i += gC(inputStream.read(this.SY, i, this.cQj - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.SY.length; i2++) {
                byte[] bArr = this.SY;
                bArr[i2] = (byte) (bArr[i2] ^ this.cQi[i2 % 4]);
            }
        }
        if (amK() == OpCode.Text) {
            this.cQk = H(amM());
        }
    }

    private void n(InputStream inputStream) throws IOException {
        int i = 0;
        byte gC = (byte) gC(inputStream.read());
        boolean z = (gC & 128) != 0;
        this.cQj = (byte) (gC & Byte.MAX_VALUE);
        if (this.cQj == 126) {
            this.cQj = ((gC(inputStream.read()) << 8) | gC(inputStream.read())) & 65535;
            if (this.cQj < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.cQj == 127) {
            long gC2 = (gC(inputStream.read()) << 56) | (gC(inputStream.read()) << 48) | (gC(inputStream.read()) << 40) | (gC(inputStream.read()) << 32) | (gC(inputStream.read()) << 24) | (gC(inputStream.read()) << 16) | (gC(inputStream.read()) << 8) | gC(inputStream.read());
            if (gC2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (gC2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.cQj = (int) gC2;
        }
        if (this.cQf.isControlFrame()) {
            if (this.cQj > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.cQf == OpCode.Close && this.cQj == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.cQi = new byte[4];
            while (i < this.cQi.length) {
                i += gC(inputStream.read(this.cQi, i, this.cQi.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = amK();
        objArr[1] = amL() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = amP();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.TD ? (byte) 128 : (byte) 0) | (this.cQf.getValue() & 15)));
        this.cQj = amM().length;
        if (this.cQj <= 125) {
            outputStream.write(isMasked() ? ((byte) this.cQj) | 128 : (byte) this.cQj);
        } else if (this.cQj < 65536) {
            outputStream.write(isMasked() ? GDiffPatcher.COPY_INT_INT : Opcodes.IAND);
            outputStream.write(this.cQj >>> 8);
            outputStream.write(this.cQj);
        } else {
            outputStream.write(isMasked() ? 255 : ThunderNetStateService.NetState.SYSNET_UNKNOWN);
            outputStream.write(new byte[4]);
            outputStream.write(this.cQj >>> 24);
            outputStream.write(this.cQj >>> 16);
            outputStream.write(this.cQj >>> 8);
            outputStream.write(this.cQj);
        }
        if (isMasked()) {
            outputStream.write(this.cQi);
            for (int i = 0; i < this.cQj; i++) {
                outputStream.write(amM()[i] ^ this.cQi[i % 4]);
            }
        } else {
            outputStream.write(amM());
        }
        outputStream.flush();
    }

    /* loaded from: classes8.dex */
    public static class a extends WebSocketFrame {
        private CloseCode cQl;
        private String cQm;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] mm = mm(str);
                byte[] bArr = new byte[mm.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(mm, 0, bArr, 2, mm.length);
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
            if (webSocketFrame.amM().length >= 2) {
                this.cQl = CloseCode.find(((webSocketFrame.amM()[0] & 255) << 8) | (webSocketFrame.amM()[1] & 255));
                this.cQm = q(amM(), 2, amM().length - 2);
            }
        }

        public CloseCode amQ() {
            return this.cQl;
        }

        public String getCloseReason() {
            return this.cQm;
        }
    }
}
