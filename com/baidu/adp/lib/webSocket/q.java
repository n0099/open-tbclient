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
    private static long AR = 0;
    private final Random AP;
    private final a AQ;
    private final Handler Ax;
    private final Looper mLooper;
    private final e.a zJ;
    private final n zR;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.AP = new Random();
        this.mLooper = looper;
        this.Ax = handler;
        this.zJ = aVar;
        this.zR = nVar;
        this.AQ = new a(nVar.jP() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean r(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void q(Object obj) {
        Message obtainMessage = this.Ax.obtainMessage();
        obtainMessage.obj = obj;
        this.Ax.sendMessage(obtainMessage);
    }

    private String ka() {
        byte[] bArr = new byte[16];
        this.AP.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) {
        String str;
        if (bVar.Aa != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.Aa;
        } else {
            str = bVar.mPath;
        }
        this.AQ.write("GET " + str + " HTTP/1.1");
        this.AQ.jt();
        this.AQ.write("Host: " + bVar.zZ);
        this.AQ.jt();
        this.AQ.write("Upgrade: WebSocket");
        this.AQ.jt();
        this.AQ.write("Connection: Upgrade");
        this.AQ.jt();
        this.AQ.write("Sec-WebSocket-Key: " + ka());
        this.AQ.jt();
        if (this.zR != null && this.zR.jV() != null && this.zR.jV().length() > 0) {
            this.AQ.write("Sec-WebSocket-Extensions: " + this.zR.jV());
            this.AQ.jt();
        }
        if (bVar.Ab != null && !bVar.Ab.equals("")) {
            this.AQ.write("Origin: " + bVar.Ab);
            this.AQ.jt();
        }
        if (bVar.Ac != null && bVar.Ac.length > 0) {
            this.AQ.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.Ac.length; i++) {
                this.AQ.write(bVar.Ac[i]);
                this.AQ.write(", ");
            }
            this.AQ.jt();
        }
        this.AQ.write("Sec-WebSocket-Version: 13");
        this.AQ.jt();
        if (bVar.Ae != null) {
            for (NameValuePair nameValuePair : bVar.Ae) {
                this.AQ.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.AQ.jt();
            }
        }
        this.AQ.jt();
    }

    private void a(m.c cVar) {
        byte[] bArr;
        if (cVar.Af > 0) {
            if (cVar.Ag != null && !cVar.Ag.equals("")) {
                byte[] bytes = cVar.Ag.getBytes("UTF-8");
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
            bArr[0] = (byte) ((cVar.Af >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (cVar.Af & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(m.j jVar) {
        if (jVar.zY != null && jVar.zY.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.zY);
    }

    private void a(m.k kVar) {
        if (kVar.zY != null && kVar.zY.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.zY);
    }

    private boolean a(m.i iVar) {
        byte[] ju = iVar.Ak.ju();
        if (ju == null) {
            return false;
        }
        if (ju.length > this.zR.jQ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, ju);
        return true;
    }

    private void a(m.a aVar) {
        if (aVar.zY.length > this.zR.jQ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.zY);
    }

    private void a(m.s sVar) {
        byte[] bytes = sVar.Ao.getBytes("UTF-8");
        if (bytes.length > this.zR.jQ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0008m c0008m) {
        if (c0008m.zY.length > this.zR.jQ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0008m.zY);
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
        this.AQ.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.zR.jU()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.AQ.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.AQ.write((byte) (b2 | 126));
            this.AQ.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.AQ.write((byte) (b2 | Byte.MAX_VALUE));
            this.AQ.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.zR.jU()) {
            this.AQ.write(0);
            this.AQ.write(0);
            this.AQ.write(0);
            this.AQ.write(0);
        }
        if (j > 0) {
            this.zR.jU();
            this.AQ.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).Ak;
                }
                this.AQ.clear();
                if (!s(message.obj)) {
                    q(new m.n(cVar));
                    return;
                }
                this.AQ.flip();
                if (cVar != null) {
                    q(new m.r(cVar));
                }
                while (this.AQ.remaining() > 0) {
                    if (this.zJ == null) {
                        q(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.zJ.write(this.AQ.js());
                    if (write > 0) {
                        synchronized (q.class) {
                            AR += write;
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
            this.zJ.close();
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

    public void jE() {
        synchronized (q.class) {
            AR = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = AR;
        }
        return j;
    }
}
