package com.baidu.adp.lib.webSocket;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.e;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.ar.util.SystemInfoUtil;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class m extends Thread {
    private static long Fm = 0;
    private final l EE;
    private final e.a Ew;
    private final Handler Fj;
    private final ByteBuffer Fk;
    private final d Fl;
    private boolean Fn;
    private int Fo;
    private a Fp;
    private int Fq;
    private final f Fr;
    private int Fs;
    private long Ft;
    private long Fu;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int FA;
        public byte[] FB;
        public byte[] FC;
        public int Fv;
        public boolean Fw;
        public int Fx;
        public int Fy;
        public int Fz;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Fn = false;
        this.Fr = new f();
        this.Fs = 0;
        this.Ft = 0L;
        this.Fu = 0L;
        this.Fj = handler;
        this.Ew = aVar;
        this.EE = lVar;
        this.Fk = ByteBuffer.allocateDirect(lVar.kE() + 14);
        this.Fl = new d(lVar.kF());
        this.Fp = null;
        this.mState = 1;
    }

    protected void v(Object obj) {
        this.Ft = 0L;
        this.Fu = 0L;
        Message obtainMessage = this.Fj.obtainMessage();
        obtainMessage.obj = obj;
        this.Fj.sendMessage(obtainMessage);
    }

    private boolean kL() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Fp == null) {
            if (this.Fk.position() >= 2) {
                byte b = this.Fk.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Fk.get(1);
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
                    if (!this.Fn && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Fn && i4 != 0) {
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
                if (this.Fk.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Fk.get(2) & 255) << 8) | (this.Fk.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Fk.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Fk.get(2) & 255) << 56) | ((this.Fk.get(3) & 255) << 48) | ((this.Fk.get(4) & 255) << 40) | ((this.Fk.get(5) & 255) << 32) | ((this.Fk.get(6) & 255) << 24) | ((this.Fk.get(7) & 255) << 16) | ((this.Fk.get(8) & 255) << 8) | (this.Fk.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Fp = new a();
                    this.Fp.Fv = i4;
                    this.Fp.Fw = z;
                    this.Fp.Fx = i3;
                    this.Fp.Fz = (int) j;
                    this.Fp.Fy = i2;
                    this.Fp.FA = this.Fp.Fy + this.Fp.Fz;
                    this.Fp.FB = null;
                    int position = this.Fk.position();
                    this.Fp.FC = new byte[this.Fp.Fy];
                    this.Fk.position(0);
                    this.Fk.get(this.Fp.FC, 0, this.Fp.Fy);
                    this.Fk.position(this.Fp.Fy);
                    this.Fk.limit(position);
                    this.Fk.compact();
                    return this.Fp.Fz == 0 || this.Fk.position() >= this.Fp.Fz;
                }
                return false;
            }
            return false;
        } else if (this.Fq >= this.Fp.Fz) {
            if (this.Fp.Fv > 7) {
                if (this.Fp.Fv == 8) {
                    if (this.Fp.Fz < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Fp.FC[1] & 255) + ((this.Fp.FC[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Fp.Fz > 2) {
                            byte[] bArr2 = new byte[this.Fp.Fz - 2];
                            System.arraycopy(this.Fp.FC, 2, bArr2, 0, this.Fp.Fz - 2);
                            f fVar = new f();
                            fVar.p(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.Fp.Fv == 9) {
                    r(this.Fl.toByteArray());
                } else if (this.Fp.Fv == 10) {
                    s(this.Fl.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Fn) {
                    this.Fn = true;
                    this.Fo = this.Fp.Fv;
                    if (this.Fo == 1 && this.EE.kI()) {
                        this.Fr.reset();
                    }
                }
                if (this.Fo == 1 && this.EE.kI() && !this.Fr.p(this.Fl.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Fp.Fw) {
                    if (this.Fo == 1) {
                        if (this.EE.kI() && !this.Fr.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.EE.kD()) {
                            q(this.Fl.toByteArray());
                        } else {
                            S(new String(this.Fl.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Fo == 2) {
                        t(this.Fl.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Fn = false;
                    this.Fl.reset();
                }
            }
            this.Fp = null;
            this.Fq = 0;
            return this.Fk.position() > 0;
        } else {
            int position2 = this.Fk.position();
            if (this.Fp.Fz - this.Fq < position2) {
                position2 = this.Fp.Fz - this.Fq;
            }
            int position3 = this.Fk.position();
            if (this.Fp.Fz > 0) {
                bArr = new byte[position2];
                this.Fk.position(0);
                this.Fk.get(bArr, 0, position2);
            }
            this.Fk.position(position2);
            this.Fk.limit(position3);
            this.Fk.compact();
            if (bArr != null) {
                this.Fl.write(bArr);
            }
            this.Fq = position2 + this.Fq;
            return this.Fq >= this.Fp.Fz;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        v(new k.q(z, map));
    }

    protected void e(int i, String str) {
        v(new k.c(i, str));
    }

    protected void r(byte[] bArr) {
        v(new k.j(bArr));
    }

    protected void s(byte[] bArr) {
        v(new k.C0018k(bArr));
    }

    protected void S(String str) {
        v(new k.s(str));
    }

    protected void q(byte[] bArr) {
        v(new k.m(bArr));
    }

    protected void t(byte[] bArr) {
        this.Fu = System.currentTimeMillis();
        v(new k.a(bArr, this.Ft, this.Fu));
    }

    private boolean kM() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Fk.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Fk.get(position + 0) != 13 || this.Fk.get(position + 1) != 10 || this.Fk.get(position + 2) != 13 || this.Fk.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Fk.position();
                Map<String, String> map = null;
                if (this.Fk.get(0) == 72 && this.Fk.get(1) == 84 && this.Fk.get(2) == 84 && this.Fk.get(3) == 80) {
                    Pair<Integer, String> kN = kN();
                    if (((Integer) kN.first).intValue() >= 300) {
                        v(new k.p(((Integer) kN.first).intValue(), (String) kN.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Fk.position(0);
                        byte[] bArr = new byte[position];
                        this.Fk.get(bArr);
                        map = u(bArr);
                    }
                } else {
                    z = false;
                }
                this.Fk.position(position + 4);
                this.Fk.limit(position2);
                this.Fk.compact();
                if (this.Fs < this.Ew.kn() && map.size() == 0) {
                    this.Fs++;
                    return true;
                }
                this.Fs = 0;
                if (!z) {
                    z2 = this.Fk.position() > 0;
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
        String str = new String(bArr, "UTF-8");
        HashMap hashMap = new HashMap();
        String[] split = str.split(SystemInfoUtil.LINE_END);
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

    private Pair<Integer, String> kN() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Fk.position() && this.Fk.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Fk.position() && this.Fk.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Fk.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Fk.position() && this.Fk.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Fk.position(i6);
        this.Fk.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean kO() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return kL();
        }
        if (this.mState == 1) {
            return kM();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Ew.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Fk.clear();
            do {
                try {
                    int read = this.Ew.read(this.Fk);
                    if (read > 0) {
                        if (this.Ft <= 0) {
                            this.Ft = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Fm += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (kO());
                    } else if (read < 0) {
                        v(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.jD()) {
                        this.mStopped = true;
                        v(new k.d(new SocketException("not net")));
                        return;
                    }
                }
            } while (!this.mStopped);
        } catch (SocketException e2) {
            v(new k.d(e2));
        } catch (WebSocketException e3) {
            v(new k.l(e3));
        } catch (Exception e4) {
            v(new k.f(e4));
        } finally {
            this.mStopped = true;
        }
    }

    public void ku() {
        synchronized (m.class) {
            Fm = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Fm;
        }
        return j;
    }
}
