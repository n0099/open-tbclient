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
    private static long IL = 0;
    private final e.a HB;
    private final l HJ;
    private final Random IJ;
    private final a IK;
    private final Handler Io;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.IJ = new Random();
        this.mLooper = looper;
        this.Io = handler;
        this.HB = aVar;
        this.HJ = lVar;
        this.IK = new a(lVar.lY() + 14, 262144);
    }

    public boolean x(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void w(Object obj) {
        Message obtainMessage = this.Io.obtainMessage();
        obtainMessage.obj = obj;
        this.Io.sendMessage(obtainMessage);
    }

    private String mj() {
        byte[] bArr = new byte[16];
        this.IJ.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.IK.write("GET " + str + " HTTP/1.1");
        this.IK.lD();
        this.IK.write("Host: " + bVar.HR);
        this.IK.lD();
        this.IK.write("Upgrade: WebSocket");
        this.IK.lD();
        this.IK.write("Connection: Upgrade");
        this.IK.lD();
        this.IK.write("Sec-WebSocket-Key: " + mj());
        this.IK.lD();
        if (this.HJ != null && this.HJ.me() != null && this.HJ.me().length() > 0) {
            this.IK.write("Sec-WebSocket-Extensions: " + this.HJ.me());
            this.IK.lD();
        }
        if (bVar.HS != null && !bVar.HS.equals("")) {
            this.IK.write("Origin: " + bVar.HS);
            this.IK.lD();
        }
        if (bVar.HU != null && bVar.HU.length > 0) {
            this.IK.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.HU.length; i++) {
                this.IK.write(bVar.HU[i]);
                this.IK.write(", ");
            }
            this.IK.lD();
        }
        this.IK.write("Sec-WebSocket-Version: 13");
        this.IK.lD();
        if (bVar.HV != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.HV) {
                this.IK.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.IK.lD();
            }
        }
        this.IK.lD();
    }

    private void a(k.c cVar) throws IOException, WebSocketException {
        byte[] bArr;
        if (cVar.mCode > 0) {
            if (cVar.HW != null && !cVar.HW.equals("")) {
                byte[] bytes = cVar.HW.getBytes(HTTP.UTF_8);
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
        if (jVar.HQ != null && jVar.HQ.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.HQ);
    }

    private void a(k.C0019k c0019k) throws IOException, WebSocketException {
        if (c0019k.HQ != null && c0019k.HQ.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0019k.HQ);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] lE = iVar.Ia.lE();
        if (lE == null) {
            return false;
        }
        if (lE.length > this.HJ.lZ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, lE);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.HQ.length > this.HJ.lZ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.HQ);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.If.getBytes(HTTP.UTF_8);
        if (bytes.length > this.HJ.lZ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.HQ.length > this.HJ.lZ()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.HQ);
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
        this.IK.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.HJ.md()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.IK.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.IK.write((byte) (b2 | 126));
            this.IK.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.IK.write((byte) (b2 | Byte.MAX_VALUE));
            this.IK.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.HJ.md()) {
            this.IK.write(0);
            this.IK.write(0);
            this.IK.write(0);
            this.IK.write(0);
        }
        if (j > 0) {
            if (this.HJ.md()) {
            }
            this.IK.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).Ia;
                }
                this.IK.clear();
                if (!y(message.obj)) {
                    w(new k.n(cVar));
                    return;
                }
                this.IK.flip();
                if (cVar != null) {
                    w(new k.r(cVar));
                }
                while (this.IK.remaining() > 0) {
                    if (this.HB == null) {
                        w(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.HB.write(this.IK.getBuffer());
                    if (write > 0) {
                        synchronized (o.class) {
                            IL += write;
                        }
                    }
                }
                if (cVar != null) {
                    w(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            w(new k.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            w(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.HB.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean y(Object obj) throws IOException, WebSocketException {
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
            v(obj);
        }
        return true;
    }

    protected void v(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void lN() {
        synchronized (o.class) {
            IL = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = IL;
        }
        return j;
    }
}
