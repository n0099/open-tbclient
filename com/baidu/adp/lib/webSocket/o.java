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
    private static long wu = 0;
    private final Looper mLooper;
    private final Handler vW;
    private final e.a vo;
    private final l vx;
    private final Random ws;
    private final a wt;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.ws = new Random();
        this.mLooper = looper;
        this.vW = handler;
        this.vo = aVar;
        this.vx = lVar;
        this.wt = new a(lVar.iq() + 14, 262144);
    }

    public boolean v(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void u(Object obj) {
        Message obtainMessage = this.vW.obtainMessage();
        obtainMessage.obj = obj;
        this.vW.sendMessage(obtainMessage);
    }

    private String iB() {
        byte[] bArr = new byte[16];
        this.ws.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.wt.write("GET " + str + " HTTP/1.1");
        this.wt.hV();
        this.wt.write("Host: " + bVar.mHost);
        this.wt.hV();
        this.wt.write("Upgrade: WebSocket");
        this.wt.hV();
        this.wt.write("Connection: Upgrade");
        this.wt.hV();
        this.wt.write("Sec-WebSocket-Key: " + iB());
        this.wt.hV();
        if (this.vx != null && this.vx.iw() != null && this.vx.iw().length() > 0) {
            this.wt.write("Sec-WebSocket-Extensions: " + this.vx.iw());
            this.wt.hV();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.wt.write("Origin: " + bVar.mOrigin);
            this.wt.hV();
        }
        if (bVar.vF != null && bVar.vF.length > 0) {
            this.wt.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.vF.length; i++) {
                this.wt.write(bVar.vF[i]);
                this.wt.write(", ");
            }
            this.wt.hV();
        }
        this.wt.write("Sec-WebSocket-Version: 13");
        this.wt.hV();
        if (bVar.vG != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.vG) {
                this.wt.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.wt.hV();
            }
        }
        this.wt.hV();
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
        if (jVar.vE != null && jVar.vE.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.vE);
    }

    private void a(k.C0021k c0021k) throws IOException, WebSocketException {
        if (c0021k.vE != null && c0021k.vE.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0021k.vE);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.vK.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.vx.ir()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.vE.length > this.vx.ir()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.vE);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.vN.getBytes("UTF-8");
        if (bytes.length > this.vx.ir()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.vE.length > this.vx.ir()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.vE);
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
        this.wt.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.vx.iv()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.wt.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.wt.write((byte) (b2 | 126));
            this.wt.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.wt.write((byte) (b2 | Byte.MAX_VALUE));
            this.wt.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.vx.iv()) {
            this.wt.write(0);
            this.wt.write(0);
            this.wt.write(0);
            this.wt.write(0);
        }
        if (j > 0) {
            if (this.vx.iv()) {
            }
            this.wt.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).vK;
                }
                this.wt.hT();
                if (!w(message.obj)) {
                    u(new k.n(cVar));
                    return;
                }
                this.wt.hS();
                if (cVar != null) {
                    u(new k.r(cVar));
                }
                while (this.wt.hU() > 0) {
                    if (this.vo == null) {
                        u(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.vo.write(this.wt.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            wu += write;
                        }
                    }
                }
                if (cVar != null) {
                    u(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            u(new k.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            u(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.vo.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean w(Object obj) throws IOException, WebSocketException {
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
        } else if (obj instanceof k.C0021k) {
            a((k.C0021k) obj);
        } else if (obj instanceof k.c) {
            a((k.c) obj);
        } else if (obj instanceof k.b) {
            a((k.b) obj);
        } else {
            t(obj);
        }
        return true;
    }

    protected void t(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void ie() {
        synchronized (o.class) {
            wu = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = wu;
        }
        return j;
    }
}
