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
    private static long AR = 0;
    private final Random AP;
    private final a AQ;
    private final Handler Au;
    private final Looper mLooper;
    private final e.a zG;
    private final l zO;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.AP = new Random();
        this.mLooper = looper;
        this.Au = handler;
        this.zG = aVar;
        this.zO = lVar;
        this.AQ = new a(lVar.il() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean t(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void s(Object obj) {
        Message obtainMessage = this.Au.obtainMessage();
        obtainMessage.obj = obj;
        this.Au.sendMessage(obtainMessage);
    }

    private String iw() {
        byte[] bArr = new byte[16];
        this.AP.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.zX != null) {
            str = bVar.mPath + "?" + bVar.zX;
        } else {
            str = bVar.mPath;
        }
        this.AQ.write("GET " + str + " HTTP/1.1");
        this.AQ.hO();
        this.AQ.write("Host: " + bVar.zW);
        this.AQ.hO();
        this.AQ.write("Upgrade: WebSocket");
        this.AQ.hO();
        this.AQ.write("Connection: Upgrade");
        this.AQ.hO();
        this.AQ.write("Sec-WebSocket-Key: " + iw());
        this.AQ.hO();
        if (this.zO != null && this.zO.ir() != null && this.zO.ir().length() > 0) {
            this.AQ.write("Sec-WebSocket-Extensions: " + this.zO.ir());
            this.AQ.hO();
        }
        if (bVar.zY != null && !bVar.zY.equals("")) {
            this.AQ.write("Origin: " + bVar.zY);
            this.AQ.hO();
        }
        if (bVar.zZ != null && bVar.zZ.length > 0) {
            this.AQ.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.zZ.length; i++) {
                this.AQ.write(bVar.zZ[i]);
                this.AQ.write(", ");
            }
            this.AQ.hO();
        }
        this.AQ.write("Sec-WebSocket-Version: 13");
        this.AQ.hO();
        if (bVar.Aa != null) {
            for (NameValuePair nameValuePair : bVar.Aa) {
                this.AQ.write(nameValuePair.getName() + ":" + nameValuePair.getValue());
                this.AQ.hO();
            }
        }
        this.AQ.hO();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.Ab != null && !cVar.Ab.equals("")) {
                byte[] bytes = cVar.Ab.getBytes("UTF-8");
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
        if (jVar.zV != null && jVar.zV.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.zV);
    }

    private void a(k.C0008k c0008k) throws IOException, WebSocketException {
        if (c0008k.zV != null && c0008k.zV.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0008k.zV);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] hP = iVar.Ag.hP();
        if (hP == null) {
            return false;
        }
        if (hP.length > this.zO.im()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, hP);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.zV.length > this.zO.im()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.zV);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Al.getBytes("UTF-8");
        if (bytes.length > this.zO.im()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.zV.length > this.zO.im()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.zV);
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
        this.AQ.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.zO.iq()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.AQ.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.AQ.write((byte) (b2 | 126));
            this.AQ.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.AQ.write((byte) (b2 | Byte.MAX_VALUE));
            this.AQ.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.zO.iq()) {
            this.AQ.write(0);
            this.AQ.write(0);
            this.AQ.write(0);
            this.AQ.write(0);
        }
        if (j > 0) {
            if (this.zO.iq()) {
            }
            this.AQ.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).Ag;
                }
                this.AQ.clear();
                if (!u(message.obj)) {
                    s(new k.n(cVar));
                    return;
                }
                this.AQ.flip();
                if (cVar != null) {
                    s(new k.r(cVar));
                }
                while (this.AQ.remaining() > 0) {
                    if (this.zG == null) {
                        s(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.zG.write(this.AQ.hN());
                    if (write > 0) {
                        synchronized (o.class) {
                            AR += write;
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
            if (hZ()) {
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
            this.zG.close();
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

    private boolean hZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ia() {
        synchronized (o.class) {
            AR = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = AR;
        }
        return j;
    }
}
