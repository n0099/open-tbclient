package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Log;
import androidx.core.internal.view.SupportMenu;
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
/* loaded from: classes9.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset cOH = Charset.forName("UTF-8");
    private byte[] Rz;
    private boolean Sh;
    private OpCode cOF;
    private byte[] cOI;
    private int cOJ;
    private String cOK;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.amH());
        fa(webSocketFrame.amI());
        D(webSocketFrame.amJ());
        E(webSocketFrame.amL());
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
            j = it.next().amJ().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.cOJ = (int) j;
        byte[] bArr = new byte[this.cOJ];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.amJ(), 0, bArr, i, webSocketFrame.amJ().length);
            i = webSocketFrame.amJ().length + i;
        }
        D(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        D(bArr);
    }

    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        me(str);
    }

    private void a(OpCode opCode) {
        this.cOF = opCode;
    }

    public OpCode amH() {
        return this.cOF;
    }

    private void fa(boolean z) {
        this.Sh = z;
    }

    public boolean amI() {
        return this.Sh;
    }

    private void D(byte[] bArr) {
        this.Rz = bArr;
        this.cOJ = bArr.length;
        this.cOK = null;
    }

    public byte[] amJ() {
        return this.Rz;
    }

    private void me(String str) {
        this.Rz = mf(str);
        this.cOJ = str.length();
        this.cOK = str;
    }

    public String amK() {
        if (this.cOK == null) {
            this.cOK = F(amJ());
        }
        return this.cOK;
    }

    private void E(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.cOI = bArr;
    }

    private byte[] amL() {
        return this.cOI;
    }

    private boolean isMasked() {
        return this.cOI != null && this.cOI.length == 4;
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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

    private static String F(byte[] bArr) {
        return q(bArr, 0, bArr.length);
    }

    static String q(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, cOH);
    }

    private static int gB(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame l(InputStream inputStream) throws IOException {
        byte gB = (byte) gB(inputStream.read());
        boolean z = (gB & 128) != 0;
        OpCode find = OpCode.find((byte) (gB & 15));
        if ((gB & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(gB & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (gB & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.n(inputStream);
        webSocketFrame.m(inputStream);
        return webSocketFrame.amH() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] mf(String str) {
        return str.getBytes(cOH);
    }

    private String amM() {
        if (this.Rz == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.Rz.length).append("b] ");
        if (amH() == OpCode.Text) {
            String amK = amK();
            if (amK.length() > 100) {
                sb.append(amK.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(amK);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.Rz.length, 50); i++) {
                sb.append(Integer.toHexString(this.Rz[i] & 255));
            }
            if (this.Rz.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void m(InputStream inputStream) throws IOException {
        this.Rz = new byte[this.cOJ];
        int i = 0;
        while (i < this.cOJ) {
            i += gB(inputStream.read(this.Rz, i, this.cOJ - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.Rz.length; i2++) {
                byte[] bArr = this.Rz;
                bArr[i2] = (byte) (bArr[i2] ^ this.cOI[i2 % 4]);
            }
        }
        if (amH() == OpCode.Text) {
            this.cOK = F(amJ());
        }
    }

    private void n(InputStream inputStream) throws IOException {
        int i = 0;
        byte gB = (byte) gB(inputStream.read());
        boolean z = (gB & 128) != 0;
        this.cOJ = (byte) (gB & Byte.MAX_VALUE);
        if (this.cOJ == 126) {
            this.cOJ = ((gB(inputStream.read()) << 8) | gB(inputStream.read())) & SupportMenu.USER_MASK;
            if (this.cOJ < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.cOJ == 127) {
            long gB2 = (gB(inputStream.read()) << 56) | (gB(inputStream.read()) << 48) | (gB(inputStream.read()) << 40) | (gB(inputStream.read()) << 32) | (gB(inputStream.read()) << 24) | (gB(inputStream.read()) << 16) | (gB(inputStream.read()) << 8) | gB(inputStream.read());
            if (gB2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (gB2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.cOJ = (int) gB2;
        }
        if (this.cOF.isControlFrame()) {
            if (this.cOJ > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.cOF == OpCode.Close && this.cOJ == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.cOI = new byte[4];
            while (i < this.cOI.length) {
                i += gB(inputStream.read(this.cOI, i, this.cOI.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = amH();
        objArr[1] = amI() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = amM();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Sh ? (byte) 128 : (byte) 0) | (this.cOF.getValue() & 15)));
        this.cOJ = amJ().length;
        if (this.cOJ <= 125) {
            outputStream.write(isMasked() ? ((byte) this.cOJ) | 128 : (byte) this.cOJ);
        } else if (this.cOJ < 65536) {
            outputStream.write(isMasked() ? GDiffPatcher.COPY_INT_INT : Opcodes.IAND);
            outputStream.write(this.cOJ >>> 8);
            outputStream.write(this.cOJ);
        } else {
            outputStream.write(isMasked() ? 255 : ThunderNetStateService.NetState.SYSNET_UNKNOWN);
            outputStream.write(new byte[4]);
            outputStream.write(this.cOJ >>> 24);
            outputStream.write(this.cOJ >>> 16);
            outputStream.write(this.cOJ >>> 8);
            outputStream.write(this.cOJ);
        }
        if (isMasked()) {
            outputStream.write(this.cOI);
            for (int i = 0; i < this.cOJ; i++) {
                outputStream.write(amJ()[i] ^ this.cOI[i % 4]);
            }
        } else {
            outputStream.write(amJ());
        }
        outputStream.flush();
    }

    /* loaded from: classes9.dex */
    public static class a extends WebSocketFrame {
        private CloseCode cOL;
        private String cOM;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] mf = mf(str);
                byte[] bArr = new byte[mf.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(mf, 0, bArr, 2, mf.length);
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
            if (webSocketFrame.amJ().length >= 2) {
                this.cOL = CloseCode.find(((webSocketFrame.amJ()[0] & 255) << 8) | (webSocketFrame.amJ()[1] & 255));
                this.cOM = q(amJ(), 2, amJ().length - 2);
            }
        }

        public CloseCode amN() {
            return this.cOL;
        }

        public String getCloseReason() {
            return this.cOM;
        }
    }
}
