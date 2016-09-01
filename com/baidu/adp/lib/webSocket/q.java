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
    private static long uK = 0;
    private final n tH;
    private final e.a tz;
    private final Random uH;
    private final Looper uI;
    private final a uJ;
    private final Handler um;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.uH = new Random();
        this.uI = looper;
        this.um = handler;
        this.tz = aVar;
        this.tH = nVar;
        this.uJ = new a(nVar.hr() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.um.obtainMessage();
        obtainMessage.obj = obj;
        this.um.sendMessage(obtainMessage);
    }

    private String hC() {
        byte[] bArr = new byte[16];
        this.uH.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) throws IOException {
        String str;
        if (bVar.tQ != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.tQ;
        } else {
            str = bVar.mPath;
        }
        this.uJ.write("GET " + str + " HTTP/1.1");
        this.uJ.gU();
        this.uJ.write("Host: " + bVar.tP);
        this.uJ.gU();
        this.uJ.write("Upgrade: WebSocket");
        this.uJ.gU();
        this.uJ.write("Connection: Upgrade");
        this.uJ.gU();
        this.uJ.write("Sec-WebSocket-Key: " + hC());
        this.uJ.gU();
        if (this.tH != null && this.tH.hx() != null && this.tH.hx().length() > 0) {
            this.uJ.write("Sec-WebSocket-Extensions: " + this.tH.hx());
            this.uJ.gU();
        }
        if (bVar.tR != null && !bVar.tR.equals("")) {
            this.uJ.write("Origin: " + bVar.tR);
            this.uJ.gU();
        }
        if (bVar.tS != null && bVar.tS.length > 0) {
            this.uJ.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.tS.length; i++) {
                this.uJ.write(bVar.tS[i]);
                this.uJ.write(", ");
            }
            this.uJ.gU();
        }
        this.uJ.write("Sec-WebSocket-Version: 13");
        this.uJ.gU();
        if (bVar.tT != null) {
            for (NameValuePair nameValuePair : bVar.tT) {
                this.uJ.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.uJ.gU();
            }
        }
        this.uJ.gU();
    }

    private void a(m.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.tU != null && !cVar.tU.equals("")) {
                byte[] bytes = cVar.tU.getBytes("UTF-8");
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
        if (jVar.tO != null && jVar.tO.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.tO);
    }

    private void a(m.k kVar) throws IOException, WebSocketException {
        if (kVar.tO != null && kVar.tO.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.tO);
    }

    private boolean a(m.i iVar) throws IOException, WebSocketException {
        byte[] gV = iVar.tY.gV();
        if (gV == null) {
            return false;
        }
        if (gV.length > this.tH.hs()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, gV);
        return true;
    }

    private void c(m.a aVar) throws IOException, WebSocketException {
        if (aVar.tO.length > this.tH.hs()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.tO);
    }

    private void a(m.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.ud.getBytes("UTF-8");
        if (bytes.length > this.tH.hs()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0010m c0010m) throws IOException, WebSocketException {
        if (c0010m.tO.length > this.tH.hs()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0010m.tO);
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
        this.uJ.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.tH.hw()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.uJ.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.uJ.write((byte) (b2 | 126));
            this.uJ.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.uJ.write((byte) (b2 | Byte.MAX_VALUE));
            this.uJ.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.tH.hw()) {
            this.uJ.write(0);
            this.uJ.write(0);
            this.uJ.write(0);
            this.uJ.write(0);
        }
        if (j > 0) {
            this.tH.hw();
            this.uJ.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).tY;
                }
                this.uJ.clear();
                if (!v(message.obj)) {
                    t(new m.n(cVar));
                    return;
                }
                this.uJ.flip();
                if (cVar != null) {
                    t(new m.r(cVar));
                }
                while (this.uJ.remaining() > 0) {
                    if (this.tz == null) {
                        t(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.tz.write(this.uJ.gT());
                    if (write > 0) {
                        synchronized (q.class) {
                            uK += write;
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
            if (hf()) {
                e2.printStackTrace();
            }
            t(new m.f(e2));
        }
    }

    public void quit() {
        try {
            this.uI.quit();
        } catch (Exception e) {
        }
        try {
            this.tz.close();
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

    private boolean hf() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hg() {
        synchronized (q.class) {
            uK = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = uK;
        }
        return j;
    }
}
