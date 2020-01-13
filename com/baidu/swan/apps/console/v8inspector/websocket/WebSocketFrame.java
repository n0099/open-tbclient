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
/* loaded from: classes10.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset bhj = Charset.forName("UTF-8");
    private OpCode bhh;
    private byte[] bhk;
    private int bhl;
    private String bhm;
    private boolean vS;
    private byte[] vm;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.JX());
        cc(webSocketFrame.JY());
        p(webSocketFrame.JZ());
        q(webSocketFrame.Kb());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        cc(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().JZ().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.bhl = (int) j;
        byte[] bArr = new byte[this.bhl];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.JZ(), 0, bArr, i, webSocketFrame.JZ().length);
            i = webSocketFrame.JZ().length + i;
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
        gu(str);
    }

    private void a(OpCode opCode) {
        this.bhh = opCode;
    }

    public OpCode JX() {
        return this.bhh;
    }

    private void cc(boolean z) {
        this.vS = z;
    }

    public boolean JY() {
        return this.vS;
    }

    private void p(byte[] bArr) {
        this.vm = bArr;
        this.bhl = bArr.length;
        this.bhm = null;
    }

    public byte[] JZ() {
        return this.vm;
    }

    private void gu(String str) {
        this.vm = gv(str);
        this.bhl = str.length();
        this.bhm = str;
    }

    public String Ka() {
        if (this.bhm == null) {
            this.bhm = r(JZ());
        }
        return this.bhm;
    }

    private void q(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.bhk = bArr;
    }

    private byte[] Kb() {
        return this.bhk;
    }

    private boolean isMasked() {
        return this.bhk != null && this.bhk.length == 4;
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

    private static String r(byte[] bArr) {
        return g(bArr, 0, bArr.length);
    }

    static String g(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, bhj);
    }

    private static int dY(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame i(InputStream inputStream) throws IOException {
        byte dY = (byte) dY(inputStream.read());
        boolean z = (dY & 128) != 0;
        OpCode find = OpCode.find((byte) (dY & 15));
        if ((dY & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(dY & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (dY & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.k(inputStream);
        webSocketFrame.j(inputStream);
        return webSocketFrame.JX() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] gv(String str) {
        return str.getBytes(bhj);
    }

    private String Kc() {
        if (this.vm == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.vm.length).append("b] ");
        if (JX() == OpCode.Text) {
            String Ka = Ka();
            if (Ka.length() > 100) {
                sb.append(Ka.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(Ka);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.vm.length, 50); i++) {
                sb.append(Integer.toHexString(this.vm[i] & 255));
            }
            if (this.vm.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void j(InputStream inputStream) throws IOException {
        this.vm = new byte[this.bhl];
        int i = 0;
        while (i < this.bhl) {
            i += dY(inputStream.read(this.vm, i, this.bhl - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.vm.length; i2++) {
                byte[] bArr = this.vm;
                bArr[i2] = (byte) (bArr[i2] ^ this.bhk[i2 % 4]);
            }
        }
        if (JX() == OpCode.Text) {
            this.bhm = r(JZ());
        }
    }

    private void k(InputStream inputStream) throws IOException {
        int i = 0;
        byte dY = (byte) dY(inputStream.read());
        boolean z = (dY & 128) != 0;
        this.bhl = (byte) (dY & Byte.MAX_VALUE);
        if (this.bhl == 126) {
            this.bhl = ((dY(inputStream.read()) << 8) | dY(inputStream.read())) & 65535;
            if (this.bhl < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.bhl == 127) {
            long dY2 = (dY(inputStream.read()) << 56) | (dY(inputStream.read()) << 48) | (dY(inputStream.read()) << 40) | (dY(inputStream.read()) << 32) | (dY(inputStream.read()) << 24) | (dY(inputStream.read()) << 16) | (dY(inputStream.read()) << 8) | dY(inputStream.read());
            if (dY2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (dY2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.bhl = (int) dY2;
        }
        if (this.bhh.isControlFrame()) {
            if (this.bhl > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.bhh == OpCode.Close && this.bhl == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.bhk = new byte[4];
            while (i < this.bhk.length) {
                i += dY(inputStream.read(this.bhk, i, this.bhk.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = JX();
        objArr[1] = JY() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = Kc();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.vS ? (byte) 128 : (byte) 0) | (this.bhh.getValue() & 15)));
        this.bhl = JZ().length;
        if (this.bhl <= 125) {
            outputStream.write(isMasked() ? ((byte) this.bhl) | 128 : (byte) this.bhl);
        } else if (this.bhl < 65536) {
            outputStream.write(isMasked() ? 254 : 126);
            outputStream.write(this.bhl >>> 8);
            outputStream.write(this.bhl);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.bhl >>> 24);
            outputStream.write(this.bhl >>> 16);
            outputStream.write(this.bhl >>> 8);
            outputStream.write(this.bhl);
        }
        if (isMasked()) {
            outputStream.write(this.bhk);
            for (int i = 0; i < this.bhl; i++) {
                outputStream.write(JZ()[i] ^ this.bhk[i % 4]);
            }
        } else {
            outputStream.write(JZ());
        }
        outputStream.flush();
    }

    /* loaded from: classes10.dex */
    public static class a extends WebSocketFrame {
        private CloseCode bhn;
        private String bho;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] gv = gv(str);
                byte[] bArr = new byte[gv.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(gv, 0, bArr, 2, gv.length);
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
            if (webSocketFrame.JZ().length >= 2) {
                this.bhn = CloseCode.find(((webSocketFrame.JZ()[0] & 255) << 8) | (webSocketFrame.JZ()[1] & 255));
                this.bho = g(JZ(), 2, JZ().length - 2);
            }
        }

        public CloseCode Kd() {
            return this.bhn;
        }

        public String getCloseReason() {
            return this.bho;
        }
    }
}
