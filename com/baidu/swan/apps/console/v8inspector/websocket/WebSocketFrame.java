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
    private static final Charset csH = Charset.forName("UTF-8");
    private byte[] QF;
    private boolean Rm;
    private OpCode csF;
    private byte[] csI;
    private int csJ;
    private String csK;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.ahW());
        ef(webSocketFrame.ahX());
        G(webSocketFrame.ahY());
        H(webSocketFrame.aia());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        ef(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().ahY().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.csJ = (int) j;
        byte[] bArr = new byte[this.csJ];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.ahY(), 0, bArr, i, webSocketFrame.ahY().length);
            i = webSocketFrame.ahY().length + i;
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
        lV(str);
    }

    private void a(OpCode opCode) {
        this.csF = opCode;
    }

    public OpCode ahW() {
        return this.csF;
    }

    private void ef(boolean z) {
        this.Rm = z;
    }

    public boolean ahX() {
        return this.Rm;
    }

    private void G(byte[] bArr) {
        this.QF = bArr;
        this.csJ = bArr.length;
        this.csK = null;
    }

    public byte[] ahY() {
        return this.QF;
    }

    private void lV(String str) {
        this.QF = lW(str);
        this.csJ = str.length();
        this.csK = str;
    }

    public String ahZ() {
        if (this.csK == null) {
            this.csK = I(ahY());
        }
        return this.csK;
    }

    private void H(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.csI = bArr;
    }

    private byte[] aia() {
        return this.csI;
    }

    private boolean isMasked() {
        return this.csI != null && this.csI.length == 4;
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
        return new String(bArr, i, i2, csH);
    }

    private static int hv(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame l(InputStream inputStream) throws IOException {
        byte hv = (byte) hv(inputStream.read());
        boolean z = (hv & 128) != 0;
        OpCode find = OpCode.find((byte) (hv & 15));
        if ((hv & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(hv & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (hv & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.n(inputStream);
        webSocketFrame.m(inputStream);
        return webSocketFrame.ahW() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] lW(String str) {
        return str.getBytes(csH);
    }

    private String aib() {
        if (this.QF == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.QF.length).append("b] ");
        if (ahW() == OpCode.Text) {
            String ahZ = ahZ();
            if (ahZ.length() > 100) {
                sb.append(ahZ.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(ahZ);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.QF.length, 50); i++) {
                sb.append(Integer.toHexString(this.QF[i] & 255));
            }
            if (this.QF.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void m(InputStream inputStream) throws IOException {
        this.QF = new byte[this.csJ];
        int i = 0;
        while (i < this.csJ) {
            i += hv(inputStream.read(this.QF, i, this.csJ - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.QF.length; i2++) {
                byte[] bArr = this.QF;
                bArr[i2] = (byte) (bArr[i2] ^ this.csI[i2 % 4]);
            }
        }
        if (ahW() == OpCode.Text) {
            this.csK = I(ahY());
        }
    }

    private void n(InputStream inputStream) throws IOException {
        int i = 0;
        byte hv = (byte) hv(inputStream.read());
        boolean z = (hv & 128) != 0;
        this.csJ = (byte) (hv & Byte.MAX_VALUE);
        if (this.csJ == 126) {
            this.csJ = ((hv(inputStream.read()) << 8) | hv(inputStream.read())) & 65535;
            if (this.csJ < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.csJ == 127) {
            long hv2 = (hv(inputStream.read()) << 56) | (hv(inputStream.read()) << 48) | (hv(inputStream.read()) << 40) | (hv(inputStream.read()) << 32) | (hv(inputStream.read()) << 24) | (hv(inputStream.read()) << 16) | (hv(inputStream.read()) << 8) | hv(inputStream.read());
            if (hv2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (hv2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.csJ = (int) hv2;
        }
        if (this.csF.isControlFrame()) {
            if (this.csJ > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.csF == OpCode.Close && this.csJ == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.csI = new byte[4];
            while (i < this.csI.length) {
                i += hv(inputStream.read(this.csI, i, this.csI.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = ahW();
        objArr[1] = ahX() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = aib();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Rm ? (byte) 128 : (byte) 0) | (this.csF.getValue() & 15)));
        this.csJ = ahY().length;
        if (this.csJ <= 125) {
            outputStream.write(isMasked() ? ((byte) this.csJ) | 128 : (byte) this.csJ);
        } else if (this.csJ < 65536) {
            outputStream.write(isMasked() ? GDiffPatcher.COPY_INT_INT : Opcodes.IAND);
            outputStream.write(this.csJ >>> 8);
            outputStream.write(this.csJ);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.csJ >>> 24);
            outputStream.write(this.csJ >>> 16);
            outputStream.write(this.csJ >>> 8);
            outputStream.write(this.csJ);
        }
        if (isMasked()) {
            outputStream.write(this.csI);
            for (int i = 0; i < this.csJ; i++) {
                outputStream.write(ahY()[i] ^ this.csI[i % 4]);
            }
        } else {
            outputStream.write(ahY());
        }
        outputStream.flush();
    }

    /* loaded from: classes10.dex */
    public static class a extends WebSocketFrame {
        private CloseCode csL;
        private String csM;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] lW = lW(str);
                byte[] bArr = new byte[lW.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(lW, 0, bArr, 2, lW.length);
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
            if (webSocketFrame.ahY().length >= 2) {
                this.csL = CloseCode.find(((webSocketFrame.ahY()[0] & 255) << 8) | (webSocketFrame.ahY()[1] & 255));
                this.csM = r(ahY(), 2, ahY().length - 2);
            }
        }

        public CloseCode aic() {
            return this.csL;
        }

        public String getCloseReason() {
            return this.csM;
        }
    }
}
