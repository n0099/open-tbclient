package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.m;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class q extends Handler {
    private static long BC = 0;
    private final n AA;
    private final e.a As;
    private final Looper BA;
    private final a BB;
    private final Handler Bf;
    private final Random Bz;

    public q(Looper looper, Handler handler, e.a aVar, n nVar) {
        super(looper);
        this.Bz = new Random();
        this.BA = looper;
        this.Bf = handler;
        this.As = aVar;
        this.AA = nVar;
        this.BB = new a(nVar.ki() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean r(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void q(Object obj) {
        Message obtainMessage = this.Bf.obtainMessage();
        obtainMessage.obj = obj;
        this.Bf.sendMessage(obtainMessage);
    }

    private String kt() {
        byte[] bArr = new byte[16];
        this.Bz.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(m.b bVar) {
        String str;
        if (bVar.AJ != null) {
            str = String.valueOf(bVar.mPath) + "?" + bVar.AJ;
        } else {
            str = bVar.mPath;
        }
        this.BB.write("GET " + str + " HTTP/1.1");
        this.BB.jL();
        this.BB.write("Host: " + bVar.AI);
        this.BB.jL();
        this.BB.write("Upgrade: WebSocket");
        this.BB.jL();
        this.BB.write("Connection: Upgrade");
        this.BB.jL();
        this.BB.write("Sec-WebSocket-Key: " + kt());
        this.BB.jL();
        if (this.AA != null && this.AA.ko() != null && this.AA.ko().length() > 0) {
            this.BB.write("Sec-WebSocket-Extensions: " + this.AA.ko());
            this.BB.jL();
        }
        if (bVar.AK != null && !bVar.AK.equals("")) {
            this.BB.write("Origin: " + bVar.AK);
            this.BB.jL();
        }
        if (bVar.AL != null && bVar.AL.length > 0) {
            this.BB.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.AL.length; i++) {
                this.BB.write(bVar.AL[i]);
                this.BB.write(", ");
            }
            this.BB.jL();
        }
        this.BB.write("Sec-WebSocket-Version: 13");
        this.BB.jL();
        if (bVar.AM != null) {
            for (NameValuePair nameValuePair : bVar.AM) {
                this.BB.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.BB.jL();
            }
        }
        this.BB.jL();
    }

    private void a(m.c cVar) {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.AN != null && !cVar.AN.equals("")) {
                byte[] bytes = cVar.AN.getBytes("UTF-8");
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

    private void a(m.j jVar) {
        if (jVar.AH != null && jVar.AH.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.AH);
    }

    private void a(m.k kVar) {
        if (kVar.AH != null && kVar.AH.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, kVar.AH);
    }

    private boolean a(m.i iVar) {
        byte[] jM = iVar.AR.jM();
        if (jM == null) {
            return false;
        }
        if (jM.length > this.AA.kj()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, jM);
        return true;
    }

    private void c(m.a aVar) {
        if (aVar.AH.length > this.AA.kj()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.AH);
    }

    private void a(m.s sVar) {
        byte[] bytes = sVar.AW.getBytes("UTF-8");
        if (bytes.length > this.AA.kj()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(m.C0010m c0010m) {
        if (c0010m.AH.length > this.AA.kj()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, c0010m.AH);
    }

    protected void a(int i, boolean z, byte[] bArr) {
        if (bArr != null) {
            a(i, z, bArr, 0, bArr.length);
        } else {
            a(i, z, null, 0, 0);
        }
    }

    protected void a(int i, boolean z, byte[] bArr, int i2, int i3) {
        byte b = 0;
        if (z) {
            b = (byte) (-128);
        }
        this.BB.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.AA.kn()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.BB.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.BB.write((byte) (b2 | 126));
            this.BB.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.BB.write((byte) (b2 | Byte.MAX_VALUE));
            this.BB.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.AA.kn()) {
            this.BB.write(0);
            this.BB.write(0);
            this.BB.write(0);
            this.BB.write(0);
        }
        if (j > 0) {
            this.AA.kn();
            this.BB.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof m.i) {
                    cVar = ((m.i) message.obj).AR;
                }
                this.BB.clear();
                if (!s(message.obj)) {
                    q(new m.n(cVar));
                    return;
                }
                this.BB.flip();
                if (cVar != null) {
                    q(new m.r(cVar));
                }
                while (this.BB.remaining() > 0) {
                    if (this.As == null) {
                        q(new m.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.As.write(this.BB.jK());
                    if (write > 0) {
                        synchronized (q.class) {
                            BC += write;
                        }
                    }
                }
                if (cVar != null) {
                    q(new m.g(cVar));
                }
            }
        } catch (SocketException e) {
            q(new m.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            q(new m.f(e2));
        }
    }

    public void quit() {
        try {
            this.BA.quit();
        } catch (Exception e) {
        }
        try {
            this.As.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean s(Object obj) {
        if (obj instanceof m.i) {
            return a((m.i) obj);
        }
        if (obj instanceof m.s) {
            a((m.s) obj);
        } else if (obj instanceof m.C0010m) {
            a((m.C0010m) obj);
        } else if (obj instanceof m.a) {
            c((m.a) obj);
        } else if (obj instanceof m.j) {
            a((m.j) obj);
        } else if (obj instanceof m.k) {
            a((m.k) obj);
        } else if (obj instanceof m.c) {
            a((m.c) obj);
        } else if (obj instanceof m.b) {
            a((m.b) obj);
        } else {
            p(obj);
        }
        return true;
    }

    protected void p(Object obj) {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jW() {
        synchronized (q.class) {
            BC = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (q.class) {
            j = BC;
        }
        return j;
    }
}
