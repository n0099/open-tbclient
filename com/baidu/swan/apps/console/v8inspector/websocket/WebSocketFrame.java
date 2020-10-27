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
    private static final Charset cBh = Charset.forName("UTF-8");
    private byte[] QG;
    private boolean Rn;
    private OpCode cBf;
    private byte[] cBi;
    private int cBj;
    private String cBk;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.ajQ());
        es(webSocketFrame.ajR());
        G(webSocketFrame.ajS());
        H(webSocketFrame.ajU());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        es(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().ajS().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.cBj = (int) j;
        byte[] bArr = new byte[this.cBj];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.ajS(), 0, bArr, i, webSocketFrame.ajS().length);
            i = webSocketFrame.ajS().length + i;
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
        mo(str);
    }

    private void a(OpCode opCode) {
        this.cBf = opCode;
    }

    public OpCode ajQ() {
        return this.cBf;
    }

    private void es(boolean z) {
        this.Rn = z;
    }

    public boolean ajR() {
        return this.Rn;
    }

    private void G(byte[] bArr) {
        this.QG = bArr;
        this.cBj = bArr.length;
        this.cBk = null;
    }

    public byte[] ajS() {
        return this.QG;
    }

    private void mo(String str) {
        this.QG = mp(str);
        this.cBj = str.length();
        this.cBk = str;
    }

    public String ajT() {
        if (this.cBk == null) {
            this.cBk = I(ajS());
        }
        return this.cBk;
    }

    private void H(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.cBi = bArr;
    }

    private byte[] ajU() {
        return this.cBi;
    }

    private boolean isMasked() {
        return this.cBi != null && this.cBi.length == 4;
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
        return new String(bArr, i, i2, cBh);
    }

    private static int hG(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame l(InputStream inputStream) throws IOException {
        byte hG = (byte) hG(inputStream.read());
        boolean z = (hG & 128) != 0;
        OpCode find = OpCode.find((byte) (hG & 15));
        if ((hG & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(hG & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (hG & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.n(inputStream);
        webSocketFrame.m(inputStream);
        return webSocketFrame.ajQ() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] mp(String str) {
        return str.getBytes(cBh);
    }

    private String ajV() {
        if (this.QG == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.QG.length).append("b] ");
        if (ajQ() == OpCode.Text) {
            String ajT = ajT();
            if (ajT.length() > 100) {
                sb.append(ajT.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(ajT);
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
        this.QG = new byte[this.cBj];
        int i = 0;
        while (i < this.cBj) {
            i += hG(inputStream.read(this.QG, i, this.cBj - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.QG.length; i2++) {
                byte[] bArr = this.QG;
                bArr[i2] = (byte) (bArr[i2] ^ this.cBi[i2 % 4]);
            }
        }
        if (ajQ() == OpCode.Text) {
            this.cBk = I(ajS());
        }
    }

    private void n(InputStream inputStream) throws IOException {
        int i = 0;
        byte hG = (byte) hG(inputStream.read());
        boolean z = (hG & 128) != 0;
        this.cBj = (byte) (hG & Byte.MAX_VALUE);
        if (this.cBj == 126) {
            this.cBj = ((hG(inputStream.read()) << 8) | hG(inputStream.read())) & 65535;
            if (this.cBj < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.cBj == 127) {
            long hG2 = (hG(inputStream.read()) << 56) | (hG(inputStream.read()) << 48) | (hG(inputStream.read()) << 40) | (hG(inputStream.read()) << 32) | (hG(inputStream.read()) << 24) | (hG(inputStream.read()) << 16) | (hG(inputStream.read()) << 8) | hG(inputStream.read());
            if (hG2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (hG2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.cBj = (int) hG2;
        }
        if (this.cBf.isControlFrame()) {
            if (this.cBj > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.cBf == OpCode.Close && this.cBj == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.cBi = new byte[4];
            while (i < this.cBi.length) {
                i += hG(inputStream.read(this.cBi, i, this.cBi.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = ajQ();
        objArr[1] = ajR() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = ajV();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Rn ? (byte) 128 : (byte) 0) | (this.cBf.getValue() & 15)));
        this.cBj = ajS().length;
        if (this.cBj <= 125) {
            outputStream.write(isMasked() ? ((byte) this.cBj) | 128 : (byte) this.cBj);
        } else if (this.cBj < 65536) {
            outputStream.write(isMasked() ? GDiffPatcher.COPY_INT_INT : Opcodes.IAND);
            outputStream.write(this.cBj >>> 8);
            outputStream.write(this.cBj);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.cBj >>> 24);
            outputStream.write(this.cBj >>> 16);
            outputStream.write(this.cBj >>> 8);
            outputStream.write(this.cBj);
        }
        if (isMasked()) {
            outputStream.write(this.cBi);
            for (int i = 0; i < this.cBj; i++) {
                outputStream.write(ajS()[i] ^ this.cBi[i % 4]);
            }
        } else {
            outputStream.write(ajS());
        }
        outputStream.flush();
    }

    /* loaded from: classes10.dex */
    public static class a extends WebSocketFrame {
        private CloseCode cBl;
        private String cBm;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] mp = mp(str);
                byte[] bArr = new byte[mp.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(mp, 0, bArr, 2, mp.length);
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
            if (webSocketFrame.ajS().length >= 2) {
                this.cBl = CloseCode.find(((webSocketFrame.ajS()[0] & 255) << 8) | (webSocketFrame.ajS()[1] & 255));
                this.cBm = r(ajS(), 2, ajS().length - 2);
            }
        }

        public CloseCode ajW() {
            return this.cBl;
        }

        public String getCloseReason() {
            return this.cBm;
        }
    }
}
