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
    private static long rP = 0;
    private final e.a qE;
    private final n qM;
    private final Random rM;
    private final Looper rN;
    private final a rO;
    private final Handler rs;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.rM = new Random();
        this.rN = looper;
        this.rs = handler;
        this.qE = aVar;
        this.qM = nVar;
        this.rO = new a(nVar.gx() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean r(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void q(Object obj) {
        Message obtainMessage = this.rs.obtainMessage();
        obtainMessage.obj = obj;
        this.rs.sendMessage(obtainMessage);
    }

    private String gI() {
        byte[] bArr = new byte[16];
        this.rM.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) {
        String str;
        if (bVar.qV != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.qV;
        } else {
            str = bVar.mPath;
        }
        this.rO.write("GET " + str + " HTTP/1.1");
        this.rO.fZ();
        this.rO.write("Host: " + bVar.qU);
        this.rO.fZ();
        this.rO.write("Upgrade: WebSocket");
        this.rO.fZ();
        this.rO.write("Connection: Upgrade");
        this.rO.fZ();
        this.rO.write("Sec-WebSocket-Key: " + gI());
        this.rO.fZ();
        if (this.qM != null && this.qM.gD() != null && this.qM.gD().length() > 0) {
            this.rO.write("Sec-WebSocket-Extensions: " + this.qM.gD());
            this.rO.fZ();
        }
        if (bVar.qW != null && !bVar.qW.equals("")) {
            this.rO.write("Origin: " + bVar.qW);
            this.rO.fZ();
        }
        if (bVar.qX != null && bVar.qX.length > 0) {
            this.rO.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.qX.length; i++) {
                this.rO.write(bVar.qX[i]);
                this.rO.write(", ");
            }
            this.rO.fZ();
        }
        this.rO.write("Sec-WebSocket-Version: 13");
        this.rO.fZ();
        if (bVar.qY != null) {
            for (NameValuePair nameValuePair : bVar.qY) {
                this.rO.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.rO.fZ();
            }
        }
        this.rO.fZ();
    }

    private void a(m.c cVar) {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.qZ != null && !cVar.qZ.equals("")) {
                byte[] bytes = cVar.qZ.getBytes("UTF-8");
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

    private void a(m.j jVar) {
        if (jVar.qT != null && jVar.qT.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.qT);
    }

    private void a(m.k kVar) {
        if (kVar.qT != null && kVar.qT.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.qT);
    }

    private boolean a(m.i iVar) {
        byte[] ga = iVar.rd.ga();
        if (ga == null) {
            return false;
        }
        if (ga.length > this.qM.gy()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, ga);
        return true;
    }

    private void c(m.a aVar) {
        if (aVar.qT.length > this.qM.gy()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.qT);
    }

    private void a(m.s sVar) {
        byte[] bytes = sVar.ri.getBytes("UTF-8");
        if (bytes.length > this.qM.gy()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0010m c0010m) {
        if (c0010m.qT.length > this.qM.gy()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0010m.qT);
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
        this.rO.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.qM.gC()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.rO.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.rO.write((byte) (b2 | 126));
            this.rO.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.rO.write((byte) (b2 | Byte.MAX_VALUE));
            this.rO.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.qM.gC()) {
            this.rO.write(0);
            this.rO.write(0);
            this.rO.write(0);
            this.rO.write(0);
        }
        if (j > 0) {
            this.qM.gC();
            this.rO.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).rd;
                }
                this.rO.clear();
                if (!s(message.obj)) {
                    q(new m.n(cVar));
                    return;
                }
                this.rO.flip();
                if (cVar != null) {
                    q(new m.r(cVar));
                }
                while (this.rO.remaining() > 0) {
                    if (this.qE == null) {
                        q(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.qE.write(this.rO.fY());
                    if (write > 0) {
                        synchronized (q.class) {
                            rP += write;
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
            if (gl()) {
                e2.printStackTrace();
            }
            q(new m.f(e2));
        }
    }

    public void quit() {
        try {
            this.rN.quit();
        } catch (Exception e) {
        }
        try {
            this.qE.close();
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
            p(obj);
        }
        return true;
    }

    protected void p(Object obj) {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean gl() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void gm() {
        synchronized (q.class) {
            rP = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = rP;
        }
        return j;
    }
}
