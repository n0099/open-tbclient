package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.m;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class q extends Handler {
    private static long AS = 0;
    private final Random AQ;
    private final a AR;
    private final Handler Ay;
    private final Looper mLooper;
    private final e.a zK;
    private final n zS;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.AQ = new Random();
        this.mLooper = looper;
        this.Ay = handler;
        this.zK = aVar;
        this.zS = nVar;
        this.AR = new a(nVar.jR() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean r(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void q(Object obj) {
        Message obtainMessage = this.Ay.obtainMessage();
        obtainMessage.obj = obj;
        this.Ay.sendMessage(obtainMessage);
    }

    private String kc() {
        byte[] bArr = new byte[16];
        this.AQ.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) {
        String str;
        if (bVar.Ab != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.Ab;
        } else {
            str = bVar.mPath;
        }
        this.AR.write("GET " + str + " HTTP/1.1");
        this.AR.jv();
        this.AR.write("Host: " + bVar.Aa);
        this.AR.jv();
        this.AR.write("Upgrade: WebSocket");
        this.AR.jv();
        this.AR.write("Connection: Upgrade");
        this.AR.jv();
        this.AR.write("Sec-WebSocket-Key: " + kc());
        this.AR.jv();
        if (this.zS != null && this.zS.jX() != null && this.zS.jX().length() > 0) {
            this.AR.write("Sec-WebSocket-Extensions: " + this.zS.jX());
            this.AR.jv();
        }
        if (bVar.Ac != null && !bVar.Ac.equals("")) {
            this.AR.write("Origin: " + bVar.Ac);
            this.AR.jv();
        }
        if (bVar.Ae != null && bVar.Ae.length > 0) {
            this.AR.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.Ae.length; i++) {
                this.AR.write(bVar.Ae[i]);
                this.AR.write(", ");
            }
            this.AR.jv();
        }
        this.AR.write("Sec-WebSocket-Version: 13");
        this.AR.jv();
        if (bVar.Af != null) {
            for (NameValuePair nameValuePair : bVar.Af) {
                this.AR.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.AR.jv();
            }
        }
        this.AR.jv();
    }

    private void a(m.c cVar) {
        byte[] bArr;
        if (cVar.Ag > 0) {
            if (cVar.Ah != null && !cVar.Ah.equals("")) {
                byte[] bytes = cVar.Ah.getBytes("UTF-8");
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
            bArr[0] = (byte) ((cVar.Ag >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (cVar.Ag & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(m.j jVar) {
        if (jVar.zZ != null && jVar.zZ.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.zZ);
    }

    private void a(m.k kVar) {
        if (kVar.zZ != null && kVar.zZ.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.zZ);
    }

    private boolean a(m.i iVar) {
        byte[] jw = iVar.Al.jw();
        if (jw == null) {
            return false;
        }
        if (jw.length > this.zS.jS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, jw);
        return true;
    }

    private void a(m.a aVar) {
        if (aVar.zZ.length > this.zS.jS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.zZ);
    }

    private void a(m.s sVar) {
        byte[] bytes = sVar.Ap.getBytes("UTF-8");
        if (bytes.length > this.zS.jS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0008m c0008m) {
        if (c0008m.zZ.length > this.zS.jS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0008m.zZ);
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
        this.AR.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.zS.jW()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.AR.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.AR.write((byte) (b2 | 126));
            this.AR.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.AR.write((byte) (b2 | Byte.MAX_VALUE));
            this.AR.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.zS.jW()) {
            this.AR.write(0);
            this.AR.write(0);
            this.AR.write(0);
            this.AR.write(0);
        }
        if (j > 0) {
            this.zS.jW();
            this.AR.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).Al;
                }
                this.AR.clear();
                if (!s(message.obj)) {
                    q(new m.n(cVar));
                    return;
                }
                this.AR.flip();
                if (cVar != null) {
                    q(new m.r(cVar));
                }
                while (this.AR.remaining() > 0) {
                    if (this.zK == null) {
                        q(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.zK.write(this.AR.ju());
                    if (write > 0) {
                        synchronized (q.class) {
                            AS += write;
                        }
                    }
                }
                if (cVar != null) {
                    q(new m.g(cVar));
                }
            }
        } catch (SocketException e) {
            q(new m.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            q(new m.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.zK.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean s(Object obj) {
        if (obj instanceof m.i) {
            return a((m.i) obj);
        }
        if (obj instanceof m.s) {
            a((m.s) obj);
        } else if (obj instanceof m.C0008m) {
            a((m.C0008m) obj);
        } else if (obj instanceof m.a) {
            a((m.a) obj);
        } else if (obj instanceof m.j) {
            a((m.j) obj);
        } else if (obj instanceof m.k) {
            a((m.k) obj);
        } else if (obj instanceof m.c) {
            a((m.c) obj);
        } else if (obj instanceof m.b) {
            a((m.b) obj);
        } else {
            p(obj);
        }
        return true;
    }

    protected void p(Object obj) {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jG() {
        synchronized (q.class) {
            AS = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = AS;
        }
        return j;
    }
}
