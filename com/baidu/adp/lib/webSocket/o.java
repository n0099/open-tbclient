package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.ar.util.SystemInfoUtil;
import java.io.IOException;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class o extends Handler {
    private static long FE = 0;
    private final l ED;
    private final e.a Ev;
    private final Random FC;
    private final a FD;
    private final Handler Fi;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.FC = new Random();
        this.mLooper = looper;
        this.Fi = handler;
        this.Ev = aVar;
        this.ED = lVar;
        this.FD = new a(lVar.kG() + 14, 262144);
    }

    public boolean w(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void v(Object obj) {
        Message obtainMessage = this.Fi.obtainMessage();
        obtainMessage.obj = obj;
        this.Fi.sendMessage(obtainMessage);
    }

    private String kR() {
        byte[] bArr = new byte[16];
        this.FC.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.wf + "?" + bVar.mQuery;
        } else {
            str = bVar.wf;
        }
        this.FD.write("GET " + str + " HTTP/1.1");
        this.FD.kk();
        this.FD.write("Host: " + bVar.EL);
        this.FD.kk();
        this.FD.write("Upgrade: WebSocket");
        this.FD.kk();
        this.FD.write("Connection: Upgrade");
        this.FD.kk();
        this.FD.write("Sec-WebSocket-Key: " + kR());
        this.FD.kk();
        if (this.ED != null && this.ED.kM() != null && this.ED.kM().length() > 0) {
            this.FD.write("Sec-WebSocket-Extensions: " + this.ED.kM());
            this.FD.kk();
        }
        if (bVar.EM != null && !bVar.EM.equals("")) {
            this.FD.write("Origin: " + bVar.EM);
            this.FD.kk();
        }
        if (bVar.EN != null && bVar.EN.length > 0) {
            this.FD.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.EN.length; i++) {
                this.FD.write(bVar.EN[i]);
                this.FD.write(", ");
            }
            this.FD.kk();
        }
        this.FD.write("Sec-WebSocket-Version: 13");
        this.FD.kk();
        if (bVar.EO != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.EO) {
                this.FD.write(basicNameValuePair.getName() + SystemInfoUtil.COLON + basicNameValuePair.getValue());
                this.FD.kk();
            }
        }
        this.FD.kk();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.EP != null && !cVar.EP.equals("")) {
                byte[] bytes = cVar.EP.getBytes("UTF-8");
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
        if (jVar.EK != null && jVar.EK.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.EK);
    }

    private void a(k.C0018k c0018k) throws IOException, WebSocketException {
        if (c0018k.EK != null && c0018k.EK.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0018k.EK);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] kl = iVar.EU.kl();
        if (kl == null) {
            return false;
        }
        if (kl.length > this.ED.kH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, kl);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.EK.length > this.ED.kH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.EK);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.EZ.getBytes("UTF-8");
        if (bytes.length > this.ED.kH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.EK.length > this.ED.kH()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.EK);
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
        this.FD.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.ED.kL()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.FD.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.FD.write((byte) (b2 | 126));
            this.FD.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.FD.write((byte) (b2 | Byte.MAX_VALUE));
            this.FD.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.ED.kL()) {
            this.FD.write(0);
            this.FD.write(0);
            this.FD.write(0);
            this.FD.write(0);
        }
        if (j > 0) {
            if (this.ED.kL()) {
            }
            this.FD.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).EU;
                }
                this.FD.clear();
                if (!x(message.obj)) {
                    v(new k.n(cVar));
                    return;
                }
                this.FD.flip();
                if (cVar != null) {
                    v(new k.r(cVar));
                }
                while (this.FD.remaining() > 0) {
                    if (this.Ev == null) {
                        v(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Ev.write(this.FD.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            FE += write;
                        }
                    }
                }
                if (cVar != null) {
                    v(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            v(new k.d(e));
        } catch (Exception e2) {
            if (ku()) {
                e2.printStackTrace();
            }
            v(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.Ev.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean x(Object obj) throws IOException, WebSocketException {
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
            u(obj);
        }
        return true;
    }

    protected void u(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean ku() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kv() {
        synchronized (o.class) {
            FE = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = FE;
        }
        return j;
    }
}
