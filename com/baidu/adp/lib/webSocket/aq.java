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
    private static long qx = 0;
    private final Looper mLooper;
    private final am pD;
    private final g pv;
    private final Handler qg;
    private final Random qv;
    private final c qw;

    public aq(Looper looper, Handler handler, g gVar, am amVar) {
        super(looper);
        this.qv = new Random();
        this.mLooper = looper;
        this.qg = handler;
        this.pv = gVar;
        this.pD = amVar;
        this.qw = new c(amVar.gm() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean q(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void p(Object obj) {
        Message obtainMessage = this.qg.obtainMessage();
        obtainMessage.obj = obj;
        this.qg.sendMessage(obtainMessage);
    }

    private String gx() {
        byte[] bArr = new byte[16];
        this.qv.nextBytes(bArr);
        return a.p(bArr);
    }

    private void a(u uVar) {
        String str;
        if (uVar.pL != null) {
            str = String.valueOf(uVar.mPath) + "?" + uVar.pL;
        } else {
            str = uVar.mPath;
        }
        this.qw.write("GET " + str + " HTTP/1.1");
        this.qw.fQ();
        this.qw.write("Host: " + uVar.mHost);
        this.qw.fQ();
        this.qw.write("Upgrade: WebSocket");
        this.qw.fQ();
        this.qw.write("Connection: Upgrade");
        this.qw.fQ();
        this.qw.write("Sec-WebSocket-Key: " + gx());
        this.qw.fQ();
        if (this.pD != null && this.pD.gs() != null && this.pD.gs().length() > 0) {
            this.qw.write("Sec-WebSocket-Extensions: " + this.pD.gs());
            this.qw.fQ();
        }
        if (uVar.mOrigin != null && !uVar.mOrigin.equals("")) {
            this.qw.write("Origin: " + uVar.mOrigin);
            this.qw.fQ();
        }
        if (uVar.pM != null && uVar.pM.length > 0) {
            this.qw.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < uVar.pM.length; i++) {
                this.qw.write(uVar.pM[i]);
                this.qw.write(", ");
            }
            this.qw.fQ();
        }
        this.qw.write("Sec-WebSocket-Version: 13");
        this.qw.fQ();
        if (uVar.pN != null) {
            for (NameValuePair nameValuePair : uVar.pN) {
                this.qw.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.qw.fQ();
            }
        }
        this.qw.fQ();
    }

    private void a(v vVar) {
        byte[] bArr;
        if (vVar.pO > 0) {
            if (vVar.pP != null && !vVar.pP.equals("")) {
                byte[] bytes = vVar.pP.getBytes("UTF-8");
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
            bArr[0] = (byte) ((vVar.pO >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (vVar.pO & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(ac acVar) {
        if (acVar.pK != null && acVar.pK.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, acVar.pK);
    }

    private void a(ad adVar) {
        if (adVar.pK != null && adVar.pK.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, adVar.pK);
    }

    private boolean a(ab abVar) {
        byte[] fR = abVar.pT.fR();
        if (fR == null) {
            return false;
        }
        if (fR.length > this.pD.gn()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, fR);
        return true;
    }

    private void a(t tVar) {
        if (tVar.pK.length > this.pD.gn()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, tVar.pK);
    }

    private void a(al alVar) {
        byte[] bytes = alVar.pX.getBytes("UTF-8");
        if (bytes.length > this.pD.gn()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(af afVar) {
        if (afVar.pK.length > this.pD.gn()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, afVar.pK);
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
        this.qw.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.pD.gr()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.qw.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.qw.write((byte) (b2 | 126));
            this.qw.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.qw.write((byte) (b2 | Byte.MAX_VALUE));
            this.qw.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.pD.gr()) {
            this.qw.write(0);
            this.qw.write(0);
            this.qw.write(0);
            this.qw.write(0);
        }
        if (j > 0) {
            this.pD.gr();
            this.qw.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                d dVar = null;
                if (message.obj instanceof ab) {
                    dVar = ((ab) message.obj).pT;
                }
                this.qw.clear();
                if (!r(message.obj)) {
                    p(new ag(dVar));
                    return;
                }
                this.qw.flip();
                if (dVar != null) {
                    p(new ak(dVar));
                }
                while (this.qw.remaining() > 0) {
                    if (this.pv == null) {
                        p(new w(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.pv.write(this.qw.fP());
                    if (write > 0) {
                        synchronized (aq.class) {
                            qx += write;
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
            if (ga()) {
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
            this.pv.close();
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

    private boolean ga() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void gb() {
        synchronized (aq.class) {
            qx = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (aq.class) {
            j = qx;
        }
        return j;
    }
}
