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
    private static long Pu = 0;
    private final Handler OX;
    private final e.a Ol;
    private final l Ou;
    private final Random Ps;
    private final a Pt;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Ps = new Random();
        this.mLooper = looper;
        this.OX = handler;
        this.Ol = aVar;
        this.Ou = lVar;
        this.Pt = new a(lVar.mT() + 14, 262144);
    }

    public boolean w(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void v(Object obj) {
        Message obtainMessage = this.OX.obtainMessage();
        obtainMessage.obj = obj;
        this.OX.sendMessage(obtainMessage);
    }

    private String ne() {
        byte[] bArr = new byte[16];
        this.Ps.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.Pt.write("GET " + str + " HTTP/1.1");
        this.Pt.mA();
        this.Pt.write("Host: " + bVar.mHost);
        this.Pt.mA();
        this.Pt.write("Upgrade: WebSocket");
        this.Pt.mA();
        this.Pt.write("Connection: Upgrade");
        this.Pt.mA();
        this.Pt.write("Sec-WebSocket-Key: " + ne());
        this.Pt.mA();
        if (this.Ou != null && this.Ou.mZ() != null && this.Ou.mZ().length() > 0) {
            this.Pt.write("Sec-WebSocket-Extensions: " + this.Ou.mZ());
            this.Pt.mA();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.Pt.write("Origin: " + bVar.mOrigin);
            this.Pt.mA();
        }
        if (bVar.OC != null && bVar.OC.length > 0) {
            this.Pt.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.OC.length; i++) {
                this.Pt.write(bVar.OC[i]);
                this.Pt.write(", ");
            }
            this.Pt.mA();
        }
        this.Pt.write("Sec-WebSocket-Version: 13");
        this.Pt.mA();
        if (bVar.OD != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.OD) {
                this.Pt.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.Pt.mA();
            }
        }
        this.Pt.mA();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.mReason != null && !cVar.mReason.equals("")) {
                byte[] bytes = cVar.mReason.getBytes("UTF-8");
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
        if (jVar.OB != null && jVar.OB.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.OB);
    }

    private void a(k.C0023k c0023k) throws IOException, WebSocketException {
        if (c0023k.OB != null && c0023k.OB.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0023k.OB);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.OH.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.Ou.mU()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.OB.length > this.Ou.mU()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.OB);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.OM.getBytes("UTF-8");
        if (bytes.length > this.Ou.mU()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.OB.length > this.Ou.mU()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.OB);
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
        this.Pt.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.Ou.mY()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Pt.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Pt.write((byte) (b2 | 126));
            this.Pt.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Pt.write((byte) (b2 | Byte.MAX_VALUE));
            this.Pt.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Ou.mY()) {
            this.Pt.write(0);
            this.Pt.write(0);
            this.Pt.write(0);
            this.Pt.write(0);
        }
        if (j > 0) {
            if (this.Ou.mY()) {
            }
            this.Pt.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).OH;
                }
                this.Pt.my();
                if (!x(message.obj)) {
                    v(new k.n(cVar));
                    return;
                }
                this.Pt.mx();
                if (cVar != null) {
                    v(new k.r(cVar));
                }
                while (this.Pt.mz() > 0) {
                    if (this.Ol == null) {
                        v(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Ol.write(this.Pt.mw());
                    if (write > 0) {
                        synchronized (o.class) {
                            Pu += write;
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
            this.Ol.close();
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
        } else if (obj instanceof k.C0023k) {
            a((k.C0023k) obj);
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

    public void mI() {
        synchronized (o.class) {
            Pu = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Pu;
        }
        return j;
    }
}
