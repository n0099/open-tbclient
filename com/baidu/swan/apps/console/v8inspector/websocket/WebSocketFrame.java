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
    private static final Charset bJS = Charset.forName("UTF-8");
    private byte[] Ox;
    private boolean Ph;
    private OpCode bJQ;
    private byte[] bJT;
    private int bJU;
    private String bJV;

    WebSocketFrame(WebSocketFrame webSocketFrame) {
        a(webSocketFrame.Ue());
        dg(webSocketFrame.Uf());
        w(webSocketFrame.Ug());
        x(webSocketFrame.Ui());
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
            j = it.next().Ug().length + j;
        }
        if (j < 0 || j > 2147483647L) {
            if (DEBUG) {
                throw new RuntimeException("Max frame length has been exceeded.");
            }
            return;
        }
        this.bJU = (int) j;
        byte[] bArr = new byte[this.bJU];
        int i = 0;
        for (WebSocketFrame webSocketFrame : list) {
            System.arraycopy(webSocketFrame.Ug(), 0, bArr, i, webSocketFrame.Ug().length);
            i = webSocketFrame.Ug().length + i;
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
        this.bJQ = opCode;
    }

    public OpCode Ue() {
        return this.bJQ;
    }

    private void dg(boolean z) {
        this.Ph = z;
    }

    public boolean Uf() {
        return this.Ph;
    }

    private void w(byte[] bArr) {
        this.Ox = bArr;
        this.bJU = bArr.length;
        this.bJV = null;
    }

    public byte[] Ug() {
        return this.Ox;
    }

    private void hW(String str) {
        this.Ox = hX(str);
        this.bJU = str.length();
        this.bJV = str;
    }

    public String Uh() {
        if (this.bJV == null) {
            this.bJV = y(Ug());
        }
        return this.bJV;
    }

    private void x(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && DEBUG) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.bJT = bArr;
    }

    private byte[] Ui() {
        return this.bJT;
    }

    private boolean isMasked() {
        return this.bJT != null && this.bJT.length == 4;
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
        return new String(bArr, i, i2, bJS);
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
        return webSocketFrame.Ue() == OpCode.Close ? new a() : webSocketFrame;
    }

    static byte[] hX(String str) {
        return str.getBytes(bJS);
    }

    private String Uj() {
        if (this.Ox == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(this.Ox.length).append("b] ");
        if (Ue() == OpCode.Text) {
            String Uh = Uh();
            if (Uh.length() > 100) {
                sb.append(Uh.substring(0, 100)).append(StringHelper.STRING_MORE);
            } else {
                sb.append(Uh);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.Ox.length, 50); i++) {
                sb.append(Integer.toHexString(this.Ox[i] & 255));
            }
            if (this.Ox.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    private void k(InputStream inputStream) throws IOException {
        this.Ox = new byte[this.bJU];
        int i = 0;
        while (i < this.bJU) {
            i += et(inputStream.read(this.Ox, i, this.bJU - i));
        }
        if (isMasked()) {
            for (int i2 = 0; i2 < this.Ox.length; i2++) {
                byte[] bArr = this.Ox;
                bArr[i2] = (byte) (bArr[i2] ^ this.bJT[i2 % 4]);
            }
        }
        if (Ue() == OpCode.Text) {
            this.bJV = y(Ug());
        }
    }

    private void l(InputStream inputStream) throws IOException {
        int i = 0;
        byte et = (byte) et(inputStream.read());
        boolean z = (et & 128) != 0;
        this.bJU = (byte) (et & Byte.MAX_VALUE);
        if (this.bJU == 126) {
            this.bJU = ((et(inputStream.read()) << 8) | et(inputStream.read())) & 65535;
            if (this.bJU < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (this.bJU == 127) {
            long et2 = (et(inputStream.read()) << 56) | (et(inputStream.read()) << 48) | (et(inputStream.read()) << 40) | (et(inputStream.read()) << 32) | (et(inputStream.read()) << 24) | (et(inputStream.read()) << 16) | (et(inputStream.read()) << 8) | et(inputStream.read());
            if (et2 <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (et2 > 2147483647L) {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
            this.bJU = (int) et2;
        }
        if (this.bJQ.isControlFrame()) {
            if (this.bJU > 125) {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
            if (this.bJQ == OpCode.Close && this.bJU == 1) {
                throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
            }
        }
        if (z) {
            this.bJT = new byte[4];
            while (i < this.bJT.length) {
                i += et(inputStream.read(this.bJT, i, this.bJT.length - i));
            }
        }
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = Ue();
        objArr[1] = Uf() ? "fin" : "inter";
        objArr[2] = isMasked() ? "masked" : "unmasked";
        objArr[3] = Uj();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public void write(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.Ph ? (byte) 128 : (byte) 0) | (this.bJQ.getValue() & 15)));
        this.bJU = Ug().length;
        if (this.bJU <= 125) {
            outputStream.write(isMasked() ? ((byte) this.bJU) | 128 : (byte) this.bJU);
        } else if (this.bJU < 65536) {
            outputStream.write(isMasked() ? 254 : Opcodes.IAND);
            outputStream.write(this.bJU >>> 8);
            outputStream.write(this.bJU);
        } else {
            outputStream.write(isMasked() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.bJU >>> 24);
            outputStream.write(this.bJU >>> 16);
            outputStream.write(this.bJU >>> 8);
            outputStream.write(this.bJU);
        }
        if (isMasked()) {
            outputStream.write(this.bJT);
            for (int i = 0; i < this.bJU; i++) {
                outputStream.write(Ug()[i] ^ this.bJT[i % 4]);
            }
        } else {
            outputStream.write(Ug());
        }
        outputStream.flush();
    }

    /* loaded from: classes11.dex */
    public static class a extends WebSocketFrame {
        private CloseCode bJW;
        private String bJX;

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
            if (webSocketFrame.Ug().length >= 2) {
                this.bJW = CloseCode.find(((webSocketFrame.Ug()[0] & 255) << 8) | (webSocketFrame.Ug()[1] & 255));
                this.bJX = m(Ug(), 2, Ug().length - 2);
            }
        }

        public CloseCode Uk() {
            return this.bJW;
        }

        public String getCloseReason() {
            return this.bJX;
        }
    }
}
