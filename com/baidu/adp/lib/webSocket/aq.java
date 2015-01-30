package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.baidu.adp.base.BdBaseApplication;
import java.net.SocketException;
import java.util.Random;
import org.apache.http.NameValuePair;
/* loaded from: classes.dex */
public class aq extends Handler {
    private static long qC = 0;
    private final Looper mLooper;
    private final g pA;
    private final am pI;
    private final Random qA;
    private final c qB;
    private final Handler ql;

    public aq(Looper looper, Handler handler, g gVar, am amVar) {
        super(looper);
        this.qA = new Random();
        this.mLooper = looper;
        this.ql = handler;
        this.pA = gVar;
        this.pI = amVar;
        this.qB = new c(amVar.gl() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean q(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void p(Object obj) {
        Message obtainMessage = this.ql.obtainMessage();
        obtainMessage.obj = obj;
        this.ql.sendMessage(obtainMessage);
    }

    private String gw() {
        byte[] bArr = new byte[16];
        this.qA.nextBytes(bArr);
        return a.p(bArr);
    }

    private void a(u uVar) {
        String str;
        if (uVar.pQ != null) {
            str = String.valueOf(uVar.mPath) + "?" + uVar.pQ;
        } else {
            str = uVar.mPath;
        }
        this.qB.write("GET " + str + " HTTP/1.1");
        this.qB.fP();
        this.qB.write("Host: " + uVar.mHost);
        this.qB.fP();
        this.qB.write("Upgrade: WebSocket");
        this.qB.fP();
        this.qB.write("Connection: Upgrade");
        this.qB.fP();
        this.qB.write("Sec-WebSocket-Key: " + gw());
        this.qB.fP();
        if (this.pI != null && this.pI.gr() != null && this.pI.gr().length() > 0) {
            this.qB.write("Sec-WebSocket-Extensions: " + this.pI.gr());
            this.qB.fP();
        }
        if (uVar.mOrigin != null && !uVar.mOrigin.equals("")) {
            this.qB.write("Origin: " + uVar.mOrigin);
            this.qB.fP();
        }
        if (uVar.pR != null && uVar.pR.length > 0) {
            this.qB.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < uVar.pR.length; i++) {
                this.qB.write(uVar.pR[i]);
                this.qB.write(", ");
            }
            this.qB.fP();
        }
        this.qB.write("Sec-WebSocket-Version: 13");
        this.qB.fP();
        if (uVar.pS != null) {
            for (NameValuePair nameValuePair : uVar.pS) {
                this.qB.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.qB.fP();
            }
        }
        this.qB.fP();
    }

    private void a(v vVar) {
        byte[] bArr;
        if (vVar.pT > 0) {
            if (vVar.pU != null && !vVar.pU.equals("")) {
                byte[] bytes = vVar.pU.getBytes("UTF-8");
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
            bArr[0] = (byte) ((vVar.pT >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (vVar.pT & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(ac acVar) {
        if (acVar.pP != null && acVar.pP.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, acVar.pP);
    }

    private void a(ad adVar) {
        if (adVar.pP != null && adVar.pP.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, adVar.pP);
    }

    private boolean a(ab abVar) {
        byte[] fQ = abVar.pY.fQ();
        if (fQ == null) {
            return false;
        }
        if (fQ.length > this.pI.gm()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, fQ);
        return true;
    }

    private void a(t tVar) {
        if (tVar.pP.length > this.pI.gm()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, tVar.pP);
    }

    private void a(al alVar) {
        byte[] bytes = alVar.qc.getBytes("UTF-8");
        if (bytes.length > this.pI.gm()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(af afVar) {
        if (afVar.pP.length > this.pI.gm()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, afVar.pP);
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
        this.qB.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.pI.gq()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.qB.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.qB.write((byte) (b2 | 126));
            this.qB.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.qB.write((byte) (b2 | Byte.MAX_VALUE));
            this.qB.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.pI.gq()) {
            this.qB.write(0);
            this.qB.write(0);
            this.qB.write(0);
            this.qB.write(0);
        }
        if (j > 0) {
            this.pI.gq();
            this.qB.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                d dVar = null;
                if (message.obj instanceof ab) {
                    dVar = ((ab) message.obj).pY;
                }
                this.qB.clear();
                if (!r(message.obj)) {
                    p(new ag(dVar));
                    return;
                }
                this.qB.flip();
                if (dVar != null) {
                    p(new ak(dVar));
                }
                while (this.qB.remaining() > 0) {
                    if (this.pA == null) {
                        p(new w(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.pA.write(this.qB.fO());
                    if (write > 0) {
                        synchronized (aq.class) {
                            qC += write;
                        }
                    }
                }
                if (dVar != null) {
                    p(new z(dVar));
                }
            }
        } catch (SocketException e) {
            p(new w(e));
        } catch (Exception e2) {
            if (fZ()) {
                e2.printStackTrace();
            }
            p(new y(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.pA.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean r(Object obj) {
        if (obj instanceof ab) {
            return a((ab) obj);
        }
        if (obj instanceof al) {
            a((al) obj);
        } else if (obj instanceof af) {
            a((af) obj);
        } else if (obj instanceof t) {
            a((t) obj);
        } else if (obj instanceof ac) {
            a((ac) obj);
        } else if (obj instanceof ad) {
            a((ad) obj);
        } else if (obj instanceof v) {
            a((v) obj);
        } else if (obj instanceof u) {
            a((u) obj);
        } else {
            o(obj);
        }
        return true;
    }

    protected void o(Object obj) {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean fZ() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ga() {
        synchronized (aq.class) {
            qC = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (aq.class) {
            j = qC;
        }
        return j;
    }
}
