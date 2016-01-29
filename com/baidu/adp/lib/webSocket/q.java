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
    private static long Bh = 0;
    private final Handler AN;
    private final n Ai;
    private final Random Bf;
    private final a Bg;
    private final Looper mLooper;
    private final e.a zZ;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.Bf = new Random();
        this.mLooper = looper;
        this.AN = handler;
        this.zZ = aVar;
        this.Ai = nVar;
        this.Bg = new a(nVar.kb() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean r(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void q(Object obj) {
        Message obtainMessage = this.AN.obtainMessage();
        obtainMessage.obj = obj;
        this.AN.sendMessage(obtainMessage);
    }

    private String kn() {
        byte[] bArr = new byte[16];
        this.Bf.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) {
        String str;
        if (bVar.Ar != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.Ar;
        } else {
            str = bVar.mPath;
        }
        this.Bg.write("GET " + str + " HTTP/1.1");
        this.Bg.jF();
        this.Bg.write("Host: " + bVar.Aq);
        this.Bg.jF();
        this.Bg.write("Upgrade: WebSocket");
        this.Bg.jF();
        this.Bg.write("Connection: Upgrade");
        this.Bg.jF();
        this.Bg.write("Sec-WebSocket-Key: " + kn());
        this.Bg.jF();
        if (this.Ai != null && this.Ai.ki() != null && this.Ai.ki().length() > 0) {
            this.Bg.write("Sec-WebSocket-Extensions: " + this.Ai.ki());
            this.Bg.jF();
        }
        if (bVar.As != null && !bVar.As.equals("")) {
            this.Bg.write("Origin: " + bVar.As);
            this.Bg.jF();
        }
        if (bVar.At != null && bVar.At.length > 0) {
            this.Bg.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.At.length; i++) {
                this.Bg.write(bVar.At[i]);
                this.Bg.write(", ");
            }
            this.Bg.jF();
        }
        this.Bg.write("Sec-WebSocket-Version: 13");
        this.Bg.jF();
        if (bVar.Au != null) {
            for (NameValuePair nameValuePair : bVar.Au) {
                this.Bg.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.Bg.jF();
            }
        }
        this.Bg.jF();
    }

    private void a(m.c cVar) {
        byte[] bArr;
        if (cVar.Av > 0) {
            if (cVar.Aw != null && !cVar.Aw.equals("")) {
                byte[] bytes = cVar.Aw.getBytes("UTF-8");
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
            bArr[0] = (byte) ((cVar.Av >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (cVar.Av & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(m.j jVar) {
        if (jVar.Ap != null && jVar.Ap.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Ap);
    }

    private void a(m.k kVar) {
        if (kVar.Ap != null && kVar.Ap.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.Ap);
    }

    private boolean a(m.i iVar) {
        byte[] jG = iVar.AA.jG();
        if (jG == null) {
            return false;
        }
        if (jG.length > this.Ai.kd()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, jG);
        return true;
    }

    private void a(m.a aVar) {
        if (aVar.Ap.length > this.Ai.kd()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Ap);
    }

    private void a(m.s sVar) {
        byte[] bytes = sVar.AE.getBytes("UTF-8");
        if (bytes.length > this.Ai.kd()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0009m c0009m) {
        if (c0009m.Ap.length > this.Ai.kd()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0009m.Ap);
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
        this.Bg.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.Ai.kh()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Bg.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Bg.write((byte) (b2 | 126));
            this.Bg.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Bg.write((byte) (b2 | Byte.MAX_VALUE));
            this.Bg.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Ai.kh()) {
            this.Bg.write(0);
            this.Bg.write(0);
            this.Bg.write(0);
            this.Bg.write(0);
        }
        if (j > 0) {
            this.Ai.kh();
            this.Bg.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).AA;
                }
                this.Bg.clear();
                if (!s(message.obj)) {
                    q(new m.n(cVar));
                    return;
                }
                this.Bg.flip();
                if (cVar != null) {
                    q(new m.r(cVar));
                }
                while (this.Bg.remaining() > 0) {
                    if (this.zZ == null) {
                        q(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.zZ.write(this.Bg.jE());
                    if (write > 0) {
                        synchronized (q.class) {
                            Bh += write;
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
            this.zZ.close();
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

    public void jQ() {
        synchronized (q.class) {
            Bh = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = Bh;
        }
        return j;
    }
}
