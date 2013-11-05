package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class WebSocketWriter extends Handler {
    private static long g = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Random f518a;
    private final Handler b;
    private final Looper c;
    private final f d;
    private final ai e;
    private final c f;

    public WebSocketWriter(Looper looper, Handler handler, f fVar, ai aiVar) {
        super(looper);
        this.f518a = new Random();
        this.c = looper;
        this.b = handler;
        this.d = fVar;
        this.e = aiVar;
        this.f = new c(aiVar.b() + 14, 262144);
        if (f()) {
            com.baidu.adp.lib.h.d.d("created");
        }
    }

    public boolean a(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void d(Object obj) {
        Message obtainMessage = this.b.obtainMessage();
        obtainMessage.obj = obj;
        this.b.sendMessage(obtainMessage);
    }

    private String d() {
        byte[] bArr = new byte[16];
        this.f518a.nextBytes(bArr);
        return a.a(bArr);
    }

    private byte[] e() {
        byte[] bArr = new byte[4];
        this.f518a.nextBytes(bArr);
        return bArr;
    }

    private void a(t tVar) {
        String str;
        if (tVar.c != null) {
            str = tVar.b + "?" + tVar.c;
        } else {
            str = tVar.b;
        }
        this.f.a("GET " + str + " HTTP/1.1");
        this.f.e();
        this.f.a("Host: " + tVar.f542a);
        this.f.e();
        this.f.a("Upgrade: WebSocket");
        this.f.e();
        this.f.a("Connection: Upgrade");
        this.f.e();
        this.f.a("Sec-WebSocket-Key: " + d());
        this.f.e();
        if (this.e != null && this.e.i() != null && this.e.i().length() > 0) {
            this.f.a("Sec-WebSocket-Extensions: " + this.e.i());
            this.f.e();
        }
        if (tVar.d != null && !tVar.d.equals("")) {
            this.f.a("Origin: " + tVar.d);
            this.f.e();
        }
        if (tVar.e != null && tVar.e.length > 0) {
            this.f.a("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < tVar.e.length; i++) {
                this.f.a(tVar.e[i]);
                this.f.a(", ");
            }
            this.f.e();
        }
        this.f.a("Sec-WebSocket-Version: 13");
        this.f.e();
        if (tVar.f != null) {
            for (NameValuePair nameValuePair : tVar.f) {
                this.f.a(nameValuePair.getName() + ":" + nameValuePair.getValue());
                this.f.e();
            }
        }
        this.f.e();
    }

    private void a(u uVar) {
        byte[] bArr;
        if (uVar.f543a > 0) {
            if (uVar.b != null && !uVar.b.equals("")) {
                byte[] bytes = uVar.b.getBytes("UTF-8");
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
            bArr[0] = (byte) ((uVar.f543a >> 8) & Util.MASK_8BIT);
            bArr[1] = (byte) (uVar.f543a & Util.MASK_8BIT);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(aa aaVar) {
        if (aaVar.f520a != null && aaVar.f520a.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, aaVar.f520a);
    }

    private void a(ab abVar) {
        if (abVar.f521a != null && abVar.f521a.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, abVar.f521a);
    }

    private void a(s sVar) {
        if (sVar.f541a.length > this.e.c()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, sVar.f541a);
    }

    private void a(ah ahVar) {
        byte[] bytes = ahVar.f526a.getBytes("UTF-8");
        if (bytes.length > this.e.c()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(ad adVar) {
        if (adVar.f523a.length > this.e.c()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, adVar.f523a);
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
        this.f.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.e.h()) {
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
        if (!this.e.h()) {
            bArr2 = null;
        } else {
            byte[] e = e();
            this.f.write(e[0]);
            this.f.write(e[1]);
            this.f.write(e[2]);
            this.f.write(e[3]);
            bArr2 = e;
        }
        if (j > 0) {
            if (this.e.h()) {
                for (int i4 = 0; i4 < j; i4++) {
                    int i5 = i4 + i2;
                    bArr[i5] = (byte) (bArr[i5] ^ bArr2[i4 % 4]);
                }
            }
            this.f.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            this.f.c();
            b(message.obj);
            this.f.b();
            boolean z = false;
            if (message.obj != null && ((message.obj instanceof ah) || (message.obj instanceof ad) || (message.obj instanceof s))) {
                z = true;
            }
            if (z) {
                d(new ag());
            }
            while (this.f.d() > 0) {
                if (this.d == null) {
                    d(new v(new SocketException("write socket = null")));
                    return;
                }
                int b = this.d.b(this.f.a());
                if (b > 0) {
                    synchronized (WebSocketWriter.class) {
                        g += b;
                    }
                }
            }
            if (z) {
                d(new y());
            }
        } catch (SocketException e) {
            if (f()) {
                com.baidu.adp.lib.h.d.d("run() : SocketException (" + e.toString() + ")");
            }
            d(new v(e));
        } catch (Exception e2) {
            if (f()) {
                e2.printStackTrace();
                com.baidu.adp.lib.h.d.c("----WebSocketWriter.handleMessage error. e:" + e2.getMessage());
            }
            d(new x(e2));
        }
    }

    public void a() {
        try {
            this.c.quit();
        } catch (Exception e) {
        }
        try {
            this.d.a();
        } catch (Exception e2) {
            com.baidu.adp.lib.h.d.a("error:" + e2.getMessage());
        }
        if (f()) {
            com.baidu.adp.lib.h.d.d("ended");
        }
    }

    protected void b(Object obj) {
        if (obj instanceof ah) {
            a((ah) obj);
        } else if (obj instanceof ad) {
            a((ad) obj);
        } else if (obj instanceof s) {
            a((s) obj);
        } else if (obj instanceof aa) {
            a((aa) obj);
        } else if (obj instanceof ab) {
            a((ab) obj);
        } else if (obj instanceof u) {
            a((u) obj);
        } else if (obj instanceof t) {
            a((t) obj);
        } else {
            c(obj);
        }
    }

    protected void c(Object obj) {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean f() {
        return com.baidu.adp.a.b.a().b();
    }

    public void b() {
        synchronized (WebSocketWriter.class) {
            g = 0L;
        }
    }

    public long c() {
        long j;
        synchronized (WebSocketWriter.class) {
            j = g;
        }
        return j;
    }
}
