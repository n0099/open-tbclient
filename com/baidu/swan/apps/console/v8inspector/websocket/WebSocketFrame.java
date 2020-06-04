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
    private static final Charset bSU = Charset.forName("UTF-8");
    private byte[] OI;
    private boolean Pr;
    private OpCode bSS;
    private byte[] bSV;
    private int bSW;
    private String bSX;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.WJ());
        dt(webSocketFrame.WK());
        D(webSocketFrame.WL());
        E(webSocketFrame.WN());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        dt(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().WL().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.bSW = (int) j;
        byte[] bArr = new byte[this.bSW];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.WL(), 0, bArr, i, webSocketFrame.WL().length);
            i = webSocketFrame.WL().length + i;
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
        iX(str);
    }

    private void a(OpCode opCode) {
        this.bSS = opCode;
    }

    public OpCode WJ() {
        return this.bSS;
    }

    private void dt(boolean z) {
        this.Pr = z;
    }

    public boolean WK() {
        return this.Pr;
    }

    private void D(byte[] bArr) {
        this.OI = bArr;
        this.bSW = bArr.length;
        this.bSX = null;
    }

    public byte[] WL() {
        return this.OI;
    }

    private void iX(String str) {
        this.OI = iY(str);
        this.bSW = str.length();
        this.bSX = str;
    }

    public String WM() {
        if (this.bSX == null) {
            this.bSX = F(WL());
        }
        return this.bSX;
    }

    private void E(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.bSV = bArr;
    }

    private byte[] WN() {
        return this.bSV;
    }

    private boolean isMasked() {
        return this.bSV != null && this.bSV.length == 4;
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

    private static String F(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    static String n(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, bSU);
    }

    private static int eE(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame k(InputStream inputStream) throws IOException {
        byte eE = (byte) eE(inputStream.read());
        boolean z = (eE & 128) != 0;
        OpCode find = OpCode.find((byte) (eE & 15));
        if ((eE & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(eE & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (eE & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.m(inputStream);
        webSocketFrame.l(inputStream);
        return webSocketFrame.WJ() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] iY(String str) {
        return str.getBytes(bSU);
    }

    private String WO() {
        if (this.OI == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.OI.length).append("b] ");
        if (WJ() == OpCode.Text) {
            String WM = WM();
            if (WM.length() > 100) {
                sb.append(WM.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(WM);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.OI.length, 50); i++) {
                sb.append(Integer.toHexString(this.OI[i] & 255));
            }
            if (this.OI.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void l(InputStream inputStream) throws IOException {
        this.OI = new byte[this.bSW];
        int i = 0;
        while (i < this.bSW) {
            i += eE(inputStream.read(this.OI, i, this.bSW - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.OI.length; i2++) {
                byte[] bArr = this.OI;
                bArr[i2] = (byte) (bArr[i2] ^ this.bSV[i2 % 4]);
            }
        }
        if (WJ() == OpCode.Text) {
            this.bSX = F(WL());
        }
    }

    private void m(InputStream inputStream) throws IOException {
        int i = 0;
        byte eE = (byte) eE(inputStream.read());
        boolean z = (eE & 128) != 0;
        this.bSW = (byte) (eE & Byte.MAX_VALUE);
        if (this.bSW == 126) {
            this.bSW = ((eE(inputStream.read()) << 8) | eE(inputStream.read())) & 65535;
            if (this.bSW < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.bSW == 127) {
            long eE2 = (eE(inputStream.read()) << 56) | (eE(inputStream.read()) << 48) | (eE(inputStream.read()) << 40) | (eE(inputStream.read()) << 32) | (eE(inputStream.read()) << 24) | (eE(inputStream.read()) << 16) | (eE(inputStream.read()) << 8) | eE(inputStream.read());
            if (eE2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (eE2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.bSW = (int) eE2;
        }
        if (this.bSS.isControlFrame()) {
            if (this.bSW > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.bSS == OpCode.Close && this.bSW == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.bSV = new byte[4];
            while (i < this.bSV.length) {
                i += eE(inputStream.read(this.bSV, i, this.bSV.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = WJ();
        objArr[1] = WK() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = WO();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Pr ? (byte) 128 : (byte) 0) | (this.bSS.getValue() & 15)));
        this.bSW = WL().length;
        if (this.bSW <= 125) {
            outputStream.write(isMasked() ? ((byte) this.bSW) | 128 : (byte) this.bSW);
        } else if (this.bSW < 65536) {
            outputStream.write(isMasked() ? 254 : Opcodes.IAND);
            outputStream.write(this.bSW >>> 8);
            outputStream.write(this.bSW);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.bSW >>> 24);
            outputStream.write(this.bSW >>> 16);
            outputStream.write(this.bSW >>> 8);
            outputStream.write(this.bSW);
        }
        if (isMasked()) {
            outputStream.write(this.bSV);
            for (int i = 0; i < this.bSW; i++) {
                outputStream.write(WL()[i] ^ this.bSV[i % 4]);
            }
        } else {
            outputStream.write(WL());
        }
        outputStream.flush();
    }

    /* loaded from: classes11.dex */
    public static class a extends WebSocketFrame {
        private CloseCode bSY;
        private String bSZ;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] iY = iY(str);
                byte[] bArr = new byte[iY.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(iY, 0, bArr, 2, iY.length);
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
            if (webSocketFrame.WL().length >= 2) {
                this.bSY = CloseCode.find(((webSocketFrame.WL()[0] & 255) << 8) | (webSocketFrame.WL()[1] & 255));
                this.bSZ = n(WL(), 2, WL().length - 2);
            }
        }

        public CloseCode WP() {
            return this.bSY;
        }

        public String getCloseReason() {
            return this.bSZ;
        }
    }
}
