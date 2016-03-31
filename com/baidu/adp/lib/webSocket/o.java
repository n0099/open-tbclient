package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.m;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends Thread {
    private static long Bi = 0;
    private final n AA;
    private final e.a As;
    private final Handler Bf;
    private final ByteBuffer Bg;
    private final d Bh;
    private boolean Bj;
    private int Bk;
    private a Bl;
    private int Bm;
    private final f Bn;
    private int Bo;
    private long Bp;
    private long Bq;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Br;
        public boolean Bs;
        public int Bt;
        public int Bu;
        public int Bv;
        public int Bw;
        public byte[] Bx;
        public byte[] By;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    public o(Handler handler, e.a aVar, n nVar, String str) {
        super(str);
        this.mStopped = false;
        this.Bj = false;
        this.Bn = new f();
        this.Bo = 0;
        this.Bp = 0L;
        this.Bq = 0L;
        this.Bf = handler;
        this.As = aVar;
        this.AA = nVar;
        this.Bg = ByteBuffer.allocateDirect(nVar.ki() + 14);
        this.Bh = new d(nVar.kj());
        this.Bl = null;
        this.mState = 1;
    }

    protected void q(Object obj) {
        this.Bp = 0L;
        this.Bq = 0L;
        Message obtainMessage = this.Bf.obtainMessage();
        obtainMessage.obj = obj;
        this.Bf.sendMessage(obtainMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [232=8] */
    private boolean kp() {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Bl == null) {
            if (this.Bg.position() >= 2) {
                byte b = this.Bg.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Bg.get(1);
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
                    if (!this.Bj && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Bj && i4 != 0) {
                        throw new WebSocketException("received non-continuation data frame while inside fragmented message");
                    }
                }
                if (i5 < 126) {
                    i2 = 2;
                } else if (i5 == 126) {
                    i2 = 4;
                } else if (i5 != 127) {
                    throw new Exception("BdLogic error");
                } else {
                    i2 = 10;
                }
                if (this.Bg.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Bg.get(2) & 255) << 8) | (this.Bg.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 != 127) {
                        j = i5;
                    } else if ((this.Bg.get(2) & 128) != 0) {
                        throw new WebSocketException("invalid data frame length (> 2^63)");
                    } else {
                        j = ((this.Bg.get(2) & 255) << 56) | ((this.Bg.get(3) & 255) << 48) | ((this.Bg.get(4) & 255) << 40) | ((this.Bg.get(5) & 255) << 32) | ((this.Bg.get(6) & 255) << 24) | ((this.Bg.get(7) & 255) << 16) | ((this.Bg.get(8) & 255) << 8) | (this.Bg.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    }
                    this.Bl = new a(null);
                    this.Bl.Br = i4;
                    this.Bl.Bs = z;
                    this.Bl.Bt = i3;
                    this.Bl.Bv = (int) j;
                    this.Bl.Bu = i2;
                    this.Bl.Bw = this.Bl.Bu + this.Bl.Bv;
                    this.Bl.Bx = null;
                    int position = this.Bg.position();
                    this.Bl.By = new byte[this.Bl.Bu];
                    this.Bg.position(0);
                    this.Bg.get(this.Bl.By, 0, this.Bl.Bu);
                    this.Bg.position(this.Bl.Bu);
                    this.Bg.limit(position);
                    this.Bg.compact();
                    return this.Bl.Bv == 0 || this.Bg.position() >= this.Bl.Bv;
                }
                return false;
            }
            return false;
        } else if (this.Bm < this.Bl.Bv) {
            int position2 = this.Bg.position();
            if (this.Bl.Bv - this.Bm < position2) {
                position2 = this.Bl.Bv - this.Bm;
            }
            int position3 = this.Bg.position();
            if (this.Bl.Bv > 0) {
                bArr = new byte[position2];
                this.Bg.position(0);
                this.Bg.get(bArr, 0, position2);
            }
            this.Bg.position(position2);
            this.Bg.limit(position3);
            this.Bg.compact();
            if (bArr != null) {
                this.Bh.write(bArr);
            }
            this.Bm = position2 + this.Bm;
            return this.Bm >= this.Bl.Bv;
        } else {
            if (this.Bl.Br <= 7) {
                if (!this.Bj) {
                    this.Bj = true;
                    this.Bk = this.Bl.Br;
                    if (this.Bk == 1 && this.AA.km()) {
                        this.Bn.reset();
                    }
                }
                if (this.Bk == 1 && this.AA.km() && !this.Bn.o(this.Bh.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Bl.Bs) {
                    if (this.Bk == 1) {
                        if (this.AA.km() && !this.Bn.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.AA.kh()) {
                            p(this.Bh.toByteArray());
                        } else {
                            H(new String(this.Bh.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Bk != 2) {
                        throw new Exception("BdLogic error");
                    } else {
                        s(this.Bh.toByteArray());
                    }
                    this.Bj = false;
                    this.Bh.reset();
                }
            } else if (this.Bl.Br == 8) {
                if (this.Bl.Bv >= 2) {
                    i = (this.Bl.By[1] & 255) + ((this.Bl.By[0] & 255) * 256);
                    if (i < 1000 || (!(i < 1000 || i > 2999 || i == 1000 || i == 1001 || i == 1002 || i == 1003 || i == 1007 || i == 1008 || i == 1009 || i == 1010 || i == 1011) || i >= 5000)) {
                        throw new WebSocketException("invalid close code " + i);
                    }
                    if (this.Bl.Bv > 2) {
                        byte[] bArr2 = new byte[this.Bl.Bv - 2];
                        System.arraycopy(this.Bl.By, 2, bArr2, 0, this.Bl.Bv - 2);
                        f fVar = new f();
                        fVar.o(bArr2);
                        if (!fVar.isValid()) {
                            throw new WebSocketException("invalid close reasons (not UTF-8)");
                        }
                        str = new String(bArr2, "UTF-8");
                    } else {
                        str = null;
                    }
                } else {
                    i = 1005;
                    str = null;
                }
                e(i, str);
            } else if (this.Bl.Br == 9) {
                q(this.Bh.toByteArray());
            } else if (this.Bl.Br != 10) {
                throw new Exception("BdLogic error");
            } else {
                r(this.Bh.toByteArray());
            }
            this.Bl = null;
            this.Bm = 0;
            return this.Bg.position() > 0;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        q(new m.q(z, map));
    }

    protected void e(int i, String str) {
        q(new m.c(i, str));
    }

    protected void q(byte[] bArr) {
        q(new m.j(bArr));
    }

    protected void r(byte[] bArr) {
        q(new m.k(bArr));
    }

    protected void H(String str) {
        q(new m.s(str));
    }

    protected void p(byte[] bArr) {
        q(new m.C0010m(bArr));
    }

    protected void s(byte[] bArr) {
        this.Bq = System.currentTimeMillis();
        q(new m.a(bArr, this.Bp, this.Bq));
    }

    private boolean kq() {
        boolean z;
        boolean z2;
        int position = this.Bg.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Bg.get(position + 0) != 13 || this.Bg.get(position + 1) != 10 || this.Bg.get(position + 2) != 13 || this.Bg.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Bg.position();
                Map<String, String> map = null;
                if (this.Bg.get(0) == 72 && this.Bg.get(1) == 84 && this.Bg.get(2) == 84 && this.Bg.get(3) == 80) {
                    Pair<Integer, String> kr = kr();
                    if (((Integer) kr.first).intValue() >= 300) {
                        q(new m.p(((Integer) kr.first).intValue(), (String) kr.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Bg.position(0);
                        byte[] bArr = new byte[position];
                        this.Bg.get(bArr);
                        map = t(bArr);
                    }
                } else {
                    z = false;
                }
                this.Bg.position(position + 4);
                this.Bg.limit(position2);
                this.Bg.compact();
                if (this.Bo < this.As.jP() && map.size() == 0) {
                    this.Bo++;
                    return true;
                }
                this.Bo = 0;
                if (!z) {
                    z2 = this.Bg.position() > 0;
                    this.mState = 3;
                } else {
                    this.mState = 0;
                    this.mStopped = true;
                    z2 = true;
                }
                a(z ? false : true, map);
                r1 = z2;
            }
        }
        return r1;
    }

    private Map<String, String> t(byte[] bArr) {
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

    private Pair<Integer, String> kr() {
        int i = 4;
        while (i < this.Bg.position() && this.Bg.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Bg.position() && this.Bg.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Bg.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Bg.position() && this.Bg.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Bg.position(i6);
        this.Bg.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean ks() {
        if (this.mState == 3 || this.mState == 2) {
            return kp();
        }
        if (this.mState == 1) {
            return kq();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.As.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=6] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Bg.clear();
            do {
                try {
                    int read = this.As.read(this.Bg);
                    if (read > 0) {
                        if (this.Bp <= 0) {
                            this.Bp = System.currentTimeMillis();
                        }
                        synchronized (o.class) {
                            Bi += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (ks());
                    } else if (read < 0) {
                        q(new m.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.i.jf()) {
                        this.mStopped = true;
                        q(new m.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (WebSocketException e2) {
            q(new m.l(e2));
        } catch (SocketException e3) {
            q(new m.d(e3));
        } catch (Exception e4) {
            q(new m.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void jX() {
        synchronized (o.class) {
            Bi = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (o.class) {
            j = Bi;
        }
        return j;
    }
}
