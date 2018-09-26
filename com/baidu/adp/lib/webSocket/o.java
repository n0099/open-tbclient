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
/* loaded from: classes.dex */
public class o extends Handler {
    private static long Ia = 0;
    private final e.a GP;
    private final l GZ;
    private final Handler HD;
    private final Random HY;
    private final a HZ;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.HY = new Random();
        this.mLooper = looper;
        this.HD = handler;
        this.GP = aVar;
        this.GZ = lVar;
        this.HZ = new a(lVar.lM() + 14, 262144);
    }

    public boolean x(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void w(Object obj) {
        Message obtainMessage = this.HD.obtainMessage();
        obtainMessage.obj = obj;
        this.HD.sendMessage(obtainMessage);
    }

    private String lX() {
        byte[] bArr = new byte[16];
        this.HY.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.yz + "?" + bVar.mQuery;
        } else {
            str = bVar.yz;
        }
        this.HZ.write("GET " + str + " HTTP/1.1");
        this.HZ.lq();
        this.HZ.write("Host: " + bVar.Hh);
        this.HZ.lq();
        this.HZ.write("Upgrade: WebSocket");
        this.HZ.lq();
        this.HZ.write("Connection: Upgrade");
        this.HZ.lq();
        this.HZ.write("Sec-WebSocket-Key: " + lX());
        this.HZ.lq();
        if (this.GZ != null && this.GZ.lS() != null && this.GZ.lS().length() > 0) {
            this.HZ.write("Sec-WebSocket-Extensions: " + this.GZ.lS());
            this.HZ.lq();
        }
        if (bVar.Hi != null && !bVar.Hi.equals("")) {
            this.HZ.write("Origin: " + bVar.Hi);
            this.HZ.lq();
        }
        if (bVar.Hj != null && bVar.Hj.length > 0) {
            this.HZ.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.Hj.length; i++) {
                this.HZ.write(bVar.Hj[i]);
                this.HZ.write(", ");
            }
            this.HZ.lq();
        }
        this.HZ.write("Sec-WebSocket-Version: 13");
        this.HZ.lq();
        if (bVar.Hk != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.Hk) {
                this.HZ.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.HZ.lq();
            }
        }
        this.HZ.lq();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.Hl != null && !cVar.Hl.equals("")) {
                byte[] bytes = cVar.Hl.getBytes("UTF-8");
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
        if (jVar.Hg != null && jVar.Hg.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Hg);
    }

    private void a(k.C0018k c0018k) throws IOException, WebSocketException {
        if (c0018k.Hg != null && c0018k.Hg.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0018k.Hg);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] lr = iVar.Hp.lr();
        if (lr == null) {
            return false;
        }
        if (lr.length > this.GZ.lN()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, lr);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.Hg.length > this.GZ.lN()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Hg);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Hu.getBytes("UTF-8");
        if (bytes.length > this.GZ.lN()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.Hg.length > this.GZ.lN()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.Hg);
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
        this.HZ.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.GZ.lR()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.HZ.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.HZ.write((byte) (b2 | 126));
            this.HZ.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.HZ.write((byte) (b2 | Byte.MAX_VALUE));
            this.HZ.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.GZ.lR()) {
            this.HZ.write(0);
            this.HZ.write(0);
            this.HZ.write(0);
            this.HZ.write(0);
        }
        if (j > 0) {
            if (this.GZ.lR()) {
            }
            this.HZ.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).Hp;
                }
                this.HZ.clear();
                if (!y(message.obj)) {
                    w(new k.n(cVar));
                    return;
                }
                this.HZ.flip();
                if (cVar != null) {
                    w(new k.r(cVar));
                }
                while (this.HZ.remaining() > 0) {
                    if (this.GP == null) {
                        w(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.GP.write(this.HZ.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            Ia += write;
                        }
                    }
                }
                if (cVar != null) {
                    w(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            w(new k.d(e));
        } catch (Exception e2) {
            if (lA()) {
                e2.printStackTrace();
            }
            w(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.GP.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean y(Object obj) throws IOException, WebSocketException {
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
        } else if (obj instanceof k.C0018k) {
            a((k.C0018k) obj);
        } else if (obj instanceof k.c) {
            a((k.c) obj);
        } else if (obj instanceof k.b) {
            a((k.b) obj);
        } else {
            v(obj);
        }
        return true;
    }

    protected void v(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean lA() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void lB() {
        synchronized (o.class) {
            Ia = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Ia;
        }
        return j;
    }
}
