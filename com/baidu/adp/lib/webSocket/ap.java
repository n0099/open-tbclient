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
    private static long Bf = 0;
    private final Handler AL;
    private final al Ah;
    private final Random Bd;
    private final a Be;
    private final Looper mLooper;
    private final f zY;

    public ap(Looper looper, Handler handler, f fVar, al alVar) {
        super(looper);
        this.Bd = new Random();
        this.mLooper = looper;
        this.AL = handler;
        this.zY = fVar;
        this.Ah = alVar;
        this.Be = new a(alVar.jY() + 14, AccessibilityEventCompat.TYPE_GESTURE_DETECTION_START);
    }

    public boolean q(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void p(Object obj) {
        Message obtainMessage = this.AL.obtainMessage();
        obtainMessage.obj = obj;
        this.AL.sendMessage(obtainMessage);
    }

    private String kj() {
        byte[] bArr = new byte[16];
        this.Bd.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.m(bArr);
    }

    private void a(t tVar) {
        String str;
        if (tVar.Ap != null) {
            str = String.valueOf(tVar.mPath) + "?" + tVar.Ap;
        } else {
            str = tVar.mPath;
        }
        this.Be.write("GET " + str + " HTTP/1.1");
        this.Be.jC();
        this.Be.write("Host: " + tVar.mHost);
        this.Be.jC();
        this.Be.write("Upgrade: WebSocket");
        this.Be.jC();
        this.Be.write("Connection: Upgrade");
        this.Be.jC();
        this.Be.write("Sec-WebSocket-Key: " + kj());
        this.Be.jC();
        if (this.Ah != null && this.Ah.ke() != null && this.Ah.ke().length() > 0) {
            this.Be.write("Sec-WebSocket-Extensions: " + this.Ah.ke());
            this.Be.jC();
        }
        if (tVar.mOrigin != null && !tVar.mOrigin.equals("")) {
            this.Be.write("Origin: " + tVar.mOrigin);
            this.Be.jC();
        }
        if (tVar.Aq != null && tVar.Aq.length > 0) {
            this.Be.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < tVar.Aq.length; i++) {
                this.Be.write(tVar.Aq[i]);
                this.Be.write(", ");
            }
            this.Be.jC();
        }
        this.Be.write("Sec-WebSocket-Version: 13");
        this.Be.jC();
        if (tVar.Ar != null) {
            for (NameValuePair nameValuePair : tVar.Ar) {
                this.Be.write(String.valueOf(nameValuePair.getName()) + ":" + nameValuePair.getValue());
                this.Be.jC();
            }
        }
        this.Be.jC();
    }

    private void a(u uVar) {
        byte[] bArr;
        if (uVar.As > 0) {
            if (uVar.At != null && !uVar.At.equals("")) {
                byte[] bytes = uVar.At.getBytes("UTF-8");
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
            bArr[0] = (byte) ((uVar.As >> 8) & MotionEventCompat.ACTION_MASK);
            bArr[1] = (byte) (uVar.As & MotionEventCompat.ACTION_MASK);
            a(8, true, bArr);
            return;
        }
        a(8, true, null);
    }

    private void a(ab abVar) {
        if (abVar.Ao != null && abVar.Ao.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, abVar.Ao);
    }

    private void a(ac acVar) {
        if (acVar.Ao != null && acVar.Ao.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, acVar.Ao);
    }

    private boolean a(aa aaVar) {
        byte[] jD = aaVar.Ax.jD();
        if (jD == null) {
            return false;
        }
        if (jD.length > this.Ah.jZ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, jD);
        return true;
    }

    private void a(s sVar) {
        if (sVar.Ao.length > this.Ah.jZ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, sVar.Ao);
    }

    private void a(ak akVar) {
        byte[] bytes = akVar.AB.getBytes("UTF-8");
        if (bytes.length > this.Ah.jZ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(ae aeVar) {
        if (aeVar.Ao.length > this.Ah.jZ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, aeVar.Ao);
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
        this.Be.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.Ah.kd()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Be.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Be.write((byte) (b2 | 126));
            this.Be.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Be.write((byte) (b2 | Byte.MAX_VALUE));
            this.Be.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Ah.kd()) {
            this.Be.write(0);
            this.Be.write(0);
            this.Be.write(0);
            this.Be.write(0);
        }
        if (j > 0) {
            this.Ah.kd();
            this.Be.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof aa) {
                    cVar = ((aa) message.obj).Ax;
                }
                this.Be.clear();
                if (!r(message.obj)) {
                    p(new af(cVar));
                    return;
                }
                this.Be.flip();
                if (cVar != null) {
                    p(new aj(cVar));
                }
                while (this.Be.remaining() > 0) {
                    if (this.zY == null) {
                        p(new v(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.zY.write(this.Be.jB());
                    if (write > 0) {
                        synchronized (ap.class) {
                            Bf += write;
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
            if (jN()) {
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
            this.zY.close();
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

    private boolean jN() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void jO() {
        synchronized (ap.class) {
            Bf = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (ap.class) {
            j = Bf;
        }
        return j;
    }
}
