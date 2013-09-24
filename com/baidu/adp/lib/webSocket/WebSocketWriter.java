package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class WebSocketWriter extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final Random f460a;
    private final Handler b;
    private final SocketChannel c;
    private final q d;
    private final c e;

    private void c(Object obj) {
        Message obtainMessage = this.b.obtainMessage();
        obtainMessage.obj = obj;
        this.b.sendMessage(obtainMessage);
    }

    private String a() {
        byte[] bArr = new byte[16];
        this.f460a.nextBytes(bArr);
        return a.a(bArr);
    }

    private byte[] b() {
        byte[] bArr = new byte[4];
        this.f460a.nextBytes(bArr);
        return bArr;
    }

    private void a(f fVar) {
        String str;
        if (fVar.c != null) {
            str = String.valueOf(fVar.b) + "?" + fVar.c;
        } else {
            str = fVar.b;
        }
        this.e.a("GET " + str + " HTTP/1.1");
        this.e.e();
        this.e.a("Host: " + fVar.f465a);
        this.e.e();
        this.e.a("Upgrade: WebSocket");
        this.e.e();
        this.e.a("Connection: Upgrade");
        this.e.e();
        this.e.a("Sec-WebSocket-Key: " + a());
        this.e.e();
        if (this.d != null && this.d.c() != null && this.d.c().length() > 0) {
            this.e.a("Sec-WebSocket-Extensions: " + this.d.c());
            this.e.e();
        }
        if (fVar.d != null && !fVar.d.equals("")) {
            this.e.a("Origin: " + fVar.d);
            this.e.e();
        }
        if (fVar.e != null && fVar.e.length > 0) {
            this.e.a("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < fVar.e.length; i++) {
                this.e.a(fVar.e[i]);
                this.e.a(", ");
            }
            this.e.e();
        }
        this.e.a("Sec-WebSocket-Version: 13");
        this.e.e();
        if (fVar.f != null) {
            for (NameValuePair nameValuePair : fVar.f) {
                this.e.a(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.e.e();
            }
        }
        this.e.e();
    }

    private void a(g gVar) {
        byte[] bArr;
        if (gVar.f466a > 0) {
            if (gVar.b != null && !gVar.b.equals("")) {
                byte[] bytes = gVar.b.getBytes("UTF-8");
                byte[] bArr2 = new byte[bytes.length + 2];
                for (int i = 0; i < bytes.length; i++) {
                    bArr2[i + 2] = bytes[i];
                }
                bArr = bArr2;
            } else {
                bArr = new byte[2];
            }
            if (bArr != null && bArr.length > 125) {
                throw new WebSocketException("close payload exceeds 125 octets");
            }
            bArr[0] = (byte) ((gVar.f466a >> 8) & Util.MASK_8BIT);
            bArr[1] = (byte) (gVar.f466a & Util.MASK_8BIT);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(l lVar) {
        if (lVar.f468a != null && lVar.f468a.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, lVar.f468a);
    }

    private void a(m mVar) {
        if (mVar.f469a != null && mVar.f469a.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, mVar.f469a);
    }

    private void a(e eVar) {
        if (eVar.f464a.length > this.d.a()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, eVar.f464a);
    }

    private void a(p pVar) {
        byte[] bytes = pVar.f471a.getBytes("UTF-8");
        if (bytes.length > this.d.a()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(n nVar) {
        if (nVar.f470a.length > this.d.a()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, nVar.f470a);
    }

    protected void a(int i, boolean z, byte[] bArr) {
        if (bArr != null) {
            a(i, z, bArr, 0, bArr.length);
        } else {
            a(i, z, null, 0, 0);
        }
    }

    protected void a(int i, boolean z, byte[] bArr, int i2, int i3) {
        byte[] bArr2;
        byte b = 0;
        if (z) {
            b = (byte) (-128);
        }
        this.e.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.d.b()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.e.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.e.write((byte) (b2 | 126));
            this.e.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.e.write((byte) (b2 | Byte.MAX_VALUE));
            this.e.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (!this.d.b()) {
            bArr2 = null;
        } else {
            byte[] b3 = b();
            this.e.write(b3[0]);
            this.e.write(b3[1]);
            this.e.write(b3[2]);
            this.e.write(b3[3]);
            bArr2 = b3;
        }
        if (j > 0) {
            if (this.d.b()) {
                for (int i4 = 0; i4 < j; i4++) {
                    int i5 = i4 + i2;
                    bArr[i5] = (byte) (bArr[i5] ^ bArr2[i4 % 4]);
                }
            }
            this.e.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            this.e.c();
            a(message.obj);
            this.e.b();
            boolean z = false;
            if (message.obj != null && ((message.obj instanceof p) || (message.obj instanceof n) || (message.obj instanceof e))) {
                z = true;
            }
            if (z) {
                c(new o());
            }
            while (this.e.d() > 0) {
                this.c.write(this.e.a());
            }
            if (z) {
                c(new j());
            }
        } catch (SocketException e) {
            if (c()) {
                com.baidu.adp.lib.f.d.c("run() : SocketException (" + e.toString() + ")");
            }
            c(new h());
        } catch (Exception e2) {
            if (c()) {
                e2.printStackTrace();
            }
            c(new i(e2));
        }
    }

    protected void a(Object obj) {
        if (obj instanceof p) {
            a((p) obj);
        } else if (obj instanceof n) {
            a((n) obj);
        } else if (obj instanceof e) {
            a((e) obj);
        } else if (obj instanceof l) {
            a((l) obj);
        } else if (obj instanceof m) {
            a((m) obj);
        } else if (obj instanceof g) {
            a((g) obj);
        } else if (obj instanceof f) {
            a((f) obj);
        } else {
            b(obj);
        }
    }

    protected void b(Object obj) {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean c() {
        return com.baidu.adp.a.b.a().b();
    }
}
