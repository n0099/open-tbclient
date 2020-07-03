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
    private static final Charset bXI = Charset.forName("UTF-8");
    private boolean PZ;
    private byte[] Pm;
    private OpCode bXG;
    private byte[] bXJ;
    private int bXK;
    private String bXL;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.XP());
        dy(webSocketFrame.XQ());
        F(webSocketFrame.XR());
        G(webSocketFrame.XT());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        dy(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().XR().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.bXK = (int) j;
        byte[] bArr = new byte[this.bXK];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.XR(), 0, bArr, i, webSocketFrame.XR().length);
            i = webSocketFrame.XR().length + i;
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
        jf(str);
    }

    private void a(OpCode opCode) {
        this.bXG = opCode;
    }

    public OpCode XP() {
        return this.bXG;
    }

    private void dy(boolean z) {
        this.PZ = z;
    }

    public boolean XQ() {
        return this.PZ;
    }

    private void F(byte[] bArr) {
        this.Pm = bArr;
        this.bXK = bArr.length;
        this.bXL = null;
    }

    public byte[] XR() {
        return this.Pm;
    }

    private void jf(String str) {
        this.Pm = jg(str);
        this.bXK = str.length();
        this.bXL = str;
    }

    public String XS() {
        if (this.bXL == null) {
            this.bXL = H(XR());
        }
        return this.bXL;
    }

    private void G(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.bXJ = bArr;
    }

    private byte[] XT() {
        return this.bXJ;
    }

    private boolean isMasked() {
        return this.bXJ != null && this.bXJ.length == 4;
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

    private static String H(byte[] bArr) {
        return n(bArr, 0, bArr.length);
    }

    static String n(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, bXI);
    }

    private static int eP(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame k(InputStream inputStream) throws IOException {
        byte eP = (byte) eP(inputStream.read());
        boolean z = (eP & 128) != 0;
        OpCode find = OpCode.find((byte) (eP & 15));
        if ((eP & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(eP & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (eP & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.m(inputStream);
        webSocketFrame.l(inputStream);
        return webSocketFrame.XP() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] jg(String str) {
        return str.getBytes(bXI);
    }

    private String XU() {
        if (this.Pm == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.Pm.length).append("b] ");
        if (XP() == OpCode.Text) {
            String XS = XS();
            if (XS.length() > 100) {
                sb.append(XS.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(XS);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.Pm.length, 50); i++) {
                sb.append(Integer.toHexString(this.Pm[i] & 255));
            }
            if (this.Pm.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void l(InputStream inputStream) throws IOException {
        this.Pm = new byte[this.bXK];
        int i = 0;
        while (i < this.bXK) {
            i += eP(inputStream.read(this.Pm, i, this.bXK - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.Pm.length; i2++) {
                byte[] bArr = this.Pm;
                bArr[i2] = (byte) (bArr[i2] ^ this.bXJ[i2 % 4]);
            }
        }
        if (XP() == OpCode.Text) {
            this.bXL = H(XR());
        }
    }

    private void m(InputStream inputStream) throws IOException {
        int i = 0;
        byte eP = (byte) eP(inputStream.read());
        boolean z = (eP & 128) != 0;
        this.bXK = (byte) (eP & Byte.MAX_VALUE);
        if (this.bXK == 126) {
            this.bXK = ((eP(inputStream.read()) << 8) | eP(inputStream.read())) & 65535;
            if (this.bXK < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.bXK == 127) {
            long eP2 = (eP(inputStream.read()) << 56) | (eP(inputStream.read()) << 48) | (eP(inputStream.read()) << 40) | (eP(inputStream.read()) << 32) | (eP(inputStream.read()) << 24) | (eP(inputStream.read()) << 16) | (eP(inputStream.read()) << 8) | eP(inputStream.read());
            if (eP2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (eP2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.bXK = (int) eP2;
        }
        if (this.bXG.isControlFrame()) {
            if (this.bXK > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.bXG == OpCode.Close && this.bXK == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.bXJ = new byte[4];
            while (i < this.bXJ.length) {
                i += eP(inputStream.read(this.bXJ, i, this.bXJ.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = XP();
        objArr[1] = XQ() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = XU();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.PZ ? (byte) 128 : (byte) 0) | (this.bXG.getValue() & 15)));
        this.bXK = XR().length;
        if (this.bXK <= 125) {
            outputStream.write(isMasked() ? ((byte) this.bXK) | 128 : (byte) this.bXK);
        } else if (this.bXK < 65536) {
            outputStream.write(isMasked() ? 254 : Opcodes.IAND);
            outputStream.write(this.bXK >>> 8);
            outputStream.write(this.bXK);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.bXK >>> 24);
            outputStream.write(this.bXK >>> 16);
            outputStream.write(this.bXK >>> 8);
            outputStream.write(this.bXK);
        }
        if (isMasked()) {
            outputStream.write(this.bXJ);
            for (int i = 0; i < this.bXK; i++) {
                outputStream.write(XR()[i] ^ this.bXJ[i % 4]);
            }
        } else {
            outputStream.write(XR());
        }
        outputStream.flush();
    }

    /* loaded from: classes11.dex */
    public static class a extends WebSocketFrame {
        private CloseCode bXM;
        private String bXN;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] jg = jg(str);
                byte[] bArr = new byte[jg.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(jg, 0, bArr, 2, jg.length);
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
            if (webSocketFrame.XR().length >= 2) {
                this.bXM = CloseCode.find(((webSocketFrame.XR()[0] & 255) << 8) | (webSocketFrame.XR()[1] & 255));
                this.bXN = n(XR(), 2, XR().length - 2);
            }
        }

        public CloseCode XV() {
            return this.bXM;
        }

        public String getCloseReason() {
            return this.bXN;
        }
    }
}
