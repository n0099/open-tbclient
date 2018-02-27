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
    private static long aoV = 0;
    private final e.a anM;
    private final l anU;
    private final Random aoT;
    private final a aoU;
    private final Handler aoz;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.aoT = new Random();
        this.mLooper = looper;
        this.aoz = handler;
        this.anM = aVar;
        this.anU = lVar;
        this.aoU = new a(lVar.pL() + 14, 262144);
    }

    public boolean ay(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void ax(Object obj) {
        Message obtainMessage = this.aoz.obtainMessage();
        obtainMessage.obj = obj;
        this.aoz.sendMessage(obtainMessage);
    }

    private String pW() {
        byte[] bArr = new byte[16];
        this.aoT.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.aod != null) {
            str = bVar.mPath + "?" + bVar.aod;
        } else {
            str = bVar.mPath;
        }
        this.aoU.write("GET " + str + " HTTP/1.1");
        this.aoU.pp();
        this.aoU.write("Host: " + bVar.aoc);
        this.aoU.pp();
        this.aoU.write("Upgrade: WebSocket");
        this.aoU.pp();
        this.aoU.write("Connection: Upgrade");
        this.aoU.pp();
        this.aoU.write("Sec-WebSocket-Key: " + pW());
        this.aoU.pp();
        if (this.anU != null && this.anU.pR() != null && this.anU.pR().length() > 0) {
            this.aoU.write("Sec-WebSocket-Extensions: " + this.anU.pR());
            this.aoU.pp();
        }
        if (bVar.aoe != null && !bVar.aoe.equals("")) {
            this.aoU.write("Origin: " + bVar.aoe);
            this.aoU.pp();
        }
        if (bVar.aof != null && bVar.aof.length > 0) {
            this.aoU.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.aof.length; i++) {
                this.aoU.write(bVar.aof[i]);
                this.aoU.write(", ");
            }
            this.aoU.pp();
        }
        this.aoU.write("Sec-WebSocket-Version: 13");
        this.aoU.pp();
        if (bVar.aog != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.aog) {
                this.aoU.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.aoU.pp();
            }
        }
        this.aoU.pp();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.aoh != null && !cVar.aoh.equals("")) {
                byte[] bytes = cVar.aoh.getBytes("UTF-8");
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
        if (jVar.aob != null && jVar.aob.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.aob);
    }

    private void a(k.C0021k c0021k) throws IOException, WebSocketException {
        if (c0021k.aob != null && c0021k.aob.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0021k.aob);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] pq = iVar.aol.pq();
        if (pq == null) {
            return false;
        }
        if (pq.length > this.anU.pM()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, pq);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.aob.length > this.anU.pM()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.aob);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.aoq.getBytes("UTF-8");
        if (bytes.length > this.anU.pM()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.aob.length > this.anU.pM()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.aob);
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
        this.aoU.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.anU.pQ()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.aoU.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.aoU.write((byte) (b2 | 126));
            this.aoU.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.aoU.write((byte) (b2 | Byte.MAX_VALUE));
            this.aoU.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.anU.pQ()) {
            this.aoU.write(0);
            this.aoU.write(0);
            this.aoU.write(0);
            this.aoU.write(0);
        }
        if (j > 0) {
            if (this.anU.pQ()) {
            }
            this.aoU.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).aol;
                }
                this.aoU.clear();
                if (!az(message.obj)) {
                    ax(new k.n(cVar));
                    return;
                }
                this.aoU.flip();
                if (cVar != null) {
                    ax(new k.r(cVar));
                }
                while (this.aoU.remaining() > 0) {
                    if (this.anM == null) {
                        ax(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.anM.write(this.aoU.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            aoV += write;
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
            this.anM.close();
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
            aoV = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = aoV;
        }
        return j;
    }
}
