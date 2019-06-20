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
    private static long Gu = 0;
    private final Handler FY;
    private final e.a Fl;
    private final l Ft;
    private final Random Gs;
    private final a Gt;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Gs = new Random();
        this.mLooper = looper;
        this.FY = handler;
        this.Fl = aVar;
        this.Ft = lVar;
        this.Gt = new a(lVar.kS() + 14, 262144);
    }

    public boolean x(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void w(Object obj) {
        Message obtainMessage = this.FY.obtainMessage();
        obtainMessage.obj = obj;
        this.FY.sendMessage(obtainMessage);
    }

    private String ld() {
        byte[] bArr = new byte[16];
        this.Gs.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.wU + "?" + bVar.mQuery;
        } else {
            str = bVar.wU;
        }
        this.Gt.write("GET " + str + " HTTP/1.1");
        this.Gt.kx();
        this.Gt.write("Host: " + bVar.FB);
        this.Gt.kx();
        this.Gt.write("Upgrade: WebSocket");
        this.Gt.kx();
        this.Gt.write("Connection: Upgrade");
        this.Gt.kx();
        this.Gt.write("Sec-WebSocket-Key: " + ld());
        this.Gt.kx();
        if (this.Ft != null && this.Ft.kY() != null && this.Ft.kY().length() > 0) {
            this.Gt.write("Sec-WebSocket-Extensions: " + this.Ft.kY());
            this.Gt.kx();
        }
        if (bVar.FC != null && !bVar.FC.equals("")) {
            this.Gt.write("Origin: " + bVar.FC);
            this.Gt.kx();
        }
        if (bVar.FD != null && bVar.FD.length > 0) {
            this.Gt.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.FD.length; i++) {
                this.Gt.write(bVar.FD[i]);
                this.Gt.write(", ");
            }
            this.Gt.kx();
        }
        this.Gt.write("Sec-WebSocket-Version: 13");
        this.Gt.kx();
        if (bVar.FE != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.FE) {
                this.Gt.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.Gt.kx();
            }
        }
        this.Gt.kx();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.FF != null && !cVar.FF.equals("")) {
                byte[] bytes = cVar.FF.getBytes(HTTP.UTF_8);
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
        if (jVar.FA != null && jVar.FA.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.FA);
    }

    private void a(k.C0019k c0019k) throws IOException, WebSocketException {
        if (c0019k.FA != null && c0019k.FA.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0019k.FA);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] ky = iVar.FJ.ky();
        if (ky == null) {
            return false;
        }
        if (ky.length > this.Ft.kT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, ky);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.FA.length > this.Ft.kT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.FA);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.FO.getBytes(HTTP.UTF_8);
        if (bytes.length > this.Ft.kT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.FA.length > this.Ft.kT()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.FA);
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
        this.Gt.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.Ft.kX()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Gt.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Gt.write((byte) (b2 | 126));
            this.Gt.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Gt.write((byte) (b2 | Byte.MAX_VALUE));
            this.Gt.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Ft.kX()) {
            this.Gt.write(0);
            this.Gt.write(0);
            this.Gt.write(0);
            this.Gt.write(0);
        }
        if (j > 0) {
            if (this.Ft.kX()) {
            }
            this.Gt.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).FJ;
                }
                this.Gt.clear();
                if (!y(message.obj)) {
                    w(new k.n(cVar));
                    return;
                }
                this.Gt.flip();
                if (cVar != null) {
                    w(new k.r(cVar));
                }
                while (this.Gt.remaining() > 0) {
                    if (this.Fl == null) {
                        w(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Fl.write(this.Gt.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            Gu += write;
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
            this.Fl.close();
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
            Gu = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Gu;
        }
        return j;
    }
}
