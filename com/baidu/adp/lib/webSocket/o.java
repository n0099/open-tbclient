package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.k;
import java.io.IOException;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class o extends Handler {
    private static long CU = 0;
    private final e.a BK;
    private final l BS;
    private final Random CR;
    private final Looper CS;
    private final a CT;
    private final Handler Cx;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.CR = new Random();
        this.CS = looper;
        this.Cx = handler;
        this.BK = aVar;
        this.BS = lVar;
        this.CT = new a(lVar.iu() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.Cx.obtainMessage();
        obtainMessage.obj = obj;
        this.Cx.sendMessage(obtainMessage);
    }

    private String iF() {
        byte[] bArr = new byte[16];
        this.CR.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.Cb != null) {
            str = bVar.mPath + "?" + bVar.Cb;
        } else {
            str = bVar.mPath;
        }
        this.CT.write("GET " + str + " HTTP/1.1");
        this.CT.hY();
        this.CT.write("Host: " + bVar.Ca);
        this.CT.hY();
        this.CT.write("Upgrade: WebSocket");
        this.CT.hY();
        this.CT.write("Connection: Upgrade");
        this.CT.hY();
        this.CT.write("Sec-WebSocket-Key: " + iF());
        this.CT.hY();
        if (this.BS != null && this.BS.iA() != null && this.BS.iA().length() > 0) {
            this.CT.write("Sec-WebSocket-Extensions: " + this.BS.iA());
            this.CT.hY();
        }
        if (bVar.Cc != null && !bVar.Cc.equals("")) {
            this.CT.write("Origin: " + bVar.Cc);
            this.CT.hY();
        }
        if (bVar.Cd != null && bVar.Cd.length > 0) {
            this.CT.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.Cd.length; i++) {
                this.CT.write(bVar.Cd[i]);
                this.CT.write(", ");
            }
            this.CT.hY();
        }
        this.CT.write("Sec-WebSocket-Version: 13");
        this.CT.hY();
        if (bVar.Ce != null) {
            for (NameValuePair nameValuePair : bVar.Ce) {
                this.CT.write(nameValuePair.getName() + ":" + nameValuePair.getValue());
                this.CT.hY();
            }
        }
        this.CT.hY();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.Cf != null && !cVar.Cf.equals("")) {
                byte[] bytes = cVar.Cf.getBytes("UTF-8");
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
            bArr[0] = (byte) ((cVar.mCode >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (cVar.mCode & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(k.j jVar) throws IOException, WebSocketException {
        if (jVar.BZ != null && jVar.BZ.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.BZ);
    }

    private void a(k.C0009k c0009k) throws IOException, WebSocketException {
        if (c0009k.BZ != null && c0009k.BZ.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0009k.BZ);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] hZ = iVar.Cj.hZ();
        if (hZ == null) {
            return false;
        }
        if (hZ.length > this.BS.iv()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, hZ);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.BZ.length > this.BS.iv()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.BZ);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Co.getBytes("UTF-8");
        if (bytes.length > this.BS.iv()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.BZ.length > this.BS.iv()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.BZ);
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
        this.CT.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.BS.iz()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.CT.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.CT.write((byte) (b2 | 126));
            this.CT.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.CT.write((byte) (b2 | Byte.MAX_VALUE));
            this.CT.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.BS.iz()) {
            this.CT.write(0);
            this.CT.write(0);
            this.CT.write(0);
            this.CT.write(0);
        }
        if (j > 0) {
            if (this.BS.iz()) {
            }
            this.CT.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).Cj;
                }
                this.CT.clear();
                if (!v(message.obj)) {
                    t(new k.n(cVar));
                    return;
                }
                this.CT.flip();
                if (cVar != null) {
                    t(new k.r(cVar));
                }
                while (this.CT.remaining() > 0) {
                    if (this.BK == null) {
                        t(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.BK.write(this.CT.hX());
                    if (write > 0) {
                        synchronized (o.class) {
                            CU += write;
                        }
                    }
                }
                if (cVar != null) {
                    t(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            t(new k.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            t(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.CS.quit();
        } catch (Exception e) {
        }
        try {
            this.BK.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean v(Object obj) throws IOException, WebSocketException {
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
        } else if (obj instanceof k.C0009k) {
            a((k.C0009k) obj);
        } else if (obj instanceof k.c) {
            a((k.c) obj);
        } else if (obj instanceof k.b) {
            a((k.b) obj);
        } else {
            s(obj);
        }
        return true;
    }

    protected void s(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ij() {
        synchronized (o.class) {
            CU = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = CU;
        }
        return j;
    }
}
