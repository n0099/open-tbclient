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
    private static long GB = 0;
    private final l FA;
    private final e.a Fs;
    private final a GA;
    private final Handler Gf;
    private final Random Gz;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Gz = new Random();
        this.mLooper = looper;
        this.Gf = handler;
        this.Fs = aVar;
        this.FA = lVar;
        this.GA = new a(lVar.lh() + 14, 262144);
    }

    public boolean x(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void w(Object obj) {
        Message obtainMessage = this.Gf.obtainMessage();
        obtainMessage.obj = obj;
        this.Gf.sendMessage(obtainMessage);
    }

    private String lt() {
        byte[] bArr = new byte[16];
        this.Gz.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.wX + "?" + bVar.mQuery;
        } else {
            str = bVar.wX;
        }
        this.GA.bq("GET " + str + " HTTP/1.1");
        this.GA.kM();
        this.GA.bq("Host: " + bVar.FI);
        this.GA.kM();
        this.GA.bq("Upgrade: WebSocket");
        this.GA.kM();
        this.GA.bq("Connection: Upgrade");
        this.GA.kM();
        this.GA.bq("Sec-WebSocket-Key: " + lt());
        this.GA.kM();
        if (this.FA != null && this.FA.lo() != null && this.FA.lo().length() > 0) {
            this.GA.bq("Sec-WebSocket-Extensions: " + this.FA.lo());
            this.GA.kM();
        }
        if (bVar.FJ != null && !bVar.FJ.equals("")) {
            this.GA.bq("Origin: " + bVar.FJ);
            this.GA.kM();
        }
        if (bVar.FK != null && bVar.FK.length > 0) {
            this.GA.bq("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.FK.length; i++) {
                this.GA.bq(bVar.FK[i]);
                this.GA.bq(", ");
            }
            this.GA.kM();
        }
        this.GA.bq("Sec-WebSocket-Version: 13");
        this.GA.kM();
        if (bVar.FL != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.FL) {
                this.GA.bq(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.GA.kM();
            }
        }
        this.GA.kM();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.FM != null && !cVar.FM.equals("")) {
                byte[] bytes = cVar.FM.getBytes(HTTP.UTF_8);
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
        if (jVar.FH != null && jVar.FH.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.FH);
    }

    private void a(k.C0019k c0019k) throws IOException, WebSocketException {
        if (c0019k.FH != null && c0019k.FH.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0019k.FH);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] kN = iVar.FQ.kN();
        if (kN == null) {
            return false;
        }
        if (kN.length > this.FA.li()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, kN);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.FH.length > this.FA.li()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.FH);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.FW.getBytes(HTTP.UTF_8);
        if (bytes.length > this.FA.li()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.FH.length > this.FA.li()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.FH);
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
        this.GA.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.FA.ln()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.GA.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.GA.write((byte) (b2 | 126));
            this.GA.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.GA.write((byte) (b2 | Byte.MAX_VALUE));
            this.GA.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.FA.ln()) {
            this.GA.write(0);
            this.GA.write(0);
            this.GA.write(0);
            this.GA.write(0);
        }
        if (j > 0) {
            if (this.FA.ln()) {
            }
            this.GA.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).FQ;
                }
                this.GA.kK();
                if (!y(message.obj)) {
                    w(new k.n(cVar));
                    return;
                }
                this.GA.kJ();
                if (cVar != null) {
                    w(new k.r(cVar));
                }
                while (this.GA.kL() > 0) {
                    if (this.Fs == null) {
                        w(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Fs.write(this.GA.kI());
                    if (write > 0) {
                        synchronized (o.class) {
                            GB += write;
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
            this.Fs.close();
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

    public void kW() {
        synchronized (o.class) {
            GB = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = GB;
        }
        return j;
    }
}
