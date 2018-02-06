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
    private static long apb = 0;
    private final e.a anS;
    private final Handler aoF;
    private final Random aoZ;
    private final l aoa;
    private final a apa;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.aoZ = new Random();
        this.mLooper = looper;
        this.aoF = handler;
        this.anS = aVar;
        this.aoa = lVar;
        this.apa = new a(lVar.pL() + 14, 262144);
    }

    public boolean ay(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void ax(Object obj) {
        Message obtainMessage = this.aoF.obtainMessage();
        obtainMessage.obj = obj;
        this.aoF.sendMessage(obtainMessage);
    }

    private String pW() {
        byte[] bArr = new byte[16];
        this.aoZ.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.aoj != null) {
            str = bVar.mPath + "?" + bVar.aoj;
        } else {
            str = bVar.mPath;
        }
        this.apa.write("GET " + str + " HTTP/1.1");
        this.apa.pp();
        this.apa.write("Host: " + bVar.aoi);
        this.apa.pp();
        this.apa.write("Upgrade: WebSocket");
        this.apa.pp();
        this.apa.write("Connection: Upgrade");
        this.apa.pp();
        this.apa.write("Sec-WebSocket-Key: " + pW());
        this.apa.pp();
        if (this.aoa != null && this.aoa.pR() != null && this.aoa.pR().length() > 0) {
            this.apa.write("Sec-WebSocket-Extensions: " + this.aoa.pR());
            this.apa.pp();
        }
        if (bVar.aok != null && !bVar.aok.equals("")) {
            this.apa.write("Origin: " + bVar.aok);
            this.apa.pp();
        }
        if (bVar.aol != null && bVar.aol.length > 0) {
            this.apa.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.aol.length; i++) {
                this.apa.write(bVar.aol[i]);
                this.apa.write(", ");
            }
            this.apa.pp();
        }
        this.apa.write("Sec-WebSocket-Version: 13");
        this.apa.pp();
        if (bVar.aom != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.aom) {
                this.apa.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.apa.pp();
            }
        }
        this.apa.pp();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.aon != null && !cVar.aon.equals("")) {
                byte[] bytes = cVar.aon.getBytes("UTF-8");
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
        if (jVar.aoh != null && jVar.aoh.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.aoh);
    }

    private void a(k.C0021k c0021k) throws IOException, WebSocketException {
        if (c0021k.aoh != null && c0021k.aoh.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0021k.aoh);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] pq = iVar.aor.pq();
        if (pq == null) {
            return false;
        }
        if (pq.length > this.aoa.pM()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, pq);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.aoh.length > this.aoa.pM()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.aoh);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.aow.getBytes("UTF-8");
        if (bytes.length > this.aoa.pM()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.aoh.length > this.aoa.pM()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.aoh);
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
        this.apa.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.aoa.pQ()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.apa.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.apa.write((byte) (b2 | 126));
            this.apa.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.apa.write((byte) (b2 | Byte.MAX_VALUE));
            this.apa.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.aoa.pQ()) {
            this.apa.write(0);
            this.apa.write(0);
            this.apa.write(0);
            this.apa.write(0);
        }
        if (j > 0) {
            if (this.aoa.pQ()) {
            }
            this.apa.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).aor;
                }
                this.apa.clear();
                if (!az(message.obj)) {
                    ax(new k.n(cVar));
                    return;
                }
                this.apa.flip();
                if (cVar != null) {
                    ax(new k.r(cVar));
                }
                while (this.apa.remaining() > 0) {
                    if (this.anS == null) {
                        ax(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.anS.write(this.apa.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            apb += write;
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
            if (pz()) {
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
            this.anS.close();
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

    private boolean pz() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void pA() {
        synchronized (o.class) {
            apb = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = apb;
        }
        return j;
    }
}
