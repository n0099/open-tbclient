package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.k;
import java.io.IOException;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class o extends Handler {
    private static long AP = 0;
    private final Random AN;
    private final a AO;
    private final Handler At;
    private final Looper mLooper;
    private final e.a zF;
    private final l zN;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.AN = new Random();
        this.mLooper = looper;
        this.At = handler;
        this.zF = aVar;
        this.zN = lVar;
        this.AO = new a(lVar.im() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean t(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void s(Object obj) {
        Message obtainMessage = this.At.obtainMessage();
        obtainMessage.obj = obj;
        this.At.sendMessage(obtainMessage);
    }

    private String ix() {
        byte[] bArr = new byte[16];
        this.AN.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.zW != null) {
            str = bVar.mPath + "?" + bVar.zW;
        } else {
            str = bVar.mPath;
        }
        this.AO.write("GET " + str + " HTTP/1.1");
        this.AO.hP();
        this.AO.write("Host: " + bVar.zV);
        this.AO.hP();
        this.AO.write("Upgrade: WebSocket");
        this.AO.hP();
        this.AO.write("Connection: Upgrade");
        this.AO.hP();
        this.AO.write("Sec-WebSocket-Key: " + ix());
        this.AO.hP();
        if (this.zN != null && this.zN.is() != null && this.zN.is().length() > 0) {
            this.AO.write("Sec-WebSocket-Extensions: " + this.zN.is());
            this.AO.hP();
        }
        if (bVar.zX != null && !bVar.zX.equals("")) {
            this.AO.write("Origin: " + bVar.zX);
            this.AO.hP();
        }
        if (bVar.zY != null && bVar.zY.length > 0) {
            this.AO.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.zY.length; i++) {
                this.AO.write(bVar.zY[i]);
                this.AO.write(", ");
            }
            this.AO.hP();
        }
        this.AO.write("Sec-WebSocket-Version: 13");
        this.AO.hP();
        if (bVar.zZ != null) {
            for (NameValuePair nameValuePair : bVar.zZ) {
                this.AO.write(nameValuePair.getName() + ":" + nameValuePair.getValue());
                this.AO.hP();
            }
        }
        this.AO.hP();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.Aa != null && !cVar.Aa.equals("")) {
                byte[] bytes = cVar.Aa.getBytes("UTF-8");
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

    private void a(k.j jVar) throws IOException, WebSocketException {
        if (jVar.zU != null && jVar.zU.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.zU);
    }

    private void a(k.C0008k c0008k) throws IOException, WebSocketException {
        if (c0008k.zU != null && c0008k.zU.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0008k.zU);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] hQ = iVar.Af.hQ();
        if (hQ == null) {
            return false;
        }
        if (hQ.length > this.zN.in()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, hQ);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.zU.length > this.zN.in()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.zU);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Ak.getBytes("UTF-8");
        if (bytes.length > this.zN.in()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.zU.length > this.zN.in()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.zU);
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
        this.AO.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.zN.ir()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.AO.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.AO.write((byte) (b2 | 126));
            this.AO.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.AO.write((byte) (b2 | Byte.MAX_VALUE));
            this.AO.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.zN.ir()) {
            this.AO.write(0);
            this.AO.write(0);
            this.AO.write(0);
            this.AO.write(0);
        }
        if (j > 0) {
            if (this.zN.ir()) {
            }
            this.AO.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).Af;
                }
                this.AO.clear();
                if (!u(message.obj)) {
                    s(new k.n(cVar));
                    return;
                }
                this.AO.flip();
                if (cVar != null) {
                    s(new k.r(cVar));
                }
                while (this.AO.remaining() > 0) {
                    if (this.zF == null) {
                        s(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.zF.write(this.AO.hO());
                    if (write > 0) {
                        synchronized (o.class) {
                            AP += write;
                        }
                    }
                }
                if (cVar != null) {
                    s(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            s(new k.d(e));
        } catch (Exception e2) {
            if (ia()) {
                e2.printStackTrace();
            }
            s(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.zF.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean u(Object obj) throws IOException, WebSocketException {
        if (obj instanceof k.i) {
            return a((k.i) obj);
        }
        if (obj instanceof k.s) {
            a((k.s) obj);
        } else if (obj instanceof k.m) {
            a((k.m) obj);
        } else if (obj instanceof k.a) {
            c((k.a) obj);
        } else if (obj instanceof k.j) {
            a((k.j) obj);
        } else if (obj instanceof k.C0008k) {
            a((k.C0008k) obj);
        } else if (obj instanceof k.c) {
            a((k.c) obj);
        } else if (obj instanceof k.b) {
            a((k.b) obj);
        } else {
            r(obj);
        }
        return true;
    }

    protected void r(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean ia() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ib() {
        synchronized (o.class) {
            AP = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = AP;
        }
        return j;
    }
}
