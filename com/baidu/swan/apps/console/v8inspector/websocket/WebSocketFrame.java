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
/* loaded from: classes25.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset cMk = Charset.forName("UTF-8");
    private byte[] RA;
    private boolean Si;
    private OpCode cMi;
    private byte[] cMl;
    private int cMm;
    private String cMn;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.aoQ());
        eT(webSocketFrame.aoR());
        I(webSocketFrame.aoS());
        J(webSocketFrame.aoU());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        eT(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().aoS().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.cMm = (int) j;
        byte[] bArr = new byte[this.cMm];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.aoS(), 0, bArr, i, webSocketFrame.aoS().length);
            i = webSocketFrame.aoS().length + i;
        }
        I(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        I(bArr);
    }

    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        ne(str);
    }

    private void a(OpCode opCode) {
        this.cMi = opCode;
    }

    public OpCode aoQ() {
        return this.cMi;
    }

    private void eT(boolean z) {
        this.Si = z;
    }

    public boolean aoR() {
        return this.Si;
    }

    private void I(byte[] bArr) {
        this.RA = bArr;
        this.cMm = bArr.length;
        this.cMn = null;
    }

    public byte[] aoS() {
        return this.RA;
    }

    private void ne(String str) {
        this.RA = nf(str);
        this.cMm = str.length();
        this.cMn = str;
    }

    public String aoT() {
        if (this.cMn == null) {
            this.cMn = K(aoS());
        }
        return this.cMn;
    }

    private void J(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.cMl = bArr;
    }

    private byte[] aoU() {
        return this.cMl;
    }

    private boolean isMasked() {
        return this.cMl != null && this.cMl.length == 4;
    }

    /* loaded from: classes25.dex */
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

    /* loaded from: classes25.dex */
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

    private static String K(byte[] bArr) {
        return r(bArr, 0, bArr.length);
    }

    static String r(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, cMk);
    }

    private static int ik(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame m(InputStream inputStream) throws IOException {
        byte ik = (byte) ik(inputStream.read());
        boolean z = (ik & 128) != 0;
        OpCode find = OpCode.find((byte) (ik & 15));
        if ((ik & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(ik & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (ik & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.o(inputStream);
        webSocketFrame.n(inputStream);
        return webSocketFrame.aoQ() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] nf(String str) {
        return str.getBytes(cMk);
    }

    private String aoV() {
        if (this.RA == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.RA.length).append("b] ");
        if (aoQ() == OpCode.Text) {
            String aoT = aoT();
            if (aoT.length() > 100) {
                sb.append(aoT.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(aoT);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.RA.length, 50); i++) {
                sb.append(Integer.toHexString(this.RA[i] & 255));
            }
            if (this.RA.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void n(InputStream inputStream) throws IOException {
        this.RA = new byte[this.cMm];
        int i = 0;
        while (i < this.cMm) {
            i += ik(inputStream.read(this.RA, i, this.cMm - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.RA.length; i2++) {
                byte[] bArr = this.RA;
                bArr[i2] = (byte) (bArr[i2] ^ this.cMl[i2 % 4]);
            }
        }
        if (aoQ() == OpCode.Text) {
            this.cMn = K(aoS());
        }
    }

    private void o(InputStream inputStream) throws IOException {
        int i = 0;
        byte ik = (byte) ik(inputStream.read());
        boolean z = (ik & 128) != 0;
        this.cMm = (byte) (ik & Byte.MAX_VALUE);
        if (this.cMm == 126) {
            this.cMm = ((ik(inputStream.read()) << 8) | ik(inputStream.read())) & 65535;
            if (this.cMm < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.cMm == 127) {
            long ik2 = (ik(inputStream.read()) << 56) | (ik(inputStream.read()) << 48) | (ik(inputStream.read()) << 40) | (ik(inputStream.read()) << 32) | (ik(inputStream.read()) << 24) | (ik(inputStream.read()) << 16) | (ik(inputStream.read()) << 8) | ik(inputStream.read());
            if (ik2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (ik2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.cMm = (int) ik2;
        }
        if (this.cMi.isControlFrame()) {
            if (this.cMm > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.cMi == OpCode.Close && this.cMm == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.cMl = new byte[4];
            while (i < this.cMl.length) {
                i += ik(inputStream.read(this.cMl, i, this.cMl.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = aoQ();
        objArr[1] = aoR() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = aoV();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Si ? (byte) 128 : (byte) 0) | (this.cMi.getValue() & 15)));
        this.cMm = aoS().length;
        if (this.cMm <= 125) {
            outputStream.write(isMasked() ? ((byte) this.cMm) | 128 : (byte) this.cMm);
        } else if (this.cMm < 65536) {
            outputStream.write(isMasked() ? GDiffPatcher.COPY_INT_INT : Opcodes.IAND);
            outputStream.write(this.cMm >>> 8);
            outputStream.write(this.cMm);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.cMm >>> 24);
            outputStream.write(this.cMm >>> 16);
            outputStream.write(this.cMm >>> 8);
            outputStream.write(this.cMm);
        }
        if (isMasked()) {
            outputStream.write(this.cMl);
            for (int i = 0; i < this.cMm; i++) {
                outputStream.write(aoS()[i] ^ this.cMl[i % 4]);
            }
        } else {
            outputStream.write(aoS());
        }
        outputStream.flush();
    }

    /* loaded from: classes25.dex */
    public static class a extends WebSocketFrame {
        private CloseCode cMo;
        private String cMp;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] nf = nf(str);
                byte[] bArr = new byte[nf.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(nf, 0, bArr, 2, nf.length);
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
            if (webSocketFrame.aoS().length >= 2) {
                this.cMo = CloseCode.find(((webSocketFrame.aoS()[0] & 255) << 8) | (webSocketFrame.aoS()[1] & 255));
                this.cMp = r(aoS(), 2, aoS().length - 2);
            }
        }

        public CloseCode aoW() {
            return this.cMo;
        }

        public String getCloseReason() {
            return this.cMp;
        }
    }
}
