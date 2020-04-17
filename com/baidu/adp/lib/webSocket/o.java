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
    private static long Pq = 0;
    private final Handler OT;
    private final e.a Oh;
    private final l Oq;
    private final Random Po;
    private final a Pp;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Po = new Random();
        this.mLooper = looper;
        this.OT = handler;
        this.Oh = aVar;
        this.Oq = lVar;
        this.Pp = new a(lVar.mT() + 14, 262144);
    }

    public boolean v(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void u(Object obj) {
        Message obtainMessage = this.OT.obtainMessage();
        obtainMessage.obj = obj;
        this.OT.sendMessage(obtainMessage);
    }

    private String ne() {
        byte[] bArr = new byte[16];
        this.Po.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.Pp.write("GET " + str + " HTTP/1.1");
        this.Pp.mA();
        this.Pp.write("Host: " + bVar.mHost);
        this.Pp.mA();
        this.Pp.write("Upgrade: WebSocket");
        this.Pp.mA();
        this.Pp.write("Connection: Upgrade");
        this.Pp.mA();
        this.Pp.write("Sec-WebSocket-Key: " + ne());
        this.Pp.mA();
        if (this.Oq != null && this.Oq.mZ() != null && this.Oq.mZ().length() > 0) {
            this.Pp.write("Sec-WebSocket-Extensions: " + this.Oq.mZ());
            this.Pp.mA();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.Pp.write("Origin: " + bVar.mOrigin);
            this.Pp.mA();
        }
        if (bVar.Oy != null && bVar.Oy.length > 0) {
            this.Pp.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.Oy.length; i++) {
                this.Pp.write(bVar.Oy[i]);
                this.Pp.write(", ");
            }
            this.Pp.mA();
        }
        this.Pp.write("Sec-WebSocket-Version: 13");
        this.Pp.mA();
        if (bVar.Oz != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.Oz) {
                this.Pp.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.Pp.mA();
            }
        }
        this.Pp.mA();
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
        if (jVar.Ox != null && jVar.Ox.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Ox);
    }

    private void a(k.C0023k c0023k) throws IOException, WebSocketException {
        if (c0023k.Ox != null && c0023k.Ox.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0023k.Ox);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.OD.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.Oq.mU()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.Ox.length > this.Oq.mU()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Ox);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.OH.getBytes("UTF-8");
        if (bytes.length > this.Oq.mU()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.Ox.length > this.Oq.mU()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.Ox);
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
        this.Pp.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.Oq.mY()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Pp.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Pp.write((byte) (b2 | 126));
            this.Pp.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Pp.write((byte) (b2 | Byte.MAX_VALUE));
            this.Pp.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Oq.mY()) {
            this.Pp.write(0);
            this.Pp.write(0);
            this.Pp.write(0);
            this.Pp.write(0);
        }
        if (j > 0) {
            if (this.Oq.mY()) {
            }
            this.Pp.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).OD;
                }
                this.Pp.my();
                if (!w(message.obj)) {
                    u(new k.n(cVar));
                    return;
                }
                this.Pp.mx();
                if (cVar != null) {
                    u(new k.r(cVar));
                }
                while (this.Pp.mz() > 0) {
                    if (this.Oh == null) {
                        u(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Oh.write(this.Pp.mw());
                    if (write > 0) {
                        synchronized (o.class) {
                            Pq += write;
                        }
                    }
                }
                if (cVar != null) {
                    u(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            u(new k.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            u(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.Oh.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean w(Object obj) throws IOException, WebSocketException {
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
            t(obj);
        }
        return true;
    }

    protected void t(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void mI() {
        synchronized (o.class) {
            Pq = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Pq;
        }
        return j;
    }
}
