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
    private static long Gv = 0;
    private final Handler FZ;
    private final e.a Fm;
    private final l Fu;
    private final Random Gt;
    private final a Gu;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Gt = new Random();
        this.mLooper = looper;
        this.FZ = handler;
        this.Fm = aVar;
        this.Fu = lVar;
        this.Gu = new a(lVar.kS() + 14, 262144);
    }

    public boolean x(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void w(Object obj) {
        Message obtainMessage = this.FZ.obtainMessage();
        obtainMessage.obj = obj;
        this.FZ.sendMessage(obtainMessage);
    }

    private String ld() {
        byte[] bArr = new byte[16];
        this.Gt.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.wV + "?" + bVar.mQuery;
        } else {
            str = bVar.wV;
        }
        this.Gu.write("GET " + str + " HTTP/1.1");
        this.Gu.kx();
        this.Gu.write("Host: " + bVar.FC);
        this.Gu.kx();
        this.Gu.write("Upgrade: WebSocket");
        this.Gu.kx();
        this.Gu.write("Connection: Upgrade");
        this.Gu.kx();
        this.Gu.write("Sec-WebSocket-Key: " + ld());
        this.Gu.kx();
        if (this.Fu != null && this.Fu.kY() != null && this.Fu.kY().length() > 0) {
            this.Gu.write("Sec-WebSocket-Extensions: " + this.Fu.kY());
            this.Gu.kx();
        }
        if (bVar.FD != null && !bVar.FD.equals("")) {
            this.Gu.write("Origin: " + bVar.FD);
            this.Gu.kx();
        }
        if (bVar.FE != null && bVar.FE.length > 0) {
            this.Gu.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.FE.length; i++) {
                this.Gu.write(bVar.FE[i]);
                this.Gu.write(", ");
            }
            this.Gu.kx();
        }
        this.Gu.write("Sec-WebSocket-Version: 13");
        this.Gu.kx();
        if (bVar.FF != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.FF) {
                this.Gu.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.Gu.kx();
            }
        }
        this.Gu.kx();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.FG != null && !cVar.FG.equals("")) {
                byte[] bytes = cVar.FG.getBytes(HTTP.UTF_8);
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
        if (jVar.FB != null && jVar.FB.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.FB);
    }

    private void a(k.C0019k c0019k) throws IOException, WebSocketException {
        if (c0019k.FB != null && c0019k.FB.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0019k.FB);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] ky = iVar.FK.ky();
        if (ky == null) {
            return false;
        }
        if (ky.length > this.Fu.kT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, ky);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.FB.length > this.Fu.kT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.FB);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.FP.getBytes(HTTP.UTF_8);
        if (bytes.length > this.Fu.kT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.FB.length > this.Fu.kT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.FB);
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
        this.Gu.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.Fu.kX()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Gu.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Gu.write((byte) (b2 | 126));
            this.Gu.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Gu.write((byte) (b2 | Byte.MAX_VALUE));
            this.Gu.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Fu.kX()) {
            this.Gu.write(0);
            this.Gu.write(0);
            this.Gu.write(0);
            this.Gu.write(0);
        }
        if (j > 0) {
            if (this.Fu.kX()) {
            }
            this.Gu.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).FK;
                }
                this.Gu.clear();
                if (!y(message.obj)) {
                    w(new k.n(cVar));
                    return;
                }
                this.Gu.flip();
                if (cVar != null) {
                    w(new k.r(cVar));
                }
                while (this.Gu.remaining() > 0) {
                    if (this.Fm == null) {
                        w(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Fm.write(this.Gu.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            Gv += write;
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
            if (isDebug()) {
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
            this.Fm.close();
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
        } else if (obj instanceof k.C0019k) {
            a((k.C0019k) obj);
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

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kH() {
        synchronized (o.class) {
            Gv = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Gv;
        }
        return j;
    }
}
