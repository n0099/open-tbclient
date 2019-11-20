package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.k;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class m extends Thread {
    private static long sT = 0;
    private int mState;
    private boolean mStopped;
    private final e.a rZ;
    private final Handler sQ;
    private final ByteBuffer sR;
    private final d sS;
    private boolean sU;
    private int sV;
    private a sW;
    private int sX;
    private final f sY;
    private int sZ;
    private final l sj;
    private long tb;
    private long tc;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int td;
        public boolean te;
        public int tf;
        public int tg;
        public int th;
        public int ti;
        public byte[] tj;
        public byte[] tk;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.sU = false;
        this.sY = new f();
        this.sZ = 0;
        this.tb = 0L;
        this.tc = 0L;
        this.sQ = handler;
        this.rZ = aVar;
        this.sj = lVar;
        this.sR = ByteBuffer.allocateDirect(lVar.hG() + 14);
        this.sS = new d(lVar.hH());
        this.sW = null;
        this.mState = 1;
    }

    protected void t(Object obj) {
        this.tb = 0L;
        this.tc = 0L;
        Message obtainMessage = this.sQ.obtainMessage();
        obtainMessage.obj = obj;
        this.sQ.sendMessage(obtainMessage);
    }

    private boolean hO() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.sW == null) {
            if (this.sR.position() >= 2) {
                byte b = this.sR.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.sR.get(1);
                boolean z2 = (b2 & 128) != 0;
                int i5 = b2 & Byte.MAX_VALUE;
                if (i3 != 0) {
                    throw new WebSocketException("RSV != 0 and no extension negotiated");
                }
                if (z2) {
                    throw new WebSocketException("masked server frame");
                }
                if (i4 > 7) {
                    if (!z) {
                        throw new WebSocketException("fragmented control frame");
                    }
                    if (i5 > 125) {
                        throw new WebSocketException("control frame with payload length > 125 octets");
                    }
                    if (i4 != 8 && i4 != 9 && i4 != 10) {
                        throw new WebSocketException("control frame using reserved opcode " + i4);
                    }
                    if (i4 == 8 && i5 == 1) {
                        throw new WebSocketException("received close control frame with payload len 1");
                    }
                } else if (i4 != 0 && i4 != 1 && i4 != 2) {
                    throw new WebSocketException("data frame using reserved opcode " + i4);
                } else {
                    if (!this.sU && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.sU && i4 != 0) {
                        throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                    }
                }
                if (i5 < 126) {
                    i2 = 2;
                } else if (i5 == 126) {
                    i2 = 4;
                } else if (i5 == 127) {
                    i2 = 10;
                } else {
                    throw new Exception("BdLogic error");
                }
                if (this.sR.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.sR.get(2) & 255) << 8) | (this.sR.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.sR.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.sR.get(2) & 255) << 56) | ((this.sR.get(3) & 255) << 48) | ((this.sR.get(4) & 255) << 40) | ((this.sR.get(5) & 255) << 32) | ((this.sR.get(6) & 255) << 24) | ((this.sR.get(7) & 255) << 16) | ((this.sR.get(8) & 255) << 8) | (this.sR.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.sW = new a();
                    this.sW.td = i4;
                    this.sW.te = z;
                    this.sW.tf = i3;
                    this.sW.th = (int) j;
                    this.sW.tg = i2;
                    this.sW.ti = this.sW.tg + this.sW.th;
                    this.sW.tj = null;
                    int position = this.sR.position();
                    this.sW.tk = new byte[this.sW.tg];
                    this.sR.position(0);
                    this.sR.get(this.sW.tk, 0, this.sW.tg);
                    this.sR.position(this.sW.tg);
                    this.sR.limit(position);
                    this.sR.compact();
                    return this.sW.th == 0 || this.sR.position() >= this.sW.th;
                }
                return false;
            }
            return false;
        } else if (this.sX >= this.sW.th) {
            if (this.sW.td > 7) {
                if (this.sW.td == 8) {
                    if (this.sW.th < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.sW.tk[1] & 255) + ((this.sW.tk[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.sW.th > 2) {
                            byte[] bArr2 = new byte[this.sW.th - 2];
                            System.arraycopy(this.sW.tk, 2, bArr2, 0, this.sW.th - 2);
                            f fVar = new f();
                            fVar.h(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, HTTP.UTF_8);
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.sW.td == 9) {
                    j(this.sS.toByteArray());
                } else if (this.sW.td == 10) {
                    k(this.sS.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.sU) {
                    this.sU = true;
                    this.sV = this.sW.td;
                    if (this.sV == 1 && this.sj.hL()) {
                        this.sY.reset();
                    }
                }
                if (this.sV == 1 && this.sj.hL() && !this.sY.h(this.sS.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.sW.te) {
                    if (this.sV == 1) {
                        if (this.sj.hL() && !this.sY.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.sj.hF()) {
                            i(this.sS.toByteArray());
                        } else {
                            onTextMessage(new String(this.sS.toByteArray(), HTTP.UTF_8));
                        }
                    } else if (this.sV == 2) {
                        l(this.sS.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.sU = false;
                    this.sS.reset();
                }
            }
            this.sW = null;
            this.sX = 0;
            return this.sR.position() > 0;
        } else {
            int position2 = this.sR.position();
            if (this.sW.th - this.sX < position2) {
                position2 = this.sW.th - this.sX;
            }
            int position3 = this.sR.position();
            if (this.sW.th > 0) {
                bArr = new byte[position2];
                this.sR.position(0);
                this.sR.get(bArr, 0, position2);
            }
            this.sR.position(position2);
            this.sR.limit(position3);
            this.sR.compact();
            if (bArr != null) {
                this.sS.write(bArr);
            }
            this.sX = position2 + this.sX;
            return this.sX >= this.sW.th;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        t(new k.q(z, map));
    }

    protected void e(int i, String str) {
        t(new k.c(i, str));
    }

    protected void j(byte[] bArr) {
        t(new k.j(bArr));
    }

    protected void k(byte[] bArr) {
        t(new k.C0019k(bArr));
    }

    protected void onTextMessage(String str) {
        t(new k.s(str));
    }

    protected void i(byte[] bArr) {
        t(new k.m(bArr));
    }

    protected void l(byte[] bArr) {
        this.tc = System.currentTimeMillis();
        t(new k.a(bArr, this.tb, this.tc));
    }

    private boolean hP() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.sR.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.sR.get(position + 0) != 13 || this.sR.get(position + 1) != 10 || this.sR.get(position + 2) != 13 || this.sR.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.sR.position();
                Map<String, String> map = null;
                if (this.sR.get(0) == 72 && this.sR.get(1) == 84 && this.sR.get(2) == 84 && this.sR.get(3) == 80) {
                    Pair<Integer, String> hQ = hQ();
                    if (((Integer) hQ.first).intValue() >= 300) {
                        t(new k.p(((Integer) hQ.first).intValue(), (String) hQ.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.sR.position(0);
                        byte[] bArr = new byte[position];
                        this.sR.get(bArr);
                        map = m(bArr);
                    }
                } else {
                    z = false;
                }
                this.sR.position(position + 4);
                this.sR.limit(position2);
                this.sR.compact();
                if (this.sZ < this.rZ.hp() && map.size() == 0) {
                    this.sZ++;
                    return true;
                }
                this.sZ = 0;
                if (!z) {
                    z2 = this.sR.position() > 0;
                    this.mState = 3;
                } else {
                    this.mState = 0;
                    this.mStopped = true;
                    z2 = true;
                }
                a(z ? false : true, map);
                z3 = z2;
            }
        }
        return z3;
    }

    private Map<String, String> m(byte[] bArr) throws UnsupportedEncodingException {
        String str = new String(bArr, HTTP.UTF_8);
        HashMap hashMap = new HashMap();
        String[] split = str.split("\r\n");
        for (String str2 : split) {
            if (str2.length() > 0) {
                String[] split2 = str2.split(": ");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    private Pair<Integer, String> hQ() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.sR.position() && this.sR.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.sR.position() && this.sR.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.sR.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.sR.position() && this.sR.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.sR.position(i6);
        this.sR.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, HTTP.UTF_8));
    }

    private boolean hR() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return hO();
        }
        if (this.mState == 1) {
            return hP();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.rZ.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.sR.clear();
            do {
                try {
                    int read = this.rZ.read(this.sR);
                    if (read > 0) {
                        if (this.tb <= 0) {
                            this.tb = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            sT += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (hR());
                    } else if (read < 0) {
                        t(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        t(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            t(new k.d(e2));
        } catch (WebSocketException e3) {
            t(new k.l(e3));
        } catch (Exception e4) {
            t(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void hw() {
        synchronized (m.class) {
            sT = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = sT;
        }
        return j;
    }
}
