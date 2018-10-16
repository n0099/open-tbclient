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
    private static long IB = 0;
    private final l HF;
    private final e.a Hx;
    private final a IA;
    private final Handler If;
    private final Random Iz;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Iz = new Random();
        this.mLooper = looper;
        this.If = handler;
        this.Hx = aVar;
        this.HF = lVar;
        this.IA = new a(lVar.lW() + 14, 262144);
    }

    public boolean A(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void z(Object obj) {
        Message obtainMessage = this.If.obtainMessage();
        obtainMessage.obj = obj;
        this.If.sendMessage(obtainMessage);
    }

    private String mh() {
        byte[] bArr = new byte[16];
        this.Iz.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.IA.write("GET " + str + " HTTP/1.1");
        this.IA.lB();
        this.IA.write("Host: " + bVar.mHost);
        this.IA.lB();
        this.IA.write("Upgrade: WebSocket");
        this.IA.lB();
        this.IA.write("Connection: Upgrade");
        this.IA.lB();
        this.IA.write("Sec-WebSocket-Key: " + mh());
        this.IA.lB();
        if (this.HF != null && this.HF.mc() != null && this.HF.mc().length() > 0) {
            this.IA.write("Sec-WebSocket-Extensions: " + this.HF.mc());
            this.IA.lB();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.IA.write("Origin: " + bVar.mOrigin);
            this.IA.lB();
        }
        if (bVar.HM != null && bVar.HM.length > 0) {
            this.IA.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.HM.length; i++) {
                this.IA.write(bVar.HM[i]);
                this.IA.write(", ");
            }
            this.IA.lB();
        }
        this.IA.write("Sec-WebSocket-Version: 13");
        this.IA.lB();
        if (bVar.HN != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.HN) {
                this.IA.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.IA.lB();
            }
        }
        this.IA.lB();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.HO != null && !cVar.HO.equals("")) {
                byte[] bytes = cVar.HO.getBytes("UTF-8");
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
        if (jVar.HL != null && jVar.HL.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.HL);
    }

    private void a(k.C0021k c0021k) throws IOException, WebSocketException {
        if (c0021k.HL != null && c0021k.HL.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0021k.HL);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] lC = iVar.HR.lC();
        if (lC == null) {
            return false;
        }
        if (lC.length > this.HF.lX()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, lC);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.HL.length > this.HF.lX()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.HL);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.HW.getBytes("UTF-8");
        if (bytes.length > this.HF.lX()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.HL.length > this.HF.lX()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.HL);
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
        this.IA.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.HF.mb()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.IA.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.IA.write((byte) (b2 | 126));
            this.IA.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.IA.write((byte) (b2 | Byte.MAX_VALUE));
            this.IA.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.HF.mb()) {
            this.IA.write(0);
            this.IA.write(0);
            this.IA.write(0);
            this.IA.write(0);
        }
        if (j > 0) {
            if (this.HF.mb()) {
            }
            this.IA.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).HR;
                }
                this.IA.clear();
                if (!B(message.obj)) {
                    z(new k.n(cVar));
                    return;
                }
                this.IA.flip();
                if (cVar != null) {
                    z(new k.r(cVar));
                }
                while (this.IA.remaining() > 0) {
                    if (this.Hx == null) {
                        z(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Hx.write(this.IA.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            IB += write;
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
            this.Hx.close();
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
        } else if (obj instanceof k.C0021k) {
            a((k.C0021k) obj);
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

    public void lL() {
        synchronized (o.class) {
            IB = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = IB;
        }
        return j;
    }
}
