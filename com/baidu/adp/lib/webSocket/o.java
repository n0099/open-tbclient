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
    private static long Rw = 0;
    private final e.a Qq;
    private final l Qy;
    private final Handler Ra;
    private final Random Ru;
    private final a Rv;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Ru = new Random();
        this.mLooper = looper;
        this.Ra = handler;
        this.Qq = aVar;
        this.Qy = lVar;
        this.Rv = new a(lVar.oR() + 14, 262144);
    }

    public boolean A(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void z(Object obj) {
        Message obtainMessage = this.Ra.obtainMessage();
        obtainMessage.obj = obj;
        this.Ra.sendMessage(obtainMessage);
    }

    private String pc() {
        byte[] bArr = new byte[16];
        this.Ru.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.Rv.write("GET " + str + " HTTP/1.1");
        this.Rv.oy();
        this.Rv.write("Host: " + bVar.mHost);
        this.Rv.oy();
        this.Rv.write("Upgrade: WebSocket");
        this.Rv.oy();
        this.Rv.write("Connection: Upgrade");
        this.Rv.oy();
        this.Rv.write("Sec-WebSocket-Key: " + pc());
        this.Rv.oy();
        if (this.Qy != null && this.Qy.oX() != null && this.Qy.oX().length() > 0) {
            this.Rv.write("Sec-WebSocket-Extensions: " + this.Qy.oX());
            this.Rv.oy();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.Rv.write("Origin: " + bVar.mOrigin);
            this.Rv.oy();
        }
        if (bVar.QH != null && bVar.QH.length > 0) {
            this.Rv.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.QH.length; i++) {
                this.Rv.write(bVar.QH[i]);
                this.Rv.write(", ");
            }
            this.Rv.oy();
        }
        this.Rv.write("Sec-WebSocket-Version: 13");
        this.Rv.oy();
        if (bVar.QI != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.QI) {
                this.Rv.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.Rv.oy();
            }
        }
        this.Rv.oy();
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
        if (jVar.QG != null && jVar.QG.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.QG);
    }

    private void a(k.C0024k c0024k) throws IOException, WebSocketException {
        if (c0024k.QG != null && c0024k.QG.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0024k.QG);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.QM.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.Qy.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.QG.length > this.Qy.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.QG);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.QR.getBytes("UTF-8");
        if (bytes.length > this.Qy.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.QG.length > this.Qy.oS()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.QG);
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
        this.Rv.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.Qy.oW()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Rv.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.Rv.write((byte) (b2 | 126));
            this.Rv.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Rv.write((byte) (b2 | Byte.MAX_VALUE));
            this.Rv.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Qy.oW()) {
            this.Rv.write(0);
            this.Rv.write(0);
            this.Rv.write(0);
            this.Rv.write(0);
        }
        if (j > 0) {
            if (this.Qy.oW()) {
            }
            this.Rv.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).QM;
                }
                this.Rv.ow();
                if (!B(message.obj)) {
                    z(new k.n(cVar));
                    return;
                }
                this.Rv.ov();
                if (cVar != null) {
                    z(new k.r(cVar));
                }
                while (this.Rv.ox() > 0) {
                    if (this.Qq == null) {
                        z(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Qq.write(this.Rv.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            Rw += write;
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
            this.Qq.close();
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
            Rw = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Rw;
        }
        return j;
    }
}
