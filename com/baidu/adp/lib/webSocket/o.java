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
    private static long tp = 0;
    private final Looper mLooper;
    private final e.a rZ;
    private final Handler sQ;
    private final l sj;
    private final Random tl;
    private final a tm;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.tl = new Random();
        this.mLooper = looper;
        this.sQ = handler;
        this.rZ = aVar;
        this.sj = lVar;
        this.tm = new a(lVar.hG() + 14, 262144);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.sQ.obtainMessage();
        obtainMessage.obj = obj;
        this.sQ.sendMessage(obtainMessage);
    }

    private String hS() {
        byte[] bArr = new byte[16];
        this.tl.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.tm.ax("GET " + str + " HTTP/1.1");
        this.tm.hm();
        this.tm.ax("Host: " + bVar.su);
        this.tm.hm();
        this.tm.ax("Upgrade: WebSocket");
        this.tm.hm();
        this.tm.ax("Connection: Upgrade");
        this.tm.hm();
        this.tm.ax("Sec-WebSocket-Key: " + hS());
        this.tm.hm();
        if (this.sj != null && this.sj.hN() != null && this.sj.hN().length() > 0) {
            this.tm.ax("Sec-WebSocket-Extensions: " + this.sj.hN());
            this.tm.hm();
        }
        if (bVar.sv != null && !bVar.sv.equals("")) {
            this.tm.ax("Origin: " + bVar.sv);
            this.tm.hm();
        }
        if (bVar.sw != null && bVar.sw.length > 0) {
            this.tm.ax("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.sw.length; i++) {
                this.tm.ax(bVar.sw[i]);
                this.tm.ax(", ");
            }
            this.tm.hm();
        }
        this.tm.ax("Sec-WebSocket-Version: 13");
        this.tm.hm();
        if (bVar.sx != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.sx) {
                this.tm.ax(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.tm.hm();
            }
        }
        this.tm.hm();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.sy != null && !cVar.sy.equals("")) {
                byte[] bytes = cVar.sy.getBytes(HTTP.UTF_8);
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
        if (jVar.ss != null && jVar.ss.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.ss);
    }

    private void a(k.C0019k c0019k) throws IOException, WebSocketException {
        if (c0019k.ss != null && c0019k.ss.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0019k.ss);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.sC.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.sj.hH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.ss.length > this.sj.hH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.ss);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.sH.getBytes(HTTP.UTF_8);
        if (bytes.length > this.sj.hH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.ss.length > this.sj.hH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.ss);
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
        this.tm.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.sj.hM()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.tm.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.tm.write((byte) (b2 | 126));
            this.tm.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.tm.write((byte) (b2 | Byte.MAX_VALUE));
            this.tm.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.sj.hM()) {
            this.tm.write(0);
            this.tm.write(0);
            this.tm.write(0);
            this.tm.write(0);
        }
        if (j > 0) {
            if (this.sj.hM()) {
            }
            this.tm.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).sC;
                }
                this.tm.hk();
                if (!v(message.obj)) {
                    t(new k.n(cVar));
                    return;
                }
                this.tm.hj();
                if (cVar != null) {
                    t(new k.r(cVar));
                }
                while (this.tm.hl() > 0) {
                    if (this.rZ == null) {
                        t(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.rZ.write(this.tm.hi());
                    if (write > 0) {
                        synchronized (o.class) {
                            tp += write;
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
            this.rZ.close();
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
            tp = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = tp;
        }
        return j;
    }
}
