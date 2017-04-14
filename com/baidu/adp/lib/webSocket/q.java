package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.m;
import java.io.IOException;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class q extends Handler {
    private static long Br = 0;
    private final Handler AU;
    private final e.a Ah;
    private final n Ap;
    private final Random Bo;
    private final Looper Bp;
    private final a Bq;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.Bo = new Random();
        this.Bp = looper;
        this.AU = handler;
        this.Ah = aVar;
        this.Ap = nVar;
        this.Bq = new a(nVar.in() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.AU.obtainMessage();
        obtainMessage.obj = obj;
        this.AU.sendMessage(obtainMessage);
    }

    private String iy() {
        byte[] bArr = new byte[16];
        this.Bo.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) throws IOException {
        String str;
        if (bVar.Ay != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.Ay;
        } else {
            str = bVar.mPath;
        }
        this.Bq.write("GET " + str + " HTTP/1.1");
        this.Bq.hR();
        this.Bq.write("Host: " + bVar.Ax);
        this.Bq.hR();
        this.Bq.write("Upgrade: WebSocket");
        this.Bq.hR();
        this.Bq.write("Connection: Upgrade");
        this.Bq.hR();
        this.Bq.write("Sec-WebSocket-Key: " + iy());
        this.Bq.hR();
        if (this.Ap != null && this.Ap.it() != null && this.Ap.it().length() > 0) {
            this.Bq.write("Sec-WebSocket-Extensions: " + this.Ap.it());
            this.Bq.hR();
        }
        if (bVar.Az != null && !bVar.Az.equals("")) {
            this.Bq.write("Origin: " + bVar.Az);
            this.Bq.hR();
        }
        if (bVar.AA != null && bVar.AA.length > 0) {
            this.Bq.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.AA.length; i++) {
                this.Bq.write(bVar.AA[i]);
                this.Bq.write(", ");
            }
            this.Bq.hR();
        }
        this.Bq.write("Sec-WebSocket-Version: 13");
        this.Bq.hR();
        if (bVar.AB != null) {
            for (NameValuePair nameValuePair : bVar.AB) {
                this.Bq.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.Bq.hR();
            }
        }
        this.Bq.hR();
    }

    private void a(m.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.AC != null && !cVar.AC.equals("")) {
                byte[] bytes = cVar.AC.getBytes("UTF-8");
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
            bArr[0] = (byte) ((cVar.mCode >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (cVar.mCode & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(m.j jVar) throws IOException, WebSocketException {
        if (jVar.Aw != null && jVar.Aw.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Aw);
    }

    private void a(m.k kVar) throws IOException, WebSocketException {
        if (kVar.Aw != null && kVar.Aw.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.Aw);
    }

    private boolean a(m.i iVar) throws IOException, WebSocketException {
        byte[] hS = iVar.AG.hS();
        if (hS == null) {
            return false;
        }
        if (hS.length > this.Ap.io()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, hS);
        return true;
    }

    private void c(m.a aVar) throws IOException, WebSocketException {
        if (aVar.Aw.length > this.Ap.io()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Aw);
    }

    private void a(m.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.AL.getBytes("UTF-8");
        if (bytes.length > this.Ap.io()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0008m c0008m) throws IOException, WebSocketException {
        if (c0008m.Aw.length > this.Ap.io()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0008m.Aw);
    }

    protected void a(int i, boolean z, byte[] bArr) throws IOException {
        if (bArr != null) {
            a(i, z, bArr, 0, bArr.length);
        } else {
            a(i, z, null, 0, 0);
        }
    }

    protected void a(int i, boolean z, byte[] bArr, int i2, int i3) throws IOException {
        byte b = 0;
        if (z) {
            b = (byte) (-128);
        }
        this.Bq.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.Ap.is()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Bq.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Bq.write((byte) (b2 | 126));
            this.Bq.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Bq.write((byte) (b2 | Byte.MAX_VALUE));
            this.Bq.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Ap.is()) {
            this.Bq.write(0);
            this.Bq.write(0);
            this.Bq.write(0);
            this.Bq.write(0);
        }
        if (j > 0) {
            this.Ap.is();
            this.Bq.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).AG;
                }
                this.Bq.clear();
                if (!v(message.obj)) {
                    t(new m.n(cVar));
                    return;
                }
                this.Bq.flip();
                if (cVar != null) {
                    t(new m.r(cVar));
                }
                while (this.Bq.remaining() > 0) {
                    if (this.Ah == null) {
                        t(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Ah.write(this.Bq.hQ());
                    if (write > 0) {
                        synchronized (q.class) {
                            Br += write;
                        }
                    }
                }
                if (cVar != null) {
                    t(new m.g(cVar));
                }
            }
        } catch (SocketException e) {
            t(new m.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            t(new m.f(e2));
        }
    }

    public void quit() {
        try {
            this.Bp.quit();
        } catch (Exception e) {
        }
        try {
            this.Ah.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean v(Object obj) throws IOException, WebSocketException {
        if (obj instanceof m.i) {
            return a((m.i) obj);
        }
        if (obj instanceof m.s) {
            a((m.s) obj);
        } else if (obj instanceof m.C0008m) {
            a((m.C0008m) obj);
        } else if (obj instanceof m.a) {
            c((m.a) obj);
        } else if (obj instanceof m.j) {
            a((m.j) obj);
        } else if (obj instanceof m.k) {
            a((m.k) obj);
        } else if (obj instanceof m.c) {
            a((m.c) obj);
        } else if (obj instanceof m.b) {
            a((m.b) obj);
        } else {
            s(obj);
        }
        return true;
    }

    protected void s(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ic() {
        synchronized (q.class) {
            Br = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = Br;
        }
        return j;
    }
}
