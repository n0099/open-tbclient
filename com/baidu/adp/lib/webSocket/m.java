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
    private static long Gb = 0;
    private final Handler FY;
    private final ByteBuffer FZ;
    private final e.a Fl;
    private final l Ft;
    private final d Ga;
    private boolean Gc;
    private int Gd;
    private a Ge;
    private int Gf;
    private final f Gg;
    private int Gh;
    private long Gi;
    private long Gj;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Gk;
        public boolean Gl;
        public int Gm;
        public int Gn;
        public int Go;
        public int Gp;
        public byte[] Gq;
        public byte[] Gr;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Gc = false;
        this.Gg = new f();
        this.Gh = 0;
        this.Gi = 0L;
        this.Gj = 0L;
        this.FY = handler;
        this.Fl = aVar;
        this.Ft = lVar;
        this.FZ = ByteBuffer.allocateDirect(lVar.kS() + 14);
        this.Ga = new d(lVar.kT());
        this.Ge = null;
        this.mState = 1;
    }

    protected void w(Object obj) {
        this.Gi = 0L;
        this.Gj = 0L;
        Message obtainMessage = this.FY.obtainMessage();
        obtainMessage.obj = obj;
        this.FY.sendMessage(obtainMessage);
    }

    private boolean kZ() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Ge == null) {
            if (this.FZ.position() >= 2) {
                byte b = this.FZ.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.FZ.get(1);
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
                    if (!this.Gc && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Gc && i4 != 0) {
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
                if (this.FZ.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.FZ.get(2) & 255) << 8) | (this.FZ.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.FZ.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.FZ.get(2) & 255) << 56) | ((this.FZ.get(3) & 255) << 48) | ((this.FZ.get(4) & 255) << 40) | ((this.FZ.get(5) & 255) << 32) | ((this.FZ.get(6) & 255) << 24) | ((this.FZ.get(7) & 255) << 16) | ((this.FZ.get(8) & 255) << 8) | (this.FZ.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Ge = new a();
                    this.Ge.Gk = i4;
                    this.Ge.Gl = z;
                    this.Ge.Gm = i3;
                    this.Ge.Go = (int) j;
                    this.Ge.Gn = i2;
                    this.Ge.Gp = this.Ge.Gn + this.Ge.Go;
                    this.Ge.Gq = null;
                    int position = this.FZ.position();
                    this.Ge.Gr = new byte[this.Ge.Gn];
                    this.FZ.position(0);
                    this.FZ.get(this.Ge.Gr, 0, this.Ge.Gn);
                    this.FZ.position(this.Ge.Gn);
                    this.FZ.limit(position);
                    this.FZ.compact();
                    return this.Ge.Go == 0 || this.FZ.position() >= this.Ge.Go;
                }
                return false;
            }
            return false;
        } else if (this.Gf >= this.Ge.Go) {
            if (this.Ge.Gk > 7) {
                if (this.Ge.Gk == 8) {
                    if (this.Ge.Go < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Ge.Gr[1] & 255) + ((this.Ge.Gr[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Ge.Go > 2) {
                            byte[] bArr2 = new byte[this.Ge.Go - 2];
                            System.arraycopy(this.Ge.Gr, 2, bArr2, 0, this.Ge.Go - 2);
                            f fVar = new f();
                            fVar.o(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, HTTP.UTF_8);
                        } else {
                            str = null;
                        }
                    }
                    f(i, str);
                } else if (this.Ge.Gk == 9) {
                    q(this.Ga.toByteArray());
                } else if (this.Ge.Gk == 10) {
                    r(this.Ga.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Gc) {
                    this.Gc = true;
                    this.Gd = this.Ge.Gk;
                    if (this.Gd == 1 && this.Ft.kW()) {
                        this.Gg.reset();
                    }
                }
                if (this.Gd == 1 && this.Ft.kW() && !this.Gg.o(this.Ga.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Ge.Gl) {
                    if (this.Gd == 1) {
                        if (this.Ft.kW() && !this.Gg.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Ft.kR()) {
                            p(this.Ga.toByteArray());
                        } else {
                            S(new String(this.Ga.toByteArray(), HTTP.UTF_8));
                        }
                    } else if (this.Gd == 2) {
                        s(this.Ga.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Gc = false;
                    this.Ga.reset();
                }
            }
            this.Ge = null;
            this.Gf = 0;
            return this.FZ.position() > 0;
        } else {
            int position2 = this.FZ.position();
            if (this.Ge.Go - this.Gf < position2) {
                position2 = this.Ge.Go - this.Gf;
            }
            int position3 = this.FZ.position();
            if (this.Ge.Go > 0) {
                bArr = new byte[position2];
                this.FZ.position(0);
                this.FZ.get(bArr, 0, position2);
            }
            this.FZ.position(position2);
            this.FZ.limit(position3);
            this.FZ.compact();
            if (bArr != null) {
                this.Ga.write(bArr);
            }
            this.Gf = position2 + this.Gf;
            return this.Gf >= this.Ge.Go;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        w(new k.q(z, map));
    }

    protected void f(int i, String str) {
        w(new k.c(i, str));
    }

    protected void q(byte[] bArr) {
        w(new k.j(bArr));
    }

    protected void r(byte[] bArr) {
        w(new k.C0019k(bArr));
    }

    protected void S(String str) {
        w(new k.s(str));
    }

    protected void p(byte[] bArr) {
        w(new k.m(bArr));
    }

    protected void s(byte[] bArr) {
        this.Gj = System.currentTimeMillis();
        w(new k.a(bArr, this.Gi, this.Gj));
    }

    private boolean la() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.FZ.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.FZ.get(position + 0) != 13 || this.FZ.get(position + 1) != 10 || this.FZ.get(position + 2) != 13 || this.FZ.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.FZ.position();
                Map<String, String> map = null;
                if (this.FZ.get(0) == 72 && this.FZ.get(1) == 84 && this.FZ.get(2) == 84 && this.FZ.get(3) == 80) {
                    Pair<Integer, String> lb = lb();
                    if (((Integer) lb.first).intValue() >= 300) {
                        w(new k.p(((Integer) lb.first).intValue(), (String) lb.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.FZ.position(0);
                        byte[] bArr = new byte[position];
                        this.FZ.get(bArr);
                        map = t(bArr);
                    }
                } else {
                    z = false;
                }
                this.FZ.position(position + 4);
                this.FZ.limit(position2);
                this.FZ.compact();
                if (this.Gh < this.Fl.kB() && map.size() == 0) {
                    this.Gh++;
                    return true;
                }
                this.Gh = 0;
                if (!z) {
                    z2 = this.FZ.position() > 0;
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

    private Map<String, String> t(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> lb() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.FZ.position() && this.FZ.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.FZ.position() && this.FZ.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.FZ.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.FZ.position() && this.FZ.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.FZ.position(i6);
        this.FZ.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, HTTP.UTF_8));
    }

    private boolean lc() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return kZ();
        }
        if (this.mState == 1) {
            return la();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Fl.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.FZ.clear();
            do {
                try {
                    int read = this.Fl.read(this.FZ);
                    if (read > 0) {
                        if (this.Gi <= 0) {
                            this.Gi = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Gb += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (lc());
                    } else if (read < 0) {
                        w(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.jS()) {
                        this.mStopped = true;
                        w(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            w(new k.d(e2));
        } catch (WebSocketException e3) {
            w(new k.l(e3));
        } catch (Exception e4) {
            w(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void kI() {
        synchronized (m.class) {
            Gb = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Gb;
        }
        return j;
    }
}
