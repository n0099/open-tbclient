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
    private static long Gi = 0;
    private final l FA;
    private final e.a Fs;
    private final Handler Gf;
    private final ByteBuffer Gg;
    private final d Gh;
    private boolean Gj;
    private int Gk;
    private a Gl;
    private int Gm;
    private final f Gn;
    private int Go;
    private long Gp;
    private long Gq;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int Gr;
        public boolean Gs;
        public int Gt;
        public int Gu;
        public int Gv;
        public int Gw;
        public byte[] Gx;
        public byte[] Gy;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Gj = false;
        this.Gn = new f();
        this.Go = 0;
        this.Gp = 0L;
        this.Gq = 0L;
        this.Gf = handler;
        this.Fs = aVar;
        this.FA = lVar;
        this.Gg = ByteBuffer.allocateDirect(lVar.lh() + 14);
        this.Gh = new d(lVar.li());
        this.Gl = null;
        this.mState = 1;
    }

    protected void w(Object obj) {
        this.Gp = 0L;
        this.Gq = 0L;
        Message obtainMessage = this.Gf.obtainMessage();
        obtainMessage.obj = obj;
        this.Gf.sendMessage(obtainMessage);
    }

    private boolean lp() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Gl == null) {
            if (this.Gg.position() >= 2) {
                byte b = this.Gg.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Gg.get(1);
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
                    if (!this.Gj && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Gj && i4 != 0) {
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
                if (this.Gg.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Gg.get(2) & 255) << 8) | (this.Gg.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Gg.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Gg.get(2) & 255) << 56) | ((this.Gg.get(3) & 255) << 48) | ((this.Gg.get(4) & 255) << 40) | ((this.Gg.get(5) & 255) << 32) | ((this.Gg.get(6) & 255) << 24) | ((this.Gg.get(7) & 255) << 16) | ((this.Gg.get(8) & 255) << 8) | (this.Gg.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Gl = new a();
                    this.Gl.Gr = i4;
                    this.Gl.Gs = z;
                    this.Gl.Gt = i3;
                    this.Gl.Gv = (int) j;
                    this.Gl.Gu = i2;
                    this.Gl.Gw = this.Gl.Gu + this.Gl.Gv;
                    this.Gl.Gx = null;
                    int position = this.Gg.position();
                    this.Gl.Gy = new byte[this.Gl.Gu];
                    this.Gg.position(0);
                    this.Gg.get(this.Gl.Gy, 0, this.Gl.Gu);
                    this.Gg.position(this.Gl.Gu);
                    this.Gg.limit(position);
                    this.Gg.compact();
                    return this.Gl.Gv == 0 || this.Gg.position() >= this.Gl.Gv;
                }
                return false;
            }
            return false;
        } else if (this.Gm >= this.Gl.Gv) {
            if (this.Gl.Gr > 7) {
                if (this.Gl.Gr == 8) {
                    if (this.Gl.Gv < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Gl.Gy[1] & 255) + ((this.Gl.Gy[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Gl.Gv > 2) {
                            byte[] bArr2 = new byte[this.Gl.Gv - 2];
                            System.arraycopy(this.Gl.Gy, 2, bArr2, 0, this.Gl.Gv - 2);
                            f fVar = new f();
                            fVar.p(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, HTTP.UTF_8);
                        } else {
                            str = null;
                        }
                    }
                    f(i, str);
                } else if (this.Gl.Gr == 9) {
                    r(this.Gh.toByteArray());
                } else if (this.Gl.Gr == 10) {
                    s(this.Gh.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Gj) {
                    this.Gj = true;
                    this.Gk = this.Gl.Gr;
                    if (this.Gk == 1 && this.FA.lm()) {
                        this.Gn.reset();
                    }
                }
                if (this.Gk == 1 && this.FA.lm() && !this.Gn.p(this.Gh.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Gl.Gs) {
                    if (this.Gk == 1) {
                        if (this.FA.lm() && !this.Gn.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.FA.lg()) {
                            q(this.Gh.toByteArray());
                        } else {
                            S(new String(this.Gh.toByteArray(), HTTP.UTF_8));
                        }
                    } else if (this.Gk == 2) {
                        t(this.Gh.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Gj = false;
                    this.Gh.reset();
                }
            }
            this.Gl = null;
            this.Gm = 0;
            return this.Gg.position() > 0;
        } else {
            int position2 = this.Gg.position();
            if (this.Gl.Gv - this.Gm < position2) {
                position2 = this.Gl.Gv - this.Gm;
            }
            int position3 = this.Gg.position();
            if (this.Gl.Gv > 0) {
                bArr = new byte[position2];
                this.Gg.position(0);
                this.Gg.get(bArr, 0, position2);
            }
            this.Gg.position(position2);
            this.Gg.limit(position3);
            this.Gg.compact();
            if (bArr != null) {
                this.Gh.write(bArr);
            }
            this.Gm = position2 + this.Gm;
            return this.Gm >= this.Gl.Gv;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        w(new k.q(z, map));
    }

    protected void f(int i, String str) {
        w(new k.c(i, str));
    }

    protected void r(byte[] bArr) {
        w(new k.j(bArr));
    }

    protected void s(byte[] bArr) {
        w(new k.C0019k(bArr));
    }

    protected void S(String str) {
        w(new k.s(str));
    }

    protected void q(byte[] bArr) {
        w(new k.m(bArr));
    }

    protected void t(byte[] bArr) {
        this.Gq = System.currentTimeMillis();
        w(new k.a(bArr, this.Gp, this.Gq));
    }

    private boolean lq() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Gg.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Gg.get(position + 0) != 13 || this.Gg.get(position + 1) != 10 || this.Gg.get(position + 2) != 13 || this.Gg.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Gg.position();
                Map<String, String> map = null;
                if (this.Gg.get(0) == 72 && this.Gg.get(1) == 84 && this.Gg.get(2) == 84 && this.Gg.get(3) == 80) {
                    Pair<Integer, String> lr = lr();
                    if (((Integer) lr.first).intValue() >= 300) {
                        w(new k.p(((Integer) lr.first).intValue(), (String) lr.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Gg.position(0);
                        byte[] bArr = new byte[position];
                        this.Gg.get(bArr);
                        map = u(bArr);
                    }
                } else {
                    z = false;
                }
                this.Gg.position(position + 4);
                this.Gg.limit(position2);
                this.Gg.compact();
                if (this.Go < this.Fs.kQ() && map.size() == 0) {
                    this.Go++;
                    return true;
                }
                this.Go = 0;
                if (!z) {
                    z2 = this.Gg.position() > 0;
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

    private Map<String, String> u(byte[] bArr) throws UnsupportedEncodingException {
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

    private Pair<Integer, String> lr() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Gg.position() && this.Gg.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Gg.position() && this.Gg.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Gg.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Gg.position() && this.Gg.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Gg.position(i6);
        this.Gg.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, HTTP.UTF_8));
    }

    private boolean ls() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return lp();
        }
        if (this.mState == 1) {
            return lq();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Fs.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Gg.clear();
            do {
                try {
                    int read = this.Fs.read(this.Gg);
                    if (read > 0) {
                        if (this.Gp <= 0) {
                            this.Gp = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Gi += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (ls());
                    } else if (read < 0) {
                        w(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.kc()) {
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

    public void kX() {
        synchronized (m.class) {
            Gi = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Gi;
        }
        return j;
    }
}
