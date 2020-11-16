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
/* loaded from: classes7.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset cFq = Charset.forName("UTF-8");
    private byte[] QH;
    private boolean Ro;
    private OpCode cFo;
    private byte[] cFr;
    private int cFs;
    private String cFt;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.alI());
        eE(webSocketFrame.alJ());
        G(webSocketFrame.alK());
        H(webSocketFrame.alM());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        eE(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().alK().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.cFs = (int) j;
        byte[] bArr = new byte[this.cFs];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.alK(), 0, bArr, i, webSocketFrame.alK().length);
            i = webSocketFrame.alK().length + i;
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
        mx(str);
    }

    private void a(OpCode opCode) {
        this.cFo = opCode;
    }

    public OpCode alI() {
        return this.cFo;
    }

    private void eE(boolean z) {
        this.Ro = z;
    }

    public boolean alJ() {
        return this.Ro;
    }

    private void G(byte[] bArr) {
        this.QH = bArr;
        this.cFs = bArr.length;
        this.cFt = null;
    }

    public byte[] alK() {
        return this.QH;
    }

    private void mx(String str) {
        this.QH = my(str);
        this.cFs = str.length();
        this.cFt = str;
    }

    public String alL() {
        if (this.cFt == null) {
            this.cFt = I(alK());
        }
        return this.cFt;
    }

    private void H(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.cFr = bArr;
    }

    private byte[] alM() {
        return this.cFr;
    }

    private boolean isMasked() {
        return this.cFr != null && this.cFr.length == 4;
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
        return new String(bArr, i, i2, cFq);
    }

    private static int hM(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame l(InputStream inputStream) throws IOException {
        byte hM = (byte) hM(inputStream.read());
        boolean z = (hM & 128) != 0;
        OpCode find = OpCode.find((byte) (hM & 15));
        if ((hM & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(hM & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (hM & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.n(inputStream);
        webSocketFrame.m(inputStream);
        return webSocketFrame.alI() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] my(String str) {
        return str.getBytes(cFq);
    }

    private String alN() {
        if (this.QH == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.QH.length).append("b] ");
        if (alI() == OpCode.Text) {
            String alL = alL();
            if (alL.length() > 100) {
                sb.append(alL.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(alL);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.QH.length, 50); i++) {
                sb.append(Integer.toHexString(this.QH[i] & 255));
            }
            if (this.QH.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void m(InputStream inputStream) throws IOException {
        this.QH = new byte[this.cFs];
        int i = 0;
        while (i < this.cFs) {
            i += hM(inputStream.read(this.QH, i, this.cFs - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.QH.length; i2++) {
                byte[] bArr = this.QH;
                bArr[i2] = (byte) (bArr[i2] ^ this.cFr[i2 % 4]);
            }
        }
        if (alI() == OpCode.Text) {
            this.cFt = I(alK());
        }
    }

    private void n(InputStream inputStream) throws IOException {
        int i = 0;
        byte hM = (byte) hM(inputStream.read());
        boolean z = (hM & 128) != 0;
        this.cFs = (byte) (hM & Byte.MAX_VALUE);
        if (this.cFs == 126) {
            this.cFs = ((hM(inputStream.read()) << 8) | hM(inputStream.read())) & 65535;
            if (this.cFs < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.cFs == 127) {
            long hM2 = (hM(inputStream.read()) << 56) | (hM(inputStream.read()) << 48) | (hM(inputStream.read()) << 40) | (hM(inputStream.read()) << 32) | (hM(inputStream.read()) << 24) | (hM(inputStream.read()) << 16) | (hM(inputStream.read()) << 8) | hM(inputStream.read());
            if (hM2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (hM2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.cFs = (int) hM2;
        }
        if (this.cFo.isControlFrame()) {
            if (this.cFs > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.cFo == OpCode.Close && this.cFs == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.cFr = new byte[4];
            while (i < this.cFr.length) {
                i += hM(inputStream.read(this.cFr, i, this.cFr.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = alI();
        objArr[1] = alJ() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = alN();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Ro ? (byte) 128 : (byte) 0) | (this.cFo.getValue() & 15)));
        this.cFs = alK().length;
        if (this.cFs <= 125) {
            outputStream.write(isMasked() ? ((byte) this.cFs) | 128 : (byte) this.cFs);
        } else if (this.cFs < 65536) {
            outputStream.write(isMasked() ? GDiffPatcher.COPY_INT_INT : Opcodes.IAND);
            outputStream.write(this.cFs >>> 8);
            outputStream.write(this.cFs);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.cFs >>> 24);
            outputStream.write(this.cFs >>> 16);
            outputStream.write(this.cFs >>> 8);
            outputStream.write(this.cFs);
        }
        if (isMasked()) {
            outputStream.write(this.cFr);
            for (int i = 0; i < this.cFs; i++) {
                outputStream.write(alK()[i] ^ this.cFr[i % 4]);
            }
        } else {
            outputStream.write(alK());
        }
        outputStream.flush();
    }

    /* loaded from: classes7.dex */
    public static class a extends WebSocketFrame {
        private CloseCode cFu;
        private String cFv;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] my = my(str);
                byte[] bArr = new byte[my.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(my, 0, bArr, 2, my.length);
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
            if (webSocketFrame.alK().length >= 2) {
                this.cFu = CloseCode.find(((webSocketFrame.alK()[0] & 255) << 8) | (webSocketFrame.alK()[1] & 255));
                this.cFv = r(alK(), 2, alK().length - 2);
            }
        }

        public CloseCode alO() {
            return this.cFu;
        }

        public String getCloseReason() {
            return this.cFv;
        }
    }
}
