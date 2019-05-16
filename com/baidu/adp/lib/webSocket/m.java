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
    private static long Gc = 0;
    private final Handler FZ;
    private final e.a Fm;
    private final l Fu;
    private final ByteBuffer Ga;
    private final d Gb;
    private boolean Gd;
    private int Ge;
    private a Gf;
    private int Gg;
    private final f Gh;
    private int Gi;
    private long Gj;
    private long Gk;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Gl;
        public boolean Gm;
        public int Gn;
        public int Go;
        public int Gp;
        public int Gq;
        public byte[] Gr;
        public byte[] Gs;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Gd = false;
        this.Gh = new f();
        this.Gi = 0;
        this.Gj = 0L;
        this.Gk = 0L;
        this.FZ = handler;
        this.Fm = aVar;
        this.Fu = lVar;
        this.Ga = ByteBuffer.allocateDirect(lVar.kS() + 14);
        this.Gb = new d(lVar.kT());
        this.Gf = null;
        this.mState = 1;
    }

    protected void w(Object obj) {
        this.Gj = 0L;
        this.Gk = 0L;
        Message obtainMessage = this.FZ.obtainMessage();
        obtainMessage.obj = obj;
        this.FZ.sendMessage(obtainMessage);
    }

    private boolean kZ() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Gf == null) {
            if (this.Ga.position() >= 2) {
                byte b = this.Ga.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Ga.get(1);
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
                    if (!this.Gd && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Gd && i4 != 0) {
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
                if (this.Ga.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Ga.get(2) & 255) << 8) | (this.Ga.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Ga.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Ga.get(2) & 255) << 56) | ((this.Ga.get(3) & 255) << 48) | ((this.Ga.get(4) & 255) << 40) | ((this.Ga.get(5) & 255) << 32) | ((this.Ga.get(6) & 255) << 24) | ((this.Ga.get(7) & 255) << 16) | ((this.Ga.get(8) & 255) << 8) | (this.Ga.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Gf = new a();
                    this.Gf.Gl = i4;
                    this.Gf.Gm = z;
                    this.Gf.Gn = i3;
                    this.Gf.Gp = (int) j;
                    this.Gf.Go = i2;
                    this.Gf.Gq = this.Gf.Go + this.Gf.Gp;
                    this.Gf.Gr = null;
                    int position = this.Ga.position();
                    this.Gf.Gs = new byte[this.Gf.Go];
                    this.Ga.position(0);
                    this.Ga.get(this.Gf.Gs, 0, this.Gf.Go);
                    this.Ga.position(this.Gf.Go);
                    this.Ga.limit(position);
                    this.Ga.compact();
                    return this.Gf.Gp == 0 || this.Ga.position() >= this.Gf.Gp;
                }
                return false;
            }
            return false;
        } else if (this.Gg >= this.Gf.Gp) {
            if (this.Gf.Gl > 7) {
                if (this.Gf.Gl == 8) {
                    if (this.Gf.Gp < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Gf.Gs[1] & 255) + ((this.Gf.Gs[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Gf.Gp > 2) {
                            byte[] bArr2 = new byte[this.Gf.Gp - 2];
                            System.arraycopy(this.Gf.Gs, 2, bArr2, 0, this.Gf.Gp - 2);
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
                } else if (this.Gf.Gl == 9) {
                    q(this.Gb.toByteArray());
                } else if (this.Gf.Gl == 10) {
                    r(this.Gb.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Gd) {
                    this.Gd = true;
                    this.Ge = this.Gf.Gl;
                    if (this.Ge == 1 && this.Fu.kW()) {
                        this.Gh.reset();
                    }
                }
                if (this.Ge == 1 && this.Fu.kW() && !this.Gh.o(this.Gb.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Gf.Gm) {
                    if (this.Ge == 1) {
                        if (this.Fu.kW() && !this.Gh.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.Fu.kR()) {
                            p(this.Gb.toByteArray());
                        } else {
                            S(new String(this.Gb.toByteArray(), HTTP.UTF_8));
                        }
                    } else if (this.Ge == 2) {
                        s(this.Gb.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Gd = false;
                    this.Gb.reset();
                }
            }
            this.Gf = null;
            this.Gg = 0;
            return this.Ga.position() > 0;
        } else {
            int position2 = this.Ga.position();
            if (this.Gf.Gp - this.Gg < position2) {
                position2 = this.Gf.Gp - this.Gg;
            }
            int position3 = this.Ga.position();
            if (this.Gf.Gp > 0) {
                bArr = new byte[position2];
                this.Ga.position(0);
                this.Ga.get(bArr, 0, position2);
            }
            this.Ga.position(position2);
            this.Ga.limit(position3);
            this.Ga.compact();
            if (bArr != null) {
                this.Gb.write(bArr);
            }
            this.Gg = position2 + this.Gg;
            return this.Gg >= this.Gf.Gp;
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
        this.Gk = System.currentTimeMillis();
        w(new k.a(bArr, this.Gj, this.Gk));
    }

    private boolean la() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Ga.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Ga.get(position + 0) != 13 || this.Ga.get(position + 1) != 10 || this.Ga.get(position + 2) != 13 || this.Ga.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Ga.position();
                Map<String, String> map = null;
                if (this.Ga.get(0) == 72 && this.Ga.get(1) == 84 && this.Ga.get(2) == 84 && this.Ga.get(3) == 80) {
                    Pair<Integer, String> lb = lb();
                    if (((Integer) lb.first).intValue() >= 300) {
                        w(new k.p(((Integer) lb.first).intValue(), (String) lb.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Ga.position(0);
                        byte[] bArr = new byte[position];
                        this.Ga.get(bArr);
                        map = t(bArr);
                    }
                } else {
                    z = false;
                }
                this.Ga.position(position + 4);
                this.Ga.limit(position2);
                this.Ga.compact();
                if (this.Gi < this.Fm.kB() && map.size() == 0) {
                    this.Gi++;
                    return true;
                }
                this.Gi = 0;
                if (!z) {
                    z2 = this.Ga.position() > 0;
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
        while (i < this.Ga.position() && this.Ga.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Ga.position() && this.Ga.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Ga.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Ga.position() && this.Ga.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Ga.position(i6);
        this.Ga.get(bArr, 0, i8);
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
            this.Fm.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Ga.clear();
            do {
                try {
                    int read = this.Fm.read(this.Ga);
                    if (read > 0) {
                        if (this.Gj <= 0) {
                            this.Gj = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Gc += read;
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
            Gc = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Gc;
        }
        return j;
    }
}
