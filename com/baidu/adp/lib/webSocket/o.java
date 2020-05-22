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
    private static long PD = 0;
    private final l OB;
    private final e.a Ot;
    private final Handler Pe;
    private final Random Py;
    private final a Pz;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Py = new Random();
        this.mLooper = looper;
        this.Pe = handler;
        this.Ot = aVar;
        this.OB = lVar;
        this.Pz = new a(lVar.mV() + 14, 262144);
    }

    public boolean y(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void x(Object obj) {
        Message obtainMessage = this.Pe.obtainMessage();
        obtainMessage.obj = obj;
        this.Pe.sendMessage(obtainMessage);
    }

    private String ng() {
        byte[] bArr = new byte[16];
        this.Py.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.Pz.write("GET " + str + " HTTP/1.1");
        this.Pz.mC();
        this.Pz.write("Host: " + bVar.mHost);
        this.Pz.mC();
        this.Pz.write("Upgrade: WebSocket");
        this.Pz.mC();
        this.Pz.write("Connection: Upgrade");
        this.Pz.mC();
        this.Pz.write("Sec-WebSocket-Key: " + ng());
        this.Pz.mC();
        if (this.OB != null && this.OB.nb() != null && this.OB.nb().length() > 0) {
            this.Pz.write("Sec-WebSocket-Extensions: " + this.OB.nb());
            this.Pz.mC();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.Pz.write("Origin: " + bVar.mOrigin);
            this.Pz.mC();
        }
        if (bVar.OJ != null && bVar.OJ.length > 0) {
            this.Pz.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.OJ.length; i++) {
                this.Pz.write(bVar.OJ[i]);
                this.Pz.write(", ");
            }
            this.Pz.mC();
        }
        this.Pz.write("Sec-WebSocket-Version: 13");
        this.Pz.mC();
        if (bVar.OL != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.OL) {
                this.Pz.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.Pz.mC();
            }
        }
        this.Pz.mC();
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
        if (jVar.OI != null && jVar.OI.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.OI);
    }

    private void a(k.C0025k c0025k) throws IOException, WebSocketException {
        if (c0025k.OI != null && c0025k.OI.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0025k.OI);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.OQ.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.OB.mW()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.OI.length > this.OB.mW()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.OI);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.OV.getBytes("UTF-8");
        if (bytes.length > this.OB.mW()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.OI.length > this.OB.mW()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.OI);
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
        this.Pz.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.OB.na()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Pz.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Pz.write((byte) (b2 | 126));
            this.Pz.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Pz.write((byte) (b2 | Byte.MAX_VALUE));
            this.Pz.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.OB.na()) {
            this.Pz.write(0);
            this.Pz.write(0);
            this.Pz.write(0);
            this.Pz.write(0);
        }
        if (j > 0) {
            if (this.OB.na()) {
            }
            this.Pz.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).OQ;
                }
                this.Pz.mA();
                if (!z(message.obj)) {
                    x(new k.n(cVar));
                    return;
                }
                this.Pz.mz();
                if (cVar != null) {
                    x(new k.r(cVar));
                }
                while (this.Pz.mB() > 0) {
                    if (this.Ot == null) {
                        x(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Ot.write(this.Pz.my());
                    if (write > 0) {
                        synchronized (o.class) {
                            PD += write;
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
            this.Ot.close();
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

    public void mK() {
        synchronized (o.class) {
            PD = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = PD;
        }
        return j;
    }
}
