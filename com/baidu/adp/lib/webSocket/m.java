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
    private static long Fo = 0;
    private final l EG;
    private final e.a Ey;
    private final Handler Fl;
    private final ByteBuffer Fm;
    private final d Fn;
    private boolean Fp;
    private int Fq;
    private a Fr;
    private int Fs;
    private final f Ft;
    private int Fu;
    private long Fv;
    private long Fw;
    private int mState;
    private boolean mStopped;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public int FA;
        public int FB;
        public int FC;
        public byte[] FD;
        public byte[] FE;
        public int Fx;
        public boolean Fy;
        public int Fz;

        private a() {
        }
    }

    public m(Handler handler, e.a aVar, l lVar, String str) {
        super(str);
        this.mStopped = false;
        this.Fp = false;
        this.Ft = new f();
        this.Fu = 0;
        this.Fv = 0L;
        this.Fw = 0L;
        this.Fl = handler;
        this.Ey = aVar;
        this.EG = lVar;
        this.Fm = ByteBuffer.allocateDirect(lVar.kE() + 14);
        this.Fn = new d(lVar.kF());
        this.Fr = null;
        this.mState = 1;
    }

    protected void v(Object obj) {
        this.Fv = 0L;
        this.Fw = 0L;
        Message obtainMessage = this.Fl.obtainMessage();
        obtainMessage.obj = obj;
        this.Fl.sendMessage(obtainMessage);
    }

    private boolean kL() throws Exception {
        int i;
        String str;
        int i2;
        long j;
        byte[] bArr = null;
        if (this.Fr == null) {
            if (this.Fm.position() >= 2) {
                byte b = this.Fm.get(0);
                boolean z = (b & 128) != 0;
                int i3 = (b & 112) >> 4;
                int i4 = b & 15;
                byte b2 = this.Fm.get(1);
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
                    if (!this.Fp && i4 == 0) {
                        throw new WebSocketException("received continuation data frame outside fragmented message");
                    }
                    if (this.Fp && i4 != 0) {
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
                if (this.Fm.position() >= i2) {
                    if (i5 == 126) {
                        j = ((this.Fm.get(2) & 255) << 8) | (this.Fm.get(3) & 255);
                        if (j < 126) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else if (i5 == 127) {
                        if ((this.Fm.get(2) & 128) != 0) {
                            throw new WebSocketException("invalid data frame length (> 2^63)");
                        }
                        j = ((this.Fm.get(2) & 255) << 56) | ((this.Fm.get(3) & 255) << 48) | ((this.Fm.get(4) & 255) << 40) | ((this.Fm.get(5) & 255) << 32) | ((this.Fm.get(6) & 255) << 24) | ((this.Fm.get(7) & 255) << 16) | ((this.Fm.get(8) & 255) << 8) | (this.Fm.get(9) & 255);
                        if (j < 65536) {
                            throw new WebSocketException("invalid data frame length (not using minimal length encoding)");
                        }
                    } else {
                        j = i5;
                    }
                    this.Fr = new a();
                    this.Fr.Fx = i4;
                    this.Fr.Fy = z;
                    this.Fr.Fz = i3;
                    this.Fr.FB = (int) j;
                    this.Fr.FA = i2;
                    this.Fr.FC = this.Fr.FA + this.Fr.FB;
                    this.Fr.FD = null;
                    int position = this.Fm.position();
                    this.Fr.FE = new byte[this.Fr.FA];
                    this.Fm.position(0);
                    this.Fm.get(this.Fr.FE, 0, this.Fr.FA);
                    this.Fm.position(this.Fr.FA);
                    this.Fm.limit(position);
                    this.Fm.compact();
                    return this.Fr.FB == 0 || this.Fm.position() >= this.Fr.FB;
                }
                return false;
            }
            return false;
        } else if (this.Fs >= this.Fr.FB) {
            if (this.Fr.Fx > 7) {
                if (this.Fr.Fx == 8) {
                    if (this.Fr.FB < 2) {
                        i = 1005;
                        str = null;
                    } else {
                        i = (this.Fr.FE[1] & 255) + ((this.Fr.FE[0] & 255) * 256);
                        if (i < 1000 || ((i >= 1000 && i <= 2999 && i != 1000 && i != 1001 && i != 1002 && i != 1003 && i != 1007 && i != 1008 && i != 1009 && i != 1010 && i != 1011) || i >= 5000)) {
                            throw new WebSocketException("invalid close code " + i);
                        }
                        if (this.Fr.FB > 2) {
                            byte[] bArr2 = new byte[this.Fr.FB - 2];
                            System.arraycopy(this.Fr.FE, 2, bArr2, 0, this.Fr.FB - 2);
                            f fVar = new f();
                            fVar.q(bArr2);
                            if (!fVar.isValid()) {
                                throw new WebSocketException("invalid close reasons (not UTF-8)");
                            }
                            str = new String(bArr2, "UTF-8");
                        } else {
                            str = null;
                        }
                    }
                    e(i, str);
                } else if (this.Fr.Fx == 9) {
                    s(this.Fn.toByteArray());
                } else if (this.Fr.Fx == 10) {
                    t(this.Fn.toByteArray());
                } else {
                    throw new Exception("BdLogic error");
                }
            } else {
                if (!this.Fp) {
                    this.Fp = true;
                    this.Fq = this.Fr.Fx;
                    if (this.Fq == 1 && this.EG.kI()) {
                        this.Ft.reset();
                    }
                }
                if (this.Fq == 1 && this.EG.kI() && !this.Ft.q(this.Fn.toByteArray())) {
                    throw new WebSocketException("invalid UTF-8 in text message payload");
                }
                if (this.Fr.Fy) {
                    if (this.Fq == 1) {
                        if (this.EG.kI() && !this.Ft.isValid()) {
                            throw new WebSocketException("UTF-8 text message payload ended within Unicode code point");
                        }
                        if (this.EG.kD()) {
                            r(this.Fn.toByteArray());
                        } else {
                            S(new String(this.Fn.toByteArray(), "UTF-8"));
                        }
                    } else if (this.Fq == 2) {
                        u(this.Fn.toByteArray());
                    } else {
                        throw new Exception("BdLogic error");
                    }
                    this.Fp = false;
                    this.Fn.reset();
                }
            }
            this.Fr = null;
            this.Fs = 0;
            return this.Fm.position() > 0;
        } else {
            int position2 = this.Fm.position();
            if (this.Fr.FB - this.Fs < position2) {
                position2 = this.Fr.FB - this.Fs;
            }
            int position3 = this.Fm.position();
            if (this.Fr.FB > 0) {
                bArr = new byte[position2];
                this.Fm.position(0);
                this.Fm.get(bArr, 0, position2);
            }
            this.Fm.position(position2);
            this.Fm.limit(position3);
            this.Fm.compact();
            if (bArr != null) {
                this.Fn.write(bArr);
            }
            this.Fs = position2 + this.Fs;
            return this.Fs >= this.Fr.FB;
        }
    }

    protected void a(boolean z, Map<String, String> map) {
        v(new k.q(z, map));
    }

    protected void e(int i, String str) {
        v(new k.c(i, str));
    }

    protected void s(byte[] bArr) {
        v(new k.j(bArr));
    }

    protected void t(byte[] bArr) {
        v(new k.C0018k(bArr));
    }

    protected void S(String str) {
        v(new k.s(str));
    }

    protected void r(byte[] bArr) {
        v(new k.m(bArr));
    }

    protected void u(byte[] bArr) {
        this.Fw = System.currentTimeMillis();
        v(new k.a(bArr, this.Fv, this.Fw));
    }

    private boolean kM() throws UnsupportedEncodingException {
        boolean z;
        boolean z2;
        boolean z3 = false;
        int position = this.Fm.position() - 4;
        while (true) {
            if (position < 0) {
                break;
            } else if (this.Fm.get(position + 0) != 13 || this.Fm.get(position + 1) != 10 || this.Fm.get(position + 2) != 13 || this.Fm.get(position + 3) != 10) {
                position--;
            } else {
                int position2 = this.Fm.position();
                Map<String, String> map = null;
                if (this.Fm.get(0) == 72 && this.Fm.get(1) == 84 && this.Fm.get(2) == 84 && this.Fm.get(3) == 80) {
                    Pair<Integer, String> kN = kN();
                    if (((Integer) kN.first).intValue() >= 300) {
                        v(new k.p(((Integer) kN.first).intValue(), (String) kN.second));
                        z = true;
                    } else {
                        z = false;
                    }
                    if (position > 0) {
                        this.Fm.position(0);
                        byte[] bArr = new byte[position];
                        this.Fm.get(bArr);
                        map = v(bArr);
                    }
                } else {
                    z = false;
                }
                this.Fm.position(position + 4);
                this.Fm.limit(position2);
                this.Fm.compact();
                if (this.Fu < this.Ey.kn() && map.size() == 0) {
                    this.Fu++;
                    return true;
                }
                this.Fu = 0;
                if (!z) {
                    z2 = this.Fm.position() > 0;
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

    private Map<String, String> v(byte[] bArr) throws UnsupportedEncodingException {
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
        while (i < this.Fm.position() && this.Fm.get(i) != 32) {
            i++;
        }
        int i2 = i + 1;
        while (i2 < this.Fm.position() && this.Fm.get(i2) != 32) {
            i2++;
        }
        int i3 = i + 1;
        int i4 = 0;
        for (int i5 = 0; i3 + i5 < i2; i5++) {
            i4 = (i4 * 10) + (this.Fm.get(i3 + i5) - 48);
        }
        int i6 = i2 + 1;
        int i7 = i6;
        while (i7 < this.Fm.position() && this.Fm.get(i7) != 13) {
            i7++;
        }
        int i8 = i7 - i6;
        byte[] bArr = new byte[i8];
        this.Fm.position(i6);
        this.Fm.get(bArr, 0, i8);
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
            this.Ey.close();
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [764=5] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.Fm.clear();
            do {
                try {
                    int read = this.Ey.read(this.Fm);
                    if (read > 0) {
                        if (this.Fv <= 0) {
                            this.Fv = System.currentTimeMillis();
                        }
                        synchronized (m.class) {
                            Fo += read;
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
            Fo = 0L;
        }
    }

    public long getDownFlowSize() {
        long j;
        synchronized (m.class) {
            j = Fo;
        }
        return j;
    }
}
