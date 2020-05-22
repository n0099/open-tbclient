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
    private static long Ph = 0;
    private final l OB;
    private final e.a Ot;
    private final Handler Pe;
    private final ByteBuffer Pf;
    private final d Pg;
    private boolean Pi;
    private int Pj;
    private a Pk;
    private int Pl;
    private final f Pm;
    private int Pn;
    private long Po;
    private long Pp;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Pq;
        public boolean Pr;
        public int Ps;
        public int Pt;
        public int Pu;
        public int Pv;
        public byte[] Pw;
        public byte[] Px;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Pi = false;
        this.Pm = new f();
        this.Pn = 0;
        this.Po = 0L;
        this.Pp = 0L;
        this.Pe = handler;
        this.Ot = aVar;
        this.OB = lVar;
        this.Pf = ByteBuffer.allocateDirect(lVar.mV() + 14);
        this.Pg = new d(lVar.mW());
        this.Pk = null;
        this.mState = 1;
    }

    protected void x(Object obj) {
        this.Po = 0L;
        this.Pp = 0L;
        Message obtainMessage = this.Pe.obtainMessage();
        obtainMessage.obj = obj;
        this.Pe.sendMessage(obtainMessage);
    }

    private boolean nc() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Pk == null) {
            if (this.Pf.position() >= 2) {
                byte b = this.Pf.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Pf.get(1);
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
                    if (!this.Pi && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Pi && i4 != 0) {
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
                if (this.Pf.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Pf.get(2) & 255) << 8) | (this.Pf.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Pf.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Pf.get(2) & 255) << 56) | ((this.Pf.get(3) & 255) << 48) | ((this.Pf.get(4) & 255) << 40) | ((this.Pf.get(5) & 255) << 32) | ((this.Pf.get(6) & 255) << 24) | ((this.Pf.get(7) & 255) << 16) | ((this.Pf.get(8) & 255) << 8) | (this.Pf.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Pk = new a();
                    this.Pk.Pq = i4;
                    this.Pk.Pr = z;
                    this.Pk.Ps = i3;
                    this.Pk.Pu = (int) j;
                    this.Pk.Pt = i2;
                    this.Pk.Pv = this.Pk.Pt + this.Pk.Pu;
                    this.Pk.Pw = null;
                    int position = this.Pf.position();
                    this.Pk.Px = new byte[this.Pk.Pt];
                    this.Pf.position(0);
                    this.Pf.get(this.Pk.Px, 0, this.Pk.Pt);
                    this.Pf.position(this.Pk.Pt);
                    this.Pf.limit(position);
                    this.Pf.compact();
                    return this.Pk.Pu == 0 || this.Pf.position() >= this.Pk.Pu;
                }
                return false;
            }
            return false;
        } else if (this.Pl >= this.Pk.Pu) {
            if (this.Pk.Pq > 7) {
                if (this.Pk.Pq == 8) {
                    if (this.Pk.Pu < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Pk.Px[1] & 255) + ((this.Pk.Px[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Pk.Pu > 2) {
                            byte[] bArr2 = new byte[this.Pk.Pu - 2];
                            System.arraycopy(this.Pk.Px, 2, bArr2, 0, this.Pk.Pu - 2);
                            f fVar = new f();
                            fVar.j(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    d(i, str);
                } else if (this.Pk.Pq == 9) {
                    l(this.Pg.toByteArray());
                } else if (this.Pk.Pq == 10) {
                    m(this.Pg.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Pi) {
                    this.Pi = true;
                    this.Pj = this.Pk.Pq;
                    if (this.Pj == 1 && this.OB.mZ()) {
                        this.Pm.reset();
                    }
                }
                if (this.Pj == 1 && this.OB.mZ() && !this.Pm.j(this.Pg.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Pk.Pr) {
                    if (this.Pj == 1) {
                        if (this.OB.mZ() && !this.Pm.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.OB.mU()) {
                            k(this.Pg.toByteArray());
                        } else {
                            onTextMessage(new String(this.Pg.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Pj == 2) {
                        n(this.Pg.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Pi = false;
                    this.Pg.reset();
                }
            }
            this.Pk = null;
            this.Pl = 0;
            return this.Pf.position() > 0;
        } else {
            int position2 = this.Pf.position();
            if (this.Pk.Pu - this.Pl < position2) {
                position2 = this.Pk.Pu - this.Pl;
            }
            int position3 = this.Pf.position();
            if (this.Pk.Pu > 0) {
                bArr = new byte[position2];
                this.Pf.position(0);
                this.Pf.get(bArr, 0, position2);
            }
            this.Pf.position(position2);
            this.Pf.limit(position3);
            this.Pf.compact();
            if (bArr != null) {
                this.Pg.write(bArr);
            }
            this.Pl = position2 + this.Pl;
            return this.Pl >= this.Pk.Pu;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        x(new k.q(z, map));
    }

    protected void d(int i, String str) {
        x(new k.c(i, str));
    }

    protected void l(byte[] bArr) {
        x(new k.j(bArr));
    }

    protected void m(byte[] bArr) {
        x(new k.C0025k(bArr));
    }

    protected void onTextMessage(String str) {
        x(new k.s(str));
    }

    protected void k(byte[] bArr) {
        x(new k.m(bArr));
    }

    protected void n(byte[] bArr) {
        this.Pp = System.currentTimeMillis();
        x(new k.a(bArr, this.Po, this.Pp));
    }

    private boolean nd() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Pf.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Pf.get(position + 0) != 13 || this.Pf.get(position + 1) != 10 || this.Pf.get(position + 2) != 13 || this.Pf.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Pf.position();
                Map<String, String> map = null;
                if (this.Pf.get(0) == 72 && this.Pf.get(1) == 84 && this.Pf.get(2) == 84 && this.Pf.get(3) == 80) {
                    Pair<Integer, String> ne = ne();
                    if (((Integer) ne.first).intValue() >= 300) {
                        x(new k.p(((Integer) ne.first).intValue(), (String) ne.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Pf.position(0);
                        byte[] bArr = new byte[position];
                        this.Pf.get(bArr);
                        map = o(bArr);
                    }
                } else {
                    z = false;
                }
                this.Pf.position(position + 4);
                this.Pf.limit(position2);
                this.Pf.compact();
                if (this.Pn < this.Ot.mF() && map.size() == 0) {
                    this.Pn++;
                    return true;
                }
                this.Pn = 0;
                if (!z) {
                    z2 = this.Pf.position() > 0;
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

    private Map<String, String> o(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> ne() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Pf.position() && this.Pf.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Pf.position() && this.Pf.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Pf.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Pf.position() && this.Pf.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Pf.position(i6);
        this.Pf.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean nf() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return nc();
        }
        if (this.mState == 1) {
            return nd();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Ot.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Pf.clear();
            do {
                try {
                    int read = this.Ot.read(this.Pf);
                    if (read > 0) {
                        if (this.Po <= 0) {
                            this.Po = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Ph += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (nf());
                    } else if (read < 0) {
                        x(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        this.mStopped = true;
                        x(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            x(new k.d(e2));
        } catch (WebSocketException e3) {
            x(new k.l(e3));
        } catch (Exception e4) {
            x(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void mL() {
        synchronized (m.class) {
            Ph = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Ph;
        }
        return j;
    }
}
