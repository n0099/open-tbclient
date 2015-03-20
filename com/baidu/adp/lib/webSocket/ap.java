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
public class ap extends Handler {
    private static long Bq = 0;
    private final Handler AW;
    private final f Ak;
    private final al As;
    private final Random Bo;
    private final a Bp;
    private final Looper mLooper;

    public ap(Looper looper, Handler handler, f fVar, al alVar) {
        super(looper);
        this.Bo = new Random();
        this.mLooper = looper;
        this.AW = handler;
        this.Ak = fVar;
        this.As = alVar;
        this.Bp = new a(alVar.jH() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean q(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void p(Object obj) {
        Message obtainMessage = this.AW.obtainMessage();
        obtainMessage.obj = obj;
        this.AW.sendMessage(obtainMessage);
    }

    private String jS() {
        byte[] bArr = new byte[16];
        this.Bo.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.m(bArr);
    }

    private void a(t tVar) {
        String str;
        if (tVar.AA != null) {
            str = String.valueOf(tVar.mPath) + "?" + tVar.AA;
        } else {
            str = tVar.mPath;
        }
        this.Bp.write("GET " + str + " HTTP/1.1");
        this.Bp.jl();
        this.Bp.write("Host: " + tVar.mHost);
        this.Bp.jl();
        this.Bp.write("Upgrade: WebSocket");
        this.Bp.jl();
        this.Bp.write("Connection: Upgrade");
        this.Bp.jl();
        this.Bp.write("Sec-WebSocket-Key: " + jS());
        this.Bp.jl();
        if (this.As != null && this.As.jN() != null && this.As.jN().length() > 0) {
            this.Bp.write("Sec-WebSocket-Extensions: " + this.As.jN());
            this.Bp.jl();
        }
        if (tVar.mOrigin != null && !tVar.mOrigin.equals("")) {
            this.Bp.write("Origin: " + tVar.mOrigin);
            this.Bp.jl();
        }
        if (tVar.AB != null && tVar.AB.length > 0) {
            this.Bp.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < tVar.AB.length; i++) {
                this.Bp.write(tVar.AB[i]);
                this.Bp.write(", ");
            }
            this.Bp.jl();
        }
        this.Bp.write("Sec-WebSocket-Version: 13");
        this.Bp.jl();
        if (tVar.AC != null) {
            for (NameValuePair nameValuePair : tVar.AC) {
                this.Bp.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.Bp.jl();
            }
        }
        this.Bp.jl();
    }

    private void a(u uVar) {
        byte[] bArr;
        if (uVar.AD > 0) {
            if (uVar.AE != null && !uVar.AE.equals("")) {
                byte[] bytes = uVar.AE.getBytes("UTF-8");
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
            bArr[0] = (byte) ((uVar.AD >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (uVar.AD & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(ab abVar) {
        if (abVar.Az != null && abVar.Az.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, abVar.Az);
    }

    private void a(ac acVar) {
        if (acVar.Az != null && acVar.Az.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, acVar.Az);
    }

    private boolean a(aa aaVar) {
        byte[] jm = aaVar.AI.jm();
        if (jm == null) {
            return false;
        }
        if (jm.length > this.As.jI()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, jm);
        return true;
    }

    private void a(s sVar) {
        if (sVar.Az.length > this.As.jI()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, sVar.Az);
    }

    private void a(ak akVar) {
        byte[] bytes = akVar.AN.getBytes("UTF-8");
        if (bytes.length > this.As.jI()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(ae aeVar) {
        if (aeVar.Az.length > this.As.jI()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, aeVar.Az);
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
        this.Bp.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.As.jM()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Bp.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Bp.write((byte) (b2 | 126));
            this.Bp.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Bp.write((byte) (b2 | Byte.MAX_VALUE));
            this.Bp.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.As.jM()) {
            this.Bp.write(0);
            this.Bp.write(0);
            this.Bp.write(0);
            this.Bp.write(0);
        }
        if (j > 0) {
            this.As.jM();
            this.Bp.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof aa) {
                    cVar = ((aa) message.obj).AI;
                }
                this.Bp.clear();
                if (!r(message.obj)) {
                    p(new af(cVar));
                    return;
                }
                this.Bp.flip();
                if (cVar != null) {
                    p(new aj(cVar));
                }
                while (this.Bp.remaining() > 0) {
                    if (this.Ak == null) {
                        p(new v(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Ak.write(this.Bp.jk());
                    if (write > 0) {
                        synchronized (ap.class) {
                            Bq += write;
                        }
                    }
                }
                if (cVar != null) {
                    p(new y(cVar));
                }
            }
        } catch (SocketException e) {
            p(new v(e));
        } catch (Exception e2) {
            if (jw()) {
                e2.printStackTrace();
            }
            p(new x(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.Ak.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean r(Object obj) {
        if (obj instanceof aa) {
            return a((aa) obj);
        }
        if (obj instanceof ak) {
            a((ak) obj);
        } else if (obj instanceof ae) {
            a((ae) obj);
        } else if (obj instanceof s) {
            a((s) obj);
        } else if (obj instanceof ab) {
            a((ab) obj);
        } else if (obj instanceof ac) {
            a((ac) obj);
        } else if (obj instanceof u) {
            a((u) obj);
        } else if (obj instanceof t) {
            a((t) obj);
        } else {
            o(obj);
        }
        return true;
    }

    protected void o(Object obj) {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean jw() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jx() {
        synchronized (ap.class) {
            Bq = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (ap.class) {
            j = Bq;
        }
        return j;
    }
}
