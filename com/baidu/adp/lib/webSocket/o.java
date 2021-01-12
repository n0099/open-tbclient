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
    private static long Ss = 0;
    private final Handler RW;
    private final e.a Rm;
    private final l Ru;
    private final Random Sq;
    private final a Sr;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.Sq = new Random();
        this.mLooper = looper;
        this.RW = handler;
        this.Rm = aVar;
        this.Ru = lVar;
        this.Sr = new a(lVar.os() + 14, 262144);
    }

    public boolean w(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void v(Object obj) {
        Message obtainMessage = this.RW.obtainMessage();
        obtainMessage.obj = obj;
        this.RW.sendMessage(obtainMessage);
    }

    private String oE() {
        byte[] bArr = new byte[16];
        this.Sq.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.Sr.write("GET " + str + " HTTP/1.1");
        this.Sr.nY();
        this.Sr.write("Host: " + bVar.mHost);
        this.Sr.nY();
        this.Sr.write("Upgrade: WebSocket");
        this.Sr.nY();
        this.Sr.write("Connection: Upgrade");
        this.Sr.nY();
        this.Sr.write("Sec-WebSocket-Key: " + oE());
        this.Sr.nY();
        if (this.Ru != null && this.Ru.oz() != null && this.Ru.oz().length() > 0) {
            this.Sr.write("Sec-WebSocket-Extensions: " + this.Ru.oz());
            this.Sr.nY();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.Sr.write("Origin: " + bVar.mOrigin);
            this.Sr.nY();
        }
        if (bVar.RC != null && bVar.RC.length > 0) {
            this.Sr.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.RC.length; i++) {
                this.Sr.write(bVar.RC[i]);
                this.Sr.write(", ");
            }
            this.Sr.nY();
        }
        this.Sr.write("Sec-WebSocket-Version: 13");
        this.Sr.nY();
        if (bVar.RD != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.RD) {
                this.Sr.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.Sr.nY();
            }
        }
        this.Sr.nY();
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
        if (jVar.RB != null && jVar.RB.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.RB);
    }

    private void a(k.C0019k c0019k) throws IOException, WebSocketException {
        if (c0019k.RB != null && c0019k.RB.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0019k.RB);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.RH.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.Ru.ot()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.RB.length > this.Ru.ot()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.RB);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.RK.getBytes("UTF-8");
        if (bytes.length > this.Ru.ot()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.RB.length > this.Ru.ot()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.RB);
    }

    protected void a(int i, boolean z, byte[] bArr) throws IOException {
        if (bArr != null) {
            a(i, z, bArr, 0, bArr.length);
        } else {
            a(i, z, null, 0, 0);
        }
    }

    protected void a(int i, boolean z, byte[] bArr, int i2, int i3) throws IOException {
        byte b2 = 0;
        if (z) {
            b2 = (byte) (-128);
        }
        this.Sr.write((byte) (b2 | ((byte) i)));
        byte b3 = 0;
        if (this.Ru.oy()) {
            b3 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.Sr.write((byte) (b3 | ((byte) j)));
        } else if (j <= 65535) {
            this.Sr.write((byte) (b3 | 126));
            this.Sr.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.Sr.write((byte) (b3 | Byte.MAX_VALUE));
            this.Sr.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.Ru.oy()) {
            this.Sr.write(0);
            this.Sr.write(0);
            this.Sr.write(0);
            this.Sr.write(0);
        }
        if (j > 0) {
            if (this.Ru.oy()) {
            }
            this.Sr.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).RH;
                }
                this.Sr.nW();
                if (!x(message.obj)) {
                    v(new k.n(cVar));
                    return;
                }
                this.Sr.nV();
                if (cVar != null) {
                    v(new k.r(cVar));
                }
                while (this.Sr.nX() > 0) {
                    if (this.Rm == null) {
                        v(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.Rm.write(this.Sr.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            Ss += write;
                        }
                    }
                }
                if (cVar != null) {
                    v(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            v(new k.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            v(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.Rm.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean x(Object obj) throws IOException, WebSocketException {
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
        } else if (obj instanceof k.C0019k) {
            a((k.C0019k) obj);
        } else if (obj instanceof k.c) {
            a((k.c) obj);
        } else if (obj instanceof k.b) {
            a((k.b) obj);
        } else {
            u(obj);
        }
        return true;
    }

    protected void u(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oh() {
        synchronized (o.class) {
            Ss = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = Ss;
        }
        return j;
    }
}
