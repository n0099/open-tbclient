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
/* loaded from: classes.dex */
public class m extends Thread {
    private static long Re = 0;
    private final e.a Qr;
    private final l Qz;
    private final Handler Rb;
    private final ByteBuffer Rc;
    private final d Rd;
    private boolean Rf;
    private int Rg;
    private a Rh;
    private int Ri;
    private final f Rj;
    private int Rk;
    private long Rl;
    private long Rm;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Rn;
        public boolean Ro;
        public int Rp;
        public int Rq;
        public int Rr;
        public int Rs;
        public byte[] Rt;
        public byte[] Ru;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Rf = false;
        this.Rj = new f();
        this.Rk = 0;
        this.Rl = 0L;
        this.Rm = 0L;
        this.Rb = handler;
        this.Qr = aVar;
        this.Qz = lVar;
        this.Rc = ByteBuffer.allocateDirect(lVar.oR() + 14);
        this.Rd = new d(lVar.oS());
        this.Rh = null;
        this.mState = 1;
    }

    protected void z(Object obj) {
        this.Rl = 0L;
        this.Rm = 0L;
        Message obtainMessage = this.Rb.obtainMessage();
        obtainMessage.obj = obj;
        this.Rb.sendMessage(obtainMessage);
    }

    private boolean oY() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Rh == null) {
            if (this.Rc.position() >= 2) {
                byte b = this.Rc.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Rc.get(1);
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
                    if (!this.Rf && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Rf && i4 != 0) {
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
                if (this.Rc.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Rc.get(2) & 255) << 8) | (this.Rc.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Rc.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Rc.get(2) & 255) << 56) | ((this.Rc.get(3) & 255) << 48) | ((this.Rc.get(4) & 255) << 40) | ((this.Rc.get(5) & 255) << 32) | ((this.Rc.get(6) & 255) << 24) | ((this.Rc.get(7) & 255) << 16) | ((this.Rc.get(8) & 255) << 8) | (this.Rc.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Rh = new a();
                    this.Rh.Rn = i4;
                    this.Rh.Ro = z;
                    this.Rh.Rp = i3;
                    this.Rh.Rr = (int) j;
                    this.Rh.Rq = i2;
                    this.Rh.Rs = this.Rh.Rq + this.Rh.Rr;
                    this.Rh.Rt = null;
                    int position = this.Rc.position();
                    this.Rh.Ru = new byte[this.Rh.Rq];
                    this.Rc.position(0);
                    this.Rc.get(this.Rh.Ru, 0, this.Rh.Rq);
                    this.Rc.position(this.Rh.Rq);
                    this.Rc.limit(position);
                    this.Rc.compact();
                    return this.Rh.Rr == 0 || this.Rc.position() >= this.Rh.Rr;
                }
                return false;
            }
            return false;
        } else if (this.Ri >= this.Rh.Rr) {
            if (this.Rh.Rn > 7) {
                if (this.Rh.Rn == 8) {
                    if (this.Rh.Rr < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Rh.Ru[1] & 255) + ((this.Rh.Ru[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Rh.Rr > 2) {
                            byte[] bArr2 = new byte[this.Rh.Rr - 2];
                            System.arraycopy(this.Rh.Ru, 2, bArr2, 0, this.Rh.Rr - 2);
                            f fVar = new f();
                            fVar.l(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    c(i, str);
                } else if (this.Rh.Rn == 9) {
                    n(this.Rd.toByteArray());
                } else if (this.Rh.Rn == 10) {
                    o(this.Rd.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Rf) {
                    this.Rf = true;
                    this.Rg = this.Rh.Rn;
                    if (this.Rg == 1 && this.Qz.oV()) {
                        this.Rj.reset();
                    }
                }
                if (this.Rg == 1 && this.Qz.oV() && !this.Rj.l(this.Rd.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Rh.Ro) {
                    if (this.Rg == 1) {
                        if (this.Qz.oV() && !this.Rj.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Qz.oQ()) {
                            m(this.Rd.toByteArray());
                        } else {
                            onTextMessage(new String(this.Rd.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Rg == 2) {
                        p(this.Rd.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Rf = false;
                    this.Rd.reset();
                }
            }
            this.Rh = null;
            this.Ri = 0;
            return this.Rc.position() > 0;
        } else {
            int position2 = this.Rc.position();
            if (this.Rh.Rr - this.Ri < position2) {
                position2 = this.Rh.Rr - this.Ri;
            }
            int position3 = this.Rc.position();
            if (this.Rh.Rr > 0) {
                bArr = new byte[position2];
                this.Rc.position(0);
                this.Rc.get(bArr, 0, position2);
            }
            this.Rc.position(position2);
            this.Rc.limit(position3);
            this.Rc.compact();
            if (bArr != null) {
                this.Rd.write(bArr);
            }
            this.Ri = position2 + this.Ri;
            return this.Ri >= this.Rh.Rr;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        z(new k.q(z, map));
    }

    protected void c(int i, String str) {
        z(new k.c(i, str));
    }

    protected void n(byte[] bArr) {
        z(new k.j(bArr));
    }

    protected void o(byte[] bArr) {
        z(new k.C0024k(bArr));
    }

    protected void onTextMessage(String str) {
        z(new k.s(str));
    }

    protected void m(byte[] bArr) {
        z(new k.m(bArr));
    }

    protected void p(byte[] bArr) {
        this.Rm = System.currentTimeMillis();
        z(new k.a(bArr, this.Rl, this.Rm));
    }

    private boolean oZ() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Rc.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Rc.get(position + 0) != 13 || this.Rc.get(position + 1) != 10 || this.Rc.get(position + 2) != 13 || this.Rc.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Rc.position();
                Map<String, String> map = null;
                if (this.Rc.get(0) == 72 && this.Rc.get(1) == 84 && this.Rc.get(2) == 84 && this.Rc.get(3) == 80) {
                    Pair<Integer, String> pa = pa();
                    if (((Integer) pa.first).intValue() >= 300) {
                        z(new k.p(((Integer) pa.first).intValue(), (String) pa.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Rc.position(0);
                        byte[] bArr = new byte[position];
                        this.Rc.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.Rc.position(position + 4);
                this.Rc.limit(position2);
                this.Rc.compact();
                if (this.Rk < this.Qr.oB() && map.size() == 0) {
                    this.Rk++;
                    return true;
                }
                this.Rk = 0;
                if (!z) {
                    z2 = this.Rc.position() > 0;
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

    private Map<String, String> q(byte[] bArr) throws UnsupportedEncodingException {
        String str = new String(bArr, "UTF-8");
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

    private Pair<Integer, String> pa() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Rc.position() && this.Rc.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Rc.position() && this.Rc.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Rc.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Rc.position() && this.Rc.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Rc.position(i6);
        this.Rc.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean pb() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return oY();
        }
        if (this.mState == 1) {
            return oZ();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Qr.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Rc.clear();
            do {
                try {
                    int read = this.Qr.read(this.Rc);
                    if (read > 0) {
                        if (this.Rl <= 0) {
                            this.Rl = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Re += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (pb());
                    } else if (read < 0) {
                        z(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        z(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            z(new k.d(e2));
        } catch (WebSocketException e3) {
            z(new k.l(e3));
        } catch (Exception e4) {
            z(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void oH() {
        synchronized (m.class) {
            Re = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Re;
        }
        return j;
    }
}
