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
    private static long FH = 0;
    private final l EG;
    private final e.a Ey;
    private final Random FF;
    private final a FG;
    private final Handler Fl;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.FF = new Random();
        this.mLooper = looper;
        this.Fl = handler;
        this.Ey = aVar;
        this.EG = lVar;
        this.FG = new a(lVar.kE() + 14, 262144);
    }

    public boolean w(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void v(Object obj) {
        Message obtainMessage = this.Fl.obtainMessage();
        obtainMessage.obj = obj;
        this.Fl.sendMessage(obtainMessage);
    }

    private String kP() {
        byte[] bArr = new byte[16];
        this.FF.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.FG.write("GET " + str + " HTTP/1.1");
        this.FG.kj();
        this.FG.write("Host: " + bVar.EO);
        this.FG.kj();
        this.FG.write("Upgrade: WebSocket");
        this.FG.kj();
        this.FG.write("Connection: Upgrade");
        this.FG.kj();
        this.FG.write("Sec-WebSocket-Key: " + kP());
        this.FG.kj();
        if (this.EG != null && this.EG.kK() != null && this.EG.kK().length() > 0) {
            this.FG.write("Sec-WebSocket-Extensions: " + this.EG.kK());
            this.FG.kj();
        }
        if (bVar.EP != null && !bVar.EP.equals("")) {
            this.FG.write("Origin: " + bVar.EP);
            this.FG.kj();
        }
        if (bVar.ER != null && bVar.ER.length > 0) {
            this.FG.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.ER.length; i++) {
                this.FG.write(bVar.ER[i]);
                this.FG.write(", ");
            }
            this.FG.kj();
        }
        this.FG.write("Sec-WebSocket-Version: 13");
        this.FG.kj();
        if (bVar.ES != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.ES) {
                this.FG.write(basicNameValuePair.getName() + SystemInfoUtil.COLON + basicNameValuePair.getValue());
                this.FG.kj();
            }
        }
        this.FG.kj();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.ET != null && !cVar.ET.equals("")) {
                byte[] bytes = cVar.ET.getBytes("UTF-8");
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
        if (jVar.EN != null && jVar.EN.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.EN);
    }

    private void a(k.C0018k c0018k) throws IOException, WebSocketException {
        if (c0018k.EN != null && c0018k.EN.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0018k.EN);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] kk = iVar.EX.kk();
        if (kk == null) {
            return false;
        }
        if (kk.length > this.EG.kF()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, kk);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.EN.length > this.EG.kF()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.EN);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Fc.getBytes("UTF-8");
        if (bytes.length > this.EG.kF()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.EN.length > this.EG.kF()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.EN);
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
        this.FG.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.EG.kJ()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.FG.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.FG.write((byte) (b2 | 126));
            this.FG.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.FG.write((byte) (b2 | Byte.MAX_VALUE));
            this.FG.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.EG.kJ()) {
            this.FG.write(0);
            this.FG.write(0);
            this.FG.write(0);
            this.FG.write(0);
        }
        if (j > 0) {
            if (this.EG.kJ()) {
            }
            this.FG.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).EX;
                }
                this.FG.clear();
                if (!x(message.obj)) {
                    v(new k.n(cVar));
                    return;
                }
                this.FG.flip();
                if (cVar != null) {
                    v(new k.r(cVar));
                }
                while (this.FG.remaining() > 0) {
                    if (this.Ey == null) {
                        v(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Ey.write(this.FG.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            FH += write;
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
            this.Ey.close();
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
            FH = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = FH;
        }
        return j;
    }
}
