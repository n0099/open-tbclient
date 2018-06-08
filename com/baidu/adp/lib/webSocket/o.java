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
    private static long FF = 0;
    private final l EE;
    private final e.a Ew;
    private final Random FD;
    private final a FE;
    private final Handler Fj;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.FD = new Random();
        this.mLooper = looper;
        this.Fj = handler;
        this.Ew = aVar;
        this.EE = lVar;
        this.FE = new a(lVar.kE() + 14, 262144);
    }

    public boolean w(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void v(Object obj) {
        Message obtainMessage = this.Fj.obtainMessage();
        obtainMessage.obj = obj;
        this.Fj.sendMessage(obtainMessage);
    }

    private String kP() {
        byte[] bArr = new byte[16];
        this.FD.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.FE.write("GET " + str + " HTTP/1.1");
        this.FE.kj();
        this.FE.write("Host: " + bVar.EM);
        this.FE.kj();
        this.FE.write("Upgrade: WebSocket");
        this.FE.kj();
        this.FE.write("Connection: Upgrade");
        this.FE.kj();
        this.FE.write("Sec-WebSocket-Key: " + kP());
        this.FE.kj();
        if (this.EE != null && this.EE.kK() != null && this.EE.kK().length() > 0) {
            this.FE.write("Sec-WebSocket-Extensions: " + this.EE.kK());
            this.FE.kj();
        }
        if (bVar.EN != null && !bVar.EN.equals("")) {
            this.FE.write("Origin: " + bVar.EN);
            this.FE.kj();
        }
        if (bVar.EO != null && bVar.EO.length > 0) {
            this.FE.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.EO.length; i++) {
                this.FE.write(bVar.EO[i]);
                this.FE.write(", ");
            }
            this.FE.kj();
        }
        this.FE.write("Sec-WebSocket-Version: 13");
        this.FE.kj();
        if (bVar.EP != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.EP) {
                this.FE.write(basicNameValuePair.getName() + SystemInfoUtil.COLON + basicNameValuePair.getValue());
                this.FE.kj();
            }
        }
        this.FE.kj();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.ER != null && !cVar.ER.equals("")) {
                byte[] bytes = cVar.ER.getBytes("UTF-8");
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
        if (jVar.EL != null && jVar.EL.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.EL);
    }

    private void a(k.C0018k c0018k) throws IOException, WebSocketException {
        if (c0018k.EL != null && c0018k.EL.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0018k.EL);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] kk = iVar.EV.kk();
        if (kk == null) {
            return false;
        }
        if (kk.length > this.EE.kF()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, kk);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.EL.length > this.EE.kF()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.EL);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Fa.getBytes("UTF-8");
        if (bytes.length > this.EE.kF()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.EL.length > this.EE.kF()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.EL);
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
        this.FE.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.EE.kJ()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.FE.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.FE.write((byte) (b2 | 126));
            this.FE.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.FE.write((byte) (b2 | Byte.MAX_VALUE));
            this.FE.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.EE.kJ()) {
            this.FE.write(0);
            this.FE.write(0);
            this.FE.write(0);
            this.FE.write(0);
        }
        if (j > 0) {
            if (this.EE.kJ()) {
            }
            this.FE.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).EV;
                }
                this.FE.clear();
                if (!x(message.obj)) {
                    v(new k.n(cVar));
                    return;
                }
                this.FE.flip();
                if (cVar != null) {
                    v(new k.r(cVar));
                }
                while (this.FE.remaining() > 0) {
                    if (this.Ew == null) {
                        v(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Ew.write(this.FE.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            FF += write;
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
            if (isDebug()) {
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
            this.Ew.close();
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

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void kt() {
        synchronized (o.class) {
            FF = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = FF;
        }
        return j;
    }
}
