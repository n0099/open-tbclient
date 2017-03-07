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
    private static long BQ = 0;
    private final e.a AG;
    private final n AO;
    private final Random BN;
    private final Looper BO;
    private final a BP;
    private final Handler Bt;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.BN = new Random();
        this.BO = looper;
        this.Bt = handler;
        this.AG = aVar;
        this.AO = nVar;
        this.BP = new a(nVar.ij() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.Bt.obtainMessage();
        obtainMessage.obj = obj;
        this.Bt.sendMessage(obtainMessage);
    }

    private String iu() {
        byte[] bArr = new byte[16];
        this.BN.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) throws IOException {
        String str;
        if (bVar.AX != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.AX;
        } else {
            str = bVar.mPath;
        }
        this.BP.write("GET " + str + " HTTP/1.1");
        this.BP.hM();
        this.BP.write("Host: " + bVar.AW);
        this.BP.hM();
        this.BP.write("Upgrade: WebSocket");
        this.BP.hM();
        this.BP.write("Connection: Upgrade");
        this.BP.hM();
        this.BP.write("Sec-WebSocket-Key: " + iu());
        this.BP.hM();
        if (this.AO != null && this.AO.ip() != null && this.AO.ip().length() > 0) {
            this.BP.write("Sec-WebSocket-Extensions: " + this.AO.ip());
            this.BP.hM();
        }
        if (bVar.AY != null && !bVar.AY.equals("")) {
            this.BP.write("Origin: " + bVar.AY);
            this.BP.hM();
        }
        if (bVar.AZ != null && bVar.AZ.length > 0) {
            this.BP.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.AZ.length; i++) {
                this.BP.write(bVar.AZ[i]);
                this.BP.write(", ");
            }
            this.BP.hM();
        }
        this.BP.write("Sec-WebSocket-Version: 13");
        this.BP.hM();
        if (bVar.Ba != null) {
            for (NameValuePair nameValuePair : bVar.Ba) {
                this.BP.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.BP.hM();
            }
        }
        this.BP.hM();
    }

    private void a(m.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.Bb != null && !cVar.Bb.equals("")) {
                byte[] bytes = cVar.Bb.getBytes("UTF-8");
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
        if (jVar.AV != null && jVar.AV.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.AV);
    }

    private void a(m.k kVar) throws IOException, WebSocketException {
        if (kVar.AV != null && kVar.AV.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.AV);
    }

    private boolean a(m.i iVar) throws IOException, WebSocketException {
        byte[] hN = iVar.Bf.hN();
        if (hN == null) {
            return false;
        }
        if (hN.length > this.AO.ik()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, hN);
        return true;
    }

    private void c(m.a aVar) throws IOException, WebSocketException {
        if (aVar.AV.length > this.AO.ik()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.AV);
    }

    private void a(m.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Bk.getBytes("UTF-8");
        if (bytes.length > this.AO.ik()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0008m c0008m) throws IOException, WebSocketException {
        if (c0008m.AV.length > this.AO.ik()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0008m.AV);
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
        this.BP.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.AO.io()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.BP.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.BP.write((byte) (b2 | 126));
            this.BP.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.BP.write((byte) (b2 | Byte.MAX_VALUE));
            this.BP.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.AO.io()) {
            this.BP.write(0);
            this.BP.write(0);
            this.BP.write(0);
            this.BP.write(0);
        }
        if (j > 0) {
            this.AO.io();
            this.BP.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).Bf;
                }
                this.BP.clear();
                if (!v(message.obj)) {
                    t(new m.n(cVar));
                    return;
                }
                this.BP.flip();
                if (cVar != null) {
                    t(new m.r(cVar));
                }
                while (this.BP.remaining() > 0) {
                    if (this.AG == null) {
                        t(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.AG.write(this.BP.hL());
                    if (write > 0) {
                        synchronized (q.class) {
                            BQ += write;
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
            if (hX()) {
                e2.printStackTrace();
            }
            t(new m.f(e2));
        }
    }

    public void quit() {
        try {
            this.BO.quit();
        } catch (Exception e) {
        }
        try {
            this.AG.close();
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

    private boolean hX() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hY() {
        synchronized (q.class) {
            BQ = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = BQ;
        }
        return j;
    }
}
