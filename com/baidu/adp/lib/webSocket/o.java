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
    private static long QM = 0;
    private final e.a PD;
    private final l PN;
    private final Random QK;
    private final a QL;
    private final Handler Qp;
    private final Looper mLooper;

    public o(Looper looper, Handler handler, e.a aVar, l lVar) {
        super(looper);
        this.QK = new Random();
        this.mLooper = looper;
        this.Qp = handler;
        this.PD = aVar;
        this.PN = lVar;
        this.QL = new a(lVar.oM() + 14, 262144);
    }

    public boolean z(Object obj) {
        Message obtainMessage = obtainMessage();
        obtainMessage.obj = obj;
        return sendMessage(obtainMessage);
    }

    private void y(Object obj) {
        Message obtainMessage = this.Qp.obtainMessage();
        obtainMessage.obj = obj;
        this.Qp.sendMessage(obtainMessage);
    }

    private String oX() {
        byte[] bArr = new byte[16];
        this.QK.nextBytes(bArr);
        return com.baidu.adp.lib.util.c.encodeBytes(bArr);
    }

    private void a(k.b bVar) throws IOException {
        String str;
        if (bVar.mQuery != null) {
            str = bVar.mPath + "?" + bVar.mQuery;
        } else {
            str = bVar.mPath;
        }
        this.QL.write("GET " + str + " HTTP/1.1");
        this.QL.ot();
        this.QL.write("Host: " + bVar.mHost);
        this.QL.ot();
        this.QL.write("Upgrade: WebSocket");
        this.QL.ot();
        this.QL.write("Connection: Upgrade");
        this.QL.ot();
        this.QL.write("Sec-WebSocket-Key: " + oX());
        this.QL.ot();
        if (this.PN != null && this.PN.oS() != null && this.PN.oS().length() > 0) {
            this.QL.write("Sec-WebSocket-Extensions: " + this.PN.oS());
            this.QL.ot();
        }
        if (bVar.mOrigin != null && !bVar.mOrigin.equals("")) {
            this.QL.write("Origin: " + bVar.mOrigin);
            this.QL.ot();
        }
        if (bVar.PW != null && bVar.PW.length > 0) {
            this.QL.write("Sec-WebSocket-Protocol: ");
            for (int i = 0; i < bVar.PW.length; i++) {
                this.QL.write(bVar.PW[i]);
                this.QL.write(", ");
            }
            this.QL.ot();
        }
        this.QL.write("Sec-WebSocket-Version: 13");
        this.QL.ot();
        if (bVar.PY != null) {
            for (BasicNameValuePair basicNameValuePair : bVar.PY) {
                this.QL.write(basicNameValuePair.getName() + ":" + basicNameValuePair.getValue());
                this.QL.ot();
            }
        }
        this.QL.ot();
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
        if (jVar.PV != null && jVar.PV.length > 125) {
            throw new WebSocketException("ping payload exceeds 125 octets");
        }
        a(9, true, jVar.PV);
    }

    private void a(k.C0022k c0022k) throws IOException, WebSocketException {
        if (c0022k.PV != null && c0022k.PV.length > 125) {
            throw new WebSocketException("pong payload exceeds 125 octets");
        }
        a(10, true, c0022k.PV);
    }

    private boolean a(k.i iVar) throws IOException, WebSocketException {
        byte[] binaryData = iVar.Qc.getBinaryData();
        if (binaryData == null) {
            return false;
        }
        if (binaryData.length > this.PN.oN()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, binaryData);
        return true;
    }

    private void c(k.a aVar) throws IOException, WebSocketException {
        if (aVar.PV.length > this.PN.oN()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(2, true, aVar.PV);
    }

    private void a(k.s sVar) throws IOException, WebSocketException {
        byte[] bytes = sVar.Qg.getBytes("UTF-8");
        if (bytes.length > this.PN.oN()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, bytes);
    }

    private void a(k.m mVar) throws IOException, WebSocketException {
        if (mVar.PV.length > this.PN.oN()) {
            throw new WebSocketException("message payload exceeds payload limit");
        }
        a(1, true, mVar.PV);
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
        this.QL.write((byte) (b | ((byte) i)));
        byte b2 = 0;
        if (this.PN.oR()) {
            b2 = Byte.MIN_VALUE;
        }
        long j = i3;
        if (j <= 125) {
            this.QL.write((byte) (b2 | ((byte) j)));
        } else if (j <= 65535) {
            this.QL.write((byte) (b2 | 126));
            this.QL.write(new byte[]{(byte) ((j >> 8) & 255), (byte) (255 & j)});
        } else {
            this.QL.write((byte) (b2 | Byte.MAX_VALUE));
            this.QL.write(new byte[]{(byte) ((j >> 56) & 255), (byte) ((j >> 48) & 255), (byte) ((j >> 40) & 255), (byte) ((j >> 32) & 255), (byte) ((j >> 24) & 255), (byte) ((j >> 16) & 255), (byte) ((j >> 8) & 255), (byte) (255 & j)});
        }
        if (this.PN.oR()) {
            this.QL.write(0);
            this.QL.write(0);
            this.QL.write(0);
            this.QL.write(0);
        }
        if (j > 0) {
            if (this.PN.oR()) {
            }
            this.QL.write(bArr, i2, i3);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                c cVar = null;
                if (message.obj instanceof k.i) {
                    cVar = ((k.i) message.obj).Qc;
                }
                this.QL.or();
                if (!A(message.obj)) {
                    y(new k.n(cVar));
                    return;
                }
                this.QL.oq();
                if (cVar != null) {
                    y(new k.r(cVar));
                }
                while (this.QL.os() > 0) {
                    if (this.PD == null) {
                        y(new k.d(new SocketException("write socket = null")));
                        return;
                    }
                    int write = this.PD.write(this.QL.op());
                    if (write > 0) {
                        synchronized (o.class) {
                            QM += write;
                        }
                    }
                }
                if (cVar != null) {
                    y(new k.g(cVar));
                }
            }
        } catch (SocketException e) {
            y(new k.d(e));
        } catch (Exception e2) {
            if (isDebug()) {
                e2.printStackTrace();
            }
            y(new k.f(e2));
        }
    }

    public void quit() {
        try {
            this.mLooper.quit();
        } catch (Exception e) {
        }
        try {
            this.PD.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected boolean A(Object obj) throws IOException, WebSocketException {
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
        } else if (obj instanceof k.C0022k) {
            a((k.C0022k) obj);
        } else if (obj instanceof k.c) {
            a((k.c) obj);
        } else if (obj instanceof k.b) {
            a((k.b) obj);
        } else {
            x(obj);
        }
        return true;
    }

    protected void x(Object obj) throws WebSocketException, IOException {
        throw new WebSocketException("unknown message received by WebSocketWriter");
    }

    private boolean isDebug() {
        return BdBaseApplication.getInst().isDebugMode();
    }

    public void oB() {
        synchronized (o.class) {
            QM = 0L;
        }
    }

    public long getUpFlowSize() {
        long j;
        synchronized (o.class) {
            j = QM;
        }
        return j;
    }
}
