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
    private static long su = 0;
    private final Handler rU;
    private final e.a rg;
    private final n rp;
    private final Random sq;
    private final Looper sr;
    private final a ss;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.sq = new Random();
        this.sr = looper;
        this.rU = handler;
        this.rg = aVar;
        this.rp = nVar;
        this.ss = new a(nVar.gw() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.rU.obtainMessage();
        obtainMessage.obj = obj;
        this.rU.sendMessage(obtainMessage);
    }

    private String gH() {
        byte[] bArr = new byte[16];
        this.sq.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) throws IOException {
        String str;
        if (bVar.ry != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.ry;
        } else {
            str = bVar.mPath;
        }
        this.ss.write("GET " + str + " HTTP/1.1");
        this.ss.fY();
        this.ss.write("Host: " + bVar.rx);
        this.ss.fY();
        this.ss.write("Upgrade: WebSocket");
        this.ss.fY();
        this.ss.write("Connection: Upgrade");
        this.ss.fY();
        this.ss.write("Sec-WebSocket-Key: " + gH());
        this.ss.fY();
        if (this.rp != null && this.rp.gC() != null && this.rp.gC().length() > 0) {
            this.ss.write("Sec-WebSocket-Extensions: " + this.rp.gC());
            this.ss.fY();
        }
        if (bVar.rz != null && !bVar.rz.equals("")) {
            this.ss.write("Origin: " + bVar.rz);
            this.ss.fY();
        }
        if (bVar.rA != null && bVar.rA.length > 0) {
            this.ss.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.rA.length; i++) {
                this.ss.write(bVar.rA[i]);
                this.ss.write(", ");
            }
            this.ss.fY();
        }
        this.ss.write("Sec-WebSocket-Version: 13");
        this.ss.fY();
        if (bVar.rB != null) {
            for (NameValuePair nameValuePair : bVar.rB) {
                this.ss.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.ss.fY();
            }
        }
        this.ss.fY();
    }

    private void a(m.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.rC != null && !cVar.rC.equals("")) {
                byte[] bytes = cVar.rC.getBytes("UTF-8");
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
        if (jVar.rw != null && jVar.rw.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.rw);
    }

    private void a(m.k kVar) throws IOException, WebSocketException {
        if (kVar.rw != null && kVar.rw.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.rw);
    }

    private boolean a(m.i iVar) throws IOException, WebSocketException {
        byte[] fZ = iVar.rG.fZ();
        if (fZ == null) {
            return false;
        }
        if (fZ.length > this.rp.gx()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, fZ);
        return true;
    }

    private void c(m.a aVar) throws IOException, WebSocketException {
        if (aVar.rw.length > this.rp.gx()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.rw);
    }

    private void a(m.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.rL.getBytes("UTF-8");
        if (bytes.length > this.rp.gx()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0010m c0010m) throws IOException, WebSocketException {
        if (c0010m.rw.length > this.rp.gx()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0010m.rw);
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
        this.ss.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.rp.gB()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.ss.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.ss.write((byte) (b2 | 126));
            this.ss.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.ss.write((byte) (b2 | Byte.MAX_VALUE));
            this.ss.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.rp.gB()) {
            this.ss.write(0);
            this.ss.write(0);
            this.ss.write(0);
            this.ss.write(0);
        }
        if (j > 0) {
            this.rp.gB();
            this.ss.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).rG;
                }
                this.ss.clear();
                if (!v(message.obj)) {
                    t(new m.n(cVar));
                    return;
                }
                this.ss.flip();
                if (cVar != null) {
                    t(new m.r(cVar));
                }
                while (this.ss.remaining() > 0) {
                    if (this.rg == null) {
                        t(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.rg.write(this.ss.fX());
                    if (write > 0) {
                        synchronized (q.class) {
                            su += write;
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
            if (gk()) {
                e2.printStackTrace();
            }
            t(new m.f(e2));
        }
    }

    public void quit() {
        try {
            this.sr.quit();
        } catch (Exception e) {
        }
        try {
            this.rg.close();
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
        } else if (obj instanceof m.C0010m) {
            a((m.C0010m) obj);
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

    private boolean gk() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void gl() {
        synchronized (q.class) {
            su = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = su;
        }
        return j;
    }
}
