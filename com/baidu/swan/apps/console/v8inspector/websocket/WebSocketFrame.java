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
    private static final Charset bJX = Charset.forName("UTF-8");
    private byte[] OB;
    private boolean Pl;
    private OpCode bJV;
    private byte[] bJY;
    private int bJZ;
    private String bKa;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.Ud());
        dg(webSocketFrame.Ue());
        w(webSocketFrame.Uf());
        x(webSocketFrame.Uh());
    }

    private WebSocketFrame(OpCode opCode, boolean z) {
        a(opCode);
        dg(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j = it.next().Uf().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.bJZ = (int) j;
        byte[] bArr = new byte[this.bJZ];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.Uf(), 0, bArr, i, webSocketFrame.Uf().length);
            i = webSocketFrame.Uf().length + i;
        }
        w(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        w(bArr);
    }

    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        hW(str);
    }

    private void a(OpCode opCode) {
        this.bJV = opCode;
    }

    public OpCode Ud() {
        return this.bJV;
    }

    private void dg(boolean z) {
        this.Pl = z;
    }

    public boolean Ue() {
        return this.Pl;
    }

    private void w(byte[] bArr) {
        this.OB = bArr;
        this.bJZ = bArr.length;
        this.bKa = null;
    }

    public byte[] Uf() {
        return this.OB;
    }

    private void hW(String str) {
        this.OB = hX(str);
        this.bJZ = str.length();
        this.bKa = str;
    }

    public String Ug() {
        if (this.bKa == null) {
            this.bKa = y(Uf());
        }
        return this.bKa;
    }

    private void x(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.bJY = bArr;
    }

    private byte[] Uh() {
        return this.bJY;
    }

    private boolean isMasked() {
        return this.bJY != null && this.bJY.length == 4;
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

    private static String y(byte[] bArr) {
        return m(bArr, 0, bArr.length);
    }

    static String m(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, bJX);
    }

    private static int et(int i) throws EOFException {
        if (i < 0) {
            throw new EOFException();
        }
        return i;
    }

    public static WebSocketFrame j(InputStream inputStream) throws IOException {
        byte et = (byte) et(inputStream.read());
        boolean z = (et & 128) != 0;
        OpCode find = OpCode.find((byte) (et & 15));
        if ((et & 112) != 0) {
            throw new WebSocketException(CloseCode.ProtocolError, "The reserved bits (" + Integer.toBinaryString(et & 112) + ") must be 0.");
        }
        if (find == null) {
            throw new WebSocketException(CloseCode.ProtocolError, "Received frame with reserved/unknown opcode " + (et & 112) + ".");
        }
        if (find.isControlFrame() && !z) {
            throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
        }
        WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
        webSocketFrame.l(inputStream);
        webSocketFrame.k(inputStream);
        return webSocketFrame.Ud() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] hX(String str) {
        return str.getBytes(bJX);
    }

    private String Ui() {
        if (this.OB == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.OB.length).append("b] ");
        if (Ud() == OpCode.Text) {
            String Ug = Ug();
            if (Ug.length() > 100) {
                sb.append(Ug.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(Ug);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.OB.length, 50); i++) {
                sb.append(Integer.toHexString(this.OB[i] & 255));
            }
            if (this.OB.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void k(InputStream inputStream) throws IOException {
        this.OB = new byte[this.bJZ];
        int i = 0;
        while (i < this.bJZ) {
            i += et(inputStream.read(this.OB, i, this.bJZ - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.OB.length; i2++) {
                byte[] bArr = this.OB;
                bArr[i2] = (byte) (bArr[i2] ^ this.bJY[i2 % 4]);
            }
        }
        if (Ud() == OpCode.Text) {
            this.bKa = y(Uf());
        }
    }

    private void l(InputStream inputStream) throws IOException {
        int i = 0;
        byte et = (byte) et(inputStream.read());
        boolean z = (et & 128) != 0;
        this.bJZ = (byte) (et & Byte.MAX_VALUE);
        if (this.bJZ == 126) {
            this.bJZ = ((et(inputStream.read()) << 8) | et(inputStream.read())) & 65535;
            if (this.bJZ < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.bJZ == 127) {
            long et2 = (et(inputStream.read()) << 56) | (et(inputStream.read()) << 48) | (et(inputStream.read()) << 40) | (et(inputStream.read()) << 32) | (et(inputStream.read()) << 24) | (et(inputStream.read()) << 16) | (et(inputStream.read()) << 8) | et(inputStream.read());
            if (et2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (et2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.bJZ = (int) et2;
        }
        if (this.bJV.isControlFrame()) {
            if (this.bJZ > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.bJV == OpCode.Close && this.bJZ == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.bJY = new byte[4];
            while (i < this.bJY.length) {
                i += et(inputStream.read(this.bJY, i, this.bJY.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = Ud();
        objArr[1] = Ue() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = Ui();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Pl ? (byte) 128 : (byte) 0) | (this.bJV.getValue() & 15)));
        this.bJZ = Uf().length;
        if (this.bJZ <= 125) {
            outputStream.write(isMasked() ? ((byte) this.bJZ) | 128 : (byte) this.bJZ);
        } else if (this.bJZ < 65536) {
            outputStream.write(isMasked() ? 254 : Opcodes.IAND);
            outputStream.write(this.bJZ >>> 8);
            outputStream.write(this.bJZ);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.bJZ >>> 24);
            outputStream.write(this.bJZ >>> 16);
            outputStream.write(this.bJZ >>> 8);
            outputStream.write(this.bJZ);
        }
        if (isMasked()) {
            outputStream.write(this.bJY);
            for (int i = 0; i < this.bJZ; i++) {
                outputStream.write(Uf()[i] ^ this.bJY[i % 4]);
            }
        } else {
            outputStream.write(Uf());
        }
        outputStream.flush();
    }

    /* loaded from: classes11.dex */
    public static class a extends WebSocketFrame {
        private CloseCode bKb;
        private String bKc;

        private static byte[] b(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] hX = hX(str);
                byte[] bArr = new byte[hX.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(hX, 0, bArr, 2, hX.length);
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
            if (webSocketFrame.Uf().length >= 2) {
                this.bKb = CloseCode.find(((webSocketFrame.Uf()[0] & 255) << 8) | (webSocketFrame.Uf()[1] & 255));
                this.bKc = m(Uf(), 2, Uf().length - 2);
            }
        }

        public CloseCode Uj() {
            return this.bKb;
        }

        public String getCloseReason() {
            return this.bKc;
        }
    }
}
