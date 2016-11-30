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
    private static long uL = 0;
    private final e.a tA;
    private final n tI;
    private final Random uI;
    private final Looper uJ;
    private final a uK;
    private final Handler uo;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.uI = new Random();
        this.uJ = looper;
        this.uo = handler;
        this.tA = aVar;
        this.tI = nVar;
        this.uK = new a(nVar.hr() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.uo.obtainMessage();
        obtainMessage.obj = obj;
        this.uo.sendMessage(obtainMessage);
    }

    private String hC() {
        byte[] bArr = new byte[16];
        this.uI.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) throws IOException {
        String str;
        if (bVar.tR != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.tR;
        } else {
            str = bVar.mPath;
        }
        this.uK.write("GET " + str + " HTTP/1.1");
        this.uK.gU();
        this.uK.write("Host: " + bVar.tQ);
        this.uK.gU();
        this.uK.write("Upgrade: WebSocket");
        this.uK.gU();
        this.uK.write("Connection: Upgrade");
        this.uK.gU();
        this.uK.write("Sec-WebSocket-Key: " + hC());
        this.uK.gU();
        if (this.tI != null && this.tI.hx() != null && this.tI.hx().length() > 0) {
            this.uK.write("Sec-WebSocket-Extensions: " + this.tI.hx());
            this.uK.gU();
        }
        if (bVar.tS != null && !bVar.tS.equals("")) {
            this.uK.write("Origin: " + bVar.tS);
            this.uK.gU();
        }
        if (bVar.tT != null && bVar.tT.length > 0) {
            this.uK.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.tT.length; i++) {
                this.uK.write(bVar.tT[i]);
                this.uK.write(", ");
            }
            this.uK.gU();
        }
        this.uK.write("Sec-WebSocket-Version: 13");
        this.uK.gU();
        if (bVar.tU != null) {
            for (NameValuePair nameValuePair : bVar.tU) {
                this.uK.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.uK.gU();
            }
        }
        this.uK.gU();
    }

    private void a(m.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.tV != null && !cVar.tV.equals("")) {
                byte[] bytes = cVar.tV.getBytes("UTF-8");
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
        if (jVar.tP != null && jVar.tP.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.tP);
    }

    private void a(m.k kVar) throws IOException, WebSocketException {
        if (kVar.tP != null && kVar.tP.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.tP);
    }

    private boolean a(m.i iVar) throws IOException, WebSocketException {
        byte[] gV = iVar.tZ.gV();
        if (gV == null) {
            return false;
        }
        if (gV.length > this.tI.hs()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, gV);
        return true;
    }

    private void c(m.a aVar) throws IOException, WebSocketException {
        if (aVar.tP.length > this.tI.hs()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.tP);
    }

    private void a(m.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.ue.getBytes("UTF-8");
        if (bytes.length > this.tI.hs()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0010m c0010m) throws IOException, WebSocketException {
        if (c0010m.tP.length > this.tI.hs()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0010m.tP);
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
        this.uK.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.tI.hw()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.uK.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.uK.write((byte) (b2 | 126));
            this.uK.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.uK.write((byte) (b2 | Byte.MAX_VALUE));
            this.uK.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.tI.hw()) {
            this.uK.write(0);
            this.uK.write(0);
            this.uK.write(0);
            this.uK.write(0);
        }
        if (j > 0) {
            this.tI.hw();
            this.uK.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).tZ;
                }
                this.uK.clear();
                if (!v(message.obj)) {
                    t(new m.n(cVar));
                    return;
                }
                this.uK.flip();
                if (cVar != null) {
                    t(new m.r(cVar));
                }
                while (this.uK.remaining() > 0) {
                    if (this.tA == null) {
                        t(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.tA.write(this.uK.gT());
                    if (write > 0) {
                        synchronized (q.class) {
                            uL += write;
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
            this.uJ.quit();
        } catch (Exception e) {
        }
        try {
            this.tA.close();
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
            uL = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = uL;
        }
        return j;
    }
}
