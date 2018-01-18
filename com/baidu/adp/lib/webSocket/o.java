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
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class o extends Handler {
    private static long aoZ = 0;
    private final e.a anQ;
    private final l anY;
    private final Handler aoD;
    private final Random aoX;
    private final a aoY;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.aoX = new Random();
        this.mLooper = looper;
        this.aoD = handler;
        this.anQ = aVar;
        this.anY = lVar;
        this.aoY = new a(lVar.pK() + 14, 262144);
    }

    public boolean ay(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void ax(Object obj) {
        Message obtainMessage = this.aoD.obtainMessage();
        obtainMessage.obj = obj;
        this.aoD.sendMessage(obtainMessage);
    }

    private String pV() {
        byte[] bArr = new byte[16];
        this.aoX.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.aoh != null) {
            str = bVar.mPath + "?" + bVar.aoh;
        } else {
            str = bVar.mPath;
        }
        this.aoY.write("GET " + str + " HTTP/1.1");
        this.aoY.po();
        this.aoY.write("Host: " + bVar.aog);
        this.aoY.po();
        this.aoY.write("Upgrade: WebSocket");
        this.aoY.po();
        this.aoY.write("Connection: Upgrade");
        this.aoY.po();
        this.aoY.write("Sec-WebSocket-Key: " + pV());
        this.aoY.po();
        if (this.anY != null && this.anY.pQ() != null && this.anY.pQ().length() > 0) {
            this.aoY.write("Sec-WebSocket-Extensions: " + this.anY.pQ());
            this.aoY.po();
        }
        if (bVar.aoi != null && !bVar.aoi.equals("")) {
            this.aoY.write("Origin: " + bVar.aoi);
            this.aoY.po();
        }
        if (bVar.aoj != null && bVar.aoj.length > 0) {
            this.aoY.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.aoj.length; i++) {
                this.aoY.write(bVar.aoj[i]);
                this.aoY.write(", ");
            }
            this.aoY.po();
        }
        this.aoY.write("Sec-WebSocket-Version: 13");
        this.aoY.po();
        if (bVar.aok != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.aok) {
                this.aoY.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.aoY.po();
            }
        }
        this.aoY.po();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.aol != null && !cVar.aol.equals("")) {
                byte[] bytes = cVar.aol.getBytes(HTTP.UTF_8);
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
        if (jVar.aof != null && jVar.aof.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.aof);
    }

    private void a(k.C0021k c0021k) throws IOException, WebSocketException {
        if (c0021k.aof != null && c0021k.aof.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0021k.aof);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] pp = iVar.aop.pp();
        if (pp == null) {
            return false;
        }
        if (pp.length > this.anY.pL()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, pp);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.aof.length > this.anY.pL()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.aof);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.aou.getBytes(HTTP.UTF_8);
        if (bytes.length > this.anY.pL()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.aof.length > this.anY.pL()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.aof);
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
        this.aoY.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.anY.pP()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.aoY.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.aoY.write((byte) (b2 | 126));
            this.aoY.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.aoY.write((byte) (b2 | Byte.MAX_VALUE));
            this.aoY.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.anY.pP()) {
            this.aoY.write(0);
            this.aoY.write(0);
            this.aoY.write(0);
            this.aoY.write(0);
        }
        if (j > 0) {
            if (this.anY.pP()) {
            }
            this.aoY.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).aop;
                }
                this.aoY.clear();
                if (!az(message.obj)) {
                    ax(new k.n(cVar));
                    return;
                }
                this.aoY.flip();
                if (cVar != null) {
                    ax(new k.r(cVar));
                }
                while (this.aoY.remaining() > 0) {
                    if (this.anQ == null) {
                        ax(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.anQ.write(this.aoY.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            aoZ += write;
                        }
                    }
                }
                if (cVar != null) {
                    ax(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            ax(new k.d(e));
        } catch (Exception e2) {
            if (py()) {
                e2.printStackTrace();
            }
            ax(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.anQ.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean az(Object obj) throws IOException, WebSocketException {
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
            aw(obj);
        }
        return true;
    }

    protected void aw(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean py() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pz() {
        synchronized (o.class) {
            aoZ = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = aoZ;
        }
        return j;
    }
}
