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
    private static long zy = 0;
    private final Looper mLooper;
    private final e.a yp;
    private final l yx;
    private final Handler zc;
    private final Random zw;
    private final a zx;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.zw = new Random();
        this.mLooper = looper;
        this.zc = handler;
        this.yp = aVar;
        this.yx = lVar;
        this.zx = new a(lVar.hQ() + 14, 262144);
    }

    public boolean t(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void s(Object obj) {
        Message obtainMessage = this.zc.obtainMessage();
        obtainMessage.obj = obj;
        this.zc.sendMessage(obtainMessage);
    }

    private String ib() {
        byte[] bArr = new byte[16];
        this.zw.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.yG != null) {
            str = bVar.mPath + "?" + bVar.yG;
        } else {
            str = bVar.mPath;
        }
        this.zx.write("GET " + str + " HTTP/1.1");
        this.zx.hv();
        this.zx.write("Host: " + bVar.yF);
        this.zx.hv();
        this.zx.write("Upgrade: WebSocket");
        this.zx.hv();
        this.zx.write("Connection: Upgrade");
        this.zx.hv();
        this.zx.write("Sec-WebSocket-Key: " + ib());
        this.zx.hv();
        if (this.yx != null && this.yx.hW() != null && this.yx.hW().length() > 0) {
            this.zx.write("Sec-WebSocket-Extensions: " + this.yx.hW());
            this.zx.hv();
        }
        if (bVar.yH != null && !bVar.yH.equals("")) {
            this.zx.write("Origin: " + bVar.yH);
            this.zx.hv();
        }
        if (bVar.yI != null && bVar.yI.length > 0) {
            this.zx.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.yI.length; i++) {
                this.zx.write(bVar.yI[i]);
                this.zx.write(", ");
            }
            this.zx.hv();
        }
        this.zx.write("Sec-WebSocket-Version: 13");
        this.zx.hv();
        if (bVar.yJ != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.yJ) {
                this.zx.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.zx.hv();
            }
        }
        this.zx.hv();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.yK != null && !cVar.yK.equals("")) {
                byte[] bytes = cVar.yK.getBytes("UTF-8");
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
        if (jVar.yE != null && jVar.yE.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.yE);
    }

    private void a(k.C0010k c0010k) throws IOException, WebSocketException {
        if (c0010k.yE != null && c0010k.yE.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0010k.yE);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] hw = iVar.yO.hw();
        if (hw == null) {
            return false;
        }
        if (hw.length > this.yx.hR()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, hw);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.yE.length > this.yx.hR()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.yE);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.yT.getBytes("UTF-8");
        if (bytes.length > this.yx.hR()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.yE.length > this.yx.hR()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.yE);
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
        this.zx.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.yx.hV()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.zx.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.zx.write((byte) (b2 | 126));
            this.zx.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.zx.write((byte) (b2 | Byte.MAX_VALUE));
            this.zx.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.yx.hV()) {
            this.zx.write(0);
            this.zx.write(0);
            this.zx.write(0);
            this.zx.write(0);
        }
        if (j > 0) {
            if (this.yx.hV()) {
            }
            this.zx.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).yO;
                }
                this.zx.clear();
                if (!u(message.obj)) {
                    s(new k.n(cVar));
                    return;
                }
                this.zx.flip();
                if (cVar != null) {
                    s(new k.r(cVar));
                }
                while (this.zx.remaining() > 0) {
                    if (this.yp == null) {
                        s(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.yp.write(this.zx.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            zy += write;
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
            this.yp.close();
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
            zy = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = zy;
        }
        return j;
    }
}
