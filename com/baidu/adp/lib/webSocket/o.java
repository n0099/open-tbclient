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
    private static long Bu = 0;
    private final Handler AX;
    private final e.a Ak;
    private final l As;
    private final Random Br;
    private final Looper Bs;
    private final a Bt;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Br = new Random();
        this.Bs = looper;
        this.AX = handler;
        this.Ak = aVar;
        this.As = lVar;
        this.Bt = new a(lVar.ik() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean u(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void t(Object obj) {
        Message obtainMessage = this.AX.obtainMessage();
        obtainMessage.obj = obj;
        this.AX.sendMessage(obtainMessage);
    }

    private String iv() {
        byte[] bArr = new byte[16];
        this.Br.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.AB != null) {
            str = bVar.mPath + "?" + bVar.AB;
        } else {
            str = bVar.mPath;
        }
        this.Bt.write("GET " + str + " HTTP/1.1");
        this.Bt.hO();
        this.Bt.write("Host: " + bVar.AA);
        this.Bt.hO();
        this.Bt.write("Upgrade: WebSocket");
        this.Bt.hO();
        this.Bt.write("Connection: Upgrade");
        this.Bt.hO();
        this.Bt.write("Sec-WebSocket-Key: " + iv());
        this.Bt.hO();
        if (this.As != null && this.As.iq() != null && this.As.iq().length() > 0) {
            this.Bt.write("Sec-WebSocket-Extensions: " + this.As.iq());
            this.Bt.hO();
        }
        if (bVar.AC != null && !bVar.AC.equals("")) {
            this.Bt.write("Origin: " + bVar.AC);
            this.Bt.hO();
        }
        if (bVar.AD != null && bVar.AD.length > 0) {
            this.Bt.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.AD.length; i++) {
                this.Bt.write(bVar.AD[i]);
                this.Bt.write(", ");
            }
            this.Bt.hO();
        }
        this.Bt.write("Sec-WebSocket-Version: 13");
        this.Bt.hO();
        if (bVar.AE != null) {
            for (NameValuePair nameValuePair : bVar.AE) {
                this.Bt.write(nameValuePair.getName() + ":" + nameValuePair.getValue());
                this.Bt.hO();
            }
        }
        this.Bt.hO();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.AF != null && !cVar.AF.equals("")) {
                byte[] bytes = cVar.AF.getBytes("UTF-8");
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
        if (jVar.Az != null && jVar.Az.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.Az);
    }

    private void a(k.C0009k c0009k) throws IOException, WebSocketException {
        if (c0009k.Az != null && c0009k.Az.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0009k.Az);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] hP = iVar.AJ.hP();
        if (hP == null) {
            return false;
        }
        if (hP.length > this.As.il()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, hP);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.Az.length > this.As.il()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.Az);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.AO.getBytes("UTF-8");
        if (bytes.length > this.As.il()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.Az.length > this.As.il()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.Az);
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
        this.Bt.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.As.ip()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Bt.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Bt.write((byte) (b2 | 126));
            this.Bt.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Bt.write((byte) (b2 | Byte.MAX_VALUE));
            this.Bt.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.As.ip()) {
            this.Bt.write(0);
            this.Bt.write(0);
            this.Bt.write(0);
            this.Bt.write(0);
        }
        if (j > 0) {
            if (this.As.ip()) {
            }
            this.Bt.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).AJ;
                }
                this.Bt.clear();
                if (!v(message.obj)) {
                    t(new k.n(cVar));
                    return;
                }
                this.Bt.flip();
                if (cVar != null) {
                    t(new k.r(cVar));
                }
                while (this.Bt.remaining() > 0) {
                    if (this.Ak == null) {
                        t(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Ak.write(this.Bt.hN());
                    if (write > 0) {
                        synchronized (o.class) {
                            Bu += write;
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
            this.Bs.quit();
        } catch (Exception e) {
        }
        try {
            this.Ak.close();
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

    public void hZ() {
        synchronized (o.class) {
            Bu = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Bu;
        }
        return j;
    }
}
