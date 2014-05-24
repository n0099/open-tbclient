package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class aq extends Handler {
    private static long g = 0;
    private final Random a;
    private final Handler b;
    private final Looper c;
    private final g d;
    private final am e;
    private final c f;

    public aq(Looper looper, Handler handler, g gVar, am amVar) {
        super(looper);
        this.a = new Random();
        this.c = looper;
        this.b = handler;
        this.d = gVar;
        this.e = amVar;
        this.f = new c(amVar.b() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
        if (e()) {
            BdLog.d("created");
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
        this.a.nextBytes(bArr);
        return a.a(bArr);
    }

    private void a(u uVar) {
        String str;
        if (uVar.c != null) {
            str = String.valueOf(uVar.b) + "?" + uVar.c;
        } else {
            str = uVar.b;
        }
        this.f.a("GET " + str + " HTTP/1.1");
        this.f.e();
        this.f.a("Host: " + uVar.a);
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
        if (uVar.d != null && !uVar.d.equals("")) {
            this.f.a("Origin: " + uVar.d);
            this.f.e();
        }
        if (uVar.e != null && uVar.e.length > 0) {
            this.f.a("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < uVar.e.length; i++) {
                this.f.a(uVar.e[i]);
                this.f.a(", ");
            }
            this.f.e();
        }
        this.f.a("Sec-WebSocket-Version: 13");
        this.f.e();
        if (uVar.f != null) {
            for (NameValuePair nameValuePair : uVar.f) {
                this.f.a(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.f.e();
            }
        }
        this.f.e();
    }

    private void a(v vVar) {
        byte[] bArr;
        if (vVar.a > 0) {
            if (vVar.b != null && !vVar.b.equals("")) {
                byte[] bytes = vVar.b.getBytes("UTF-8");
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
            bArr[0] = (byte) ((vVar.a >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (vVar.a & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(ac acVar) {
        if (acVar.a != null && acVar.a.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, acVar.a);
    }

    private void a(ad adVar) {
        if (adVar.a != null && adVar.a.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, adVar.a);
    }

    private boolean a(ab abVar) {
        byte[] r = abVar.a.r();
        if (r == null) {
            return false;
        }
        if (r.length > this.e.c()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, r);
        return true;
    }

    private void a(t tVar) {
        if (tVar.a.length > this.e.c()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, tVar.a);
    }

    private void a(al alVar) {
        byte[] bytes = alVar.a.getBytes("UTF-8");
        if (bytes.length > this.e.c()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(af afVar) {
        if (afVar.a.length > this.e.c()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, afVar.a);
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
            this.f.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                d dVar = null;
                if (message.obj instanceof ab) {
                    dVar = ((ab) message.obj).a;
                }
                this.f.c();
                if (!b(message.obj)) {
                    d(new ag(dVar));
                    return;
                }
                this.f.b();
                if (dVar != null) {
                    d(new ak(dVar));
                }
                while (this.f.d() > 0) {
                    if (this.d == null) {
                        d(new w(new SocketException("write socket = null")));
                        return;
                    }
                    int b = this.d.b(this.f.a());
                    if (b > 0) {
                        synchronized (aq.class) {
                            g += b;
                        }
                    }
                }
                if (dVar != null) {
                    d(new z(dVar));
                }
            }
        } catch (SocketException e) {
            if (e()) {
                BdLog.d("run() : SocketException (" + e.toString() + ")");
            }
            d(new w(e));
        } catch (Exception e2) {
            if (e()) {
                e2.printStackTrace();
                BdLog.i("----WebSocketWriter.handleMessage error. e:" + e2.getMessage());
            }
            d(new y(e2));
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
            BdLog.e("error:" + e2.getMessage());
        }
        if (e()) {
            BdLog.d("ended");
        }
    }

    protected boolean b(Object obj) {
        if (obj instanceof ab) {
            return a((ab) obj);
        }
        if (obj instanceof al) {
            a((al) obj);
        } else if (obj instanceof af) {
            a((af) obj);
        } else if (obj instanceof t) {
            a((t) obj);
        } else if (obj instanceof ac) {
            a((ac) obj);
        } else if (obj instanceof ad) {
            a((ad) obj);
        } else if (obj instanceof v) {
            a((v) obj);
        } else if (obj instanceof u) {
            a((u) obj);
        } else {
            c(obj);
        }
        return true;
    }

    protected void c(Object obj) {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean e() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void b() {
        synchronized (aq.class) {
            g = 0L;
        }
    }

    public long c() {
        long j;
        synchronized (aq.class) {
            j = g;
        }
        return j;
    }
}
