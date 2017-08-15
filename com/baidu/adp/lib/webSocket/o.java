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
    private static long CW = 0;
    private final e.a BM;
    private final l BU;
    private final Random CT;
    private final Looper CU;
    private final a CV;
    private final Handler Cz;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.CT = new Random();
        this.CU = looper;
        this.Cz = handler;
        this.BM = aVar;
        this.BU = lVar;
        this.CV = new a(lVar.iu() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.Cz.obtainMessage();
        obtainMessage.obj = obj;
        this.Cz.sendMessage(obtainMessage);
    }

    private String iF() {
        byte[] bArr = new byte[16];
        this.CT.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.Cd != null) {
            str = bVar.mPath + "?" + bVar.Cd;
        } else {
            str = bVar.mPath;
        }
        this.CV.write("GET " + str + " HTTP/1.1");
        this.CV.hY();
        this.CV.write("Host: " + bVar.Cc);
        this.CV.hY();
        this.CV.write("Upgrade: WebSocket");
        this.CV.hY();
        this.CV.write("Connection: Upgrade");
        this.CV.hY();
        this.CV.write("Sec-WebSocket-Key: " + iF());
        this.CV.hY();
        if (this.BU != null && this.BU.iA() != null && this.BU.iA().length() > 0) {
            this.CV.write("Sec-WebSocket-Extensions: " + this.BU.iA());
            this.CV.hY();
        }
        if (bVar.Ce != null && !bVar.Ce.equals("")) {
            this.CV.write("Origin: " + bVar.Ce);
            this.CV.hY();
        }
        if (bVar.Cf != null && bVar.Cf.length > 0) {
            this.CV.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.Cf.length; i++) {
                this.CV.write(bVar.Cf[i]);
                this.CV.write(", ");
            }
            this.CV.hY();
        }
        this.CV.write("Sec-WebSocket-Version: 13");
        this.CV.hY();
        if (bVar.Cg != null) {
            for (NameValuePair nameValuePair : bVar.Cg) {
                this.CV.write(nameValuePair.getName() + ":" + nameValuePair.getValue());
                this.CV.hY();
            }
        }
        this.CV.hY();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.Ch != null && !cVar.Ch.equals("")) {
                byte[] bytes = cVar.Ch.getBytes("UTF-8");
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
        if (jVar.Cb != null && jVar.Cb.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Cb);
    }

    private void a(k.C0008k c0008k) throws IOException, WebSocketException {
        if (c0008k.Cb != null && c0008k.Cb.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0008k.Cb);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] hZ = iVar.Cl.hZ();
        if (hZ == null) {
            return false;
        }
        if (hZ.length > this.BU.iv()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, hZ);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.Cb.length > this.BU.iv()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Cb);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Cq.getBytes("UTF-8");
        if (bytes.length > this.BU.iv()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.Cb.length > this.BU.iv()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.Cb);
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
        this.CV.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.BU.iz()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.CV.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.CV.write((byte) (b2 | 126));
            this.CV.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.CV.write((byte) (b2 | Byte.MAX_VALUE));
            this.CV.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.BU.iz()) {
            this.CV.write(0);
            this.CV.write(0);
            this.CV.write(0);
            this.CV.write(0);
        }
        if (j > 0) {
            if (this.BU.iz()) {
            }
            this.CV.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).Cl;
                }
                this.CV.clear();
                if (!v(message.obj)) {
                    t(new k.n(cVar));
                    return;
                }
                this.CV.flip();
                if (cVar != null) {
                    t(new k.r(cVar));
                }
                while (this.CV.remaining() > 0) {
                    if (this.BM == null) {
                        t(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.BM.write(this.CV.hX());
                    if (write > 0) {
                        synchronized (o.class) {
                            CW += write;
                        }
                    }
                }
                if (cVar != null) {
                    t(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            t(new k.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            t(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.CU.quit();
        } catch (Exception e) {
        }
        try {
            this.BM.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean v(Object obj) throws IOException, WebSocketException {
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

    public void ij() {
        synchronized (o.class) {
            CW = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = CW;
        }
        return j;
    }
}
