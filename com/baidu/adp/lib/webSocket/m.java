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
    private static long Rd = 0;
    private final e.a Qq;
    private final l Qy;
    private final Handler Ra;
    private final ByteBuffer Rb;
    private final d Rc;
    private boolean Re;
    private int Rf;
    private a Rg;
    private int Rh;
    private final f Ri;
    private int Rj;
    private long Rk;
    private long Rl;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Rm;
        public boolean Rn;
        public int Ro;
        public int Rp;
        public int Rq;
        public int Rr;
        public byte[] Rs;
        public byte[] Rt;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Re = false;
        this.Ri = new f();
        this.Rj = 0;
        this.Rk = 0L;
        this.Rl = 0L;
        this.Ra = handler;
        this.Qq = aVar;
        this.Qy = lVar;
        this.Rb = ByteBuffer.allocateDirect(lVar.oR() + 14);
        this.Rc = new d(lVar.oS());
        this.Rg = null;
        this.mState = 1;
    }

    protected void z(Object obj) {
        this.Rk = 0L;
        this.Rl = 0L;
        Message obtainMessage = this.Ra.obtainMessage();
        obtainMessage.obj = obj;
        this.Ra.sendMessage(obtainMessage);
    }

    private boolean oY() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Rg == null) {
            if (this.Rb.position() >= 2) {
                byte b = this.Rb.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Rb.get(1);
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
                    if (!this.Re && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Re && i4 != 0) {
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
                if (this.Rb.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Rb.get(2) & 255) << 8) | (this.Rb.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Rb.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Rb.get(2) & 255) << 56) | ((this.Rb.get(3) & 255) << 48) | ((this.Rb.get(4) & 255) << 40) | ((this.Rb.get(5) & 255) << 32) | ((this.Rb.get(6) & 255) << 24) | ((this.Rb.get(7) & 255) << 16) | ((this.Rb.get(8) & 255) << 8) | (this.Rb.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Rg = new a();
                    this.Rg.Rm = i4;
                    this.Rg.Rn = z;
                    this.Rg.Ro = i3;
                    this.Rg.Rq = (int) j;
                    this.Rg.Rp = i2;
                    this.Rg.Rr = this.Rg.Rp + this.Rg.Rq;
                    this.Rg.Rs = null;
                    int position = this.Rb.position();
                    this.Rg.Rt = new byte[this.Rg.Rp];
                    this.Rb.position(0);
                    this.Rb.get(this.Rg.Rt, 0, this.Rg.Rp);
                    this.Rb.position(this.Rg.Rp);
                    this.Rb.limit(position);
                    this.Rb.compact();
                    return this.Rg.Rq == 0 || this.Rb.position() >= this.Rg.Rq;
                }
                return false;
            }
            return false;
        } else if (this.Rh >= this.Rg.Rq) {
            if (this.Rg.Rm > 7) {
                if (this.Rg.Rm == 8) {
                    if (this.Rg.Rq < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Rg.Rt[1] & 255) + ((this.Rg.Rt[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Rg.Rq > 2) {
                            byte[] bArr2 = new byte[this.Rg.Rq - 2];
                            System.arraycopy(this.Rg.Rt, 2, bArr2, 0, this.Rg.Rq - 2);
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
                } else if (this.Rg.Rm == 9) {
                    n(this.Rc.toByteArray());
                } else if (this.Rg.Rm == 10) {
                    o(this.Rc.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Re) {
                    this.Re = true;
                    this.Rf = this.Rg.Rm;
                    if (this.Rf == 1 && this.Qy.oV()) {
                        this.Ri.reset();
                    }
                }
                if (this.Rf == 1 && this.Qy.oV() && !this.Ri.l(this.Rc.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Rg.Rn) {
                    if (this.Rf == 1) {
                        if (this.Qy.oV() && !this.Ri.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Qy.oQ()) {
                            m(this.Rc.toByteArray());
                        } else {
                            onTextMessage(new String(this.Rc.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Rf == 2) {
                        p(this.Rc.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Re = false;
                    this.Rc.reset();
                }
            }
            this.Rg = null;
            this.Rh = 0;
            return this.Rb.position() > 0;
        } else {
            int position2 = this.Rb.position();
            if (this.Rg.Rq - this.Rh < position2) {
                position2 = this.Rg.Rq - this.Rh;
            }
            int position3 = this.Rb.position();
            if (this.Rg.Rq > 0) {
                bArr = new byte[position2];
                this.Rb.position(0);
                this.Rb.get(bArr, 0, position2);
            }
            this.Rb.position(position2);
            this.Rb.limit(position3);
            this.Rb.compact();
            if (bArr != null) {
                this.Rc.write(bArr);
            }
            this.Rh = position2 + this.Rh;
            return this.Rh >= this.Rg.Rq;
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
        this.Rl = System.currentTimeMillis();
        z(new k.a(bArr, this.Rk, this.Rl));
    }

    private boolean oZ() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Rb.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Rb.get(position + 0) != 13 || this.Rb.get(position + 1) != 10 || this.Rb.get(position + 2) != 13 || this.Rb.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Rb.position();
                Map<String, String> map = null;
                if (this.Rb.get(0) == 72 && this.Rb.get(1) == 84 && this.Rb.get(2) == 84 && this.Rb.get(3) == 80) {
                    Pair<Integer, String> pa = pa();
                    if (((Integer) pa.first).intValue() >= 300) {
                        z(new k.p(((Integer) pa.first).intValue(), (String) pa.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Rb.position(0);
                        byte[] bArr = new byte[position];
                        this.Rb.get(bArr);
                        map = q(bArr);
                    }
                } else {
                    z = false;
                }
                this.Rb.position(position + 4);
                this.Rb.limit(position2);
                this.Rb.compact();
                if (this.Rj < this.Qq.oB() && map.size() == 0) {
                    this.Rj++;
                    return true;
                }
                this.Rj = 0;
                if (!z) {
                    z2 = this.Rb.position() > 0;
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
        while (i < this.Rb.position() && this.Rb.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Rb.position() && this.Rb.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Rb.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Rb.position() && this.Rb.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Rb.position(i6);
        this.Rb.get(bArr, 0, i8);
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
            this.Qq.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Rb.clear();
            do {
                try {
                    int read = this.Qq.read(this.Rb);
                    if (read > 0) {
                        if (this.Rk <= 0) {
                            this.Rk = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Rd += read;
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
            Rd = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Rd;
        }
        return j;
    }
}
