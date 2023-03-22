package com.baidu.swan.apps.console.v8inspector.websocket;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.do1;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes3.dex */
public class WebSocketFrame {
    public static final boolean g = do1.a;
    public static final Charset h = Charset.forName("UTF-8");
    public OpCode a;
    public boolean b;
    public byte[] c;
    public byte[] d;
    public int e;
    public String f;

    /* loaded from: classes3.dex */
    public static class b extends WebSocketFrame {
        public CloseCode i;
        public String j;

        public b(CloseCode closeCode, String str) {
            super(OpCode.Close, true, u(closeCode, str));
        }

        public static byte[] u(CloseCode closeCode, String str) {
            if (closeCode != null) {
                byte[] s = WebSocketFrame.s(str);
                byte[] bArr = new byte[s.length + 2];
                bArr[0] = (byte) ((closeCode.getValue() >> 8) & 255);
                bArr[1] = (byte) (closeCode.getValue() & 255);
                System.arraycopy(s, 0, bArr, 2, s.length);
                return bArr;
            }
            return new byte[0];
        }

        public b(WebSocketFrame webSocketFrame) {
            super(webSocketFrame);
            if (webSocketFrame.d().length >= 2) {
                this.i = CloseCode.find((webSocketFrame.d()[1] & 255) | ((webSocketFrame.d()[0] & 255) << 8));
                this.j = WebSocketFrame.a(d(), 2, d().length - 2);
            }
        }

        public CloseCode v() {
            return this.i;
        }

        public String w() {
            return this.j;
        }
    }

    public byte[] d() {
        return this.d;
    }

    public final byte[] e() {
        return this.c;
    }

    public OpCode f() {
        return this.a;
    }

    public String g() {
        if (this.f == null) {
            this.f = b(d());
        }
        return this.f;
    }

    public boolean h() {
        return this.b;
    }

    public final boolean i() {
        byte[] bArr = this.c;
        if (bArr != null && bArr.length == 4) {
            return true;
        }
        return false;
    }

    /* loaded from: classes3.dex */
    public enum CloseCode {
        NormalClosure(1000),
        ProtocolError(1002),
        MessageTooLong(1009);
        
        public final int mCode;

        CloseCode(int i) {
            this.mCode = i;
        }

        public static CloseCode find(int i) {
            CloseCode[] values;
            for (CloseCode closeCode : values()) {
                if (closeCode.getValue() == i) {
                    return closeCode;
                }
            }
            return null;
        }

        public int getValue() {
            return this.mCode;
        }
    }

    /* loaded from: classes3.dex */
    public enum OpCode {
        Continuation(0),
        Text(1),
        Binary(2),
        Close(8),
        Ping(9),
        Pong(10);
        
        public final byte mCode;

        OpCode(int i) {
            this.mCode = (byte) i;
        }

        public static OpCode find(byte b) {
            OpCode[] values;
            for (OpCode opCode : values()) {
                if (opCode.getValue() == b) {
                    return opCode;
                }
            }
            return null;
        }

        public byte getValue() {
            return this.mCode;
        }

        public boolean isControlFrame() {
            if (this != Close && this != Ping && this != Pong) {
                return false;
            }
            return true;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j += it.next().d().length;
        }
        if (j >= 0 && j <= 2147483647L) {
            int i = (int) j;
            this.e = i;
            byte[] bArr = new byte[i];
            int i2 = 0;
            for (WebSocketFrame webSocketFrame : list) {
                System.arraycopy(webSocketFrame.d(), 0, bArr, i2, webSocketFrame.d().length);
                i2 += webSocketFrame.d().length;
            }
            n(bArr);
        } else if (g) {
            throw new RuntimeException("Max frame length has been exceeded.");
        }
    }

    public WebSocketFrame(OpCode opCode, boolean z) {
        q(opCode);
        o(z);
    }

    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        r(str);
    }

    public static String a(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, h);
    }

    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        n(bArr);
    }

    public WebSocketFrame(WebSocketFrame webSocketFrame) {
        q(webSocketFrame.f());
        o(webSocketFrame.h());
        n(webSocketFrame.d());
        p(webSocketFrame.e());
    }

    public static String b(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    @SuppressLint({"BDThrowableCheck"})
    public static int c(int i) throws EOFException {
        if (i >= 0) {
            return i;
        }
        throw new EOFException();
    }

    public static byte[] s(String str) {
        return str.getBytes(h);
    }

    public final void n(byte[] bArr) {
        this.d = bArr;
        this.e = bArr.length;
        this.f = null;
    }

    public final void o(boolean z) {
        this.b = z;
    }

    public final void p(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && g) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.c = bArr;
    }

    public final void q(OpCode opCode) {
        this.a = opCode;
    }

    public final void r(String str) {
        this.d = s(str);
        this.e = str.length();
        this.f = str;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static WebSocketFrame k(InputStream inputStream) throws IOException {
        boolean z;
        int read = inputStream.read();
        c(read);
        byte b2 = (byte) read;
        if ((b2 & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        OpCode find = OpCode.find((byte) (b2 & 15));
        int i = b2 & 112;
        if (i == 0) {
            if (find != null) {
                if (find.isControlFrame() && !z) {
                    throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
                }
                WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
                webSocketFrame.m(inputStream);
                webSocketFrame.l(inputStream);
                if (webSocketFrame.f() == OpCode.Close) {
                    return new b();
                }
                return webSocketFrame;
            }
            CloseCode closeCode = CloseCode.ProtocolError;
            throw new WebSocketException(closeCode, "Received frame with reserved/unknown opcode " + i + ".");
        }
        CloseCode closeCode2 = CloseCode.ProtocolError;
        throw new WebSocketException(closeCode2, "The reserved bits (" + Integer.toBinaryString(i) + ") must be 0.");
    }

    public final String j() {
        if (this.d == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(this.d.length);
        sb.append("b] ");
        if (f() == OpCode.Text) {
            String g2 = g();
            if (g2.length() > 100) {
                sb.append(g2.substring(0, 100));
                sb.append(StringHelper.STRING_MORE);
            } else {
                sb.append(g2);
            }
        } else {
            sb.append("0x");
            for (int i = 0; i < Math.min(this.d.length, 50); i++) {
                sb.append(Integer.toHexString(this.d[i] & 255));
            }
            if (this.d.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    public final void l(InputStream inputStream) throws IOException {
        this.d = new byte[this.e];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = this.e;
            if (i2 >= i3) {
                break;
            }
            int read = inputStream.read(this.d, i2, i3 - i2);
            c(read);
            i2 += read;
        }
        if (i()) {
            while (true) {
                byte[] bArr = this.d;
                if (i >= bArr.length) {
                    break;
                }
                bArr[i] = (byte) (bArr[i] ^ this.c[i % 4]);
                i++;
            }
        }
        if (f() == OpCode.Text) {
            this.f = b(d());
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public final void m(InputStream inputStream) throws IOException {
        boolean z;
        int read = inputStream.read();
        c(read);
        byte b2 = (byte) read;
        int i = 0;
        if ((b2 & 128) != 0) {
            z = true;
        } else {
            z = false;
        }
        byte b3 = (byte) (b2 & ByteCompanionObject.MAX_VALUE);
        this.e = b3;
        if (b3 == 126) {
            int read2 = inputStream.read();
            c(read2);
            int read3 = inputStream.read();
            c(read3);
            int i2 = ((read2 << 8) | read3) & 65535;
            this.e = i2;
            if (i2 < 126) {
                throw new WebSocketException(CloseCode.ProtocolError, "Invalid data frame 2byte length.(not using minimal length encoding)");
            }
        } else if (b3 == Byte.MAX_VALUE) {
            int read4 = inputStream.read();
            c(read4);
            int read5 = inputStream.read();
            c(read5);
            int read6 = inputStream.read();
            c(read6);
            int read7 = inputStream.read();
            c(read7);
            int read8 = inputStream.read();
            c(read8);
            int read9 = inputStream.read();
            c(read9);
            int read10 = inputStream.read();
            c(read10);
            int read11 = inputStream.read();
            c(read11);
            long j = (read4 << 56) | (read5 << 48) | (read6 << 40) | (read7 << 32) | (read8 << 24) | (read9 << 16) | (read10 << 8) | read11;
            if (j > 65536) {
                if (j <= 2147483647L) {
                    this.e = (int) j;
                } else {
                    throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
                }
            } else {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
        }
        if (this.a.isControlFrame()) {
            int i3 = this.e;
            if (i3 <= 125) {
                if (this.a == OpCode.Close && i3 == 1) {
                    throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
                }
            } else {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
        }
        if (z) {
            this.c = new byte[4];
            while (true) {
                byte[] bArr = this.c;
                if (i < bArr.length) {
                    int read12 = inputStream.read(bArr, i, bArr.length - i);
                    c(read12);
                    i += read12;
                } else {
                    return;
                }
            }
        }
    }

    public void t(OutputStream outputStream) throws IOException {
        byte b2;
        int i;
        int i2;
        int i3;
        if (this.b) {
            b2 = (byte) 128;
        } else {
            b2 = 0;
        }
        outputStream.write((byte) (b2 | (this.a.getValue() & 15)));
        int length = d().length;
        this.e = length;
        if (length <= 125) {
            if (i()) {
                i3 = ((byte) this.e) | 128;
            } else {
                i3 = (byte) this.e;
            }
            outputStream.write(i3);
        } else if (length < 65536) {
            if (i()) {
                i2 = 254;
            } else {
                i2 = 126;
            }
            outputStream.write(i2);
            outputStream.write(this.e >>> 8);
            outputStream.write(this.e);
        } else {
            if (i()) {
                i = 255;
            } else {
                i = 127;
            }
            outputStream.write(i);
            outputStream.write(new byte[4]);
            outputStream.write(this.e >>> 24);
            outputStream.write(this.e >>> 16);
            outputStream.write(this.e >>> 8);
            outputStream.write(this.e);
        }
        if (i()) {
            outputStream.write(this.c);
            for (int i4 = 0; i4 < this.e; i4++) {
                outputStream.write(d()[i4] ^ this.c[i4 % 4]);
            }
        } else {
            outputStream.write(d());
        }
        outputStream.flush();
    }

    public String toString() {
        String str;
        String str2;
        Object[] objArr = new Object[4];
        objArr[0] = f();
        if (h()) {
            str = "fin";
        } else {
            str = "inter";
        }
        objArr[1] = str;
        if (i()) {
            str2 = "masked";
        } else {
            str2 = "unmasked";
        }
        objArr[2] = str2;
        objArr[3] = j();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }
}
