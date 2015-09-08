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
    private static long AQ = 0;
    private final Random AO;
    private final a AP;
    private final Handler Aw;
    private final Looper mLooper;
    private final e.a zI;
    private final n zQ;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.AO = new Random();
        this.mLooper = looper;
        this.Aw = handler;
        this.zI = aVar;
        this.zQ = nVar;
        this.AP = new a(nVar.jO() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean r(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void q(Object obj) {
        Message obtainMessage = this.Aw.obtainMessage();
        obtainMessage.obj = obj;
        this.Aw.sendMessage(obtainMessage);
    }

    private String jZ() {
        byte[] bArr = new byte[16];
        this.AO.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) {
        String str;
        if (bVar.zZ != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.zZ;
        } else {
            str = bVar.mPath;
        }
        this.AP.write("GET " + str + " HTTP/1.1");
        this.AP.js();
        this.AP.write("Host: " + bVar.zY);
        this.AP.js();
        this.AP.write("Upgrade: WebSocket");
        this.AP.js();
        this.AP.write("Connection: Upgrade");
        this.AP.js();
        this.AP.write("Sec-WebSocket-Key: " + jZ());
        this.AP.js();
        if (this.zQ != null && this.zQ.jU() != null && this.zQ.jU().length() > 0) {
            this.AP.write("Sec-WebSocket-Extensions: " + this.zQ.jU());
            this.AP.js();
        }
        if (bVar.Aa != null && !bVar.Aa.equals("")) {
            this.AP.write("Origin: " + bVar.Aa);
            this.AP.js();
        }
        if (bVar.Ab != null && bVar.Ab.length > 0) {
            this.AP.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.Ab.length; i++) {
                this.AP.write(bVar.Ab[i]);
                this.AP.write(", ");
            }
            this.AP.js();
        }
        this.AP.write("Sec-WebSocket-Version: 13");
        this.AP.js();
        if (bVar.Ac != null) {
            for (NameValuePair nameValuePair : bVar.Ac) {
                this.AP.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.AP.js();
            }
        }
        this.AP.js();
    }

    private void a(m.c cVar) {
        byte[] bArr;
        if (cVar.Ae > 0) {
            if (cVar.Af != null && !cVar.Af.equals("")) {
                byte[] bytes = cVar.Af.getBytes("UTF-8");
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
            bArr[0] = (byte) ((cVar.Ae >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (cVar.Ae & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(m.j jVar) {
        if (jVar.zX != null && jVar.zX.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.zX);
    }

    private void a(m.k kVar) {
        if (kVar.zX != null && kVar.zX.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.zX);
    }

    private boolean a(m.i iVar) {
        byte[] jt = iVar.Aj.jt();
        if (jt == null) {
            return false;
        }
        if (jt.length > this.zQ.jP()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, jt);
        return true;
    }

    private void a(m.a aVar) {
        if (aVar.zX.length > this.zQ.jP()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.zX);
    }

    private void a(m.s sVar) {
        byte[] bytes = sVar.An.getBytes("UTF-8");
        if (bytes.length > this.zQ.jP()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0008m c0008m) {
        if (c0008m.zX.length > this.zQ.jP()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0008m.zX);
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
        this.AP.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.zQ.jT()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.AP.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.AP.write((byte) (b2 | 126));
            this.AP.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.AP.write((byte) (b2 | Byte.MAX_VALUE));
            this.AP.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.zQ.jT()) {
            this.AP.write(0);
            this.AP.write(0);
            this.AP.write(0);
            this.AP.write(0);
        }
        if (j > 0) {
            this.zQ.jT();
            this.AP.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).Aj;
                }
                this.AP.clear();
                if (!s(message.obj)) {
                    q(new m.n(cVar));
                    return;
                }
                this.AP.flip();
                if (cVar != null) {
                    q(new m.r(cVar));
                }
                while (this.AP.remaining() > 0) {
                    if (this.zI == null) {
                        q(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.zI.write(this.AP.jr());
                    if (write > 0) {
                        synchronized (q.class) {
                            AQ += write;
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
            this.zI.close();
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

    public void jD() {
        synchronized (q.class) {
            AQ = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = AQ;
        }
        return j;
    }
}
