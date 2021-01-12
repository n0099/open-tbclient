package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Log;
import androidx.core.internal.view.SupportMenu;
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
/* loaded from: classes8.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset cMt = Charset.forName("UTF-8");
    private byte[] RB;
    private boolean Sj;
    private OpCode cMr;
    private byte[] cMu;
    private int cMv;
    private String cMw;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.amj());
        eY(webSocketFrame.amk());
        E(webSocketFrame.aml());
        F(webSocketFrame.amn());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        eY(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().aml().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.cMv = (int) j;
        byte[] bArr = new byte[this.cMv];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.aml(), 0, bArr, i, webSocketFrame.aml().length);
            i = webSocketFrame.aml().length + i;
        }
        E(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        E(bArr);
    }

    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        lM(str);
    }

    private void a(OpCode opCode) {
        this.cMr = opCode;
    }

    public OpCode amj() {
        return this.cMr;
    }

    private void eY(boolean z) {
        this.Sj = z;
    }

    public boolean amk() {
        return this.Sj;
    }

    private void E(byte[] bArr) {
        this.RB = bArr;
        this.cMv = bArr.length;
        this.cMw = null;
    }

    public byte[] aml() {
        return this.RB;
    }

    private void lM(String str) {
        this.RB = lN(str);
        this.cMv = str.length();
        this.cMw = str;
    }

    public String amm() {
        if (this.cMw == null) {
            this.cMw = G(aml());
        }
        return this.cMw;
    }

    private void F(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.cMu = bArr;
    }

    private byte[] amn() {
        return this.cMu;
    }

    private boolean isMasked() {
        return this.cMu != null && this.cMu.length == 4;
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

        public static OpCode find(byte b2) {
            OpCode[] values;
            for (OpCode opCode : values()) {
                if (opCode.getValue() == b2) {
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

    private static String G(byte[] bArr) {
        return q(bArr, 0, bArr.length);
    }

    static String q(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, cMt);
    }

    private static int gy(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame n(InputStream inputStream) throws IOException {
        byte gy = (byte) gy(inputStream.read());
        boolean z = (gy & 128) != 0;
        OpCode find = OpCode.find((byte) (gy & 15));
        if ((gy & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(gy & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (gy & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.p(inputStream);
        webSocketFrame.o(inputStream);
        return webSocketFrame.amj() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] lN(String str) {
        return str.getBytes(cMt);
    }

    private String amo() {
        if (this.RB == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.RB.length).append("b] ");
        if (amj() == OpCode.Text) {
            String amm = amm();
            if (amm.length() > 100) {
                sb.append(amm.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(amm);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.RB.length, 50); i++) {
                sb.append(Integer.toHexString(this.RB[i] & 255));
            }
            if (this.RB.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void o(InputStream inputStream) throws IOException {
        this.RB = new byte[this.cMv];
        int i = 0;
        while (i < this.cMv) {
            i += gy(inputStream.read(this.RB, i, this.cMv - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.RB.length; i2++) {
                byte[] bArr = this.RB;
                bArr[i2] = (byte) (bArr[i2] ^ this.cMu[i2 % 4]);
            }
        }
        if (amj() == OpCode.Text) {
            this.cMw = G(aml());
        }
    }

    private void p(InputStream inputStream) throws IOException {
        int i = 0;
        byte gy = (byte) gy(inputStream.read());
        boolean z = (gy & 128) != 0;
        this.cMv = (byte) (gy & Byte.MAX_VALUE);
        if (this.cMv == 126) {
            this.cMv = ((gy(inputStream.read()) << 8) | gy(inputStream.read())) & SupportMenu.USER_MASK;
            if (this.cMv < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.cMv == 127) {
            long gy2 = (gy(inputStream.read()) << 56) | (gy(inputStream.read()) << 48) | (gy(inputStream.read()) << 40) | (gy(inputStream.read()) << 32) | (gy(inputStream.read()) << 24) | (gy(inputStream.read()) << 16) | (gy(inputStream.read()) << 8) | gy(inputStream.read());
            if (gy2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (gy2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.cMv = (int) gy2;
        }
        if (this.cMr.isControlFrame()) {
            if (this.cMv > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.cMr == OpCode.Close && this.cMv == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.cMu = new byte[4];
            while (i < this.cMu.length) {
                i += gy(inputStream.read(this.cMu, i, this.cMu.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = amj();
        objArr[1] = amk() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = amo();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Sj ? (byte) 128 : (byte) 0) | (this.cMr.getValue() & 15)));
        this.cMv = aml().length;
        if (this.cMv <= 125) {
            outputStream.write(isMasked() ? ((byte) this.cMv) | 128 : (byte) this.cMv);
        } else if (this.cMv < 65536) {
            outputStream.write(isMasked() ? GDiffPatcher.COPY_INT_INT : Opcodes.IAND);
            outputStream.write(this.cMv >>> 8);
            outputStream.write(this.cMv);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.cMv >>> 24);
            outputStream.write(this.cMv >>> 16);
            outputStream.write(this.cMv >>> 8);
            outputStream.write(this.cMv);
        }
        if (isMasked()) {
            outputStream.write(this.cMu);
            for (int i = 0; i < this.cMv; i++) {
                outputStream.write(aml()[i] ^ this.cMu[i % 4]);
            }
        } else {
            outputStream.write(aml());
        }
        outputStream.flush();
    }

    /* loaded from: classes8.dex */
    public static class a extends WebSocketFrame {
        private CloseCode cMx;
        private String cMy;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] lN = lN(str);
                byte[] bArr = new byte[lN.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(lN, 0, bArr, 2, lN.length);
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
            if (webSocketFrame.aml().length >= 2) {
                this.cMx = CloseCode.find(((webSocketFrame.aml()[0] & 255) << 8) | (webSocketFrame.aml()[1] & 255));
                this.cMy = q(aml(), 2, aml().length - 2);
            }
        }

        public CloseCode amp() {
            return this.cMx;
        }

        public String getCloseReason() {
            return this.cMy;
        }
    }
}
