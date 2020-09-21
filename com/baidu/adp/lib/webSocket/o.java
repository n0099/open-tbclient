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
    private static long Rf = 0;
    private final e.a PZ;
    private final Handler QI;
    private final l Qh;
    private final Random Rd;
    private final a Re;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Rd = new Random();
        this.mLooper = looper;
        this.QI = handler;
        this.PZ = aVar;
        this.Qh = lVar;
        this.Re = new a(lVar.oR() + 14, 262144);
    }

    public boolean A(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void z(Object obj) {
        Message obtainMessage = this.QI.obtainMessage();
        obtainMessage.obj = obj;
        this.QI.sendMessage(obtainMessage);
    }

    private String pc() {
        byte[] bArr = new byte[16];
        this.Rd.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.Re.write("GET " + str + " HTTP/1.1");
        this.Re.oy();
        this.Re.write("Host: " + bVar.mHost);
        this.Re.oy();
        this.Re.write("Upgrade: WebSocket");
        this.Re.oy();
        this.Re.write("Connection: Upgrade");
        this.Re.oy();
        this.Re.write("Sec-WebSocket-Key: " + pc());
        this.Re.oy();
        if (this.Qh != null && this.Qh.oX() != null && this.Qh.oX().length() > 0) {
            this.Re.write("Sec-WebSocket-Extensions: " + this.Qh.oX());
            this.Re.oy();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.Re.write("Origin: " + bVar.mOrigin);
            this.Re.oy();
        }
        if (bVar.Qp != null && bVar.Qp.length > 0) {
            this.Re.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.Qp.length; i++) {
                this.Re.write(bVar.Qp[i]);
                this.Re.write(", ");
            }
            this.Re.oy();
        }
        this.Re.write("Sec-WebSocket-Version: 13");
        this.Re.oy();
        if (bVar.Qq != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.Qq) {
                this.Re.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.Re.oy();
            }
        }
        this.Re.oy();
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
        if (jVar.Qo != null && jVar.Qo.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Qo);
    }

    private void a(k.C0023k c0023k) throws IOException, WebSocketException {
        if (c0023k.Qo != null && c0023k.Qo.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0023k.Qo);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.Qu.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.Qh.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.Qo.length > this.Qh.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Qo);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Qy.getBytes("UTF-8");
        if (bytes.length > this.Qh.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.Qo.length > this.Qh.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.Qo);
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
        this.Re.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.Qh.oW()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Re.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Re.write((byte) (b2 | 126));
            this.Re.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Re.write((byte) (b2 | Byte.MAX_VALUE));
            this.Re.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Qh.oW()) {
            this.Re.write(0);
            this.Re.write(0);
            this.Re.write(0);
            this.Re.write(0);
        }
        if (j > 0) {
            if (this.Qh.oW()) {
            }
            this.Re.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).Qu;
                }
                this.Re.ow();
                if (!B(message.obj)) {
                    z(new k.n(cVar));
                    return;
                }
                this.Re.ov();
                if (cVar != null) {
                    z(new k.r(cVar));
                }
                while (this.Re.ox() > 0) {
                    if (this.PZ == null) {
                        z(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.PZ.write(this.Re.ou());
                    if (write > 0) {
                        synchronized (o.class) {
                            Rf += write;
                        }
                    }
                }
                if (cVar != null) {
                    z(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            z(new k.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            z(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.PZ.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean B(Object obj) throws IOException, WebSocketException {
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
            y(obj);
        }
        return true;
    }

    protected void y(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oG() {
        synchronized (o.class) {
            Rf = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Rf;
        }
        return j;
    }
}
