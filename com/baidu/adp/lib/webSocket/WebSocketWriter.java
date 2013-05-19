package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class WebSocketWriter extends Handler {
    private static final String a = WebSocketWriter.class.getName();
    private final Random b;
    private final Handler c;
    private final SocketChannel d;
    private final r e;
    private final c f;

    private void c(Object obj) {
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.obj = obj;
        this.c.sendMessage(obtainMessage);
    }

    private String a() {
        byte[] bArr = new byte[16];
        this.b.nextBytes(bArr);
        return a.a(bArr);
    }

    private byte[] b() {
        byte[] bArr = new byte[4];
        this.b.nextBytes(bArr);
        return bArr;
    }

    private void a(g gVar) {
        String str;
        if (gVar.c != null) {
            str = String.valueOf(gVar.b) + "?" + gVar.c;
        } else {
            str = gVar.b;
        }
        this.f.a("GET " + str + " HTTP/1.1");
        this.f.e();
        this.f.a("Host: " + gVar.a);
        this.f.e();
        this.f.a("Upgrade: WebSocket");
        this.f.e();
        this.f.a("Connection: Upgrade");
        this.f.e();
        this.f.a("Sec-WebSocket-Key: " + a());
        this.f.e();
        if (gVar.d != null && !gVar.d.equals("")) {
            this.f.a("Origin: " + gVar.d);
            this.f.e();
        }
        if (gVar.e != null && gVar.e.length > 0) {
            this.f.a("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < gVar.e.length; i++) {
                this.f.a(gVar.e[i]);
                this.f.a(", ");
            }
            this.f.e();
        }
        this.f.a("Sec-WebSocket-Version: 13");
        this.f.e();
        if (gVar.f != null) {
            for (NameValuePair nameValuePair : gVar.f) {
                this.f.a(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.f.e();
            }
        }
        this.f.e();
    }

    private void a(h hVar) {
        byte[] bArr;
        if (hVar.a > 0) {
            if (hVar.b != null && !hVar.b.equals("")) {
                byte[] bytes = hVar.b.getBytes("UTF-8");
                byte[] bArr2 = new byte[bytes.length + 2];
                for (int i = 0; i < bytes.length; i++) {
                    bArr2[i + 2] = bytes[i];
                }
                bArr = bArr2;
            } else {
                bArr = new byte[2];
            }
            if (bArr != null && bArr.length > 125) {
                throw new d("close payload exceeds 125 octets");
            }
            bArr[0] = (byte) ((hVar.a >> 8) & 255);
            bArr[1] = (byte) (hVar.a & 255);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(m mVar) {
        if (mVar.a != null && mVar.a.length > 125) {
            throw new d("ping payload exceeds 125 octets");
        }
        a(9, true, mVar.a);
    }

    private void a(n nVar) {
        if (nVar.a != null && nVar.a.length > 125) {
            throw new d("pong payload exceeds 125 octets");
        }
        a(10, true, nVar.a);
    }

    private void a(f fVar) {
        if (fVar.a.length > this.e.a()) {
            throw new d("message payload exceeds payload limit");
        }
        a(2, true, fVar.a);
    }

    private void a(q qVar) {
        byte[] bytes = qVar.a.getBytes("UTF-8");
        if (bytes.length > this.e.a()) {
            throw new d("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(o oVar) {
        if (oVar.a.length > this.e.a()) {
            throw new d("message payload exceeds payload limit");
        }
        a(1, true, oVar.a);
    }

    protected void a(int i, boolean z, byte[] bArr) {
        if (bArr != null) {
            a(i, z, bArr, 0, bArr.length);
        } else {
            a(i, z, null, 0, 0);
        }
    }

    protected void a(int i, boolean z, byte[] bArr, int i2, int i3) {
        byte b = 0;
        if (z) {
            b = (byte) (-128);
        }
        this.f.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.e.b()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.f.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.f.write((byte) (b2 | 126));
            this.f.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.f.write((byte) (b2 | Byte.MAX_VALUE));
            this.f.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        byte[] bArr2 = null;
        if (this.e.b()) {
            bArr2 = b();
            this.f.write(bArr2[0]);
            this.f.write(bArr2[1]);
            this.f.write(bArr2[2]);
            this.f.write(bArr2[3]);
        }
        byte[] bArr3 = bArr2;
        if (j > 0) {
            if (this.e.b()) {
                for (int i4 = 0; i4 < j; i4++) {
                    int i5 = i4 + i2;
                    bArr[i5] = (byte) (bArr[i5] ^ bArr3[i4 % 4]);
                }
            }
            this.f.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            this.f.c();
            a(message.obj);
            this.f.b();
            boolean z = false;
            if (message.obj != null && ((message.obj instanceof q) || (message.obj instanceof o) || (message.obj instanceof f))) {
                z = true;
            }
            if (z) {
                c(new p());
            }
            while (this.f.d() > 0) {
                this.d.write(this.f.a());
            }
            if (z) {
                c(new k());
            }
        } catch (SocketException e) {
            Log.d(a, "run() : SocketException (" + e.toString() + ")");
            c(new i());
        } catch (Exception e2) {
            e2.printStackTrace();
            c(new j(e2));
        }
    }

    protected void a(Object obj) {
        if (obj instanceof q) {
            a((q) obj);
        } else if (obj instanceof o) {
            a((o) obj);
        } else if (obj instanceof f) {
            a((f) obj);
        } else if (obj instanceof m) {
            a((m) obj);
        } else if (obj instanceof n) {
            a((n) obj);
        } else if (obj instanceof h) {
            a((h) obj);
        } else if (obj instanceof g) {
            a((g) obj);
        } else {
            b(obj);
        }
    }

    protected void b(Object obj) {
        throw new d("unknown message received by WebSocketWriter");
    }
}
