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
    private static long Sr = 0;
    private final Handler RV;
    private final e.a Rl;
    private final l Rt;
    private final Random Sp;
    private final a Sq;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Sp = new Random();
        this.mLooper = looper;
        this.RV = handler;
        this.Rl = aVar;
        this.Rt = lVar;
        this.Sq = new a(lVar.oR() + 14, 262144);
    }

    public boolean A(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void z(Object obj) {
        Message obtainMessage = this.RV.obtainMessage();
        obtainMessage.obj = obj;
        this.RV.sendMessage(obtainMessage);
    }

    private String pd() {
        byte[] bArr = new byte[16];
        this.Sp.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.Sq.write("GET " + str + " HTTP/1.1");
        this.Sq.ox();
        this.Sq.write("Host: " + bVar.mHost);
        this.Sq.ox();
        this.Sq.write("Upgrade: WebSocket");
        this.Sq.ox();
        this.Sq.write("Connection: Upgrade");
        this.Sq.ox();
        this.Sq.write("Sec-WebSocket-Key: " + pd());
        this.Sq.ox();
        if (this.Rt != null && this.Rt.oY() != null && this.Rt.oY().length() > 0) {
            this.Sq.write("Sec-WebSocket-Extensions: " + this.Rt.oY());
            this.Sq.ox();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.Sq.write("Origin: " + bVar.mOrigin);
            this.Sq.ox();
        }
        if (bVar.RB != null && bVar.RB.length > 0) {
            this.Sq.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.RB.length; i++) {
                this.Sq.write(bVar.RB[i]);
                this.Sq.write(", ");
            }
            this.Sq.ox();
        }
        this.Sq.write("Sec-WebSocket-Version: 13");
        this.Sq.ox();
        if (bVar.RC != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.RC) {
                this.Sq.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.Sq.ox();
            }
        }
        this.Sq.ox();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.mReason != null && !cVar.mReason.equals("")) {
                byte[] bytes = cVar.mReason.getBytes("UTF-8");
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
        if (jVar.RA != null && jVar.RA.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.RA);
    }

    private void a(k.C0024k c0024k) throws IOException, WebSocketException {
        if (c0024k.RA != null && c0024k.RA.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0024k.RA);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.RG.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.Rt.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.RA.length > this.Rt.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.RA);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.RJ.getBytes("UTF-8");
        if (bytes.length > this.Rt.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.RA.length > this.Rt.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.RA);
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
        this.Sq.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.Rt.oX()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Sq.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Sq.write((byte) (b2 | 126));
            this.Sq.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Sq.write((byte) (b2 | Byte.MAX_VALUE));
            this.Sq.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Rt.oX()) {
            this.Sq.write(0);
            this.Sq.write(0);
            this.Sq.write(0);
            this.Sq.write(0);
        }
        if (j > 0) {
            if (this.Rt.oX()) {
            }
            this.Sq.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).RG;
                }
                this.Sq.ov();
                if (!B(message.obj)) {
                    z(new k.n(cVar));
                    return;
                }
                this.Sq.ou();
                if (cVar != null) {
                    z(new k.r(cVar));
                }
                while (this.Sq.ow() > 0) {
                    if (this.Rl == null) {
                        z(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Rl.write(this.Sq.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            Sr += write;
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
            this.Rl.close();
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
        } else if (obj instanceof k.C0024k) {
            a((k.C0024k) obj);
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

    public void oG() {
        synchronized (o.class) {
            Sr = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Sr;
        }
        return j;
    }
}
