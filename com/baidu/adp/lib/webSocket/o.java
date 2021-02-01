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
    private static long Sq = 0;
    private final Handler RU;
    private final e.a Rk;
    private final l Rs;
    private final Random So;
    private final a Sp;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.So = new Random();
        this.mLooper = looper;
        this.RU = handler;
        this.Rk = aVar;
        this.Rs = lVar;
        this.Sp = new a(lVar.oq() + 14, 262144);
    }

    public boolean w(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void v(Object obj) {
        Message obtainMessage = this.RU.obtainMessage();
        obtainMessage.obj = obj;
        this.RU.sendMessage(obtainMessage);
    }

    private String oC() {
        byte[] bArr = new byte[16];
        this.So.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.Sp.write("GET " + str + " HTTP/1.1");
        this.Sp.nW();
        this.Sp.write("Host: " + bVar.mHost);
        this.Sp.nW();
        this.Sp.write("Upgrade: WebSocket");
        this.Sp.nW();
        this.Sp.write("Connection: Upgrade");
        this.Sp.nW();
        this.Sp.write("Sec-WebSocket-Key: " + oC());
        this.Sp.nW();
        if (this.Rs != null && this.Rs.ox() != null && this.Rs.ox().length() > 0) {
            this.Sp.write("Sec-WebSocket-Extensions: " + this.Rs.ox());
            this.Sp.nW();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.Sp.write("Origin: " + bVar.mOrigin);
            this.Sp.nW();
        }
        if (bVar.RA != null && bVar.RA.length > 0) {
            this.Sp.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.RA.length; i++) {
                this.Sp.write(bVar.RA[i]);
                this.Sp.write(", ");
            }
            this.Sp.nW();
        }
        this.Sp.write("Sec-WebSocket-Version: 13");
        this.Sp.nW();
        if (bVar.RB != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.RB) {
                this.Sp.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.Sp.nW();
            }
        }
        this.Sp.nW();
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
        if (jVar.Rz != null && jVar.Rz.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Rz);
    }

    private void a(k.C0019k c0019k) throws IOException, WebSocketException {
        if (c0019k.Rz != null && c0019k.Rz.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0019k.Rz);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.RF.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.Rs.or()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.Rz.length > this.Rs.or()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Rz);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.RI.getBytes("UTF-8");
        if (bytes.length > this.Rs.or()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.Rz.length > this.Rs.or()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.Rz);
    }

    protected void a(int i, boolean z, byte[] bArr) throws IOException {
        if (bArr != null) {
            a(i, z, bArr, 0, bArr.length);
        } else {
            a(i, z, null, 0, 0);
        }
    }

    protected void a(int i, boolean z, byte[] bArr, int i2, int i3) throws IOException {
        byte b2 = 0;
        if (z) {
            b2 = (byte) (-128);
        }
        this.Sp.write((byte) (b2 | ((byte) i)));
        byte b3 = 0;
        if (this.Rs.ow()) {
            b3 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Sp.write((byte) (b3 | ((byte) j)));
        } else if (j <= 65535) {
            this.Sp.write((byte) (b3 | 126));
            this.Sp.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Sp.write((byte) (b3 | Byte.MAX_VALUE));
            this.Sp.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Rs.ow()) {
            this.Sp.write(0);
            this.Sp.write(0);
            this.Sp.write(0);
            this.Sp.write(0);
        }
        if (j > 0) {
            if (this.Rs.ow()) {
            }
            this.Sp.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).RF;
                }
                this.Sp.nV();
                if (!x(message.obj)) {
                    v(new k.n(cVar));
                    return;
                }
                this.Sp.nU();
                if (cVar != null) {
                    v(new k.r(cVar));
                }
                while (this.Sp.remaining() > 0) {
                    if (this.Rk == null) {
                        v(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Rk.write(this.Sp.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            Sq += write;
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
            this.Rk.close();
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
        } else if (obj instanceof k.C0019k) {
            a((k.C0019k) obj);
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

    public void oe() {
        synchronized (o.class) {
            Sq = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Sq;
        }
        return j;
    }
}
