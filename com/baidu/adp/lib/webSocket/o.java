package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.k;
import java.io.IOException;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class o extends Handler {
    private static long tR = 0;
    private final Looper mLooper;
    private final e.a sD;
    private final l sL;
    private final Random tP;
    private final a tQ;
    private final Handler ts;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.tP = new Random();
        this.mLooper = looper;
        this.ts = handler;
        this.sD = aVar;
        this.sL = lVar;
        this.tQ = new a(lVar.hG() + 14, 262144);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.ts.obtainMessage();
        obtainMessage.obj = obj;
        this.ts.sendMessage(obtainMessage);
    }

    private String hS() {
        byte[] bArr = new byte[16];
        this.tP.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.tQ.ax("GET " + str + " HTTP/1.1");
        this.tQ.hm();
        this.tQ.ax("Host: " + bVar.sT);
        this.tQ.hm();
        this.tQ.ax("Upgrade: WebSocket");
        this.tQ.hm();
        this.tQ.ax("Connection: Upgrade");
        this.tQ.hm();
        this.tQ.ax("Sec-WebSocket-Key: " + hS());
        this.tQ.hm();
        if (this.sL != null && this.sL.hN() != null && this.sL.hN().length() > 0) {
            this.tQ.ax("Sec-WebSocket-Extensions: " + this.sL.hN());
            this.tQ.hm();
        }
        if (bVar.sU != null && !bVar.sU.equals("")) {
            this.tQ.ax("Origin: " + bVar.sU);
            this.tQ.hm();
        }
        if (bVar.sV != null && bVar.sV.length > 0) {
            this.tQ.ax("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.sV.length; i++) {
                this.tQ.ax(bVar.sV[i]);
                this.tQ.ax(", ");
            }
            this.tQ.hm();
        }
        this.tQ.ax("Sec-WebSocket-Version: 13");
        this.tQ.hm();
        if (bVar.sW != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.sW) {
                this.tQ.ax(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.tQ.hm();
            }
        }
        this.tQ.hm();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.sX != null && !cVar.sX.equals("")) {
                byte[] bytes = cVar.sX.getBytes(HTTP.UTF_8);
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
            bArr[0] = (byte) ((cVar.mCode >> 8) & 255);
            bArr[1] = (byte) (cVar.mCode & 255);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(k.j jVar) throws IOException, WebSocketException {
        if (jVar.sS != null && jVar.sS.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.sS);
    }

    private void a(k.C0019k c0019k) throws IOException, WebSocketException {
        if (c0019k.sS != null && c0019k.sS.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0019k.sS);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.tc.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.sL.hH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.sS.length > this.sL.hH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.sS);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.th.getBytes(HTTP.UTF_8);
        if (bytes.length > this.sL.hH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.sS.length > this.sL.hH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.sS);
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
        this.tQ.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.sL.hM()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.tQ.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.tQ.write((byte) (b2 | 126));
            this.tQ.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.tQ.write((byte) (b2 | Byte.MAX_VALUE));
            this.tQ.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.sL.hM()) {
            this.tQ.write(0);
            this.tQ.write(0);
            this.tQ.write(0);
            this.tQ.write(0);
        }
        if (j > 0) {
            if (this.sL.hM()) {
            }
            this.tQ.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).tc;
                }
                this.tQ.hk();
                if (!v(message.obj)) {
                    t(new k.n(cVar));
                    return;
                }
                this.tQ.hj();
                if (cVar != null) {
                    t(new k.r(cVar));
                }
                while (this.tQ.hl() > 0) {
                    if (this.sD == null) {
                        t(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.sD.write(this.tQ.hi());
                    if (write > 0) {
                        synchronized (o.class) {
                            tR += write;
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
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.sD.close();
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
        } else if (obj instanceof k.C0019k) {
            a((k.C0019k) obj);
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

    public void hv() {
        synchronized (o.class) {
            tR = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = tR;
        }
        return j;
    }
}
