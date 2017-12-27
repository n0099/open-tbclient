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
    private static long apa = 0;
    private final e.a anR;
    private final l anZ;
    private final Handler aoE;
    private final Random aoY;
    private final a aoZ;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.aoY = new Random();
        this.mLooper = looper;
        this.aoE = handler;
        this.anR = aVar;
        this.anZ = lVar;
        this.aoZ = new a(lVar.pK() + 14, 262144);
    }

    public boolean ay(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void ax(Object obj) {
        Message obtainMessage = this.aoE.obtainMessage();
        obtainMessage.obj = obj;
        this.aoE.sendMessage(obtainMessage);
    }

    private String pV() {
        byte[] bArr = new byte[16];
        this.aoY.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.aoi != null) {
            str = bVar.mPath + "?" + bVar.aoi;
        } else {
            str = bVar.mPath;
        }
        this.aoZ.write("GET " + str + " HTTP/1.1");
        this.aoZ.po();
        this.aoZ.write("Host: " + bVar.aoh);
        this.aoZ.po();
        this.aoZ.write("Upgrade: WebSocket");
        this.aoZ.po();
        this.aoZ.write("Connection: Upgrade");
        this.aoZ.po();
        this.aoZ.write("Sec-WebSocket-Key: " + pV());
        this.aoZ.po();
        if (this.anZ != null && this.anZ.pQ() != null && this.anZ.pQ().length() > 0) {
            this.aoZ.write("Sec-WebSocket-Extensions: " + this.anZ.pQ());
            this.aoZ.po();
        }
        if (bVar.aoj != null && !bVar.aoj.equals("")) {
            this.aoZ.write("Origin: " + bVar.aoj);
            this.aoZ.po();
        }
        if (bVar.aok != null && bVar.aok.length > 0) {
            this.aoZ.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.aok.length; i++) {
                this.aoZ.write(bVar.aok[i]);
                this.aoZ.write(", ");
            }
            this.aoZ.po();
        }
        this.aoZ.write("Sec-WebSocket-Version: 13");
        this.aoZ.po();
        if (bVar.aol != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.aol) {
                this.aoZ.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.aoZ.po();
            }
        }
        this.aoZ.po();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.aom != null && !cVar.aom.equals("")) {
                byte[] bytes = cVar.aom.getBytes(HTTP.UTF_8);
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
        if (jVar.aog != null && jVar.aog.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.aog);
    }

    private void a(k.C0021k c0021k) throws IOException, WebSocketException {
        if (c0021k.aog != null && c0021k.aog.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0021k.aog);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] pp = iVar.aoq.pp();
        if (pp == null) {
            return false;
        }
        if (pp.length > this.anZ.pL()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, pp);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.aog.length > this.anZ.pL()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.aog);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.aov.getBytes(HTTP.UTF_8);
        if (bytes.length > this.anZ.pL()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.aog.length > this.anZ.pL()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.aog);
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
        this.aoZ.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.anZ.pP()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.aoZ.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.aoZ.write((byte) (b2 | 126));
            this.aoZ.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.aoZ.write((byte) (b2 | Byte.MAX_VALUE));
            this.aoZ.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.anZ.pP()) {
            this.aoZ.write(0);
            this.aoZ.write(0);
            this.aoZ.write(0);
            this.aoZ.write(0);
        }
        if (j > 0) {
            if (this.anZ.pP()) {
            }
            this.aoZ.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).aoq;
                }
                this.aoZ.clear();
                if (!az(message.obj)) {
                    ax(new k.n(cVar));
                    return;
                }
                this.aoZ.flip();
                if (cVar != null) {
                    ax(new k.r(cVar));
                }
                while (this.aoZ.remaining() > 0) {
                    if (this.anR == null) {
                        ax(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.anR.write(this.aoZ.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            apa += write;
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
            this.anR.close();
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
            apa = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = apa;
        }
        return j;
    }
}
