package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Log;
import com.baidu.tbadk.core.util.StringHelper;
import d.b.g0.a.k;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes2.dex */
public class WebSocketFrame {

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f11806g = k.f45443a;

    /* renamed from: h  reason: collision with root package name */
    public static final Charset f11807h = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    public OpCode f11808a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f11809b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f11810c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f11811d;

    /* renamed from: e  reason: collision with root package name */
    public int f11812e;

    /* renamed from: f  reason: collision with root package name */
    public String f11813f;

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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

        public static OpCode find(byte b2) {
            OpCode[] values;
            for (OpCode opCode : values()) {
                if (opCode.getValue() == b2) {
                    return opCode;
                }
            }
            return null;
        }

        public byte getValue() {
            return this.mCode;
        }

        public boolean isControlFrame() {
            return this == Close || this == Ping || this == Pong;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends WebSocketFrame {
        public CloseCode i;
        public String j;

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

        public CloseCode v() {
            return this.i;
        }

        public String w() {
            return this.j;
        }

        public b(CloseCode closeCode, String str) {
            super(OpCode.Close, true, u(closeCode, str));
        }

        public b(WebSocketFrame webSocketFrame) {
            super(webSocketFrame);
            if (webSocketFrame.d().length >= 2) {
                this.i = CloseCode.find((webSocketFrame.d()[1] & 255) | ((webSocketFrame.d()[0] & 255) << 8));
                this.j = WebSocketFrame.a(d(), 2, d().length - 2);
            }
        }
    }

    public WebSocketFrame(WebSocketFrame webSocketFrame) {
        q(webSocketFrame.f());
        o(webSocketFrame.h());
        n(webSocketFrame.d());
        p(webSocketFrame.e());
    }

    public static String a(byte[] bArr, int i, int i2) {
        return new String(bArr, i, i2, f11807h);
    }

    public static String b(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static int c(int i) throws EOFException {
        if (i >= 0) {
            return i;
        }
        throw new EOFException();
    }

    public static WebSocketFrame k(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        c(read);
        byte b2 = (byte) read;
        boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
        OpCode find = OpCode.find((byte) (b2 & 15));
        int i = b2 & 112;
        if (i != 0) {
            CloseCode closeCode = CloseCode.ProtocolError;
            throw new WebSocketException(closeCode, "The reserved bits (" + Integer.toBinaryString(i) + ") must be 0.");
        } else if (find != null) {
            if (find.isControlFrame() && !z) {
                throw new WebSocketException(CloseCode.ProtocolError, "Fragmented control frame.");
            }
            WebSocketFrame webSocketFrame = new WebSocketFrame(find, z);
            webSocketFrame.m(inputStream);
            webSocketFrame.l(inputStream);
            return webSocketFrame.f() == OpCode.Close ? new b() : webSocketFrame;
        } else {
            CloseCode closeCode2 = CloseCode.ProtocolError;
            throw new WebSocketException(closeCode2, "Received frame with reserved/unknown opcode " + i + ".");
        }
    }

    public static byte[] s(String str) {
        return str.getBytes(f11807h);
    }

    public byte[] d() {
        return this.f11811d;
    }

    public final byte[] e() {
        return this.f11810c;
    }

    public OpCode f() {
        return this.f11808a;
    }

    public String g() {
        if (this.f11813f == null) {
            this.f11813f = b(d());
        }
        return this.f11813f;
    }

    public boolean h() {
        return this.f11809b;
    }

    public final boolean i() {
        byte[] bArr = this.f11810c;
        return bArr != null && bArr.length == 4;
    }

    public final String j() {
        if (this.f11811d == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(this.f11811d.length);
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
            for (int i = 0; i < Math.min(this.f11811d.length, 50); i++) {
                sb.append(Integer.toHexString(this.f11811d[i] & 255));
            }
            if (this.f11811d.length > 50) {
                sb.append(StringHelper.STRING_MORE);
            }
        }
        return sb.toString();
    }

    public final void l(InputStream inputStream) throws IOException {
        this.f11811d = new byte[this.f11812e];
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = this.f11812e;
            if (i2 >= i3) {
                break;
            }
            int read = inputStream.read(this.f11811d, i2, i3 - i2);
            c(read);
            i2 += read;
        }
        if (i()) {
            while (true) {
                byte[] bArr = this.f11811d;
                if (i >= bArr.length) {
                    break;
                }
                bArr[i] = (byte) (bArr[i] ^ this.f11810c[i % 4]);
                i++;
            }
        }
        if (f() == OpCode.Text) {
            this.f11813f = b(d());
        }
    }

    public final void m(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        c(read);
        byte b2 = (byte) read;
        int i = 0;
        boolean z = (b2 & ByteCompanionObject.MIN_VALUE) != 0;
        byte b3 = (byte) (b2 & ByteCompanionObject.MAX_VALUE);
        this.f11812e = b3;
        if (b3 == 126) {
            int read2 = inputStream.read();
            c(read2);
            int read3 = inputStream.read();
            c(read3);
            int i2 = ((read2 << 8) | read3) & 65535;
            this.f11812e = i2;
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
            if (j <= 65536) {
                throw new IOException("Invalid data frame 4byte length.(not using minimal length encoding)");
            }
            if (j <= 2147483647L) {
                this.f11812e = (int) j;
            } else {
                throw new WebSocketException(CloseCode.MessageTooLong, "Max frame length has been exceeded.");
            }
        }
        if (this.f11808a.isControlFrame()) {
            int i3 = this.f11812e;
            if (i3 <= 125) {
                if (this.f11808a == OpCode.Close && i3 == 1) {
                    throw new WebSocketException(CloseCode.ProtocolError, "Received close frame with mPayload len 1.");
                }
            } else {
                throw new WebSocketException(CloseCode.ProtocolError, "Control frame with mPayload length > 125 bytes.");
            }
        }
        if (!z) {
            return;
        }
        this.f11810c = new byte[4];
        while (true) {
            byte[] bArr = this.f11810c;
            if (i >= bArr.length) {
                return;
            }
            int read12 = inputStream.read(bArr, i, bArr.length - i);
            c(read12);
            i += read12;
        }
    }

    public final void n(byte[] bArr) {
        this.f11811d = bArr;
        this.f11812e = bArr.length;
        this.f11813f = null;
    }

    public final void o(boolean z) {
        this.f11809b = z;
    }

    public final void p(byte[] bArr) {
        if (bArr != null && bArr.length != 4 && f11806g) {
            Log.e("WebSocketFrame", "MaskingKey " + Arrays.toString(bArr) + " hasn't length 4");
        }
        this.f11810c = bArr;
    }

    public final void q(OpCode opCode) {
        this.f11808a = opCode;
    }

    public final void r(String str) {
        this.f11811d = s(str);
        this.f11812e = str.length();
        this.f11813f = str;
    }

    public void t(OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((this.f11809b ? (byte) 128 : (byte) 0) | (this.f11808a.getValue() & 15)));
        int length = d().length;
        this.f11812e = length;
        if (length <= 125) {
            outputStream.write(i() ? ((byte) this.f11812e) | ByteCompanionObject.MIN_VALUE : (byte) this.f11812e);
        } else if (length < 65536) {
            outputStream.write(i() ? 254 : 126);
            outputStream.write(this.f11812e >>> 8);
            outputStream.write(this.f11812e);
        } else {
            outputStream.write(i() ? 255 : 127);
            outputStream.write(new byte[4]);
            outputStream.write(this.f11812e >>> 24);
            outputStream.write(this.f11812e >>> 16);
            outputStream.write(this.f11812e >>> 8);
            outputStream.write(this.f11812e);
        }
        if (i()) {
            outputStream.write(this.f11810c);
            for (int i = 0; i < this.f11812e; i++) {
                outputStream.write(d()[i] ^ this.f11810c[i % 4]);
            }
        } else {
            outputStream.write(d());
        }
        outputStream.flush();
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = f();
        objArr[1] = h() ? "fin" : "inter";
        objArr[2] = i() ? "masked" : "unmasked";
        objArr[3] = j();
        return String.format("WS[%s, %s, %s, %s]", objArr);
    }

    public WebSocketFrame(OpCode opCode, boolean z) {
        q(opCode);
        o(z);
    }

    public WebSocketFrame(OpCode opCode, List<WebSocketFrame> list) {
        this(opCode, true);
        Iterator<WebSocketFrame> it;
        long j = 0;
        while (list.iterator().hasNext()) {
            j += it.next().d().length;
        }
        if (j >= 0 && j <= 2147483647L) {
            int i = (int) j;
            this.f11812e = i;
            byte[] bArr = new byte[i];
            int i2 = 0;
            for (WebSocketFrame webSocketFrame : list) {
                System.arraycopy(webSocketFrame.d(), 0, bArr, i2, webSocketFrame.d().length);
                i2 += webSocketFrame.d().length;
            }
            n(bArr);
        } else if (f11806g) {
            throw new RuntimeException("Max frame length has been exceeded.");
        }
    }

    public WebSocketFrame(OpCode opCode, boolean z, byte[] bArr) {
        this(opCode, z);
        n(bArr);
    }

    public WebSocketFrame(OpCode opCode, boolean z, String str) {
        this(opCode, z);
        r(str);
    }
}
