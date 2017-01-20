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
    private static long uC = 0;
    private final e.a tr;
    private final n tz;
    private final Looper uA;
    private final a uB;
    private final Handler ue;
    private final Random uz;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.uz = new Random();
        this.uA = looper;
        this.ue = handler;
        this.tr = aVar;
        this.tz = nVar;
        this.uB = new a(nVar.hp() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.ue.obtainMessage();
        obtainMessage.obj = obj;
        this.ue.sendMessage(obtainMessage);
    }

    private String hA() {
        byte[] bArr = new byte[16];
        this.uz.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) throws IOException {
        String str;
        if (bVar.tI != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.tI;
        } else {
            str = bVar.mPath;
        }
        this.uB.write("GET " + str + " HTTP/1.1");
        this.uB.gS();
        this.uB.write("Host: " + bVar.tH);
        this.uB.gS();
        this.uB.write("Upgrade: WebSocket");
        this.uB.gS();
        this.uB.write("Connection: Upgrade");
        this.uB.gS();
        this.uB.write("Sec-WebSocket-Key: " + hA());
        this.uB.gS();
        if (this.tz != null && this.tz.hv() != null && this.tz.hv().length() > 0) {
            this.uB.write("Sec-WebSocket-Extensions: " + this.tz.hv());
            this.uB.gS();
        }
        if (bVar.tJ != null && !bVar.tJ.equals("")) {
            this.uB.write("Origin: " + bVar.tJ);
            this.uB.gS();
        }
        if (bVar.tK != null && bVar.tK.length > 0) {
            this.uB.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.tK.length; i++) {
                this.uB.write(bVar.tK[i]);
                this.uB.write(", ");
            }
            this.uB.gS();
        }
        this.uB.write("Sec-WebSocket-Version: 13");
        this.uB.gS();
        if (bVar.tL != null) {
            for (NameValuePair nameValuePair : bVar.tL) {
                this.uB.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.uB.gS();
            }
        }
        this.uB.gS();
    }

    private void a(m.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.tM != null && !cVar.tM.equals("")) {
                byte[] bytes = cVar.tM.getBytes("UTF-8");
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
        if (jVar.tG != null && jVar.tG.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.tG);
    }

    private void a(m.k kVar) throws IOException, WebSocketException {
        if (kVar.tG != null && kVar.tG.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.tG);
    }

    private boolean a(m.i iVar) throws IOException, WebSocketException {
        byte[] gT = iVar.tQ.gT();
        if (gT == null) {
            return false;
        }
        if (gT.length > this.tz.hq()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, gT);
        return true;
    }

    private void c(m.a aVar) throws IOException, WebSocketException {
        if (aVar.tG.length > this.tz.hq()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.tG);
    }

    private void a(m.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.tV.getBytes("UTF-8");
        if (bytes.length > this.tz.hq()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0009m c0009m) throws IOException, WebSocketException {
        if (c0009m.tG.length > this.tz.hq()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0009m.tG);
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
        this.uB.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.tz.hu()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.uB.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.uB.write((byte) (b2 | 126));
            this.uB.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.uB.write((byte) (b2 | Byte.MAX_VALUE));
            this.uB.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.tz.hu()) {
            this.uB.write(0);
            this.uB.write(0);
            this.uB.write(0);
            this.uB.write(0);
        }
        if (j > 0) {
            this.tz.hu();
            this.uB.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).tQ;
                }
                this.uB.clear();
                if (!v(message.obj)) {
                    t(new m.n(cVar));
                    return;
                }
                this.uB.flip();
                if (cVar != null) {
                    t(new m.r(cVar));
                }
                while (this.uB.remaining() > 0) {
                    if (this.tr == null) {
                        t(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.tr.write(this.uB.gR());
                    if (write > 0) {
                        synchronized (q.class) {
                            uC += write;
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
            if (hd()) {
                e2.printStackTrace();
            }
            t(new m.f(e2));
        }
    }

    public void quit() {
        try {
            this.uA.quit();
        } catch (Exception e) {
        }
        try {
            this.tr.close();
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
        } else if (obj instanceof m.C0009m) {
            a((m.C0009m) obj);
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

    private boolean hd() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void he() {
        synchronized (q.class) {
            uC = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = uC;
        }
        return j;
    }
}
