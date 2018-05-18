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
    private static long zx = 0;
    private final Looper mLooper;
    private final e.a yo;
    private final l yw;
    private final Handler zb;
    private final Random zv;
    private final a zw;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.zv = new Random();
        this.mLooper = looper;
        this.zb = handler;
        this.yo = aVar;
        this.yw = lVar;
        this.zw = new a(lVar.hQ() + 14, 262144);
    }

    public boolean t(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void s(Object obj) {
        Message obtainMessage = this.zb.obtainMessage();
        obtainMessage.obj = obj;
        this.zb.sendMessage(obtainMessage);
    }

    private String ib() {
        byte[] bArr = new byte[16];
        this.zv.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.yF != null) {
            str = bVar.mPath + "?" + bVar.yF;
        } else {
            str = bVar.mPath;
        }
        this.zw.write("GET " + str + " HTTP/1.1");
        this.zw.hv();
        this.zw.write("Host: " + bVar.yE);
        this.zw.hv();
        this.zw.write("Upgrade: WebSocket");
        this.zw.hv();
        this.zw.write("Connection: Upgrade");
        this.zw.hv();
        this.zw.write("Sec-WebSocket-Key: " + ib());
        this.zw.hv();
        if (this.yw != null && this.yw.hW() != null && this.yw.hW().length() > 0) {
            this.zw.write("Sec-WebSocket-Extensions: " + this.yw.hW());
            this.zw.hv();
        }
        if (bVar.yG != null && !bVar.yG.equals("")) {
            this.zw.write("Origin: " + bVar.yG);
            this.zw.hv();
        }
        if (bVar.yH != null && bVar.yH.length > 0) {
            this.zw.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.yH.length; i++) {
                this.zw.write(bVar.yH[i]);
                this.zw.write(", ");
            }
            this.zw.hv();
        }
        this.zw.write("Sec-WebSocket-Version: 13");
        this.zw.hv();
        if (bVar.yI != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.yI) {
                this.zw.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.zw.hv();
            }
        }
        this.zw.hv();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.yJ != null && !cVar.yJ.equals("")) {
                byte[] bytes = cVar.yJ.getBytes("UTF-8");
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
        if (jVar.yD != null && jVar.yD.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.yD);
    }

    private void a(k.C0010k c0010k) throws IOException, WebSocketException {
        if (c0010k.yD != null && c0010k.yD.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0010k.yD);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] hw = iVar.yN.hw();
        if (hw == null) {
            return false;
        }
        if (hw.length > this.yw.hR()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, hw);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.yD.length > this.yw.hR()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.yD);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.yS.getBytes("UTF-8");
        if (bytes.length > this.yw.hR()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.yD.length > this.yw.hR()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.yD);
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
        this.zw.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.yw.hV()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.zw.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.zw.write((byte) (b2 | 126));
            this.zw.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.zw.write((byte) (b2 | Byte.MAX_VALUE));
            this.zw.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.yw.hV()) {
            this.zw.write(0);
            this.zw.write(0);
            this.zw.write(0);
            this.zw.write(0);
        }
        if (j > 0) {
            if (this.yw.hV()) {
            }
            this.zw.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).yN;
                }
                this.zw.clear();
                if (!u(message.obj)) {
                    s(new k.n(cVar));
                    return;
                }
                this.zw.flip();
                if (cVar != null) {
                    s(new k.r(cVar));
                }
                while (this.zw.remaining() > 0) {
                    if (this.yo == null) {
                        s(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.yo.write(this.zw.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            zx += write;
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
            if (isDebug()) {
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
            this.yo.close();
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
        } else if (obj instanceof k.C0010k) {
            a((k.C0010k) obj);
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

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void hF() {
        synchronized (o.class) {
            zx = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = zx;
        }
        return j;
    }
}
