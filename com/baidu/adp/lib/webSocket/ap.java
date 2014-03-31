package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class ap extends Handler {
    private static long g = 0;
    private final Random a;
    private final Handler b;
    private final Looper c;
    private final g d;
    private final al e;
    private final c f;

    public ap(Looper looper, Handler handler, g gVar, al alVar) {
        super(looper);
        this.a = new Random();
        this.c = looper;
        this.b = handler;
        this.d = gVar;
        this.e = alVar;
        this.f = new c(alVar.b() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("created");
        }
    }

    public final boolean a(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void b(Object obj) {
        Message obtainMessage = this.b.obtainMessage();
        obtainMessage.obj = obj;
        this.b.sendMessage(obtainMessage);
    }

    private void a(int i, boolean z, byte[] bArr) {
        if (bArr != null) {
            a(i, true, bArr, 0, bArr.length);
        } else {
            a(i, true, null, 0, 0);
        }
    }

    private void a(int i, boolean z, byte[] bArr, int i2, int i3) {
        byte b = 0;
        if (z) {
            b = Byte.MIN_VALUE;
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
        if (this.e.h()) {
            this.f.write(0);
            this.f.write(0);
            this.f.write(0);
            this.f.write(0);
        }
        if (j > 0) {
            this.e.h();
            this.f.write(bArr, 0, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        d dVar;
        byte[] bArr;
        boolean z;
        int i = 0;
        try {
            if (message.obj != null) {
                if (!(message.obj instanceof aa)) {
                    dVar = null;
                } else {
                    dVar = ((aa) message.obj).a;
                }
                this.f.c();
                Object obj = message.obj;
                if (obj instanceof aa) {
                    byte[] l = ((aa) obj).a.l();
                    if (l == null) {
                        z = false;
                    } else if (l.length > this.e.c()) {
                        throw new WebSocketException("message payload exceeds payload limit");
                    } else {
                        a(2, true, l);
                        z = true;
                    }
                } else {
                    if (obj instanceof ak) {
                        byte[] bytes = ((ak) obj).a.getBytes("UTF-8");
                        if (bytes.length > this.e.c()) {
                            throw new WebSocketException("message payload exceeds payload limit");
                        }
                        a(1, true, bytes);
                    } else if (obj instanceof ae) {
                        ae aeVar = (ae) obj;
                        if (aeVar.a.length > this.e.c()) {
                            throw new WebSocketException("message payload exceeds payload limit");
                        }
                        a(1, true, aeVar.a);
                    } else if (obj instanceof s) {
                        s sVar = (s) obj;
                        if (sVar.a.length > this.e.c()) {
                            throw new WebSocketException("message payload exceeds payload limit");
                        }
                        a(2, true, sVar.a);
                    } else if (obj instanceof ab) {
                        ab abVar = (ab) obj;
                        if (abVar.a != null && abVar.a.length > 125) {
                            throw new WebSocketException("ping payload exceeds 125 octets");
                        }
                        a(9, true, abVar.a);
                    } else if (obj instanceof ac) {
                        ac acVar = (ac) obj;
                        if (acVar.a != null && acVar.a.length > 125) {
                            throw new WebSocketException("pong payload exceeds 125 octets");
                        }
                        a(10, true, acVar.a);
                    } else if (obj instanceof u) {
                        u uVar = (u) obj;
                        if (uVar.a > 0) {
                            if (uVar.b == null || uVar.b.equals("")) {
                                bArr = new byte[2];
                            } else {
                                byte[] bytes2 = uVar.b.getBytes("UTF-8");
                                byte[] bArr2 = new byte[bytes2.length + 2];
                                while (i < bytes2.length) {
                                    bArr2[i + 2] = bytes2[i];
                                    i++;
                                }
                                bArr = bArr2;
                            }
                            if (bArr.length > 125) {
                                throw new WebSocketException("close payload exceeds 125 octets");
                            }
                            bArr[0] = (byte) ((uVar.a >> 8) & MotionEventCompat.ACTION_MASK);
                            bArr[1] = (byte) (uVar.a & MotionEventCompat.ACTION_MASK);
                            a(8, true, bArr);
                        } else {
                            a(8, true, null);
                        }
                    } else if (!(obj instanceof t)) {
                        throw new WebSocketException("unknown message received by WebSocketWriter");
                    } else {
                        t tVar = (t) obj;
                        this.f.a("GET " + (tVar.c != null ? String.valueOf(tVar.b) + "?" + tVar.c : tVar.b) + " HTTP/1.1");
                        this.f.e();
                        this.f.a("Host: " + tVar.a);
                        this.f.e();
                        this.f.a("Upgrade: WebSocket");
                        this.f.e();
                        this.f.a("Connection: Upgrade");
                        this.f.e();
                        c cVar = this.f;
                        StringBuilder sb = new StringBuilder("Sec-WebSocket-Key: ");
                        byte[] bArr3 = new byte[16];
                        this.a.nextBytes(bArr3);
                        cVar.a(sb.append(a.a(bArr3)).toString());
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
                            while (i < tVar.e.length) {
                                this.f.a(tVar.e[i]);
                                this.f.a(", ");
                                i++;
                            }
                            this.f.e();
                        }
                        this.f.a("Sec-WebSocket-Version: 13");
                        this.f.e();
                        if (tVar.f != null) {
                            for (NameValuePair nameValuePair : tVar.f) {
                                this.f.a(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                                this.f.e();
                            }
                        }
                        this.f.e();
                    }
                    z = true;
                }
                if (!z) {
                    b(new af(dVar));
                    return;
                }
                this.f.b();
                if (dVar != null) {
                    b(new aj(dVar));
                }
                while (this.f.d() > 0) {
                    if (this.d == null) {
                        b(new v(new SocketException("write socket = null")));
                        return;
                    }
                    int b = this.d.b(this.f.a());
                    if (b > 0) {
                        synchronized (ap.class) {
                            g += b;
                        }
                    }
                }
                if (dVar != null) {
                    b(new y(dVar));
                }
            }
        } catch (SocketException e) {
            if (com.baidu.adp.a.b.a().d()) {
                com.baidu.adp.lib.util.f.e("run() : SocketException (" + e.toString() + ")");
            }
            b(new v(e));
        } catch (Exception e2) {
            if (com.baidu.adp.a.b.a().d()) {
                e2.printStackTrace();
                com.baidu.adp.lib.util.f.d("----WebSocketWriter.handleMessage error. e:" + e2.getMessage());
            }
            b(new x(e2));
        }
    }

    public final void a() {
        try {
            this.c.quit();
        } catch (Exception e) {
        }
        try {
            this.d.a();
        } catch (Exception e2) {
            com.baidu.adp.lib.util.f.b("error:" + e2.getMessage());
        }
        if (com.baidu.adp.a.b.a().d()) {
            com.baidu.adp.lib.util.f.e("ended");
        }
    }

    public static void b() {
        synchronized (ap.class) {
            g = 0L;
        }
    }

    public static long c() {
        long j;
        synchronized (ap.class) {
            j = g;
        }
        return j;
    }
}
