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
    private static long Fl = 0;
    private final l ED;
    private final e.a Ev;
    private final Handler Fi;
    private final ByteBuffer Fj;
    private final d Fk;
    private boolean Fm;
    private int Fn;
    private a Fo;
    private int Fp;
    private final f Fq;
    private int Fr;
    private long Fs;
    private long Ft;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public byte[] FA;
        public byte[] FB;
        public int Fu;
        public boolean Fv;
        public int Fw;
        public int Fx;
        public int Fy;
        public int Fz;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Fm = false;
        this.Fq = new f();
        this.Fr = 0;
        this.Fs = 0L;
        this.Ft = 0L;
        this.Fi = handler;
        this.Ev = aVar;
        this.ED = lVar;
        this.Fj = ByteBuffer.allocateDirect(lVar.kG() + 14);
        this.Fk = new d(lVar.kH());
        this.Fo = null;
        this.mState = 1;
    }

    protected void v(Object obj) {
        this.Fs = 0L;
        this.Ft = 0L;
        Message obtainMessage = this.Fi.obtainMessage();
        obtainMessage.obj = obj;
        this.Fi.sendMessage(obtainMessage);
    }

    private boolean kN() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Fo == null) {
            if (this.Fj.position() >= 2) {
                byte b = this.Fj.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Fj.get(1);
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
                    if (!this.Fm && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Fm && i4 != 0) {
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
                if (this.Fj.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Fj.get(2) & 255) << 8) | (this.Fj.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Fj.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Fj.get(2) & 255) << 56) | ((this.Fj.get(3) & 255) << 48) | ((this.Fj.get(4) & 255) << 40) | ((this.Fj.get(5) & 255) << 32) | ((this.Fj.get(6) & 255) << 24) | ((this.Fj.get(7) & 255) << 16) | ((this.Fj.get(8) & 255) << 8) | (this.Fj.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Fo = new a();
                    this.Fo.Fu = i4;
                    this.Fo.Fv = z;
                    this.Fo.Fw = i3;
                    this.Fo.Fy = (int) j;
                    this.Fo.Fx = i2;
                    this.Fo.Fz = this.Fo.Fx + this.Fo.Fy;
                    this.Fo.FA = null;
                    int position = this.Fj.position();
                    this.Fo.FB = new byte[this.Fo.Fx];
                    this.Fj.position(0);
                    this.Fj.get(this.Fo.FB, 0, this.Fo.Fx);
                    this.Fj.position(this.Fo.Fx);
                    this.Fj.limit(position);
                    this.Fj.compact();
                    return this.Fo.Fy == 0 || this.Fj.position() >= this.Fo.Fy;
                }
                return false;
            }
            return false;
        } else if (this.Fp >= this.Fo.Fy) {
            if (this.Fo.Fu > 7) {
                if (this.Fo.Fu == 8) {
                    if (this.Fo.Fy < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Fo.FB[1] & 255) + ((this.Fo.FB[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Fo.Fy > 2) {
                            byte[] bArr2 = new byte[this.Fo.Fy - 2];
                            System.arraycopy(this.Fo.FB, 2, bArr2, 0, this.Fo.Fy - 2);
                            f fVar = new f();
                            fVar.o(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    f(i, str);
                } else if (this.Fo.Fu == 9) {
                    q(this.Fk.toByteArray());
                } else if (this.Fo.Fu == 10) {
                    r(this.Fk.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Fm) {
                    this.Fm = true;
                    this.Fn = this.Fo.Fu;
                    if (this.Fn == 1 && this.ED.kK()) {
                        this.Fq.reset();
                    }
                }
                if (this.Fn == 1 && this.ED.kK() && !this.Fq.o(this.Fk.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Fo.Fv) {
                    if (this.Fn == 1) {
                        if (this.ED.kK() && !this.Fq.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.ED.kF()) {
                            p(this.Fk.toByteArray());
                        } else {
                            S(new String(this.Fk.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Fn == 2) {
                        s(this.Fk.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Fm = false;
                    this.Fk.reset();
                }
            }
            this.Fo = null;
            this.Fp = 0;
            return this.Fj.position() > 0;
        } else {
            int position2 = this.Fj.position();
            if (this.Fo.Fy - this.Fp < position2) {
                position2 = this.Fo.Fy - this.Fp;
            }
            int position3 = this.Fj.position();
            if (this.Fo.Fy > 0) {
                bArr = new byte[position2];
                this.Fj.position(0);
                this.Fj.get(bArr, 0, position2);
            }
            this.Fj.position(position2);
            this.Fj.limit(position3);
            this.Fj.compact();
            if (bArr != null) {
                this.Fk.write(bArr);
            }
            this.Fp = position2 + this.Fp;
            return this.Fp >= this.Fo.Fy;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        v(new k.q(z, map));
    }

    protected void f(int i, String str) {
        v(new k.c(i, str));
    }

    protected void q(byte[] bArr) {
        v(new k.j(bArr));
    }

    protected void r(byte[] bArr) {
        v(new k.C0018k(bArr));
    }

    protected void S(String str) {
        v(new k.s(str));
    }

    protected void p(byte[] bArr) {
        v(new k.m(bArr));
    }

    protected void s(byte[] bArr) {
        this.Ft = System.currentTimeMillis();
        v(new k.a(bArr, this.Fs, this.Ft));
    }

    private boolean kO() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Fj.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Fj.get(position + 0) != 13 || this.Fj.get(position + 1) != 10 || this.Fj.get(position + 2) != 13 || this.Fj.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Fj.position();
                Map<String, String> map = null;
                if (this.Fj.get(0) == 72 && this.Fj.get(1) == 84 && this.Fj.get(2) == 84 && this.Fj.get(3) == 80) {
                    Pair<Integer, String> kP = kP();
                    if (((Integer) kP.first).intValue() >= 300) {
                        v(new k.p(((Integer) kP.first).intValue(), (String) kP.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Fj.position(0);
                        byte[] bArr = new byte[position];
                        this.Fj.get(bArr);
                        map = t(bArr);
                    }
                } else {
                    z = false;
                }
                this.Fj.position(position + 4);
                this.Fj.limit(position2);
                this.Fj.compact();
                if (this.Fr < this.Ev.ko() && map.size() == 0) {
                    this.Fr++;
                    return true;
                }
                this.Fr = 0;
                if (!z) {
                    z2 = this.Fj.position() > 0;
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

    private Pair<Integer, String> kP() throws UnsupportedEncodingException {
        int i = 4;
        while (i < this.Fj.position() && this.Fj.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Fj.position() && this.Fj.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Fj.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Fj.position() && this.Fj.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Fj.position(i6);
        this.Fj.get(bArr, 0, i8);
        return new Pair<>(Integer.valueOf(i4), new String(bArr, "UTF-8"));
    }

    private boolean kQ() throws Exception {
        if (this.mState == 3 || this.mState == 2) {
            return kN();
        }
        if (this.mState == 1) {
            return kO();
        }
        if (this.mState == 0) {
        }
        return false;
    }

    public void quit() {
        this.mStopped = true;
        try {
            this.Ev.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Fj.clear();
            do {
                try {
                    int read = this.Ev.read(this.Fj);
                    if (read > 0) {
                        if (this.Fs <= 0) {
                            this.Fs = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Fl += read;
                        }
                    }
                    if (read > 0) {
                        do {
                        } while (kQ());
                    } else if (read < 0) {
                        v(new k.d(new SocketException("len < 0")));
                        this.mStopped = true;
                    }
                } catch (SocketTimeoutException e) {
                    if (!com.baidu.adp.lib.util.j.jE()) {
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

    public void kw() {
        synchronized (m.class) {
            Fl = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Fl;
        }
        return j;
    }
}
