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
    private static long Bu = 0;
    private final Handler AX;
    private final e.a Ak;
    private final n As;
    private final Random Br;
    private final Looper Bs;
    private final a Bt;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.Br = new Random();
        this.Bs = looper;
        this.AX = handler;
        this.Ak = aVar;
        this.As = nVar;
        this.Bt = new a(nVar.in() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.AX.obtainMessage();
        obtainMessage.obj = obj;
        this.AX.sendMessage(obtainMessage);
    }

    private String iy() {
        byte[] bArr = new byte[16];
        this.Br.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) throws IOException {
        String str;
        if (bVar.AB != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.AB;
        } else {
            str = bVar.mPath;
        }
        this.Bt.write("GET " + str + " HTTP/1.1");
        this.Bt.hR();
        this.Bt.write("Host: " + bVar.AA);
        this.Bt.hR();
        this.Bt.write("Upgrade: WebSocket");
        this.Bt.hR();
        this.Bt.write("Connection: Upgrade");
        this.Bt.hR();
        this.Bt.write("Sec-WebSocket-Key: " + iy());
        this.Bt.hR();
        if (this.As != null && this.As.it() != null && this.As.it().length() > 0) {
            this.Bt.write("Sec-WebSocket-Extensions: " + this.As.it());
            this.Bt.hR();
        }
        if (bVar.AC != null && !bVar.AC.equals("")) {
            this.Bt.write("Origin: " + bVar.AC);
            this.Bt.hR();
        }
        if (bVar.AD != null && bVar.AD.length > 0) {
            this.Bt.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.AD.length; i++) {
                this.Bt.write(bVar.AD[i]);
                this.Bt.write(", ");
            }
            this.Bt.hR();
        }
        this.Bt.write("Sec-WebSocket-Version: 13");
        this.Bt.hR();
        if (bVar.AE != null) {
            for (NameValuePair nameValuePair : bVar.AE) {
                this.Bt.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.Bt.hR();
            }
        }
        this.Bt.hR();
    }

    private void a(m.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.AF != null && !cVar.AF.equals("")) {
                byte[] bytes = cVar.AF.getBytes("UTF-8");
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
        if (jVar.Az != null && jVar.Az.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Az);
    }

    private void a(m.k kVar) throws IOException, WebSocketException {
        if (kVar.Az != null && kVar.Az.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.Az);
    }

    private boolean a(m.i iVar) throws IOException, WebSocketException {
        byte[] hS = iVar.AJ.hS();
        if (hS == null) {
            return false;
        }
        if (hS.length > this.As.io()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, hS);
        return true;
    }

    private void c(m.a aVar) throws IOException, WebSocketException {
        if (aVar.Az.length > this.As.io()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Az);
    }

    private void a(m.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.AO.getBytes("UTF-8");
        if (bytes.length > this.As.io()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0008m c0008m) throws IOException, WebSocketException {
        if (c0008m.Az.length > this.As.io()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0008m.Az);
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
        this.Bt.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.As.is()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Bt.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Bt.write((byte) (b2 | 126));
            this.Bt.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Bt.write((byte) (b2 | Byte.MAX_VALUE));
            this.Bt.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.As.is()) {
            this.Bt.write(0);
            this.Bt.write(0);
            this.Bt.write(0);
            this.Bt.write(0);
        }
        if (j > 0) {
            this.As.is();
            this.Bt.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).AJ;
                }
                this.Bt.clear();
                if (!v(message.obj)) {
                    t(new m.n(cVar));
                    return;
                }
                this.Bt.flip();
                if (cVar != null) {
                    t(new m.r(cVar));
                }
                while (this.Bt.remaining() > 0) {
                    if (this.Ak == null) {
                        t(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Ak.write(this.Bt.hQ());
                    if (write > 0) {
                        synchronized (q.class) {
                            Bu += write;
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
            this.Bs.quit();
        } catch (Exception e) {
        }
        try {
            this.Ak.close();
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
            Bu = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = Bu;
        }
        return j;
    }
}
