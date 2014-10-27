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
    private static long qD = 0;
    private final am pF;
    private final g px;
    private final Random qA;
    private final Looper qB;
    private final c qC;
    private final Handler ql;

    public aq(Looper looper, Handler handler, g gVar, am amVar) {
        super(looper);
        this.qA = new Random();
        this.qB = looper;
        this.ql = handler;
        this.px = gVar;
        this.pF = amVar;
        this.qC = new c(amVar.gl() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean o(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void n(Object obj) {
        Message obtainMessage = this.ql.obtainMessage();
        obtainMessage.obj = obj;
        this.ql.sendMessage(obtainMessage);
    }

    private String gw() {
        byte[] bArr = new byte[16];
        this.qA.nextBytes(bArr);
        return a.q(bArr);
    }

    private void a(u uVar) {
        String str;
        if (uVar.pO != null) {
            str = String.valueOf(uVar.dM) + "?" + uVar.pO;
        } else {
            str = uVar.dM;
        }
        this.qC.write("GET " + str + " HTTP/1.1");
        this.qC.fO();
        this.qC.write("Host: " + uVar.pN);
        this.qC.fO();
        this.qC.write("Upgrade: WebSocket");
        this.qC.fO();
        this.qC.write("Connection: Upgrade");
        this.qC.fO();
        this.qC.write("Sec-WebSocket-Key: " + gw());
        this.qC.fO();
        if (this.pF != null && this.pF.gr() != null && this.pF.gr().length() > 0) {
            this.qC.write("Sec-WebSocket-Extensions: " + this.pF.gr());
            this.qC.fO();
        }
        if (uVar.pP != null && !uVar.pP.equals("")) {
            this.qC.write("Origin: " + uVar.pP);
            this.qC.fO();
        }
        if (uVar.pQ != null && uVar.pQ.length > 0) {
            this.qC.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < uVar.pQ.length; i++) {
                this.qC.write(uVar.pQ[i]);
                this.qC.write(", ");
            }
            this.qC.fO();
        }
        this.qC.write("Sec-WebSocket-Version: 13");
        this.qC.fO();
        if (uVar.pR != null) {
            for (NameValuePair nameValuePair : uVar.pR) {
                this.qC.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.qC.fO();
            }
        }
        this.qC.fO();
    }

    private void a(v vVar) {
        byte[] bArr;
        if (vVar.pS > 0) {
            if (vVar.pT != null && !vVar.pT.equals("")) {
                byte[] bytes = vVar.pT.getBytes("UTF-8");
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
            bArr[0] = (byte) ((vVar.pS >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (vVar.pS & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(ac acVar) {
        if (acVar.pM != null && acVar.pM.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, acVar.pM);
    }

    private void a(ad adVar) {
        if (adVar.pM != null && adVar.pM.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, adVar.pM);
    }

    private boolean a(ab abVar) {
        byte[] fP = abVar.pX.fP();
        if (fP == null) {
            return false;
        }
        if (fP.length > this.pF.gm()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, fP);
        return true;
    }

    private void a(t tVar) {
        if (tVar.pM.length > this.pF.gm()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, tVar.pM);
    }

    private void a(al alVar) {
        byte[] bytes = alVar.qc.getBytes("UTF-8");
        if (bytes.length > this.pF.gm()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(af afVar) {
        if (afVar.pM.length > this.pF.gm()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, afVar.pM);
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
        this.qC.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.pF.gq()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.qC.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.qC.write((byte) (b2 | 126));
            this.qC.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.qC.write((byte) (b2 | Byte.MAX_VALUE));
            this.qC.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.pF.gq()) {
            this.qC.write(0);
            this.qC.write(0);
            this.qC.write(0);
            this.qC.write(0);
        }
        if (j > 0) {
            this.pF.gq();
            this.qC.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                d dVar = null;
                if (message.obj instanceof ab) {
                    dVar = ((ab) message.obj).pX;
                }
                this.qC.clear();
                if (!p(message.obj)) {
                    n(new ag(dVar));
                    return;
                }
                this.qC.flip();
                if (dVar != null) {
                    n(new ak(dVar));
                }
                while (this.qC.remaining() > 0) {
                    if (this.px == null) {
                        n(new w(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.px.write(this.qC.fN());
                    if (write > 0) {
                        synchronized (aq.class) {
                            qD += write;
                        }
                    }
                }
                if (dVar != null) {
                    n(new z(dVar));
                }
            }
        } catch (SocketException e) {
            n(new w(e));
        } catch (Exception e2) {
            if (fY()) {
                e2.printStackTrace();
            }
            n(new y(e2));
        }
    }

    public void quit() {
        try {
            this.qB.quit();
        } catch (Exception e) {
        }
        try {
            this.px.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean p(Object obj) {
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
            m(obj);
        }
        return true;
    }

    protected void m(Object obj) {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean fY() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void fZ() {
        synchronized (aq.class) {
            qD = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (aq.class) {
            j = qD;
        }
        return j;
    }
}
