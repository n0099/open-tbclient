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
    private static long TO = 0;
    private final e.a SG;
    private final l SR;
    private final Random TL;
    private final a TM;
    private final Handler Tq;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.TL = new Random();
        this.mLooper = looper;
        this.Tq = handler;
        this.SG = aVar;
        this.SR = lVar;
        this.TM = new a(lVar.oq() + 14, 262144);
    }

    public boolean y(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void x(Object obj) {
        Message obtainMessage = this.Tq.obtainMessage();
        obtainMessage.obj = obj;
        this.Tq.sendMessage(obtainMessage);
    }

    private String oC() {
        byte[] bArr = new byte[16];
        this.TL.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.TM.write("GET " + str + " HTTP/1.1");
        this.TM.nW();
        this.TM.write("Host: " + bVar.mHost);
        this.TM.nW();
        this.TM.write("Upgrade: WebSocket");
        this.TM.nW();
        this.TM.write("Connection: Upgrade");
        this.TM.nW();
        this.TM.write("Sec-WebSocket-Key: " + oC());
        this.TM.nW();
        if (this.SR != null && this.SR.ox() != null && this.SR.ox().length() > 0) {
            this.TM.write("Sec-WebSocket-Extensions: " + this.SR.ox());
            this.TM.nW();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.TM.write("Origin: " + bVar.mOrigin);
            this.TM.nW();
        }
        if (bVar.SZ != null && bVar.SZ.length > 0) {
            this.TM.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.SZ.length; i++) {
                this.TM.write(bVar.SZ[i]);
                this.TM.write(", ");
            }
            this.TM.nW();
        }
        this.TM.write("Sec-WebSocket-Version: 13");
        this.TM.nW();
        if (bVar.Ta != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.Ta) {
                this.TM.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.TM.nW();
            }
        }
        this.TM.nW();
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
        if (jVar.SY != null && jVar.SY.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.SY);
    }

    private void a(k.C0025k c0025k) throws IOException, WebSocketException {
        if (c0025k.SY != null && c0025k.SY.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0025k.SY);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.Te.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.SR.or()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.SY.length > this.SR.or()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.SY);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Th.getBytes("UTF-8");
        if (bytes.length > this.SR.or()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.SY.length > this.SR.or()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.SY);
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
        this.TM.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.SR.ow()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.TM.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.TM.write((byte) (b2 | 126));
            this.TM.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.TM.write((byte) (b2 | Byte.MAX_VALUE));
            this.TM.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.SR.ow()) {
            this.TM.write(0);
            this.TM.write(0);
            this.TM.write(0);
            this.TM.write(0);
        }
        if (j > 0) {
            if (this.SR.ow()) {
            }
            this.TM.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).Te;
                }
                this.TM.nV();
                if (!z(message.obj)) {
                    x(new k.n(cVar));
                    return;
                }
                this.TM.nU();
                if (cVar != null) {
                    x(new k.r(cVar));
                }
                while (this.TM.remaining() > 0) {
                    if (this.SG == null) {
                        x(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.SG.write(this.TM.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            TO += write;
                        }
                    }
                }
                if (cVar != null) {
                    x(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            x(new k.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            x(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.SG.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean z(Object obj) throws IOException, WebSocketException {
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
        } else if (obj instanceof k.C0025k) {
            a((k.C0025k) obj);
        } else if (obj instanceof k.c) {
            a((k.c) obj);
        } else if (obj instanceof k.b) {
            a((k.b) obj);
        } else {
            w(obj);
        }
        return true;
    }

    protected void w(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oe() {
        synchronized (o.class) {
            TO = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = TO;
        }
        return j;
    }
}
