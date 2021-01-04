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
/* loaded from: classes9.dex */
public class WebSocketFrame {
    private static final boolean DEBUG = b.DEBUG;
    private static final Charset cRf = Charset.forName("UTF-8");
    private byte[] RD;
    private boolean Sl;
    private OpCode cRd;
    private byte[] cRg;
    private int cRh;
    private String cRi;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.aqd());
        fc(webSocketFrame.aqe());
        F(webSocketFrame.aqf());
        G(webSocketFrame.aqh());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        fc(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().aqf().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.cRh = (int) j;
        byte[] bArr = new byte[this.cRh];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.aqf(), 0, bArr, i, webSocketFrame.aqf().length);
            i = webSocketFrame.aqf().length + i;
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
        mX(str);
    }

    private void a(OpCode opCode) {
        this.cRd = opCode;
    }

    public OpCode aqd() {
        return this.cRd;
    }

    private void fc(boolean z) {
        this.Sl = z;
    }

    public boolean aqe() {
        return this.Sl;
    }

    private void F(byte[] bArr) {
        this.RD = bArr;
        this.cRh = bArr.length;
        this.cRi = null;
    }

    public byte[] aqf() {
        return this.RD;
    }

    private void mX(String str) {
        this.RD = mY(str);
        this.cRh = str.length();
        this.cRi = str;
    }

    public String aqg() {
        if (this.cRi == null) {
            this.cRi = H(aqf());
        }
        return this.cRi;
    }

    private void G(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.cRg = bArr;
    }

    private byte[] aqh() {
        return this.cRg;
    }

    private boolean isMasked() {
        return this.cRg != null && this.cRg.length == 4;
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

    private static String H(byte[] bArr) {
        return r(bArr, 0, bArr.length);
    }

    static String r(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, cRf);
    }

    private static int ie(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame n(InputStream inputStream) throws IOException {
        byte ie = (byte) ie(inputStream.read());
        boolean z = (ie & 128) != 0;
        OpCode find = OpCode.find((byte) (ie & 15));
        if ((ie & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(ie & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (ie & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.p(inputStream);
        webSocketFrame.o(inputStream);
        return webSocketFrame.aqd() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] mY(String str) {
        return str.getBytes(cRf);
    }

    private String aqi() {
        if (this.RD == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.RD.length).append("b] ");
        if (aqd() == OpCode.Text) {
            String aqg = aqg();
            if (aqg.length() > 100) {
                sb.append(aqg.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(aqg);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.RD.length, 50); i++) {
                sb.append(Integer.toHexString(this.RD[i] & 255));
            }
            if (this.RD.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void o(InputStream inputStream) throws IOException {
        this.RD = new byte[this.cRh];
        int i = 0;
        while (i < this.cRh) {
            i += ie(inputStream.read(this.RD, i, this.cRh - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.RD.length; i2++) {
                byte[] bArr = this.RD;
                bArr[i2] = (byte) (bArr[i2] ^ this.cRg[i2 % 4]);
            }
        }
        if (aqd() == OpCode.Text) {
            this.cRi = H(aqf());
        }
    }

    private void p(InputStream inputStream) throws IOException {
        int i = 0;
        byte ie = (byte) ie(inputStream.read());
        boolean z = (ie & 128) != 0;
        this.cRh = (byte) (ie & Byte.MAX_VALUE);
        if (this.cRh == 126) {
            this.cRh = ((ie(inputStream.read()) << 8) | ie(inputStream.read())) & SupportMenu.USER_MASK;
            if (this.cRh < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.cRh == 127) {
            long ie2 = (ie(inputStream.read()) << 56) | (ie(inputStream.read()) << 48) | (ie(inputStream.read()) << 40) | (ie(inputStream.read()) << 32) | (ie(inputStream.read()) << 24) | (ie(inputStream.read()) << 16) | (ie(inputStream.read()) << 8) | ie(inputStream.read());
            if (ie2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (ie2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.cRh = (int) ie2;
        }
        if (this.cRd.isControlFrame()) {
            if (this.cRh > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.cRd == OpCode.Close && this.cRh == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.cRg = new byte[4];
            while (i < this.cRg.length) {
                i += ie(inputStream.read(this.cRg, i, this.cRg.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = aqd();
        objArr[1] = aqe() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = aqi();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Sl ? (byte) 128 : (byte) 0) | (this.cRd.getValue() & 15)));
        this.cRh = aqf().length;
        if (this.cRh <= 125) {
            outputStream.write(isMasked() ? ((byte) this.cRh) | 128 : (byte) this.cRh);
        } else if (this.cRh < 65536) {
            outputStream.write(isMasked() ? GDiffPatcher.COPY_INT_INT : Opcodes.IAND);
            outputStream.write(this.cRh >>> 8);
            outputStream.write(this.cRh);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.cRh >>> 24);
            outputStream.write(this.cRh >>> 16);
            outputStream.write(this.cRh >>> 8);
            outputStream.write(this.cRh);
        }
        if (isMasked()) {
            outputStream.write(this.cRg);
            for (int i = 0; i < this.cRh; i++) {
                outputStream.write(aqf()[i] ^ this.cRg[i % 4]);
            }
        } else {
            outputStream.write(aqf());
        }
        outputStream.flush();
    }

    /* loaded from: classes9.dex */
    public static class a extends WebSocketFrame {
        private CloseCode cRj;
        private String cRk;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] mY = mY(str);
                byte[] bArr = new byte[mY.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(mY, 0, bArr, 2, mY.length);
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
            if (webSocketFrame.aqf().length >= 2) {
                this.cRj = CloseCode.find(((webSocketFrame.aqf()[0] & 255) << 8) | (webSocketFrame.aqf()[1] & 255));
                this.cRk = r(aqf(), 2, aqf().length - 2);
            }
        }

        public CloseCode aqj() {
            return this.cRj;
        }

        public String getCloseReason() {
            return this.cRk;
        }
    }
}
