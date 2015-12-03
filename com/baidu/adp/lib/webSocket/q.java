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
    private static long AX = 0;
    private final Handler AD;
    private final Random AV;
    private final a AW;
    private final Looper mLooper;
    private final e.a zP;
    private final n zX;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.AV = new Random();
        this.mLooper = looper;
        this.AD = handler;
        this.zP = aVar;
        this.zX = nVar;
        this.AW = new a(nVar.jR() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean r(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void q(Object obj) {
        Message obtainMessage = this.AD.obtainMessage();
        obtainMessage.obj = obj;
        this.AD.sendMessage(obtainMessage);
    }

    private String kc() {
        byte[] bArr = new byte[16];
        this.AV.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) {
        String str;
        if (bVar.Ah != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.Ah;
        } else {
            str = bVar.mPath;
        }
        this.AW.write("GET " + str + " HTTP/1.1");
        this.AW.jv();
        this.AW.write("Host: " + bVar.Ag);
        this.AW.jv();
        this.AW.write("Upgrade: WebSocket");
        this.AW.jv();
        this.AW.write("Connection: Upgrade");
        this.AW.jv();
        this.AW.write("Sec-WebSocket-Key: " + kc());
        this.AW.jv();
        if (this.zX != null && this.zX.jX() != null && this.zX.jX().length() > 0) {
            this.AW.write("Sec-WebSocket-Extensions: " + this.zX.jX());
            this.AW.jv();
        }
        if (bVar.Ai != null && !bVar.Ai.equals("")) {
            this.AW.write("Origin: " + bVar.Ai);
            this.AW.jv();
        }
        if (bVar.Aj != null && bVar.Aj.length > 0) {
            this.AW.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.Aj.length; i++) {
                this.AW.write(bVar.Aj[i]);
                this.AW.write(", ");
            }
            this.AW.jv();
        }
        this.AW.write("Sec-WebSocket-Version: 13");
        this.AW.jv();
        if (bVar.Ak != null) {
            for (NameValuePair nameValuePair : bVar.Ak) {
                this.AW.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.AW.jv();
            }
        }
        this.AW.jv();
    }

    private void a(m.c cVar) {
        byte[] bArr;
        if (cVar.Al > 0) {
            if (cVar.Am != null && !cVar.Am.equals("")) {
                byte[] bytes = cVar.Am.getBytes("UTF-8");
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
            bArr[0] = (byte) ((cVar.Al >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (cVar.Al & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(m.j jVar) {
        if (jVar.Af != null && jVar.Af.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Af);
    }

    private void a(m.k kVar) {
        if (kVar.Af != null && kVar.Af.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.Af);
    }

    private boolean a(m.i iVar) {
        byte[] jw = iVar.Aq.jw();
        if (jw == null) {
            return false;
        }
        if (jw.length > this.zX.jS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, jw);
        return true;
    }

    private void a(m.a aVar) {
        if (aVar.Af.length > this.zX.jS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Af);
    }

    private void a(m.s sVar) {
        byte[] bytes = sVar.Au.getBytes("UTF-8");
        if (bytes.length > this.zX.jS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0008m c0008m) {
        if (c0008m.Af.length > this.zX.jS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0008m.Af);
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
        this.AW.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.zX.jW()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.AW.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.AW.write((byte) (b2 | 126));
            this.AW.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.AW.write((byte) (b2 | Byte.MAX_VALUE));
            this.AW.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.zX.jW()) {
            this.AW.write(0);
            this.AW.write(0);
            this.AW.write(0);
            this.AW.write(0);
        }
        if (j > 0) {
            this.zX.jW();
            this.AW.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).Aq;
                }
                this.AW.clear();
                if (!s(message.obj)) {
                    q(new m.n(cVar));
                    return;
                }
                this.AW.flip();
                if (cVar != null) {
                    q(new m.r(cVar));
                }
                while (this.AW.remaining() > 0) {
                    if (this.zP == null) {
                        q(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.zP.write(this.AW.ju());
                    if (write > 0) {
                        synchronized (q.class) {
                            AX += write;
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
            this.zP.close();
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
            AX = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = AX;
        }
        return j;
    }
}
