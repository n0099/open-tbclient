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
    private static long AZ = 0;
    private final Handler AF;
    private final Random AX;
    private final a AY;
    private final Looper mLooper;
    private final e.a zR;
    private final n zZ;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.AX = new Random();
        this.mLooper = looper;
        this.AF = handler;
        this.zR = aVar;
        this.zZ = nVar;
        this.AY = new a(nVar.jS() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean r(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void q(Object obj) {
        Message obtainMessage = this.AF.obtainMessage();
        obtainMessage.obj = obj;
        this.AF.sendMessage(obtainMessage);
    }

    private String kd() {
        byte[] bArr = new byte[16];
        this.AX.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) {
        String str;
        if (bVar.Aj != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.Aj;
        } else {
            str = bVar.mPath;
        }
        this.AY.write("GET " + str + " HTTP/1.1");
        this.AY.jw();
        this.AY.write("Host: " + bVar.Ai);
        this.AY.jw();
        this.AY.write("Upgrade: WebSocket");
        this.AY.jw();
        this.AY.write("Connection: Upgrade");
        this.AY.jw();
        this.AY.write("Sec-WebSocket-Key: " + kd());
        this.AY.jw();
        if (this.zZ != null && this.zZ.jY() != null && this.zZ.jY().length() > 0) {
            this.AY.write("Sec-WebSocket-Extensions: " + this.zZ.jY());
            this.AY.jw();
        }
        if (bVar.Ak != null && !bVar.Ak.equals("")) {
            this.AY.write("Origin: " + bVar.Ak);
            this.AY.jw();
        }
        if (bVar.Al != null && bVar.Al.length > 0) {
            this.AY.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.Al.length; i++) {
                this.AY.write(bVar.Al[i]);
                this.AY.write(", ");
            }
            this.AY.jw();
        }
        this.AY.write("Sec-WebSocket-Version: 13");
        this.AY.jw();
        if (bVar.Am != null) {
            for (NameValuePair nameValuePair : bVar.Am) {
                this.AY.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.AY.jw();
            }
        }
        this.AY.jw();
    }

    private void a(m.c cVar) {
        byte[] bArr;
        if (cVar.An > 0) {
            if (cVar.Ao != null && !cVar.Ao.equals("")) {
                byte[] bytes = cVar.Ao.getBytes("UTF-8");
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
            bArr[0] = (byte) ((cVar.An >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (cVar.An & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(m.j jVar) {
        if (jVar.Ah != null && jVar.Ah.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Ah);
    }

    private void a(m.k kVar) {
        if (kVar.Ah != null && kVar.Ah.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.Ah);
    }

    private boolean a(m.i iVar) {
        byte[] jx = iVar.As.jx();
        if (jx == null) {
            return false;
        }
        if (jx.length > this.zZ.jT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, jx);
        return true;
    }

    private void a(m.a aVar) {
        if (aVar.Ah.length > this.zZ.jT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Ah);
    }

    private void a(m.s sVar) {
        byte[] bytes = sVar.Aw.getBytes("UTF-8");
        if (bytes.length > this.zZ.jT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0009m c0009m) {
        if (c0009m.Ah.length > this.zZ.jT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0009m.Ah);
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
        this.AY.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.zZ.jX()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.AY.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.AY.write((byte) (b2 | 126));
            this.AY.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.AY.write((byte) (b2 | Byte.MAX_VALUE));
            this.AY.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.zZ.jX()) {
            this.AY.write(0);
            this.AY.write(0);
            this.AY.write(0);
            this.AY.write(0);
        }
        if (j > 0) {
            this.zZ.jX();
            this.AY.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).As;
                }
                this.AY.clear();
                if (!s(message.obj)) {
                    q(new m.n(cVar));
                    return;
                }
                this.AY.flip();
                if (cVar != null) {
                    q(new m.r(cVar));
                }
                while (this.AY.remaining() > 0) {
                    if (this.zR == null) {
                        q(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.zR.write(this.AY.jv());
                    if (write > 0) {
                        synchronized (q.class) {
                            AZ += write;
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
            this.zR.close();
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
        } else if (obj instanceof m.C0009m) {
            a((m.C0009m) obj);
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

    public void jH() {
        synchronized (q.class) {
            AZ = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = AZ;
        }
        return j;
    }
}
